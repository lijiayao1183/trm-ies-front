/**
 * @Title: DemandServiceImpl.java
 * @Package: com.trm.service.require
 * @Description: TODO(用一句话描述该文件做什么)
 * @Copyright: Copyright (c)
 * @Company: Digital Telemedia Co.,Ltd
 * @author LiuJC
 * @date 2018年02月26 上午10:49
 * @version V1.0
 * @Revision 2018年02月26 上午10:49
 */

package com.trm.service.require;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.common.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.trm.constants.SystemConstants;
import com.trm.dao.common.CommonDao;
import com.trm.dao.common.SysDataDao;
import com.trm.dao.require.DemandDao;
import com.trm.dao.require.TechnologyDao;
import com.trm.entity.TrmAuditHistory;
import com.trm.entity.TrmDemand;
import com.trm.entity.TrmTechnology;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.AuditRequest;
import com.trm.model.common.ComIntData;
import com.trm.model.common.CommonListResponse;
import com.trm.model.common.CommonResponse;
import com.trm.model.common.PolicyComeRequest;
import com.trm.model.common.SysDataSimDetail;
import com.trm.model.equip.EquipDayReq;
import com.trm.model.require.CateCountDemand;
import com.trm.model.require.DemandDetails;
import com.trm.model.require.DemandIndex;
import com.trm.model.require.DemandListResp;
import com.trm.model.require.DemandReq;
import com.trm.model.require.RelevantTechReq;
import com.trm.model.require.RequireRequest;
import com.trm.util.BeanUtils;
import com.trm.util.SessionUtil;

/**
 * @ClassName DemandServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author LiuJC
 * @Date 2018年02月26 上午10:49
 * @version 1.0.0
 */
@Transactional(rollbackFor = Exception.class)
@Service("semandService")
public class DemandServiceImpl implements DemandService {
    @Autowired
    private SysDataDao sysDataDao;
    @Autowired
    private DemandDao demandDao;
    @Autowired
    private CommonDao commonDao;
    
    @Autowired
    private TechnologyDao technologyDao;
    
    @Override
    public CommonResponse createDemand(@Valid @RequestBody DemandReq demandReq) throws Exception {
        CommonResponse response = new CommonResponse();
        Integer userId = SessionUtil.getUserIdFromSession();
        if (null == userId) {
            response.setCodeAndMsg("E0", "用户未登录，不能发布军民融合需求！");
            return response;
        }
        TrmDemand trmDemand = new TrmDemand();
        trmDemand.setName(demandReq.getName());
        trmDemand.setSource(demandReq.getSource());
        trmDemand.setType(demandReq.getType());
        trmDemand.setKeyword(demandReq.getKeyword());
        trmDemand.setDomain(demandReq.getDomain());
        trmDemand.setCompanyName(demandReq.getCompanyName());
        trmDemand.setCompanyAddr(demandReq.getCompanyAddr());
        trmDemand.setContacts(demandReq.getContacts());
        trmDemand.setPhone(demandReq.getPhone());
        trmDemand.setEndDate(demandReq.getEndDate());
        trmDemand.setContent(demandReq.getContent());
        trmDemand.setRemark(demandReq.getRemark());
        trmDemand.setViewCount(0);
        trmDemand.setCode(
                "demand" + System.currentTimeMillis() + Math.round((new Random().nextDouble() * Math.pow(10, 2))));
        trmDemand.setMemberId(SessionUtil.getUserIdFromSession());
        trmDemand.setOrgId(SessionUtil.getUnitIdFromSession());
        String userType = SessionUtil.getUserTypeFromSession();
        boolean isFrontAdmin = null != userType && "2".equals(userType) ? true : false;
        trmDemand.setIsActive("Y");
        trmDemand.setAudStatus(demandReq.getAudStatus());
        /*trmDemand.setAudStatus(isFrontAdmin ? "A2" : demandReq.getAudStatus());
        trmDemand.setAudDate(isFrontAdmin ? new Date() : null);
        String usernameFromSession = SessionUtil.getUsernameFromSession();
        trmDemand.setAudPerson(isFrontAdmin ? usernameFromSession : null);*/
        commonDao.createEntity(trmDemand);
        List<RelevantTechReq> list = demandReq.getList();
        if (null != list && 0 != list.size()) {
            for (int i = 0; i < list.size(); i++) {
                RelevantTechReq relevantTechReq = list.get(i);
                TrmTechnology trmTechnology = new TrmTechnology();
                BeanUtils.copyProperties(relevantTechReq, trmTechnology);
                trmTechnology.setDemandId(trmDemand.getId());
                trmTechnology.setIsActive("Y");
                commonDao.createEntity(trmTechnology);
            }
        }
        
        response.setCodeAndMsg("0000", "军民融合需求新增成功！");
        return response;
    }
    
    @Override
    public CommonListResponse<DemandListResp> myDemand(RequireRequest requireReques) throws Exception {
        return demandDao.myDemand(requireReques);
    }
    
    /**
     * 查询详情
     * @param id
     */
    @Override
    public DemandDetails getMyDemandById(Integer id) throws BusinessException {
        DemandDetails demandDetails = demandDao.getMyDemandById(id);
        /*SysDataDictionary sysDataDictionary = sysDataDao.getByCode(demandDetails.getTrmDemand().getDomain());
        demandDetails.setDomain(sysDataDictionary.getName());*/
        
        PolicyComeRequest eq = new PolicyComeRequest();
        String serviceRange = demandDetails.getTrmDemand().getDomain();
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
            demandDetails
                    .setDomain(serviceRange.replace(SystemConstants.SYSTEM_COMMA, SystemConstants.SYSTEM_SEPARATOR));
        }
        return demandDetails;
    }
    
    /**
     * 删除
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public CommonResponse deleteById(String id) throws Exception {
        CommonResponse response = new CommonResponse();
        Integer userId = SessionUtil.getUserIdFromSession();
        if (null == userId) {
            response.setCodeAndMsg("E0", "用户未登录，不能删除军民融合需求！");
            return response;
        }
        TrmDemand trmDemand = new TrmDemand();
        List<Object> listEntity = commonDao.findListEntity(id, trmDemand);
        for (int i = 0; i < listEntity.size(); i++) {
            trmDemand = (TrmDemand) listEntity.get(i);
            if (!"F0".equals(trmDemand.getAudStatus()) && !"F2".equals(trmDemand.getAudStatus()) && !"F3"
                    .equals(trmDemand.getAudStatus()) && !"A3".equals(trmDemand.getAudStatus())) {
                BusinessException bs = new BusinessException();
                bs.setExceptionCode(SystemConstants.REASONCODE_2068);
                bs.setExceptionMsg("审核中状态不能删除！");
                throw bs;
            }
        }
        //boolean deleteFlag = commonDao.deleteAll(listEntity);
        
        String[] ids = id.split(SystemConstants.SYSTEM_COMMA);
        demandDao.batchDelDemands(ids);
        for (int i = 0; i < ids.length; i++) {
            //List<TrmTechnology> technologies = technologyDao.getAllTechnologyByDemanId(new Integer(ids[i]));
            //commonDao.deleteAll(listEntity);
            technologyDao.batchDelTechnogyByDemandId(ids);
        }
        
        response.setCodeAndMsg("0000", "军民融合需求删除成功！");
        return response;
    }
    
    /**
     * 修改信息
     * @param demandReq
     * @return
     * @throws Exception
     */
    @Override
    public CommonResponse modifyDemand(DemandReq demandReq) throws Exception {
        CommonResponse response = new CommonResponse();
        Integer userId = SessionUtil.getUserIdFromSession();
        if (null == userId) {
            response.setCodeAndMsg("E0", "用户未登录，不能发布军民融合需求！");
            return response;
        }
        
        Integer id = demandReq.getId();
        DemandDetails details = demandDao.getMyDemandById(id);
        if (null == id) {
            response.setCodeAndMsg("E1", "军民融合需求修改id不能为空！");
            return response;
        }
        TrmDemand trmDemand = details.getTrmDemand();
        BeanUtils.copyProperties(demandReq, trmDemand);
        trmDemand.setMemberId(SessionUtil.getUserIdFromSession());
        trmDemand.setOrgId(SessionUtil.getUnitIdFromSession());
        trmDemand.setIsActive("Y");
        commonDao.modifyEntity(trmDemand);
        List<TrmTechnology> trmTechnologies = technologyDao.getAllTechnologyByDemanId(id);
        commonDao.deleteAll(trmTechnologies);
        List<RelevantTechReq> list = demandReq.getList();
        if (null != list && 0 != list.size()) {
            for (int i = 0; i < list.size(); i++) {
                RelevantTechReq relevantTechReq = list.get(i);
                TrmTechnology trmTechnology = new TrmTechnology();
                BeanUtils.copyProperties(relevantTechReq, trmTechnology);
                trmTechnology.setDemandId(trmDemand.getId());
                trmTechnology.setIsActive("Y");
                commonDao.createEntity(trmTechnology);
            }
        }
        response.setCodeAndMsg("0000", "军民融合需求修改成功！");
        return response;
    }
    
    @Override
    public boolean auditDemand(AuditRequest request) throws Exception {
        
        // 审核时间
        Date auditDate = new Date();
        request.setAuditDate(auditDate);
        
        boolean auditFlag = demandDao.auditDemand(request);
        
        // 插入审核流水
        TrmAuditHistory entity = new TrmAuditHistory();
        // 审核项分类：设备设施1/需求2/技术服务机构3/季报4
        entity.setAuditType("2");
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
    public CommonListResponse<DemandIndex> homeDemands(RequireRequest request) throws BusinessException {
        CommonListResponse<DemandIndex> result = demandDao.homeDemand(request);
        // 信息为空时，抛出异常
        if (result.getList().size() < 1) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("设备列表查询为空！");
            throw bs;
        }
        PolicyComeRequest eq = new PolicyComeRequest();
        for (DemandIndex demandIndex : result.getList()) {
            String serviceRange = demandIndex.getDomain();
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
                demandIndex.setDomain(
                        serviceRange.replace(SystemConstants.SYSTEM_COMMA, SystemConstants.SYSTEM_SEPARATOR));
            }
        }
        
        return result;
    }
    
    /**
     * 首页需求左侧
     * @param comIntData
     * @return
     * @throws BusinessException
     */
    @Override
    public List<CateCountDemand> recentlyMoreDemand(ComIntData comIntData) throws BusinessException {
        return demandDao.recentlyMoreDemand(comIntData);
    }
    
    /**
     * 列表查询
     * @param request
     * @return
     * @throws BusinessException
     */
    @Override
    public CommonListResponse<DemandIndex> findDemand(RequireRequest request) throws BusinessException {
        CommonListResponse<DemandIndex> demand = demandDao.findDemand(request);
        PolicyComeRequest eq = new PolicyComeRequest();
        for (DemandIndex demandIndex : demand.getList()) {
            String serviceRange = demandIndex.getDomain();
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
                demandIndex.setDomain(
                        serviceRange.replace(SystemConstants.SYSTEM_COMMA, SystemConstants.SYSTEM_SEPARATOR));
            }
        }
        return demand;
    }
    
    @Override
    public DemandDetails findDemandDetail(Integer id) throws BusinessException {
        demandDao.addViewCount(id);
        DemandDetails demandDetails = getMyDemandById(id);
        //过滤状态
        /*if (!"F2".equals(demandDetails.getTrmDemand().getAudStatus())) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("军民融合需求不存在！");
            throw bs;
        }*/
        PolicyComeRequest eq = new PolicyComeRequest();
        String serviceRange = demandDetails.getTrmDemand().getDomain();
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
            demandDetails
                    .setDomain(serviceRange.replace(SystemConstants.SYSTEM_COMMA, SystemConstants.SYSTEM_SEPARATOR));
        }
        return demandDetails;
    }
    
    /**
     * 查询访问量倒序
     * @param request
     * @return
     * @throws BusinessException
     */
    @Override
    public CommonListResponse<DemandIndex> findHotDemand(RequireRequest request) throws BusinessException {
        CommonListResponse<DemandIndex> hotDemand = demandDao.findHotDemand(request);
        PolicyComeRequest eq = new PolicyComeRequest();
        for (DemandIndex demandIndex : hotDemand.getList()) {
            String serviceRange = demandIndex.getDomain();
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
                demandIndex.setDomain(
                        serviceRange.replace(SystemConstants.SYSTEM_COMMA, SystemConstants.SYSTEM_SEPARATOR));
            }
        }
        return hotDemand;
    }
    
    /**
     * an天查询
     * @param equipDayReq
     * @return
     * @throws BusinessException
     */
    @Override
    public CommonListResponse<DemandIndex> findDemandByDay(EquipDayReq equipDayReq) throws BusinessException {
        CommonListResponse<DemandIndex> demandByDay = demandDao.findDemandByDay(equipDayReq);
        PolicyComeRequest eq = new PolicyComeRequest();
        for (DemandIndex demandIndex : demandByDay.getList()) {
            String serviceRange = demandIndex.getDomain();
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
                demandIndex.setDomain(
                        serviceRange.replace(SystemConstants.SYSTEM_COMMA, SystemConstants.SYSTEM_SEPARATOR));
            }
        }
        return demandByDay;
    }

    @Override
    public CommonListResponse<TrmDemand> findList(String startTime, String endTime) {
        return demandDao.findList(startTime, endTime);
    }

}
