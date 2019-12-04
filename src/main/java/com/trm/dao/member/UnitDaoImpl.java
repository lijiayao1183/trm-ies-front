package com.trm.dao.member;

import java.util.List;

import com.trm.entity.TrmTechServOrg;
import com.trm.model.common.CommonListResponse;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trm.dao.common.BaseDao;
import com.trm.entity.TrmUnit;
import com.trm.entity.exception.BusinessException;
import com.trm.model.member.SetDepartsList;
import com.trm.model.member.SetUnitsList;
import com.trm.model.member.SetUsersList;
import com.trm.model.register.CreditIdKeys;
import com.trm.util.ParameterUtils;

/**
 * 单位部门信息查询
 * @author zhaosimiao 2017-11-14 13:54:46
 */
@Repository("unitDao")
public class UnitDaoImpl extends BaseDao implements UnitDao {

	public static Logger logger = LoggerFactory.getLogger(UnitDaoImpl.class);

	@Override
	public TrmUnit getUnitById(Integer id) {
		String hql = "from TrmUnit where id =:id ";
		TrmUnit entity = (TrmUnit) this.currentSession().createQuery(hql).setParameter("id", id).uniqueResult();
        return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SetUnitsList> getUnitsList(String orgName) throws BusinessException {
		String hql = "select new com.trm.model.member.SetUnitsList(a.id,a.orgName) from TrmUnit a where a.orgName like ? group by a.id";
		List<SetUnitsList> list = (List<SetUnitsList>) this.currentSession().createQuery(hql).setParameter(0, ParameterUtils.getLikeParam(orgName)).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SetDepartsList> getDepartsList(Integer unitId) throws BusinessException {
		String hql = "select new com.trm.model.member.SetDepartsList(a.id,a.department) from TrmDepart a where a.unitId = ? group by a.id";
		List<SetDepartsList> list = (List<SetDepartsList>) this.currentSession().createQuery(hql).setParameter(0, unitId).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SetUsersList> getUsersList(Integer id) throws BusinessException {
		String hql = "select new com.trm.model.member.SetUsersList(id,username,userType) from TrmMember where departId = ?";
		List<SetUsersList> list = (List<SetUsersList>) this.currentSession().createQuery(hql).setParameter(0, id).list();
		return list;
	}
	
	@Override
	public CreditIdKeys checkCreditId(String creditId) {
		String hql = "select new com.trm.model.register.CreditIdKeys(u.creditId, m.linkPerson, m.phone, d.department) " 
				+ "from TrmUnit u,TrmMember m,TrmDepart d where m.id=m.masterId and u.id=m.unitId and d.unitId=u.id and u.creditId = :id and m.audStatus = 'R1'";
		CreditIdKeys ci = (CreditIdKeys) this.currentSession().createQuery(hql).setParameter("id", creditId).setMaxResults(1).uniqueResult();
		return ci;
	}

	@Override
	public CommonListResponse<TrmUnit> findList(String startTime, String endTime) {
		String hql = "from TrmUnit where createTime > :startTime and createTime <= :endTime";
		Query query = currentSession().createQuery(hql);
		query.setString("startTime", startTime);
		query.setString("endTime", endTime);
		List<TrmUnit> list = query.list();
		CommonListResponse response = new CommonListResponse();
		response.setCount(list.size());
		response.setList(list);
		return response;
	}

}
