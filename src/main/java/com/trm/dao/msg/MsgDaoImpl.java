package com.trm.dao.msg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trm.dao.common.BaseDao;
import com.trm.entity.TrmMsg;
import com.trm.entity.exception.BusinessException;

/**
 * 消息模板
 * @author zhaosimiao 2017-10-11 10:36:36
 */
@Repository("msgDao")
public class MsgDaoImpl extends BaseDao implements MsgDao {

	public static Logger logger = LoggerFactory.getLogger(MsgDaoImpl.class);

    @Override
    public TrmMsg getDescription(String msgName) throws BusinessException {
        String hql = "from TrmMsg where msgName =:msgName ";
        TrmMsg Detail = (TrmMsg) this.currentSession().createQuery(hql).setParameter("msgName", msgName).uniqueResult();
        return Detail;
    }
    
}
