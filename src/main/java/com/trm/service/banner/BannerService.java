package com.trm.service.banner;

import com.trm.entity.exception.BusinessException;
import com.trm.model.banner.BannerDetail;
import com.trm.model.banner.BannerListDetail;
import com.trm.model.banner.BannerRequest;
import com.trm.model.common.CommonListResponse;

/**
 * 导航
 * @author zhaosimiao 2017-11-22 10:19:36
 */
public interface BannerService {
	
	public CommonListResponse<BannerListDetail> findBanners(BannerRequest request) throws BusinessException;
	
    public BannerDetail getBannerById(Integer id) throws BusinessException;
   
}
