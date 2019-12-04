package com.trm.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.trm.constants.LoginConstants;
import com.trm.dao.member.MemberDao;
import com.trm.entity.TrmMember;
import com.trm.entity.exception.BusinessException;

@Component("loginCheckUtil")
@Transactional(rollbackFor = Exception.class)
public class LoginCheckUtil {
	
	@Autowired
	private MemberDao memberDao;
	
	public void checkLoginStatus(Integer userId, HttpServletRequest request, HttpServletResponse response) throws BusinessException, IOException {
		
		if (null == userId) {
			// 用户未登录，跳转至登录页
			response.sendRedirect(request.getContextPath() + LoginConstants.LOCAL_INIT_PAGE);
			return;
        }
		
		TrmMember entity = memberDao.getUserinfo(userId);
		String password = entity.getPassword();
		if(StringUtils.isEmpty(password)) {
			// 用户登录，但账号被冻结
			// 1. 清空session
			SecurityContext context = SecurityContextHolder.getContext();
			context.setAuthentication(null);
			SecurityContextHolder.clearContext();
	
			// 2. 跳转
			response.sendRedirect(request.getContextPath() + LoginConstants.LOCAL_INIT_PAGE);
		}
	}
	
	/**
	 * add by zhaosimiao 2018-8-23 14:47:06
	 * 个人中心信息修改增加安全校验
	 * @param loginUserId 实际已登录用户id
	 * @param paraUserId 提交待修改的设备、需求、机构等信息中包含的用户id
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void matchingUserId(Integer loginUserId, Integer paraUserId, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		if(loginUserId.intValue() == paraUserId.intValue()) {
			return;
		}
		else {
			// 1. 清空session
			SecurityContext context = SecurityContextHolder.getContext();
			context.setAuthentication(null);
			SecurityContextHolder.clearContext();
	
			// 2. 跳转
			response.sendRedirect(request.getContextPath() + LoginConstants.LOCAL_INIT_PAGE);
		}
	}
}
