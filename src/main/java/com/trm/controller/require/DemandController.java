/**
 * @Title: DemandController.java
 * @Package: com.trm.controller.require
 * @Description: TODO(用一句话描述该文件做什么)
 * @Copyright: Copyright (c)
 * @Company: Digital Telemedia Co.,Ltd
 * @author LiuJC
 * @date 2018年02月26 上午10:48
 * @version V1.0
 * @Revision 2018年02月26 上午10:48
 */

package com.trm.controller.require;

import com.trm.entity.exception.BusinessException;
import com.trm.model.common.AuditRequest;
import com.trm.model.common.ComIntData;
import com.trm.model.common.CommonListResponse;
import com.trm.model.common.CommonResponse;
import com.trm.model.common.FindDetailsById;
import com.trm.model.equip.EquipDayReq;
import com.trm.model.require.CateCountDemand;
import com.trm.model.require.DemandDetails;
import com.trm.model.require.DemandIndex;
import com.trm.model.require.DemandListResp;
import com.trm.model.require.DemandReq;
import com.trm.model.require.RequireRequest;
import com.trm.model.session.SessionBean;
import com.trm.service.require.DemandService;
import com.trm.util.LoginCheckUtil;
import com.trm.util.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @ClassName DemandController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author LiuJC
 * @Date 2018年02月26 上午10:48
 * @version 1.0.0
 */
@Controller
@RequestMapping("/")
public class DemandController {
    public static Logger logger = LoggerFactory.getLogger(DemandController.class);
    
    @Autowired
    private DemandService demandService;
    
    @Autowired
    private LoginCheckUtil loginCheckUtil;
    
    /**
     * 新增接口
     * @param demandReq
     * @param req
     * @param resp
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/createDemand", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse createDemand(@Valid @RequestBody DemandReq demandReq, HttpServletRequest req,
            HttpServletResponse resp) throws Exception {
        logger.info("[新增新军民融合需求] request：{}", demandReq);
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, req, resp);
        
        CommonResponse response = demandService.createDemand(demandReq);
        logger.info("[新增军民融合需求] return：{}", response);
        return response;
    }
    
    /**
     * 个人中心列表  列表
     * @param request
     * @param req
     * @param resp
     * @return
     * @throws BusinessException
     * @throws IOException
     */
    @RequestMapping(value = "/myDemand", method = RequestMethod.POST)
    @ResponseBody
    public CommonListResponse<DemandListResp> myDemand(@Valid @RequestBody RequireRequest request,
            HttpServletRequest req, HttpServletResponse resp) throws Exception {
        logger.info("[军民融合需求个人中心列表]列表查询 request：{}", request);
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, req, resp);
        CommonListResponse<DemandListResp> list = demandService.myDemand(request);
        logger.info("[军民融合需求个人中心列表]列表查询 return：{}", list);
        return list;
    }
    
    /**
     * 个人中心- 需求详情
     * @param request
     * @param req
     * @param resp
     * @return
     * @throws BusinessException
     * @throws IOException
     */
    @RequestMapping(value = "/getMyDemandById", method = RequestMethod.POST)
    @ResponseBody
    public DemandDetails getMyRequireById(@Valid @RequestBody FindDetailsById request, HttpServletRequest req,
            HttpServletResponse resp) throws BusinessException, IOException {
        logger.info("[军民融合需求详情]查询id为 {}", request.getId());
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, req, resp);
        DemandDetails demandDetails = demandService.getMyDemandById(request.getId());
        logger.info("[军民融合需求详情]查询 return：{}", demandDetails.toString());
        return demandDetails;
    }
    
    /**
     * 删除
     * @param map
     * @param req
     * @param resp
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/deleteDemand", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse deleteDemand(@RequestBody Map<String, String> map, HttpServletRequest req,
            HttpServletResponse resp) throws Exception {
        String id = map.get("id");
        logger.info("[删除军民融合需求]request id为 {}", id);
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, req, resp);
        CommonResponse response = demandService.deleteById(id);
        logger.info("[删除军民融合需求] return：{}", response);
        return response;
    }
    
    /**
     * 修改
     * @param demandReq
     * @param req
     * @param resp
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/modifyDemand", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse modifyRequire(@Valid @RequestBody DemandReq demandReq, HttpServletRequest req,
            HttpServletResponse resp) throws Exception {
        logger.info("[编辑军民融合需求] request：{}", demandReq);
        Integer userId = SessionUtil.getUserIdFromSession();
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(userId, req, resp);
        CommonResponse response = demandService.modifyDemand(demandReq);
        logger.info("[编辑军民融合需求] return：{}", response);
        return response;
    }
    
    /**
     * 审核状态
     * @param req
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/auditDemandData", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse auditData(@Valid @RequestBody AuditRequest req, HttpServletRequest request) throws Exception {
        String userName = SessionUtil.getUsernameFromSession();
        req.setAuditor(userName);
        logger.info("[审核需求] request：{}", req);
        boolean updateFlag = false;
        CommonResponse msg = new CommonResponse();
        updateFlag = demandService.auditDemand(req);
        if (updateFlag) {
            msg.setCodeAndMsg("0000", "需求状态修改成功！");
        } else {
            msg.setCodeAndMsg("9999", "需求状态修改成功！");
        }
        logger.info("[审核需求] return：{}", msg);
        return msg;
    }
    
    @RequestMapping(value = "/homeDemands", method = RequestMethod.POST)
    @ResponseBody
    public CommonListResponse<DemandIndex> homeRequires(@Valid @RequestBody RequireRequest request)
            throws BusinessException {
        logger.info("[军民融合需求首页列表]列表查询 request：{}", request);
        CommonListResponse<DemandIndex> list = demandService.homeDemands(request);
        logger.info("[军民融合需求首页列表]列表查询 return：{}", list);
        return list;
    }
    
    /**
     * 左侧需求滚动
     * @param comIntData
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/recentlyMoreDemand", method = RequestMethod.POST)
    @ResponseBody
    public List<CateCountDemand> recentlyMoreEquip(@RequestBody ComIntData comIntData) throws BusinessException {
        return demandService.recentlyMoreDemand(comIntData);
    }
    
    /**
     * 列表查询
     * @param request
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/findDemand", method = RequestMethod.POST)
    @ResponseBody
    public CommonListResponse<DemandIndex> findDemand(@Valid @RequestBody RequireRequest request)
            throws BusinessException {
        logger.info("[军民融合需求列表]列表查询 request：{}", request);
        CommonListResponse<DemandIndex> listResponse = demandService.findDemand(request);
        logger.info("[军民融合需求列表]列表查询 return：{}", listResponse);
        return listResponse;
    }
    
    /**
     * 查询详情
     * @param request
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/getDemandById", method = RequestMethod.POST)
    @ResponseBody
    public DemandDetails getRequireById(@Valid @RequestBody FindDetailsById request) throws BusinessException {
        logger.info("[军民融合需求详情]查询id为 {}", request.getId());
        SessionBean sessionBean = SessionUtil.getSesssionBean();
        DemandDetails demandDetail = demandService.findDemandDetail(request.getId());
        if (null == sessionBean) {
            // demandDetail.getTrmDemand().setCompanyName("******");
            demandDetail.getTrmDemand().setCompanyAddr("******");
            demandDetail.getTrmDemand().setContacts("******");
            demandDetail.getTrmDemand().setPhone("******");
        }
        logger.info("[军民融合需求详情]查询 return：{}", demandDetail.toString());
        return demandDetail;
    }
    
    /**
     * 列表查询
     * @param request
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/findHotDemand", method = RequestMethod.POST)
    @ResponseBody
    public CommonListResponse<DemandIndex> findHotDemand(@Valid @RequestBody RequireRequest request)
            throws BusinessException {
        logger.info("[军民融合需求列表]列表查询 request：{}", request);
        CommonListResponse<DemandIndex> listResponse = demandService.findHotDemand(request);
        logger.info("[军民融合需求列表]列表查询 return：{}", listResponse);
        return listResponse;
    }
    
    /**
     * 某天的设备设施
     * @param equipDayReq
     * @throws BusinessException
     */
    @RequestMapping(value = "/demandOfDay", method = RequestMethod.POST)
    @ResponseBody
    public CommonListResponse<DemandIndex> equipOfDay(@RequestBody EquipDayReq equipDayReq) throws BusinessException {
        return demandService.findDemandByDay(equipDayReq);
        
    }
}
