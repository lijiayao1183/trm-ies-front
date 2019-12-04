package com.trm.controller.report;

import com.trm.model.common.CommonListResponse;
import com.trm.model.common.CommonResponse;
import com.trm.model.common.FindDetailsById;
import com.trm.model.report.ReportDetail;
import com.trm.model.report.ReportListDetail;
import com.trm.model.report.ReportRequest;
import com.trm.service.report.ReportService;
import com.trm.util.LoginCheckUtil;
import com.trm.util.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * 线下报表统计
 * @author zhaosimiao 2017-12-12 15:02:13
 */
@Controller
@RequestMapping("/")
public class ReportController {
    
    public static Logger logger = LoggerFactory.getLogger(ReportController.class);
    
    @Autowired
    private ReportService reportService;
    
    @Autowired
    private LoginCheckUtil loginCheckUtil;
    
    @RequestMapping(value = "/getMyReports", method = RequestMethod.POST)
    @ResponseBody
    public CommonListResponse<ReportListDetail> getMyReports(@Valid @RequestBody ReportRequest request,
            HttpServletRequest req, HttpServletResponse resp) throws Exception {
        logger.info("[报表]个人中心我的列表查询 request：{}", request);
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, req, resp);
        
        request.setUserId(userId);
        CommonListResponse<ReportListDetail> list = reportService.getMyReports(request);
        logger.info("[报表]个人中心我的列表查询 return：{}", list);
        return list;
    }
    
    @RequestMapping(value = "/getReportById", method = RequestMethod.POST)
    @ResponseBody
    public ReportDetail getReportById(@Valid @RequestBody FindDetailsById request, HttpServletRequest req,
            HttpServletResponse resp) throws Exception {
        logger.info("[线下报表统计详情]个人中心查询id为 {}", request.getId());
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, req, resp);
        ReportDetail detail = reportService.getReportById(request.getId());
        logger.info("[线下报表统计详情]个人中心查询 return：{}", detail.toString());
        return detail;
    }
    
    @RequestMapping(value = "/createReport", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse createReport(@Valid @RequestBody ReportDetail detail, HttpServletRequest req,
            HttpServletResponse resp) throws Exception {
        logger.info("[新增线下报表统计信息] request：{}", detail);
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, req, resp);
        CommonResponse response = reportService.createReport(detail);
        logger.info("[新增线下报表统计信息] return：{}", response);
        return response;
    }
    
    @RequestMapping(value = "/updateReport", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse updateReport(@Valid @RequestBody ReportDetail detail, HttpServletRequest req,
            HttpServletResponse resp) throws Exception {
        logger.info("[更新线下报表统计信息] request：{}", detail);
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, req, resp);
        CommonResponse response = reportService.updateReport(detail);
        logger.info("[更新线下报表统计信息] return：{}", response);
        return response;
    }
    
}
