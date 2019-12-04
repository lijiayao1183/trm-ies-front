package com.trm.controller.evaluation;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.common.CommonResponse;
import com.trm.model.evaluation.EvalEquipRequest;
import com.trm.model.evaluation.EvalEquipSimDetail;
import com.trm.model.evaluation.EvaluationDetail;
import com.trm.model.evaluation.EvaluationRequest;
import com.trm.model.evaluation.EvaluationSimDetail;
import com.trm.model.evaluation.RemoveReq;
import com.trm.model.session.SessionBean;
import com.trm.service.evaluation.EvaluationService;
import com.trm.util.LoginCheckUtil;
import com.trm.util.SessionUtil;

/**
 * 评论
 * @ClassName EvaluationController
 * @Description 
 * @author huyuanbo
 * @Date 2017年10月20日 上午9:45:29
 * @version 1.0.0
 */
@Controller
@RequestMapping("/")
public class EvaluationController {

    public static Logger logger = LoggerFactory.getLogger(EvaluationController.class);

    @Autowired
    private EvaluationService evaluationService;
    
    @Autowired
    private LoginCheckUtil loginCheckUtil;
    
    /**
     * 我的评论搜索
     * @param request
     * @return
     * @throws BusinessException
     * @throws IOException 
     */
    @RequestMapping(value = "/findMyEvals", method = RequestMethod.POST)
    @ResponseBody
    public CommonListResponse<EvalEquipSimDetail> findMyEvals(@Valid @RequestBody EvalEquipRequest request, HttpServletRequest requests, HttpServletResponse response) throws BusinessException, IOException {
    	// 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(SessionUtil.getUserIdFromSession(), requests, response);
        logger.info("[我的评论]列表查询 ，入参：", request.toString());
        
        SessionBean sessionBean = SessionUtil.getSesssionBean();
        CommonListResponse<EvalEquipSimDetail> list = null;
        Integer userId;
        if(sessionBean == null) {
        	// 未登录
        	BusinessException bs = new BusinessException();
            bs.setExceptionMsg("未登录状态！");
            throw bs;
        }
        else {
        	// 已登录
        	userId = sessionBean.getId();
        	logger.info("[我的评论]列表查询 ，用户id：", userId);
        	request.setUserId(userId);
        	list = evaluationService.findMyEvals(request);
        }
        
        logger.info("[我的评论]列表查询 ，出参：", list);
        return list;
    }

    /**
     * 查询设备评论
     * @Title findCareEquips
     * @Description 
     * @param request
     * @return
     * @throws BusinessException 参数说明
     * @return CommonListResponse<CareEquipSimDetail> 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    @RequestMapping(value = "/findComment", method = RequestMethod.POST)
    @ResponseBody
    public CommonListResponse<EvaluationSimDetail> findComment(@Valid @RequestBody EvaluationRequest request) throws BusinessException {
        logger.info("[设备评论]列表查询 ，入参：", request.toString());

        SessionBean sessionBean = SessionUtil.getSesssionBean();
        CommonListResponse<EvaluationSimDetail> list = null;
        if (sessionBean == null) {
            // 未登录
            BusinessException bs = new BusinessException();
            bs.setExceptionMsg("未登录状态！");
            throw bs;
        } else {
            // 已登录
            Integer userId = sessionBean.getId();
            logger.info("[设备评论]列表查询 ，用户id：", userId);
            request.setUserId(userId);
            list = evaluationService.findComment(request);
        }

        logger.info("[设备评论]列表查询 ，出参：", list);
        return list;
    }

    /**
     * 添加评论
     * @Title careEquip
     * @Description 
     * @param requestParameter
     * @param request
     * @return
     * @throws Exception 参数说明
     * @return CommonResponse 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    @RequestMapping(value = "/addComments", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse addComments(@Valid @RequestBody EvaluationDetail requestParameter, HttpServletRequest request) throws Exception {
        logger.info("[添加设备评论] request：{}", requestParameter.toString());
        CommonResponse response = new CommonResponse();
        SessionBean sessionBean = SessionUtil.getSesssionBean();
        if (sessionBean == null) {
            response.setCodeAndMsg("E0", "用户未登录，不能评论！");
        } else {
            Integer userId = sessionBean.getId();
            requestParameter.setRegId(userId);
            response = evaluationService.addComments(requestParameter);
        }
        logger.info("[添加设备评论] return：{}", response.toString());
        return response;
    }
    
    /**
     * 删除评论
     * @Title removeComments
     * @Description 
     * @param requestParameter
     * @param request
     * @return
     * @throws Exception 参数说明
     * @return CommonResponse 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    @RequestMapping(value = "/removeComments", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse removeComments(@Valid @RequestBody RemoveReq requestParameter, HttpServletRequest request) throws Exception {
        logger.info("[删除设备评论] request：{}", requestParameter.toString());
        CommonResponse response = new CommonResponse();
        SessionBean sessionBean = SessionUtil.getSesssionBean();
        if (sessionBean == null) {
            response.setCodeAndMsg("E0", "用户未登录，不能评论！");
        } else {
            Integer userId = sessionBean.getId();
            requestParameter.setRegId(userId);
            response = evaluationService.removeComments(requestParameter);
        }
        logger.info("[删除设备评论] return：{}", response.toString());
        return response;
    }
    
}
