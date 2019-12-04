package com.trm.service.report;

import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.common.CommonResponse;
import com.trm.model.report.ReportDetail;
import com.trm.model.report.ReportListDetail;
import com.trm.model.report.ReportRequest;

/**
 * 互动交流
 * @author zhaosimiao 2017-12-12 14:42:16
 */
public interface ReportService {
	
	public CommonListResponse<ReportListDetail> getMyReports(ReportRequest request) throws BusinessException;
	
    public ReportDetail getReportById(Integer id) throws BusinessException;
    
    public CommonResponse createReport(ReportDetail detail)throws Exception;

    public CommonResponse updateReport(ReportDetail detail)throws Exception;
    
}
