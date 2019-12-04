package com.trm.controller.member;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonResponse;
import com.trm.model.member.MemberDetail;
import com.trm.model.member.MyCase;
import com.trm.service.member.MemberService;
import com.trm.util.LoginCheckUtil;
import com.trm.util.SessionUtil;

/**
 * 个人中心-基本信息
 * @author zhaosimiao
 * @Date 2017-10-10 13:36:36
 */
@Controller
@RequestMapping("/personal/center")
public class MemberController {

    public static Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService memberService;
    @Autowired
    private LoginCheckUtil loginCheckUtil;

    /**
     * 个人中心-信息查询
     * @param request
     * @return
     * @throws BusinessException
     * @throws IOException 
     */
    @RequestMapping(value = "/getUserinfo", method = RequestMethod.POST)
    @ResponseBody
    public MemberDetail getUserinfo(HttpServletRequest request, HttpServletResponse response) throws BusinessException, IOException {
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, request, response);
        logger.info("个人中心-信息查询 getUserinfo，userId = " + userId);
        if(userId == null) {
        	BusinessException e = new BusinessException();
        	e.setBusiException("未登录异常", "用户为空", "ERROR");
        	throw e;
        }
        MemberDetail detail = memberService.getUserinfoById(userId);
        logger.info("个人中心-信息查询 getUserinfo，出参：", detail.toString());
        return detail;
    }

    /**
     * 个人中心-信息修改
     * @param detail
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/changeUserinfo", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse changeUserinfo(@Valid @RequestBody MemberDetail detail) throws Exception {
        logger.info("个人中心-信息修改 changeUserinfo", detail.toString());
        String username = SessionUtil.getUsernameFromSession();
        logger.info("个人中心-信息查询 changeUserinfo，username = " + username);
        if(StringUtils.isEmpty(username)) {
        	BusinessException e = new BusinessException();
        	e.setBusiException("未登录异常", "用户名为空", "ERROR");
        	throw e;
        }
        // 用户名前端可不传
        detail.setUsername(username);
        Integer userId = SessionUtil.getUserIdFromSession();
        detail.setId(userId);
        CommonResponse response = memberService.changeUserinfo(detail);
        logger.info("个人中心-信息修改 changeUserinfo，出参：", response.toString());
        return response;
    }
    
    /**
     * 我的设备  关注  评论  消息统计
     * @param request
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/getMyCases", method = RequestMethod.POST)
    @ResponseBody
    public List<MyCase> getMyCases(HttpServletRequest request) throws BusinessException {
        Integer userId = SessionUtil.getUserIdFromSession();
        logger.info("个人中心-首页信息统计 getMyCases，userId = " + userId);
        if(userId == null) {
        	BusinessException e = new BusinessException();
        	e.setBusiException("未登录异常", "用户为空", "ERROR");
        	throw e;
        }
        List<MyCase> myCaseList = memberService.getMyCases(userId);
        logger.info("个人中心-首页信息统计 getMyCases，出参：", myCaseList);
        return myCaseList;
    }
    
    /**
     * 首页当日登录用户数 用户数 设备 需求
     * @param request
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/getCases", method = RequestMethod.POST)
    @ResponseBody
    public List<MyCase> getCases(HttpServletRequest request) throws BusinessException {
        logger.info("个人中心-首页信息统计 getCases");
        List<MyCase> casesList = memberService.getCases();
        logger.info("个人中心-首页信息统计 getCases，出参：", casesList);
        return casesList;
    }
    
}
