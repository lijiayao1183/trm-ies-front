package com.trm.service.report;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trm.constants.SystemConstants;
import com.trm.dao.common.CommonDao;
import com.trm.dao.member.MemberDao;
import com.trm.dao.report.ReportDao;
import com.trm.entity.TrmMember;
import com.trm.entity.TrmReport;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.common.CommonResponse;
import com.trm.model.report.ReportDetail;
import com.trm.model.report.ReportListDetail;
import com.trm.model.report.ReportRequest;
import com.trm.util.BeanUtils;
import com.trm.util.SessionUtil;

/**
 * 线下报表统计
 * @author zhaosimiao 2017-12-12 14:42:16
 */
@Service("reportService")
@Transactional(rollbackFor = Exception.class)
public class ReportServiceImpl implements ReportService {

    public static Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);
    
    @Autowired
    private ReportDao reportDao;
    
    @Autowired
    private MemberDao memberDao;
    
    @Autowired
    private CommonDao commonDao;
    
	@Override
	public CommonListResponse<ReportListDetail> getMyReports(ReportRequest request) throws BusinessException {
		CommonListResponse<ReportListDetail> response = reportDao.getMyReports(request);
		if (response.getList().size() < 1) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("报表列表查询为空！");
            throw bs;
        }
		return response;
	}

	@Override
	public ReportDetail getReportById(Integer id) throws BusinessException {
		TrmReport entity = reportDao.getReportById(id);
		if (null == entity) {
            BusinessException bs = new BusinessException();
            bs.setExceptionMsg("该id对应的报表信息不存在！");
            throw bs;
        }
		String orgName = memberDao.getUserinfo(entity.getUserId()).getOrgName();
		ReportDetail detail = new ReportDetail();
		BeanUtils.copyProperties(entity, detail);
		detail.setUnitName(orgName);
		return detail;
	}

	@Override
	public CommonResponse createReport(ReportDetail detail) throws Exception {
		CommonResponse response = new CommonResponse();
		Integer userId = SessionUtil.getUserIdFromSession();
    	if(null == userId) {
    		response.setCodeAndMsg("E0", "用户未登录，不能填写报表信息！");
    		return response;
    	}

		// F0 保存    F1提交    reportStatus
    	if(StringUtils.isEmpty(detail.getReportStatus())) {
    		response.setCodeAndMsg("E1", "提交状态不能为空！");
    		return response;
    	}
    	
    	// 唯一性校验
    	Integer unitId = SessionUtil.getUnitIdFromSession();
    	response = isReportExist(unitId,detail.getReportYear(),detail.getReportQuart());
    	if("9999".equals(response.getCode())) {
    		return response;
    	}
    	
    	TrmMember member = memberDao.getUserinfo(userId);
		detail.setUserId(userId);
		detail.setUnitId(member.getUnitId());
		detail.setDepartId(member.getDepartId());
		detail.setIsActive("Y");
		
    	TrmReport entity = new TrmReport();
    	BeanUtils.copyProperties(detail, entity);
    	boolean createFlag = commonDao.createEntity(entity);
		if(createFlag) {
			response.setCodeAndMsg("0000", "线下报表新增成功！");
		}
		else {
			response.setCodeAndMsg("9999", "线下报表新增失败！");
		}
		return response;
	}

	@Override
	public CommonResponse updateReport(ReportDetail detail) throws Exception {
		CommonResponse response = new CommonResponse();
		Integer userId = SessionUtil.getUserIdFromSession();
    	if(null == userId) {
    		response.setCodeAndMsg("E0", "用户未登录，不能填写报表信息！");
    		return response;
    	}
    	if(null == detail.getId()) {
    		response.setCodeAndMsg("E1", "报表编辑id不能为空！");
    		return response;
    	}
    	
    	TrmReport entity = reportDao.getReportById(detail.getId());
    	
    	Integer dbReportYear = entity.getReportYear();
    	Integer dbReportQuart = entity.getReportQuart();
    	if(!dbReportYear.equals(detail.getReportYear()) || !dbReportQuart.equals(detail.getReportQuart())) {
	    	// 唯一性校验
	    	Integer unitId = SessionUtil.getUnitIdFromSession();
	    	response = isReportExist(unitId,detail.getReportYear(),detail.getReportQuart());
	    	if("9999".equals(response.getCode())) {
	    		return response;
	    	}
    	}
    	String dbStatus = entity.getReportStatus();
    	if(null != dbStatus && "F1".equals(dbStatus)){
            response.setCodeAndMsg("E2", "提交状态的报表不能修改！");
            return response;
        }
    	BeanUtils.copyProperties(detail, entity);
    	boolean updateFlag = commonDao.modifyEntity(entity);
        if(updateFlag) {
			response.setCodeAndMsg("0000", "线下报表修改成功！");
		}
		else {
			response.setCodeAndMsg("9999", "线下报表修改失败！");
		}
		return response;
	}
	
	private CommonResponse isReportExist(Integer unitId, Integer reportYear, Integer reportQuart) {
		CommonResponse response = new CommonResponse();
		List<TrmReport> list = reportDao.isReportExist(unitId, reportYear, reportQuart);
		if(list.size() < 1) {
			response.setCodeAndMsg("0000", "该单位季报信息可用！");
		}
		else {
			response.setCodeAndMsg("9999", "该单位季报信息已存在，不可重复提交！");
		}
		return response;
	}

}
