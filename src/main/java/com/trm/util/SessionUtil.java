package com.trm.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import com.trm.model.session.SessionBean;
import com.trm.model.session.UserSession;

/**
* @description get use session related info
* @author Vani
* @Time 2016年8月9日
*/
public class SessionUtil {
	
	public static UserSession getUserSession() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		// TODO
		if (null != authentication && null != authentication.getPrincipal() ) {
			Object principal = authentication.getPrincipal(); 
			if (principal instanceof UserSession) {
				final UserSession session = (UserSession) principal;
				return session;
			}
		} 
		
		return null;
	}
	
	/**
	 * 方法功能说明：  前端用户登录，更新
	 * @参数： @param userSession
	 * @参数： @param request      
	 * @return void     
	 * @throws
	 */
	public static void memberUpdateSession(UserSession userSession, HttpServletRequest request) {

		PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(
				userSession, userSession.getPassword(), userSession.getAuthorities());
		if (request != null) {
			authentication.setDetails(new WebAuthenticationDetails(request));
		}
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
	}
	
	public static SessionBean getSesssionBean() {
		UserSession	userSession = SessionUtil.getUserSession();
		return null != userSession ? userSession.getSession() : null;
	}
	
	public static Integer getUserIdFromSession(){
		SessionBean session = getSesssionBean();
		return null != session ? session.getId() : null;
	}
	
	public static String getUsernameFromSession(){
		SessionBean session = getSesssionBean();
		return null != session ? session.getUsername() : null;
	}
	
	public static String getHeadPortraitFromSession(){
		SessionBean session = getSesssionBean();
		return null != session ? session.getHeadPortrait() : null;
	}
	
	public static void setHeadPortraitFromSession(String headPortrait){
		SessionBean session = getSesssionBean();
		session.setHeadPortrait(headPortrait);
	}
	
	public static String getUserTypeFromSession(){
		SessionBean session = getSesssionBean();
		return null != session ? session.getUserType() : null;
	}
	
	public static Integer getUnitIdFromSession(){
		SessionBean session = getSesssionBean();
		return null != session ? session.getUnitId() : null;
	}
	
	public static String getAddressFromSession(){
		SessionBean session = getSesssionBean();
		return null != session ? session.getAddress() : null;
	}
	
	public static String getDepartmentFromSession(){
		SessionBean session = getSesssionBean();
		return null != session ? session.getDepartment() : null;
	}
	
	public static String getPasswordFromSession(){
		SessionBean session = getSesssionBean();
		return null != session ? session.getPassword() : null;
	}
}
