package com.trm.service.require;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.common.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trm.constants.SystemConstants;
import com.trm.dao.common.CommonDao;
import com.trm.dao.common.SysDataDao;
import com.trm.dao.member.MemberDao;
import com.trm.dao.require.RequireDao;
import com.trm.entity.TrmMember;
import com.trm.entity.TrmRequire;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.common.CommonResponse;
import com.trm.model.common.PolicyComeRequest;
import com.trm.model.common.SysDataRequest;
import com.trm.model.common.SysDataSimDetail;
import com.trm.model.member.EquipMember;
import com.trm.model.require.RequireAudit;
import com.trm.model.require.RequireDetail;
import com.trm.model.require.RequireListDetail;
import com.trm.model.require.RequireMyListDetail;
import com.trm.model.require.RequireRequest;
import com.trm.model.require.RequireSimDetail;
import com.trm.util.BeanUtils;
import com.trm.util.SessionUtil;

/**
 * 军民融合需求
 * @author zhaosimiao 2017-11-14 13:54:46
 */
@Service("requireService")
@Transactional(rollbackFor = Exception.class)
public class RequireServiceImpl implements RequireService {

    public static Logger logger = LoggerFactory.getLogger(RequireServiceImpl.class);
    
    @Autowired
    private RequireDao requireDao;

    @Autowired
    private SysDataDao sysDataDao;
    
    @Autowired
    private CommonDao commonDao;
    
    @Autowired
    private MemberDao memberDao;
    
    @Override
	public CommonListResponse<RequireSimDetail> homeRequires(RequireRequest request) throws BusinessException {
    	CommonListResponse<RequireSimDetail> response = requireDao.homeRequires(request);
    	if (response.getList().size() < 1) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("军民融合需求列表查询为空！");
            throw bs;
        }
    	
    	PolicyComeRequest eq = new PolicyComeRequest();
        for(RequireSimDetail obj : response.getList()){
            String serviceRange = obj.getServiceRange();
            if(StringHelper.isNotEmpty(serviceRange)){
                eq.setCode("SR");
                CommonListResponse<SysDataSimDetail> slit = sysDataDao.findAll(eq);
                String[] multiKeys = StringUtils.split(serviceRange, SystemConstants.SYSTEM_COMMA);
                for (String c : multiKeys) {
                    for(SysDataSimDetail ob : slit.getList()){
                        if(c.equals(ob.getCode())){
                            serviceRange = serviceRange.replace(c, ob.getName());
                        }
                    }
                }
                obj.setServiceRange(serviceRange.replace(SystemConstants.SYSTEM_COMMA, SystemConstants.SYSTEM_SEPARATOR));
            }
        }
    	return response;
	}
    
	@Override
	public CommonListResponse<RequireListDetail> findRequires(RequireRequest request) throws BusinessException {
		CommonListResponse<RequireListDetail> response = new CommonListResponse<RequireListDetail>();
		// 转换查询参数
		String searchKey = request.getSearchKey();
		SysDataRequest sysData = new SysDataRequest();
		
		sysData.setCode("DF");
		CommonListResponse<SysDataSimDetail> dfList = sysDataDao.findAll(sysData);
		for(SysDataSimDetail sds : dfList.getList()) {
			if(StringUtils.isNotEmpty(searchKey) && sds.getName().contains(searchKey)) {
				searchKey = sds.getCode();
				request.setSearchKey(searchKey);
				response = requireDao.findRequires(request);
				if (response.getList().size() < 1) {
		            BusinessException bs = new BusinessException();
		            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
		            bs.setExceptionMsg("军民融合需求列表查询为空！");
		            throw bs;
		        }
			}
		}
		
		sysData.setCode("SR");
		CommonListResponse<SysDataSimDetail> srList = sysDataDao.findAll(sysData);
		
		for(SysDataSimDetail sds : srList.getList()) {
			if(StringUtils.isNotEmpty(searchKey) && sds.getName().contains(searchKey)) {
				searchKey = sds.getCode();
				request.setSearchKey(searchKey);
				response = requireDao.findRequires(request);
				if (response.getList().size() < 1) {
		            BusinessException bs = new BusinessException();
		            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
		            bs.setExceptionMsg("军民融合需求列表查询为空！");
		            throw bs;
		        }
			}
		}
		
		response = requireDao.findRequires(request);
		if (response.getList().size() < 1) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("军民融合需求列表查询为空！");
            throw bs;
        }
		return response;
		
	}

	@Override
	public RequireDetail getRequireById(Integer id) throws BusinessException {
		TrmRequire entity = requireDao.getRequireById(id);
        if (null == entity) {
            BusinessException bs = new BusinessException();
            bs.setExceptionMsg("该id对应的军民融合需求不存在！");
            throw bs;
        }
        RequireDetail detail = new RequireDetail();
        BeanUtils.copyProperties(entity, detail);
        // 设备设施分类功能唯一
        String equipType = detail.getEquipType();
        if(StringUtils.isNotEmpty(equipType)) {
        	detail.setEquipType(sysDataDao.getByCode(equipType).getName());
        }
        else {
        	detail.setEquipType("");
        }
        // 服务领域不唯一
        String serviceRanges = detail.getServiceRange();
        if(StringUtils.isNotEmpty(serviceRanges)) {
        	// 服务领域数组
        	String[] serviceRange = StringUtils.split(serviceRanges, ",");
        	SysDataRequest sysData = new SysDataRequest();
        	sysData.setCode("SR");
        	CommonListResponse<SysDataSimDetail> sysDataList = sysDataDao.findAll(sysData);
        	for(String sr : serviceRange) {
        		for(SysDataSimDetail sds : sysDataList.getList()) {
        			if(sds.getCode().equals(sr)) {
        				serviceRanges = serviceRanges.replace(sr, sds.getName());
        			}
        		}
        	}
        	detail.setServiceRange(serviceRanges);
        }
        else {
        	detail.setServiceRange("");
        }
        Integer orgId = entity.getOrgId();
        TrmMember member = memberDao.getUserinfoById(orgId);
        EquipMember memberDetail = new EquipMember();
        BeanUtils.copyProperties(member, memberDetail);
        detail.setMemberDetail(memberDetail);
		return detail;
	}

	@Override
	public RequireDetail getMyRequireById(Integer id) throws BusinessException {
		TrmRequire entity = requireDao.getRequireById(id);
        if (null == entity) {
            BusinessException bs = new BusinessException();
            bs.setExceptionMsg("该id对应的军民融合需求不存在！");
            throw bs;
        }
        RequireDetail detail = new RequireDetail();
        BeanUtils.copyProperties(entity, detail);
		return detail;
	}
	
	@Override
	public CommonResponse createRequire(RequireDetail detail) throws Exception {
		// detail 中的审核状态 保存传F0 提交传F2
		CommonResponse response = new CommonResponse();
		Integer userId = SessionUtil.getUserIdFromSession();
    	if(null == userId) {
    		response.setCodeAndMsg("E0", "用户未登录，不能发布军民融合需求！");
    		return response;
    	}
		TrmRequire entity = new TrmRequire();
		BeanUtils.copyProperties(detail, entity);
		// 设置的当前用户id
		entity.setOrgId(userId);
		entity.setIsActive(SystemConstants.FLAG_Y);
		boolean createFlag = commonDao.createEntity(entity);
		if(createFlag) {
			response.setCodeAndMsg("0000", "军民融合需求新增成功！");
		}
		else {
			response.setCodeAndMsg("9999", "军民融合需求新增失败！");
		}
		return response;
	}

	@Override
	public CommonResponse modifyRequire(RequireDetail detail) throws Exception {
		CommonResponse response = new CommonResponse();
		Integer userId = SessionUtil.getUserIdFromSession();
    	if(null == userId) {
    		response.setCodeAndMsg("E0", "用户未登录，不能编辑军民融合需求！");
    		return response;
    	}
		if(null == detail.getId()) {
			response.setCodeAndMsg("E1", "军民融合需求修改id不能为空！");
			return response;
		}
		TrmRequire entity = requireDao.getRequireById(detail.getId());
        String audStatusInDb = entity.getAudStatus();
        if(null != audStatusInDb && "F1".equals(audStatusInDb)){
            response.setCodeAndMsg("E2", "待审核状态的设备不能修改！");
            return response;
        }
        BeanUtils.copyProperties(detail, entity);
        // 设置的当前用户id
     	entity.setOrgId(userId);
        boolean updateFlag = commonDao.modifyEntity(entity);
        if(updateFlag) {
			response.setCodeAndMsg("0000", "军民融合需求修改成功！");
		}
		else {
			response.setCodeAndMsg("9999", "军民融合需求修改失败！");
		}
		return response;
	}

	@Override
	public CommonResponse deleteById(String id) throws Exception {
		CommonResponse response = new CommonResponse();
		Integer userId = SessionUtil.getUserIdFromSession();
    	if(null == userId) {
    		response.setCodeAndMsg("E0", "用户未登录，不能删除军民融合需求！");
    		return response;
    	}
		TrmRequire entity = new TrmRequire();
		List<Object> listEntity = commonDao.findListEntity(id, entity);
		boolean deleteFlag = commonDao.deleteAll(listEntity);
		if(deleteFlag) {
			response.setCodeAndMsg("0000", "军民融合需求删除成功！");
		}
		else {
			response.setCodeAndMsg("9999", "军民融合需求删除失败！");
		}
		return response;
	}

	@Override
	public CommonListResponse<RequireMyListDetail> myRequires(RequireRequest request) throws BusinessException {
		
		Integer userId = SessionUtil.getUserIdFromSession();
    	if(null == userId) {
    		BusinessException bs = new BusinessException();
            bs.setExceptionMsg("用户未登录，无法查询军民融合需求列表！");
            throw bs;
    	}
    	else {
    		// 设置当前用户id
    		request.setId(userId);
    	}
    	CommonListResponse<RequireMyListDetail> response = requireDao.myRequires(request);
    	if (response.getList().size() < 1) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("我的军民融合需求列表查询为空！");
            throw bs;
        }
		return response;
	}
	
	@Override
	public boolean viewCount(Integer id, Integer viewCount) {
		return requireDao.viewCount(id, viewCount);
	}
	
	@Override
	public List<RequireListDetail> findRequiresTop() throws BusinessException {
		return requireDao.findRequiresTop();
	}

	@Override
	public CommonResponse shiftRequire(RequireAudit request) {
		CommonResponse response = new CommonResponse();
		boolean flag = requireDao.shiftRequire(request);
		if(flag) {
			response.setCodeAndMsg("0000", "需求状态修改成功！");
		}
		else {
			response.setCodeAndMsg("9999", "需求状态修改失败！");
		}
		return response;
	}

}
