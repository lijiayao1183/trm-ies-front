package com.trm.service.member;

import java.util.List;

import com.trm.entity.TrmUnit;
import com.trm.model.common.CommonListResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trm.dao.member.UnitDao;
import com.trm.entity.exception.BusinessException;
import com.trm.model.member.SetDepartsList;
import com.trm.model.member.SetUnitsList;
import com.trm.model.member.SetUsersList;

/**
 * 单位部门信息查询
 * @author zhaosimiao 2017-11-14 13:54:46
 */
@Service("unitService")
@Transactional(rollbackFor = Exception.class)
public class UnitServiceImpl implements UnitService {

    public static Logger logger = LoggerFactory.getLogger(UnitServiceImpl.class);
    
    @Autowired
    private UnitDao unitDao;
    
	@Override
	public List<SetUnitsList> getUnitsList(String orgName) throws BusinessException {
		List<SetUnitsList> list = unitDao.getUnitsList(orgName);
		return list;
	}

	@Override
	public List<SetDepartsList> getDepartsList(Integer unitId) throws BusinessException {
		List<SetDepartsList> list = unitDao.getDepartsList(unitId);
		return list;
	}

	@Override
	public List<SetUsersList> getUsersList(Integer id) throws BusinessException {
		List<SetUsersList> list = unitDao.getUsersList(id);
		return list;
	}

	@Override
	public CommonListResponse<TrmUnit> findList(String startDate, String endDate) {
		return unitDao.findList(startDate, endDate);
	}

}
