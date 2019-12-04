package com.trm.service.msg;

import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonResponse;
import com.trm.model.msg.MsgDetail;

/**
 * 消息模板
 * @author zhaosimiao 2017-10-11 10:36:36
 */
public interface
MsgService {
	
    public MsgDetail getDescription(String msgName) throws BusinessException;
    
    public CommonResponse equipBooking(Integer userId, String equipId, String siteMsgType) throws Exception;
    
    public CommonResponse checkBCStatus(Integer userId, Integer equipId, Integer flag) throws Exception;
    
}
