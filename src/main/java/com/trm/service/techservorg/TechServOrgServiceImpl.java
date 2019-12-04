package com.trm.service.techservorg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trm.constants.SystemConstants;
import com.trm.dao.common.CommonDao;
import com.trm.dao.member.MemberDao;
import com.trm.dao.techservorg.TechServOrgDao;
import com.trm.entity.TrmAuditHistory;
import com.trm.entity.TrmMember;
import com.trm.entity.TrmOrgMaterial;
import com.trm.entity.TrmTechServOrg;
import com.trm.entity.business.CommonResponse;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.AuditRequest;
import com.trm.model.common.ComIntData;
import com.trm.model.common.CommonListResponse;
import com.trm.model.equip.CateCountEquip;
import com.trm.model.equip.EquipDayReq;
import com.trm.model.techservorg.HomePageOrg;
import com.trm.model.techservorg.OrgMaterialListResponse;
import com.trm.model.techservorg.OrgMaterialRequest;
import com.trm.model.techservorg.OrgOneKindMaterial;
import com.trm.model.techservorg.OrgOneMaterial;
import com.trm.model.techservorg.TechServOrgCenterDetail;
import com.trm.model.techservorg.TechServOrgDetail;
import com.trm.model.techservorg.TechServOrgHomeDetail;
import com.trm.model.techservorg.TechServOrgReq;
import com.trm.model.techservorg.TechServOrgSimDetail;
import com.trm.util.BeanUtils;

/**
 * 技术服务机构
 * @author zhaosimiao 2018-2-24 14:36:36
 */
@Service("techServOrgService")
@Transactional(rollbackFor = Exception.class)
public class TechServOrgServiceImpl implements TechServOrgService {

    public static Logger logger = LoggerFactory.getLogger(TechServOrgServiceImpl.class);

    @Autowired
    private TechServOrgDao techServOrgDao;
    
    @Autowired
    private MemberDao memberDao;

    @Autowired
    private CommonDao commonDao;

	@Override
	public HomePageOrg<TechServOrgHomeDetail> homeFindAll(TechServOrgReq requestParameter)
			throws BusinessException {
		
		HomePageOrg<TechServOrgHomeDetail> result = techServOrgDao.homeFindAll(requestParameter);
        // 信息为空时，抛出异常
        if (result.getList().size() < 1) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("技术服务机构列表查询为空！");
            throw bs;
        }
        return result;
	}

	@Override
	public CommonListResponse<TechServOrgCenterDetail> personalCenterFindAll(TechServOrgReq requestParameter)
			throws BusinessException {
		CommonListResponse<TechServOrgCenterDetail> result = techServOrgDao.personalCenterFindAll(requestParameter);
        // 信息为空时，抛出异常
        if (result.getList().size() < 1) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("技术服务机构列表查询为空！");
            throw bs;
        }
        return result;
	}
	
	@Override
    public TechServOrgDetail personalCenterFindDetail(TechServOrgReq requestParameter) throws BusinessException {
        TrmTechServOrg entity = techServOrgDao.findDetailById(requestParameter.getId());
        if (null == entity) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("技术服务机构详情查询为空！");
            throw bs;
        }
        TechServOrgDetail target = new TechServOrgDetail();
        BeanUtils.copyProperties(entity, target);
        
        Integer userId = entity.getUserId();
        TrmMember member = memberDao.getUserinfoById(userId);
        target.setUnitName(member.getOrgName());
        
        // 查询该技术服务机构随附材料
        Integer orgId = entity.getId();
        OrgMaterialRequest request = new OrgMaterialRequest ();
        request.setOrgId(orgId);
        OrgMaterialListResponse<OrgOneKindMaterial> list = findOrgKindMaterialList(request);
        if(list != null)
        	target.setFileList(list.getFileList());
        
        return target;
    }
    
    @Override
    public CommonListResponse<TechServOrgSimDetail> findAll(TechServOrgReq requestParameter) throws BusinessException {
        CommonListResponse<TechServOrgSimDetail> result = techServOrgDao.findAll(requestParameter);
        // 信息为空时，抛出异常
        if (result.getList().size() < 1) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("技术服务机构列表查询为空！");
            throw bs;
        }
        return result;
    }

    @Override
    public TechServOrgDetail findDetailById(Integer id) throws BusinessException {
        TrmTechServOrg entity = techServOrgDao.findDetailById(id);
        if (null == entity) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("技术服务机构详情查询为空！");
            throw bs;
        }
        TechServOrgDetail target = new TechServOrgDetail();
        BeanUtils.copyProperties(entity, target);
        
        Integer userId = entity.getUserId();
        TrmMember member = memberDao.getUserinfoById(userId);
        target.setUnitName(member.getOrgName());
        
        // 查询该技术服务机构随附材料
        Integer orgId = entity.getId();
        OrgMaterialRequest request = new OrgMaterialRequest ();
        request.setOrgId(orgId);
        OrgMaterialListResponse<OrgOneKindMaterial> list = findOrgKindMaterialList(request);
        if(list != null)
        	target.setFileList(list.getFileList());
        
        return target;
    }
    
    @Override
    public CommonResponse createTechServOrg(TechServOrgDetail requestParameter) throws Exception {
    	
    	CommonResponse response = new CommonResponse();
    	
    	boolean createFlag = false;
    	
    	String orgName = requestParameter.getOrgName();
    	if(null != techServOrgDao.findDetailByName(orgName)) {
    		response.setCode(9999);
    		response.setMessage("机构名已存在，创建失败！");
    		return response;
    	}
    	
        TrmTechServOrg entity = new TrmTechServOrg();
        BeanUtils.copyProperties(requestParameter, entity);
        entity.setIsActive(SystemConstants.FLAG_Y);
        createFlag = commonDao.createEntity(entity);
        
        // 取机构id和随附材料列表
        Integer orgId = entity.getId();
        List<OrgOneKindMaterial> fileList = requestParameter.getFileList();
        if(fileList != null) {
        	for(OrgOneKindMaterial ookm : fileList) {
            	String materialType = ookm.getMaterialType();
            	List<OrgOneMaterial> materialList = ookm.getMaterialList();
            	
            	for(OrgOneMaterial oom : materialList) {
            		
            		TrmOrgMaterial tom = new TrmOrgMaterial();
            		tom.setOrgId(orgId);
            		tom.setMaterialType(materialType);
            		BeanUtils.copyProperties(oom, tom);
            		tom.setIsActive(SystemConstants.FLAG_Y);
            		
            		createFlag = commonDao.createEntity(tom);
            		
            	}
            }
        }
        
        if(createFlag) {
        	response.setCode(0000);
    		response.setMessage("操作成功！");
        }
        else {
        	response.setCode(9999);
    		response.setMessage("该数据创建失败！");
        }
        
        return response;
    }
    
    @Override
    public boolean deleteById(String id) throws Exception {
        //实体
        TrmTechServOrg entity = new TrmTechServOrg();
        //根据id查询实体
        List<Object> listEntity = commonDao.findListEntity(id, entity);
        // 物理删除
        return commonDao.deleteAll(listEntity);
    }
    
    @Override
    public CommonResponse modifyTechServOrg(TechServOrgDetail requestParameter) throws Exception {
    	
    	TrmTechServOrg info = techServOrgDao.findDetailById(requestParameter.getId());
    	
    	CommonResponse response = new CommonResponse();
    	
    	String orgName = requestParameter.getOrgName();
    	
    	if(!info.getOrgName().equals(orgName) && null != techServOrgDao.findDetailByName(orgName)) {
    		response.setCode(9999);
    		response.setMessage("机构名已存在，修改失败！");
    		return response;
    	}
    	
        
        BeanUtils.copyProperties(requestParameter, info);
        
        boolean modifyFlag = false;
        
        modifyFlag = commonDao.modifyEntity(info);
        
        // 取机构id和随附材料列表
        Integer orgId = info.getId();
        // 删除原有随附材料
        techServOrgDao.deleteOrgMaterialByOrgId(orgId);
        
        // 新增随附材料
        List<OrgOneKindMaterial> fileList = requestParameter.getFileList();
        if(fileList != null) {
        	for(OrgOneKindMaterial ookm : fileList) {
            	String materialType = ookm.getMaterialType();
            	List<OrgOneMaterial> materialList = ookm.getMaterialList();
            	
            	for(OrgOneMaterial oom : materialList) {
            		
            		TrmOrgMaterial tom = new TrmOrgMaterial();
            		tom.setOrgId(orgId);
            		tom.setMaterialType(materialType);
            		BeanUtils.copyProperties(oom, tom);
            		tom.setIsActive(SystemConstants.FLAG_Y);
            		
            		modifyFlag = commonDao.createEntity(tom);
            		
            	}
            }
        }
        
        
        
        if(modifyFlag) {
        	response.setCode(0000);
    		response.setMessage("操作成功！");
        }
        else {
        	response.setCode(9999);
    		response.setMessage("该数据修改失败！");
        }
        return response;
    }

	@Override
	public boolean auditTechServOrg(AuditRequest request) throws Exception {
		
		// 审核时间
		Date auditDate = new Date();
		request.setAuditDate(auditDate);
		
		boolean auditFlag = techServOrgDao.auditTechServOrg(request);
		
		// 插入审核流水
		TrmAuditHistory entity = new TrmAuditHistory();
		// 审核项分类：设备设施1/需求2/技术服务机构3/季报4
		entity.setAuditType("3");
		entity.setAuditId(request.getAuditId());
		entity.setAuditor(request.getAuditor());
		entity.setAuditDate(auditDate);
		// 操作岗位：呈报单位审核1/科工办审核2
		entity.setStation(request.getStation());
		entity.setStatus(request.getStatus());
		entity.setAuditMsg(request.getAuditMsg());
		entity.setIsActive("Y");
		
		auditFlag = commonDao.createEntity(entity);
		return auditFlag;
	}
	
	@Override
    public List<CateCountEquip> recentlyMoreOrg(ComIntData comIntData) throws BusinessException {
        return techServOrgDao.recentlyMoreOrg(comIntData);
    }

	@Override
	public CommonListResponse<TechServOrgSimDetail> findOrgByDay(EquipDayReq equipDayReq) throws BusinessException {
		return techServOrgDao.findOrgByDay(equipDayReq);
	}

	@Override
	public OrgMaterialListResponse<OrgOneKindMaterial> findOrgKindMaterialList(OrgMaterialRequest request)
			throws BusinessException {
		Integer orgId = request.getOrgId();
		
		// 依据机构id查询所有随附材料
		List<TrmOrgMaterial> tomList = techServOrgDao.findOrgMaterialList(orgId);
		
		OrgMaterialListResponse<OrgOneKindMaterial> response = new OrgMaterialListResponse<OrgOneKindMaterial>();
		
		if (tomList.size() >= 1) {
			
			List<String> typeList = new ArrayList<>();
			for(TrmOrgMaterial entity : tomList) {
				typeList.add(entity.getMaterialType());
			}
			
			// 将随附材料类型排序
			HashSet<String> has = new HashSet<String>(typeList);
			typeList.clear();
			typeList.addAll(has);
			Collections.sort(typeList);
			
			List<OrgOneKindMaterial> ookmList = new ArrayList<OrgOneKindMaterial>();
			
			for(String type : typeList) {
				
				OrgOneKindMaterial ookm = new OrgOneKindMaterial();
				
				List<OrgOneMaterial> oomList = new ArrayList<OrgOneMaterial> ();
				
				for(TrmOrgMaterial entity : tomList) {
					
					OrgOneMaterial oom = new OrgOneMaterial();
					if(type.equals(entity.getMaterialType())) {
						
						BeanUtils.copyProperties(entity, oom);
						oomList.add(oom);
						// 构造技术服务机构的某一类随附材料对象
						ookm.setOrgId(entity.getOrgId());
						ookm.setMaterialType(type);
						ookm.setMaterialList(oomList);
					}
					
				}
				ookmList.add(ookm);
			
			}
			
			response.setFileList(ookmList);
        }
		
		return response;
	}

    @Override
    public CommonListResponse<TrmTechServOrg> findList(String startDate, String endDate) {
        return techServOrgDao.findList(startDate, endDate);
    }

}
