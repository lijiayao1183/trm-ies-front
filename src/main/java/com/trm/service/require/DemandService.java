/**
 * @Title: DemandService.java
 * @Package: com.trm.service.require
 * @Description: TODO(用一句话描述该文件做什么)
 * @Copyright: Copyright (c)
 * @Company: Digital Telemedia Co.,Ltd
 * @author LiuJC
 * @date 2018年02月26 上午10:49
 * @version V1.0
 * @Revision 2018年02月26 上午10:49
 */

package com.trm.service.require;

import com.trm.entity.TrmDemand;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.AuditRequest;
import com.trm.model.common.ComIntData;
import com.trm.model.common.CommonListResponse;
import com.trm.model.common.CommonResponse;
import com.trm.model.equip.EquipDayReq;
import com.trm.model.require.CateCountDemand;
import com.trm.model.require.DemandDetails;
import com.trm.model.require.DemandIndex;
import com.trm.model.require.DemandListResp;
import com.trm.model.require.DemandReq;
import com.trm.model.require.RequireRequest;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * @ClassName DemandService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author LiuJC
 * @Date 2018年02月26 上午10:49
 * @version 1.0.0
 */
public interface DemandService {
    /**
     * 创建需求
     * @param demandReq
     * @return
     * @throws Exception
     */
    CommonResponse createDemand(DemandReq demandReq) throws Exception;
    
    /**
     * 查询需求
     * @param requireReques
     * @return
     * @throws Exception
     */
    CommonListResponse<DemandListResp> myDemand(RequireRequest requireReques) throws Exception;
    
    /**
     * 查询详情
     * @param id
     */
    DemandDetails getMyDemandById(Integer id) throws BusinessException;
    
    /**
     * 删除
     * @param id
     * @return
     * @throws Exception
     */
    CommonResponse deleteById(String id) throws Exception;
    
    /**
     * 修改
     * @param demandReq
     * @return
     * @throws Exception
     */
    CommonResponse modifyDemand(DemandReq demandReq) throws Exception;
    
    /**
     * 状态修改
     * @param request
     * @return
     * @throws Exception
     */
    boolean auditDemand(AuditRequest request) throws Exception;
    
    /**
     * 首页
     * @param request
     * @return
     * @throws BusinessException
     */
    CommonListResponse<DemandIndex> homeDemands(RequireRequest request) throws BusinessException;
    
    /**
     * 首页需求左侧
     * @param comIntData
     * @return
     * @throws BusinessException
     */
    List<CateCountDemand> recentlyMoreDemand(ComIntData comIntData) throws BusinessException;
    
    /**
     * 列表查询
     * @param request
     * @return
     * @throws BusinessException
     */
    CommonListResponse<DemandIndex> findDemand(RequireRequest request) throws BusinessException;
    
    DemandDetails findDemandDetail(Integer id) throws BusinessException;
    
    /**
     * 查询访问量倒序
     * @param request
     * @return
     * @throws BusinessException
     */
    CommonListResponse<DemandIndex> findHotDemand(RequireRequest request) throws BusinessException;
    
    /**
     * an天查询
     * @param equipDayReq
     * @return
     * @throws BusinessException
     */
    CommonListResponse<DemandIndex> findDemandByDay(EquipDayReq equipDayReq) throws BusinessException;

    CommonListResponse<TrmDemand> findList(String startTime, String endTime);
}
