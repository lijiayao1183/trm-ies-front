package com.trm.constants;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CommonTradingConstants {
	//服务码
	public final static String SERVICE_CODE_PREFIX ="SERVICE";
	public final static String TRADEMARK_CODE_PREFIX ="TRADEMARK";
	public final static String REQ_TRADEMARK_CODE_PREFIX ="REQTRADEMARK";
	public final static String PATENT_CODE_PREFIX ="PATENT";
	public final static String REQ_PATENT_CODE_PREFIX ="REQPATENT";
	public final static String TECH_CODE_PREFIX ="TECH";
	public final static String REQ_TECH_CODE_PREFIX ="REQTECH";
	public final static String PUBLISH_FLOW_CODE_PREFIX = "PUBFLOW";
	public final static String RECRUITMENT_CODE_PREFIX ="RECRUITMENT";
	public final static String INFOANDNOTICE_CODE_PREFIX ="INFOANDNOTICE";
	public final static String STORECODE_CODE_PREFIX ="STORE";
	public final static String ADDRESSCODE_CODE_PREFIX ="ADDRESS";
	public final static String ORDERCODE_CODE_PREFIX ="D";
	public final static String COLLECTION_CODE_PREFIX="COLLECT";
	public final static String BID_CODE_PREFIX="BID";
	public final static String ATTACH_CODE_PREFIX ="ATTACH";
	public final static String VALUA_CODE_PREFIX ="VALUA";
	public final static String PERSONALTRADMARK_CODE_PREFIX ="PERSONALTRADMARK";

	public final static String CONSULT_CODE_PREFIX="CONSULT";
	public final static String ENTEEPRISES_CODE_PREFIX="ENTE";
	public final static String POLICY_CODE_PREFIX="POLICY";
	public final static String EEPLAIN_CODE_PREFIX="EEPLAIN";
	public final static String DocDownload_CODE_PREFIX="DOCD";
	public final static String EVALATION_CODE_PREFIX="EVAL";
	public final static String INVESTPRO_CODE_PREFIX="INVEST";
	public final static String SITEALL_CODE_PREFIX="SITEALL";
	public final static String SEO_CODE_PREFIX="SEO";
	public final static String PATENTBID="Z";
	public final static String TECHBID="T";
	public final static String DEVICESHARE="DS";
	public final static String HATCHER="HATCHER";


	// product type
	public final static String PRODUCT_TYPE_PATENT = "专利";
	public final static String PRODUCT_TYPE_TECHNOLOGY = "技术";
	public final static String PRODUCT_TYPE_TRADEMARK = "商标";
	public final static String PRODUCT_TYPE_SERVICE = "服务";
	public final static String PRODUCT_TYPE_STORE = "店铺";
	public final static String PRODUCT_TYPE_REQ_PATENT = "专利求购";
	public final static String PRODUCT_TYPE_REQ_PROJECT = "技术求购";
	public final static String PRODUCT_TYPE_REQ_TRADEMARK = "商标求购";
	
	// product type EN Name
	public final static String PRODUCT_TYPE_PATENT_EN = "patent";
	public final static String PRODUCT_TYPE_TRADEMARK_EN = "trademark";
	public final static String PRODUCT_TYPE_SERVICE_EN = "service";
	public final static String PRODUCT_TYPE_TECH_EN = "technic";
	
	//
	public final static String FEEWAY = "比例";
	
	
	public final static String ISJudge = "难以判断";
	
	// 产品的状态
	//已批准
	public final static String PRODUCT_PUBLISH_APPROVED = "APPROVED";
	//已拒绝
	public final static String PRODUCT_PUBLISH_REJECTED = "REJECTED";
	//已录入
	public final static String PRODUCT_PUBLISH_SAVED = "SAVED";
	//审批中
	public final static String PRODUCT_PUBLISH_INPROGRESS = "INPROGRESS";
	//展示中
	public final static String PRODUCT_PUBLISH_SHOWN = "SHOWN";
	//交易中
	public final static String PRODUCT_PUBLISH_INTRADING = "INTRADING";
	//已交易
	public final static String PRODUCT_PUBLISH_COMPLETED = "COMPLETED";
	//已评价
	public final static String PRODUCT_PUBLISH_EVALUATED = "EVALUATED";
	
	//操作代码
	//同意
	public final static String PRODUCT_OPERATION_APPROVE = "approve";
	//拒绝
	public final static String PRODUCT_OPERATION_REJECT = "reject";
	//上架
	public final static String PRODUCT_OPERATION_SHELVES = "shelves";
	//下架
	public final static String PRODUCT_OPERATION_OFF = "off";
	//下单
	public final static String PRODUCT_OPERATION_PLACEORDER = "placeorder";
	//交易完成
	public final static String PRODUCT_OPERATION_DONE = "done";
	//评价
	public final static String PRODUCT_OPERATION_EVALUATE = "evaluated";
	//发布
	public final static String BASICBUS_OPERATION_PUBLISH = "publish";
	//关闭
	public final static String BASICBUS_OPERATION_CLOSED = "closed";
	//删除
	public final static String BASICBUS_OPERATION_DELETE = "delete";
	//发布成功
	public final static String BASICBUS_OPERATION_PUBLISH_Y = "Y";
	public final static String BASICBUS_OPERATION_PUBLISH_N = "N";
	
	//已读
	public final static String BASICBUS_OPERATION_MARK = "mark";
	
	//打开
	public final static String BASICBUS_OPERATION_OPEN = "open";
	
	//购物车商品类型
	public final static String CART_TYPE_TRADEMARK = "trademark";//商标
	public final static String CART_TYPE_PATENT = "patent";//专利

	// --- 数据字典 start
	// 价格区间
	public final static String SYS_PRICE_BAND_TYPE_CH_STR = "价格区间";
	
	// 服务 - 数据字典大类
	public final static String SYS_SERVICE_TYPE_CH_STR = "服务分类";	
	
	/*
	 * 数据字典 模块名称
	 */
	public final static String SYS_MODEL_SERVICE_CH_STR = "服务";	
	public final static String SYS_MODEL_TRADEMARK_CH_STR = "商标";	
	public final static String SYS_MODEL_PATENT_CH_STR = "专利";	
	public final static String SYS_MODEL_TECH_CH_STR = "技术";	
	public final static String SYS_MODEL_NOTICE_CH_STR = "通知公告与资讯";
	public final static String SYS_MODEL_RECRUIT_CH_STR = "招聘";	
	public final static String SYS_MODEL_ORDER_CH_STR = "订单";
	public final static String SYS_MODEL_IF_CH_STR = "投融资项目";
	public final static String SYS_MODEL_ARMY_CH_STR = "军民";
	public final static String SYS_MODEL_INCUBATOR_CH_STR = "孵化器";
	public final static String SYS_MODEL_DEV_SHARE_CH_STR = "设备共享";
	
	// 生成code的前缀
	public final static String SYS_SERVICE_TYPE_PREFIX = "FW"; // 服务
	public final static String SYS_TRADEMARK_TYPE_PREFIX = "SB"; // 商标
	public final static String SYS_PATENT_TYPE_PREFIX = "ZL"; // 专利
	public final static String SYS_TECH_TYPE_PREFIX = "JS"; // 技术
	public final static String SYS_NOTICE_TYPE_PREFIX = "TZ"; // 通知公告与资讯
	public final static String SYS_RECRUIT_TYPE_PREFIX = "ZP"; // 招聘
	public final static String SYS_ORDER_TYPE_PREFIX = "DD"; // 订单	
	public final static String SYS_IF_TYPE_PREFIX = "IF"; // 投融资项目
	public final static String SYS_ARMY_TYPE_PREFIX = "JM"; // 军民融合
	
	// 商标中分类的中文名称
	public final static String SYS_TRADEMARK_NC = "尼斯分类";
	public final static String SYS_TRADEMARK_CT = "组合类型";
	public final static String SYS_TRADEMARK_TT = "交易方式";
	public final static String SYS_TRADEMARK_RD = "注册时间";
	public final static String SYS_TRADEMARK_TA = "商标区域";
	public final static String SYS_TRADEMARK_LS = "法律状态";
	
	// 专利中分类的中文名称
	public final static String SYS_PATENT_TYPE = "专利类型";
	public final static String SYS_PATENT_INDUSTRY = "行业分类"; 
	public final static String SYS_PATENT_LEGAL_STATUS = "法律状态"; 
	public final static String SYS_PATENT_TRANS_METHOD = "交易方式";
	public final static String SYS_PATENT_PRICE_BAND = "价格区间";		
	
	// 技术中分类的中文名称
	public final static String SYS_TECH_INDUSTRY = "技术行业";
	public final static String SYS_TECH_STAGE = "技术阶段";
	public final static String SYS_TECH_PRICE_BAND = "价格区间";
	public final static String SYS_TECH_COOPER_WAY = "合作方式";
	public final static String SYS_TECH_INVEST_INFO = "资助情况";
	
	// 招聘中的中文类别名称
	public final static String SYS_RECRUIT_POSITION_REQ = "职位列表";
	public final static String SYS_RECRUIT_SALARY_REQ = "薪资范围";
	
	// 订单的中文类别名称
	public final static String SYS_ORDER_COMMENT_LEVEL = "评价级别"; 
	public final static String SYS_ORDER_COMMENT_CATEGORY = "评价分类";
	public final static String SYS_ORDER_CANCEL_BUYER_REASON = "买家取消订单原因"; 
	public final static String SYS_ORDER_CANCEL_SELLER_REASON = "卖家取消订单原因";
	
	// 投融资项目筛选类别名称
	public final static String SYS_IF_PROJECT_TYPE = "项目类型";
	public final static String SYS_IF_INDUSTRY = "行业分类";
	public final static String SYS_IF_PRICE_BAND = "价格区间";
	
	// 孵化器筛选类别名称
	public final static String SYS_INCUBATOR_INDUSTRY_TYPE = "行业分类";
	public final static String SYS_INCUBATOR_LEVEL_TYPE = "级别类型";
	
	// 设备共享筛选类别名称
	public final static String SYS_DEV_APP_TYPE = "应用领域分类";
	public final static String SYS_DEV_INTRU_FUNC_TYPE = "仪器功能分类";
	public final static String SYS_DEV_AREA_TYPE = "地区分类";
	
	/*
	 *  等级规则列表 
	 */
	// 会员类别名称
	public final static String SYS_LEVEL_ROLE_USER = "会员";
	// 信用类别名称
	public final static String SYS_LEVEL_ROLE_CREDIT = "信用";
	
	@SuppressWarnings("serial")
	public final static Map<String, String> SYS_PREFIX_MAPPER = Collections.unmodifiableMap(new HashMap<String, String>() {
	    {
	        put(SYS_MODEL_SERVICE_CH_STR, SYS_SERVICE_TYPE_PREFIX); // 服务
	        put(SYS_MODEL_TRADEMARK_CH_STR, SYS_TRADEMARK_TYPE_PREFIX); // 商标
	        put(SYS_MODEL_PATENT_CH_STR, SYS_PATENT_TYPE_PREFIX); // 专利
	        put(SYS_MODEL_TECH_CH_STR, SYS_TECH_TYPE_PREFIX); // 技术
	        put(SYS_MODEL_NOTICE_CH_STR, SYS_NOTICE_TYPE_PREFIX); // 通知公告与资讯
	        put(SYS_MODEL_RECRUIT_CH_STR, SYS_RECRUIT_TYPE_PREFIX); // 招聘
	        put(SYS_MODEL_ORDER_CH_STR, SYS_ORDER_TYPE_PREFIX); // 订单
	        put(SYS_MODEL_IF_CH_STR, SYS_IF_TYPE_PREFIX); // 投融资项目
	        put(SYS_MODEL_ARMY_CH_STR, SYS_ARMY_TYPE_PREFIX); //军民融合	        
	    }
	});
	
	@SuppressWarnings("serial")
	public final static Map<String, String> SYS_PRODUCT_TYPE_MAPPER = Collections.unmodifiableMap(new HashMap<String, String>() {
	    {
	        put("trademark", "商标"); // 商标
	        put("patent", "专利"); // 专利
	        put("technology", "技术"); // 技术
	    }
	});
	
	@SuppressWarnings("serial")
	public final static Map<String, String> SYS_BSC_TYPE_MAPPER = Collections.unmodifiableMap(new HashMap<String, String>() {
	    {
	    	put("position", SYS_MODEL_RECRUIT_CH_STR); // 招聘
	        put(SYS_RECRUIT_POSITION_REQ, "position"); // 职位要求
	        put(SYS_RECRUIT_SALARY_REQ, "salary"); // 薪资范围
	    }
	});
	
	
	
	//表示服务状态是提交审核
	public final static String IS_SUBMIT = "true";
	
	//表示交易类型
	public final static String IS_TRAN = "true";
	public final static String IS_PRIMT = "false";
		
	//订单状态"COMPLETED":"已完成","EVALUATED":"已评价",
	public final static String ORDER_STATUS_OBLIGATION = "PENDING";
	public final static String ORDER_STATUS_TRANSFER = "TRANSFER";
	public final static String ORDER_STATUS_COMPLETED = "COMPLETED";
	public final static String ORDER_STATUS_CANCELED = "CANCELED";
	public final static String ORDER_STATUS_TERMINATED = "TERMINATED";
	public final static String ORDER_STATUS_APPRAISE = "EVALUATED";
	public final static String ORDER_STATUS_SUBMITTED = "SUBMITTED";
		
	//支付方式
	public final static String ORDER_ONLINE_PAY = "在线支付";
	
	//转让方式
	public final static String ORDER_TRAN = "转让";
	public final static String ORDER_PERMIT = "许可";
	
	// 订单历史状态
	public final static String ORDER_GENERATED = "订单生成";
	public final static String ORDER_HIS_PAYED = "买家付款";
	public final static String SELLER_TRANSFER = "卖家过户";
	public final static String BUYERS_CONFIRM = "买家确认";
	public final static String SUCCESSFUL_TRADE = "交易成功";
	public final static String TRANSACTION_CANCELLED = "交易取消";
	public final static String TRADING_TERMINATES = "交易终止";
	public final static String MODIFY_THE_PRICE = "修改价格";
	
	//官费Remarks
	public final static String OFFICALFEE_REMARKS = "变更 - 专利权利人";
	public final static String ORDER_CHANGE_AGENT = "变更代理机构";
	//支付顺序
	public final static String ORDER_SEQUCE_FIRST = "1";
	public final static String ORDER_SEQUCE_SECEND = "2";
	public final static String ORDER_SEQUCE_THRID = "3";
	//角色 (卖家、买家)
	public final static String ROLE_SELLER = "seller";
	public final static String ROLE_BUYERS = "buyers";
	
	
	//订单评价等级
	public final static String ORDER_LEVEL_GOOD = "好评";
	public final static String ORDER_LEVEL_MEDIUM = "中评";
	public final static String ORDER_LEVEL_BAD = "差评";
	
	//订单Flag
	public final static String ORDER_FLAG_SELLER = "seller";
	public final static String ORDER_FLAG_BUYERS ="buyers";
	
	//评价类型
	public final static String ORDER_TYPE_SELLER = "0";
	public final static String ORDER_TYPE_BUYERS = "1";
	
	//支付集状态
	public final static String ORDER_PAID = "PAID";
	public final static String ORDER_SOLD = "SOLD";
	
	// --- 数据字典 end
	
	//岗位招聘
	public static final String REVIEW_APPROVE = "approve";//批准
	public static final String REVIEW_REJECT = "reject";//拒绝
	public static final String REVIEW_STATUS_INPROGRESS = "INPROGRESS";//审核中
	public static final String REVIEW_STATUS_APPROVED = "APPROVED";//已审核
	public static final String REVIEW_STATUS_REJECTED = "REJECTED";//未通过
	
	//简历状态
	public static final String RESUME_UNREAD = "unread";//未阅读
	public static final String RESUME_READ = "read";//已读
	
	//操作类型
	public static final String RECRUIT_TYPE = "recruit";//招聘
	public static final String RESUME_Type = "resume";//简历
	
	//薪资默认值
	public static final String SALARY_VALUE = "面议";//薪资默认值
	
	//店铺操作值
	public static final String STORE_SETUP = "setup";//开店
	public static final String STORE_CLOSEUP = "closeup";//关店
	
	//订单操作
	public static final String ORDER_OUTOFPRICE = "价格大于原价";//开店
	
	//军民融合
	public static final String CONSULT_NAME = "产权咨询";
	//专家咨询
	public static final String EEPLAIN_NAME = "专家解读";
	//政策法规
	public static final String POLICYLAW_NAME = "政策法规";
	
	/**
	 * 挂牌交易需要状态 start======
	 */	
	//已录入
	public static final String ZZSAVED = "saved";
	//资质审核中
	public static final String ZZCHECKING = "zzChecking";
	//资质已审核
	public static final String ZZAPROVED = "zzAproved";
	//资质未通过
	public static final String ZZREJECTED = "zzRejected";
	//保证金审核中
	public static final String BZJCHECKING = "bzjChecking";
	//保证金已审核
	public static final String BZJAPROVED = "bzjAproved";
	//保证金未通过
	public static final String BZJREJECTED = "bzjRejected";
	//公开竞价期
	public static final String PUBLICBID = "publicBid";
	//已结束
	public static final String OFFBID = "offBid";
	//资质大状态
	public static final String ZZSUPERSTATUS = "zzSuperStatus";  
	//保证金大状态
	public static final String BZJSUPERSTATUS = "bzjSuperStatus";
   //定义审核类型
	//挂牌
	public static final String LISTING = "listing";
    //竞价
	public static final String QUOTE = "quote";
	//审核通过
	public static final String APPROVE = "approve";
	//审核不通过
	public static final String REJECT = "reject";
	
	/**
	 *  信用体系 start+++++ add by shangwenshu
	 */
	public static final String AUTH_ENTE_OPER = "企业实名认证";
	public static final String AUTH_PERSON_OPER_TEL = "用户手机认证";
	public static final String CREDIT_BAIL = "保证金";
	public static final String CREDIT_EVAL = "填写评价内容";
	
	// 信誉值规则，暂时放到常量里，后续需要维护放到表中 TODO
	public static final Map<String, Integer> CREDIT_RULE_POINT_MAPPER = Collections.unmodifiableMap(new HashMap<String, Integer>() {
	   
		private static final long serialVersionUID = 2007855906252392296L;

		{
	    	put(AUTH_ENTE_OPER, 10); 
	        put(AUTH_PERSON_OPER_TEL, 5); 
	        put(CREDIT_BAIL, 30);  // 暂时不考虑
	        put(ORDER_LEVEL_GOOD, 5); 
	        put(ORDER_LEVEL_MEDIUM, 0); 
	        put(ORDER_LEVEL_BAD, -5); 
	        put(CREDIT_EVAL, 1); 
	    }
	});
	
	// 虚拟币收支 与C标段
	public final static String INCOME_COIN = "INCOME"; // 收入
	public final static String PAYOUT_COIN = "EXPEND"; // 支出
	public final static int LOGIN_INCREASE_COIN = 1; // 每日首次登录加+1金币
	public final static int TRADING_COMPLETE_COIN = 500; // 交易成功+500金币
	
	public final static String LOGIN_INCREASE_COIN_DESC = "每日首次登录"; // 每日首次登录加+1金币
	public final static String TRADING_COMPLETE_COIN_DESC = "交易成功";
		
	// 勿删 与C标段联调接口，因目前没有测试环境，此联调暂时不启动
//	public static final boolean C_INTER_OPEN = true; 
}
