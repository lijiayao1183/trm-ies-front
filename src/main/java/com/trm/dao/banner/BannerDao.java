package com.trm.dao.banner;

import com.trm.entity.TrmBanner;
import com.trm.entity.exception.BusinessException;
import com.trm.model.banner.BannerListDetail;
import com.trm.model.banner.BannerRequest;
import com.trm.model.common.CommonListResponse;

/**
 * 导航
 * @author zhaosimiao 2017-11-22 10:19:36
 */
public interface BannerDao {
	
	public CommonListResponse<BannerListDetail> findBanners(BannerRequest request) throws BusinessException;
	
    public TrmBanner getBannerById(Integer id) throws BusinessException;
    
}
