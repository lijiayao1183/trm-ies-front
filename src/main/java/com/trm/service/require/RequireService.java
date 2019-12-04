package com.trm.service.require;

import java.util.List;

import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.common.CommonResponse;
import com.trm.model.require.RequireAudit;
import com.trm.model.require.RequireDetail;
import com.trm.model.require.RequireListDetail;
import com.trm.model.require.RequireMyListDetail;
import com.trm.model.require.RequireRequest;
import com.trm.model.require.RequireSimDetail;

/**
 * 军民融合需求
 * @author zhaosimiao 2017-11-14 13:54:46
 */
public interface RequireService {
	
	public CommonListResponse<RequireSimDetail> homeRequires(RequireRequest request) throws BusinessException;

    public CommonListResponse<RequireListDetail> findRequires(RequireRequest request) throws BusinessException;
	
    public RequireDetail getRequireById(Integer id) throws BusinessException;
    
    public RequireDetail getMyRequireById(Integer id) throws BusinessException;
    
    public CommonResponse createRequire(RequireDetail detail)throws Exception;
   
    public CommonResponse modifyRequire(RequireDetail detail)throws Exception;

    public CommonResponse deleteById(String id)throws Exception;
    
    public CommonListResponse<RequireMyListDetail> myRequires(RequireRequest request) throws BusinessException;
    
	public boolean viewCount(Integer id, Integer viewCount);
	
	public List<RequireListDetail> findRequiresTop() throws BusinessException;
	
	public CommonResponse shiftRequire(RequireAudit request);
   
}
