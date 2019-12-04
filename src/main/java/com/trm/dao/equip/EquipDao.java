package com.trm.dao.equip;

import com.trm.entity.TrmEquip;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.AuditRequest;
import com.trm.model.common.ComIntData;
import com.trm.model.common.CommonListResponse;
import com.trm.model.equip.CateCountEquip;
import com.trm.model.equip.EquipDayReq;
import com.trm.model.equip.EquipReq;
import com.trm.model.equip.EquipSimDetail;
import com.trm.model.equip.HomeEquipReq;
import com.trm.model.equip.HomeEquipSimDetail;
import com.trm.model.equip.MyEquipReq;
import com.trm.model.equip.MyEquipSimDetail;

import java.util.List;

public interface EquipDao {

    public CommonListResponse<HomeEquipSimDetail> findAll(HomeEquipReq requestParameter) throws BusinessException;
    
    /**
     * 查询设备列表
     * @Title findAll
     * @param requestParameter
     * @return
     * @throws BusinessException 参数说明
     * @return OperatorDetails 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public CommonListResponse<EquipSimDetail> seniorFindAll(EquipReq requestParameter) throws BusinessException;
    
    /**
     *我的设备
     * @Title seniorFindAll
     * @Description
     * @param requestParameter
     * @return
     * @throws BusinessException 参数说明
     * @return CommonListResponse<EquipSimDetail> 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public CommonListResponse<MyEquipSimDetail> findAllMyEqip(MyEquipReq requestParameter) throws BusinessException;
    
    /**
     * 根据id查询详情
     * @Title findDetailById
     * @param id
     * @return
     * @throws BusinessException 参数说明
     * @return TrmEquip 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public TrmEquip findDetailById(Integer id) throws BusinessException;
    
    /**
     * 新增数据
     * @Title createTrmEquip
     * @Description
     * @param entity
     * @return
     * @throws BusinessException 参数说明
     * @return Integer 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public Integer createTrmEquip(TrmEquip entity) throws BusinessException;
    
    public boolean viewCount(Integer id, Integer viewCount);
    
    public List<EquipSimDetail> seniorEquipTop() throws BusinessException;
    
    List<CateCountEquip> recentlyMoreEquip(ComIntData comIntData) throws BusinessException;
    
    CommonListResponse<HomeEquipSimDetail> findEquipByDay(EquipDayReq equipDayReq) throws BusinessException;
    
    boolean auditDate(AuditRequest request);
    
    public boolean delByEquip(Integer id);
    
    public boolean batchDelEquip(String[] ids);
    
    /**
     * add by zhaosimiao 2018-4-16 16:40:16
     * 浏览量+1
     * @param id
     * @return
     */
    boolean addViewCount(Integer id);

    CommonListResponse<TrmEquip> findList(String startDate, String endDate);
}
