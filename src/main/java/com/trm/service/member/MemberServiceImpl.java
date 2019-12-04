package com.trm.service.member;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.common.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trm.constants.SystemConstants;
import com.trm.dao.common.CommonDao;
import com.trm.dao.member.MemberDao;
import com.trm.dao.member.UnitDao;
import com.trm.dao.register.RegisterDao;
import com.trm.entity.TrmDepart;
import com.trm.entity.TrmMember;
import com.trm.entity.TrmUnit;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonResponse;
import com.trm.model.member.MemberDetail;
import com.trm.model.member.MyCase;
import com.trm.model.member.SetDepartsList;
import com.trm.model.member.SubMemListDetail;
import com.trm.model.member.SubMemListRequest;
import com.trm.model.member.SubMemListResponse;
import com.trm.model.member.SubMemberDetail;
import com.trm.util.BeanUtils;
import com.trm.util.SessionUtil;

/**
 * 个人中心-基本信息
 * @author zhaosimiao
 * @Date 2017-10-10 13:36:36
 */
@Service("memberService")
@Transactional(rollbackFor = Exception.class)
public class MemberServiceImpl implements MemberService {

    public static Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private CommonDao commonDao;
    
    @Autowired
    private RegisterDao registerDao;
    
    @Autowired
    private UnitDao unitDao;

	@Override
	public SubMemListResponse<SubMemListDetail> getUsersList(SubMemListRequest request) throws BusinessException {
		
		Integer userId = SessionUtil.getUserIdFromSession();
		if(userId == null) {
			BusinessException bs = new BusinessException();
            bs.setExceptionMsg("用户未登录！");
            throw bs;
		}
		
		SubMemListResponse<SubMemListDetail> response = memberDao.getUsersList(request);
		if (response.getList().size() < 1) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("子用户列表查询为空！");
            throw bs;
        }
		else {
			// 去掉管理员用户
			List<SubMemListDetail> list = response.getList();
			List<SubMemListDetail> tempList = new ArrayList<SubMemListDetail>();
			for(SubMemListDetail obj : list) {
				if((obj.getId()).equals(userId)) {
					tempList.add(obj);
				}
			}
			list.removeAll(tempList);
			response.setList(list);
		}
        return response;
	}
    
	@Override
    public SubMemberDetail getSubMemberById(Integer id){
		SubMemberDetail detail = memberDao.getSubMemberById(id);
        return detail;
    }
	
    @Override
    public MemberDetail getUserinfoById(Integer userId){
        TrmMember entity = memberDao.getUserinfoById(userId);
        MemberDetail detail = new MemberDetail();
        BeanUtils.copyProperties(entity, detail);
        return detail;
    }
    
    @Override
    public CommonResponse changeUserinfo(MemberDetail detail) throws Exception{
    	CommonResponse response = new CommonResponse();
        TrmMember entity = memberDao.getUserinfo(detail.getId());
        if(entity == null) {
        	response.setCodeAndMsg("E0", "用户不存在！");
        }
        else {
        	// 唯一性校验
        	/*UniqueKeys keys = new UniqueKeys();
            keys.setPhone(detail.getPhone());
            keys.setEmail(detail.getEmail());
            keys.setNumberId(detail.getNumberId());
            response = registerService.checkUniqueKeys(keys);*/
            
            /*if("0000".equals(response.getCode())) {*/
        	// BeanUtils.copyProperties(detail, entity);
        	// 可修改的信息 8个
        	if(StringUtils.isNotEmpty(detail.getHeadPortrait())){
        		entity.setHeadPortrait(detail.getHeadPortrait());
        		// 更新session中的头像信息
        		SessionUtil.setHeadPortraitFromSession(detail.getHeadPortrait());
        	}
        	if(StringUtils.isNotEmpty(detail.getPhone()))
        		entity.setPhone(detail.getPhone());
        	if(StringUtils.isNotEmpty(detail.getEmail()))
        		entity.setEmail(detail.getEmail());
        	if(StringUtils.isNotEmpty(detail.getProblem()))
        		entity.setProblem(detail.getProblem());
        	if(StringUtils.isNotEmpty(detail.getAnswer()))
        		entity.setAnswer(detail.getAnswer());
        	if(StringUtils.isNotEmpty(detail.getLinkPerson()))
        		entity.setLinkPerson(detail.getLinkPerson());
        	if(StringUtils.isNotEmpty(detail.getDepartment()))
        		entity.setDepartment(detail.getDepartment());
        	if(StringUtils.isNotEmpty(detail.getNumberId()))
        		entity.setNumberId(detail.getNumberId());
        	
            boolean flag = commonDao.modifyEntity(entity);
            if(flag) {
            	response.setCodeAndMsg("0000", "个人中心-基本信息修改成功！");
            }
            else {
            	response.setCodeAndMsg("9999", "个人中心-基本信息修改失败！");
            }
        }
        
        /*}*/
        return response;
    }

	@Override
	public List<MyCase> getMyCases(Integer userId) {
		List<MyCase> myCases = memberDao.getMyCases(userId);
		return myCases;
	}

	@Override
	public List<MyCase> getCases() {
		List<MyCase> myCases = memberDao.getCases();
		return myCases;
	}

	@Override
	public CommonResponse createSubMember(SubMemberDetail detail) throws Exception {
		
		// 管理用户id
		Integer userId = SessionUtil.getUserIdFromSession();
		detail.setMasterId(userId);
		
		TrmMember masterEntity = memberDao.getUserinfo(userId);
		// 单位id
		Integer unitId = masterEntity.getUnitId();
		detail.setUnitId(unitId);
		TrmUnit unitEntity = unitDao.getUnitById(unitId);
		
		CommonResponse response = new CommonResponse();
		
		String username = detail.getUsername();
    	String phone = detail.getPhone();
    	String email = detail.getEmail();
    	response = isUniqueAccount(username, phone, email);
    	
    	String department = detail.getDepartment();
    	
    	if("R".equals(response.getCode())) {
			TrmMember entity = new TrmMember();
			// 1.将创建用户信息复制到实体中
			BeanUtils.copyProperties(detail, entity);
			// 2.将单位信息复制到实体中
			BeanUtils.copyProperties(unitEntity, entity);
			// 3.部门不存在时，同时新增部门
			boolean isDepartExist = false;
			List<SetDepartsList> departList = unitDao.getDepartsList(unitId);
			for(SetDepartsList depart : departList) {
				if(depart.getDepartment().equals(department)) {
					isDepartExist = true;
					// 设置部门id
					entity.setDepartId(depart.getId());
					break;
				}
			}
			// 设置默认头像
			entity.setHeadPortrait("/upload/images/headportrait.jpg");
			// 子用户密码前台不传，后台设置默认，abc123
			entity.setPassword("E99A18C428CB38D5F260853678922E03");
			// 为了符合原来的逻辑，实体中设置以下常量
			entity.setAudStatus("R1");
			entity.setUserType("1");
			
			boolean createFlag = false;
			if(!isDepartExist) {
				// 创建用户
				createFlag = commonDao.createEntity(entity);
				// 创建部门
				TrmDepart departEntity = new TrmDepart();
				departEntity.setUnitId(unitId);
				departEntity.setDepartment(department);
				departEntity.setIsActive("Y");
				createFlag = commonDao.createEntity(departEntity);
				
				entity.setDepartId(departEntity.getId());
			}
			else {
				// 创建用户
				createFlag = commonDao.createEntity(entity);
			}
			
			if(createFlag) {
				response.setCodeAndMsg("0000", "用户创建成功！");
			}
			else {
				response.setCodeAndMsg("9999", "用户创建失败！");
			}
			
    	}
    	
		return response;
	}
	
	private CommonResponse isUniqueAccount(String username, String phone, String email){
    	
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

	@Override
	public CommonResponse modifySubMember(SubMemberDetail detail) throws Exception {
		CommonResponse response = new CommonResponse();
		
		Integer id = detail.getId();
		SubMemberDetail subMember = memberDao.getSubMemberById(id);
		
		if (!subMember.getPhone().equals(detail.getPhone()) && !checkPhone(detail.getPhone())) {
			response.setCodeAndMsg("E1", "该手机号码已被使用，不能重复注册！");
		} else if (!subMember.getEmail().equals(detail.getEmail()) && !checkEmail(detail.getPhone())) {
			response.setCodeAndMsg("E2", "该邮箱已被使用，不能重复注册！");
		} else {
			boolean updateFlag = memberDao.updateSubMember(detail);
			if (updateFlag) {
				response.setCodeAndMsg("0000", "子用户修改成功！");
			} else {
				response.setCodeAndMsg("9999", "子用户修改失败！");
			}
		}
        return response;
	}

	@Override
	public CommonResponse deleteSubMember(String id) throws Exception {
		boolean deleteFlag = false;
		CommonResponse response = new CommonResponse();
		if(StringHelper.isNotEmpty(id)){
			String[] multiKeys = StringUtils.split(id, SystemConstants.SYSTEM_COMMA);
			for (String c : multiKeys) {
				deleteFlag = memberDao.deletePwd(Integer.valueOf(c));
				
				Integer userId = SessionUtil.getUserIdFromSession();
				if(userId.intValue()==Integer.valueOf(c).intValue()) {
					// 清空session
					SecurityContext context = SecurityContextHolder.getContext();
					context.setAuthentication(null);
					SecurityContextHolder.clearContext();
				}
			}
		}
		
		if(deleteFlag) {
			response.setCodeAndMsg("0000", "子用户冻结成功！");
		}
		else {
			response.setCodeAndMsg("9999", "子用户冻结失败！");
		}
		return response;
	}

	@Override
	public CommonResponse resetPwd(Integer id) {
		CommonResponse response = new CommonResponse();
		boolean resetFlag = memberDao.resetPwd(id);
		if(resetFlag) {
			response.setCodeAndMsg("0000", "子用户密码已重置！");
		}
		else {
			response.setCodeAndMsg("9999", "子用户密码重置失败！");
		}
		return response;
	}
	
	@Override
	public boolean checkUser(String username) {
		boolean user = false;
		if (!checkUsername(username)) {
			user = true;
		}
		return user;
	}

}
