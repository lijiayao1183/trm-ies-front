package com.trm.service.login;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trm.dao.login.PwdDao;
import com.trm.dao.login.UuidDao;
import com.trm.entity.TrmMember;
import com.trm.entity.TrmUuid;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonResponse;
import com.trm.model.login.PwdReset;
import com.trm.model.login.Uuid;
import com.trm.util.BeanUtils;
import com.trm.util.Datetime;
import com.trm.util.mail.MailUtil;

/**
 * @description 找回密码
 * @author zhaosimiao 
 * @date 2017-10-9 10:12:16
 */
@Service("pwdService")
@Transactional(rollbackFor = Exception.class)
public class PwdServiceImpl implements PwdService {

    public static Logger logger = LoggerFactory.getLogger(PwdServiceImpl.class);

    @Autowired
    private PwdDao pwdDao;
    
    @Autowired
    private UuidDao uuidDao;
    
    @Resource
    private MailUtil mailUtil;

	@Override
	public CommonResponse sendMail(PwdReset prt, String uuid) throws Exception {
		CommonResponse response = new CommonResponse();
		String email = prt.getEmail();
		
		if(StringUtils.isEmpty(email)) {
			response.setCodeAndMsg("E0", "邮箱不能为空！");
		}
		else {
			TrmMember tm = pwdDao.verifyEmail(email);
			if(tm == null) {
				response.setCodeAndMsg("9999", "邮箱未注册，发送失败！");
			}
			else {
				// 将uuid更新至数据库
				
				// 无记录则做插入操作
				TrmUuid tu = uuidDao.checkUsername(tm.getUsername());
				TrmUuid newTu = new TrmUuid();
				newTu.setUsername(tm.getUsername());
				newTu.setCode(uuid);
				newTu.setSendtime(Datetime.getLocalDate());
				if(tu == null) {
					newTu.setCount(1);
					uuidDao.insertUuid(newTu);
					logger.info("uuid insert" + newTu.toString());
				}
				//　有记录则做更新操作
				else {
					newTu.setCount(tu.getCount() + 1);
					Uuid oldTu = new Uuid();
					BeanUtils.copyProperties(newTu, oldTu);
					uuidDao.updateUuid(oldTu);
					logger.info("uuid update" + oldTu.toString());
				}
				
				mailUtil.send(tm.getUsername(), uuid, prt.getEmail());
				response.setCodeAndMsg("0000", "邮件已发送！");
			}
		}
		return response;
	}
    
	@Override
	public CommonResponse verifyQuestion(PwdReset prt) throws BusinessException {
		CommonResponse response = new CommonResponse();
		
		String username = prt.getUsername();
		String question = prt.getQuestion();
		String answer = prt.getAnswer();
		
		if(StringUtils.isEmpty(username) || StringUtils.isEmpty(question) || StringUtils.isEmpty(answer)) {
			response.setCodeAndMsg("E0", "用户名、安全问题或答案均不能为空！");
		}
		else {
			TrmMember tm = pwdDao.verifyQuestion(username, question, answer);
			if(tm == null) {
				response.setCodeAndMsg("9999", "用户名不存在，或安全问题或答案验证未通过！");
			}
			else {
				response.setCodeAndMsg("0000", "安全问题或答案验证通过！");
			}
		}
		return response;
	}

	@Override
	public CommonResponse changePwd(PwdReset prt) throws BusinessException {
		CommonResponse response = new CommonResponse();
		String username = prt.getUsername();
		String oldPwd = prt.getOldPwd();
		String newPwd = prt.getNewPwd();
		
		if(StringUtils.isEmpty(username) || StringUtils.isEmpty(oldPwd) || StringUtils.isEmpty(newPwd)) {
			response.setCodeAndMsg("E0", "用户名、密码均不能为空！");
		}
		else {
			// 用户名和加密后的密码 查询
			TrmMember tm = pwdDao.checkPwd(username, oldPwd);
			if(tm == null) {
				response.setCodeAndMsg("E1", "旧密码错误！");
			}
			else {
				// 修改新密码
				boolean flag = pwdDao.updatePwd(username, newPwd);
				if(flag) {
					response.setCodeAndMsg("0000", "密码修改成功！");
				}
				else {
					response.setCodeAndMsg("9999", "密码修改失败！");
				}
			}
		}
		
		// 修改密码后，清空session操作
		SecurityContext context = SecurityContextHolder.getContext();
		context.setAuthentication(null);
		SecurityContextHolder.clearContext();
		
		return response;
	}

	@Override
	public CommonResponse retrievePwd(PwdReset prt) throws BusinessException {
		CommonResponse response = new CommonResponse();
		String isEorQ = prt.getIsEorQ();
		String username = prt.getUsername();
		String newPwd = prt.getNewPwd();
		String code = prt.getCode();
		
		if(StringUtils.isEmpty(username) || StringUtils.isEmpty(newPwd)) {
			response.setCodeAndMsg("E0", "用户名、密码均不能为空！");
		}
		else {
			boolean flag = false;
			// 邮件找回
			if("E".equals(isEorQ) && StringUtils.isNotEmpty(code)) {
				TrmUuid temp = uuidDao.getUuid(code);
				if(temp == null) {
					response.setCodeAndMsg("E1", "CODE验证失败！");
					return response;
				}
				else{
					long tf = Datetime.timeDifference(temp.getSendtime().getTime(), Datetime.getLocalDate().getTime());
					// 30分钟内可以无限次修改
					if(temp.getCode().equals(code) && tf <= 1000*60*30)
						flag = pwdDao.updatePwd(username, newPwd);
					else {
						response.setCodeAndMsg("E2", "CODE验证超时！");
						return response;
					}
				}
			}
			// 问题找回
			else if("Q".equals(isEorQ)) {
				flag = pwdDao.updatePwd(username, newPwd);
			}
			
			if(flag) {
				response.setCodeAndMsg("0000", "密码修改成功！");
			}
			else {
				response.setCodeAndMsg("9999", "密码修改失败！");
			}
		}
		return response;
	}

}
