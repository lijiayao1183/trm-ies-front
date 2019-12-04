package com.trm.service.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trm.entity.exception.BusinessException;
import com.trm.model.login.Login;
import com.trm.model.login.LoginResponse;

/**
 * @description 用户登录
 * @author zhaosimiao 
 * @date 2017-9-28 10:12:16
 */
public interface LoginService {
   
    public LoginResponse login(Login login, HttpServletRequest request, HttpServletResponse response)throws BusinessException;
    
}
