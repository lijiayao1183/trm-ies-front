package com.trm.dao.navbar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trm.dao.common.BaseDao;

@Repository("navbarInfoDao")
public class NavbarInfoDaoImpl extends BaseDao implements NavbarInfoDao {
	static Logger logger=LoggerFactory.getLogger(NavbarInfoDaoImpl.class);
}
