package com.trm.dao.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trm.dao.common.BaseDao;
import com.trm.entity.TrmMember;

/**
 * @description 找回密码
 * @author zhaosimiao 
 * @date 2017-10-9 10:12:16
 */
@Repository("pwdDao")
public class PwdDaoImpl extends BaseDao implements PwdDao {

	public static Logger logger = LoggerFactory.getLogger(PwdDaoImpl.class);

	@Override
	public TrmMember verifyEmail(String email) {
		String hql = "from TrmMember where email=:email and (audStatus <> 'R2' or audStatus is null)";
        TrmMember tm = (TrmMember) this.currentSession().createQuery(hql)
        		.setParameter("email", email).uniqueResult();
		return tm;
	}
	
	@Override
	public TrmMember verifyQuestion(String username, String problem, String answer) {
		String hql = "from TrmMember where username=:username and problem=:problem and answer=:answer and (audStatus <> 'R2' or audStatus is null)";
        TrmMember tm = (TrmMember) this.currentSession().createQuery(hql)
        		.setParameter("username", username)
        		.setParameter("problem", problem)
        		.setParameter("answer", answer).uniqueResult();
		return tm;
	}
	
	@Override
	public TrmMember checkPwd(String username, String password) {
		String hql = "from TrmMember where username=:username and password=:password and (audStatus <> 'R2' or audStatus is null)";
        TrmMember tm = (TrmMember) this.currentSession().createQuery(hql)
        		.setParameter("username", username)
        		.setParameter("password", password).uniqueResult();
		return tm;
	}

	@Override
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

}
