package com.trm.service.evaluation;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trm.constants.SystemConstants;
import com.trm.dao.common.CommonDao;
import com.trm.dao.evaluation.EvaluationDao;
import com.trm.entity.TrmEvaluation;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.common.CommonResponse;
import com.trm.model.evaluation.EvalEquipRequest;
import com.trm.model.evaluation.EvalEquipSimDetail;
import com.trm.model.evaluation.EvaluationDetail;
import com.trm.model.evaluation.EvaluationRequest;
import com.trm.model.evaluation.EvaluationSimDetail;
import com.trm.model.evaluation.RemoveReq;
import com.trm.util.BeanUtils;
import com.trm.util.CommonUtil;

/**
 * 评论
 * @ClassName EvaluationServiceImpl
 * @Description 
 * @author huyuanbo
 * @Date 2017年10月20日 上午10:01:16
 * @version 1.0.0
 */
@Service("evaluationService")
@Transactional(rollbackFor = Exception.class)
public class EvaluationServiceImpl implements EvaluationService {

    public static Logger logger = LoggerFactory.getLogger(EvaluationServiceImpl.class);

    @Autowired
    private EvaluationDao evaluationDao;

    @Autowired
    private CommonDao commonDao;
    

	@Override
	public CommonListResponse<EvalEquipSimDetail> findMyEvals(EvalEquipRequest request) throws BusinessException {
		CommonListResponse<EvalEquipSimDetail> list = evaluationDao.findMyEvals(request);
		if (list.getList().size() < 1) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("评论列表查询为空！");
            throw bs;
        }
		
		return list;
	}

    @Override
    public CommonListResponse<EvaluationSimDetail> findComment(EvaluationRequest request) throws BusinessException {
        CommonListResponse<EvaluationSimDetail> list = evaluationDao.findComment(request);
        // 信息为空时，抛出异常
        if (list.getList().size() < 1) {
            BusinessException bs = new BusinessException();
            bs.setExceptionCode(SystemConstants.REASONCODE_2048);
            bs.setExceptionMsg("评论列表查询为空！");
            throw bs;
        }
        return list;
    }

    @Override
    public CommonResponse addComments(EvaluationDetail request) throws Exception {
        CommonResponse response = new CommonResponse();

        TrmEvaluation entity = new TrmEvaluation();
        BeanUtils.copyProperties(request, entity);
        String evaluation = entity.getEvaluation();
        evaluation = CommonUtil.trim(evaluation);
        entity.setEvaluation(evaluation);
        entity.setIsActive(SystemConstants.FLAG_Y);
        entity.setAudStatus("F0");
        entity.setPublishDate(new Date());
        
        boolean isCare = false;
        isCare = commonDao.createEntity(entity);
        if (isCare) {
            response.setCodeAndMsg("0000", "评论成功！");
        } else {
            response.setCodeAndMsg("9999", "评论失败！");
        }
        return response;
    }

    @Override
    public CommonResponse removeComments(RemoveReq request) throws Exception {
        CommonResponse response = new CommonResponse();
        Integer userId = request.getRegId();
        TrmEvaluation entity = evaluationDao.findDetailById(request.getId());
        Integer regId = entity.getRegId();
        if(userId.intValue() == regId.intValue()){
            commonDao.deleteEntity(entity);
            response.setCodeAndMsg("0000", "删除成功！");
        }else{
            response.setCodeAndMsg("9999", "删除失败，不可删除非自己的评论！");
        }
        return response;
    }
    
}
