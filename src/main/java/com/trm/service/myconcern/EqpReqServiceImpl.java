package com.trm.service.myconcern;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trm.constants.SystemConstants;
import com.trm.dao.common.CommonDao;
import com.trm.dao.common.SysDataDao;
import com.trm.dao.equip.EquipDao;
import com.trm.dao.myconcern.EqpReqDao;
import com.trm.entity.TrmEqpReq;
import com.trm.entity.TrmEquip;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.common.CommonRequest;
import com.trm.model.common.CommonResponse;
import com.trm.model.common.SysDataSimDetail;
import com.trm.model.myconcern.CareEquipRequest;
import com.trm.model.myconcern.CareEquipSimDetail;
import com.trm.model.myconcern.CareEquipStatus;
import com.trm.util.BeanUtils;

/**
 * 我的关注模块
 * @author zhaosimiao 2017年10月17日 14:33:36
 */
@Service("eqpReqService")
@Transactional(rollbackFor = Exception.class)
public class EqpReqServiceImpl implements EqpReqService {

    public static Logger logger = LoggerFactory.getLogger(EqpReqServiceImpl.class);

    @Autowired
    private EqpReqDao eqpReqDao;
    
    @Autowired
    private CommonDao commonDao;
    
    @Autowired
    private SysDataDao sysDataDao;
    
    @Autowired
    private EquipDao equipDao;
    
    @Override
    public CommonListResponse<CareEquipSimDetail> findCareEquips(CareEquipRequest request) throws BusinessException {
        CommonListResponse<CareEquipSimDetail> list = eqpReqDao.findCareEquips(request);
        // 信息为空时，抛出异常
        if (list.getList().size() < 1) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("我的关注列表查询为空！");
            throw bs;
        }
        CommonRequest req = new CommonRequest();
        List<CareEquipSimDetail> oList = list.getList();
        for(CareEquipSimDetail detail : oList) {
        	String equipType = detail.getEquipType();
        	req.setCode("DF");
        	// 查询数据字典列表
        	CommonListResponse<SysDataSimDetail> sList = sysDataDao.findAll(req);
        	// 将功能分类字段变成数组进行遍历
        	String[] equipTypes = StringUtils.split(equipType, ",");
        	// 将功能分类字段列表与数据字典数组进行比对
        	for(String et : equipTypes){
        		for(SysDataSimDetail sds : sList.getList()) {
        			if(et.equals(sds.getCode())) {
        				equipType = equipType.replace(et, sds.getName());
        			}
        		}
        	}
        	detail.setEquipType(equipType);
        	
        	String serviceRange = detail.getServiceRange();
        	req.setCode("SR");
        	// 查询数据字典列表
        	sList = sysDataDao.findAll(req);
        	// 将服务领域字段变成数组进行遍历
        	String[] serviceRanges = StringUtils.split(serviceRange, ",");
        	// 将功能分类字段列表与数据字典数组进行比对
        	for(String sr : serviceRanges){
        		for(SysDataSimDetail sds : sList.getList()) {
        			if(sr.equals(sds.getCode())) {
        				serviceRange = serviceRange.replace(sr, sds.getName());
        			}
        		}
        	}
        	detail.setServiceRange(serviceRange);
        }
        return list;
    }
    
    @Override
    public CommonResponse careEquip(CareEquipStatus request) throws Exception {
    	CommonResponse response = new CommonResponse();
    	Integer orgId = request.getOrgId();
    	Integer eqpId = request.getEqpId();
    	
    	// 不能针对自己发布的设备做关注和预约操作！modify by zhaosimiao at 2017-12-26 11:10:12
    	TrmEquip eqp = equipDao.findDetailById(eqpId);
    	if(eqp != null && eqp.getOrgId().intValue() == orgId.intValue()) {
    		response.setCodeAndMsg("E3", "不能针对自己发布的设备做关注和预约操作！");
    		return response;
    	}
    	
        TrmEqpReq entity = new TrmEqpReq();
        BeanUtils.copyProperties(request, entity);
        // add by zhaosimiao 2017-11-6 16:24:23
        // regId 0 为关注记录
        // regId 1 为预约记录
        entity.setRegId(0);
        entity.setIsActive(SystemConstants.FLAG_Y);
        TrmEqpReq checkEntity = eqpReqDao.checkCareRecord(orgId, eqpId, 0);
        
        boolean isCare = false;
        if(checkEntity == null) {
        	isCare = commonDao.createEntity(entity);
        }
        else {
        	isCare = eqpReqDao.updateCareEquip(request);
        }
        if(isCare) {
        	response.setCodeAndMsg("0000", "设备关注添加/取消成功！");
        }
        else {
        	response.setCodeAndMsg("9999", "设备关注添加/取消失败！");
        }
        return response;
    }
    
}
