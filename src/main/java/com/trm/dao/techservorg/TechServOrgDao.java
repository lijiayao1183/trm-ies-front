package com.trm.dao.techservorg;

import java.util.List;

import com.trm.entity.TrmOrgMaterial;
import com.trm.entity.TrmTechServOrg;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.AuditRequest;
import com.trm.model.common.ComIntData;
import com.trm.model.common.CommonListResponse;
import com.trm.model.equip.CateCountEquip;
import com.trm.model.equip.EquipDayReq;
import com.trm.model.techservorg.HomePageOrg;
import com.trm.model.techservorg.TechServOrgCenterDetail;
import com.trm.model.techservorg.TechServOrgHomeDetail;
import com.trm.model.techservorg.TechServOrgReq;
import com.trm.model.techservorg.TechServOrgSimDetail;

/**
 * 技术服务机构
 * @author zhaosimiao 2018-2-24 14:36:36
 */
public interface TechServOrgDao {
	
	public HomePageOrg<TechServOrgHomeDetail> homeFindAll(TechServOrgReq requestParameter) throws BusinessException;
	
	public CommonListResponse<TechServOrgCenterDetail> personalCenterFindAll(TechServOrgReq requestParameter) throws BusinessException;
	
	public TrmTechServOrg personalCenterFindDetail(TechServOrgReq requestParameter) throws BusinessException;
   
    public CommonListResponse<TechServOrgSimDetail> findAll(TechServOrgReq requestParameter) throws BusinessException;
    
    public TrmTechServOrg findDetailById(Integer id) throws BusinessException;
    
    public TrmTechServOrg findDetailByName(String name) throws BusinessException;
    
    public boolean auditTechServOrg(AuditRequest request);
    
    List<CateCountEquip> recentlyMoreOrg(ComIntData comIntData) throws BusinessException;
    
    CommonListResponse<TechServOrgSimDetail> findOrgByDay(EquipDayReq equipDayReq) throws BusinessException;
    
    /**
     * 用id查询某一条技术服务机构随附材料  add by zhaosimiao 2018-6-5 14:58:42
     * @param id
     * @return
     * @throws BusinessException
     */
    public TrmOrgMaterial findOrgMaterialById(Integer id) throws BusinessException;
    
    /**
     * 用技术服务机构id查询所有随附材料  add by zhaosimiao 2018-6-5 14:58:42
     * @param orgId
     * @return
     * @throws BusinessException
     */
    public List<TrmOrgMaterial> findOrgMaterialList(Integer orgId) throws BusinessException;
    
    /**
     * 新增一条技术服务机构随附材料  add by zhaosimiao 2018-6-5 14:58:42
     * @param entity
     * @return
     * @throws BusinessException
     */
    public Integer createOrgMaterial(TrmOrgMaterial entity) throws BusinessException;
    
    /**
     * 删除某一技术服务机构的所有随附材料  add by zhaosimiao 2018-6-5 14:58:42
     * @param orgId
     * @return
     * @throws Exception
     */
    public boolean deleteOrgMaterialByOrgId(Integer orgId) throws Exception;

    CommonListResponse<TrmTechServOrg> findList(String startDate, String endDate);
}
