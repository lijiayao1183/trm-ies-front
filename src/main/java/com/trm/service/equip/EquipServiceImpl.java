package com.trm.service.equip;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.common.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trm.constants.SystemConstants;
import com.trm.dao.common.CommonDao;
import com.trm.dao.common.SysDataDao;
import com.trm.dao.equip.EquipDao;
import com.trm.dao.member.MemberDao;
import com.trm.entity.TrmAuditHistory;
import com.trm.entity.TrmEquip;
import com.trm.entity.TrmMember;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.AuditRequest;
import com.trm.model.common.ComIntData;
import com.trm.model.common.CommonListResponse;
import com.trm.model.common.CommonRequest;
import com.trm.model.common.CommonResponse;
import com.trm.model.common.PolicyComeRequest;
import com.trm.model.common.SysDataSimDetail;
import com.trm.model.equip.CateCountEquip;
import com.trm.model.equip.EquipDayReq;
import com.trm.model.equip.EquipDetail;
import com.trm.model.equip.EquipReq;
import com.trm.model.equip.EquipSimDetail;
import com.trm.model.equip.HomeEquipReq;
import com.trm.model.equip.HomeEquipSimDetail;
import com.trm.model.equip.MyEquipReq;
import com.trm.model.equip.MyEquipSimDetail;
import com.trm.model.equip.NotDisplayReq;
import com.trm.model.member.EquipMember;
import com.trm.util.BeanUtils;
import com.trm.util.Datetime;
import com.trm.util.SessionUtil;
import com.trm.util.batch.BatchEquip;
import com.trm.util.batch.BatchEquipFileRequest;
import com.trm.util.batch.ReadExcel;

/**
 * @description
 */
@Service("equipService")
@Transactional(rollbackFor = Exception.class)
public class EquipServiceImpl implements EquipService {
    
    public static Logger logger = LoggerFactory.getLogger(EquipServiceImpl.class);
    
    @Autowired
    private EquipDao equipDao;
    
    @Autowired
    private MemberDao memberDao;
    
    //    @Autowired
    //    private MemberService memberService;//前台用户
    
    @Autowired
    private SysDataDao sysDataDao;
    @Autowired
    private CommonDao commonDao;
    
    /** 虚拟路径 */
    @Value("#{filePath.virtual_file_path}")
    private String virtualFilePath;
    
    /** 物理路径 */
    @Value("#{filePath.physical_file_path}")
    private String physicalFilePath;
    
    @Override
    public CommonListResponse<HomeEquipSimDetail> findAll(HomeEquipReq requestParameter) throws BusinessException {
        CommonListResponse<HomeEquipSimDetail> result = equipDao.findAll(requestParameter);
        // 信息为空时，抛出异常
        if (result.getList().size() < 1) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("设备列表查询为空！");
            throw bs;
        }
        return result;
    }
    
    @Override
    public CommonListResponse<MyEquipSimDetail> findAllMyEqip(MyEquipReq requestParameter) throws BusinessException {
        CommonListResponse<MyEquipSimDetail> result = equipDao.findAllMyEqip(requestParameter);
        if (result.getList().size() < 1) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("设备列表查询为空！");
            throw bs;
        }
        PolicyComeRequest eq = new PolicyComeRequest();
        for (MyEquipSimDetail obj : result.getList()) {
            String equipType = obj.getEquipType();
            if (StringHelper.isNotEmpty(equipType)) {
                eq.setCode("DF");
                CommonListResponse<SysDataSimDetail> slit = sysDataDao.findAll(eq);
                String[] multiKeys = StringUtils.split(equipType, SystemConstants.SYSTEM_COMMA);
                for (String c : multiKeys) {
                    for (SysDataSimDetail ob : slit.getList()) {
                        if (c.equals(ob.getCode())) {
                            equipType = equipType.replace(c, ob.getName());
                        }
                    }
                }
                obj.setEquipType(equipType);
            }
        }
        return result;
    }
    
    @Override
    public CommonListResponse<EquipSimDetail> seniorFindAll(EquipReq requestParameter) throws BusinessException {
        CommonListResponse<EquipSimDetail> result = equipDao.seniorFindAll(requestParameter);
        // 信息为空时，抛出异常
        if (result.getList().size() < 1) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("设备列表查询为空！");
            throw bs;
        }
        PolicyComeRequest eq = new PolicyComeRequest();
        for (EquipSimDetail obj : result.getList()) {
            String equipType = obj.getEquipType();
            if (StringHelper.isNotEmpty(equipType)) {
                eq.setCode("DF");
                CommonListResponse<SysDataSimDetail> slit = sysDataDao.findAll(eq);
                String[] multiKeys = StringUtils.split(equipType, SystemConstants.SYSTEM_COMMA);
                for (String c : multiKeys) {
                    for (SysDataSimDetail ob : slit.getList()) {
                        if (c.equals(ob.getCode())) {
                            equipType = equipType.replace(c, ob.getName());
                        }
                    }
                }
                obj.setEquipType(equipType);
            }
            
            String serviceRange = obj.getServiceRange();
            if (StringHelper.isNotEmpty(serviceRange)) {
                eq.setCode("SR");
                CommonListResponse<SysDataSimDetail> slit = sysDataDao.findAll(eq);
                String[] multiKeys = StringUtils.split(serviceRange, SystemConstants.SYSTEM_COMMA);
                for (String c : multiKeys) {
                    for (SysDataSimDetail ob : slit.getList()) {
                        if (c.equals(ob.getCode())) {
                            serviceRange = serviceRange.replace(c, ob.getName());
                        }
                    }
                }
                obj.setServiceRange(serviceRange);
            }
        }
        return result;
    }
    
    @Override
    public EquipDetail findDetailById(Integer id) throws BusinessException {
    	// 浏览次数+1
        equipDao.addViewCount(id);
        
        TrmEquip entity = equipDao.findDetailById(id);
        if (null == entity) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("设备详情查询为空！");
            throw bs;
        }
        EquipDetail target = new EquipDetail();
        BeanUtils.copyProperties(entity, target);
        //获取提供者详情
        Integer orgId = entity.getOrgId();
        TrmMember member = memberDao.getUserinfoById(orgId);
        EquipMember memberDetail = new EquipMember();
        BeanUtils.copyProperties(member, memberDetail);
        target.setMemberDetail(memberDetail);
        
        return target;
    }
    
    @Override
    public boolean createEquip(EquipDetail requestParameter) throws Exception {
        TrmEquip entity = new TrmEquip();
        BeanUtils.copyProperties(requestParameter, entity);
        entity.setIsActive(SystemConstants.FLAG_Y);
        entity.setIsDisplay("F");//设置未上架
        //设备-待审核F1;已通过F2;未通过F3;未提交F0;
        //entity.setAudStatus(SystemConstants.APPLY_RETURNED);//F0
        entity.setViewCount(0);
        return commonDao.createEntity(entity);
    }
    
    @Override
    public boolean submitData(EquipDetail requestParameter) throws Exception {
        boolean flag = false;
        Integer eqId = requestParameter.getId();
        if (eqId != null && eqId > 0) {
            TrmEquip entity = equipDao.findDetailById(eqId);
            BeanUtils.copyProperties(requestParameter, entity);
            entity.setIsDisplay("F");//设置未上架
            entity.setViewCount(0);
            entity.setApplyDate(new Date());
            //设备-待审核F1;已通过F2;未通过F3;未提交F0;
            //entity.setAudStatus(SystemConstants.EQUIP_PENDING);//F1
            flag = commonDao.modifyEntity(entity);
        } else {
            TrmEquip entity = new TrmEquip();
            BeanUtils.copyProperties(requestParameter, entity);
            entity.setIsActive(SystemConstants.FLAG_Y);
            entity.setIsDisplay("F");//设置未上架
            //设备-待审核F1;已通过F2;未通过F3;未提交F0;
            //entity.setAudStatus(SystemConstants.EQUIP_PENDING);//F1
            entity.setApplyDate(new Date());//设置提交申请审核时间
            entity.setViewCount(0);
            flag = commonDao.createEntity(entity);
        }
        return flag;
    }
    
    @Override
    public CommonResponse deleteById(String id) throws Exception {
        /*//实体
        TrmEquip entity = new TrmEquip();
        //根据id查询实体
        List<Object> listEntity = commonDao.findListEntity(id, entity);
        // 物理删除
        return commonDao.deleteAll(listEntity);*/
        
        CommonResponse response = new CommonResponse();
        Integer userId = SessionUtil.getUserIdFromSession();
        if (null == userId) {
            response.setCodeAndMsg("E0", "用户未登录，不能删除军民融合需求！");
            return response;
        }
        TrmEquip trmEquip = new TrmEquip();
        List<Object> listEntity = commonDao.findListEntity(id, trmEquip);
        for (int i = 0; i < listEntity.size(); i++) {
            trmEquip = (TrmEquip) listEntity.get(i);
            if (!"F0".equals(trmEquip.getAudStatus()) && !"F2".equals(trmEquip.getAudStatus()) && !"F3"
                    .equals(trmEquip.getAudStatus()) && !"A3".equals(trmEquip.getAudStatus())) {
                BusinessException bs = new BusinessException();
                bs.setExceptionCode(SystemConstants.REASONCODE_2068);
                bs.setExceptionMsg("审核中状态不能删除！");
                throw bs;
            }
        }
        //boolean deleteFlag = commonDao.deleteAll(listEntity);
        
        String[] ids = id.split(SystemConstants.SYSTEM_COMMA);
        equipDao.batchDelEquip(ids);
        
        response.setCodeAndMsg("0000", "军民融合需求删除成功！");
        return response;
    }
    
    @Override
    public boolean modifyEquip(EquipDetail detail) throws Exception {
        
        TrmEquip entity = equipDao.findDetailById(detail.getId());
        
        String audStatusInParam = detail.getAudStatus();
        String audStatusInDb = entity.getAudStatus();
        
        // modify by zhaosimiao 2017-11-8 16:12:18
        
        // 数据库状态为F0、F2、F3则可以修改，数据库状态为F1则不可修改
        if (null != audStatusInDb && SystemConstants.EQUIP_PENDING.equals(audStatusInDb)) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("待审核状态的设备不能修改！");
            throw bs;
        }
        
        BeanUtils.copyProperties(detail, entity);
        // 提交状态为F1，设置提交审核时间
        if (null != audStatusInParam && SystemConstants.EQUIP_PENDING.equals(audStatusInParam)) {
            entity.setApplyDate(new Date());
        }
        
        return commonDao.modifyEntity(entity);
    }
    
    @Override
    public boolean notDisplay(NotDisplayReq requestParameter) throws Exception {
        // modify by zhaosimiao 前台只能下架
        // String display = requestParameter.getIsDisplay();
        String display = "N";
        TrmEquip info = equipDao.findDetailById(requestParameter.getId());
        String status = info.getAudStatus();
        //F1未审核，F2审核通过，F3未通过，F0未提交
        if (null != status && !SystemConstants.EQUIP_ADOPT.equals(status)) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("当前设备还未通过审核，暂时不能上下架");
            throw bs;
        }
        info.setIsDisplay(display);//设置设备上下架
        info.setDisplayDate(new Date());
        info.setReason(requestParameter.getReason());
        return commonDao.modifyEntity(info);
    }
    
    @Override
    public boolean viewCount(Integer id, Integer viewCount) {
        return equipDao.viewCount(id, viewCount);
    }
    
    @Override
    public List<EquipSimDetail> seniorEquipTop() throws BusinessException {
        return equipDao.seniorEquipTop();
    }
    
    @Override
    public List<CateCountEquip> recentlyMoreEquip(ComIntData comIntData) throws BusinessException {
        return equipDao.recentlyMoreEquip(comIntData);
    }
    
    @Override
    public CommonListResponse<HomeEquipSimDetail> findEquipByDay(EquipDayReq equipDayReq) throws BusinessException {
        return equipDao.findEquipByDay(equipDayReq);
    }
    
    @Override
    public boolean auditDate(AuditRequest request) throws Exception {
        boolean b = equipDao.auditDate(request);
        
        Date auditDate = new Date();
        // 插入审核流水
        TrmAuditHistory entity = new TrmAuditHistory();
        // 审核项分类：设备设施1/需求2/技术服务机构3/季报4
        entity.setAuditType("1");
        entity.setAuditId(request.getAuditId());
        entity.setAuditor(request.getAuditor());
        entity.setAuditDate(auditDate);
        // 操作岗位：呈报单位审核1/科工办审核2
        entity.setStation(request.getStation());
        entity.setStatus(request.getStatus());
        entity.setAuditMsg(request.getAuditMsg());
        entity.setIsActive("Y");
        
        commonDao.createEntity(entity);
        return b;
    }

	@Override
	public List<BatchEquip> importData(BatchEquipFileRequest req) throws Exception{
		String filePath = req.getFilePath();
        if (filePath.contains(virtualFilePath)) {
            filePath = filePath.replace(virtualFilePath, physicalFilePath);
        }
        List<BatchEquip> list = new ReadExcel().readExcel(filePath);
        for(BatchEquip equip : list) {
        	CommonRequest cr = new CommonRequest();
            String equipType = equip.getEquipType();
            if (StringHelper.isNotEmpty(equipType)) {
            	cr.setCode("DF");
                CommonListResponse<SysDataSimDetail> slit = sysDataDao.findAll(cr);
                String[] multiKeys = StringUtils.split(equipType, SystemConstants.SYSTEM_COMMA);
                for (String c : multiKeys) {
                    for (SysDataSimDetail ob : slit.getList()) {
                        if (c.equals(ob.getName())) {
                            equipType = equipType.replace(c, ob.getCode());
                        }
                    }
                }
                equip.setEquipType(equipType);
            }
            
            String serviceRange = equip.getServiceRange();
            if (StringHelper.isNotEmpty(serviceRange)) {
                cr.setCode("SR");
                CommonListResponse<SysDataSimDetail> slit = sysDataDao.findAll(cr);
                String[] multiKeys = StringUtils.split(serviceRange, SystemConstants.SYSTEM_COMMA);
                for (String c : multiKeys) {
                    for (SysDataSimDetail ob : slit.getList()) {
                        if (c.equals(ob.getName())) {
                            serviceRange = serviceRange.replace(c, ob.getCode());
                        }
                    }
                }
                equip.setServiceRange(serviceRange);
            }
        	
        	TrmEquip entity = new TrmEquip();
        	entity.setEquipName(equip.getEquipName());
        	entity.setEquipType(equip.getEquipType());
        	entity.setServiceRange(equip.getServiceRange());
        	entity.setEquipVerCode(equip.getEquipVerCode());
        	entity.setProCountry(equip.getProCountry());
        	entity.setCreateFirm(equip.getCreateFirm());
        	entity.setServiceMode(equip.getServiceMode());
        	entity.setEquipValue(equip.getEquipValue());
        	entity.setPurchaseDate(Datetime.toDate(equip.getPurchaseDate(), "yyyy-MM-dd"));
        	entity.setLinkPerson(equip.getLinkPerson());
        	entity.setEmail(equip.getEmail());
        	entity.setLinkPhone(equip.getLinkPhone());
        	entity.setUseField(equip.getUseField());
        	entity.setQualification(equip.getQualification());
        	entity.setTecFeature(equip.getTecFeature());
        	
        	// 补全其他非批量参数
        	Integer userId = SessionUtil.getUserIdFromSession();
        	TrmMember member = memberDao.getUserinfo(userId);
        	entity.setLinkUnit(member.getOrgName());
        	entity.setLinkAddress(member.getAddress());
        	entity.setIsActive("Y");
        	entity.setAudStatus("F0");
        	entity.setApplyDate(new Date());
        	entity.setIsDisplay("F");
        	entity.setOrgId(userId);
        	entity.setViewCount(0);
        	
        	commonDao.createEntity(entity);
        }
		return list;
	}

    @Override
    public CommonListResponse<TrmEquip> findList(String startDate, String endDate) {
        return equipDao.findList(startDate, endDate);
    }
}
