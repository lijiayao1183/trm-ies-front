package com.trm.service.login;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trm.dao.login.LoginDao;
import com.trm.entity.TrmLoginHistory;
import com.trm.entity.TrmMember;
import com.trm.entity.exception.BusinessException;
import com.trm.model.login.Login;
import com.trm.model.login.LoginResponse;
import com.trm.model.session.SessionBean;
import com.trm.model.session.UserSession;
import com.trm.util.BeanUtils;
import com.trm.util.SessionUtil;

/**
 * @description 用户登录
 * @author zhaosimiao 
 * @date 2017-9-28 10:12:16
 */
@Service("loginService")
@Transactional(rollbackFor = Exception.class)
public class LoginServiceImpl implements LoginService {

    public static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private LoginDao loginDao;

    @Override
    public LoginResponse login(Login login, HttpServletRequest request, HttpServletResponse response) throws BusinessException {
    	
    	LoginResponse loginReturn = new LoginResponse();
		
		logger.info("登录login，入参：" + login.toString());
		String username = login.getUsername();
		String password = login.getPassword();
		
		// modify by zhaosimiao 2017-12-5 15:23:48
		List<TrmMember> checkPwdList = loginDao.getUsers(username);
		if(checkPwdList.size() >= 1 && StringUtils.isEmpty(checkPwdList.get(0).getPassword())) {
			loginReturn.setCodeAndMsg("9999", "该用户名已被冻结，请联系单位管理员！");
			return loginReturn;
		}
		
		// 1. 查询登录名和密码进行验证（先对密码加密，再查询）
		List<TrmMember> tmList = loginDao.checkLoginInfo(username, password);
		// 2. 验证不成功
		if(tmList == null || tmList.size() < 1) {
			loginReturn.setCodeAndMsg("9999", "用户名或密码错误，请核实后重新登录！");
		}
		// 3. 验证成功，查询用户详细信息
		else {
			// 设备提供类用户需要审核，待审核状态时，登录提示：该账号正在审核中；审核不通过状态时，登录提示：审核意见。
			// (1) audStatus="R0"待审核；
			// (2) audStatus="R1"通过；
			// (3) audStatus="R2"不通过。
			// 特殊情况处理
			List<TrmMember> sList = loginDao.getUsers(username);
			// 取最新一条用户信息
			TrmMember member = sList.get(0);
			if(member.getPassword().equals(password)) {
				// 取用户审核状态
				String audStatus = member.getAudStatus();
				if("R0".equals(audStatus)) {
					loginReturn.setCodeAndMsg("R0", "该账号正在审核中，请耐心等待。");
					return loginReturn;
				}
				else if("R2".equals(audStatus)) {
					loginReturn.setCodeAndMsg("R2", member.getAudOpinion());
					return loginReturn;
				}
				
				// 将用户信息放入session中
				List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
				authList.add(new SimpleGrantedAuthority("ROLE_MEMBER"));
				SessionBean sessionBean = new SessionBean();
				BeanUtils.copyProperties(member, sessionBean);
				UserSession user = new UserSession(username, "", "", true, true, true, true, authList);
				user.setSession(sessionBean);
				SessionUtil.memberUpdateSession(user, request);
				
				// 返回用户名和头像
				loginReturn.setUsername(username);
				loginReturn.setHeadPortrait(member.getHeadPortrait());
				loginReturn.setUserType(member.getUserType());
				loginReturn.setUnitId(member.getUnitId());
				loginReturn.setCodeAndMsg("0000", "登录成功！");
				logger.info("登录成功！");
				
				// 记录登录历史
				TrmLoginHistory tlh = new TrmLoginHistory();
				tlh.setUsername(username);
				tlh.setLoginTime(new Date());
				loginDao.loginHistory(tlh);
				
				// 更新loginDate为当前时间
				loginDao.loginDate(member.getId());
			}
			else {
				loginReturn.setCodeAndMsg("9999", "密码错误，请核实后重新登录！");
			}
		}
		return loginReturn;
	}
    
}
