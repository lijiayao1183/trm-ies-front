package com.trm.controller.laboratory;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.common.FindDetailsById;
import com.trm.model.laboratory.LaboratoryDetail;
import com.trm.model.laboratory.LaboratoryReq;
import com.trm.model.laboratory.LaboratorySimDetail;
import com.trm.service.laboratory.LaboratoryService;

/**
 * 技术服务机构
 * @ClassName LaboratoryController
 * @Description 
 * @author huyuanbo
 * @Date 2017年10月10日 下午1:37:39
 * @version 1.0.0
 */
@Controller
@RequestMapping("/laboratory/info")
public class LaboratoryController {

    public static Logger logger = LoggerFactory.getLogger(LaboratoryController.class);

    @Autowired
    private LaboratoryService laboratoryService;

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
     * @author huyuanbo
     */
    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    @ResponseBody
    public CommonListResponse<LaboratorySimDetail> findAll(@Valid @RequestBody LaboratoryReq requestParameter) throws BusinessException {
        logger.info("[技术服务机构列表]列表查询 request：{}", requestParameter);
        CommonListResponse<LaboratorySimDetail> list = laboratoryService.findAll(requestParameter);
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
     * @author huyuanbo
     */
    @RequestMapping(value = "/findDetailById", method = RequestMethod.POST)
    @ResponseBody
    public LaboratoryDetail findDetailById(@Valid @RequestBody FindDetailsById requestParameter) throws BusinessException {
        /*SessionBean sessionBean = SessionUtil.getSesssionBean();
        if (null == sessionBean) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.FRONT_USER_NOT_LOGIN);
            bs.setExceptionMsg("用户未登录！");
            throw bs;
        }*/
        logger.info("[技术服务机构详情]查询id为 {}", requestParameter.getId());
        LaboratoryDetail info = laboratoryService.findDetailById(requestParameter.getId());
        logger.info("[技术服务机构详情]查询 return：{}", info);
        return info;
    }
    
    @RequestMapping(value = "/getViewCount", method = RequestMethod.POST)
    @ResponseBody
    public boolean getViewCount(@Valid @RequestBody FindDetailsById request) throws BusinessException {
        logger.info("[技术服务机构更新访问量]查询id为 {}", request.getId());
        boolean viewCount = laboratoryService.viewCount(request.getId(), request.getViewCount());
        logger.info("[技术服务机构返回更新结果]", viewCount);
        return viewCount;
    }
    
    @RequestMapping(value = "/findLaboratoryTop", method = RequestMethod.POST)
    @ResponseBody
    public List<LaboratorySimDetail> findLaboratoryTop(HttpServletRequest request) throws BusinessException {
        logger.info("[技术服务机构详情页排序]列表查询 request：{}", request);
        List<LaboratorySimDetail> list = laboratoryService.findLaboratoryTop();        
        logger.info("[技术服务机构详情页排序]列表查询 return：{}", list);
        return list;
    }

}
