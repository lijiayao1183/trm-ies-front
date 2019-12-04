package com.trm.service.login;

import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonResponse;
import com.trm.model.login.PwdReset;

/**
 * @description 找回密码
 * @author zhaosimiao 
 * @date 2017-10-9 10:12:16
 */
public interface PwdService {
	
	public CommonResponse sendMail(PwdReset prt, String uuid)throws Exception;
   
    public CommonResponse verifyQuestion(PwdReset prt)throws BusinessException;
    
    public CommonResponse changePwd(PwdReset prt)throws BusinessException;
    
    public CommonResponse retrievePwd(PwdReset prt)throws BusinessException;
}
