package com.trm.controller.myconcern;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
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
import com.trm.model.myconcern.CareEquipRequest;
import com.trm.model.myconcern.CareEquipStatus;
import com.trm.model.myconcern.CareEquipSimDetail;
import com.trm.model.session.SessionBean;
import com.trm.service.myconcern.EqpReqService;
import com.trm.util.LoginCheckUtil;
import com.trm.util.SessionUtil;

/**
 * 我的关注模块
 * @author zhaosimiao 2017年10月17日 14:33:36
 */
@Controller
@RequestMapping("/")
public class EqpReqController {

    public static Logger logger = LoggerFactory.getLogger(EqpReqController.class);
    
    @Autowired
    private EqpReqService eqpReqService;
    
    @Autowired
    private LoginCheckUtil loginCheckUtil;

    /**
     * 查询某个用户设备关注列表
     * @author zhaosimiao 2017-10-17 16:00:36
     * @throws IOException 
     */
    @RequestMapping(value = "/findCareEquips", method = RequestMethod.POST)
    @ResponseBody
    public CommonListResponse<CareEquipSimDetail> findCareEquips(@Valid @RequestBody CareEquipRequest request, HttpServletRequest requests, HttpServletResponse response) throws BusinessException, IOException {
        // 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(SessionUtil.getUserIdFromSession(), requests, response); 	
    	logger.info("[我的关注]设备列表查询 ，入参：", request.toString());        
        SessionBean sessionBean = SessionUtil.getSesssionBean();
        CommonListResponse<CareEquipSimDetail> list = null;
        Integer userId;
        if(sessionBean == null) {
        	// 未登录
        	BusinessException bs = new BusinessException();
            bs.setExceptionMsg("未登录状态！");
            throw bs;
        }
        else {
        	// 已登录
        	userId = sessionBean.getId();
        	logger.info("[我的关注]设备列表查询 ，用户id：", userId);
        	request.setUserId(userId);
        	list = eqpReqService.findCareEquips(request);
        }
        
        logger.info("[我的关注]列表查询 ，出参：", list);
        return list;
    }

    /**
     * 添加设备关注/取消设备关注
     * @author zhaosimiao 2017-10-17 14:37:48
     */
    @RequestMapping(value = "/careEquip", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse careEquip(@Valid @RequestBody CareEquipStatus requestParameter, HttpServletRequest request) throws Exception {
    	logger.info("[添加设备关注] request：{}", requestParameter.toString());
    	CommonResponse response = new CommonResponse();
        SessionBean sessionBean = SessionUtil.getSesssionBean();
        Integer userId;
        Integer eqpId = requestParameter.getEqpId();
        String focusStatus = requestParameter.getFocusStatus();
        if(sessionBean == null) {
        	response.setCodeAndMsg("E0", "用户未登录，不能添加关注！");
        }
        else if(eqpId == null || StringUtils.isEmpty(focusStatus)) {
        	response.setCodeAndMsg("E1", "设备id或关注状态不能为空！");
        }
        else {
        	userId = sessionBean.getId();
	        requestParameter.setOrgId(userId);
	        response = eqpReqService.careEquip(requestParameter);
        }
        logger.info("[添加设备关注] return：{}", response.toString());
        return response;
    }
    
}
