package com.trm.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.trm.constants.BusinessConstants;
import com.trm.constants.CommonTradingConstants;

public class GenerateCodeUtil {
	
	
	public static String generateNewsCode(){
		return GenerateCodeUtil.generateCode(BusinessConstants.NEWSCODE_PREFIX);
	};
	
	public static String generateKeyinfoCode(){
		return GenerateCodeUtil.generateCode(BusinessConstants.KEYCODE_PREFIX);
	};
	
	public static String generateResumeCode() {
		return GenerateCodeUtil.generateCode(BusinessConstants.RESUMECODE_PREFIX);
	}
	
	public static String generatePositionCode() {
		return GenerateCodeUtil.generateCode(BusinessConstants.POSITIONCODE_PREFIX);
	}
	public static String generatePosResponseCode() {
		return GenerateCodeUtil.generateCode(BusinessConstants.POSITION_RESPONSE_CODE_PREFIX);
	}
	public static String generatePosRequireCode() {
		return GenerateCodeUtil.generateCode(BusinessConstants.POSITION_REQUIRE_CODE_PREFIX);
	}
	
	public static String generateSerCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.SERVICE_CODE_PREFIX);
	}
	
	public static String generateTrademarkCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.TRADEMARK_CODE_PREFIX);
	}
	public static String generateReqTrademarkCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.REQ_TRADEMARK_CODE_PREFIX);
	}
	
	public static String generatePUBFlowCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.PUBLISH_FLOW_CODE_PREFIX);
	}
	public static String generateCode(String prefix){
		return prefix + System.currentTimeMillis()+Math.round((new Random().nextDouble() * Math.pow(10, 2)));   
	}
	
	public static String generatePrefix(String type) {
		return CommonTradingConstants.SYS_PREFIX_MAPPER.get(type);
	}

	public static String generatePatentCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.PATENT_CODE_PREFIX);
	}
	public static String generateReqPatentCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.REQ_PATENT_CODE_PREFIX);
	}
	public static String generateTechnologyCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.TECH_CODE_PREFIX);
	}
	public static String generateReqTechnologyCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.REQ_TECH_CODE_PREFIX);
	}
	public static String generateRecruitmentCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.RECRUITMENT_CODE_PREFIX);
	}
	
	public static String generateInfoAndNoticeCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.INFOANDNOTICE_CODE_PREFIX);
	}
	
	public static String generateStoreCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.STORECODE_CODE_PREFIX);
	}
	public static String generateAddressCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.ADDRESSCODE_CODE_PREFIX);
	}
	public static String generateCollectionCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.COLLECTION_CODE_PREFIX);
	}
	public static String generateEvalCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.EVALATION_CODE_PREFIX);
	}
	public static String generateInvestProjectCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.INVESTPRO_CODE_PREFIX);
	}
	public static String generateOrderCode() {
		Date date = new Date(); 
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
		return CommonTradingConstants.ORDERCODE_CODE_PREFIX + sdf.format(date);
	}
	public static String generateConsultCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.CONSULT_CODE_PREFIX);
	}
	public static String generateEnterpriseCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.ENTEEPRISES_CODE_PREFIX);
	}
	public static String generatePolicyLawCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.POLICY_CODE_PREFIX);
	}
	public static String generateEEplainCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.EEPLAIN_CODE_PREFIX);
	}
	public static String generateDocCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.DocDownload_CODE_PREFIX);
	}
	public static String generateSiteALLCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.SITEALL_CODE_PREFIX);
	}
	public static String generateSEOCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.SEO_CODE_PREFIX);
	}
	public static String generatePBCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.PATENTBID);
	}
	public static String generateTBCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.TECHBID);
	}
	
	public static String generateDeviceShareCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.DEVICESHARE);
	}
	public static String generateHatcherCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.HATCHER);
	}
	public static String generateBidCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.BID_CODE_PREFIX);
	}
	public static String generateAttachCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.ATTACH_CODE_PREFIX);
	}
	public static String generateValuationCode() {
		return GenerateCodeUtil.generateCode(CommonTradingConstants.VALUA_CODE_PREFIX);
	}
}
