package com.trm.controller.techservorg;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
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
import com.trm.model.session.SessionBean;
import com.trm.model.techservorg.HomePageOrg;
import com.trm.model.techservorg.OrgMaterialListResponse;
import com.trm.model.techservorg.OrgMaterialRequest;
import com.trm.model.techservorg.OrgOneKindMaterial;
import com.trm.model.techservorg.TechServOrgCenterDetail;
import com.trm.model.techservorg.TechServOrgDetail;
import com.trm.model.techservorg.TechServOrgHomeDetail;
import com.trm.model.techservorg.TechServOrgReq;
import com.trm.model.techservorg.TechServOrgSimDetail;
import com.trm.service.techservorg.TechServOrgService;
import com.trm.util.LoginCheckUtil;
import com.trm.util.SessionUtil;
import com.trm.util.UploadFileUtil;

/**
 * 技术服务机构
 * @author zhaosimiao 2018-2-24 14:36:36
 */
@Controller
@RequestMapping("/techservorg/info")
public class TechServOrgController {

    public static Logger logger = LoggerFactory.getLogger(TechServOrgController.class);

    @Autowired
    private TechServOrgService techServOrgService;
    
    @Autowired
    private LoginCheckUtil loginCheckUtil;

    @Value("#{filePath.db_rich_text_img_prefix}")
    private String richTextImgPrefix;

    /** 虚拟路径 */
    @Value("#{filePath.virtual_path}")
    private String virtualPath;
    /** 物理路径 */
    @Value("#{filePath.physical_path}")
    private String physicalPath;
    
    @RequestMapping(value = "/homeFindAll", method = RequestMethod.POST)
    @ResponseBody
    public HomePageOrg<TechServOrgHomeDetail> homeFindAll(@Valid @RequestBody TechServOrgReq requestParameter) throws BusinessException {
        logger.info("[技术服务机构列表]列表查询 request：{}", requestParameter);
        HomePageOrg<TechServOrgHomeDetail> list = techServOrgService.homeFindAll(requestParameter);
        logger.info("[技术服务机构列表]列表查询 return：{}", list);
        return list;
    }
    
    @RequestMapping(value = "/personalCenterFindAll", method = RequestMethod.POST)
    @ResponseBody
    public CommonListResponse<TechServOrgCenterDetail> personalCenterFindAll(@Valid @RequestBody TechServOrgReq requestParameter,
    		HttpServletRequest req, HttpServletResponse resp) throws Exception {
        logger.info("[技术服务机构列表]列表查询 request：{}", requestParameter);
        
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, req, resp);
        requestParameter.setUserId(userId);
        
        CommonListResponse<TechServOrgCenterDetail> list = techServOrgService.personalCenterFindAll(requestParameter);
        logger.info("[技术服务机构列表]列表查询 return：{}", list);
        return list;
    }
    
    @RequestMapping(value = "/personalCenterFindDetail", method = RequestMethod.POST)
    @ResponseBody
    public TechServOrgDetail personalCenterFindDetail(@Valid @RequestBody TechServOrgReq requestParameter,
    		HttpServletRequest req, HttpServletResponse resp) throws Exception {
        logger.info("[技术服务机构列表]列表查询 request：{}", requestParameter);
        
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, req, resp);
        requestParameter.setUserId(userId);
        
        TechServOrgDetail detail = techServOrgService.personalCenterFindDetail(requestParameter);
        logger.info("[技术服务机构列表]列表查询 return：{}", detail);
        return detail;
    }

    /**
     * 1.查询全部
     * @Title findAll
     * @Description 查询技术服务机构列表
     * @param requestParameter
     * @return
     * @throws BusinessException 参数说明
     * @return CommonListResponse<EquipSimDetail> 返回类型
     * @throws
     * @see
     * @author zhaosimiao
     */
    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    @ResponseBody
    public CommonListResponse<TechServOrgSimDetail> findAll(@Valid @RequestBody TechServOrgReq requestParameter) throws BusinessException {
        logger.info("[技术服务机构列表]列表查询 request：{}", requestParameter);
        CommonListResponse<TechServOrgSimDetail> list = techServOrgService.findAll(requestParameter);
        logger.info("[技术服务机构列表]列表查询 return：{}", list);
        return list;
    }

    /**
     * 2.按id查询详情
     * @Title findDetailById
     * @Description 查询技术服务机构详情信息
     * @param requestParameter
     * @return
     * @throws BusinessException 参数说明
     * @return EquipDetail 返回类型
     * @throws
     * @see
     * @author zhaosimiao
     */
    @RequestMapping(value = "/findDetailById", method = RequestMethod.POST)
    @ResponseBody
    public TechServOrgDetail findDetailById(@Valid @RequestBody FindDetailsById requestParameter) throws BusinessException {
        logger.info("[技术服务机构详情]查询id为 {}", requestParameter.getId());
        SessionBean sessionBean = SessionUtil.getSesssionBean();
        TechServOrgDetail info = techServOrgService.findDetailById(requestParameter.getId());
        if (null == sessionBean) {
        	info.setHeader("******");
        	info.setHeaderEmail("******");
        	info.setHeaderMobile("******");
        	info.setHeaderPhone("******");
        	info.setLinker("******");
        	info.setLinkerEmail("******");
        	info.setLinkerMobile("******");
        	info.setLinkerPhone("******");
        }
        
        Integer userId = SessionUtil.getUserIdFromSession();
        if(userId == null) {
        	info.setFileList(null);
        }
        else {
        	logger.info("[技术服务机构详情]查询 return：{}", info);
        }
        
        return info;
    }

    /**
     * 3.增加一条数据
     * @Title createData
     * @Description 新增一条技术服务机构数据
     * @param requestParameter
     * @param request
     * @return
     * @throws Exception 参数说明
     * @return CommonResponse 返回类型
     * @throws
     * @see
     * @author zhaosimiao
     */
    @RequestMapping(value = "/createData", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse createData(@Valid @RequestBody TechServOrgDetail requestParameter, HttpServletRequest request) throws Exception {
        String realPath = request.getSession().getServletContext().getRealPath("");
        // 正文富文本内容
        String context = requestParameter.getBrief();
        logger.info("[新增技术服务机构]介绍为{}", context);
        // 处理 正文 富文本内容中的图片
        context = UploadFileUtil.uploaRichdImg(realPath, context, physicalPath, richTextImgPrefix);
        requestParameter.setBrief(context);

        logger.info("[新增技术服务机构]介绍(处理后)为{}", context);
        
        logger.info("[新增技术服务机构] request：{}", requestParameter);
        
        CommonResponse msg = new CommonResponse();
        
        Integer userId = SessionUtil.getUserIdFromSession();
        requestParameter.setUserId(userId);
        
        msg = techServOrgService.createTechServOrg(requestParameter);
        
        logger.info("[新增技术服务机构] return：{}", msg);
        return msg;
    }

    /**
     * 4.删除指定一条或者多条
     * @Title deleteById
     * @Description 删除数据
     * @param request
     * @param req
     * @return
     * @throws Exception 参数说明
     * @return CommonResponse 返回类型
     * @throws
     * @see
     * @author zhaosimiao
     */
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse deleteById(@RequestBody Map<String, String> request, HttpServletRequest req) throws Exception {
        String id = request.get("id");
        logger.info("[删除技术服务机构]request id为 {}", id);
        boolean flag = techServOrgService.deleteById(id);
        CommonResponse response = new CommonResponse();
        if (flag) {
            response.setMessage(SystemConstants.TRM_SUCCESS);
        } else {
            response.setMessage(SystemConstants.TRM_ERROR);
        }
        logger.info("[删除技术服务机构] return：{}", response);
        return response;
    }

    /**
     * 5.编辑一条数据
     * @Title modifyData
     * @Description 编辑数据
     * @param requestParameter
     * @param request
     * @return
     * @throws Exception 参数说明
     * @return CommonResponse 返回类型
     * @throws
     * @see
     * @author zhaosimiao
     */
    @RequestMapping(value = "/modifyData", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse modifyData(@Valid @RequestBody TechServOrgDetail requestParameter, HttpServletRequest request) throws Exception {
        String realPath = request.getSession().getServletContext().getRealPath("");
        // 正文富文本内容
        String context = requestParameter.getBrief();
        logger.info("[编辑技术服务机构]介绍为{}", context);
        // 处理 正文 富文本内容中的图片
        context = UploadFileUtil.uploaRichdImg(realPath, context, physicalPath, richTextImgPrefix);
        requestParameter.setBrief(context);

        logger.info("[编辑技术服务机构]介绍(处理后)为{}", context);
        
        logger.info("[编辑技术服务机构] request：{}", requestParameter);
        
        CommonResponse msg = new CommonResponse();
        
        Integer userId = SessionUtil.getUserIdFromSession();
        requestParameter.setUserId(userId);
        
        msg = techServOrgService.modifyTechServOrg(requestParameter);
        
        logger.info("[编辑技术服务机构] return：{}", msg);
        return msg;
    }
    
    @RequestMapping(value = "/auditData", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse auditData(@Valid @RequestBody AuditRequest request, 
    		HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
    	
    	Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, req, resp);
        
        String userName = SessionUtil.getUsernameFromSession();
        request.setAuditor(userName);
        logger.info("[审核技术服务机构相关数据项] request：{}", request);
        boolean updateFlag = false;
        CommonResponse msg = new CommonResponse();
        updateFlag = techServOrgService.auditTechServOrg(request);
        if (updateFlag) {
            msg.setMessage(SystemConstants.TRM_SUCCESS);
        } else {
            msg.setMessage(SystemConstants.TRM_ERROR);
        }
        logger.info("[审核技术服务机构相关数据项] return：{}", msg);
        return msg;
    }
    
    /**
     * 左侧设备设施滚动
     * zhaosimiao 2018-2-28 13:36:13
     * @param comIntData
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/recentlyMoreOrg", method = RequestMethod.POST)
    @ResponseBody
    public List<CateCountEquip> recentlyMoreOrg(@RequestBody ComIntData comIntData) throws BusinessException {
        return techServOrgService.recentlyMoreOrg(comIntData);
    }
    
    /**
     * 某天的新发布的技术服务机构
     * @param equipDayReq
     * @throws BusinessException
     */
    @RequestMapping(value = "/orgOfDay", method = RequestMethod.POST)
    @ResponseBody
    public CommonListResponse<TechServOrgSimDetail> orgOfDay(@RequestBody EquipDayReq equipDayReq)
            throws BusinessException {
        return techServOrgService.findOrgByDay(equipDayReq);
        
    }
    
    /**
     * for test
     */
    @RequestMapping(value = "/findOrgKindMaterialList", method = RequestMethod.POST)
    @ResponseBody
    public OrgMaterialListResponse<OrgOneKindMaterial> findOrgKindMaterialList(@Valid @RequestBody OrgMaterialRequest request) throws BusinessException {
    	OrgMaterialListResponse<OrgOneKindMaterial> list = techServOrgService.findOrgKindMaterialList(request);
        return list;
    }
    
}
