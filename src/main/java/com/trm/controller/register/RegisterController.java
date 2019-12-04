package com.trm.controller.register;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trm.model.common.CommonResponse;
import com.trm.model.member.MemberTemp;
import com.trm.model.register.CreditIdKeys;
import com.trm.model.register.Register;
import com.trm.model.register.UniqueKeys;
import com.trm.service.register.RegisterService;

/**
 * @description 用户注册
 * @author zhaosimiao 
 * @date 2017-9-28 10:12:16
 */
@Controller
@RequestMapping("/")
public class RegisterController {

    public static Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private RegisterService registerService;

    /**
     * 
     * @param register 用户注册信息
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse register(@Valid @RequestBody Register register, HttpServletRequest request) throws Exception {
        logger.info("[用户注册提交信息]：", register.toString());
        CommonResponse response = registerService.register(register);
        logger.info("[用户注册返回信息]：", response.toString());
        return response;
    }
    
    /**
     * 手机/邮箱/身份证号唯一性检测
     * @param keys
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/checkUniqueKeys", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse checkUniqueKeys(@Valid @RequestBody UniqueKeys keys) throws Exception {
        logger.info("[信息唯一性检查提交信息]：", keys.toString());
        CommonResponse response = registerService.checkUniqueKeys(keys);
        logger.info("[信息唯一性检查返回信息]：", response.toString());
        return response;
    }
    
    /**
     * 组织机构代码唯一性检测
     * @param keys
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/checkCreditIdKeys", method = RequestMethod.POST)
    @ResponseBody
    public CreditIdKeys checkCreditIdKeys(@Valid @RequestBody CreditIdKeys keys) throws Exception {
        logger.info("[组织机构代码唯一性检查提交信息]：", keys.toString());
        CreditIdKeys response = registerService.checkCreditIdKeys(keys);
        logger.info("[组织机构代码唯一性检查返回信息]：", response.toString());
        return response;
    }
    
    /**
     * add by zhaosimiao 
     * 2018-4-17 13:49:22
     * @param temp 用户注册信息暂存
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/saveMemberTemp", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse saveMemberTemp(@Valid @RequestBody MemberTemp temp, HttpServletRequest request) throws Exception {
        logger.info("[用户注册暂存信息]：", temp.toString());
        CommonResponse response = registerService.saveMemberTemp(temp);
        logger.info("[用户注册暂存信息]：", response.toString());
        return response;
    }
    
    /**
     * add by zhaosimiao 
     * 2018-4-17 13:49:36
     * @param keys 查询用户注册信息暂存
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getMemberTemp", method = RequestMethod.POST)
    @ResponseBody
    public MemberTemp getMemberTemp(@Valid @RequestBody CreditIdKeys keys) throws Exception {
        logger.info("[查询用户注册暂存信息]：", keys.getCreditId());
        MemberTemp temp = registerService.getMemberTemp(keys.getCreditId());
        logger.info("[查询用户注册暂存信息]：", temp.toString());
        return temp;
    }

}
