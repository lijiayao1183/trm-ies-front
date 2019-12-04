package com.trm.service.myconcern;

import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.common.CommonResponse;
import com.trm.model.myconcern.CareEquipStatus;
import com.trm.model.myconcern.CareEquipRequest;
import com.trm.model.myconcern.CareEquipSimDetail;

/**
 * 我的关注模块
 * @author zhaosimiao 2017年10月17日 14:33:36
 */
public interface EqpReqService {
   
    public CommonListResponse<CareEquipSimDetail> findCareEquips(CareEquipRequest request) throws BusinessException;

    public CommonResponse careEquip(CareEquipStatus request)throws Exception;
    
}
