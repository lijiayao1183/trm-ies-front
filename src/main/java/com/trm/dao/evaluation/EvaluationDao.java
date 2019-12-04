package com.trm.dao.evaluation;

import com.trm.entity.TrmEvaluation;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.evaluation.EvalEquipRequest;
import com.trm.model.evaluation.EvalEquipSimDetail;
import com.trm.model.evaluation.EvaluationRequest;
import com.trm.model.evaluation.EvaluationSimDetail;

/**
 * 评论
 * @ClassName EvaluationDao
 * @Description 
 * @author huyuanbo
 * @Date 2017年10月20日 上午10:33:03
 * @version 1.0.0
 */
public interface EvaluationDao {
	
	/**
	 * add by zhaosimiao 2017-11-2 12:56:01
	 * 我的评论搜索
	 * @param request
	 * @return
	 * @throws BusinessException
	 */
	public CommonListResponse<EvalEquipSimDetail> findMyEvals(EvalEquipRequest request) throws BusinessException;
	
    public CommonListResponse<EvaluationSimDetail> findComment(EvaluationRequest request) throws BusinessException;
	
    public TrmEvaluation findDetailById(Integer id) throws BusinessException;
}
