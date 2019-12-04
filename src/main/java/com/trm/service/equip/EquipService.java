package com.trm.service.equip;

import java.util.List;

import com.trm.entity.TrmEquip;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.AuditRequest;
import com.trm.model.common.ComIntData;
import com.trm.model.common.CommonListResponse;
import com.trm.model.common.CommonResponse;
import com.trm.model.equip.CateCountEquip;
import com.trm.model.equip.EquipDayReq;
import com.trm.model.equip.EquipDetail;
import com.trm.model.equip.EquipReq;
import com.trm.model.equip.EquipSimDetail;
import com.trm.model.equip.HomeEquipReq;
import com.trm.model.equip.HomeEquipSimDetail;
import com.trm.model.equip.MyEquipReq;
import com.trm.model.equip.MyEquipSimDetail;
import com.trm.model.equip.NotDisplayReq;
import com.trm.util.batch.BatchEquip;
import com.trm.util.batch.BatchEquipFileRequest;

/**
 * @author dell
 *
 */
public interface EquipService {
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
     * @return NewsDetail 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public EquipDetail findDetailById(Integer id) throws BusinessException;
    
    /**
     * 新增一条设备
     * @Title createNews
     * @param requestParameter
     * @return
     * @throws BusinessException 参数说明
     * @return boolean 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public boolean createEquip(EquipDetail requestParameter) throws Exception;
    
    /**
     * 提交设备
     * @Title createEquip
     * @Description
     * @param requestParameter
     * @return
     * @throws Exception 参数说明
     * @return boolean 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public boolean submitData(EquipDetail requestParameter) throws Exception;
    
    /**
     * 删除一条或多条设备
     * @Title deleteById
     * @param id
     * @return
     * @throws Exception 参数说明
     * @return boolean 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public CommonResponse deleteById(String id) throws Exception;
    
    /**
     * 编辑一条设备
     * @Title modifyNews
     * @param requestParameter
     * @return
     * @throws Exception 参数说明
     * @return boolean 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public boolean modifyEquip(EquipDetail requestParameter) throws Exception;
    
    /**
     * 下架
     * @Title notDisplay
     * @Description
     * @return
     * @throws Exception 参数说明
     * @return boolean 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public boolean notDisplay(NotDisplayReq requestParameter) throws Exception;
    
    public boolean viewCount(Integer id, Integer viewCount);
    
    public List<EquipSimDetail> seniorEquipTop() throws BusinessException;
    
    List<CateCountEquip> recentlyMoreEquip(ComIntData comIntData) throws BusinessException;
    
    CommonListResponse<HomeEquipSimDetail> findEquipByDay(EquipDayReq equipDayReq) throws BusinessException;
    
    boolean auditDate(AuditRequest auditEquipReq) throws Exception;
    
    List<BatchEquip> importData(BatchEquipFileRequest req) throws Exception;

    CommonListResponse<TrmEquip> findList(String startDate, String endDate);
}
