/**
 * @Title: DemandDaoImpl.java
 * @Package: com.trm.dao.require
 * @Description: TODO(用一句话描述该文件做什么)
 * @Copyright: Copyright (c)
 * @Company: Digital Telemedia Co.,Ltd
 * @author LiuJC
 * @date 2018年02月26 上午10:51
 * @version V1.0
 * @Revision 2018年02月26 上午10:51
 */

package com.trm.dao.require;

import com.trm.constants.SystemConstants;
import com.trm.dao.common.BaseDao;
import com.trm.dao.common.SysDataDao;
import com.trm.entity.SysDataDictionary;
import com.trm.entity.TrmDemand;
import com.trm.entity.TrmTechnology;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.AuditRequest;
import com.trm.model.common.ComIntData;
import com.trm.model.common.CommonListResponse;
import com.trm.model.common.SysDataRequest;
import com.trm.model.equip.CountEquip;
import com.trm.model.equip.EquipDayReq;
import com.trm.model.require.CateCountDemand;
import com.trm.model.require.DemandDetails;
import com.trm.model.require.DemandIndex;
import com.trm.model.require.DemandListResp;
import com.trm.model.require.RequireRequest;
import com.trm.model.require.TotalCommonDemand;
import com.trm.util.Datetime;
import com.trm.util.ParameterUtils;
import com.trm.util.SessionUtil;
import com.trm.util.paging.QueryPage;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.internal.QueryImpl;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName DemandDaoImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author LiuJC
 * @Date 2018年02月26 上午10:51
 * @version 1.0.0
 */
@Repository("demandDao")
public class DemandDaoImpl extends BaseDao implements DemandDao {
    @Autowired
    private SysDataDao sysDataDao;
    
    public CommonListResponse<DemandListResp> myDemand(RequireRequest requireReques) throws BusinessException {
        StringBuffer sbHql = new StringBuffer(
                "select new com.trm.model.require.DemandListResp(a.id,a.code,a.name,a.type,b.department,a.audDate,a.audStatus,b.username,b.userType) from TrmDemand a , TrmMember b "
                        + "where a.memberId=b.id and b.isActive='Y' and b.isActive='Y' ");
        List<Object> list = new ArrayList<Object>();
        if (StringUtils.isNotEmpty(requireReques.getDepartment())) {//部门
            sbHql.append("and b.department = ? ");
            list.add(requireReques.getDepartment());
        }
        if (StringUtils.isNotEmpty(requireReques.getHandler())) {//会员
            sbHql.append("and b.username = ? ");
            list.add(requireReques.getHandler());
        }
        if (StringUtils.isNotEmpty(requireReques.getRequireType())) {//类型
            sbHql.append("and a.type = ? ");
            list.add(requireReques.getRequireType());
        }
        if (StringUtils.isNotEmpty(requireReques.getRequireName())) {//需求名称
            sbHql.append("and a.name = ? ");
            list.add(requireReques.getRequireName());
        }
        if (StringUtils.isNotEmpty(requireReques.getAudStatus())) {//审核状态
            sbHql.append("and a.audStatus = ? ");
            list.add(requireReques.getAudStatus());
        }
        if (null != requireReques.getValidStartDate()) {//有效期开始
            sbHql.append("and a.endDate >= ? ");
            list.add(requireReques.getValidStartDate());
        }
        if (null != requireReques.getValidEndDate()) {//有效期结束
            sbHql.append("and a.endDate < ? ");
            list.add(Datetime.getDateAmountDays(requireReques.getValidEndDate(), 1));
        }
        if (null != requireReques.getAudStartDate()) {//审核状态
            sbHql.append("and a.audDate >= ? ");
            list.add(requireReques.getAudStartDate());
        }
        if (null != requireReques.getAudEndDate()) {//审核状态
            sbHql.append("and a.audDate < ? ");
            list.add(Datetime.getDateAmountDays(requireReques.getAudEndDate(), 1));
        }
        String userTypeFromSession = SessionUtil.getUserTypeFromSession();
        Integer unitIdFromSession = SessionUtil.getUnitIdFromSession();
        if ("2".equals(userTypeFromSession)) {
            sbHql.append(" and a.orgId = ?");
            list.add(unitIdFromSession);
        }
        Integer userIdFromSession = SessionUtil.getUserIdFromSession();
        if ("1".equals(userTypeFromSession)) {
            sbHql.append(" and a.memberId = ?");
            list.add(userIdFromSession);
        }
        
        sbHql.append(" order by a.updateTime desc");
        
        Object[] param = list.toArray();
        
        CommonListResponse<DemandListResp> response = new CommonListResponse<>();
        
        QueryPage query = new QueryPage(sbHql.toString(), param, requireReques.getPageNum(), requireReques.getNum(),
                this.getHibernateTemplate());
        if (0 == query.getCount()) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("我的军民融合需求列表查询为空！");
            throw bs;
        }
        response.setPageTotal(query.getPages());
        response.setList(query.getResult());
        response.setCount(query.getCount());
        return response;
    }
    
    @Override
    public DemandDetails getMyDemandById(Integer id) throws BusinessException {
        String hql = "from TrmDemand where id = ? and isActive='Y'";
        String hqlTech = "from TrmTechnology where demandId = ? and isActive='Y' ";
        TrmDemand trmDemand = (TrmDemand) this.currentSession().createQuery(hql).setParameter(0, id).uniqueResult();
        if (null == trmDemand) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("军民融合需求不存在！");
            throw bs;
        }
        List<TrmTechnology> trmTechnologies = (List<TrmTechnology>) this.currentSession().createQuery(hqlTech)
                .setParameter(0, id).list();
        DemandDetails demandDetails = new DemandDetails();
        demandDetails.setTrmDemand(trmDemand);
        demandDetails.setTechnologies(trmTechnologies);
        return demandDetails;
    }
    
    @Override
    public boolean auditDemand(AuditRequest request) {
        boolean flag = false;
        String sql = "update TrmDemand r " + " set r.audPerson = ?, " + " r.audOpinion = ?, " + " r.audDate = ?, "
                + " r.audStatus = ? " + " where r.id = ?";
        int count = this.currentSession().createQuery(sql)
                // 审核人
                .setParameter(0, request.getAuditor())
                // 审核意见
                .setParameter(1, request.getAuditMsg())
                // 审核时间
                .setParameter(2, new Date())
                // 审核状态
                .setParameter(3, request.getStatus())
                // id
                .setParameter(4, request.getAuditId()).executeUpdate();
        if (count == 1) {
            flag = true;
        }
        return flag;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public CommonListResponse<DemandIndex> homeDemand(RequireRequest request) throws BusinessException {
        
        String hql = "select new com.trm.model.require.DemandIndex(a.id, a.code, a.name, a.type, a.domain )"
                + " from TrmDemand a " + " where a.isActive = 'Y' and a.audStatus = 'F2'" + " order by a.audDate desc";
        
        TotalCommonDemand<DemandIndex> response = new TotalCommonDemand<DemandIndex>();
        
        QueryPage query = new QueryPage(hql.toString(), null, request.getPageNum(), request.getNum(),
                this.getHibernateTemplate());
        response.setPageTotal(query.getPages());
        response.setList(query.getResult());
        response.setCount(query.getCount());
        
        String techNumHql = "select count(a.id) from TrmDemand a where a.isActive = 'Y' and  a.type = '技术需求' and a.audStatus = 'F2'";
        String prodNumHql = "select count(a.id) from TrmDemand a where a.isActive = 'Y' and  a.type = '产品需求' and a.audStatus = 'F2'";
        String moneyNumHql = "select count(a.id) from TrmDemand a where a.isActive = 'Y' and  a.type = '融资需求' and a.audStatus = 'F2'";
        
        Long techNum = (Long) this.currentSession().createQuery(techNumHql).uniqueResult();
        Long prodNum = (Long) this.currentSession().createQuery(prodNumHql).uniqueResult();
        Long moneyNum = (Long) this.currentSession().createQuery(moneyNumHql).uniqueResult();
        response.setTechNum(techNum);
        response.setProdNum(prodNum);
        response.setMoneyNum(moneyNum);
        return response;
    }
    
    /**
     * 首页左侧统计
     * @param comIntData
     * @return
     * @throws BusinessException
     */
    public List<CateCountDemand> recentlyMoreDemand(ComIntData comIntData) throws BusinessException {
        //统计总条数  前N条
        String countSql =
                "SELECT DATE_FORMAT( a.audDate, '%Y-%m-%d' ) as date , COUNT(a.id ) as num FROM trm_demand a where a.isActive = 'Y' and a.audStatus = 'F2' "
                        + " GROUP BY DATE_FORMAT( a.audDate, '%Y-%m-%d' ) ORDER BY DATE_FORMAT( a.audDate, '%Y-%m-%d' ) desc limit :num";
        //统计技术需求  前N条
        String techSql = "SELECT DATE_FORMAT( a.audDate, '%Y-%m-%d' ) as date , COUNT(a.id ) as num FROM trm_demand a "
                + "where a.isActive = 'Y' and a.audStatus = 'F2' and a.type = '技术需求'"
                + "GROUP BY DATE_FORMAT( a.audDate, '%Y-%m-%d' ),a.type ORDER BY DATE_FORMAT( a.audDate, '%Y-%m-%d' ) desc limit :num";
        //统计产品需求  前N条
        String prodSql = "SELECT DATE_FORMAT( a.audDate, '%Y-%m-%d' ) as date , COUNT(a.id ) as num FROM trm_demand a "
                + "where  a.isActive = 'Y' and a.audStatus = 'F2' and a.type = '产品需求'"
                + "GROUP BY DATE_FORMAT( a.audDate, '%Y-%m-%d' ),a.type ORDER BY DATE_FORMAT( a.audDate, '%Y-%m-%d' ) desc limit :num";
        
        //统计融资需求  前N条
        String moneySql = "SELECT DATE_FORMAT( a.audDate, '%Y-%m-%d' ) as date , COUNT(a.id ) as num FROM trm_demand a "
                + "where  a.isActive = 'Y' and a.audStatus = 'F2' and a.type = '融资需求'"
                + "GROUP BY DATE_FORMAT( a.audDate, '%Y-%m-%d' ),a.type ORDER BY DATE_FORMAT( a.audDate, '%Y-%m-%d' ) desc limit :num";
        
        List<CountEquip> countEquipList = this.currentSession().createSQLQuery(countSql)
                .addScalar("date", StandardBasicTypes.STRING).addScalar("num", StandardBasicTypes.LONG)
                .setResultTransformer(Transformers.aliasToBean(CountEquip.class))
                .setParameter("num", comIntData.getNum()).list();
        
        List<CountEquip> techEquipList = this.currentSession().createSQLQuery(techSql)
                .addScalar("date", StandardBasicTypes.STRING).addScalar("num", StandardBasicTypes.LONG)
                .setResultTransformer(Transformers.aliasToBean(CountEquip.class))
                .setParameter("num", comIntData.getNum()).list();
        
        List<CountEquip> prodEquipList = this.currentSession().createSQLQuery(prodSql)
                .addScalar("date", StandardBasicTypes.STRING).addScalar("num", StandardBasicTypes.LONG)
                .setResultTransformer(Transformers.aliasToBean(CountEquip.class))
                .setParameter("num", comIntData.getNum()).list();
        
        List<CountEquip> moneyEquipList = this.currentSession().createSQLQuery(moneySql)
                .addScalar("date", StandardBasicTypes.STRING).addScalar("num", StandardBasicTypes.LONG)
                .setResultTransformer(Transformers.aliasToBean(CountEquip.class))
                .setParameter("num", comIntData.getNum()).list();
        
        List<CateCountDemand> cateCountEquips = new ArrayList<>();
        if (null == countEquipList || 0 == countEquipList.size()) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("军民融合需求查询为空！");
            throw bs;
        }
        for (int i = 0; i < countEquipList.size(); i++) {
            CateCountDemand cateCountEquip = new CateCountDemand();
            CountEquip countEquip = countEquipList.get(i);
            
            String date = countEquip.getDate();
            cateCountEquip.setDate(date);
            cateCountEquip.setNum(countEquip.getNum());
            cateCountEquip.setTechNum(new Long(0));
            cateCountEquip.setProdNum(new Long(0));
            cateCountEquip.setMoneyNum(new Long(0));
            Iterator<CountEquip> iterator = techEquipList.iterator();
            Iterator<CountEquip> prodIterator = prodEquipList.iterator();
            Iterator<CountEquip> moneyIterator = moneyEquipList.iterator();
            while (iterator.hasNext()) {
                CountEquip next = iterator.next();
                if (date.equals(next.getDate())) {
                    cateCountEquip.setTechNum(next.getNum());
                    iterator.remove();
                    break;
                }
            }
            while (prodIterator.hasNext()) {
                CountEquip next = prodIterator.next();
                if (date.equals(next.getDate())) {
                    cateCountEquip.setProdNum(next.getNum());
                    prodIterator.remove();
                    break;
                }
            }
            
            while (moneyIterator.hasNext()) {
                CountEquip next = moneyIterator.next();
                if (date.equals(next.getDate())) {
                    cateCountEquip.setMoneyNum(next.getNum());
                    moneyIterator.remove();
                    break;
                }
            }
            cateCountEquips.add(cateCountEquip);
        }
        
        return cateCountEquips;
    }
    
    @Override
    public CommonListResponse<DemandIndex> findDemand(RequireRequest request) throws BusinessException {
        CommonListResponse<DemandIndex> response = new CommonListResponse<DemandIndex>();
        StringBuffer baseSql = new StringBuffer(
                "select new com.trm.model.require.DemandIndex(a.id, a.code, a.name, a.type, a.domain)"
                        + " from TrmDemand a   where a.isActive = 'Y' and a.audStatus = 'F2' ");
        String requireType = request.getRequireType();
        String searchKey = request.getSearchKey();
        
        // 定义查询参数
        List<Object> list = new ArrayList<Object>();
        
        if (StringUtils.isNotEmpty(requireType)) {
            baseSql.append(" and a.type = ?");
            list.add(requireType);
        }
        if (StringUtils.isNotEmpty(searchKey)) {
            // (2) 需求名称
            baseSql.append(" and (a.name like ?");
            list.add(ParameterUtils.getLikeParam(searchKey));
            // (3) 设备功能类别
            baseSql.append(" or a.keyword like ?");
            list.add(ParameterUtils.getLikeParam(searchKey));
            // (4) 服务领域
            SysDataRequest sysData = new SysDataRequest();
            sysData.setName(searchKey);
            List<SysDataDictionary> serviceDomain = sysDataDao.findServiceDomain(sysData);
            if (null != serviceDomain && 0 != serviceDomain.size()) {
                for (int i = 0; i < serviceDomain.size(); i++) {
                    SysDataDictionary sysDataDictionary = serviceDomain.get(i);
                    String code = sysDataDictionary.getCode();
                    baseSql.append(" or a.domain like ?");
                    list.add(ParameterUtils.getLikeParam(code));
                }
            }
            
            // (5) 需求单位
            baseSql.append(" or a.companyName like ?");
            list.add(ParameterUtils.getLikeParam(searchKey));
            // (6) 需求单位地址
            baseSql.append(" or a.companyAddr like ?");
            list.add(ParameterUtils.getLikeParam(searchKey));
            // (7) 联系人
            baseSql.append(" or a.contacts like ?");
            list.add(ParameterUtils.getLikeParam(searchKey));
            // (8) 来源
            baseSql.append(" or a.source like ?");
            list.add(ParameterUtils.getLikeParam(searchKey));
            // (9) 联系手机
            baseSql.append(" or a.phone like ?)");
            list.add(ParameterUtils.getLikeParam(searchKey));
        }
        // 时间倒序
        baseSql.append(" order by a.updateTime desc");
        Object[] param = null;
        if (list.size() >= 1) {
            param = list.toArray();
        }
        QueryPage query = new QueryPage(baseSql.toString(), param, request.getPageNum(), request.getNum(),
                this.getHibernateTemplate());
        if (0 == query.getCount()) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("军民融合需求查询为空！");
            throw bs;
        }
        
        response.setPageTotal(query.getPages());
        response.setList(query.getResult());
        response.setCount(query.getCount());
        return response;
    }
    
    @Override
    public boolean addViewCount(Integer id) {
        String hql = "update TrmDemand a set a.viewCount = a.viewCount + 1 where id = ? ";
        int i = this.currentSession().createQuery(hql).setParameter(0, id).executeUpdate();
        if (1 == i) {
            return true;
        }
        return false;
    }
    
    @Override
    public CommonListResponse<DemandIndex> findHotDemand(RequireRequest request) throws BusinessException {
        CommonListResponse<DemandIndex> response = new CommonListResponse<DemandIndex>();
        String hql = "select new com.trm.model.require.DemandIndex(a.id, a.code, a.name, a.type, a.domain )"
                + " from TrmDemand a where a.isActive = 'Y' and a.audStatus = 'F2' order by a.viewCount desc";
        QueryPage query = new QueryPage(hql, null, request.getPageNum(), request.getNum(), this.getHibernateTemplate());
        if (0 == query.getCount()) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("军民融合需求查询为空！");
            throw bs;
        }
        
        response.setPageTotal(query.getPages());
        response.setList(query.getResult());
        response.setCount(query.getCount());
        return response;
    }
    
    /**
     * 按日期查询
     * @param equipDayReq
     * @return
     * @throws BusinessException
     */
    @Override
    public CommonListResponse<DemandIndex> findDemandByDay(EquipDayReq equipDayReq) throws BusinessException {
        //TrmMember.audStatus R0待审核，R1审核通过，R2未通过
        String hql = "select new com.trm.model.require.DemandIndex(a.id, a.code, a.name, a.type, a.domain)"
                + "from TrmDemand a where a.isActive = 'Y' and a.audStatus = 'F2' and to_days( a.audDate ) = to_days( ? ) "
                + "order by a.audDate desc";
        Object[] param = { equipDayReq.getDay() };
        
        CommonListResponse<DemandIndex> response = new CommonListResponse<>();
        QueryPage query = new QueryPage(hql.toString(), param, 1, equipDayReq.getNum(), this.getHibernateTemplate());
        if (0 == query.getCount()) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("军民融合需求查询为空！");
            throw bs;
        }
        response.setPageTotal(query.getPages());
        response.setList(query.getResult());
        response.setCount(query.getCount());
        return response;
    }
    
    @Override
    public boolean delByDemand(Integer id) {
        String hql = "update TrmDemand set isActive = 'N' where id = ?";
        int i = this.currentSession().createQuery(hql).setParameter(0, id).executeUpdate();
        return true;
    }
    
    @Override
    public boolean batchDelDemands(String[] ids) {
        for (int i = 0; i < ids.length; i++) {
            delByDemand(new Integer(ids[i]));
        }
        return true;
    }

    @Override
    public CommonListResponse<TrmDemand> findList(String startTime, String endTime) {
        String hql = "from TrmDemand where createTime > :startTime and createTime <= :endTime";
        Query query = currentSession().createQuery(hql);
        query.setString("startTime", startTime);
        query.setString("endTime", endTime);
        List<TrmDemand> list = query.list();
        CommonListResponse response = new CommonListResponse();
        response.setCount(list.size());
        response.setList(list);
        return response;
    }
}
