package com.trm.util.pdf;

import com.trm.util.pdf.obj.TemplateBO;

/**
 * PDF生成测试类
 * @author zhaosimiao 2018-5-3 11:05:41
 */
public class PdfCreateRun {
	
	public static void main(String[] args) {
		PdfCreateMethod pcm = new PdfCreateMethod();
		String templatePath="D:/pdf/tzgg.pdf";
		
		TemplateBO templateBO=new TemplateBO();
        templateBO.setTemplateName("模板名称：Hello iText! Hello freemarker! Hello jFreeChart!");
        templateBO.setFreeMarkerUrl("http://www.zheng-hang.com/chm/freemarker2_3_24/ref_directive_if.html");
        templateBO.setITEXTUrl("http://developers.itextpdf.com/examples-itext5");
        templateBO.setJFreeChartUrl("http://www.yiibai.com/jfreechart/jfreechart_referenced_apis.html");
        templateBO.setImageUrl("http://mss.vip.sankuai.com/v1/mss_74e5b6ab17f44f799a524fa86b6faebf/360report/logo_1.png");
        
		String path= pcm.createPDF(templatePath,templateBO,"tzgg.pdf");
        System.out.println(path);
	}
}
