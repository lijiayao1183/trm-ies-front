package com.trm.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.trm.constants.SystemConstants;
import com.trm.entity.exception.WebAuthException;
import com.trm.util.SessionUtil;

@Repository
public class LoginInterceptor extends HandlerInterceptorAdapter {

	public static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	// 还没发现可以直接配置不拦截的资源，所以在代码里面来排除  
	public String[] allowUrls;
	  
    public void setAllowUrls(String[] allowUrls) {  
        this.allowUrls = allowUrls;  
    }  

	/**
	 * preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用。
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestUrl = request.getRequestURI().replace(request.getContextPath(), "");  
//      System.out.println(requestUrl);  
        if (null != allowUrls && allowUrls.length >= 1)  
            for (String url : allowUrls) {  
                if (requestUrl.contains(url)) {  
                    return true;  
                }  
            }  
        String username = SessionUtil.getUsernameFromSession();
        
		if (null == username) {
			response.sendRedirect("/views/content/login/front/login.jsp");
			WebAuthException wae = new WebAuthException();
			wae.setDesc("用户未登录！");
			wae.setReasoncode(SystemConstants.FRONT_USER_NOT_LOGIN);
			throw wae;
		} else {
			return true;
		}
	}

	/**
	 * 这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行。
	 * postHandle是进行处理器拦截用的，它的执行时间是在处理器进行处理之 后，
	 * 也就是在Controller方法调用后执行，但是会在DispatcherServlet进行视图的渲染之前执行.
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。
	 * 该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行，主要是用来清理释放资源的
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
}
