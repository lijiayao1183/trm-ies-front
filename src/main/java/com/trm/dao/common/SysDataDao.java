package com.trm.dao.common;

import com.trm.entity.SysDataDictionary;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.common.CommonRequest;
import com.trm.model.common.SysDataSimDetail;

import java.util.List;

public interface SysDataDao {
    
    /**
     * 根据supercode返回数据字典列表
     * @return
     * @throws BusinessException
     */
    public CommonListResponse<SysDataSimDetail> findAll(CommonRequest request) throws BusinessException;
    
    public SysDataDictionary getByCode(String code);
    
    List<SysDataDictionary> findServiceDomain(CommonRequest request);
    
}
