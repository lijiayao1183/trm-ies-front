package com.trm.dao.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trm.dao.common.BaseDao;
import com.trm.entity.TrmMember;
import com.trm.entity.TrmUuid;
import com.trm.model.login.Uuid;

/**
 * @description uuid验证
 * @author zhaosimiao 
 * @date 2017-10-9 10:12:16
 */
@Repository("uuidDao")
public class UuidDaoImpl extends BaseDao implements UuidDao {

	public static Logger logger = LoggerFactory.getLogger(UuidDaoImpl.class);

	public TrmMember checkPwd(String username, String password) {
		String hql = "from TrmMember where username=:username and password=:password and (audStatus <> 'R2' or audStatus is null)";
        TrmMember tm = (TrmMember) this.currentSession().createQuery(hql)
        		.setParameter("username", username)
        		.setParameter("password", password).uniqueResult();
		return tm;
	}

	public boolean updatePwd(String username, String password) {
		boolean flag = false;
		String sql = "update TrmMember a set a.password = ? where a.username = ? and (audStatus <> 'R2' or audStatus is null)";
		int a = this.currentSession().createQuery(sql)
						.setParameter(0, password)
						.setParameter(1, username)
						.executeUpdate();
		if(a == 1){
			flag = true;
		}
		return flag;
	}

	@Override
	public TrmUuid checkUsername(String username) {
		String hql = "from TrmUuid where username=:username";
		TrmUuid tm = (TrmUuid) this.currentSession().createQuery(hql)
        		.setParameter("username", username).uniqueResult();
		return tm;
	}

	@Override
	public boolean insertUuid(TrmUuid entity) {
		try {
			this.getHibernateTemplate().save(entity);
			return true;
		} catch (Exception e) {
			logger.error("新增uuid实体报错!", entity.getClass().getName(), e.getMessage());
			throw e;
		}
	}

	@Override
	public boolean updateUuid(Uuid uuid) {
		boolean flag = false;
		String sql = "update TrmUuid a set a.code = ? , a.count = ? , a.sendtime = ? where a.username = ? ";
		int a = this.currentSession().createQuery(sql)
						.setParameter(0, uuid.getCode())
						.setParameter(1, uuid.getCount() + 1)
						.setParameter(2, uuid.getSendtime())
						.setParameter(3, uuid.getUsername())
						.executeUpdate();
		if(a == 1){
			flag = true;
		}
		return flag;
	}

	@Override
	public TrmUuid getUuid(String code) {
		String hql = "from TrmUuid where code=:code";
		TrmUuid tm = (TrmUuid) this.currentSession().createQuery(hql)
        		.setParameter("code", code).uniqueResult();
		return tm;
	}

}
