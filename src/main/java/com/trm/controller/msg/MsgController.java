package com.trm.controller.msg;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trm.model.common.CommonResponse;
import com.trm.model.msg.BCCheckRequest;
import com.trm.model.msg.SiteMsgRequest;
import com.trm.service.msg.MsgService;
import com.trm.util.SessionUtil;
import com.trm.util.sitemsg.SiteMsgUtil;

/**
 * 消息
 * @author zhaosimiao
 * @Date 2017-10-11 09:48:33
 */
@Controller
@RequestMapping("/")
public class MsgController {

    public static Logger logger = LoggerFactory.getLogger(MsgController.class);

    @Resource
	private SiteMsgUtil siteMsgUtil;
    
    @Autowired
    private MsgService msgService;

    @RequestMapping(value = "/sendSiteMsg", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse sendSiteMsg(@Valid @RequestBody SiteMsgRequest request) throws Exception {
        logger.info("站内消息发送，入参：", request.toString());
        CommonResponse response = siteMsgUtil.sendSiteMsg(request);
        logger.info("站内消息发送，出参：", response.toString());
        return response;
    }
    
    @RequestMapping(value = "/equipBooking", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse equipBooking(@Valid @RequestBody SiteMsgRequest request) throws Exception {
        logger.info("设备预约，入参：", request.toString());
        CommonResponse response = new CommonResponse();
        Integer userId = SessionUtil.getUserIdFromSession();
		if(userId != null) {
			response = msgService.equipBooking(userId, request.getEquipId(), request.getSiteMsgType());
		}
		else {
			response.setCodeAndMsg("E0", "未登录状态！");
		}
		logger.info("设备预约，出参：", response.toString());
        return response;
    }
    
    @RequestMapping(value = "/checkBCStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse checkBCStatus(@Valid @RequestBody BCCheckRequest request) throws Exception {
        logger.info("设备预约状态检查，入参：", request.toString());
        CommonResponse response = new CommonResponse();
        Integer userId = SessionUtil.getUserIdFromSession();
		if(userId != null) {
			response = msgService.checkBCStatus(userId, request.getEquipId(), request.getFlag());
		}
		else {
			response.setCodeAndMsg("E0", "未登录状态！");
		}
		logger.info("设备预约状态检查，出参：", response.toString());
        return response;
    }

}
