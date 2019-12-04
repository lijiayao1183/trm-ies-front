package com.trm.dao.msg;

import com.trm.entity.TrmMsg;
import com.trm.entity.exception.BusinessException;

/**
 * 消息模板
 * @author zhaosimiao 2017-10-11 10:36:36
 */
public interface MsgDao {
	
    public TrmMsg getDescription(String msgName) throws BusinessException;
    
}
