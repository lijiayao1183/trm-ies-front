package com.trm.dao.login;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trm.dao.common.BaseDao;
import com.trm.entity.TrmLoginHistory;
import com.trm.entity.TrmMember;

/**
 * @description 用户登录
 * @author zhaosimiao 
 * @date 2017-9-28 10:12:16
 */
@Repository("loginDao")
public class LoginDaoImpl extends BaseDao implements LoginDao {

	public static Logger logger = LoggerFactory.getLogger(LoginDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<TrmMember> getUsers(String username) {
		String hql = "from TrmMember where username =:username order by id desc";
		List<TrmMember> tmList = (List<TrmMember>) this.currentSession().createQuery(hql)
        		.setParameter("username", username).list();
		return tmList;
	}

	@Override
	public TrmMember getById(Integer id) {
		String hql = "from TrmMember where id =:id";
		TrmMember tmList = (TrmMember) this.currentSession().createQuery(hql)
        		.setParameter("id", id).uniqueResult();
		return tmList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrmMember> checkLoginInfo(String username, String password) {
		String hql = "from TrmMember where username =:username and password =:password order by id desc";
		List<TrmMember> tmList = (List<TrmMember>) this.currentSession().createQuery(hql)
        		.setParameter("username", username).setParameter("password", password).list();
		return tmList;
	}
	
	@Override
	public boolean loginDate(Integer id) {
		boolean flag = false;
		String sql = "update TrmMember m set m.loginDate = ? where m.id = ?";
		int a = this.currentSession().createQuery(sql)
						.setParameter(0, new Date())
						.setParameter(1, id)
						.executeUpdate();
		if(a == 1){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean loginHistory(TrmLoginHistory entity) {
		try {
			this.getHibernateTemplate().save(entity);
			return true;
		} catch (Exception e) {
			logger.error("插入登录历史记录报错!", entity.getClass().getName(), e.getMessage());
			throw e;
		}
	}

	@Override
	public boolean updateLogoutTime(TrmLoginHistory entity) {
		try {
			this.getHibernateTemplate().update(entity);
			return true;
		} catch (Exception e) {
			logger.error("更新登出时间报错!", entity.getClass().getName(), e.getMessage());
			throw e;
		}
	}


}
