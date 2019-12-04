package com.trm.dao.login;

import java.util.List;

import com.trm.entity.TrmLoginHistory;
import com.trm.entity.TrmMember;

/**
 * @description 用户登录
 * @author zhaosimiao 
 * @date 2017-9-28 10:12:16
 */
public interface LoginDao {
	
	public List<TrmMember> getUsers(String username);
	public TrmMember getById(Integer id);
	public List<TrmMember> checkLoginInfo(String username, String password);
	public boolean loginDate(Integer id);
	
	/**
	 * 记录登录历史  add by zhaosimiao 
	 * 2018-8-13 14:11:11
	 * @param entity
	 * @return
	 */
	public boolean loginHistory(TrmLoginHistory entity);
	
	/**
	 * 更新登录历史中的退出系统时间  add by zhaosimiao
	 * 2018-8-13 14:11:36
	 * @param entity
	 * @return
	 */
	public boolean updateLogoutTime(TrmLoginHistory entity);
	
}
