package com.trm.util.sitemsg;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.trm.dao.common.CommonDao;
import com.trm.dao.common.SysDataDao;
import com.trm.dao.msg.MsgDao;
import com.trm.entity.SysDataDictionary;
import com.trm.entity.TrmMsg;
import com.trm.entity.TrmMsgHistory;
import com.trm.model.common.CommonResponse;
import com.trm.model.msg.MsgHistory;
import com.trm.model.msg.SiteMsgRequest;
import com.trm.util.BeanUtils;

/**
 * 站内消息
 * @author zhaosimiao 2017-10-11 09:41:52
 */
@Component("siteMsgUtil")
@Transactional(rollbackFor = Exception.class)
public class SiteMsgUtil {

	@Autowired
	private SysDataDao sysDataDao;
	
	@Autowired
	private MsgDao msgDao;
	
	@Autowired
	private CommonDao commonDao;
	
	public CommonResponse sendSiteMsg(SiteMsgRequest request) throws Exception {
		
		CommonResponse response = new CommonResponse();
		
		String siteMsgType = request.getSiteMsgType();
		// 设备预约用户id
		Integer userId = request.getUserId();
		String username = request.getUsername();
		String dateTime = request.getDateTime();
		String equipName = request.getEquipName();
		String orderUser = request.getOrderUser();
		String orderMobile = request.getOrderMobile();
		
		String templetName = "";
		String templetContent = "";
		
		// 消息id
		Integer msgId = null;
		
		if(StringUtils.isNotEmpty(siteMsgType)) {
			
			SysDataDictionary sdd = sysDataDao.getByCode(siteMsgType);
			templetName = sdd.getName();
			
			TrmMsg msg = msgDao.getDescription(templetName);
			msgId = msg.getId();
			templetContent = msg.getDescription();
		}
		
		String content = templetContent.replaceAll("\\{用户名\\}", username)
				.replaceAll("\\{注册时间\\}", dateTime)
				.replaceAll("\\{申请时间\\}", dateTime)
				.replaceAll("\\{上架时间\\}", dateTime)
				.replaceAll("\\{设备设施名称\\}", equipName)
				.replaceAll("\\{预约用户名\\}", orderUser)
				.replaceAll("\\{预约用户注册手机号码\\}", orderMobile).replaceAll("\"", "\'");
		
		MsgHistory mh = new MsgHistory();
		TrmMsgHistory tmh = new TrmMsgHistory();
		
		mh.setRegId(userId);
		mh.setMsgId(msgId);
		mh.setMsgName(templetName);
		mh.setContent(content);
		mh.setReadingState("N");
		
		BeanUtils.copyProperties(mh, tmh);
		tmh.setIsActive("Y");
		
		boolean flag = commonDao.createEntity(tmh);
		
		if(flag) {
			response.setCodeAndMsg("0000", "站内消息发送成功！");
		}
		else {
			response.setCodeAndMsg("9999", "站内消息发送失败！");
		}
		
		return response;
	}

}
