package com.trm.constants;

import java.util.HashMap;
import java.util.Map;

public class BusinessConstants {
	
	public final static String NEWSCODE_PREFIX = "NEWS";
	public final static String KEYCODE_PREFIX = "KEY";
	public final static String RESUMECODE_PREFIX = "RES";
	public final static String POSITIONCODE_PREFIX = "POS";
	public final static String POSITION_RESPONSE_CODE_PREFIX = "PS";
	public final static String POSITION_REQUIRE_CODE_PREFIX = "PQ";
	public final static String appId = "wxc15a61f0303f62c7";
	public final static String appSecret = "eb14be1631cf91c842b7107b0e520609";
	//portalsite 项目，上传下载文件的Key,这个值要和/portalsite/trmTradingConfig.properties保持一致.
	public final static String NEW_IMG = "portalImgNews";
	public final static String RESUME_IMG = "portalImgResume";
	
	
	//project 标示
	public static final String PROJECT_TRADING = "TRMTRADING";
	//project 数组
	public static final String[] PROJECT_ARRAY = {"TRMTRADING"};
	//project对应配置的位置
	public static final Map<String, String> PROJECT_CONFIG_MAP = new HashMap<String, String>();
	static{
		PROJECT_CONFIG_MAP.put(PROJECT_TRADING, "trade");
	}
	//操作日志
	//公用模块
	public final static String STATUS_0 = "0";
	public final static String STATUS_1 = "1";
	public final static String OPER_ADD = "新增";
	public final static String OPER_DEL = "删除";
	public final static String OPER_MOD = "修改";
	public final static String MODULE_1001 = "友情链接";
	public final static String MODULE_1002 = "统计图表";
	public final static String MODULE_1003 = "新闻资讯";
	public final static String MODULE_1004 = "数据统计";
	public final static String MODULE_1005 = "数据字典";
	//首页模块

	public final static String MODULE_0101 = "首页轮播图";
	public final static String MODULE_0102 = "业务在线";
	public final static String MODULE_0103 = "行业专家";
	public final static String MODULE_0104 = "中介结构";
	public final static String MODULE_0105 = "高等院校";
	public final static String MODULE_0106 = "科研院所";
	public final static String MODULE_0107 = "科技企业";
	public final static String MODULE_0108 = "科技服务";
	
	//关于我们
	public final static String MODULE_0901 = "业务内容";
	//设备共享
	public final static String MODULE_0301 = "检测中心/检测机构";
	public final static String MODULE_0302 = "设备信息";
	public final static String MODULE_0303 = "设备需求";
	//创图在线
	public final static String MODULE_0501 = "创业专家";
	public final static String MODULE_0502 = "众创空间";
	public final static String MODULE_0503 = "人才推介";
	
	//科技政策
	public final static String MODULE_0401 = "活动通知";
	public final static String MODULE_0402 = "申报流程";
	public final static String MODULE_0403 = "科技政策";
	public final static String MODULE_0404 = "活动回顾";
	
	//技术交易
	public final static String MODULE_0201 = "已交易项目";
	public final static String MODULE_0202 = "技术需求";
	public final static String MODULE_0203 = "优秀技术经理人单位";
	public final static String MODULE_0204 = "挂牌项目";
	
	//数据库名称
    //公用模块
	public final static String TrmFriendlyLinker = "TrmFriendlyLinker";
	public final static String TrmNewsMultiple = "TrmNewsMultiple";
	public final static String TrmStatisticsInfo = "TrmStatisticsInfo";
	public final static String TrmSysData = "TrmSysData";
	////首页
	public final static String TrmAmazingSlider = "TrmAmazingSlider";
	public final static String TrmBusinessOnline = "TrmBusinessOnline";
	public final static String TrmIndustryExpert = "TrmIndustryExpert";
	public final static String TrmIntermediaryOrg = "TrmIntermediaryOrg";
	public final static String TrmOrdinaryColleges = "TrmOrdinaryColleges";
	public final static String TrmResearchInstitution = "TrmResearchInstitution";
	public final static String TrmTechnologyEnterprise = "TrmTechnologyEnterprise";
	public final static String TrmTechnologyServices = "TrmTechnologyServices";
	
	//关于我们
	public final static String TrmBusinessIntroduction = "TrmBusinessIntroduction";
	//设备共享
	public final static String TrmDeviceDetectionOrg = "TrmDeviceDetectionOrg";
	public final static String TrmDeviceInfo = "TrmDeviceInfo";
	public final static String TrmDeviceRequirement = "TrmDeviceRequirement";
	//创图在线
	public final static String TrmInnovateExpert = "TrmInnovateExpert";
	public final static String TrmInnovateInterspace = "TrmInnovateInterspace";
	public final static String TrmInnovateTalent = "TrmInnovateTalent";
	//科技政策
	public final static String TrmTechnologyActivity = "TrmTechnologyActivity";
	public final static String TrmTechnologyDeclare = "TrmTechnologyDeclare";
	public final static String TrmTechnologyPolicy = "TrmTechnologyPolicy";
	public final static String TrmActivityReview = "TrmActivityReview";
	//技术交易
	public final static String TrmTradeComplete = "TrmTradeComplete";
	public final static String TrmTradelDemand = "TrmTradelDemand";
	public final static String TrmHandlerUnit = "TrmHandlerUnit";
	public final static String TrmTradeListing = "TrmTradeListing";
	
}
