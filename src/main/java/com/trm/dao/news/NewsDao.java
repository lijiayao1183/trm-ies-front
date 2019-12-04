package com.trm.dao.news;

import java.util.List;

import com.trm.entity.TrmNews;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.news.MaterialRequest;
import com.trm.model.news.NewsListResponse;
import com.trm.model.news.NewsMaterialSimDetail;
import com.trm.model.news.NewsPic;
import com.trm.model.news.NewsReq;
import com.trm.model.news.NewsSimDetail;

public interface NewsDao {
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
     * @return TrmNews 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public TrmNews findDetailById(Integer id) throws BusinessException;
   
    /**
     * 查询最新5条资讯轮播图
     * @return
     */
    public List<NewsPic> getNewsPicList();
    
    /**
     * 根据新闻id，查找上传附件的list
     * add by zhaosimiao 2018-4-16 09:31:56
     * @param newsId
     * @return
     */
    public List<NewsMaterialSimDetail> getMaterialList(Integer newsId);
    
    /**
     * 查询资料下载列表
     * @param request
     * @return
     * @throws BusinessException
     */
    public CommonListResponse<NewsMaterialSimDetail> findMaterials(MaterialRequest request) throws BusinessException;
    
}
