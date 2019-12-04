package com.trm.dao.laboratory;

import java.util.List;

import com.trm.entity.TrmKeyLaboratory;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.laboratory.LaboratoryReq;
import com.trm.model.laboratory.LaboratorySimDetail;

public interface LaboratoryDao {
    /**
     * 查询技术服务机构列表
     * @Title findAll
     * @param requestParameter
     * @return
     * @throws BusinessException 参数说明
     * @return OperatorDetails 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public CommonListResponse<LaboratorySimDetail> findAll(LaboratoryReq requestParameter) throws BusinessException;
	
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
    public TrmKeyLaboratory findDetailById(Integer id) throws BusinessException;
    
    public boolean viewCount(Integer id, Integer viewCount);
    
	public List<LaboratorySimDetail> findLaboratoryTop() throws BusinessException;
}
