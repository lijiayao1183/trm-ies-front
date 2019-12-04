package com.trm.service.msg;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trm.dao.common.CommonDao;
import com.trm.dao.equip.EquipDao;
import com.trm.dao.member.MemberDao;
import com.trm.dao.msg.MsgDao;
import com.trm.dao.myconcern.EqpReqDao;
import com.trm.entity.TrmEqpReq;
import com.trm.entity.TrmEquip;
import com.trm.entity.TrmMember;
import com.trm.entity.TrmMsg;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonResponse;
import com.trm.model.msg.MsgDetail;
import com.trm.model.msg.SiteMsgRequest;
import com.trm.util.BeanUtils;
import com.trm.util.mail.EquipBookMailUtil;
import com.trm.util.sitemsg.SiteMsgUtil;

/**
 * 消息模板
 * @author zhaosimiao 2017-10-11 10:36:36
 */
@Service("msgService")
@Transactional(rollbackFor = Exception.class)
public class MsgServiceImpl implements MsgService {

    public static Logger logger = LoggerFactory.getLogger(MsgServiceImpl.class);

    @Autowired
    private MsgDao msgDao;
    
    @Autowired
    private EqpReqDao eqpReqDao;
    
    @Autowired
    private MemberDao memberDao;
    
    @Autowired
    private EquipDao equipDao;
    
    @Autowired
    private CommonDao commonDao;
    
    @Resource
	private SiteMsgUtil siteMsgUtil;
    
    @Resource
	private EquipBookMailUtil equipBookMailUtil;

    @Override
    public MsgDetail getDescription(String msgName) throws BusinessException {
        TrmMsg entity = msgDao.getDescription(msgName);
        if (null == entity) {
            BusinessException bs = new BusinessException();
            bs.setExceptionMsg("消息模版查询为空！");
            throw bs;
        }
        MsgDetail detail = new MsgDetail();
        BeanUtils.copyProperties(entity, detail);
        return detail;
    }

	@Override
	public CommonResponse equipBooking(Integer userId, String equipId, String siteMsgType) throws Exception {
		CommonResponse response = new CommonResponse();
		
		// 设备预约用户
		TrmMember tm = memberDao.getUserinfoById(userId);
		// 预约设备
		TrmEquip te = equipDao.findDetailById(Integer.valueOf(equipId));
		
		// 不能针对自己发布的设备做关注和预约操作！modify by zhaosimiao at 2017-12-26 11:10:12
    	if(te != null && te.getOrgId().intValue() == userId.intValue()) {
    		response.setCodeAndMsg("E3", "不能针对自己发布的设备做关注和预约操作！");
    		return response;
    	}
		
		// 设备提供用户
		TrmMember equiptm = memberDao.getUserinfoById(te.getOrgId());
		
		SiteMsgRequest msg = new SiteMsgRequest();
		
		// 设备提供用户id
		msg.setUserId(te.getOrgId());
		// 站内消息类型
		msg.setSiteMsgType(siteMsgType);
		// 设备提供用户
		msg.setUsername(equiptm.getUsername());
		// 设备名称
		msg.setEquipName(te.getEquipName());
		// 设备预约用户
		msg.setOrderUser(tm.getUsername());
		// 预约用户和手机号码
		msg.setOrderMobile(tm.getPhone());
		
		TrmEqpReq checkEntity = eqpReqDao.checkCareRecord(userId, Integer.valueOf(equipId), 1);
		if(checkEntity == null) {
			// 添加预约记录
			TrmEqpReq entity = new TrmEqpReq();
			entity.setOrgId(userId);
			entity.setEqpId(Integer.valueOf(equipId));
			entity.setFocusStatus("Y");
			// add by zhaosimiao 2017-11-6 16:24:23
	        // regId 0 为关注记录
	        // regId 1 为预约记录
			entity.setRegId(1);
			entity.setIsActive("Y");
			commonDao.createEntity(entity);
		}
		else {
			response.setCodeAndMsg("E0", "已有预约记录，不能重复预约！");
			return response;
		}
		
		// 发送站内消息
		response = siteMsgUtil.sendSiteMsg(msg);
		// 发送设备预约邮件邮件
		equipBookMailUtil.send(equiptm.getUsername(), te.getEquipName(), tm.getUsername(), tm.getPhone(), equiptm.getEmail());
		
		if("0000".equals(response.getCode())) {
			response.setCodeAndMsg("0000", "预约成功！");
		}
		else {
			response.setCodeAndMsg("9999", "预约失败！");
		}
		
		return response;
	}
	
	@Override
	public CommonResponse checkBCStatus(Integer userId, Integer equipId, Integer flag) throws Exception {
		CommonResponse response = new CommonResponse();
		
		TrmEqpReq entity = eqpReqDao.checkCareEquip(userId, equipId, flag);
		if(entity == null) {
			if(flag == 0) {
				response.setCodeAndMsg("Y", "可进行【添加关注】操作！");
			}
			else {
				response.setCodeAndMsg("Y", "可进行【预约设备】操作!");
			}
		}
		else {
			if(flag == 0) {
				response.setCodeAndMsg("N", "可进行【取消关注】操作！");
			}
			else {
				response.setCodeAndMsg("N", "已有记录，不能重复预约!");
			}
		}
		return response;
	}
    
}
