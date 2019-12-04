package com.trm.dao.common;

import java.util.Collection;
import java.util.List;

import com.trm.entity.exception.BusinessException;

/**
 * 公用DAO层操作
 * @author <a href="mailto:humorbeau@163.com">胡渊博</a>
 * @date 2017年1月9日
 * @version 1.0
 */
public interface CommonDao {
	
	/**
	 * 批量查询
	 * @return   
	 * @throws BusinessException
	 */
	public List<Object> findListEntity(String ids,Object entity) throws BusinessException;
	
	/**
	 * 批量删除
	 * @return   
	 * @throws BusinessException
	 */
	public boolean deleteAll(Collection<?> entities) throws Exception;
	
	/**
	 * 单个删除
	 * @return   
	 * @throws BusinessException
	 */
	public boolean deleteEntity(Object entity) throws Exception;
	
	/**
	 * 新增
	 * @return   
	 * @throws BusinessException
	 */
	public boolean createEntity(Object entity) throws Exception;
	
	/**
	 * 编辑
	 * @return   
	 * @throws BusinessException
	 */
	public boolean modifyEntity(Object entity) throws Exception;
	
}
