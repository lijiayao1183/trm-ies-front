package com.trm.dao.news;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trm.dao.common.BaseDao;
import com.trm.entity.TrmNews;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.news.MaterialRequest;
import com.trm.model.news.NewsListResponse;
import com.trm.model.news.NewsMaterialSimDetail;
import com.trm.model.news.NewsPic;
import com.trm.model.news.NewsReq;
import com.trm.model.news.NewsSimDetail;
import com.trm.util.BeanUtils;
import com.trm.util.Datetime;
import com.trm.util.ParameterUtils;
import com.trm.util.paging.QueryPage;

/**
 * @description 
 */
@Repository("newsDao")
public class NewsDaoImpl extends BaseDao implements NewsDao {

	public static Logger logger = LoggerFactory.getLogger(NewsDaoImpl.class);

    @SuppressWarnings("unchecked")
    @Override
	public NewsListResponse<NewsSimDetail> findAll(NewsReq requestParameter) throws BusinessException {
	    List<Object> list = new ArrayList<Object>();
	    Date startT = requestParameter.getPublishStartTime();
        Date endT = requestParameter.getPublishEndTime();
        String publishWhere = "";
        if(null != startT && null != endT){
            list.add(startT);
            list.add(Datetime.getDateAmountDays(endT,1));
            publishWhere = " and a.publishTime >= ? and a.publishTime <= ? ";
        }
	    String hql = "select new com.trm.model.news.NewsSimDetail(id, title, flagCode, publishTime, picture, summary,publishUnit) "
	            + "from TrmNews where 1=1 "+publishWhere+" and title like ? and flagCode like ? and updater like ? and publishStatus = 'Y' order by FIELD(isTop,'Y') DESC, IF(ISNULL(topSort),1,0),topSort ASC,publishTime DESC ";
	    list.add(ParameterUtils.getLikeParam(requestParameter.getTitle()));
	    list.add(ParameterUtils.getLikeParam(requestParameter.getFlagCode()));
	    list.add(ParameterUtils.getLikeParam(requestParameter.getUpdater()));
        Object[] param = list.toArray();

        NewsListResponse<NewsSimDetail> response = new NewsListResponse<NewsSimDetail>();
        QueryPage query = new QueryPage(hql.toString(), param, requestParameter.getPageNum(), requestParameter.getNum(), this.getHibernateTemplate());
        response.setPageTotal(query.getPages());
        response.setList(query.getResult());
        response.setCount(query.getCount());
        
        String hql2 = "from TrmNews where picture IS NOT NULL and picture <> '' and flagCode = ? ORDER BY updateTime DESC ";
        TrmNews Detail = (TrmNews) this.currentSession().createQuery(hql2).setParameter(0, requestParameter.getFlagCode()).setMaxResults(1).uniqueResult();
        NewsSimDetail s = new NewsSimDetail();
        BeanUtils.copyProperties(Detail, s);
        response.setPicturesObject(s);
        return response;
	}
	
    @Override
    public TrmNews findDetailById(Integer id) throws BusinessException {
        String hql = "from TrmNews where id =:id ";
        TrmNews Detail = (TrmNews) this.currentSession().createQuery(hql).setParameter("id", id).uniqueResult();
        return Detail;
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<NewsPic> getNewsPicList() {
		List<NewsPic> list = new ArrayList<NewsPic>();
		String hql = "select new com.trm.model.news.NewsPic(a.id, a.title, a.picture)"
				+ " from TrmNews a"
				+ " where a.picture IS NOT NULL and a.picture <> '' and a.flagCode = '2' ORDER BY a.updateTime DESC ";
		list = this.currentSession().createQuery(hql).setMaxResults(5).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NewsMaterialSimDetail> getMaterialList(Integer newsId) {
		String hql = "select new com.trm.model.news.NewsMaterialSimDetail("
				+ "id, newsId, materialName, materialUrl, updateTime, createTime) from TrmNewsMaterial where newsId =:newsId ";
		List<NewsMaterialSimDetail> list = (List<NewsMaterialSimDetail>) this.currentSession().createQuery(hql).setParameter("newsId", newsId).list();
        return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public CommonListResponse<NewsMaterialSimDetail> findMaterials(MaterialRequest request) throws BusinessException {
		List<Object> list = new ArrayList<Object>();
        String title = request.getTitle();
        String titleHql = "";
        if (StringUtils.isNotEmpty(title)) {
            titleHql = " and a.materialName like ?";
            list.add(ParameterUtils.getLikeParam(title));
        }
        Object[] param = list.toArray();

		String hql = "select new com.trm.model.news.NewsMaterialSimDetail(a.id, a.newsId, a.materialName, a.materialUrl, a.updateTime, a.createTime)"
                + " from TrmNewsMaterial a"
                + " where 1=1"
                + titleHql
                + " order by a.createTime desc";
        
        CommonListResponse<NewsMaterialSimDetail> response = new CommonListResponse<NewsMaterialSimDetail>();
        
        QueryPage query = new QueryPage(hql.toString(), param, request.getPageNum(), request.getNum(),
                this.getHibernateTemplate());

        response.setPageTotal(query.getPages());
        response.setList(query.getResult());
        response.setCount(query.getCount());
        
        return response;
	}
	
}
