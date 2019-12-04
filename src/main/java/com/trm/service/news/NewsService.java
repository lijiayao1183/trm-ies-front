package com.trm.service.news;

import java.util.List;

import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.news.MaterialRequest;
import com.trm.model.news.NewsDetail;
import com.trm.model.news.NewsListResponse;
import com.trm.model.news.NewsMaterialSimDetail;
import com.trm.model.news.NewsPic;
import com.trm.model.news.NewsReq;
import com.trm.model.news.NewsSimDetail;
import com.trm.model.news.PublishNewsReq;

/**
 * @author dell
 *
 */
public interface NewsService {
    /**
     * 查询咨询列表
     * @Title findAll
     * @param requestParameter
     * @return
     * @throws BusinessException 参数说明
     * @return OperatorDetails 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public NewsListResponse<NewsSimDetail> findAll(NewsReq requestParameter) throws BusinessException;

    /**
     * 根据id查询详情
     * @Title findDetailById
     * @param id
     * @return
     * @throws BusinessException 参数说明
     * @return NewsDetail 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public NewsDetail findDetailById(Integer id) throws BusinessException;

    /**
     * 新增一条资讯
     * @Title createNews
     * @param requestParameter
     * @return
     * @throws BusinessException 参数说明
     * @return boolean 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public boolean createNews(NewsDetail requestParameter) throws Exception;

    /**
     * 删除一条或多条资讯
     * @Title deleteById
     * @param id
     * @return
     * @throws Exception 参数说明
     * @return boolean 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public boolean deleteById(String id) throws Exception;

    /**
     * 编辑一条资讯
     * @Title modifyNews
     * @param requestParameter
     * @return
     * @throws Exception 参数说明
     * @return boolean 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public boolean modifyNews(NewsDetail requestParameter) throws Exception;

    /**
     * 发布资讯
     * @Title publishData
     * @Description 
     * @param requestParameter
     * @return
     * @throws Exception 参数说明
     * @return boolean 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public boolean publishData(PublishNewsReq requestParameter) throws Exception;
    
    /**
     * 查询最新5条资讯轮播图
     * @return
     */
    public List<NewsPic> getNewsPicList();
    
    public CommonListResponse<NewsMaterialSimDetail> findMaterials(MaterialRequest request) throws BusinessException;
}
