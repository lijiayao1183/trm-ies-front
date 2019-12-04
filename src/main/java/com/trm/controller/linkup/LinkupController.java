package com.trm.controller.linkup;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trm.model.common.CommonListResponse;
import com.trm.model.common.CommonResponse;
import com.trm.model.common.FindDetailsById;
import com.trm.model.linkup.LinkupDetail;
import com.trm.model.linkup.LinkupDetailResponse;
import com.trm.model.linkup.LinkupListDetail;
import com.trm.model.linkup.LinkupRequest;
import com.trm.model.linkup.LinkupSimBack;
import com.trm.service.linkup.LinkupService;
import com.trm.util.LoginCheckUtil;
import com.trm.util.SessionUtil;

/**
 * 互动交流
 * @author zhaosimiao 2017-12-12 15:02:13
 */
@Controller
@RequestMapping("/")
public class LinkupController {

    public static Logger logger = LoggerFactory.getLogger(LinkupController.class);

    @Autowired
    private LinkupService linkupService;

    @Autowired
    private LoginCheckUtil loginCheckUtil;
    
    @RequestMapping(value = "/findLinkups", method = RequestMethod.POST)
    @ResponseBody
    public CommonListResponse<LinkupListDetail> findLinkups(@Valid @RequestBody LinkupRequest request,
    		HttpServletRequest req, HttpServletResponse resp) throws Exception {
    	Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, req, resp);
        logger.info("[互动交流列表]列表查询 request：{}", request);
        CommonListResponse<LinkupListDetail> list = linkupService.findLinkups(request);
        logger.info("[互动交流列表]列表查询 return：{}", list);
        return list;
    }
    
    @RequestMapping(value = "/findLinkupById", method = RequestMethod.POST)
    @ResponseBody
    public LinkupDetailResponse findLinkupById(@Valid @RequestBody FindDetailsById request,
    		HttpServletRequest req, HttpServletResponse resp) throws Exception {
        logger.info("[互动交流详情]列表页详情查询id为 {}", request.getId());
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, req, resp);
        LinkupDetailResponse detail = linkupService.getLinkup(request.getId());
        logger.info("[互动交流详情]列表页详情查询 return：{}", detail.toString());
        return detail;
    }
    
    @RequestMapping(value = "/getMyLinkups", method = RequestMethod.POST)
    @ResponseBody
    public CommonListResponse<LinkupListDetail> getMyLinkups(@Valid @RequestBody LinkupRequest request,
    		HttpServletRequest req, HttpServletResponse resp) throws Exception {
        logger.info("[互动交流列表]个人中心我的列表查询 request：{}", request);
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, req, resp);
        
        request.setUserId(userId);
        CommonListResponse<LinkupListDetail> list = linkupService.getMyLinkups(request);
        logger.info("[互动交流列表]个人中心我的列表查询 return：{}", list);
        return list;
    }

    @RequestMapping(value = "/getLinkup", method = RequestMethod.POST)
    @ResponseBody
    public LinkupDetailResponse getLinkup(@Valid @RequestBody FindDetailsById request,
    		HttpServletRequest req, HttpServletResponse resp) throws Exception {
        logger.info("[互动交流详情]个人中心查询id为 {}", request.getId());
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, req, resp);
        LinkupDetailResponse detail = linkupService.getLinkup(request.getId());
        logger.info("[互动交流详情]个人中心查询 return：{}", detail.toString());
        return detail;
    }
    
    @RequestMapping(value = "/getMySimBack", method = RequestMethod.POST)
    @ResponseBody
    public LinkupSimBack getMySimBack(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Integer userId = SessionUtil.getUserIdFromSession();
        logger.info("[互动交流详情]个人中心查询id为 {}", userId);
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, req, resp);
        LinkupSimBack detail = linkupService.getMySimBack(userId);
        logger.info("[互动交流详情]个人中心查询 return：{}", detail.toString());
        return detail;
    }
    
    @RequestMapping(value = "/createLinkup", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse createLinkup(@Valid @RequestBody LinkupDetail detail,
    		HttpServletRequest req, HttpServletResponse resp) throws Exception {
        logger.info("[新增互动交流信息] request：{}", detail);
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, req, resp);
        CommonResponse response = linkupService.createLinkup(detail);
        logger.info("[新增互动交流信息] return：{}", response);
        return response;
    }

}
