package com.trm.dao.report;

import com.trm.dao.common.BaseDao;
import com.trm.entity.TrmReport;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.report.ReportListDetail;
import com.trm.model.report.ReportRequest;
import com.trm.util.Datetime;
import com.trm.util.ParameterUtils;
import com.trm.util.paging.QueryPage;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 线下统计报表
 * @author zhaosimiao 2017-12-13 11:11:11
 */
@Repository("reportDao")
public class ReportDaoImpl extends BaseDao implements ReportDao {
    
    public static Logger logger = LoggerFactory.getLogger(ReportDaoImpl.class);
    
    @SuppressWarnings("unchecked")
    @Override
    public CommonListResponse<ReportListDetail> getMyReports(ReportRequest request) throws BusinessException {
        
        // 1. 定义 查询语句
        String hql = "";
        
        //　2. 定义查询参数
        List<Object> list = new ArrayList<Object>();
        // 用户id
        Integer userId = request.getUserId();
        list.add(userId);
        list.add(userId);
        // 部门
        String department = request.getDepartment();
        String departmentHql = "";
        if (StringUtils.isNotEmpty(department)) {
            departmentHql = " and b.department = ?";
            list.add(ParameterUtils.getEqualParam(department));
        }
        // 用户名
        String username = request.getUsername();
        String userNameHql = "";
        if (StringUtils.isNotEmpty(username)) {
            userNameHql = " and b.username = ?";
            list.add(ParameterUtils.getEqualParam(username));
        }
        // 报表状态
        String reportStatus = request.getReportStatus();
        String reportStatusHql = "";
        if (StringUtils.isNotEmpty(reportStatus)) {
            userNameHql = " and a.reportStatus = ?";
            list.add(ParameterUtils.getEqualParam(reportStatus));
        }
        // 填报年份
        Integer reportYear = request.getReportYear();
        String reportYearHql = "";
        if (reportYear != null) {
            reportYearHql = " and a.reportYear = ?";
            list.add(reportYear);
        }
        // 填报季度
        Integer reportQuart = request.getReportQuart();
        String reportQuartHql = "";
        if (reportQuart != null) {
            reportQuartHql = " and a.reportQuart = ?";
            list.add(reportQuart);
        }
        // 填报开始时间-结束时间
        Date createStartTime = request.getCreateStartTime();
        Date createEndTime = request.getCreateEndTime();
        String createTimeHql = "";
        if (createStartTime != null && createEndTime == null) {
            list.add(createStartTime);
            createTimeHql = " and a.createTime >= ?";
        } else if (createStartTime == null && createEndTime != null) {
            list.add(Datetime.getDateAmountDays(createEndTime, 1));
            createTimeHql = " and a.createTime <= ?";
        } else if (createStartTime != null && createEndTime != null) {
            list.add(createStartTime);
            list.add(Datetime.getDateAmountDays(createEndTime, 1));
            createTimeHql = " and (a.createTime between ? and ?)";
        }
        
        hql = "select new com.trm.model.report.ReportListDetail(a.id, a.reportYear, a.reportQuart, "
                + " '设备设施共享情况季报' as reportName, a.createTime, b.username, a.reportStatus)"
                + " from TrmReport a, TrmMember b" + " where a.userId = b.id" + " and (a.userId = ? or b.masterId = ?)"
                + departmentHql + userNameHql + reportStatusHql + reportYearHql + reportQuartHql + createTimeHql
                + " order by a.updateTime desc";
        
        Object[] param = list.toArray();
        
        // 3. 定义返回参数
        CommonListResponse<ReportListDetail> response = new CommonListResponse<ReportListDetail>();
        
        // 4. 执行查询语句
        QueryPage query = new QueryPage(hql.toString(), param, request.getPageNum(), request.getNum(),
                this.getHibernateTemplate());
        
        response.setPageTotal(query.getPages());
        response.setList(query.getResult());
        response.setCount(query.getCount());
        
        return response;
    }
    
    @Override
    public TrmReport getReportById(Integer id) throws BusinessException {
        String hql = "from TrmReport where id =:id ";
        TrmReport entity = (TrmReport) this.currentSession().createQuery(hql).setParameter("id", id).uniqueResult();
        return entity;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<TrmReport> isReportExist(Integer unitId, Integer reportYear, Integer reportQuart) {
        String hql = "from TrmReport where unitId=:unitId and reportYear=:reportYear and reportQuart=:reportQuart";
        List<TrmReport> list = (List<TrmReport>) this.currentSession().createQuery(hql).setParameter("unitId", unitId)
                .setParameter("reportYear", reportYear).setParameter("reportQuart", reportQuart).list();
        return list;
    }
    
}
