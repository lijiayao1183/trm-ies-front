package com.trm.service.register;

import com.trm.model.common.CommonResponse;
import com.trm.model.member.MemberTemp;
import com.trm.model.register.CreditIdKeys;
import com.trm.model.register.Register;
import com.trm.model.register.UniqueKeys;

/**
 * @description 用户注册
 * @author zhaosimiao 
 * @date 2017-9-28 10:12:16
 */
public interface RegisterService {
   
    public CommonResponse register(Register register)throws Exception;

    /**
     * 基本信息唯一性检测
     * @param username
     * @return
     */
    public CommonResponse checkUniqueKeys(UniqueKeys keys);

    /**
     * 组织机构代码唯一性检测
     * @param username
     * @return
     */
    public CreditIdKeys checkCreditIdKeys(CreditIdKeys keys);
    
    /**
     * add by zhaosimiao 2018-4-17 11:36:36
     * 注册用户信息暂存
     * @param temp
     * @return
     */
    public CommonResponse saveMemberTemp(MemberTemp temp) throws Exception;
    
    /**
     * add by zhaosimiao 2018-4-17 11:36:36
	 * 根据统一社会信用代码 查询注册用户暂存信息
	 * @param creditId
	 * @return
	 */
	public MemberTemp getMemberTemp(String creditId);
}
