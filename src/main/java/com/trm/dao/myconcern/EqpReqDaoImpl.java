package com.trm.dao.myconcern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trm.dao.common.BaseDao;
import com.trm.entity.TrmEqpReq;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.myconcern.CareEquipRequest;
import com.trm.model.myconcern.CareEquipSimDetail;
import com.trm.model.myconcern.CareEquipStatus;
import com.trm.util.ParameterUtils;
import com.trm.util.paging.QueryPage;

/**
 * 我的关注模块
 * @author zhaosimiao 2017年10月17日 14:33:36
 */
@Repository("eqpReqDao")
public class EqpReqDaoImpl extends BaseDao implements EqpReqDao {

	public static Logger logger = LoggerFactory.getLogger(EqpReqDaoImpl.class);

	@SuppressWarnings("unchecked")
    @Override
    public CommonListResponse<CareEquipSimDetail> findCareEquips(CareEquipRequest request) throws BusinessException {
        // 用户审核状态  R0待审核，R1审核通过，R2未通过
		Integer userId = request.getUserId();
		String equipName = request.getEquipName();
		String orgName = request.getOrgName();
		String equipType = request.getEquipType();
		String serviceRange = request.getServiceRange();
		
		String userId_hql = request.getUserId() == null ? " " : " and b.orgId = '" + userId + "'";
		
        String hql = "select new com.trm.model.myconcern.CareEquipSimDetail(a.orgId as userId, a.id as eqpId, a.equipName, a.linkUnit as orgName, a.equipType, a.serviceRange, a.audStatus, a.isDisplay) "
                + "from TrmEquip a,TrmEqpReq b "
                + "where a.id = b.eqpId "
                + userId_hql
                + " and a.equipName like ? "
                + " and a.equipType like ? "
                + " and a.serviceRange like ? "
                + " and a.linkUnit like ? "
                + " and b.focusStatus = 'Y' "
                + " and b.regId = '0' "
                + " order by b.id desc";
        
        Object[] param = ParameterUtils.getLikeParams(equipName,equipType,serviceRange,orgName);

        CommonListResponse<CareEquipSimDetail> response = new CommonListResponse<CareEquipSimDetail>();
        QueryPage query = new QueryPage(hql.toString(), param, request.getPageNum(), request.getNum(), this.getHibernateTemplate());
        response.setPageTotal(query.getPages());
        response.setList(query.getResult());
        response.setCount(query.getCount());
        return response;
    }
	
	@Override
	public TrmEqpReq checkCareRecord(Integer orgId, Integer eqpId, Integer regId) {
		String hql = "from TrmEqpReq where orgId=:orgId and eqpId=:eqpId and regId=:regId";
		
		TrmEqpReq entity = (TrmEqpReq) this.currentSession().createQuery(hql)
				.setParameter("eqpId", eqpId)
				.setParameter("orgId", orgId)
				.setParameter("regId", regId).uniqueResult();
        return entity;
	}
	
	@Override
	public TrmEqpReq checkCareEquip(Integer orgId, Integer eqpId, Integer regId) {
		String hql = "from TrmEqpReq where orgId=:orgId and eqpId=:eqpId and regId=:regId and focusStatus = 'Y' ";
		
		TrmEqpReq entity = (TrmEqpReq) this.currentSession().createQuery(hql)
				.setParameter("eqpId", eqpId)
				.setParameter("orgId", orgId)
				.setParameter("regId", regId).uniqueResult();
        return entity;
	}

	@Override
	public boolean updateCareEquip(CareEquipStatus request) {
		boolean flag = false;
		String sql = "update TrmEqpReq a set a.focusStatus = ? where a.orgId = ? and a.eqpId = ? and regId = '0' ";
		int a = this.currentSession().createQuery(sql)
						.setParameter(0, request.getFocusStatus())
						.setParameter(1, request.getOrgId())
						.setParameter(2, request.getEqpId())
						.executeUpdate();
		if(a == 1){
			flag = true;
		}
		return flag;
	}
}
