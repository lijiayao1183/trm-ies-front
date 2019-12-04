package com.trm.trmserver.controller;

import com.alibaba.fastjson.JSON;
import com.trm.entity.TrmDemand;
import com.trm.entity.TrmEquip;
import com.trm.entity.TrmTechServOrg;
import com.trm.entity.TrmUnit;
import com.trm.model.common.CommonListResponse;
import com.trm.model.equip.EquipDetail;
import com.trm.service.equip.EquipService;
import com.trm.service.member.UnitService;
import com.trm.service.require.DemandService;
import com.trm.service.techservorg.TechServOrgService;
import com.trm.trmserver.model.ServiceRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/")
public class DataSyncController {

    private static final Logger logger = LoggerFactory.getLogger(DataSyncController.class);

    @Autowired
    private DemandService demandService;

    @Autowired
    private EquipService equipService;

    @Autowired
    private TechServOrgService techServOrgService;

    @Autowired
    private UnitService unitService;

    @RequestMapping(value = "/demand/findList")
    public CommonListResponse<TrmDemand> demand(HttpServletRequest request) throws Exception {
        ServiceRequest srequest = JSON.parseObject(request.getAttribute("myJsonObject").toString(), ServiceRequest.class);
        String startDate = srequest.getStartDate();
        String endDate = srequest.getEndDate();
        logger.info("---军民融合需求同步请求---参数接收：同步开始日期:" + startDate + "同步截止日期:" + endDate);
        CommonListResponse<TrmDemand> result = demandService.findList(startDate, endDate);
        logger.info("---军民融合需求同步请求成功---");
        return result;
    }

    @RequestMapping(value = "/equip/findList")
    public CommonListResponse<TrmEquip> equip(HttpServletRequest request) throws Exception {
        ServiceRequest srequest = JSON.parseObject(request.getAttribute("myJsonObject").toString(), ServiceRequest.class);
        String startDate = srequest.getStartDate();
        String endDate = srequest.getEndDate();
        logger.info("---设备设施同步请求---参数接收：同步开始日期:" + startDate + "同步截止日期:" + endDate);
        CommonListResponse<TrmEquip> result = equipService.findList(startDate, endDate);
        logger.info("---设备设施同步请求成功---");
        return result;
    }

    @RequestMapping(value = "/techServOrg/findList")
    public CommonListResponse<TrmTechServOrg> techServOrg(HttpServletRequest request) throws Exception {
        ServiceRequest srequest = JSON.parseObject(request.getAttribute("myJsonObject").toString(), ServiceRequest.class);
        String startDate = srequest.getStartDate();
        String endDate = srequest.getEndDate();
        logger.info("---技术服务机构同步请求---参数接收：同步开始日期:" + startDate + "同步截止日期:" + endDate);
        CommonListResponse<TrmTechServOrg> result = techServOrgService.findList(startDate, endDate);
        logger.info("---技术服务机构同步请求成功---");
        return result;
    }

    @RequestMapping(value = "/unit/findList")
    public CommonListResponse<TrmUnit> unit(HttpServletRequest request) throws Exception {
        ServiceRequest srequest = JSON.parseObject(request.getAttribute("myJsonObject").toString(), ServiceRequest.class);
        String startDate = srequest.getStartDate();
        String endDate = srequest.getEndDate();
        logger.info("---军工企业同步请求---参数接收：同步开始日期:" + startDate + "同步截止日期:" + endDate);
        CommonListResponse<TrmUnit> result = unitService.findList(startDate, endDate);
        logger.info("---军工企业同步请求成功---");
        return result;
    }

}
