package com.trm.dao.require;

import com.trm.dao.common.BaseDao;
import com.trm.entity.TrmRequire;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.require.RequireAudit;
import com.trm.model.require.RequireListDetail;
import com.trm.model.require.RequireMyListDetail;
import com.trm.model.require.RequireRequest;
import com.trm.model.require.RequireSimDetail;
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
 * 军民融合需求
 * @author zhaosimiao 2017-11-14 13:54:46
 */
@Repository("requireDao")
public class RequireDaoImpl extends BaseDao implements RequireDao {
    
    public static Logger logger = LoggerFactory.getLogger(RequireDaoImpl.class);
    
    @SuppressWarnings("unchecked")
    @Override
    public CommonListResponse<RequireSimDetail> homeRequires(RequireRequest request) throws BusinessException {
        
        String hql = "select new com.trm.model.require.RequireSimDetail(a.id, a.requireType, a.requireName, a.logoUrl,"
                + " (select name from SysDataDictionary s where s.code=a.equipType) as equipType, a.serviceRange)"
                + " from TrmRequire a" + " where a.audStatus = 'F2'" + " order by a.updateTime desc";
        
        CommonListResponse<RequireSimDetail> response = new CommonListResponse<RequireSimDetail>();
        
        QueryPage query = new QueryPage(hql.toString(), null, request.getPageNum(), request.getNum(),
                this.getHibernateTemplate());
        response.setPageTotal(query.getPages());
        response.setList(query.getResult());
        response.setCount(query.getCount());
        
        return response;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public CommonListResponse<RequireListDetail> findRequires(RequireRequest request) throws BusinessException {
        
        // 定义查询参数
        List<Object> list = new ArrayList<Object>();
        
        // 定义返回参数
        CommonListResponse<RequireListDetail> response = new CommonListResponse<RequireListDetail>();
        
        // 定义可能的查询条件参数
        StringBuffer hql = new StringBuffer();
        
        String searchKey = request.getSearchKey();
        // (1) 需求类型 1设备 2设施
        String requireType = request.getRequireType();
        hql.append("select new com.trm.model.require.RequireListDetail(a.id, a.requireType, a.requireName, "
                + " (select name from SysDataDictionary s where s.code=a.equipType) as equipType," + " a.serviceRange)"
                + " from TrmRequire a" + " where 1=1");
        if (StringUtils.isNotEmpty(requireType)) {
            hql.append(" and a.requireType = ?");
            list.add(requireType);
        }
        
        if (StringUtils.isNotEmpty(searchKey)) {
            // (2) 需求名称
            hql.append(" and (a.requireName like ?");
            // (3) 设备功能类别
            hql.append(" or a.equipType like ?");
            // (4) 服务领域
            hql.append(" or a.serviceRange like ?");
            // (5) 需求单位
            hql.append(" or a.requireUnit like ?");
            // (6) 需求单位地址
            hql.append(" or a.address like ?");
            // (7) 联系人
            hql.append(" or a.linkMan like ?");
            // (8) 联系手机
            hql.append(" or a.linkPhone like ?)");
            
            int pNum = 7;
            for (int i = 0; i < pNum; i++) {
                list.add(ParameterUtils.getLikeParam(searchKey));
            }
        }
        // 列表展示审核通过的军民融合需求
        hql.append(" and a.audStatus = 'F2'");
        // 时间倒序
        hql.append(" order by a.updateTime desc");
        
        Object[] param = null;
        if (list.size() >= 1) {
            param = list.toArray();
        }
        
        QueryPage query = new QueryPage(hql.toString(), param, request.getPageNum(), request.getNum(),
                this.getHibernateTemplate());
        response.setPageTotal(query.getPages());
        response.setList(query.getResult());
        response.setCount(query.getCount());
        return response;
    }
    
    @Override
    public TrmRequire getRequireById(Integer id) throws BusinessException {
        String hql = "from TrmRequire where id =:id ";
        TrmRequire detail = (TrmRequire) this.currentSession().createQuery(hql).setParameter("id", id).uniqueResult();
        return detail;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public CommonListResponse<RequireMyListDetail> myRequires(RequireRequest request) throws BusinessException {
        // 1. 定义 查询语句
        String validDateHql = "";
        String audDateHql = "";
        String hql = "";
        
        //　2. 定义查询参数
        List<Object> list = new ArrayList<Object>();
        // 用户id
        
        String department = request.getDepartment();
        String departmentHql = "";
        String handler = request.getHandler();
        String handlerHql = "";
        if (StringUtils.isNotEmpty(department)) {
            departmentHql = " and b.department = ?";
            list.add(ParameterUtils.getEqualParam(department));
        }
        if (StringUtils.isNotEmpty(handler)) {
            handlerHql = " and b.username = ?";
            list.add(ParameterUtils.getEqualParam(handler));
        }
        
        Integer orgId = request.getId();
        list.add(orgId);
        list.add(orgId);
        // 需求类别 设备需求1 设施需求2
        String requireType = request.getRequireType();
        list.add(ParameterUtils.getLikeParam(requireType));
        // 需求名称
        String requireName = request.getRequireName();
        list.add(ParameterUtils.getLikeParam(requireName));
        // 设备设施类别(唯一)
        String equipType = request.getEquipType();
        list.add(ParameterUtils.getLikeParam(equipType));
        // 审核状态
        String audStatus = request.getAudStatus();
        list.add(ParameterUtils.getLikeParam(audStatus));
        // 需求有效期开始时间-结束时间
        Date validStartDate = request.getValidStartDate();
        Date validEndDate = request.getValidEndDate();
        if (validStartDate != null && validEndDate == null) {
            list.add(validStartDate);
            validDateHql = " and a.validDate >= ?";
        } else if (validStartDate == null && validEndDate != null) {
            list.add(Datetime.getDateAmountDays(validEndDate, 1));
            validDateHql = " and a.validDate <= ?";
        } else if (validStartDate != null && validEndDate != null) {
            list.add(validStartDate);
            list.add(Datetime.getDateAmountDays(validEndDate, 1));
            validDateHql = " and (a.validDate >= ? and a.validDate <= ?)";
        }
        
        // 审核时间开始时间-结束时间
        Date audStartDate = request.getAudStartDate();
        Date audEndDate = request.getAudEndDate();
        if (audStartDate != null && audEndDate == null) {
            list.add(audStartDate);
            audDateHql = " and a.audDate >= ?";
        } else if (audStartDate == null && audEndDate != null) {
            list.add(Datetime.getDateAmountDays(audEndDate, 1));
            audDateHql = " and a.audDate <= ?";
        } else if (audStartDate != null && audEndDate != null) {
            list.add(audStartDate);
            list.add(Datetime.getDateAmountDays(audEndDate, 1));
            audDateHql = " and (a.audDate >= ? and a.audDate <= ?)";
        }
        
        hql = "select new com.trm.model.require.RequireMyListDetail(a.id, a.requireType, a.requireName, "
                + " (select name from SysDataDictionary s where s.code=a.equipType) as equipType, a.validDate, a.requireUnit,"
                + " a.audStatus, a.audDate, b.department, (select m.username from TrmMember m where m.id = a.orgId) as auser, b.userType)"
                + " from TrmRequire a,TrmMember b" + " where 1=1 and a.orgId = b.id" + departmentHql + handlerHql
                + " and (a.orgId = ? or b.masterId = ?)" + " and a.requireType like ?" + " and a.requireName like ?"
                + " and a.equipType like ?" + " and a.audStatus like ?" + validDateHql + audDateHql
                + " order by a.updateTime desc";
        
        Object[] param = list.toArray();
        
        // 3. 定义返回参数
        CommonListResponse<RequireMyListDetail> response = new CommonListResponse<RequireMyListDetail>();
        
        // 4. 执行查询语句
        QueryPage query = new QueryPage(hql.toString(), param, request.getPageNum(), request.getNum(),
                this.getHibernateTemplate());
        
        response.setPageTotal(query.getPages());
        response.setList(query.getResult());
        response.setCount(query.getCount());
        
        return response;
    }
    
    @Override
    public boolean viewCount(Integer id, Integer viewCount) {
        boolean flag = false;
        String sql = "update TrmRequire r set r.viewCount = ? where r.id = ?";
        int a = this.currentSession().createQuery(sql).setParameter(0, viewCount).setParameter(1, id).executeUpdate();
        if (a == 1) {
            flag = true;
        }
        return flag;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<RequireListDetail> findRequiresTop() throws BusinessException {
        
        String sql = "select new com.trm.model.require.RequireListDetail(a.id, a.requireType, a.requireName, "
                + " (select name from SysDataDictionary s where s.code=a.equipType) as equipType," + " a.serviceRange)"
                + " from TrmRequire a where a.audStatus = 'F2' order by a.viewCount desc";
        
        QueryPage query = new QueryPage(sql, null, 1, 6, this.getHibernateTemplate());
        return query.getResult();
    }
    
    @Override
    public boolean shiftRequire(RequireAudit request) {
        boolean flag = false;
        String sql = "update TrmRequire a set a.audStatus = ? where a.id = ?";
        int a = this.currentSession().createQuery(sql).setParameter(0, request.getAudStatus())
                .setParameter(1, request.getId()).executeUpdate();
        if (a == 1) {
            flag = true;
        }
        return flag;
    }
    
}
