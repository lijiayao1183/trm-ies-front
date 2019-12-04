package com.trm.dao.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.common.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trm.constants.SystemConstants;
import com.trm.entity.exception.BusinessException;

/**
 * 公用DAO层操作
 * @author <a href="mailto:humorbeau@163.com">胡渊博</a>
 * @date 2017年1月9日
 * @version 1.0
 */
@Repository("commonDao")
public class CommonDaoImpl extends BaseDao implements CommonDao {

	public static Logger logger = LoggerFactory.getLogger(CommonDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findListEntity(String ids,Object entity) throws BusinessException {
		List<Object> detail = null;
		if(StringHelper.isNotEmpty(ids)){
			String[] multiKeys = StringUtils.split(ids, SystemConstants.SYSTEM_COMMA);
			List<Integer> list = new ArrayList<>();
			for (String c : multiKeys) {
				list.add(Integer.valueOf(c));
			}
			String hql = " from " + entity.getClass().getName() + " where 1=1 and id in (:list) ";
			detail = (List<Object>) this.currentSession().createQuery(hql).setParameterList("list", list).list();
		}
		return detail;
	}
	
	@Override
	public boolean deleteAll(Collection<?> entities) throws Exception {
		try {
			this.getHibernateTemplate().deleteAll(entities);
			return true;
		} catch (Exception e) {
			logger.error("批量删除数据报错!", e.getMessage());
			throw e;
		}
	}

	@Override
	public boolean deleteEntity(Object entity) throws Exception {
		try {
			this.getHibernateTemplate().delete(entity);
			return true;
		} catch (Exception e) {
			logger.error("删除数据报错!", entity.getClass().getName(), e.getMessage());
			throw e;
		}
	}

	@Override
	public boolean createEntity(Object entity) throws Exception {
		try {
			this.getHibernateTemplate().save(entity);
			return true;
		} catch (Exception e) {
			logger.error("新增数据报错!", entity.getClass().getName(), e.getMessage());
			throw e;
		}
	}

	@Override
	public boolean modifyEntity(Object entity) throws Exception {
		try {
			this.getHibernateTemplate().update(entity);
			return true;
		} catch (Exception e) {
			logger.error("编辑数据报错!", entity.getClass().getName(), e.getMessage());
			throw e;
		}
	}

}
