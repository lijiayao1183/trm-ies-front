package com.trm.controller.msg;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trm.constants.SystemConstants;
import com.trm.entity.business.CommonResponse;
import com.trm.entity.exception.BusinessException;
import com.trm.model.common.CommonListResponse;
import com.trm.model.common.FindDetailsById;
import com.trm.model.msg.MyMsgDetail;
import com.trm.model.msg.MyMsgRequest;
import com.trm.service.msg.MyMsgService;
import com.trm.util.LoginCheckUtil;
import com.trm.util.SessionUtil;

/**
 * 我的消息
 * @ClassName MyMsgController
 * @Description 
 * @author huyuanbo
 * @Date 2017年10月16日 下午1:33:55
 * @version 1.0.0
 */
@Controller
@RequestMapping("/mymsg/info")
public class MyMsgController {

    public static Logger logger = LoggerFactory.getLogger(MyMsgController.class);
    
    @Autowired
    private MyMsgService myMsgService;

    @Value("#{filePath.domain}")
    private String domain;

    /**
     * 富文本图片保存数据库时需要的--前缀
     */
    //@Value("#{filePath.db_rich_text_img_prefix}")
    //private String RichTextImgPrefix;

    /** 虚拟路径 */
    @Value("#{filePath.virtual_path}")
    private String virtualPath;
    /** 物理路径 */
    @Value("#{filePath.physical_path}")
    private String physicalPath;
    
    @Autowired
    private LoginCheckUtil loginCheckUtil;
    
    /**
     * 1.查询全部
     * 
     * @param requestParameter.pageNum
     *            当前页码
     * @param requestParameter.num
     *            每页数量
     * @param requestParameter.title
     *            标题
     * @return
     * @throws BusinessException
     * @throws IOException 
     */
    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    @ResponseBody
    public CommonListResponse<MyMsgDetail> homeFindAll(@RequestBody MyMsgRequest requestParameter, HttpServletRequest request, HttpServletResponse response) throws BusinessException, IOException {
    	// 检测用户是否登录或被冻结
        loginCheckUtil.checkLoginStatus(SessionUtil.getUserIdFromSession(), request, response);
        logger.info("[我的消息列表]列表查询 request：{}", requestParameter);
        CommonListResponse<MyMsgDetail> list = myMsgService.findAll(requestParameter);
        logger.info("[我的消息列表]列表查询 return：{}", list);
        return list;
    }

    /**
     * 2.按id查询详情
     * 
     * @param request
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/findDetailById", method = RequestMethod.POST)
    @ResponseBody
    public MyMsgDetail findDetailById(@Valid @RequestBody FindDetailsById requestParameter) throws BusinessException {
        logger.info("[我的消息详情]查询id为 {}", requestParameter.getId());
        MyMsgDetail info = myMsgService.findDetailById(requestParameter.getId());
        logger.info("[我的消息详情]查询 return：{}", info);
        return info;
    }
    /**
     * 删除我的消息
     * @Title deleteById
     * @Description 
     * @param request
     * @return
     * @throws Exception 参数说明
     * @return CommonResponse 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse deleteById(@RequestBody Map<String, String> request) throws Exception {
        String id = request.get("id");
        logger.info("[删除我的消息]request id为 {}", id);
        boolean flag = myMsgService.deleteById(id);
        CommonResponse response = new CommonResponse();
        if (flag) {
            response.setMessage(SystemConstants.TRM_SUCCESS);
        } else {
            response.setMessage(SystemConstants.TRM_ERROR);
        }
        logger.info("[删除我的消息] return：{}", response);
        return response;
    }
    /**
     * 标记为已读一条或多条
     * @Title deleteById
     * @Description 
     * @param request
     * @return
     * @throws Exception 参数说明
     * @return CommonResponse 返回类型
     * @throws
     * @see
     * @author huyuanbo
     */
    @RequestMapping(value = "/updateById", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse updateById(@RequestBody Map<String, String> request) throws Exception {
        String id = request.get("id");
        logger.info("[标记为已读]request id为 {}", id);
        boolean flag = myMsgService.updateById(id);
        CommonResponse response = new CommonResponse();
        if (flag) {
            response.setMessage(SystemConstants.TRM_SUCCESS);
        } else {
            response.setMessage(SystemConstants.TRM_ERROR);
        }
        logger.info("[标记为已读] return：{}", response);
        return response;
    }
}
