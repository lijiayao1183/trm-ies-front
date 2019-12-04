package com.trm.service.register;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trm.constants.SystemConstants;
import com.trm.dao.common.CommonDao;
import com.trm.dao.member.MemberDao;
import com.trm.dao.member.UnitDao;
import com.trm.dao.register.RegisterDao;
import com.trm.entity.TrmDepart;
import com.trm.entity.TrmMember;
import com.trm.entity.TrmMemberTemp;
import com.trm.entity.TrmUnit;
import com.trm.model.common.CommonResponse;
import com.trm.model.member.MemberTemp;
import com.trm.model.register.CreditIdKeys;
import com.trm.model.register.Register;
import com.trm.model.register.UniqueKeys;
import com.trm.util.BeanUtils;

/**
 * @description 用户注册
 * @author zhaosimiao 
 * @date 2017-9-28 10:12:16
 */
@Service("registerService")
@Transactional(rollbackFor = Exception.class)
public class RegisterServiceImpl implements RegisterService {

    public static Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);

    @Autowired
    private CommonDao commonDao;

    @Autowired
    private RegisterDao registerDao;

    @Autowired
    private UnitDao unitDao;
    
    @Autowired
    private MemberDao memberDao;

    @Override
    public CommonResponse register(Register register)throws Exception {
    	
		CommonResponse response = new CommonResponse();

		// 信息非空校验（注解实现）

		String username = register.getUsername();
		String phone = register.getPhone();
		String email = register.getEmail();
		String numberId = register.getNumberId();
    	
    	// 密码加密存储
    	// String password = Encryption.encrypt(register.getPassword());
    	// register.setPassword(password);
		
		// 判断信息是否正在审核  add by zhaosimiao 2018-8-1 10:02:31
		String creditId = register.getCreditId();
		TrmMember inReviewUser = memberDao.getInReviewUser(creditId);
		if(inReviewUser != null) {
    		response.setCodeAndMsg("EE", "该单位的注册信息正在审核中，请耐心等待！");
    		return response;
		}
    	
		response = isUniqueAccount(username, phone, email, numberId);
		if ("R".equals(response.getCode())) {
			TrmMember entity = new TrmMember();
			TrmDepart td = new TrmDepart();
			TrmUnit tu = new TrmUnit();
			BeanUtils.copyProperties(register, entity);
			BeanUtils.copyProperties(register, td);
			BeanUtils.copyProperties(register, tu);
			entity.setUserType("2");
    		
    		// 设备提供类用户需要审核
    		if("2".equals(entity.getUserType())) {
    			// (1) audStatus="R0"待审核；(2) audStatus="R1"通过；(3) audStatus="R2"不通过。
    			entity.setAudStatus("R0");
    		}
    		// 设置默认头像
			entity.setHeadPortrait("/upload/images/headportrait.jpg");
			entity.setIsActive(SystemConstants.FLAG_Y);
			tu.setIsActive(SystemConstants.FLAG_Y);

			if (unitDao.checkCreditId(tu.getCreditId()) == null) {
				// 保存单位信息
				commonDao.createEntity(tu);
				td.setUnitId(tu.getId());
				td.setIsActive(SystemConstants.FLAG_Y);
				entity.setUnitId(tu.getId());
				// 保存部门信息
				commonDao.createEntity(td);
				entity.setDepartId(td.getId());
				// 保存用户信息
				commonDao.createEntity(entity);
				entity.setMasterId(entity.getId());
				
				response.setCodeAndMsg("0000", "注册成功！");
			}
		}
    	return response;
    }
    
    /**
     * 注册信息唯一性
     * @param phone
     * @param email
     * @param numberId
     * @return
     */
    private CommonResponse isUniqueAccount(String username, String phone, String email, String numberId){
    	
    	CommonResponse response = new CommonResponse();
    	String code = "R";
    	String msg = "注册信息唯一可用！";
    	
    	if(!checkUsername(username)) {
    		code = "E0";
    		msg = "该用户名已被使用，不能重复注册！";
    		response.setCodeAndMsg(code, msg);
    		return response;
    	}
    	
    	else if(!checkPhone(phone)) {
    		code = "E1";
    		msg = "该手机号码已被使用，不能重复注册！";
    		response.setCodeAndMsg(code, msg);
    		return response;
    	}
    	
    	else if(!checkEmail(email)) {
    		code = "E2";
    		msg = "该邮箱已被使用，不能重复注册！";
    		response.setCodeAndMsg(code, msg);
    		return response;
    	}
    	
    	else if(!checkNumberId(numberId)) {
    		code = "E3";
    		msg = "该身份证号已被使用，不能重复注册！";
    		response.setCodeAndMsg(code, msg);
    		return response;
    	}
    	
    	response.setCodeAndMsg(code, msg);
        return response;
    }
    
    /**
     * 设备检索/提供用户用户名唯一性
     * @param phone
     * @return
     */
    private boolean checkUsername(String username) {
    	TrmMember entity = registerDao.checkUsername(username);
    	if(entity != null) 
    		return ("R2".equals(entity.getAudStatus())) ? true : false;
    	else
    		return true;
    }
    
    /**
     * 设备检索/提供用户手机号唯一性
     * @param phone
     * @return
     */
    private boolean checkPhone(String phone) {
    	TrmMember entity = registerDao.checkPhone(phone);
    	if(entity != null) 
    		return ("R2".equals(entity.getAudStatus())) ? true : false;
    	else
    		return true;
    }
    
    /**
     * 设备检索/提供用户邮箱唯一性
     * @param email
     * @return
     */
    private boolean checkEmail(String email) {
    	TrmMember entity = registerDao.checkEmail(email);
    	if(entity != null) 
    		return ("R2".equals(entity.getAudStatus())) ? true : false;
    	else
    		return true;
    }
    
    /**
     * 设备提供用户身份证号唯一性
     * @param numberId
     * @return
     */
    private boolean checkNumberId(String numberId) {
    	TrmMember entity = registerDao.checkNumberId(numberId);
    	if(entity != null) 
    		return ("R2".equals(entity.getAudStatus())) ? true : false;
    	else
    		return true;
    }

	@Override
	public CommonResponse checkUniqueKeys(UniqueKeys keys) {
		
		CommonResponse response = new CommonResponse();
		String code = "";
		String msg = "";
		String phone = keys.getPhone();
		String email = keys.getEmail();
		String numberId = keys.getNumberId();
		
		if(StringUtils.isEmpty(phone) && StringUtils.isEmpty(email) && StringUtils.isEmpty(numberId)) {
			code = "E0";
    		msg = "验证参数为空！";
    		response.setCodeAndMsg(code, msg);
    		return response;
		}
		else { 
			if(StringUtils.isNotEmpty(phone) && !checkPhone(phone)) {
				code = "E1";
	    		msg = "该手机号码已被其他用户使用！";
	    		response.setCodeAndMsg(code, msg);
	    		return response;
			}
			if(StringUtils.isNotEmpty(email) && !checkEmail(email)) {
				code = "E2";
	    		msg = "该邮箱已被其他用户使用！";
	    		response.setCodeAndMsg(code, msg);
	    		return response;
			}
			if(StringUtils.isNotEmpty(numberId) && !checkNumberId(numberId)) {
				code = "E3";
	    		msg = "该身份证号已被其他用户使用！";
	    		response.setCodeAndMsg(code, msg);
	    		return response;
			}
		}
		code = "0000";
		msg = "唯一可用！";
		response.setCodeAndMsg(code, msg);
		
		return response;
		
	}
	
	@Override
	public CreditIdKeys checkCreditIdKeys(CreditIdKeys keys) {

		String code = "";
		String creditId = keys.getCreditId();
		CreditIdKeys entity = unitDao.checkCreditId(creditId);
		CreditIdKeys cd = new CreditIdKeys();

		if (entity == null) {
			code = "E2";// 该组织机构代码没有使用
			cd.setCode(code);
			return cd;
		} else {
			code = "E1";// 该组织机构代码已经注册
			entity.setCode(code);
		}
		
		return entity;
	}

	@Override
	public MemberTemp getMemberTemp(String creditId) {
		TrmMemberTemp entity = registerDao.getMemberTemp(creditId);
		MemberTemp temp = new MemberTemp();
		BeanUtils.copyProperties(entity, temp);
		return temp;
	}

	@Override
	public CommonResponse saveMemberTemp(MemberTemp temp) throws Exception {
		CommonResponse response = new CommonResponse();
		String creditId = temp.getCreditId();
		if(StringUtils.isEmpty(creditId)) {
			response.setCodeAndMsg("9999", "用户注册信息暂存失败，社会信用统一代码不能为空！");
			return response;
		}
		TrmMemberTemp entity = new TrmMemberTemp();
		BeanUtils.copyProperties(temp, entity);
		entity.setIsActive("Y");
		boolean flag = commonDao.createEntity(entity);
		if(flag) {
			response.setCodeAndMsg("0000", "用户注册信息暂存成功！");
		}
		else {
			response.setCodeAndMsg("9999", "用户注册信息暂存失败！");
		}
		return response;
	}
	
}
