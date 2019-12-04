package com.trm.dao.myconcern;

import com.trm.entity.TrmEqpReq;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.myconcern.CareEquipRequest;
import com.trm.model.myconcern.CareEquipSimDetail;
import com.trm.model.myconcern.CareEquipStatus;

/**
 * 我的关注模块
 * @author zhaosimiao 2017年10月17日 14:33:36
 */
public interface EqpReqDao {
	
    public CommonListResponse<CareEquipSimDetail> findCareEquips(CareEquipRequest request) throws BusinessException;
	
    public TrmEqpReq checkCareRecord(Integer orgId, Integer eqpId, Integer regId);
    
    public TrmEqpReq checkCareEquip(Integer orgId, Integer eqpId, Integer regId);
    
    public boolean updateCareEquip(CareEquipStatus request);
    
}
