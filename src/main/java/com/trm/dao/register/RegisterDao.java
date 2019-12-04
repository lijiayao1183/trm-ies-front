package com.trm.dao.register;

import com.trm.entity.TrmMember;
import com.trm.entity.TrmMemberTemp;

/**
 * @description 用户注册
 * @author zhaosimiao 
 * @date 2017-9-28 10:12:16
 */
public interface RegisterDao {
	
	public TrmMember checkUsername(String username);
    
    public TrmMember checkPhone(String phone);
    
    public TrmMember checkEmail(String email);
    
    public TrmMember checkNumberId(String numberId);

	/**
	 * add by zhaosimiao 2018-4-17 11:30:48
	 * 根据统一社会信用代码 查询注册用户暂存信息
	 * @param creditId
	 * @return
	 */
	public TrmMemberTemp getMemberTemp(String creditId);
	
}
