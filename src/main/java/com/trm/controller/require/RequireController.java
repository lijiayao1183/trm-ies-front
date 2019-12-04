package com.trm.controller.require;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.trm.model.common.CommonListResponse;
import com.trm.model.common.CommonResponse;
import com.trm.model.common.FindDetailsById;
import com.trm.model.require.RequireAudit;
import com.trm.model.require.RequireDetail;
import com.trm.model.require.RequireListDetail;
import com.trm.model.require.RequireMyListDetail;
import com.trm.model.require.RequireRequest;
import com.trm.model.require.RequireSimDetail;
import com.trm.model.session.SessionBean;
import com.trm.service.require.RequireService;
import com.trm.util.LoginCheckUtil;
import com.trm.util.SessionUtil;

/**
 * 军民融合需求
 * @author zhaosimiao 2017-11-14 13:54:46
 */
@Controller
@RequestMapping("/")
public class RequireController {

    public static Logger logger = LoggerFactory.getLogger(RequireController.class);

    @Autowired
    private RequireService requireService;
    
    @Autowired
    private LoginCheckUtil loginCheckUtil;
    
    @RequestMapping(value = "/homeRequires", method = RequestMethod.POST)
    @ResponseBody
    public CommonListResponse<RequireSimDetail> homeRequires(@Valid @RequestBody RequireRequest request) throws BusinessException {
        logger.info("[军民融合需求首页列表]列表查询 request：{}", request);
        CommonListResponse<RequireSimDetail> list = requireService.homeRequires(request);
        logger.info("[军民融合需求首页列表]列表查询 return：{}", list);
        return list;
    }

    @RequestMapping(value = "/findRequires", method = RequestMethod.POST)
    @ResponseBody
    public CommonListResponse<RequireListDetail> findRequires(@Valid @RequestBody RequireRequest request) throws BusinessException {
        logger.info("[军民融合需求列表]列表查询 request：{}", request);
        CommonListResponse<RequireListDetail> list = requireService.findRequires(request);
        logger.info("[军民融合需求列表]列表查询 return：{}", list);
        return list;
    }

    @RequestMapping(value = "/getRequireById", method = RequestMethod.POST)
    @ResponseBody
    public RequireDetail getRequireById(@Valid @RequestBody FindDetailsById request) throws BusinessException {
    	SessionBean sessionBean = SessionUtil.getSesssionBean();
        logger.info("[军民融合需求详情]查询id为 {}", request.getId());
        RequireDetail detail = requireService.getRequireById(request.getId());
        if (null == sessionBean) {
        	detail.setRequireUnit("******");
        	detail.setAddress("******");
        	detail.setLinkMan("******");
        	detail.setLinkPhone("******");
        }
        logger.info("[军民融合需求详情]查询 return：{}", detail.toString());
        return detail;
    }
    
    @RequestMapping(value = "/getMyRequireById", method = RequestMethod.POST)
    @ResponseBody
    public RequireDetail getMyRequireById(@Valid @RequestBody FindDetailsById request,
    		HttpServletRequest req, HttpServletResponse resp) throws BusinessException, IOException {
        logger.info("[军民融合需求详情]查询id为 {}", request.getId());
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, req, resp);
        RequireDetail detail = requireService.getMyRequireById(request.getId());
        logger.info("[军民融合需求详情]查询 return：{}", detail.toString());
        return detail;
    }

    @RequestMapping(value = "/createRequire", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse createRequire(@Valid @RequestBody RequireDetail detail,
    		HttpServletRequest req, HttpServletResponse resp) throws Exception {
        logger.info("[新增军民融合需求] request：{}", detail);
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, req, resp);
        CommonResponse response = requireService.createRequire(detail);
        logger.info("[新增军民融合需求] return：{}", response);
        return response;
    }
    
    @RequestMapping(value = "/modifyRequire", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse modifyRequire(@Valid @RequestBody RequireDetail detail, 
    		HttpServletRequest req, HttpServletResponse resp) throws Exception {
        logger.info("[编辑军民融合需求] request：{}", detail);
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, req, resp);
        CommonResponse response = requireService.modifyRequire(detail);
        logger.info("[编辑军民融合需求] return：{}", response);
        return response;
    }

    @RequestMapping(value = "/deleteRequire", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse deleteRequire(@RequestBody Map<String, String> map,
    		HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String id = map.get("id");
        logger.info("[删除军民融合需求]request id为 {}", id);
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, req, resp);
        CommonResponse response = requireService.deleteById(id);
        logger.info("[删除军民融合需求] return：{}", response);
        return response;
    }
    
    @RequestMapping(value = "/myRequires", method = RequestMethod.POST)
    @ResponseBody
    public CommonListResponse<RequireMyListDetail> myRequires(@Valid @RequestBody RequireRequest request,
    		HttpServletRequest req, HttpServletResponse resp) throws BusinessException, IOException {
        logger.info("[军民融合需求个人中心列表]列表查询 request：{}", request);
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, req, resp);
        CommonListResponse<RequireMyListDetail> list = requireService.myRequires(request);
        logger.info("[军民融合需求个人中心列表]列表查询 return：{}", list);
        return list;
    }
    
    @RequestMapping(value = "/getViewCount", method = RequestMethod.POST)
    @ResponseBody
    public boolean getViewCount(@Valid @RequestBody FindDetailsById request) throws BusinessException {
        logger.info("[军民融合需求详情更新设备游览次数]查询id为 {}", request.getId());
        boolean viewCount = requireService.viewCount(request.getId(), request.getViewCount());
        logger.info("[军民融合需求详情返回更新结果]", viewCount);
        return viewCount;
    }
    
    @RequestMapping(value = "/findRequiresTop", method = RequestMethod.POST)
    @ResponseBody
    public List<RequireListDetail> findRequiresTop(HttpServletRequest request) throws BusinessException {
        logger.info("[军民融合需求列表]列表查询 request：{}", request);
        List<RequireListDetail> list = requireService.findRequiresTop();        
        logger.info("[军民融合需求列表]列表查询 return：{}", list);
        return list;
    }
    
    @RequestMapping(value = "/shiftRequire", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse shiftRequire(@Valid @RequestBody RequireAudit request, 
    		HttpServletRequest req, HttpServletResponse resp) throws Exception {
        logger.info("[编辑军民融合需求] request：{}", request);
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, req, resp);
        CommonResponse response = requireService.shiftRequire(request);
        logger.info("[编辑军民融合需求] return：{}", response);
        return response;
    }
}
