package com.trm.dao.techservorg;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.trm.entity.TrmDemand;
import com.trm.entity.TrmEquip;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trm.dao.common.BaseDao;
import com.trm.entity.TrmOrgMaterial;
import com.trm.entity.TrmTechServOrg;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.AuditRequest;
import com.trm.model.common.ComIntData;
import com.trm.model.common.CommonListResponse;
import com.trm.model.equip.CateCountEquip;
import com.trm.model.equip.CountEquip;
import com.trm.model.equip.EquipDayReq;
import com.trm.model.techservorg.HomePageOrg;
import com.trm.model.techservorg.TechServOrgCenterDetail;
import com.trm.model.techservorg.TechServOrgHomeDetail;
import com.trm.model.techservorg.TechServOrgReq;
import com.trm.model.techservorg.TechServOrgSimDetail;
import com.trm.util.Datetime;
import com.trm.util.ParameterUtils;
import com.trm.util.paging.QueryPage;

/**
 * 技术服务机构
 * @author zhaosimiao 2018-2-24 14:36:36
 */
@Repository("techServOrgDao")
public class TechServOrgDaoImpl extends BaseDao implements TechServOrgDao {

	public static Logger logger = LoggerFactory.getLogger(TechServOrgDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public HomePageOrg<TechServOrgHomeDetail> homeFindAll(TechServOrgReq requestParameter)
			throws BusinessException {
		String servType = requestParameter.getServType();
		String servTypeHql = "";
		if("1".equals(servType)) {
			servTypeHql = " and (a.servType like '%技术%' or a.servType like '%需求%' or a.servType like '%对接%')";
		}
		else if("2".equals(servType)) {
			servTypeHql = " and (a.servType like '%评估%')";
		}
		else if("3".equals(servType)) {
			servTypeHql = " and (a.servType like '%孵化器%')";
		}
		else if("4".equals(servType)) {
			servTypeHql = " and (a.servType like '%投融资%' or a.servType like '%投资%' or a.servType like '%融资%')";
		}
		else if("5".equals(servType)) {
			servTypeHql = " and (a.servType like '%管理%' or a.servType like '%咨询%')";
		}
		
		String hql = "select new com.trm.model.techservorg.TechServOrgHomeDetail(a.id, a.orgName) "
	            + " from TrmTechServOrg a, TrmMember b where a.userId = b.id and b.audStatus = 'R1' and a.audStatus = 'F2'"
				+ servTypeHql
	    		+ " order by a.audDate desc";
		HomePageOrg<TechServOrgHomeDetail> response = new HomePageOrg<TechServOrgHomeDetail>();
        QueryPage query = new QueryPage(hql.toString(), null, requestParameter.getPageNum(), requestParameter.getNum(), this.getHibernateTemplate());
        response.setPageTotal(query.getPages());
        response.setList(query.getResult());
        response.setCount(query.getCount());
        
        String orgNumHql = "select count(a.id) from TrmTechServOrg a, TrmMember b"
        		+ " where a.userId = b.id and b.audStatus = 'R1' and a.audStatus = 'F2'";
        Long orgNum = (Long) this.currentSession().createQuery(orgNumHql).uniqueResult();
        String orgNum1Hql = "select count(a.id) from TrmTechServOrg a, TrmMember b"
        		+ " where a.userId = b.id and b.audStatus = 'R1' and a.audStatus = 'F2'"
        		+ " and (a.servType like '%技术%' or a.servType like '%需求%' or a.servType like '%对接%')";
        Long orgNum1 = (Long) this.currentSession().createQuery(orgNum1Hql).uniqueResult();
        String orgNum2Hql = "select count(a.id) from TrmTechServOrg a, TrmMember b"
        		+ " where a.userId = b.id and b.audStatus = 'R1' and a.audStatus = 'F2'"
        		+ " and (a.servType like '%评估%')";
        Long orgNum2 = (Long) this.currentSession().createQuery(orgNum2Hql).uniqueResult();
        String orgNum3Hql = "select count(a.id) from TrmTechServOrg a, TrmMember b"
        		+ " where a.userId = b.id and b.audStatus = 'R1' and a.audStatus = 'F2'"
        		+ " and (a.servType like '%孵化器%')";
        Long orgNum3 = (Long) this.currentSession().createQuery(orgNum3Hql).uniqueResult();
        String orgNum4Hql = "select count(a.id) from TrmTechServOrg a, TrmMember b"
        		+ " where a.userId = b.id and b.audStatus = 'R1' and a.audStatus = 'F2'"
        		+ " and (a.servType like '%投融资%' or a.servType like '%投资%' or a.servType like '%融资%')";
        Long orgNum4 = (Long) this.currentSession().createQuery(orgNum4Hql).uniqueResult();
        String orgNum5Hql = "select count(a.id) from TrmTechServOrg a, TrmMember b"
        		+ " where a.userId = b.id and b.audStatus = 'R1' and a.audStatus = 'F2'"
        		+ " and (a.servType like '%管理%' or a.servType like '%咨询%')";
        Long orgNum5 = (Long) this.currentSession().createQuery(orgNum5Hql).uniqueResult();
        response.setOrgNum(orgNum);
        response.setOrgNum1(orgNum1);
        response.setOrgNum2(orgNum2);
        response.setOrgNum3(orgNum3);
        response.setOrgNum4(orgNum4);
        response.setOrgNum5(orgNum5);
        return response;
	}
	
	@SuppressWarnings("unchecked")
    @Override
	public CommonListResponse<TechServOrgCenterDetail> personalCenterFindAll(TechServOrgReq requestParameter)throws BusinessException {
		List<Object> list = new ArrayList<Object>();
		
		String department = requestParameter.getDepartment();
		String departmentHql = "";
		String handler = requestParameter.getHandler();
		String handlerHql = "";
		if(StringUtils.isNotEmpty(department)) {
			departmentHql = " and b.department = ?";
			list.add(ParameterUtils.getEqualParam(department));
		}
		if(StringUtils.isNotEmpty(handler)) {
			handlerHql = " and b.username = ?";
			list.add(ParameterUtils.getEqualParam(handler));
		}
		// 审核时间开始时间-结束时间
		String audDateHql = "";
		Date audStartDate = requestParameter.getAudStartDate();
		Date audEndDate = requestParameter.getAudEndDate();
		if(audStartDate != null && audEndDate == null) {
			list.add(audStartDate);
			audDateHql = " and a.audDate >= ?";
		}
		else if(audStartDate == null && audEndDate != null) {
			list.add(Datetime.getDateAmountDays(audEndDate,1));
			audDateHql = " and a.audDate <= ?";
		}
		else if(audStartDate != null && audEndDate != null) {
			list.add(audStartDate);
			list.add(Datetime.getDateAmountDays(audEndDate,1));
			audDateHql = " and (a.audDate >= ? and a.audDate <= ?)";
		}
		
	    String hql = "select new com.trm.model.techservorg.TechServOrgCenterDetail(a.id, "
	    		+ " b.department, (select m.username from TrmMember m where m.id = a.userId) as handler, "
	    		+ " a.orgName, a.servType, a.property, a.attribute, a.audDate, a.audStatus, b.userType) "
	            + " from TrmTechServOrg a,TrmMember b "
	            + " where 1=1 and a.userId = b.id"
	    		+ departmentHql
	    		+ handlerHql
	    		+ audDateHql
	    		+ " and (a.userId = ? or b.masterId = ?)"
	    		+ " and a.orgName like ? "
	    		+ " and a.servType like ? "
	    		+ " and a.property like ? "
	    		+ " and a.attribute like ? "
	    		+ " and a.audStatus like ?"
	    		+ " order by a.updateTime desc";
	    Integer userId = requestParameter.getUserId();
		list.add(userId);
		list.add(userId);
	    list.add(ParameterUtils.getLikeParam(requestParameter.getOrgName()));
	    list.add(ParameterUtils.getLikeParam(requestParameter.getServType()));
	    list.add(ParameterUtils.getLikeParam(requestParameter.getProperty()));
	    list.add(ParameterUtils.getLikeParam(requestParameter.getAttribute()));
	    list.add(ParameterUtils.getLikeParam(requestParameter.getAudStatus()));
        Object[] param = list.toArray();

        CommonListResponse<TechServOrgCenterDetail> response = new CommonListResponse<TechServOrgCenterDetail>();
        QueryPage query = new QueryPage(hql.toString(), param, requestParameter.getPageNum(), requestParameter.getNum(), this.getHibernateTemplate());
        response.setPageTotal(query.getPages());
        response.setList(query.getResult());
        response.setCount(query.getCount());
        return response;
	}
	
	@Override
    public TrmTechServOrg personalCenterFindDetail(TechServOrgReq requestParameter) throws BusinessException {
        String hql = "from TrmTechServOrg where id =:id and userId =:userId";
        TrmTechServOrg entity = (TrmTechServOrg) this.currentSession().createQuery(hql)
        		.setParameter("id", requestParameter.getId())
        		.setParameter("userId", requestParameter.getUserId())
        		.uniqueResult();
        return entity;
    }
	
	@SuppressWarnings("unchecked")
    @Override
	public CommonListResponse<TechServOrgSimDetail> findAll(TechServOrgReq requestParameter)throws BusinessException {
	    List<Object> list = new ArrayList<Object>();
	    
	    String keyword = requestParameter.getKeyword();
        
	    String hql = "select new com.trm.model.techservorg.TechServOrgSimDetail(a.id, a.orgName, a.servType, a.property, a.attribute, a.createTime) "
	            + " from TrmTechServOrg a, TrmMember b where a.userId = b.id and b.audStatus = 'R1' and a.audStatus = 'F2'"
	    		+ " and (a.orgName like ? "
	    		+ " or a.servType like ? "
	    		+ " or a.property like ? "
	    		+ " or a.attribute like ?) "
	    		+ " order by a.audDate desc";
	    list.add(ParameterUtils.getLikeParam(keyword));
	    list.add(ParameterUtils.getLikeParam(keyword));
	    list.add(ParameterUtils.getLikeParam(keyword));
	    list.add(ParameterUtils.getLikeParam(keyword));
        Object[] param = list.toArray();

        CommonListResponse<TechServOrgSimDetail> response = new CommonListResponse<TechServOrgSimDetail>();
        QueryPage query = new QueryPage(hql.toString(), param, requestParameter.getPageNum(), requestParameter.getNum(), this.getHibernateTemplate());
        response.setPageTotal(query.getPages());
        response.setList(query.getResult());
        response.setCount(query.getCount());
        return response;
	}
	
    @Override
    public TrmTechServOrg findDetailById(Integer id) throws BusinessException {
        String hql = "from TrmTechServOrg where id =:id ";
        TrmTechServOrg entity = (TrmTechServOrg) this.currentSession().createQuery(hql).setParameter("id", id).uniqueResult();
        return entity;
    }
    
    @Override
    public TrmTechServOrg findDetailByName(String name) throws BusinessException {
        String hql = "from TrmTechServOrg where orgName =:name ";
        TrmTechServOrg entity = (TrmTechServOrg) this.currentSession().createQuery(hql).setParameter("name", name).uniqueResult();
        return entity;
    }

	@Override
	public boolean auditTechServOrg(AuditRequest request) {
		boolean flag = false;
        String sql = "update TrmTechServOrg r "
        		+ " set r.audPerson = ?, "
        		+ " r.audOpinion = ?, "
        		+ " r.audDate = ?, "
        		+ " r.audStatus = ? "
        		+ " where r.id = ?";
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
        		.setParameter(4, request.getAuditId())
        		.executeUpdate();
        if (count == 1) {
            flag = true;
        }
        return flag;
	}
	
	@SuppressWarnings("unchecked")
	public List<CateCountEquip> recentlyMoreOrg(ComIntData comIntData) throws BusinessException {
        //统计总条数  前N条
        String countSql =
                "SELECT DATE_FORMAT( a.audDate, '%Y-%m-%d' ) as date , COUNT(a.id ) as num FROM trm_tech_serv_org a,trm_member b "
                		+ " where a.userId = b.id and b.audStatus = 'R1' "
                        + " and a.audStatus = 'F2' GROUP BY DATE_FORMAT( a.audDate, '%Y-%m-%d' ) ORDER BY DATE_FORMAT( a.audDate, '%Y-%m-%d' ) desc limit :num";
        List<CountEquip> countEquipList = this.currentSession().createSQLQuery(countSql)
                .addScalar("date", StandardBasicTypes.STRING).addScalar("num", StandardBasicTypes.LONG)
                .setResultTransformer(Transformers.aliasToBean(CountEquip.class))
                .setParameter("num", comIntData.getNum()).list();
        List<CateCountEquip> cateCountEquips = new ArrayList<CateCountEquip>();
        for (int i = 0; i < countEquipList.size(); i++) {
            CateCountEquip cateCountEquip = new CateCountEquip();
            CountEquip countEquip = countEquipList.get(i);
            String date = countEquip.getDate();
            cateCountEquip.setDate(date);
            cateCountEquip.setNum(countEquip.getNum());
            cateCountEquips.add(cateCountEquip);
        }
        
        return cateCountEquips;
    }
	
	@SuppressWarnings("unchecked")
	@Override
    public CommonListResponse<TechServOrgSimDetail> findOrgByDay(EquipDayReq equipDayReq) throws BusinessException {
        //TrmMember.audStatus R0待审核，R1审核通过，R2未通过
        String hql =
                "select new com.trm.model.techservorg.TechServOrgSimDetail(a.id, a.orgName, a.servType, a.property, a.attribute, a.createTime, a.audDate) "
                        + " from TrmTechServOrg a,TrmMember b "
                        + " where  a.userId = b.id and b.audStatus = 'R1' and a.audStatus = 'F2' "
                        + " and to_days( a.audDate ) = to_days( ? )"
                        + " order by a.audDate desc";
        Object[] param = { equipDayReq.getDay() };
        
        CommonListResponse<TechServOrgSimDetail> response = new CommonListResponse<TechServOrgSimDetail>();
        QueryPage query = new QueryPage(hql.toString(), param, 1, equipDayReq.getNum(), this.getHibernateTemplate());
        response.setPageTotal(query.getPages());
        response.setList(query.getResult());
        response.setCount(query.getCount());
        return response;
    }
	
	@Override
	public TrmOrgMaterial findOrgMaterialById(Integer id) throws BusinessException {
		String hql = " from TrmOrgMaterial a where a.id = ? ";
		TrmOrgMaterial detail = (TrmOrgMaterial) this.currentSession().createQuery(hql).setParameter(0, id).uniqueResult();
		return detail;
	}
	
	@Override
	public List<TrmOrgMaterial> findOrgMaterialList(Integer orgId) throws BusinessException {
		String hql = " from TrmOrgMaterial a where a.orgId = ? ";
		@SuppressWarnings("unchecked")
		List<TrmOrgMaterial> list = (List<TrmOrgMaterial>) this.currentSession().createQuery(hql).setParameter(0, orgId).list();
		return list;
	}
	
	@Override
	public Integer createOrgMaterial(TrmOrgMaterial entity) throws BusinessException {
		// 自动生成方法存根
		try {
			this.getHibernateTemplate().save(entity);
			return entity.getId();
		} catch (Exception e) {
			logger.error("新增技术服务机构随附材料报错!" + e.getMessage());
			throw e;
		}
	}

	@Override
	public boolean deleteOrgMaterialByOrgId(Integer orgId) throws Exception {
		boolean flag = false;
		String hql = "update TrmOrgMaterial a set a.isActive = 'N' where a.orgId = ? ";
		int a = this.currentSession().createQuery(hql).setParameter(0, orgId).executeUpdate();
		if(a > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public CommonListResponse<TrmTechServOrg> findList(String startTime, String endTime) {
		String hql = "from TrmTechServOrg where createTime > :startTime and createTime <= :endTime";
		Query query = currentSession().createQuery(hql);
		query.setString("startTime", startTime);
		query.setString("endTime", endTime);
		List<TrmTechServOrg> list = query.list();
		CommonListResponse response = new CommonListResponse();
		response.setCount(list.size());
		response.setList(list);
		return response;
	}
}
