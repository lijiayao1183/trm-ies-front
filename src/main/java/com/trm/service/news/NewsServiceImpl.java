package com.trm.service.news;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trm.constants.SystemConstants;
import com.trm.dao.common.CommonDao;
import com.trm.dao.news.NewsDao;
import com.trm.entity.TrmNews;
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
import com.trm.util.BeanUtils;

/**
 * @description
 */
@Service("newsService")
@Transactional(rollbackFor = Exception.class)
public class NewsServiceImpl implements NewsService {

    public static Logger logger = LoggerFactory.getLogger(NewsServiceImpl.class);

    @Autowired
    private NewsDao newsDao;

    @Autowired
    private CommonDao commonDao;

    @Override
    public NewsListResponse<NewsSimDetail> findAll(NewsReq requestParameter) throws BusinessException {
        NewsListResponse<NewsSimDetail> result = newsDao.findAll(requestParameter);
        // 信息为空时，抛出异常
        if (result.getList().size() < 1) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("资讯列表查询为空！");
            throw bs;
        }
        return result;
    }

    @Override
    public NewsDetail findDetailById(Integer id) throws BusinessException {
        TrmNews entity = newsDao.findDetailById(id);
        if (null == entity) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("资讯详情查询为空！");
            throw bs;
        }
        NewsDetail target = new NewsDetail();
        BeanUtils.copyProperties(entity, target);
        
        List<NewsMaterialSimDetail> nmList = newsDao.getMaterialList(id);
        target.setNmList(nmList);
        
        return target;
    }

    @Override
    public boolean createNews(NewsDetail requestParameter) throws Exception {
        TrmNews entity = new TrmNews();
        BeanUtils.copyProperties(requestParameter, entity);
        String isTop = entity.getIsTop();
        if (null != isTop && isTop.equals(SystemConstants.FLAG_N)) {
            entity.setTopSort(null);
        }
        entity.setIsActive(SystemConstants.FLAG_Y);
        return commonDao.createEntity(entity);
    }

    @Override
    public boolean deleteById(String id) throws Exception {
        //实体
        TrmNews entity = new TrmNews();
        //根据id查询实体
        List<Object> listEntity = commonDao.findListEntity(id, entity);
        // 物理删除
        return commonDao.deleteAll(listEntity);
    }

    @Override
    public boolean modifyNews(NewsDetail requestParameter) throws Exception {
        TrmNews info = newsDao.findDetailById(requestParameter.getId());
        BeanUtils.copyProperties(requestParameter, info);
        String isTop = info.getIsTop();
        if (null != isTop && isTop.equals(SystemConstants.FLAG_N)) {
            info.setTopSort(null);
        }
        return commonDao.modifyEntity(info);
    }

    @Override
    public boolean publishData(PublishNewsReq requestParameter) throws Exception {
        TrmNews info = newsDao.findDetailById(requestParameter.getId());
        BeanUtils.copyProperties(requestParameter, info);
        String status = info.getPublishStatus();
        if(null != status && status.equals(SystemConstants.FLAG_Y)){
            info.setPublishTime(new Date());
        }
        return commonDao.modifyEntity(info);
    }

	@Override
	public List<NewsPic> getNewsPicList() {
		List<NewsPic> list = newsDao.getNewsPicList();
		return list;
	}

	@Override
	public CommonListResponse<NewsMaterialSimDetail> findMaterials(MaterialRequest request) throws BusinessException {
		CommonListResponse<NewsMaterialSimDetail> result = newsDao.findMaterials(request);
        // 信息为空时，抛出异常
        if (result.getList().size() < 1) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("资料下载列表查询为空！");
            throw bs;
        }
        return result;
	}
	
	
}
