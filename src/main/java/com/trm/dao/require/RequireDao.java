package com.trm.dao.require;

import java.util.List;

import com.trm.entity.TrmRequire;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.require.RequireAudit;
import com.trm.model.require.RequireListDetail;
import com.trm.model.require.RequireMyListDetail;
import com.trm.model.require.RequireRequest;
import com.trm.model.require.RequireSimDetail;

/**
 * 军民融合需求
 * @author zhaosimiao 2017-11-14 13:54:46
 */
public interface RequireDao {
	
	public CommonListResponse<RequireSimDetail> homeRequires(RequireRequest request) throws BusinessException;
	
    public CommonListResponse<RequireListDetail> findRequires(RequireRequest request) throws BusinessException;
	
    public TrmRequire getRequireById(Integer id) throws BusinessException;
    
    public CommonListResponse<RequireMyListDetail> myRequires(RequireRequest request) throws BusinessException;
    
    public boolean viewCount(Integer id, Integer viewCount);
    
    public List<RequireListDetail> findRequiresTop() throws BusinessException;
    
    public boolean shiftRequire(RequireAudit request);
    
}
