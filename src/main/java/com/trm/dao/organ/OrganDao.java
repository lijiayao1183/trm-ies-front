package com.trm.dao.organ;

import java.util.List;

import com.trm.entity.TrmOrgan;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.organ.OrganReq;
import com.trm.model.organ.OrganSimDetail;

public interface OrganDao {
    /**
     * 查询机构（推荐）配置列表
     * @Title findAll
     * @param requestParameter
     * @return
     * @throws BusinessException 参数说明
     * @return OperatorDetails 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public CommonListResponse<OrganSimDetail> findAll(OrganReq requestParameter) throws BusinessException;
	
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
    public TrmOrgan findDetailById(Integer id) throws BusinessException;
    
    public boolean viewCount(Integer id, Integer viewCount);
    
	public List<OrganSimDetail> findOrganTop() throws BusinessException;
}
