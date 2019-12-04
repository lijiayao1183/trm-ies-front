package com.trm.service.evaluation;

import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.common.CommonResponse;
import com.trm.model.evaluation.EvalEquipRequest;
import com.trm.model.evaluation.EvalEquipSimDetail;
import com.trm.model.evaluation.EvaluationDetail;
import com.trm.model.evaluation.EvaluationRequest;
import com.trm.model.evaluation.EvaluationSimDetail;
import com.trm.model.evaluation.RemoveReq;

/**
 * 评论
 * @ClassName EvaluationService
 * @Description 
 * @author huyuanbo
 * @Date 2017年10月20日 上午10:01:04
 * @version 1.0.0
 */
public interface EvaluationService {
	
	/**
	 * 我的评论搜索 add by zhaosimiao 2017-11-2 12:53:36
	 * @param request
	 * @return
	 * @throws BusinessException
	 */
	public CommonListResponse<EvalEquipSimDetail> findMyEvals(EvalEquipRequest request) throws BusinessException;
   
    public CommonListResponse<EvaluationSimDetail> findComment(EvaluationRequest request) throws BusinessException;

    public CommonResponse addComments(EvaluationDetail request)throws Exception;
    
    public CommonResponse removeComments(RemoveReq request)throws Exception;
    
}
