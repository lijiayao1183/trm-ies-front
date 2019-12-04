package com.trm.dao.common;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;


public class BaseDao extends HibernateDaoSupport {
	
	@Resource(name="jt")
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Resource    
	 public void setSessionFacotry(SessionFactory sessionFacotry) {    
	         super.setSessionFactory(sessionFacotry);    
	 }

}
