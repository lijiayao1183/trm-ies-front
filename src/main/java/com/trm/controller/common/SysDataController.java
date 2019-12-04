package com.trm.controller.common;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.common.CommonRequest;
import com.trm.model.common.SysDataSimDetail;
import com.trm.model.common.UnitResponse;
import com.trm.service.common.SysDataService;

@Controller
@RequestMapping("/sys/data")
public class SysDataController {
	public static Logger logger = LoggerFactory.getLogger(SysDataController.class);

	@Autowired
	private SysDataService sysDataService;

	/**
	 * 根据code返回数据字典列表
	 * 
	 * @return
	 * @throws BusinessException
	 */
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	@ResponseBody
	private CommonListResponse<SysDataSimDetail> findAll(@RequestBody CommonRequest request) throws BusinessException {
		CommonListResponse<SysDataSimDetail> response = sysDataService.findAll(request);
		return response;
	}

	/**
     * 隶属单位联动查询
     * 
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/unitLinkage", method = RequestMethod.POST)
    @ResponseBody
    private List<UnitResponse> unitLinkage() throws BusinessException {
        List<UnitResponse> response = sysDataService.unitLinkage();
        return response;
    }
}
