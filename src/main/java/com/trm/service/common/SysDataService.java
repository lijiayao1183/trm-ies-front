package com.trm.service.common;

import java.util.List;

import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.common.CommonRequest;
import com.trm.model.common.SysDataSimDetail;
import com.trm.model.common.UnitResponse;

public interface SysDataService {
	/**
	 * 根据supercode返回数据字典列表
	 * @return
	 * @throws BusinessException
	 */
	public CommonListResponse<SysDataSimDetail> findAll(CommonRequest request)throws BusinessException;

	public List<UnitResponse> unitLinkage()throws BusinessException;
}
