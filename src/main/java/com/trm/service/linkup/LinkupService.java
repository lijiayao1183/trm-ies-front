package com.trm.service.linkup;

import com.trm.entity.TrmLinkup;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.common.CommonResponse;
import com.trm.model.linkup.LinkupDetail;
import com.trm.model.linkup.LinkupDetailResponse;
import com.trm.model.linkup.LinkupListDetail;
import com.trm.model.linkup.LinkupReply;
import com.trm.model.linkup.LinkupRequest;
import com.trm.model.linkup.LinkupSimBack;

/**
 * 互动交流
 * @author zhaosimiao 2017-12-12 14:42:16
 */
public interface LinkupService {
	
	public CommonListResponse<LinkupListDetail> findLinkups(LinkupRequest request) throws BusinessException;

    public CommonListResponse<LinkupListDetail> getMyLinkups(LinkupRequest request) throws BusinessException;
	
    public LinkupDetailResponse getLinkup(Integer id) throws BusinessException;
    
    public TrmLinkup getLinkupById(Integer id) throws BusinessException;
    
    public CommonResponse replyLinkup(LinkupReply reply)throws Exception;
    
    public LinkupSimBack getMySimBack(Integer userId) throws BusinessException;
    
    public CommonResponse createLinkup(LinkupDetail detail)throws Exception;
}
