package com.trm.dao.evaluation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trm.dao.common.BaseDao;
import com.trm.entity.TrmEvaluation;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.evaluation.EvalEquipRequest;
import com.trm.model.evaluation.EvalEquipSimDetail;
import com.trm.model.evaluation.EvaluationRequest;
import com.trm.model.evaluation.EvaluationSimDetail;
import com.trm.util.Datetime;
import com.trm.util.ParameterUtils;
import com.trm.util.paging.QueryPage;

/**
 * 评论
 * @ClassName EvaluationDaoImpl
 * @Description 
 * @author huyuanbo
 * @Date 2017年10月20日 上午10:33:13
 * @version 1.0.0
 */
@Repository("evaluationDao")
public class EvaluationDaoImpl extends BaseDao implements EvaluationDao {

	public static Logger logger = LoggerFactory.getLogger(EvaluationDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public CommonListResponse<EvalEquipSimDetail> findMyEvals(EvalEquipRequest request) throws BusinessException {
		
		Date startDate = request.getStartDate();
		Date endDate = request.getEndDate();
		String createTime_hql = "";
		
		List<Object> list = new ArrayList<Object>();
		list.add(ParameterUtils.getLikeParam(request.getEquipName()));
		list.add(ParameterUtils.getLikeParam(request.getEvaluation()));
		
		if(startDate != null && endDate == null) {
			createTime_hql = " AND b.createTime >= ? ";
			list.add(startDate);
		}
		else if(startDate == null && endDate != null) {
			createTime_hql = " AND b.createTime <= ? ";
			list.add(Datetime.getDateAmountDays(endDate,1));
		}
		else if(startDate != null && endDate != null) {
			createTime_hql = " AND b.createTime >= ? AND b.createTime <= ? ";
			list.add(startDate);
			list.add(Datetime.getDateAmountDays(endDate,1));
		}
		
		Object[] param = list.toArray();
		
		String hql = "select new com.trm.model.evaluation.EvalEquipSimDetail(b.id, a.equipName, b.evaluation, b.createTime)"
				+ " FROM TrmEquip a, TrmEvaluation b"
				+ " WHERE a.id = b.eqpId"
				+ " AND b.regId = '" + request.getUserId() + "'"
				+ " AND a.equipName LIKE ?"
				+ " AND b.evaluation LIKE ?"
				+ createTime_hql
				+ " ORDER BY b.id desc";
		
		CommonListResponse<EvalEquipSimDetail> response = new CommonListResponse<EvalEquipSimDetail>();
		QueryPage query = new QueryPage(hql.toString(), param, request.getPageNum(), request.getNum(), this.getHibernateTemplate());
		response.setPageTotal(query.getPages());
        response.setList(query.getResult());
        response.setCount(query.getCount());
        
		return response;
	}
	
	@SuppressWarnings("unchecked")
    @Override
    public CommonListResponse<EvaluationSimDetail> findComment(EvaluationRequest request) throws BusinessException {
        String hql = "select new com.trm.model.evaluation.EvaluationSimDetail(a.id,b.username, b.nickName,b.headPortrait, a.evaluation, a.publishDate) "
                + "from TrmEvaluation a,TrmMember b "
                + "where 1=1 and a.regId = b.id and a.eqpId = ? and (a.audStatus = 'F1' or a.regId = ?) GROUP BY a.id order by a.updateTime DESC";
        Object[] param = {request.getEqpId(),request.getUserId()};
        CommonListResponse<EvaluationSimDetail> response = new CommonListResponse<EvaluationSimDetail>();
        QueryPage query = new QueryPage(hql.toString(), param, request.getPageNum(), request.getNum(), this.getHibernateTemplate());
        response.setPageTotal(query.getPages());
        response.setList(query.getResult());
        response.setCount(query.getCount());
        return response;
    }

	@Override
	public TrmEvaluation findDetailById(Integer id) throws BusinessException {
	    String hql = "from TrmEvaluation where id =:id ";
	    TrmEvaluation Detail = (TrmEvaluation) this.currentSession().createQuery(hql).setParameter("id", id).setMaxResults(1).uniqueResult();
        return Detail;
	}

}
