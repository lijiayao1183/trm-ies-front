package com.trm.controller.organ;

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
import com.trm.model.organ.OrganDetail;
import com.trm.model.organ.OrganReq;
import com.trm.model.organ.OrganSimDetail;
import com.trm.service.organ.OrganService;

/**
 * 机构（推荐）配置
 * @ClassName MessageController
 * @Description 
 * @author huyuanbo
 * @Date 2017年9月26日 上午9:21:21
 * @version 1.0.0
 */
@Controller
@RequestMapping("/organ/info")
public class OrganController {

    public static Logger logger = LoggerFactory.getLogger(OrganController.class);

    @Autowired
    private OrganService organService;

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
     * @Description 查询机构（推荐）配置列表
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
    public CommonListResponse<OrganSimDetail> homeFindAll(@Valid @RequestBody OrganReq requestParameter) throws BusinessException {
        logger.info("[机构（推荐）配置列表]列表查询 request：{}", requestParameter);
        CommonListResponse<OrganSimDetail> list = organService.findAll(requestParameter);
        logger.info("[机构（推荐）配置列表]列表查询 return：{}", list);
        return list;
    }

    /**
     * 2.按id查询详情
     * @Title findDetailById
     * @Description 查询机构（推荐）配置详情信息
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
    public OrganDetail findDetailById(@Valid @RequestBody FindDetailsById requestParameter) throws BusinessException {
        logger.info("[机构（推荐）配置详情]查询id为 {}", requestParameter.getId());
        OrganDetail info = organService.findDetailById(requestParameter.getId());
        logger.info("[机构（推荐）配置详情]查询 return：{}", info);
        return info;
    }
    
    @RequestMapping(value = "/getViewCount", method = RequestMethod.POST)
    @ResponseBody
    public boolean getViewCount(@Valid @RequestBody FindDetailsById request) throws BusinessException {
        logger.info("[机构详情更新设备游览次数]查询id为 {}", request.getId());
        boolean viewCount = organService.viewCount(request.getId(), request.getViewCount());
        logger.info("[机构详情返回更新结果]", viewCount);
        return viewCount;
    }
    
    @RequestMapping(value = "/findOrganTop", method = RequestMethod.POST)
    @ResponseBody
    public List<OrganSimDetail> findOrganTop(HttpServletRequest request) throws BusinessException {
        logger.info("[机构详情页排序]列表查询 request：{}", request);
        List<OrganSimDetail> list = organService.findOrganTop();        
        logger.info("[机构详情页排序]列表查询 return：{}", list);
        return list;
    }
}
