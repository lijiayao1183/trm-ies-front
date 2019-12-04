package com.trm.dao.login;

import com.trm.entity.TrmMember;

/**
 * @description 找回密码
 * @author zhaosimiao 
 * @date 2017-10-9 10:12:16
 */
public interface PwdDao {
	
	public TrmMember verifyEmail(String email);
	
	public TrmMember verifyQuestion(String username, String problem, String answer);
	
	public TrmMember checkPwd(String username, String password);
	
	public boolean updatePwd(String username, String password);
	
}
