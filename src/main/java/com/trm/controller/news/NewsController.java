package com.trm.controller.news;

import java.util.List;

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
import com.trm.model.news.MaterialRequest;
import com.trm.model.news.NewsDetail;
import com.trm.model.news.NewsListResponse;
import com.trm.model.news.NewsMaterialSimDetail;
import com.trm.model.news.NewsPic;
import com.trm.model.news.NewsReq;
import com.trm.model.news.NewsSimDetail;
import com.trm.service.news.NewsService;

/**
 * 资讯模块
 * @ClassName NewsController
 * @Description 
 * @author huyuanbo
 * @Date 2017年9月29日 下午1:15:15
 * @version 1.0.0
 */
@Controller
@RequestMapping("/news/info")
public class NewsController {

    public static Logger logger = LoggerFactory.getLogger(NewsController.class);
    
    @Autowired
    private NewsService newsService;

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
     * 
     * @param requestParameter.pageNum
     *            当前页码
     * @param requestParameter.num
     *            每页数量
     * @param requestParameter.title
     *            标题
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/homeFindAll", method = RequestMethod.POST)
    @ResponseBody
    public NewsListResponse<NewsSimDetail> homeFindAll(@Valid @RequestBody NewsReq requestParameter) throws BusinessException {
        logger.info("[资讯列表]列表查询 request：{}", requestParameter);
        NewsListResponse<NewsSimDetail> list = newsService.findAll(requestParameter);
        logger.info("[资讯列表]列表查询 return：{}", list);
        return list;
    }

    /**
     * 2.按id查询详情
     * 
     * @param request
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/findDetailById", method = RequestMethod.POST)
    @ResponseBody
    public NewsDetail findDetailById(@Valid @RequestBody FindDetailsById requestParameter) throws BusinessException {
        logger.info("[资讯详情]查询id为 {}", requestParameter.getId());
        NewsDetail info = newsService.findDetailById(requestParameter.getId());
        logger.info("[资讯详情]查询 return：{}", info);
        return info;
    }

    @RequestMapping(value = "/getNewsPicList", method = RequestMethod.POST)
    @ResponseBody
    public List<NewsPic> getNewsPicList() throws BusinessException {
        List<NewsPic> list = newsService.getNewsPicList();
        return list;
    }
    
    @RequestMapping(value = "/findMaterials", method = RequestMethod.POST)
    @ResponseBody
    public CommonListResponse<NewsMaterialSimDetail> findMaterials(@Valid @RequestBody MaterialRequest request) throws BusinessException {
        logger.info("[资料下载]列表查询 request：{}", request);
        CommonListResponse<NewsMaterialSimDetail> list = newsService.findMaterials(request);
        logger.info("[资料下载]列表查询 return：{}", list);
        return list;
    }
}
