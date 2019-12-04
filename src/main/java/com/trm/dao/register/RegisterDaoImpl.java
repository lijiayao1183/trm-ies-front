package com.trm.dao.register;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trm.dao.common.BaseDao;
import com.trm.entity.TrmMember;
import com.trm.entity.TrmMemberTemp;

/**
 * @description 用户注册
 * @author zhaosimiao 
 * @date 2017-9-28 10:12:16
 */
@Repository("registerDao")
public class RegisterDaoImpl extends BaseDao implements RegisterDao {

	public static Logger logger = LoggerFactory.getLogger(RegisterDaoImpl.class);

	@Override
	public TrmMember checkUsername(String username) {
		String hql = "from TrmMember where username =:username and (audStatus <> 'R2' or audStatus is null)";
        TrmMember tm = (TrmMember) this.currentSession().createQuery(hql).setParameter("username", username).uniqueResult();
		return tm;
	}
	
	@Override
	public TrmMember checkPhone(String phone) {
		String hql = "from TrmMember where phone =:phone and (audStatus <> 'R2' or audStatus is null)";
        TrmMember tm = (TrmMember) this.currentSession().createQuery(hql).setParameter("phone", phone).uniqueResult();
		return tm;
	}

	@Override
	public TrmMember checkEmail(String email) {
		String hql = "from TrmMember where email =:email and (audStatus <> 'R2' or audStatus is null)";
        TrmMember tm = (TrmMember) this.currentSession().createQuery(hql).setParameter("email", email).uniqueResult();
		return tm;
	}

	@Override
	public TrmMember checkNumberId(String numberId) {
		String hql = "from TrmMember where numberId =:numberId and (audStatus <> 'R2' or audStatus is null)";
        TrmMember tm = (TrmMember) this.currentSession().createQuery(hql).setParameter("numberId", numberId).uniqueResult();
		return tm;
	}

	@Override
	public TrmMemberTemp getMemberTemp(String creditId) {
		String hql = "from TrmMemberTemp where creditId =:creditId order by createTime desc";
		TrmMemberTemp entity = (TrmMemberTemp) this.currentSession().createQuery(hql).setParameter("creditId", creditId).setMaxResults(1).uniqueResult();
        return entity;
	}
    
}
