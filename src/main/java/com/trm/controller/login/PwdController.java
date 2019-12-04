package com.trm.controller.login;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trm.model.common.CommonResponse;
import com.trm.model.login.PwdReset;
import com.trm.service.login.PwdService;
import com.trm.util.SessionUtil;

@Controller
@RequestMapping("/")
public class PwdController {
	
    private static Logger logger = LoggerFactory.getLogger(PwdController.class);

    @Autowired
    private PwdService pwdService;

    /**
     * 发送验证邮件
     * @param mail
     * @throws Exception
     */
    @RequestMapping(value = "/sendMail", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse sendMail(@Valid @RequestBody PwdReset prt, HttpServletRequest request) throws Exception {
        logger.info("找回密码:sendMail，入参 email = " + prt.getEmail());
        String uuid = getUUID();
        logger.info("找回密码:sendMail，uuid = " + uuid);
        CommonResponse response = pwdService.sendMail(prt,uuid);
        return response;
    }
    
    /**
     * 验证安全问题
     * @param prt
     * @throws Exception
     */
    @RequestMapping(value = "/verifyQuestion", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse verifyQuestion(@Valid @RequestBody PwdReset prt) throws Exception {
        logger.info("找回密码:verifyQuestion，入参 ：" + prt.toString());
        // 验证安全问题
        CommonResponse response = pwdService.verifyQuestion(prt);
        return response;
    }
    
    /**
     * 修改密码/找回密码
     * @param prt
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/changePwd", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse changePwd(@Valid @RequestBody PwdReset prt, HttpServletRequest request, HttpServletResponse responses) throws Exception {
        logger.info("找回密码:changePwd，入参 ：" + prt.toString());
        String username = SessionUtil.getUsernameFromSession();
        CommonResponse response = new CommonResponse();
        String isLogin = prt.getIsLogin();
        // 找回密码
        if("N".equals(isLogin)) {
        	response = pwdService.retrievePwd(prt);
        }
        // 修改密码
        else if("Y".equals(isLogin) && StringUtils.isNotEmpty(username)) {
        	prt.setUsername(username);
        	response = pwdService.changePwd(prt);
        }
        else {
        	response.setCodeAndMsg("E2", "密码修改参数不合法！");
        }
        return response;
    }
    
	private static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		String uuidStr = str.replace("-", "");
		return uuidStr;
	}
	
}
