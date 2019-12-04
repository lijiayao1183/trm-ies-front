package com.trm.service.organ;

import java.util.List;

import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.organ.OrganDetail;
import com.trm.model.organ.OrganReq;
import com.trm.model.organ.OrganSimDetail;

/**
 * @author dell
 *
 */
public interface OrganService {
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
     * @return NewsDetail 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public OrganDetail findDetailById(Integer id) throws BusinessException;
    
    /**
     * 新增一条机构（推荐）配置
     * @Title createNews
     * @param requestParameter
     * @return
     * @throws BusinessException 参数说明
     * @return boolean 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public boolean createEquip(OrganDetail requestParameter)throws Exception;
    
    /**
     * 删除一条或多条机构（推荐）配置
     * @Title deleteById
     * @param id
     * @return
     * @throws Exception 参数说明
     * @return boolean 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public boolean deleteById(String id)throws Exception;
    
    /**
     * 编辑一条机构（推荐）配置
     * @Title modifyNews
     * @param requestParameter
     * @return
     * @throws Exception 参数说明
     * @return boolean 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public boolean modifyEquip(OrganDetail requestParameter)throws Exception;
    
    public boolean viewCount(Integer id, Integer viewCount);
    
	public List<OrganSimDetail> findOrganTop() throws BusinessException;
    
}
