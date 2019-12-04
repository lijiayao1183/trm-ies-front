package com.trm.controller.login;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trm.constants.LoginConstants;
import com.trm.entity.exception.BusinessException;
import com.trm.model.login.Login;
import com.trm.model.login.LoginResponse;
import com.trm.service.login.LoginService;
import com.trm.util.SessionUtil;

/**
 * @description 用户登录
 * @author zhaosimiao 
 * @date 2017-9-28 10:12:16
 */
@Controller
@RequestMapping("/")
public class LoginController {
	
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;

	/**
	 * 登录
	 * @param login 登录入参
	 * @param request
	 * @param response
	 * @return
	 * @throws BusinessException
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public LoginResponse login(@RequestBody Login login, HttpServletRequest request, HttpServletResponse response)
			throws BusinessException {
		logger.info("登录login，入参：" + login.getUsername());
		LoginResponse loginReturn = loginService.login(login, request, response);
		logger.info("登录login，返回：" + loginReturn.toString());
		return loginReturn;
	}
	
	/**
	 * 登录状态检测
	 * @return
	 * @throws BusinessException
	 */
	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	@ResponseBody
	public LoginResponse checkLogin()
			throws BusinessException {
		LoginResponse response = new LoginResponse();
		String username = SessionUtil.getUsernameFromSession();
		String headPortrait = SessionUtil.getHeadPortraitFromSession();
		String userType = SessionUtil.getUserTypeFromSession();
		Integer unitId = SessionUtil.getUnitIdFromSession();
		String address = SessionUtil.getAddressFromSession();
		String department = SessionUtil.getDepartmentFromSession();
		
		if(StringUtils.isNotEmpty(username)) {
			response.setCodeAndMsg("0000", "账号" + username + "已登录！");
			response.setUsername(username);
			response.setHeadPortrait(headPortrait);
			response.setUserType(userType);
			response.setUnitId(unitId);
			response.setAddress(address);
			response.setDepartment(department);
		}
		else {
			response.setCodeAndMsg("9999", "未登录状态！");
		}
		
		logger.info("验证登录checkLogin，返回 username = " + username);
		return response;
	}
	
	/**
	 * 登出
	 * @param request
	 * @param response
	 * @throws BusinessException
	 * @throws IOException 
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	public void logout(HttpServletRequest request, HttpServletResponse response) throws BusinessException, IOException {
		
		// 1. 清空session
		SecurityContext context = SecurityContextHolder.getContext();
		context.setAuthentication(null);
		SecurityContextHolder.clearContext();

		// 2. 跳转
		response.sendRedirect(request.getContextPath() + LoginConstants.LOCAL_INIT_PAGE);
	}
}
