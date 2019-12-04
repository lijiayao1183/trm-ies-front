package com.trm.service.msg;

import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.msg.MyMsgDetail;
import com.trm.model.msg.MyMsgRequest;

/**
 * @author dell
 *
 */
public interface MyMsgService {
    /**
     * 查询咨询列表
     * @Title findAll
     * @param requestParameter
     * @return
     * @throws BusinessException 参数说明
     * @return OperatorDetails 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public CommonListResponse<MyMsgDetail> findAll(MyMsgRequest requestParameter) throws BusinessException;

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
    public MyMsgDetail findDetailById(Integer id) throws BusinessException;
    /**
     * 删除一条或多条
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
     * 标记为已读一条或多条
     * @Title deleteById
     * @param id
     * @return
     * @throws Exception 参数说明
     * @return boolean 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public boolean updateById(String id)throws Exception;
}
