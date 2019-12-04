package com.trm.service.techservorg;

import java.util.List;

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
import com.trm.model.techservorg.TechServOrgCenterDetail;
import com.trm.model.techservorg.TechServOrgDetail;
import com.trm.model.techservorg.TechServOrgHomeDetail;
import com.trm.model.techservorg.TechServOrgReq;
import com.trm.model.techservorg.TechServOrgSimDetail;

/**
 * 技术服务机构
 * @author zhaosimiao 2018-2-24 14:36:36
 */
public interface TechServOrgService {
	
	public HomePageOrg<TechServOrgHomeDetail> homeFindAll(TechServOrgReq requestParameter) throws BusinessException;
	
	public CommonListResponse<TechServOrgCenterDetail> personalCenterFindAll(TechServOrgReq requestParameter) throws BusinessException;
	
	public TechServOrgDetail personalCenterFindDetail(TechServOrgReq requestParameter) throws BusinessException;
    
    public CommonListResponse<TechServOrgSimDetail> findAll(TechServOrgReq requestParameter) throws BusinessException;

    public TechServOrgDetail findDetailById(Integer id) throws BusinessException;
    
    public CommonResponse createTechServOrg(TechServOrgDetail requestParameter)throws Exception;
    
    public boolean deleteById(String id)throws Exception;
    
    public CommonResponse modifyTechServOrg(TechServOrgDetail requestParameter)throws Exception;
    
    public boolean auditTechServOrg(AuditRequest request) throws Exception ;
    
    List<CateCountEquip> recentlyMoreOrg(ComIntData comIntData) throws BusinessException;
    
    CommonListResponse<TechServOrgSimDetail> findOrgByDay(EquipDayReq equipDayReq) throws BusinessException;
    
    /**
     * 查询技术服务机构各类随附材料列表信息  add by zhaosimiao 2018-6-5 15:53:43
     * @param request
     * @return
     * @throws BusinessException
     */
    public OrgMaterialListResponse<OrgOneKindMaterial> findOrgKindMaterialList(OrgMaterialRequest request) throws BusinessException;

    CommonListResponse<TrmTechServOrg> findList(String startDate, String endDate);
}
