package com.trm.authentication;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

@WebFilter(filterName="sessionTimeoutFilter", 
urlPatterns={
		"/views/content/comment/ucenter/*",
		"/views/content/equipment/ucenter/*",
		"/views/content/follow/ucenter/*",
		"/views/content/personal/ucenter/*",
		"/views/content/demand/ucenter/*",
		"/views/content/usermgt/ucenter/*",
		"/views/content/interaction/front/srchlist.jsp",
		"/views/content/interaction/ucenter/*",
		"/views/content/quarterly/ucenter/*",
		"/views/content/laboratory/ucenter/*"})

public class SessionTimeoutFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		// 判断session信息
		HttpSession httpSession = httpRequest.getSession();
		SecurityContext ctx = (SecurityContext) httpSession
                .getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
		if(null != ctx) {
			chain.doFilter(request, response);
			return;
		}
		else {
			httpResponse.sendRedirect("/views/content/login/front/login.jsp");
		}
	}

	@Override
	public void destroy() {
	}
	
}
