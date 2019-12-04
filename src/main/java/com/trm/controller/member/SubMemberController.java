package com.trm.controller.member;


import java.io.IOException;
import java.util.Map;

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

import com.trm.constants.SystemConstants;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonResponse;
import com.trm.model.common.FindDetailsById;
import com.trm.model.member.SubMemListDetail;
import com.trm.model.member.SubMemListRequest;
import com.trm.model.member.SubMemListResponse;
import com.trm.model.member.SubMemberDetail;
import com.trm.service.member.MemberService;
import com.trm.util.LoginCheckUtil;
import com.trm.util.SessionUtil;

/**
 * 个人中心-用户创建子用户基本信息
 * @author zhaosimiao
 * @Date 2017-10-10 13:36:36
 */
@Controller
@RequestMapping("/personal/center")
public class SubMemberController {

    public static Logger logger = LoggerFactory.getLogger(SubMemberController.class);

    @Autowired
    private MemberService memberService;
    
    @Autowired
    private LoginCheckUtil loginCheckUtil;

    @RequestMapping(value = "/getUsersList", method = RequestMethod.POST)
    @ResponseBody
    public SubMemListResponse<SubMemListDetail> getUsersList(@Valid @RequestBody SubMemListRequest request, HttpServletRequest requests, HttpServletResponse response) throws BusinessException, IOException {
    	Integer userId = SessionUtil.getUserIdFromSession();
    	// 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, requests, response);
    	if(null == userId) {
    		BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.FRONT_USER_NOT_LOGIN);
            bs.setExceptionMsg("用户未登录！");
            throw bs;
    	}
    	else {
    		request.setMasterId(userId);
    	}
        logger.info("[管理员创建用户]列表查询 request：{}", request.toString());
        SubMemListResponse<SubMemListDetail> list = memberService.getUsersList(request);
        logger.info("[管理员创建用户]列表查询 return：{}", list);
        return list;
    }
    
    @RequestMapping(value = "/getSubMemberById", method = RequestMethod.POST)
    @ResponseBody
    public SubMemberDetail getSubMemberById(@Valid @RequestBody FindDetailsById request) throws BusinessException {
        logger.info("[前台用户详情]查询id为 {}", request.getId());
        SubMemberDetail detail = memberService.getSubMemberById(request.getId());
        logger.info("[前台用户详情]查询 return：{}", detail.toString());
        return detail;
    }
    
    /**
     * 创建子用户
     * @param register
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/createSubMember", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse createSubMember(@Valid @RequestBody SubMemberDetail register, HttpServletRequest request, HttpServletResponse responses) throws Exception {
        loginCheckUtil.checkLoginStatus(SessionUtil.getUserIdFromSession(), request, responses);
        logger.info("[子用户创建提交信息]：", register.toString());
        CommonResponse response = memberService.createSubMember(register);
        logger.info("[子用户创建返回信息]：", response.toString());
        return response;
    }
    
    @RequestMapping(value = "/modifySubMember", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse modifySubMember(@Valid @RequestBody SubMemberDetail register, HttpServletRequest request, HttpServletResponse responses) throws Exception {
    	loginCheckUtil.checkLoginStatus(SessionUtil.getUserIdFromSession(), request, responses);
        logger.info("[子用户修改信息]入参：", register.toString());
        CommonResponse response = memberService.modifySubMember(register);
        logger.info("[子用户修改信息]出参：", response.toString());
        return response;
    }
    
    @RequestMapping(value = "/deleteSubMember", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse deleteSubMember(@RequestBody Map<String, String> request, HttpServletRequest req, HttpServletResponse responses) throws Exception {
    	loginCheckUtil.checkLoginStatus(SessionUtil.getUserIdFromSession(), req, responses);
        logger.info("[子用户删除信息]入参：", request.get("id"));
        CommonResponse response = memberService.deleteSubMember(request.get("id"));
        logger.info("[子用户删除信息]出参：", response.toString());
        return response;
    }
    
    @RequestMapping(value = "/resetPwd", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse resetPwd(@Valid @RequestBody FindDetailsById request) throws BusinessException {
        logger.info("[前台用户详情]查询id为 {}", request.getId());
        CommonResponse response = memberService.resetPwd(request.getId());
        logger.info("[前台用户详情]查询 return：{}", response.toString());
        return response;
    }
    
    @RequestMapping(value = "/checkUser", method = RequestMethod.POST)
    @ResponseBody
    public boolean checkUser(@Valid @RequestBody SubMemberDetail register) throws BusinessException {
        logger.info("[检查用户名是否重复]", register.getUsername());
        boolean user = memberService.checkUser(register.getUsername());
        logger.info("[检查用户名是否重复]", user);
        return user;
    }
    
}
