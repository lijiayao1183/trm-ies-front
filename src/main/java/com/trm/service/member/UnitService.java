package com.trm.service.member;

import java.util.List;

import com.trm.entity.TrmUnit;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.member.SetDepartsList;
import com.trm.model.member.SetUnitsList;
import com.trm.model.member.SetUsersList;

/**
 * 单位部门信息查询
 * @author zhaosimiao 2017-11-14 13:54:46
 */
public interface UnitService {

	public List<SetUnitsList> getUnitsList(String orgName) throws BusinessException;
	
    public List<SetDepartsList> getDepartsList(Integer unitId) throws BusinessException;
	
    public List<SetUsersList> getUsersList(Integer id) throws BusinessException;

    CommonListResponse<TrmUnit> findList(String startDate, String endDate);
}
