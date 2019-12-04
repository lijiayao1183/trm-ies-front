package com.trm.dao.banner;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trm.dao.common.BaseDao;
import com.trm.entity.TrmBanner;
import com.trm.entity.exception.BusinessException;
import com.trm.model.banner.BannerListDetail;
import com.trm.model.banner.BannerRequest;
import com.trm.model.common.CommonListResponse;
import com.trm.util.paging.QueryPage;

/**
 * 导航
 * @author zhaosimiao 2017-11-22 10:19:36
 */
@Repository("bannerDao")
public class BannerDaoImpl extends BaseDao implements BannerDao {

	public static Logger logger = LoggerFactory.getLogger(BannerDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public CommonListResponse<BannerListDetail> findBanners(BannerRequest request) throws BusinessException {
		
		String siteCodeHql = "";
		List<Object> list = new ArrayList<Object>();
		Object[] param = null;
		
		if(StringUtils.isNotEmpty(request.getSiteCode())) {
			siteCodeHql =  " and a.siteCode = ?";
			list.add(request.getSiteCode());
		}
		param = list.toArray();
		
		String hql = "select new com.trm.model.banner.BannerListDetail(a.id, a.siteCode, a.bannerUp, a.bannerDown, a.videoUrl, a.bgColour, a.imgUrl, a.brief, a.sortNo)"
				+ " from TrmBanner a"
				+ " where 1=1"
				+ siteCodeHql
				+ " order by a.id desc";
		
		CommonListResponse<BannerListDetail> response = new CommonListResponse<BannerListDetail>();
		QueryPage query = new QueryPage(hql.toString(), param, request.getPageNum(), request.getNum(), this.getHibernateTemplate());
		response.setPageTotal(query.getPages());
        response.setList(query.getResult());
        response.setCount(query.getCount());
        
		return response;
	}

	@Override
	public TrmBanner getBannerById(Integer id) throws BusinessException {
		String hql = "from TrmBanner where id =:id ";
		TrmBanner detail = (TrmBanner) this.currentSession().createQuery(hql).setParameter("id", id).uniqueResult();
        return detail;
	}

}
