package com.trm.service.banner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trm.constants.SystemConstants;
import com.trm.dao.banner.BannerDao;
import com.trm.entity.TrmBanner;
import com.trm.entity.exception.BusinessException;
import com.trm.model.banner.BannerDetail;
import com.trm.model.banner.BannerListDetail;
import com.trm.model.banner.BannerRequest;
import com.trm.model.common.CommonListResponse;
import com.trm.util.BeanUtils;

/**
 * 军民融合需求
 * @author zhaosimiao 2017-11-14 13:54:46
 */
@Service("bannerService")
@Transactional(rollbackFor = Exception.class)
public class BannerServiceImpl implements BannerService {

    public static Logger logger = LoggerFactory.getLogger(BannerServiceImpl.class);
    
    @Autowired
    private BannerDao bannerDao;

	@Override
	public CommonListResponse<BannerListDetail> findBanners(BannerRequest request) throws BusinessException {
		CommonListResponse<BannerListDetail> response = bannerDao.findBanners(request);
		if(response.getList().size() < 1) {
			BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("Banner列表查询为空！");
            throw bs;
		}
		for(BannerListDetail detail : response.getList()) {
			String siteCode = detail.getSiteCode();
			if("1".equals(siteCode)) {
				detail.setSiteCode("首页");
			}
			else if("2".equals(siteCode)){
				detail.setSiteCode("新闻资讯");
			}
			else if("3".equals(siteCode)){
				detail.setSiteCode("设备设施检索");
			}
			else if("4".equals(siteCode)){
				detail.setSiteCode("军民融合需求");
			}
		}
		return response;
	}

	@Override
	public BannerDetail getBannerById(Integer id) throws BusinessException {
		TrmBanner entity = bannerDao.getBannerById(id);
		if (null == entity) {
            BusinessException bs = new BusinessException();
            bs.setExceptionMsg("该id对应的banner不存在！");
            throw bs;
        }
		BannerDetail detail = new BannerDetail();
		BeanUtils.copyProperties(entity, detail);
		return detail;
	}
    
}
