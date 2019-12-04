package com.trm.dao.msg;

import com.trm.entity.TrmMsgHistory;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.msg.MyMsgDetail;
import com.trm.model.msg.MyMsgRequest;

public interface MyMsgDao {
    /**
     * 查询我的消息列表
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
     * @return TrmNews 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    public TrmMsgHistory findDetailById(Integer id) throws BusinessException;
    
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
