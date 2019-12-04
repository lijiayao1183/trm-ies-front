package com.trm.dao.big;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trm.dao.common.BaseDao;

@Repository("marketServerDao")
public class MarketServerDaoImpl extends BaseDao implements MarketServerDao {
	static Logger logger = LoggerFactory.getLogger(MarketServerDaoImpl.class);
}
