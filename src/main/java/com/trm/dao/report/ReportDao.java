package com.trm.dao.report;

import java.util.List;

import com.trm.entity.TrmReport;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.report.ReportListDetail;
import com.trm.model.report.ReportRequest;

/**
 * 线下统计报表
 * @author zhaosimiao 2017-12-13 11:11:11
 */
public interface ReportDao {
	
    public CommonListResponse<ReportListDetail> getMyReports(ReportRequest request) throws BusinessException;
	
    public TrmReport getReportById(Integer id) throws BusinessException;
    
    public List<TrmReport> isReportExist(Integer unitId, Integer reportYear, Integer reportQuart);

}
