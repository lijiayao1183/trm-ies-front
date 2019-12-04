/**
 * @Title: DemandDao.java
 * @Package: com.trm.dao.require
 * @Description: TODO(用一句话描述该文件做什么)
 * @Copyright: Copyright (c)
 * @Company: Digital Telemedia Co.,Ltd
 * @author LiuJC
 * @date 2018年02月26 上午10:51
 * @version V1.0
 * @Revision 2018年02月26 上午10:51
 */

package com.trm.dao.require;

import com.trm.entity.TrmDemand;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.AuditRequest;
import com.trm.model.common.ComIntData;
import com.trm.model.common.CommonListResponse;
import com.trm.model.equip.EquipDayReq;
import com.trm.model.require.CateCountDemand;
import com.trm.model.require.DemandDetails;
import com.trm.model.require.DemandIndex;
import com.trm.model.require.DemandListResp;
import com.trm.model.require.RequireRequest;

import java.util.Date;
import java.util.List;

/**
 * @ClassName DemandDao
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author LiuJC
 * @Date 2018年02月26 上午10:51
 * @version 1.0.0
 */
public interface DemandDao {
    
    CommonListResponse<DemandListResp> myDemand(RequireRequest requireReques) throws BusinessException;
    
    /**
     * 详情
     * @param id
     * @return
     * @throws BusinessException
     */
    DemandDetails getMyDemandById(Integer id) throws BusinessException;
    
    /**
     * 审核
     * @param request
     * @return
     */
    boolean auditDemand(AuditRequest request);
    
    /**
     * 首页展示
     * @param request
     * @return
     * @throws BusinessException
     */
    CommonListResponse<DemandIndex> homeDemand(RequireRequest request) throws BusinessException;
    
    List<CateCountDemand> recentlyMoreDemand(ComIntData comIntData) throws BusinessException;
    
    /**
     * 列表查询
     * @param request
     * @return
     * @throws BusinessException
     */
    CommonListResponse<DemandIndex> findDemand(RequireRequest request) throws BusinessException;
    
    /**
     * 浏览量+1
     * @param id
     * @return
     */
    boolean addViewCount(Integer id);
    
    /**
     * 查询访问量倒序
     * @param request
     * @return
     * @throws BusinessException
     */
    CommonListResponse<DemandIndex> findHotDemand(RequireRequest request) throws BusinessException;
    
    /**
     * 按天查询
     * @param equipDayReq
     * @return
     * @throws BusinessException
     */
    CommonListResponse<DemandIndex> findDemandByDay(EquipDayReq equipDayReq) throws BusinessException;
    
    boolean delByDemand(Integer id);
    
    boolean batchDelDemands(String[] ids);

    CommonListResponse<TrmDemand> findList(String startTime, String endTime);
}
