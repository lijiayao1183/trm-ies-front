package com.trm.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.annotations.common.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.pdf.BaseFont;
import com.trm.entity.TrmTechnology;
import com.trm.model.equip.EquipDetail;
import com.trm.model.member.MemberDetail;
import com.trm.model.report.ReportDetail;
import com.trm.model.require.DemandDetails;
import com.trm.model.techservorg.TechServOrgDetail;

public class PDFUtil {
	
	private static Logger logger = LoggerFactory.getLogger(PDFUtil.class);

	public static String downLoadPdf(HttpServletRequest request, Object obj, String isDetail) throws Exception {
		
		String serverIP = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
		logger.info("Print Server IP: " + serverIP);
		
		String outFilePath = request.getSession().getServletContext().getRealPath("pdffiles");
		String realPath = getCommand() + request.getSession().getServletContext().getRealPath("");
		String fontPath = request.getSession().getServletContext().getRealPath("fonts/SIMSUN.TTC");
		// String fontPath = "C:/Windows/fonts/simsun.ttc";
		// String timeStamp = TrmDateUtil.getStringDate();
		String inputFile = "";
		if (obj instanceof MemberDetail) {
			inputFile = getUserHtmlString((MemberDetail)obj, realPath, isDetail, serverIP);
		}
		// 设备设施
		else if (obj instanceof EquipDetail) {
			inputFile = getEquipHtmlString((EquipDetail)obj, realPath, isDetail, serverIP);
		}
		// 需求
		else if (obj instanceof DemandDetails) {
			inputFile = getDemandHtmlString((DemandDetails)obj, realPath, isDetail);
		}
		// 技术服务机构
		else if (obj instanceof TechServOrgDetail) {
			inputFile = getTechServOrgHtmlString((TechServOrgDetail)obj, realPath, isDetail);
		}
		// 在线季报
		else if (obj instanceof ReportDetail) {
			inputFile = getReportHtmlString((ReportDetail)obj, realPath, isDetail);
		}
		else {
			logger.info("对象类型不识别...");
		}
		logger.info("Print PDF Html: " + inputFile);
		String filePath = htmlToPDF(inputFile, outFilePath, fontPath, TrmDateUtil.getStringDate());
		return filePath;
	}
	
	public static String getUserHtmlString(MemberDetail user, String realPath, String isDetail, String serverIP)
			throws FileNotFoundException, UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		// 解决不明字符无法识别时，导致下载失败的问题
		// sb.append("<!DOCTYPE html>");
		sb.append("<!DOCTYPE html [<!ENTITY nbsp ' '><!ENTITY copy '©'><!ENTITY reg '®'><!ENTITY trade '™'><!ENTITY mdash '—'><!ENTITY ldquo '“'><!ENTITY rdquo '”'> <!ENTITY pound '£'><!ENTITY yen '¥'><!ENTITY euro '€'>]>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
		sb.append("<style type=\"text/css\">");
		sb.append(".form-content-approve table tr {line-height: 30px;}");
		sb.append(".detail > table td .w200 {text-align:left;}");
		sb.append(".detail > table td {padding-left: 10px}");
		sb.append("*{margin: 0;padding: 0;list-style: none;}");
		sb.append("table {border-spacing: 0;border-collapse: collapse;text-align: center;}");
		sb.append("table thead {background-color: #f5f5f5;}");
		sb.append(".title{text-align: center;font-weight: bold;color: #000;font-size: 18px;}");
		sb.append("table td{ border: 1px solid #CCC; text-align: left;}");
		sb.append("table td.in-1 {width: 20%;word-wrap:break-word;}");
		sb.append("table td.in-2 {width: 80%;word-wrap:break-word;}");
		sb.append("</style>");
		sb.append("</head>");

		sb.append("<body style=\"font-family: 'SimSun','宋体';\" >");
		sb.append("<div class=\"ibox\">");
		sb.append("<div class=\"title media-middle\" style=\"margin-bottom: 20px;font-weight: bold;font-size:18px;text-align: center;\"><p>陕西军民融合科技创新资源开放共享服务平台</p><p><br></br></p><p>用户注册信息表</p></div>");
		sb.append("<div class=\"detail form-content-approve\" id=\"patent_approve\">");
		sb.append("<table style=\"word-break:break-strict;width:100%;table-layout:fixed;\">");

		sb.append("	<tr >");
		sb.append("		<td> 单位名称</td>");
		sb.append("		<td colspan=\"2\">" + isNull(user.getOrgName()) + "</td>");
		sb.append("		<td> 统一社会信用代码</td>");
		sb.append("		<td colspan=\"2\">" + isNull(user.getCreditId()) + "</td>");
		sb.append("	</tr>");
		sb.append("	<tr >");
		sb.append("		<td> 单位地址</td>");
		sb.append("		<td colspan=\"5\">" + isNull(user.getAddress()) + "</td>");
		sb.append("	</tr>");
		
		String isListed = user.getIsListed();
		if("1".equals(isListed)) {
			isListed = "主板上市";
		}
		else if("2".equals(isListed)) {
			isListed = "创业板上市";
		}
		else if("3".equals(isListed)) {
			isListed = "中小企业板上市";
		}
		else if("4".equals(isListed)) {
			isListed = "新三板挂牌";
		}
		else if("5".equals(isListed)) {
			isListed = "未上市";
		}
		String isHighNew = user.getIsHighNew();
		 if("Y".equals(isHighNew)) {
			 isHighNew = "是";
		}
		else if("N".equals(isHighNew)) {
			isHighNew = "否";
		}
		sb.append("	<tr >");
		sb.append("		<td> 单位性质</td>");
		sb.append("		<td>" + isNull(user.getOrgProperty()) + "</td>");
		sb.append("		<td> 公司上市情况 </td>");
		sb.append("		<td>" + isNull(isListed) + "</td>");
		sb.append("		<td> 是否高新企业 </td>");
		sb.append("		<td>" + isNull(isHighNew) + "</td>");
		sb.append("	</tr>");
		
		sb.append("<tr >");
		sb.append("		<td> 隶属单位</td>");
		sb.append("		<td colspan=\"5\">" + isNull(user.getMasterType()) + "   " + isNull(user.getMaster()) + "</td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td> 所在省份</td>");
		sb.append("		<td colspan=\"5\">" + isNull(user.getProvince()) + "   " + isNull(user.getCity()) +  "   " + isNull(user.getArea()) + "</td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td> 企业简介</td>");
		sb.append("		<td colspan=\"5\">" + isNull(user.getOrgBrief()) + "</td>");
		sb.append("</tr>");
		sb.append("	<tr >");
		sb.append("		<td>营业执照/法人证书扫描件</td>");
		sb.append("		<td colspan=\"2\"><img style='width: 160px; height: 240px;' src='"+serverIP+isNull(user.getLicensePdf())+"'/></td>");
		sb.append("		<td>信息报送承诺书扫描件(加盖单位公章)</td>");
		sb.append("		<td colspan=\"2\"><img style='width: 160px; height: 240px;' src='"+serverIP+isNull(user.getPromisePdf())+"'/></td>");
		sb.append("	</tr>");
		
		// 注册人信息
		sb.append("<tr >");
		sb.append("		<td> 注册人姓名 </td>");
		sb.append("		<td colspan=\"2\">" + isNull(user.getLinkPerson()) + "</td>");
		sb.append("		<td> 所在部门 </td>");
		sb.append("		<td colspan=\"2\">" + isNull(user.getDepartment()) + "</td>");
		sb.append("</tr>");
		
		sb.append("<tr >");
		sb.append("		<td> 身份证号 </td>");
		sb.append("		<td colspan=\"2\">" + isNull(user.getNumberId()) + "</td>");
		sb.append("		<td> 手机号码</td>");
		sb.append("		<td colspan=\"2\">" + isNull(user.getPhone()) + "</td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td> 电子邮件 </td>");
		sb.append("		<td colspan=\"5\">" + isNull(user.getEmail()) + "</td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td> 安全提示问题 </td>");
		sb.append("		<td colspan=\"2\">" + isNull(user.getProblem()) + "</td>");
		sb.append("		<td> 安全提示答案 </td>");
		sb.append("		<td colspan=\"2\">" + isNull(user.getAnswer()) + "</td>");
		sb.append("</tr>");
		
		if("N".equals(isDetail)){
			// 审核信息
			sb.append("<tr  style=\"background-color:#f5f5f5;\">");
			sb.append("		<td colspan=\"6\" class=\"title\"><strong>审核信息</strong></td>");
			sb.append("</tr>");
			
			String audStatus = user.getAudStatus();
			if("R0".equals(audStatus)) {
				audStatus = "待审核";
			}
			else if("R1".equals(audStatus)) {
				audStatus = "已通过";
			}
			else if("R2".equals(audStatus)) {
				audStatus = "未通过";
			}
			
			sb.append("<tr >");
			sb.append("		<td> 审核状态 </td>");
			sb.append("		<td colspan=\"2\">" + isNull(audStatus) + "</td>");
			sb.append("		<td> 审核时间 </td>");
			sb.append("		<td colspan=\"2\">" + isNull(user.getAudDate()) + "</td>");
			sb.append("</tr>");
		}
		sb.append("</table>");
		sb.append("</div>");
		sb.append("</div>");

		sb.append("</body></html>");
		return sb.toString();
	}

	public static String getEquipHtmlString(EquipDetail equip, String realPath, String isDetail, String serverIP)
			throws FileNotFoundException, UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		// 解决不明字符无法识别时，导致下载失败的问题
		// sb.append("<!DOCTYPE html>");
		sb.append("<!DOCTYPE html [<!ENTITY nbsp ' '><!ENTITY copy '©'><!ENTITY reg '®'><!ENTITY trade '™'><!ENTITY mdash '—'><!ENTITY ldquo '“'><!ENTITY rdquo '”'> <!ENTITY pound '£'><!ENTITY yen '¥'><!ENTITY euro '€'>]>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
		sb.append("<style type=\"text/css\">");
		sb.append(".form-content-approve table tr {line-height: 30px;}");
		sb.append(".detail > table td .w200 {text-align:left;}");
		sb.append(".detail > table td {padding-left: 10px}");
		sb.append("*{margin: 0;padding: 0;list-style: none;}");
		sb.append("table {border-spacing: 0;border-collapse: collapse;text-align: center;}");
		sb.append("table thead {background-color: #f5f5f5;}");
		sb.append(".title{text-align: center;font-weight: bold;color: #000;font-size: 18px;}");
		sb.append("table td{ border: 1px solid #CCC; text-align: left;}");
		sb.append("table td.in-1 {width: 20%;word-wrap:break-word;}");
		sb.append("table td.in-2 {width: 80%;word-wrap:break-word;}");
		sb.append("</style>");
		sb.append("</head>");

		sb.append("<body style=\"font-family: 'SimSun','宋体';\" >");
		sb.append("<div class=\"ibox\">");
		sb.append("<div class=\"title media-middle\" style=\"margin-bottom: 20px;font-weight: bold;font-size:18px;text-align: center;\">"
				/*+ "<p style='font-size:12px;'>陕西军民融合科技创新资源开放共享服务平台</p>"
				+ "<p><br/></p>"*/
				+ "<p style='font-size:20px;'>"+isNull(equip.getEquipName())+"</p>"
				+ "<p><br/></p>"
				+ "<p style='font-size:12px;'>发布时间："+isNull(equip.getApplyDate())+"            信息来源："+isNull(equip.getLinkUnit())+"</p>"
				+ "</div>");
		sb.append("<div class=\"detail form-content-approve\" id=\"patent_approve\">");
		sb.append("<table style=\"word-break:break-strict;width:100%;table-layout:fixed;\">");

		sb.append("	<tr >");
		sb.append("		<td >设备设施图片</td>");
		sb.append("		<td colspan=\"6\"><img style='width: 160px; height: 120px;' src='"+serverIP+isNull(equip.getEquipPic1())+"'/>");
		sb.append("		<img style='width: 160px; height: 120px;' src='"+serverIP+isNull(equip.getEquipPic2())+"'/>");
		sb.append("		<img style='width: 160px; height: 120px;' src='"+serverIP+isNull(equip.getEquipPic3())+"'/>" + "</td>");
		sb.append("	</tr>");
		sb.append("	<tr >");
		sb.append("		<td > 设备设施类别</td>");
		sb.append("		<td colspan=\"6\">" + isNull(equip.getEquipType()) + "</td>");
		sb.append("	</tr>");
		sb.append("	<tr >");
		sb.append("		<td > 服务领域 </td>");
		sb.append("		<td colspan=\"6\">" + isNull(equip.getServiceRange()) + "</td>");
		sb.append("	</tr>");
		sb.append("	<tr >");
		sb.append("		<td > 制造厂商 </td>");
		sb.append("		<td colspan=\"3\">" + isNull(equip.getCreateFirm()) + "</td>");
		sb.append("		<td > 生产国别 </td>");
		sb.append("		<td colspan=\"2\">" + isNull(equip.getProCountry()) + "</td>");
		sb.append("	</tr>");
		sb.append("	<tr >");
		sb.append("		<td > 购置日期 </td>");
		sb.append("		<td colspan=\"3\">" + isNull(equip.getPurchaseDate()) + "</td>");
		sb.append("		<td > 规格型号 </td>");
		sb.append("		<td colspan=\"2\">" + isNull(equip.getEquipVerCode()) + "</td>");
		sb.append("	</tr>");

		sb.append("<tr >");
		sb.append("		<td > 关键字 </td>");
		sb.append("		<td colspan=\"6\">" + isNull(equip.getKeyWords()) + "</td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td > 主要技术指标 </td>");
		sb.append("		<td colspan=\"6\">" + isNull(equip.getQualification()) + "</td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td > 功能应用范围 </td>");
		sb.append("		<td colspan=\"6\">" + isNull(equip.getUseField()) + "</td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td > 技术特色 </td>");
		sb.append("		<td colspan=\"6\">" + isNull(equip.getTecFeature()) + "</td>");
		sb.append("</tr>");

		sb.append("<tr >");
		sb.append("		<td > 服务方式  </td>");
		sb.append("		<td colspan=\"3\">" + isNull(equip.getServiceMode()) + "</td>");
		sb.append("		<td > 服务费</td>");
		sb.append("		<td colspan=\"2\">" + isNull(equip.getEquipValue()) + "</td>");
		sb.append("</tr>");

		sb.append("<tr >");
		sb.append("		<td > 持有单位  </td>");
		sb.append("		<td colspan=\"6\">" + isNull(equip.getLinkUnit()) + "</td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td > 单位地址 </td>");
		sb.append("		<td colspan=\"6\">" + isNull(equip.getLinkAddress()) + "</td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td > 联系人 </td>");
		sb.append("		<td colspan=\"6\">" + isNull(equip.getLinkPerson()) + "</td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td > 电子邮件 </td>");
		sb.append("		<td colspan=\"3\">" + isNull(equip.getEmail()) + "</td>");
		sb.append("		<td > 联系方式 </td>");
		sb.append("		<td colspan=\"2\">" + isNull(equip.getLinkPhone()) + "</td>");
		sb.append("</tr>");
		
		if("N".equals(isDetail)){
			// 审核信息
			sb.append("<tr  style=\"background-color:#f5f5f5;\">");
			sb.append("		<td colspan=\"7\" class=\"title\"><strong>审核信息</strong></td>");
			sb.append("</tr>");
			
			String audStatus = equip.getAudStatus();
			if("F0".equals(audStatus)) {
				audStatus = "用户-未提交";
			}
			else if("F1".equals(audStatus)) {
				audStatus = "用户-待审核";
			}
			else if("A2".equals(audStatus)) {
				audStatus = "单位-已通过";
			}
			else if("A3".equals(audStatus)) {
				audStatus = "单位-未通过";
			}
			else if("F2".equals(audStatus)) {
				audStatus = "平台-已通过";
			}
			else if("F3".equals(audStatus)) {
				audStatus = "平台-未通过";
			}
			
			sb.append("<tr >");
			sb.append("		<td > 审核状态 </td>");
			sb.append("		<td colspan=\"2\">" + isNull(audStatus) + "</td>");
			sb.append("		<td > 审核时间 </td>");
			sb.append("		<td colspan=\"3\">" + isNull(equip.getAudDate()) + "</td>");
			sb.append("</tr>");
			
		}
		sb.append("</table>");
		sb.append("</div>");
		sb.append("</div>");

		sb.append("</body></html>");
		return sb.toString();
	}
	
	public static String getDemandHtmlString(DemandDetails demand, String realPath, String isDetail)
			throws FileNotFoundException, UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		// 解决不明字符无法识别时，导致下载失败的问题
		// sb.append("<!DOCTYPE html>");
		sb.append("<!DOCTYPE html [<!ENTITY nbsp ' '><!ENTITY copy '©'><!ENTITY reg '®'><!ENTITY trade '™'><!ENTITY mdash '—'><!ENTITY ldquo '“'><!ENTITY rdquo '”'> <!ENTITY pound '£'><!ENTITY yen '¥'><!ENTITY euro '€'>]>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
		sb.append("<style type=\"text/css\">");
		sb.append(".form-content-approve table tr {line-height: 30px;}");
		sb.append(".detail > table td .w200 {text-align:left;}");
		sb.append(".detail > table td {padding-left: 10px}");
		sb.append("*{margin: 0;padding: 0;list-style: none;}");
		sb.append("table {border-spacing: 0;border-collapse: collapse;text-align: center;}");
		sb.append("table thead {background-color: #f5f5f5;}");
		sb.append(".title{text-align: center;font-weight: bold;color: #000;font-size: 18px;}");
		sb.append("table td{ border: 1px solid #CCC; text-align: left;}");
		sb.append("table td.in-1 {width: 20%;word-wrap:break-word;}");
		sb.append("table td.in-2 {width: 80%;word-wrap:break-word;}");
		sb.append("</style>");
		sb.append("</head>");

		sb.append("<body style=\"font-family: 'SimSun','宋体';\" >");
		sb.append("<div class=\"ibox\">");
		/*sb.append("<div class=\"title media-middle\" style=\"margin-bottom: 20px;font-weight: bold;font-size:18px;text-align: center;\">陕西军民融合科技创新资源开放共享服务平台——<span>军民融合需求</span></div>");*/
		
		sb.append("<div class=\"title media-middle\" style=\"margin-bottom: 20px;font-weight: bold;font-size:18px;text-align: center;\">"
				/*+ "<p style='font-size:12px;'>陕西军民融合科技创新资源开放共享服务平台</p>"
				+ "<p><br/></p>"*/
				+ "<p style='font-size:20px;'>"+isNull(demand.getTrmDemand().getName())+"</p>"
				+ "<p><br/></p>"
				+ "<p style='font-size:12px;'>发布时间："+isNull(demand.getTrmDemand().getCreateTime())+"            信息来源："+isNull(demand.getTrmDemand().getCompanyName())+"</p>"
				+ "</div>");
		
		sb.append("<div class=\"detail form-content-approve\" id=\"patent_approve\">");
		sb.append("<table style=\"word-break:break-strict;width:100%;table-layout:fixed;\">");

		/*sb.append("	<tr >");
		sb.append("		<td > 需求来源</td>");
		sb.append("		<td colspan=\"6\">" + isNull(demand.getTrmDemand().getSource()) + "</td>");
		sb.append("	</tr>");*/
		sb.append("	<tr >");
		sb.append("		<td > 需求类别 </td>");
		sb.append("		<td colspan=\"3\">" + isNull(demand.getTrmDemand().getType()) + "</td>");
		sb.append("		<td > 关键字</td>");
		sb.append("		<td colspan=\"3\">" + isNull(demand.getTrmDemand().getKeyword()) + "</td>");
		sb.append("	</tr>");
		sb.append("	<tr >");
		sb.append("		<td > 应用领域 </td>");
		sb.append("		<td colspan=\"7\">" + isNull(demand.getDomain()) + "</td>");
		sb.append("	</tr>");
		sb.append("<tr >");
		sb.append("		<td > 需求单位 </td>");
		sb.append("		<td colspan=\"7\">" + isNull(demand.getTrmDemand().getCompanyName()) + "</td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td > 单位地址 </td>");
		sb.append("		<td colspan=\"7\">" + isNull(demand.getTrmDemand().getCompanyAddr()) + "</td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td > 联系人 </td>");
		sb.append("		<td colspan=\"7\">" + isNull(demand.getTrmDemand().getContacts()) + "</td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td > 手机号码 </td>");
		sb.append("		<td colspan=\"7\">" + isNull(demand.getTrmDemand().getPhone()) + "</td>");
		sb.append("</tr>");
		sb.append("	<tr >");
		sb.append("		<td > 需求有效期</td>");
		sb.append("		<td colspan=\"7\">" + isNull(demand.getTrmDemand().getEndDate()) + "</td>");
		sb.append("	</tr>");
		sb.append("<tr >");
		sb.append("		<td > 需求描述 </td>");
		sb.append("		<td colspan=\"7\">" + isNull(demand.getTrmDemand().getContent()) + "</td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td > 备注  </td>");
		sb.append("		<td colspan=\"7\">" + isNull(demand.getTrmDemand().getRemark()) + "</td>");
		sb.append("</tr>");
		
		// 相关技术产品
		sb.append("<tr  style=\"background-color:#f5f5f5;\">");
		sb.append("		<td colspan=\"8\" class=\"title\"><strong>相关技术产品</strong></td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td colspan=\"2\"> 产品名称</td>");
		sb.append("		<td colspan=\"4\"> 功能描述</td>");
		sb.append("		<td colspan=\"2\"> 联系方式</td>");
		sb.append("</tr>");
		List<TrmTechnology> techPros = demand.getTechnologies();
		if(techPros.size() < 1) {
			
			sb.append("<tr >");
			sb.append("		<td colspan=\"8\">暂无数据</td>");
			sb.append("</tr>");
		}
		else {
			
			for(int i=0; i<techPros.size(); i++) {
				TrmTechnology techPro = techPros.get(i);
				sb.append("<tr >");
				sb.append("		<td colspan=\"2\">" + isNull(techPro.getTechName()) + "</td>");
				sb.append("		<td colspan=\"4\">" + isNull(techPro.getTechContent()) + "</td>");
				sb.append("		<td colspan=\"2\">" + isNull(techPro.getTechPhone()) + "</td>");
				sb.append("</tr>");
			}
			
		}
		
		if("N".equals(isDetail)){
			// 审核信息
			sb.append("<tr  style=\"background-color:#f5f5f5;\">");
			sb.append("		<td colspan=\"8\" class=\"title\"><strong>审核信息</strong></td>");
			sb.append("</tr>");
			
			String audStatus = demand.getTrmDemand().getAudStatus();
			if("F0".equals(audStatus)) {
				audStatus = "用户-未提交";
			}
			else if("F1".equals(audStatus)) {
				audStatus = "用户-待审核";
			}
			else if("A2".equals(audStatus)) {
				audStatus = "单位-已通过";
			}
			else if("A3".equals(audStatus)) {
				audStatus = "单位-未通过";
			}
			else if("F2".equals(audStatus)) {
				audStatus = "平台-已通过";
			}
			else if("F3".equals(audStatus)) {
				audStatus = "平台-未通过";
			}
			
			sb.append("<tr >");
			sb.append("		<td > 审核状态 </td>");
			sb.append("		<td colspan=\"3\">" + isNull(audStatus) + "</td>");
			sb.append("		<td > 审核时间 </td>");
			sb.append("		<td colspan=\"3\">" + isNull(demand.getTrmDemand().getAudDate()) + "</td>");
			sb.append("</tr>");
			
		}
		
		sb.append("</table>");
		sb.append("</div>");
		sb.append("</div>");

		sb.append("</body></html>");
		return sb.toString();
	}
	
	
	public static String getTechServOrgHtmlString(TechServOrgDetail org, String realPath, String isDetail)
			throws FileNotFoundException, UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		// 解决不明字符无法识别时，导致下载失败的问题
		// sb.append("<!DOCTYPE html>");
		sb.append("<!DOCTYPE html [<!ENTITY nbsp ' '><!ENTITY copy '©'><!ENTITY reg '®'><!ENTITY trade '™'><!ENTITY mdash '—'><!ENTITY ldquo '“'><!ENTITY rdquo '”'> <!ENTITY pound '£'><!ENTITY yen '¥'><!ENTITY euro '€'>]>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
		sb.append("<style type=\"text/css\">");
		sb.append(".form-content-approve table tr {line-height: 30px;}");
		sb.append(".detail > table td .w200 {text-align:left;}");
		sb.append(".detail > table td {padding-left: 10px}");
		sb.append("*{margin: 0;padding: 0;list-style: none;}");
		sb.append("table {border-spacing: 0;border-collapse: collapse;text-align: center;}");
		sb.append("table thead {background-color: #f5f5f5;}");
		sb.append(".title{text-align: center;font-weight: bold;color: #000;font-size: 18px;}");
		sb.append("table td{ border: 1px solid #CCC; text-align: left;}");
		sb.append("table td.in-1 {width: 20%;word-wrap:break-word;}");
		sb.append("table td.in-2 {width: 80%;word-wrap:break-word;}");
		
		sb.append("</style>");
		sb.append("</head>");

		sb.append("<body style=\"font-family: 'SimSun','宋体'; \" >");
		sb.append("<div class=\"ibox\">");
		/*sb.append("<div class=\"title media-middle\" style=\"margin-bottom: 20px;font-weight: bold;font-size:18px;text-align: center;\">陕西军民融合科技创新资源开放共享服务平台——<span>技术服务机构</span></div>");*/
		
		sb.append("<div class=\"title media-middle\" style=\"margin-bottom: 20px;font-weight: bold;font-size:18px;text-align: center;\">"
				/*+ "<p style='font-size:12px;'>陕西军民融合科技创新资源开放共享服务平台</p>"
				+ "<p><br/></p>"*/
				+ "<p style='font-size:20px;'>"+isNull(org.getOrgName())+"</p>"
				+ "<p><br/></p>"
				+ "<p style='font-size:12px;'>发布时间："+isNull(org.getCreateTime())+"            信息来源："+isNull(org.getUnitName())+"</p>"
				+ "</div>");
		sb.append("<div class=\"detail form-content-approve\" id=\"patent_approve\">" );
		sb.append("<table style=\"word-break:break-strict;width:100%;table-layout:fixed;\">");
		
		sb.append("	<tr >");
		sb.append("		<td > 服务类型</td>");
		sb.append("		<td colspan=\"7\">" + isNull(org.getServType()) + "</td>");
		sb.append("	</tr>");
		sb.append("	<tr >");
		sb.append("		<td > 机构地址</td>");
		sb.append("		<td colspan=\"4\">" + isNull(org.getAddress()) + "</td>");
		sb.append("		<td > 机构邮编</td>");
		sb.append("		<td colspan=\"2\">" + isNull(org.getPostcode()) + "</td>");
		sb.append("	</tr>");
		sb.append("	<tr >");
		sb.append("		<td > 机构性质</td>");
		sb.append("		<td colspan=\"3\">" + isNull(org.getProperty()) + "</td>");
		sb.append("		<td > 机构属性</td>");
		sb.append("		<td colspan=\"3\">" + isNull(org.getAttribute()) + "</td>");
		sb.append("	</tr>");

		// 负责人信息
		sb.append("<tr style=\"background-color:#f5f5f5;\">");
		sb.append("		<td colspan=\"8\" class=\"title\"><strong>负责人</strong></td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("		<td > 姓名 </td>");
		sb.append("		<td colspan=\"3\">" + isNull(org.getHeader()) + "</td>");
		sb.append("		<td > 电话 </td>");
		sb.append("		<td colspan=\"3\">" + isNull(org.getHeaderPhone()) + "</td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("		<td > 手机 </td>");
		sb.append("		<td colspan=\"3\">" + isNull(org.getHeaderMobile()) + "</td>");
		sb.append("		<td > 邮箱 </td>");
		sb.append("		<td colspan=\"3\">" + isNull(org.getHeaderEmail()) + "</td>");
		sb.append("</tr>");
		
		// 联系人信息
		sb.append("<tr style=\"background-color:#f5f5f5;\">");
		sb.append("		<td colspan=\"8\" class=\"title\"><strong>联系人</strong></td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("		<td > 姓名 </td>");
		sb.append("		<td colspan=\"3\">" + isNull(org.getLinker()) + "</td>");
		sb.append("		<td > 电话 </td>");
		sb.append("		<td colspan=\"3\">" + isNull(org.getLinkerPhone()) + "</td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("		<td > 手机 </td>");
		sb.append("		<td colspan=\"3\">" + isNull(org.getLinkerMobile()) + "</td>");
		sb.append("		<td > 邮箱 </td>");
		sb.append("		<td colspan=\"3\">" + isNull(org.getLinkerEmail()) + "</td>");
		sb.append("</tr>");
		sb.append("<tr style=\"background-color:#f5f5f5;\">");
		sb.append("		<td colspan=\"8\" class=\"title\"><strong>现有基础</strong></td>");
		sb.append("</tr>");
		sb.append("	<tr >");
		sb.append("		<td > 机构简介</td>");
		sb.append("		<td colspan=\"7\">" + isNull(org.getBrief()) + "</td>");
		sb.append("	</tr>");
		sb.append("<tr >");
		sb.append("		<td > 人才队伍情况</td>");
		sb.append("		<td colspan=\"7\">" + isNull(org.getTeam()) + "</td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td > 规范化管理水平</td>");
		sb.append("		<td colspan=\"7\">" + isNull(org.getMgtLevel()) + "</td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td > 所获资质及荣誉</td>");
		sb.append("		<td colspan=\"7\">" + isNull(org.getHonor()) + "</td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td > 技术服务情况</td>");
		sb.append("		<td colspan=\"7\">" + isNull(org.getServCase()) + "</td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td > 近年承担重要项目/案例  </td>");
		sb.append("		<td colspan=\"7\">" + isNull(org.getProjectCase()) + "</td>");
		sb.append("</tr>");
		
		if("N".equals(isDetail)){
			// 审核信息
			sb.append("<tr style=\"background-color:#f5f5f5;\">");
			sb.append("		<td colspan=\"8\" class=\"title\"><strong>审核信息</strong></td>");
			sb.append("</tr>");
			
			String audStatus = org.getAudStatus();
			if("F0".equals(audStatus)) {
				audStatus = "用户-未提交";
			}
			else if("F1".equals(audStatus)) {
				audStatus = "用户-待审核";
			}
			else if("A2".equals(audStatus)) {
				audStatus = "单位-已通过";
			}
			else if("A3".equals(audStatus)) {
				audStatus = "单位-未通过";
			}
			else if("F2".equals(audStatus)) {
				audStatus = "平台-已通过";
			}
			else if("F3".equals(audStatus)) {
				audStatus = "平台-未通过";
			}
			
			sb.append("<tr >");
			sb.append("		<td > 审核状态 </td>");
			sb.append("		<td colspan=\"3\">" + isNull(audStatus) + "</td>");
			sb.append("		<td > 审核时间 </td>");
			sb.append("		<td colspan=\"3\">" + isNull(org.getAudDate()) + "</td>");
			sb.append("</tr>");
			
		}
		sb.append("</table>");
		sb.append("</div>");
		sb.append("</div>");

		sb.append("</body></html>");
		return sb.toString();
	}
	
	public static String getReportHtmlString(ReportDetail report, String realPath, String isDetail)
			throws FileNotFoundException, UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		// 解决不明字符无法识别时，导致下载失败的问题
		// sb.append("<!DOCTYPE html>");
		sb.append("<!DOCTYPE html [<!ENTITY nbsp ' '><!ENTITY copy '©'><!ENTITY reg '®'><!ENTITY trade '™'><!ENTITY mdash '—'><!ENTITY ldquo '“'><!ENTITY rdquo '”'> <!ENTITY pound '£'><!ENTITY yen '¥'><!ENTITY euro '€'>]>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
		sb.append("<style type=\"text/css\">");
		sb.append(".form-content-approve table tr {line-height: 30px;}");
		sb.append(".detail > table td .w200 {text-align:left;}");
		sb.append(".detail > table td {padding-left: 10px}");
		sb.append("*{margin: 0;padding: 0;list-style: none;}");
		sb.append("table {border-spacing: 0;border-collapse: collapse;text-align: center;}");
		sb.append("table thead {background-color: #f5f5f5;}");
		sb.append(".title{text-align: center;font-weight: bold;color: #000;font-size: 18px;}");
		sb.append("table td{ border: 1px solid #CCC; text-align: left;}");
		sb.append("table td.in-1 {width: 20%;word-wrap:break-word;}");
		sb.append("table td.in-2 {width: 80%;word-wrap:break-word;}");
		sb.append("</style>");
		sb.append("</head>");

		sb.append("<body style=\"font-family: 'SimSun','宋体';\" >");
		sb.append("<div class=\"ibox\">");
		/*sb.append("<div class=\"title media-middle\" style=\"margin-bottom: 20px;font-weight: bold;font-size:18px;text-align: center;\">陕西军民融合科技创新资源开放共享服务平台——<span>在线季报</span></div>");*/
		
		sb.append("<div class=\"title media-middle\" style=\"margin-bottom: 20px;font-weight: bold;font-size:18px;text-align: center;\">"
				/*+ "<p style='font-size:12px;'>陕西军民融合科技创新资源开放共享服务平台</p>"
				+ "<p><br/></p>"*/
				+ "<p style='font-size:20px;'>"+isNull(report.getReportYear())+"年第" + isNull(report.getReportQuart()) + "季度" + isNull(report.getUnitName()) + "服务成效报告表</p>"
				+ "<p><br/></p>"
				+ "<p style='font-size:12px;'>发布时间："+isNull(report.getCreateTime())+"            信息来源："+isNull(report.getUnitName())+"</p>"
				+ "</div>");
		
		sb.append("<div class=\"detail form-content-approve\" id=\"patent_approve\">");
		sb.append("<table style=\"word-break:break-strict;width:100%;table-layout:fixed;\">");

		// 基本信息
		/*sb.append("	<tr style=\"background-color:#f5f5f5;\">");
		sb.append("		<td colspan=\"7\" class=\"title\"><strong>季报基本信息</strong></td>");
		sb.append("	</tr>");*/
		/*sb.append("	<tr >");
		sb.append("		<td >年份</td>");
		sb.append("		<td colspan=\"6\">" + isNull(report.getReportYear()) + " 年</td>");
		sb.append("	</tr>");*/
		/*sb.append("	<tr >");
		sb.append("		<td > 季度</td>");
		sb.append("		<td colspan=\"6\">第 " + isNull(report.getReportQuart()) + " 季度</td>");
		sb.append("	</tr>");*/
		sb.append("<tr style=\"background-color:#f5f5f5;\">");
		sb.append("		<td colspan=\"9\" class=\"title\"><strong>设备设施数量</strong></td>");
		sb.append("</tr>");
		sb.append("	<tr >");
		sb.append("		<td colspan=\"2\"> 设备数量（台/套）</td>");
		sb.append("		<td colspan=\"3\">" + isNull(report.getEquipSum()) + "</td>");
		sb.append("		<td > 设施数量（个）</td>");
		sb.append("		<td colspan=\"3\">" + isNull(report.getFacilitySum()) + "</td>");
		sb.append("	</tr>");

		// 共享服务情况
		sb.append("<tr style=\"background-color:#f5f5f5;\">");
		sb.append("		<td colspan=\"9\" class=\"title\"><strong>共享服务情况</strong></td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td colspan=\"2\"> 对外检测样品总数<br/>（个）</td>");
		sb.append("		<td colspan=\"7\">" + isNull(report.getSumItem1()) + "</td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td colspan=\"2\"> 对外服务总机时数<br/>（小时） </td>");
		sb.append("		<td colspan=\"7\">" + isNull(report.getSumItem2()) + "</td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td colspan=\"2\"> 对外服务总金额<br/>（元） </td>");
		sb.append("		<td colspan=\"7\">" + isNull(report.getSumItem3()) + "</td>");
		sb.append("</tr>");

		// 服务对象所在地
		sb.append("<tr  style=\"background-color:#f5f5f5;\">");
		sb.append("		<td colspan=\"9\" class=\"title\"><strong>服务对象所在地</strong></td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td colspan=\"2\"> 省市区域数量（个）  </td>");
		sb.append("		<td colspan=\"7\">" + isNull(report.getInProvinceCount()) + "</td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td colspan=\"2\"> 西安数量（个） </td>");
		sb.append("		<td colspan=\"7\">" + isNull(report.getXianCount()) + "</td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td colspan=\"2\"> 外省区域数量（个） </td>");
		sb.append("		<td colspan=\"7\">" + isNull(report.getOutProvinceCount()) + "</td>");
		sb.append("</tr>");
		
		
		// 主要服务内容
		sb.append("<tr  style=\"background-color:#f5f5f5;\">");
		sb.append("		<td colspan=\"9\" class=\"title\"><strong>主要服务内容</strong></td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td colspan=\"2\"> 主要服务内容  </td>");
		sb.append("		<td colspan=\"7\">" + isNull(report.getServiceItem()) + "</td>");
		sb.append("</tr>");

		// 对外服务经典事例
		sb.append("<tr  style=\"background-color:#f5f5f5;\">");
		sb.append("		<td colspan=\"9\" class=\"title\"><strong>对外服务经典事例</strong></td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td colspan=\"2\"> 事例名称  </td>");
		sb.append("		<td colspan=\"7\">" + isNull(report.getCaseName()) + "</td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td colspan=\"2\"> 服务对象 </td>");
		sb.append("		<td colspan=\"7\">" + isNull(report.getCaseObj()) + "</td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td colspan=\"2\"> 服务内容</td>");
		sb.append("		<td colspan=\"7\">" + isNull(report.getCaseBrief()) + "</td>");
		sb.append("</tr>");
		sb.append("<tr >");
		sb.append("		<td colspan=\"2\"> 服务效果</td>");
		sb.append("		<td colspan=\"7\">" + isNull(report.getCaseEffect()) + "</td>");
		sb.append("</tr>");
		
		String reportStatus = report.getReportStatus();
		if("F0".equals(reportStatus)) {
			reportStatus = "未提交";
		}
		else if("F1".equals(reportStatus)) {
			reportStatus = "已提交";
		}
		
		sb.append("<tr >");
		sb.append("		<td colspan=\"2\"> 报表状态 </td>");
		sb.append("		<td colspan=\"7\">" + isNull(reportStatus) + "</td>");
		sb.append("</tr>");
		
		sb.append("</table>");
		sb.append("</div>");
		sb.append("</div>");

		sb.append("</body></html>");
		return sb.toString();
	}

	public static String htmlToPDF(String inputFile, String outFilePath, String fontPath, String downloadPeople)
			throws Exception {
		String filePath = outFilePath + System.getProperty("file.separator") + downloadPeople + ".pdf";
		OutputStream os = new FileOutputStream(filePath);
		ITextRenderer renderer = new ITextRenderer();
		ITextFontResolver fontResolver = renderer.getFontResolver();

		// fontResolver.addFont("C:/Windows/fonts/simsun.ttc",BaseFont.IDENTITY_H,
		// BaseFont.NOT_EMBEDDED);
		// fontResolver.addFont("C:/Windows/Fonts/SIMSUN.TTC,1",BaseFont.IDENTITY_H,
		// BaseFont.NOT_EMBEDDED);
		fontResolver.addFont(fontPath + ",0", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

		renderer.setDocumentFromString(inputFile.toString());
		renderer.layout();
		renderer.createPDF(os);
		os.flush();
		os.close();
		return "/pdffiles/" + downloadPeople + ".pdf";
	}

	public static Object isNull(Object obj) {
		return null != obj ? obj : "";
	}

	public static String isNullDate(Date date) {
		return null != date ? date.toString().substring(0, 10) : "";
	}

	/**
	 * 若字符串不包含汉字则换行
	 * 
	 * @param str
	 * @return
	 */
	public static String isContainsChinese(String str) {
		String newStr = "";
		if (StringHelper.isEmpty(str)) {
			return newStr;
		}
		Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher isNum = pattern.matcher(str);
		if (isNum.find()) {
			return str;// 包含
		}
		if (str.length() > 16) {
			String str2[] = str.split("");
			for (int k = 1; k < str2.length; k++) {
				if (k % 16 == 0) {
					newStr += str2[k] + "\r\n";
				} else {
					newStr += str2[k];
				}
			}
		} else {
			newStr = str;
		}
		return newStr;
	}

	/**
	 * 区分操作系统，如果是windows返回 file:/否则返回空
	 * 
	 * @return
	 */
	public static String getCommand() {
		String system = System.getProperty("os.name");
		if (system.toLowerCase().contains("Windows".toLowerCase())) // Windows系统
			return "file:/";
		else if (system.toLowerCase().contains("Linux".toLowerCase())) // linux
																		// 系统
			return "";
		return "";
	}
}