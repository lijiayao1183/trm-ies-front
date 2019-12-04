package com.trm.dao.member;

import java.util.List;

import com.trm.entity.TrmUnit;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.member.SetDepartsList;
import com.trm.model.member.SetUnitsList;
import com.trm.model.member.SetUsersList;
import com.trm.model.register.CreditIdKeys;

/**
 * 单位部门信息查询
 * @author zhaosimiao 2017-11-14 13:54:46
 */
public interface UnitDao {
	
	public TrmUnit getUnitById(Integer id);
	
	public List<SetUnitsList> getUnitsList(String orgName) throws BusinessException;

    public List<SetDepartsList> getDepartsList(Integer unitId) throws BusinessException;
    
    public List<SetUsersList> getUsersList(Integer id) throws BusinessException;
    
    public CreditIdKeys checkCreditId(String creditId);

    CommonListResponse<TrmUnit> findList(String startDate, String endDate);
}
