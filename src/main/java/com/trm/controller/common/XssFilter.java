package com.trm.controller.common;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

/**
* @description XSS Risk Defend
* @author Vani
* @Time 2016年8月4日
*/
public class XssFilter implements Filter {


	/** the tool property which get filter parameter */
	protected FilterConfig filterConfig;

	/** define all URLs which do not need to filter XSS risk */
	private String notFilterUrl;

	/** define sensitive words in system */
	private String illegalString;

	/** the switch if XSS effective for this filter */	
	private String xssFilterFlag;
	
	/** the switch if CSRF effective for this filter */	
	private String csrfFilterFlag;
	
	/** the page system forward to when risk found */
	private String riskForwardPage;
	
	/** trusted domain list */
	private static final String[] TRUSTED_DOMAIN= {
		"localhost"
	};
	
	private static final String FLAG_TRUE = "true";

	public void destroy() {
	}

	/**  
	 * @description：  XSS and CSRF risk scan
	 * @param： request	get URL and parameters for current request
	 * @param： response	go ahead filter system
	 * @param： filter	go ahead filter system
	 * @throws  
	 */ 	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter) throws IOException,
			ServletException {
		
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest)request;

		if (isFilterUrl((HttpServletRequest) request)) {
			// filter url-get param
			String queryString = ((HttpServletRequest) request).getQueryString();
			System.out.println("============queryString========="+queryString);
			queryString = escapeString(queryString);
			System.out.println("============queryString========="+queryString);
			// filter url total param
			String queryStringall = ((HttpServletRequest) request).getRequestURL().toString();
			System.out.println("============queryStringall========="+queryStringall);
			queryStringall = escapeString(queryStringall);
			System.out.println("============queryStringall========="+queryStringall);
			// check URL paramters
			if (queryString != null && !queryString.trim().equals("") && !URLCheck(queryString)) {
				System.out.println("============URLCheck(queryString)========="+URLCheck(queryString));
				processResponse(req, resp);
				return;
			}
			
			// check URI
			if (queryStringall != null && !queryStringall.trim().equals("") && !URLCheck(queryStringall)) {
				System.out.println("============URLCheck(queryStringall)========="+URLCheck(queryStringall));
				processResponse(req, resp);
				return;
			}
			
			// check POST parameters
			@SuppressWarnings("rawtypes")
			Enumeration names = request.getParameterNames();
			while (names.hasMoreElements()) {
				String name = (String) names.nextElement();
				String value = request.getParameter(name);
				value = escapeString(value);
				if (checkIllegalString(value) || !URLCheck(value)) {
					processResponse(req, resp);
					return;
				}
			}
		}
		
		//CSRF scan
		if( null != this.getCsrfFilterFlag() && FLAG_TRUE.equals(this.getCsrfFilterFlag()) ){
			String referer = req.getHeader("referer");
			if( null != referer && !this.isInTrustedDomainList(referer) ){
				processResponse(req, resp);
				return;
			}	
		}
		
		filter.doFilter(request, response);
	}
	
	public void processResponse(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		resp.sendRedirect(req.getContextPath() + this.getRiskForwardPage());
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		this.setFilterConfig(arg0);
		this.setNotFilterUrl(this.filterConfig.getInitParameter("notFilterUrl"));
		this.setIllegalString(filterConfig.getInitParameter("illegalString"));
		this.setXssFilterFlag(filterConfig.getInitParameter("xssFilterFlag"));
		this.setRiskForwardPage(filterConfig.getInitParameter("riskForwardPage"));
		this.setCsrfFilterFlag(filterConfig.getInitParameter("csrfFilterFlag"));
	}

	/**
	 * filter ' " $ > < ( )
	 * @param queryString
	 * @return
	 */
	public boolean URLCheck(String queryString) {

		boolean flag = true;
		if (queryString != null && !queryString.equals("")) {
			if (queryString.indexOf("'") > -1 || queryString.indexOf("%27") > -1
					|| // '
					queryString.indexOf(" ") > -1 || queryString.indexOf("%20") > -1
					|| //  
					queryString.indexOf("\"") > -1 || queryString.indexOf("%22") > -1
					|| // "
					queryString.indexOf("$") > -1 || queryString.indexOf("%24") > -1
					|| // $
					queryString.indexOf(">") > -1 || queryString.indexOf("%3E") > -1 || queryString.indexOf("%3e") > -1
					|| // >
					queryString.indexOf("<") > -1 || queryString.indexOf("%3c") > -1 || queryString.indexOf("%3C") > -1 // <
			)
				flag = false;
		}
		return flag;
	}

	/**
	 * 判断是否需要对当前url 进行过滤
	 */
	private boolean isFilterUrl(HttpServletRequest req) {
		String uriStr = StringUtils.substringAfterLast(req.getServletPath(), "/");
		if (notFilterUrl != null && notFilterUrl.indexOf(uriStr.toLowerCase()) > -1) {
			return false;
		}
		return true;
	}

	/**
	 * 判断是否存在敏感关键字
	 * 
	 * @param queryString
	 * @return
	 */
	private boolean checkIllegalString(String queryString) {
		// 包含信息
		if (illegalString != null && !illegalString.equals("")) {
			String[] illegal = illegalString.split(",");
			for (int i = 0; i < illegal.length; i++) {
				if (queryString.toLowerCase().indexOf(illegal[i]) > -1) {
					return true;
				}
			}
		}
		return false;
	}

	private String escapeString(String value) {
		return escapeString(value, null, null);
	}

	/**
	 * 对当前s 转义 目前只支持 “(” 转义成 &#x28; “)” 转义成 &#x29;
	 * 
	 * @param s
	 * @return
	 */
	private String escapeString(String value, String name, HttpServletRequest req) {
		if (value == null || value.equals("")) {
			return value;
		}
		if (this.getXssFilterFlag() != null && !this.getXssFilterFlag().equals("")
				&& this.getXssFilterFlag().equals("true")) {
			if (value.indexOf("(") > -1 || value.indexOf("%28") > -1) {
				value = value.replaceAll("\\(", "&#x28;").replaceAll("%28", "&#x28;");
			}
			if (value.indexOf(")") > -1 || value.indexOf("%29") > -1) {
				value = value.replaceAll("\\)", "&#x29;").replaceAll("%29", "&#x29;");
			}
			if (req != null) {
				req.setAttribute(name, value);
			}
			return value;
		} else {
			return value;
		}
	}
	
	private boolean isInTrustedDomainList(String referer){
		for( String domain : TRUSTED_DOMAIN ){
			if( referer.indexOf(domain) > -1  ){
				return true;
			}
		}
		return false;
	}

	public FilterConfig getFilterConfig() {
		return filterConfig;
	}

	public void setFilterConfig(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}

	public String getNotFilterUrl() {
		return notFilterUrl;
	}

	public void setNotFilterUrl(String notFilterUrl) {
		this.notFilterUrl = notFilterUrl;
	}

	public String getIllegalString() {
		return illegalString;
	}

	public void setIllegalString(String illegalString) {
		this.illegalString = illegalString;
	}

	public String getXssFilterFlag() {
		return xssFilterFlag;
	}

	public void setXssFilterFlag(String xssFilterFlag) {
		this.xssFilterFlag = xssFilterFlag;
	}

	public String getRiskForwardPage() {
		return riskForwardPage;
	}

	public void setRiskForwardPage(String riskForwardPage) {
		this.riskForwardPage = riskForwardPage;
	}

	public String getCsrfFilterFlag() {
		return csrfFilterFlag;
	}

	public void setCsrfFilterFlag(String csrfFilterFlag) {
		this.csrfFilterFlag = csrfFilterFlag;
	}



}
