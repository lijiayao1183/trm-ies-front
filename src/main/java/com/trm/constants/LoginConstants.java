package com.trm.constants;

public class LoginConstants {
	
	private LoginConstants(){}
	
	public static String cInteUrl;
	public static String domain;	
	public static String cInterPathBdc;	
	public static void setcInterPathBdc(String cInterPathBdc) {
		LoginConstants.cInterPathBdc = cInterPathBdc;
	}
	public static void setcInteUrl(String cInteUrl) {
		LoginConstants.cInteUrl = cInteUrl;
	}
	public static void setDomain(String domain) {
		LoginConstants.domain = domain;
	}
	
	// 虚拟币收入
	public final static String INCOME_COIN = "INCOME";
	
	// 每日首次登录加+20金币
	public final static int LOGIN_INCREASE_COIN = 20; 
	
	// 每日首次登录 C段自动添加该字段  传空
	public final static String LOGIN_INCREASE_COIN_DESC = "";
	
	public final static String FRONT_USER = "front";
	
	// C段定义COOKIE名称
	public static final String C_COOKIE_NAME = "SSOTOKEN";
	// 同一级域名才可共享cookie
	public static final String C_COOKIE_DOMAIN = ".iptrm.com";
	// cookie生命周期
	// public static final int C_COOKIE_MAXAGE = 600;
	// public static final int C_COOKIE_MAXAGE = -1;
	// cookie生命周期2小时
	public static final int C_COOKIE_MAXAGE = 7200;
	
	public final static String LOCAL_INIT_PAGE = "/views/content/login/front/login.jsp";
	public final static String DEFAULT_HEAD_PIC = "/trm-common-service-oss/oss/trading/pic/default_user_headPic.png";
	public final static String IPTRM_HOME_PAGE = "http://www.iptrm.com";
	
}
