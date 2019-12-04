package com.trm.constants;

public class SystemConstants {
	
	public static final String RESPONSECOE_000 = "000";
	public static final String RESPONSECOE_004 = "004";
	public static final String RESPONSECOE_008 = "008";
	public static final String RESPONSECOE_016 = "016";
	//ReasonCode
	public static final String REASONCODE_1001 = "1001";//专利号不可用
	
	public static final String REASONCODE_2048 = "2048";
	public static final String REASONCODE_2068 = "2068";
	public static final String REASONCODE_2088 = "2088";
	
	public static final String REASONCODE_3056 = "3056";
	public static final String REASONCODE_4011 = "4011";
	public static final String REASONCODE_4022 = "4022";
	public static final String REASONCODE_4241 = "4241";
	public final static String TRM_SUCCESS = "success";
	public final static String TRM_ERROR = "error";
	
	public final static String ERROR_TYPE_0 = "0";//表示一般类型的错误
	public final static String ERROR_TYPE_1 ="1";//表示校验类型的错误
	public final static String ERROR_TYPE_2 ="2";//表示权限不够的错误
	public final static String ERROR_TYPE_3 ="3";//表示XSS风险错误
	public final static String ERROR_TYPE_4 ="4";//表示与C标段对接的错误
	
	public final static String DELETE_FLAG_Y = "Y";//表示删除该对象
	public final static String DELETE_FLAG_N = "N";//表示该对象可用
	
	public final static String FLAG_Y = "Y";//表示该对象可用
	public final static String FLAG_N = "N";//表示该对象不可用
	
	public final static String AJAX_INDICATOR = "ajaxIndicator";
	
	public final static String SYSTEM_SEPARATOR = " ";
	public final static String SYSTEM_MINUS = "-";
	public final static String SYSTEM_COMMA = ",";
	
	public static final String FRONT_USER_NOT_LOGIN = "3001"; // 前端用户未登录
	public static final String MGT_USER_NOT_LOGIN = "3002"; // 后端用户未登录
	public static final String FRONT_USER_NOT_LOGIN_3003 = "3003";//未实名认证
	
	public static final String SYNC_md5 = "cf4107f7ba8406abd309a02da3e8c10c2809c971321068f4bb0231fc29b98f7f";
	public static final String SYNC_md52 = "c4ca4238a0b923820dcc509a6f75849b";
	public static final String SYNC_NAME = "syncname"; // 该用户未手机认证
	public static final String SYNC_PASWD = "syncpaswd"; // 该用户未手机认证
	//used in webservice interceptor
	public static final String XML_HEADER = "SoapHeader";
	public static final String XML_AUTHENTICATION = "authentication";
	public static final String XML_TIMESTAMP = "timestamp";
	public static final String XML_LICENSE = "license";
	public static final String XML_SESSIONBEAN ="sessionBean";
	public static final String XML_USERNAME ="username";
	public static final String XML_USERID ="userId";
	public static final String XML_PHONE ="phone";
	public static final String XML_REALNAME = "realName";
	public static final String XML_EMAIL = "email";
	public static final String XML_ENTER_CODE = "enterCode";
	public static final String XML_ENTER_ID = "enterId";
	public static final String XML_SOURCE = "source";
	
	//日期格式
	public static final String DATE_PATTERN= "yyyy-MM-dd";
	public static final String DATE_PATTERN_HH= "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_PATTERN_TWO= "yyyy/MM/dd";
	
	//资质审核code
	
    //申请状态
    //设备-待审核F1;已通过F2;未通过F3;未提交F0;
    public static final String EQUIP_PENDING = "F1";
    public static final String EQUIP_ADOPT = "F2";
    public static final String EQUIP_FAIL = "F3";
    public static final String APPLY_RETURNED = "F0";
}
