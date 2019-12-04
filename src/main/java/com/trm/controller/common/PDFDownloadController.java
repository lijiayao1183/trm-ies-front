package com.trm.controller.common;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trm.constants.SystemConstants;
import com.trm.dao.common.SysDataDao;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.common.PolicyComeRequest;
import com.trm.model.common.SysDataSimDetail;
import com.trm.model.equip.EquipDetail;
import com.trm.model.equip.PDFRequest;
import com.trm.model.equip.PDFResponse;
import com.trm.model.member.MemberDetail;
import com.trm.model.news.NewsDetail;
import com.trm.model.report.ReportDetail;
import com.trm.model.require.DemandDetails;
import com.trm.model.techservorg.TechServOrgDetail;
import com.trm.service.equip.EquipService;
import com.trm.service.member.MemberService;
import com.trm.service.news.NewsService;
import com.trm.service.report.ReportService;
import com.trm.service.require.DemandService;
import com.trm.service.techservorg.TechServOrgService;
import com.trm.util.LoginCheckUtil;
import com.trm.util.PDFUtil;
import com.trm.util.SessionUtil;
import com.trm.util.pdf.PdfCreateMethod;
import com.trm.util.pdf.obj.NewsPdfObj;
import com.trm.util.pdf.obj.PdfNewsRequest;
import com.trm.util.pdf.util.RandomUtil;

/**
 * PDF下载通用Controller
 * @date 2018-3-1 14:40:13
 * @author zhaosimiao
 *
 */
@Controller
@Transactional(rollbackFor = Exception.class)
public class PDFDownloadController {

    private static Logger logger = LoggerFactory.getLogger(PDFDownloadController.class);
    
    @Autowired
    private LoginCheckUtil loginCheckUtil;
    
    @Autowired
    private SysDataDao sysDataDao;
    
    @Autowired
    private MemberService memberService;
    
    @Autowired
    private EquipService equipService;
    
    @Autowired
    private DemandService demandService;
    
    @Autowired
    private TechServOrgService techServOrgService;
    
    @Autowired
    private ReportService reportService;
    
    @Autowired
    private NewsService newsService;
    
    /**
     * 下载技术服务机构
     * add by zhaosimiao 2018-8-14 15:51:48
     * @param request
     * @param req
     * @param resp
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/downloadOrgPDF", method = RequestMethod.POST)
    @ResponseBody
    public PDFResponse downloadOrgPDF(@RequestBody PDFRequest request, HttpServletRequest req,
            HttpServletResponse resp) throws BusinessException {
    	
    	String outFilePath = req.getSession().getServletContext().getRealPath("pdffiles");
    	Integer itemId = request.getItemId();
        // String itemType = request.getItemType();
        // String isDetail = request.getIsDetail();
        logger.info("[技术服务机构下载]查询id为 {}", itemId);
        
        TechServOrgDetail detail = techServOrgService.findDetailById(itemId);
        
        String audStatus = detail.getAudStatus();
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
        detail.setAudStatus(audStatus);
        
        PdfCreateMethod pcm = new PdfCreateMethod();
        String fileName = "ORG" + RandomUtil.getRandomFileName();
        String orgPath = outFilePath + System.getProperty("file.separator") + fileName +".pdf";
        String path = pcm.createPDF(orgPath, detail, fileName + ".pdf");
        logger.info("[技术服务机构下载]PDF生成物理路径：", path);
        PDFResponse response = new PDFResponse();
        response.setFilePath("/pdffiles/" + fileName + ".pdf");
        logger.info("[技术服务机构下载]查询 return：{}", response.getFilePath().toString());
        return response;
    }
    
    /**
     * 下载通知公告  add by zhaosimiao 2018-5-4 11:36:52
     * @param request
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/downloadNoticePDF", method = RequestMethod.POST)
    @ResponseBody
    public PDFResponse downloadNoticePDF(@Valid @RequestBody PdfNewsRequest request, HttpServletRequest req,
            HttpServletResponse resp) throws BusinessException {
    	
    	String outFilePath = req.getSession().getServletContext().getRealPath("pdffiles");
    	
        logger.info("[通知公告下载]查询id为 {}", request.getId());
        NewsDetail detail = newsService.findDetailById(request.getId());
        NewsPdfObj news = new NewsPdfObj();
        news.setTitle(detail.getTitle());
        news.setPublishTime(new SimpleDateFormat("yyyy-MM-dd").format(detail.getPublishTime()).toString());
        news.setOrigin(detail.getOrigin());
        news.setPublishUnit(detail.getPublishUnit());
        news.setContext(detail.getContext());
        
        PdfCreateMethod pcm = new PdfCreateMethod();
        String fileName = "NEWS" + RandomUtil.getRandomFileName();
        String newsPath = outFilePath + System.getProperty("file.separator") + fileName +".pdf";
        String path = pcm.createPDF(newsPath, news, fileName + ".pdf");
        logger.info("[通知公告下载]PDF生成物理路径：", path);
        PDFResponse response = new PDFResponse();
        response.setFilePath("/pdffiles/" + fileName + ".pdf");
        logger.info("[通知公告下载]查询 return：{}", response.toString());
        return response;
    }

    @RequestMapping(value = "/downloadPDF", method = RequestMethod.POST)
    @ResponseBody
    public PDFResponse downloadPDF(@Valid @RequestBody PDFRequest parameter, HttpServletRequest req,
            HttpServletResponse resp) throws Exception {
        
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, req, resp);
        
        PDFResponse response = new PDFResponse();
        String pdfFilePath = "";
        Integer itemId = parameter.getItemId();
        String itemType = parameter.getItemType();
        String isDetail = parameter.getIsDetail();
        
        if("0".equals(itemType)) {
        	MemberDetail detail = memberService.getUserinfoById(userId);
        	pdfFilePath = PDFUtil.downLoadPdf(req, detail, isDetail);
        }
        else if("1".equals(itemType)) {
            
            EquipDetail detail = equipService.findDetailById(itemId);
            
            String equipType = detail.getEquipType();
            String serviceRange = detail.getServiceRange();
            
            detail.setEquipType(sysDataDao.getByCode(equipType).getName());
            
            PolicyComeRequest eq = new PolicyComeRequest();
            eq.setCode("SR");
            CommonListResponse<SysDataSimDetail> slit = sysDataDao.findAll(eq);
            String[] multiKeys = StringUtils.split(serviceRange, SystemConstants.SYSTEM_COMMA);
            for (String c : multiKeys) {
                for (SysDataSimDetail ob : slit.getList()) {
                    if (c.equals(ob.getCode())) {
                        serviceRange = serviceRange.replace(c, ob.getName());
                    }
                }
            }
            detail.setServiceRange(serviceRange);
            logger.info("当前操作：下载设备设施PDFmethod:downloadPDF,response：" + detail + ",下载完成");
            
            pdfFilePath = PDFUtil.downLoadPdf(req, detail, isDetail);
        }
        
        else if("2".equals(itemType)) {
        	DemandDetails detail = demandService.findDemandDetail(itemId);
        	pdfFilePath = PDFUtil.downLoadPdf(req, detail, isDetail);
        }
        
        else if("3".equals(itemType)) {
        	TechServOrgDetail detail = techServOrgService.findDetailById(itemId);
        	pdfFilePath = PDFUtil.downLoadPdf(req, detail, isDetail);
        }
        else if("4".equals(itemType)) {
        	ReportDetail detail = reportService.getReportById(itemId);
        	pdfFilePath = PDFUtil.downLoadPdf(req, detail, isDetail);
        }
        
        response.setFilePath(pdfFilePath);
        
        return response;
    }

    /**
	 * 区分操作系统，如果是windows返回 file:/否则返回空
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
