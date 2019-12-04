package com.trm.dao.linkup;

import com.trm.entity.TrmLinkup;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.linkup.LinkupDetailResponse;
import com.trm.model.linkup.LinkupListDetail;
import com.trm.model.linkup.LinkupReply;
import com.trm.model.linkup.LinkupRequest;
import com.trm.model.linkup.LinkupSimBack;

/**
 * 互动交流
 * @author zhaosimiao 2017-12-12 11:01:11
 */
public interface LinkupDao {
	
	public CommonListResponse<LinkupListDetail> findLinkups(LinkupRequest request) throws BusinessException;
	
    public CommonListResponse<LinkupListDetail> getMyLinkups(LinkupRequest request) throws BusinessException;
	
    public LinkupDetailResponse getLinkup(Integer id) throws BusinessException;
    
    public TrmLinkup getLinkupById(Integer id) throws BusinessException;
    
    public boolean replyLinkup(LinkupReply reply)throws Exception;
    
    /**
     * 获取回显信息
     */
    public LinkupSimBack getMySimBack(Integer userId) throws BusinessException;
    
}
