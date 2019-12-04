package com.trm.controller.banner;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trm.entity.exception.BusinessException;
import com.trm.model.banner.BannerDetail;
import com.trm.model.banner.BannerListDetail;
import com.trm.model.banner.BannerRequest;
import com.trm.model.common.CommonListResponse;
import com.trm.model.common.FindDetailsById;
import com.trm.service.banner.BannerService;

/**
 * Banner
 * @author zhaosimiao 2017-11-14 13:54:46
 */
@Controller
@RequestMapping("/")
public class BannerController {

    public static Logger logger = LoggerFactory.getLogger(BannerController.class);

    @Autowired
    private BannerService bannerService;

    @RequestMapping(value = "/findBanners", method = RequestMethod.POST)
    @ResponseBody
    public CommonListResponse<BannerListDetail> findBanners(@Valid @RequestBody BannerRequest request) throws BusinessException {
        logger.info("[Banner列表]列表查询 request：{}", request);
        CommonListResponse<BannerListDetail> list = bannerService.findBanners(request);
        logger.info("[Banner列表]列表查询 return：{}", list);
        return list;
    }

    @RequestMapping(value = "/getBannerById", method = RequestMethod.POST)
    @ResponseBody
    public BannerDetail getBannerById(@Valid @RequestBody FindDetailsById request) throws BusinessException {
        logger.info("[Banner详情]查询id为 {}", request.getId());
        BannerDetail detail = bannerService.getBannerById(request.getId());
        logger.info("[Banner详情]查询 return：{}", detail.toString());
        return detail;
    }

}
