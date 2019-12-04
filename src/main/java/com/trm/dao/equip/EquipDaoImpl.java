package com.trm.dao.equip;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.trm.entity.TrmDemand;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.annotations.common.util.StringHelper;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trm.dao.common.BaseDao;
import com.trm.entity.TrmEquip;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.AuditRequest;
import com.trm.model.common.ComIntData;
import com.trm.model.common.CommonListResponse;
import com.trm.model.equip.CateCountEquip;
import com.trm.model.equip.CountEquip;
import com.trm.model.equip.EquipDayReq;
import com.trm.model.equip.EquipReq;
import com.trm.model.equip.EquipSimDetail;
import com.trm.model.equip.HomeEquipReq;
import com.trm.model.equip.HomeEquipSimDetail;
import com.trm.model.equip.IndexPageEqip;
import com.trm.model.equip.MyEquipReq;
import com.trm.model.equip.MyEquipSimDetail;
import com.trm.util.Datetime;
import com.trm.util.ParameterUtils;
import com.trm.util.SessionUtil;
import com.trm.util.paging.QueryPage;

/**
 * @description
 */
@Repository("equipDao")
public class EquipDaoImpl extends BaseDao implements EquipDao {
    
    public static Logger logger = LoggerFactory.getLogger(EquipDaoImpl.class);
    
    @SuppressWarnings("unchecked")
    @Override
    public CommonListResponse<HomeEquipSimDetail> findAll(HomeEquipReq requestParameter) throws BusinessException {
        //TrmMember.audStatus R0待审核，R1审核通过，R2未通过
        String hql =
                "select new com.trm.model.equip.HomeEquipSimDetail(a.id, a.equipName, a.equipPic1, a.equipPic2, a.equipPic3) "
                        + "from TrmEquip a,TrmMember b where 1=1 and a.orgId = b.id and b.audStatus = 'R1' and a.audStatus = 'F2' and a.isDisplay = 'Y' "
                        + "order by a.id desc";
        Object[] param = {};
        
        IndexPageEqip<HomeEquipSimDetail> response = new IndexPageEqip<>();
        QueryPage query = new QueryPage(hql.toString(), param, requestParameter.getPageNum(), requestParameter.getNum(),
                this.getHibernateTemplate());
        response.setPageTotal(query.getPages());
        response.setList(query.getResult());
        response.setCount(query.getCount());
        //--------------------2018-2-23  数量统计-------------------------
        String faciNumHql =
                "select count(a.id) from TrmEquip a ,TrmMember b ,SysDataDictionary c  where a.orgId = b.id and b.audStatus = 'R1' and a.audStatus = 'F2' and a.isDisplay = 'Y' "
                        + " and a.equipType=c.code and c.subType='军工试验设施'";
        String eqipNumHql =
                "select count(a.id) from TrmEquip a ,TrmMember b ,SysDataDictionary c  where a.orgId = b.id and b.audStatus = 'R1' and a.audStatus = 'F2' and a.isDisplay = 'Y' "
                        + " and a.equipType=c.code and c.subType='军工大型科研仪器'";
        Long eqipNum = (Long) this.currentSession().createQuery(eqipNumHql).uniqueResult();
        Long faciNum = (Long) this.currentSession().createQuery(faciNumHql).uniqueResult();
        response.setEqipNum(eqipNum);
        response.setFaciNum(faciNum);
        return response;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public CommonListResponse<MyEquipSimDetail> findAllMyEqip(MyEquipReq requestParameter) throws BusinessException {
        List<Object> list = new ArrayList<Object>();
        String department = requestParameter.getDepartment();
        String departmentHql = "";
        String handler = requestParameter.getHandler();
        String handlerHql = "";
        if (StringUtils.isNotEmpty(department)) {
            departmentHql = " and b.department = ?";
            list.add(ParameterUtils.getEqualParam(department));
        }
        if (StringUtils.isNotEmpty(handler)) {
            handlerHql = " and b.username = ?";
            list.add(ParameterUtils.getEqualParam(handler));
        }
        Date startT = requestParameter.getAudStartTime();
        Date endT = requestParameter.getAudEndTime();
        String where = "";
        if (null != startT) {
            list.add(startT);
            where += " and a.audDate >= ? ";
        }
        if (null != endT) {
            list.add(Datetime.getDateAmountDays(endT, 1));
            where += " and a.audDate <= ? ";
        }
        String equipName = requestParameter.getEquipName();
        if (StringHelper.isNotEmpty(equipName)) {
            list.add(ParameterUtils.getLikeParam(equipName));
            where += " and a.equipName like ? ";
        }
        String equipType = requestParameter.getEquipType();
        if (StringHelper.isNotEmpty(equipType)) {
            list.add(ParameterUtils.getLikeParam(equipType));
            where += " and a.equipType like ? ";
        }
        String audStatus = requestParameter.getAudStatus();
        if (StringHelper.isNotEmpty(audStatus)) {
            list.add(ParameterUtils.getLikeParam(audStatus));
            
            // modify by zhaosimiao
            if ("N".equals(audStatus)) {
                where += "and a.isDisplay like ? ";
            } else if ("F2".equals(audStatus)) {
                where += "and a.audStatus like ? and a.isDisplay = 'Y'";
            } else {
                where += "and a.audStatus like ?";
            }
            
        }
        String orgName = requestParameter.getOrgName();
        if (StringHelper.isNotEmpty(orgName)) {
            list.add(ParameterUtils.getLikeParam(orgName));
            where += " and b.orgName like ? ";
        }
        String hql =
                "select new com.trm.model.equip.MyEquipSimDetail(a.id, a.equipName, a.equipType, a.audStatus, a.audDate, a.isDisplay, "
                        + "b.department, (select m.username from TrmMember m where m.id = a.orgId) as auser, b.userType) "
                        + "from TrmEquip a,TrmMember b where 1=1 and a.orgId = b.id and b.audStatus = 'R1' "
                        + departmentHql + handlerHql + where;
        // + " and (a.orgId = ? or b.masterId = ?) ";
        Integer unitIdFromSession = SessionUtil.getUnitIdFromSession();
        Integer userIdFromSession = SessionUtil.getUserIdFromSession();
        String userTypeFromSession = SessionUtil.getUserTypeFromSession();
        if ("2".equals(userTypeFromSession)) {
            hql += " and b.unitId = ? ";
            list.add(unitIdFromSession);
        }
        if ("1".equals(userTypeFromSession)) {
            hql += " and a.orgId = ?";
            list.add(userIdFromSession);
        }
        hql += "order by a.updateTime desc";
       /*
        list.add(requestParameter.getOrgId());
        list.add(requestParameter.getOrgId());*/
        Object[] param = list.toArray();
        
        CommonListResponse<MyEquipSimDetail> response = new CommonListResponse<MyEquipSimDetail>();
        QueryPage query = new QueryPage(hql.toString(), param, requestParameter.getPageNum(), requestParameter.getNum(),
                this.getHibernateTemplate());
        response.setPageTotal(query.getPages());
        response.setList(query.getResult());
        response.setCount(query.getCount());
        return response;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public CommonListResponse<EquipSimDetail> seniorFindAll(EquipReq requestParameter) throws BusinessException {
        List<Object> list = new ArrayList<Object>();
        List<String> equipType = requestParameter.getEquipType();
        String equipWhere = "";
        if (null != equipType && equipType.size() > 0) {
            equipWhere += "and(";
            for (int i = 0; i < equipType.size(); i++) {
                if (i == (equipType.size() - 1)) {
                    list.add(ParameterUtils.getLikeParam(equipType.get(i)));
                    equipWhere += " a.equipType like ?) ";
                } else {
                    list.add(ParameterUtils.getLikeParam(equipType.get(i)));
                    equipWhere += " a.equipType like ? or";
                }
            }
        }
        
        List<String> serviceRange = requestParameter.getServiceRange();
        String serviceWhere = "";
        if (null != serviceRange && serviceRange.size() > 0) {
            serviceWhere += "and(";
            for (int i = 0; i < serviceRange.size(); i++) {
                if (i == (serviceRange.size() - 1)) {
                    list.add(ParameterUtils.getLikeParam(serviceRange.get(i)));
                    serviceWhere += " a.serviceRange like ?) ";
                } else {
                    list.add(ParameterUtils.getLikeParam(serviceRange.get(i)));
                    serviceWhere += " a.serviceRange like ? or";
                }
            }
        }
        //TrmEquip.audStatus F1未审核，F2审核通过，F3未通过，R1已退回
        String equipOrgType =
                requestParameter.getEquipOrgType() == null || StringHelper.isEmpty(requestParameter.getEquipOrgType()) ?
                        "and" :
                        requestParameter.getEquipOrgType();
        String orgQualType =
                requestParameter.getOrgQualType() == null || StringHelper.isEmpty(requestParameter.getOrgQualType()) ?
                        "and" :
                        requestParameter.getOrgQualType();
        String qualUseType =
                requestParameter.getQualUseType() == null || StringHelper.isEmpty(requestParameter.getQualUseType()) ?
                        "and" :
                        requestParameter.getQualUseType();
        String useTecType =
                requestParameter.getUseTecType() == null || StringHelper.isEmpty(requestParameter.getUseTecType()) ?
                        "and" :
                        requestParameter.getUseTecType();
        String hql =
                "select new com.trm.model.equip.EquipSimDetail(a.id, a.equipName, a.equipType, a.serviceRange, a.proCountry,a.equipVerCode,a.equipPic1) "
                        + "from TrmEquip a,TrmMember b where 1=1 " + equipWhere + serviceWhere + " and a.orgId = b.id "
                        + "and a.equipName like ? " + equipOrgType + " (b.orgName IS NULL OR b.orgName like ?) "
                        + orgQualType + " a.qualification like ? " + qualUseType + " a.useField like ? " + useTecType
                        + " a.tecFeature like ? and a.audStatus = 'F2'  and a.isDisplay = 'Y' order by a.id desc";
        
        // modify by zhaosimiao 全文检索
        // begin
        String equipName = requestParameter.getEquipName();
        String orgName = requestParameter.getOrgName();
        String qualification = requestParameter.getQualification();
        String useField = requestParameter.getUseField();
        String tecFeature = requestParameter.getTecFeature();
        
        // 将数据库中的equipType、serviceRange code转换成name
        
        // equipName 为搜索框中参数
        if (StringUtils.isNotEmpty(equipName) && StringUtils.isEmpty(orgName) && StringUtils.isEmpty(qualification)
                && StringUtils.isEmpty(useField) && StringUtils.isEmpty(tecFeature)) {
            list.add(ParameterUtils.getLikeParam(equipName));
            list.add(ParameterUtils.getLikeParam(equipName));
            list.add(ParameterUtils.getLikeParam(equipName));
            list.add(ParameterUtils.getLikeParam(equipName));
            list.add(ParameterUtils.getLikeParam(equipName));
            
            hql = "select new com.trm.model.equip.EquipSimDetail(a.id, a.equipName, a.equipType, a.serviceRange, a.proCountry,a.equipVerCode,a.equipPic1) "
                    + " from TrmEquip a,TrmMember b where 1=1 " + equipWhere + serviceWhere + "and a.orgId = b.id "
                    + " and (a.equipName like ? or (b.orgName IS NULL OR b.orgName like ?) or a.qualification like ? "
                    + " or a.useField like ? or a.tecFeature like ?) and a.audStatus = 'F2'  and a.isDisplay = 'Y' order by a.id desc";
        } else {
            list.add(ParameterUtils.getLikeParam(equipName));
            list.add(ParameterUtils.getLikeParam(orgName));
            list.add(ParameterUtils.getLikeParam(qualification));
            list.add(ParameterUtils.getLikeParam(useField));
            list.add(ParameterUtils.getLikeParam(tecFeature));
            
            hql = "select new com.trm.model.equip.EquipSimDetail(a.id, a.equipName, a.equipType, a.serviceRange, a.proCountry,a.equipVerCode,a.equipPic1) "
                    + "from TrmEquip a,TrmMember b where 1=1 " + equipWhere + serviceWhere + " and a.orgId = b.id "
                    + "and a.equipName like ? " + equipOrgType + " (b.orgName IS NULL OR b.orgName like ?) "
                    + orgQualType + " a.qualification like ? " + qualUseType + " a.useField like ? " + useTecType
                    + " a.tecFeature like ? and a.audStatus = 'F2'  and a.isDisplay = 'Y' order by a.id desc";
        }
        // end
        
        Object[] param = list.toArray();
        
        CommonListResponse<EquipSimDetail> response = new CommonListResponse<EquipSimDetail>();
        QueryPage query = new QueryPage(hql.toString(), param, requestParameter.getPageNum(), requestParameter.getNum(),
                this.getHibernateTemplate());
        response.setPageTotal(query.getPages());
        response.setList(query.getResult());
        response.setCount(query.getCount());
        return response;
    }
    
    @Override
    public TrmEquip findDetailById(Integer id) throws BusinessException {
        String hql = "from TrmEquip where id =:id ";
        TrmEquip Detail = (TrmEquip) this.currentSession().createQuery(hql).setParameter("id", id).uniqueResult();
        return Detail;
    }
    
    @Override
    public Integer createTrmEquip(TrmEquip entity) throws BusinessException {
        try {
            this.getHibernateTemplate().save(entity);
            return entity.getId();
        } catch (Exception e) {
            logger.error("新增数据报错!", entity.getClass().getName(), e.getMessage());
            throw e;
        }
    }
    
    @Override
    public boolean viewCount(Integer id, Integer viewCount) {
        boolean flag = false;
        String sql = "update TrmEquip r set r.viewCount = ? where r.id = ?";
        int a = this.currentSession().createQuery(sql).setParameter(0, viewCount).setParameter(1, id).executeUpdate();
        if (a == 1) {
            flag = true;
        }
        return flag;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<EquipSimDetail> seniorEquipTop() throws BusinessException {
        
        String hql =
                "select new com.trm.model.equip.EquipSimDetail(a.id, a.equipName, a.equipType, a.serviceRange, a.proCountry,a.equipVerCode,a.equipPic1)"
                        + " from TrmEquip a where a.audStatus = 'F2' and a.isDisplay = 'Y' order by a.viewCount desc";
        
        QueryPage query = new QueryPage(hql, null, 1, 4, this.getHibernateTemplate());
        return query.getResult();
    }
    
    @SuppressWarnings("unchecked")
    public List<CateCountEquip> recentlyMoreEquip(ComIntData comIntData) throws BusinessException {
        //统计总条数  前N条
        String countSql =
                "SELECT DATE_FORMAT( a.audDate, '%Y-%m-%d' ) as date , COUNT(a.id ) as num FROM trm_equip a,trm_member b  where a.orgId = b.id and b.audStatus = 'R1' "
                        + "and a.audStatus = 'F2' and a.isDisplay = 'Y' GROUP BY DATE_FORMAT( a.audDate, '%Y-%m-%d' ) ORDER BY DATE_FORMAT( a.audDate, '%Y-%m-%d' ) desc limit :num";
        //统计设备条数  前N条
        String equipSql =
                "SELECT DATE_FORMAT( a.audDate, '%Y-%m-%d' ) as date , COUNT(a.id ) as num FROM trm_equip a,trm_member b ,sys_data_dictionary c "
                        + "where a.orgId = b.id and b.audStatus = 'R1' and a.audStatus = 'F2' and a.isDisplay = 'Y' and a.equipType = c.`code` and c.`subType`='军工大型科研仪器' "
                        + "GROUP BY DATE_FORMAT( a.audDate, '%Y-%m-%d' ),c.subType ORDER BY DATE_FORMAT( a.audDate, '%Y-%m-%d' ) desc limit :num";
        //统计设施条数  前N条
        String faciSql =
                "SELECT DATE_FORMAT( a.audDate, '%Y-%m-%d' ) as date , COUNT(a.id ) as num FROM trm_equip a,trm_member b ,sys_data_dictionary c "
                        + "where a.orgId = b.id and b.audStatus = 'R1' and a.audStatus = 'F2' and a.isDisplay = 'Y' and a.equipType = c.`code` and c.`subType`='军工试验设施' "
                        + "GROUP BY DATE_FORMAT( a.audDate, '%Y-%m-%d' ),c.subType ORDER BY DATE_FORMAT( a.audDate, '%Y-%m-%d' ) desc limit :num";
        
        List<CountEquip> countEquipList = this.currentSession().createSQLQuery(countSql)
                .addScalar("date", StandardBasicTypes.STRING).addScalar("num", StandardBasicTypes.LONG)
                .setResultTransformer(Transformers.aliasToBean(CountEquip.class))
                .setParameter("num", comIntData.getNum()).list();
        List<CountEquip> equipEquipList = this.currentSession().createSQLQuery(equipSql)
                .addScalar("date", StandardBasicTypes.STRING).addScalar("num", StandardBasicTypes.LONG)
                .setResultTransformer(Transformers.aliasToBean(CountEquip.class))
                .setParameter("num", comIntData.getNum()).list();
        List<CountEquip> faciEquipList = this.currentSession().createSQLQuery(faciSql)
                .addScalar("date", StandardBasicTypes.STRING).addScalar("num", StandardBasicTypes.LONG)
                .setResultTransformer(Transformers.aliasToBean(CountEquip.class))
                .setParameter("num", comIntData.getNum()).list();
        List<CateCountEquip> cateCountEquips = new ArrayList<>();
        for (int i = 0; i < countEquipList.size(); i++) {
            CateCountEquip cateCountEquip = new CateCountEquip();
            CountEquip countEquip = countEquipList.get(i);
            String date = countEquip.getDate();
            cateCountEquip.setDate(date);
            cateCountEquip.setNum(countEquip.getNum());
            cateCountEquip.setFaciNum(new Long(0));
            cateCountEquip.setEquipNum(new Long(0));
            Iterator<CountEquip> iterator = equipEquipList.iterator();
            Iterator<CountEquip> faciIterator = faciEquipList.iterator();
            while (iterator.hasNext()) {
                CountEquip next = iterator.next();
                if (date.equals(next.getDate())) {
                    cateCountEquip.setEquipNum(next.getNum());
                    iterator.remove();
                    break;
                }
            }
            while (faciIterator.hasNext()) {
                CountEquip next = faciIterator.next();
                if (date.equals(next.getDate())) {
                    cateCountEquip.setFaciNum(next.getNum());
                    faciIterator.remove();
                    break;
                }
            }
            cateCountEquips.add(cateCountEquip);
        }
        
        return cateCountEquips;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public CommonListResponse<HomeEquipSimDetail> findEquipByDay(EquipDayReq equipDayReq) throws BusinessException {
        //TrmMember.audStatus R0待审核，R1审核通过，R2未通过
        String hql =
                "select new com.trm.model.equip.HomeEquipSimDetail(a.id, a.equipName, a.equipPic1, a.equipPic2, a.equipPic3) "
                        + "from TrmEquip a,TrmMember b where  a.orgId = b.id and b.audStatus = 'R1' and a.audStatus = 'F2' and a.isDisplay = 'Y' and to_days( a.audDate ) = to_days( ? ) "
                        + "order by a.audDate desc";
        Object[] param = { equipDayReq.getDay() };
        
        CommonListResponse<HomeEquipSimDetail> response = new CommonListResponse<>();
        QueryPage query = new QueryPage(hql.toString(), param, 1, equipDayReq.getNum(), this.getHibernateTemplate());
        response.setPageTotal(query.getPages());
        response.setList(query.getResult());
        response.setCount(query.getCount());
        return response;
    }
    
    public boolean auditDate(AuditRequest request) {
        boolean flag = false;
        String sql = "update TrmEquip r " + " set r.audPerson = ?, " + " r.audOpinion = ?, " + " r.audDate = ?, "
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
    
    @Override
    public boolean delByEquip(Integer id) {
        String hql = "update TrmEquip set isActive = 'N' where id = ?";
        int i = this.currentSession().createQuery(hql).setParameter(0, id).executeUpdate();
        return true;
    }
    
    @Override
    public boolean batchDelEquip(String[] ids) {
        for (int i = 0; i < ids.length; i++) {
            delByEquip(new Integer(ids[i]));
        }
        return true;
    }
    
    @Override
    public boolean addViewCount(Integer id) {
        String hql = "update TrmEquip a set a.viewCount = a.viewCount + 1 where id = ? ";
        int i = this.currentSession().createQuery(hql).setParameter(0, id).executeUpdate();
        if (1 == i) {
            return true;
        }
        return false;
    }

    @Override
    public CommonListResponse<TrmEquip> findList(String startTime, String endTime) {
        String hql = "from TrmEquip where createTime > :startTime and createTime <= :endTime";
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