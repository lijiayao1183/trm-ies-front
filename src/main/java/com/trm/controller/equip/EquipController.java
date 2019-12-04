package com.trm.controller.equip;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trm.constants.SystemConstants;
import com.trm.entity.business.CommonResponse;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.AuditRequest;
import com.trm.model.common.ComIntData;
import com.trm.model.common.CommonListResponse;
import com.trm.model.common.FindDetailsById;
import com.trm.model.equip.CateCountEquip;
import com.trm.model.equip.EquipDayReq;
import com.trm.model.equip.EquipDetail;
import com.trm.model.equip.EquipReq;
import com.trm.model.equip.EquipSimDetail;
import com.trm.model.equip.HomeEquipReq;
import com.trm.model.equip.HomeEquipSimDetail;
import com.trm.model.equip.MyEquipReq;
import com.trm.model.equip.MyEquipSimDetail;
import com.trm.model.equip.NotDisplayReq;
import com.trm.model.session.SessionBean;
import com.trm.service.equip.EquipService;
import com.trm.util.FileUtil;
import com.trm.util.LoginCheckUtil;
import com.trm.util.SessionUtil;
import com.trm.util.batch.BatchEquip;
import com.trm.util.batch.BatchEquipFileRequest;

/**
 * 设备模块
 * @ClassName EquipController
 * @author huyuanbo
 * @Date 2017年9月22日 上午9:06:25
 * @version 1.0.0
 */
@Controller
@RequestMapping("/equip/info")
@Transactional(rollbackFor = Exception.class)
public class EquipController {
    
    public static Logger logger = LoggerFactory.getLogger(EquipController.class);
    
    @Autowired
    private EquipService equipService;
    
    @Value("#{filePath.domain}")
    private String domain;
    
    /**
     * 富文本图片保存数据库时需要的--前缀
     */
    //@Value("#{filePath.db_rich_text_img_prefix}")
    //private String RichTextImgPrefix;
    
    /** 虚拟路径 */
    @Value("#{filePath.virtual_path}")
    private String virtualPath;
    /** 物理路径 */
    @Value("#{filePath.physical_path}")
    private String physicalPath;
    
    @Autowired
    private LoginCheckUtil loginCheckUtil;
    
    /**
     * 首页查询全部
     * @Title findAll
     * @Description 查询设备列表
     * @param requestParameter
     * @return
     * @throws BusinessException 参数说明
     * @return CommonListResponse<EquipSimDetail> 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    @RequestMapping(value = "/homeFindAll", method = RequestMethod.POST)
    @ResponseBody
    public CommonListResponse<HomeEquipSimDetail> findAll(@Valid @RequestBody HomeEquipReq requestParameter)
            throws BusinessException {
        logger.info("[首页设备列表]列表查询 request：{}", requestParameter);
        CommonListResponse<HomeEquipSimDetail> list = equipService.findAll(requestParameter);
        logger.info("[首页设备列表]列表查询 return：{}", list);
        return list;
    }
    
    /**
     * 高级搜搜查询
     * @Title findAll
     * @Description 查询设备列表
     * @param requestParameter
     * @return
     * @throws BusinessException 参数说明
     * @return CommonListResponse<EquipSimDetail> 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    @RequestMapping(value = "/seniorFindAll", method = RequestMethod.POST)
    @ResponseBody
    public CommonListResponse<EquipSimDetail> seniorFindAll(@Valid @RequestBody EquipReq requestParameter)
            throws BusinessException {
        logger.info("[高级搜索设备列表]列表查询 request：{}", requestParameter);
        CommonListResponse<EquipSimDetail> list = equipService.seniorFindAll(requestParameter);
        logger.info("[高级搜索设备列表]列表查询 return：{}", list);
        return list;
    }
    
    /**
     * 我的设备
     * @Title findAllMyEqip
     * @Description
     * @param requestParameter
     * @return
     * @throws BusinessException 参数说明
     * @return CommonListResponse<EquipSimDetail> 返回类型
     * @throws
     * @see
     * @author huyuanbo
     * @throws IOException
     */
    @RequestMapping(value = "/findAllMyEqip", method = RequestMethod.POST)
    @ResponseBody
    public CommonListResponse<MyEquipSimDetail> findAllMyEqip(@Valid @RequestBody MyEquipReq requestParameter,
            HttpServletRequest request, HttpServletResponse response) throws BusinessException, IOException {
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, request, response);
        
        requestParameter.setOrgId(userId);
        logger.info("[我的设备列表]列表查询 request：{}", requestParameter);
        CommonListResponse<MyEquipSimDetail> list = equipService.findAllMyEqip(requestParameter);
        logger.info("[我的设备列表]列表查询 return：{}", list);
        return list;
    }
    
    /**
     * 按id查询详情
     * @Title findDetailById
     * @Description 查询设备详情信息
     * @param requestParameter
     * @return
     * @throws BusinessException 参数说明
     * @return EquipDetail 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    @RequestMapping(value = "/findDetailById", method = RequestMethod.POST)
    @ResponseBody
    public EquipDetail findDetailById(@Valid @RequestBody FindDetailsById requestParameter, HttpServletRequest request)
            throws BusinessException {
        SessionBean sessionBean = SessionUtil.getSesssionBean();
        String requestHeader = request.getHeader("referer");
        
        /*
        if (null == sessionBean) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.FRONT_USER_NOT_LOGIN);
            bs.setExceptionMsg("用户未登录！");
            throw bs;
        }*/
        logger.info("[设备详情]查询id为 {}", requestParameter.getId());
        EquipDetail info = equipService.findDetailById(requestParameter.getId());
        if (StringUtils.isNotEmpty(requestHeader) && !requestHeader.contains("ucenter")) {
            if (null == info || !"F2".equals(info.getAudStatus()) || "N".equals(info.getIsDisplay())) {
                BusinessException bs = new BusinessException();
                bs.setExceptionCode(SystemConstants.REASONCODE_2048);
                bs.setExceptionMsg("设备详情查询为空！");
                throw bs;
            }
        }
        if (null == sessionBean) {
            info.setLinkPerson("******");
            info.setLinkPhone("******");
            // info.setLinkUnit("******");
            info.setEmail("******");
            info.setLinkAddress("******");
        }
        logger.info("[设备详情]查询 return：{}", info);
        return info;
    }
    
    /**
     * 新增设备时保存
     * @Title createData
     * @Description 新增一条设备数据
     * @param requestParameter
     * @param request
     * @return
     * @throws Exception 参数说明
     * @return CommonResponse 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    @RequestMapping(value = "/createData", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse createData(@Valid @RequestBody EquipDetail requestParameter, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, request, response);
        requestParameter.setOrgId(userId);
        
        logger.info("[新增设备] request：{}", requestParameter);
        boolean createFlag = false;
        CommonResponse msg = new CommonResponse();
        createFlag = equipService.createEquip(requestParameter);
        if (createFlag) {
            msg.setMessage(SystemConstants.TRM_SUCCESS);
        } else {
            msg.setMessage(SystemConstants.TRM_ERROR);
        }
        logger.info("[新增设备] return：{}", msg);
        return msg;
    }
    
    /**
     * 新增设备时提交
     * @Title createData
     * @Description
     * @param requestParameter
     * @param request
     * @return
     * @throws Exception 参数说明
     * @return CommonResponse 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    @RequestMapping(value = "/submitData", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse submitData(@Valid @RequestBody EquipDetail requestParameter, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, request, response);
        requestParameter.setOrgId(userId);
        
        logger.info("[提交设备] request：{}", requestParameter);
        boolean createFlag = false;
        CommonResponse msg = new CommonResponse();
        createFlag = equipService.submitData(requestParameter);
        if (createFlag) {
            msg.setMessage(SystemConstants.TRM_SUCCESS);
        } else {
            msg.setMessage(SystemConstants.TRM_ERROR);
        }
        logger.info("[提交设备] return：{}", msg);
        return msg;
    }
    
    /**
     * 删除指定一条或者多条
     * @Title deleteById
     * @Description 删除数据
     * @param request
     * @param req
     * @return
     * @throws Exception 参数说明
     * @return CommonResponse 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    @ResponseBody
    public com.trm.model.common.CommonResponse deleteById(@RequestBody Map<String, String> request,
            HttpServletRequest req, HttpServletResponse resp) throws Exception {
        
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, req, resp);
        
        String id = request.get("id");
        logger.info("[删除设备]request id为 {}", id);
        return equipService.deleteById(id);
        
    }
    
    /**
     * 编辑一条数据
     * @Title modifyData
     * @Description 编辑数据
     * @param requestParameter
     * @param request
     * @return
     * @throws Exception 参数说明
     * @return CommonResponse 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    @RequestMapping(value = "/modifyData", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse modifyData(@Valid @RequestBody EquipDetail requestParameter, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, request, response);
        
        requestParameter.setOrgId(userId);
        
        logger.info("[编辑设备] request：{}", requestParameter);
        boolean updateFlag = false;
        CommonResponse msg = new CommonResponse();
        updateFlag = equipService.modifyEquip(requestParameter);
        if (updateFlag) {
            msg.setMessage(SystemConstants.TRM_SUCCESS);
        } else {
            msg.setMessage(SystemConstants.TRM_ERROR);
        }
        logger.info("[编辑设备] return：{}", msg);
        return msg;
    }
    
    /**
     * 上下架
     * @Title notDisplay
     * @Description
     * @param requestParameter
     * @param request
     * @return
     * @throws Exception 参数说明
     * @return CommonResponse 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    @RequestMapping(value = "/shelvesDisplay", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse shelvesDisplay(@Valid @RequestBody NotDisplayReq requestParameter, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, request, response);
        
        logger.info("[上下架设备] request：{}", requestParameter);
        boolean updateFlag = false;
        CommonResponse msg = new CommonResponse();
        updateFlag = equipService.notDisplay(requestParameter);
        if (updateFlag) {
            msg.setMessage(SystemConstants.TRM_SUCCESS);
        } else {
            msg.setMessage(SystemConstants.TRM_ERROR);
        }
        logger.info("[上下架设备] return：{}", msg);
        return msg;
    }
    
    /**
     * 下架设备
     * @Title notDisplay
     * @Description
     * @param requestParameter
     * @param request
     * @return
     * @throws Exception 参数说明
     * @return CommonResponse 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    @RequestMapping(value = "/notDisplay", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse notDisplay(@Valid @RequestBody NotDisplayReq requestParameter, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        logger.info("[下架设备] request：{}", requestParameter);
        
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, request, response);
        
        boolean updateFlag = false;
        CommonResponse msg = new CommonResponse();
        updateFlag = equipService.notDisplay(requestParameter);
        if (updateFlag) {
            msg.setMessage(SystemConstants.TRM_SUCCESS);
        } else {
            msg.setMessage(SystemConstants.TRM_ERROR);
        }
        logger.info("[下架设备] return：{}", msg);
        return msg;
    }
    
    /*@RequestMapping(value = "/getViewCount", method = RequestMethod.POST)
    @ResponseBody
    public boolean getViewCount(@Valid @RequestBody FindDetailsById request) throws BusinessException {
        logger.info("[设备设施检索详情更新设备游览次数]查询id为 {}", request.getId());
        boolean viewCount = equipService.viewCount(request.getId(), request.getViewCount());
        logger.info("[设备设施检索详情返回更新结果]", viewCount);
        return viewCount;
    }*/
    
    @RequestMapping(value = "/seniorEquipTop", method = RequestMethod.POST)
    @ResponseBody
    public List<EquipSimDetail> seniorEquipTop(HttpServletRequest request) throws BusinessException {
        logger.info("[设备详情页排序]");
        List<EquipSimDetail> list = equipService.seniorEquipTop();
        logger.info("[设备详情页排序] return：{}", list);
        return list;
    }
    
    /**
     * 方法迁移
     */
    /*@RequestMapping(value = "/downloadPDF", method = RequestMethod.POST)
    @ResponseBody
    public PDFResponse downloadPDF(@Valid @RequestBody PDFRequest parameter, HttpServletRequest req,
            HttpServletResponse resp) throws Exception {
        
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, req, resp);
        
        PDFResponse response = new PDFResponse();
        EquipDetail detail = equipService.findDetailById(parameter.getItemId());
        
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
        
        String PDFFilePath = PDFUtil.downLoadPdf(req, detail);
        response.setFilePath(PDFFilePath);
        logger.info("当前操作：下载设备设施PDFmethod:downloadPDF,response：" + detail + ",下载完成");
        return response;
    }*/
    
    /**
     * 左侧设备设施滚动
     * @param comIntData
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/recentlyMoreEquip", method = RequestMethod.POST)
    @ResponseBody
    public List<CateCountEquip> recentlyMoreEquip(@RequestBody ComIntData comIntData) throws BusinessException {
        return equipService.recentlyMoreEquip(comIntData);
    }
    
    /**
     * 某天的设备设施
     * @param equipDayReq
     * @throws BusinessException
     */
    @RequestMapping(value = "/equipOfDay", method = RequestMethod.POST)
    @ResponseBody
    public CommonListResponse<HomeEquipSimDetail> equipOfDay(@RequestBody EquipDayReq equipDayReq)
            throws BusinessException {
        return equipService.findEquipByDay(equipDayReq);
        
    }
    
    /**
     * 上下架
     * @Title notDisplay
     * @Description
     * @param auditEquipReq
     * @param request
     * @return
     * @throws Exception 参数说明
     * @return CommonResponse 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    @RequestMapping(value = "/auditDate", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse auditDate(@Valid @RequestBody AuditRequest auditEquipReq, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, request, response);
        
        logger.info("[设备设施信息] request：{}", auditEquipReq);
        boolean updateFlag = false;
        auditEquipReq.setAuditor(SessionUtil.getUsernameFromSession());
        auditEquipReq.setAuditDate(new Date());
        auditEquipReq.setAuditType("1");
        CommonResponse msg = new CommonResponse();
        updateFlag = equipService.auditDate(auditEquipReq);
        if (updateFlag) {
            msg.setMessage(SystemConstants.TRM_SUCCESS);
        } else {
            msg.setMessage(SystemConstants.TRM_ERROR);
        }
        logger.info("[设备设施信息消息] return：{}", msg);
        return msg;
    }
    
    @ResponseBody
    @RequestMapping(value = "/importData", method = RequestMethod.POST)
    public List<BatchEquip> importData(@Valid @RequestBody BatchEquipFileRequest req , HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, request, response);
        logger.info("当前操作：导入设备设施数据[前台]method:importData,用户:" + userId + ",入参：" + req.toString());
        String filePath = req.getFilePath();
        String suffix = FileUtil.getSmallName(filePath);
        if (!suffix.contains("xls")) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("模板格式错误！");
            throw bs;
        }
        
        List<BatchEquip> list = equipService.importData(req);
        logger.info("当前操作：导入设备设施数据[前台]method:importData,response：" + list + ",查询完成");
        return list;
    }
}
