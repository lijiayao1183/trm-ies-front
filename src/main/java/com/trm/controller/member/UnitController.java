package com.trm.controller.member;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trm.entity.exception.BusinessException;
import com.trm.model.member.GetDepartsRequest;
import com.trm.model.member.SetDepartsList;
import com.trm.model.member.SetUnitsList;
import com.trm.model.member.SetUsersList;
import com.trm.service.member.UnitService;

/**
 * 单位部门信息查询
 * @author zhaosimiao 2017-11-14 13:54:46
 */
@Controller
@RequestMapping("/")
public class UnitController {

    public static Logger logger = LoggerFactory.getLogger(UnitController.class);

    @Autowired
    private UnitService unitService;

    @RequestMapping(value = "/getUnitsList", method = RequestMethod.POST)
    @ResponseBody
    public List<SetUnitsList> getUnitsList(@Valid @RequestBody GetDepartsRequest request) throws BusinessException {
        logger.info("[注册单位列表]列表查询request：{}" + request.toString());
        List<SetUnitsList> list = unitService.getUnitsList(request.getOrgName());
        logger.info("[注册单位列表]列表查询 return：{}", list);
        return list;
    }

    @RequestMapping(value = "/getDepartsList", method = RequestMethod.POST)
    @ResponseBody
    public List<SetDepartsList> getDepartsList(@Valid @RequestBody GetDepartsRequest request) throws BusinessException {
        logger.info("[注册单位部门]列表查询request：{}", request.getUnitId());
        List<SetDepartsList> detail = unitService.getDepartsList(request.getUnitId());
        logger.info("[注册单位部门]列表查询 return：{}", detail.toString());
        return detail;
    }
    
    @RequestMapping(value = "/getUsersList", method = RequestMethod.POST)
    @ResponseBody
    public List<SetUsersList> getUsersList(@Valid @RequestBody SetUsersList request) throws BusinessException {
        logger.info("[部门查询用户]列表查询request：{}", request.getId());
        List<SetUsersList> detail = unitService.getUsersList(request.getId());
        logger.info("[部门查询用户]列表查询 return：{}", detail.toString());
        return detail;
    }

}
