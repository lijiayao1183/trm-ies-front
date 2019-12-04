package com.trm.service.laboratory;

import java.util.List;

import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.laboratory.LaboratoryDetail;
import com.trm.model.laboratory.LaboratoryReq;
import com.trm.model.laboratory.LaboratorySimDetail;

/**
 * @author dell
 *
 */
public interface LaboratoryService {
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
     * @return NewsDetail 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public LaboratoryDetail findDetailById(Integer id) throws BusinessException;
    
    /**
     * 新增一条技术服务机构
     * @Title createNews
     * @param requestParameter
     * @return
     * @throws BusinessException 参数说明
     * @return boolean 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public boolean createEquip(LaboratoryDetail requestParameter)throws Exception;
    
    /**
     * 删除一条或多条技术服务机构
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
     * 编辑一条技术服务机构
     * @Title modifyNews
     * @param requestParameter
     * @return
     * @throws Exception 参数说明
     * @return boolean 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public boolean modifyEquip(LaboratoryDetail requestParameter)throws Exception;
    
	public boolean viewCount(Integer id, Integer viewCount);
	
	public List<LaboratorySimDetail> findLaboratoryTop() throws BusinessException;
    
}
