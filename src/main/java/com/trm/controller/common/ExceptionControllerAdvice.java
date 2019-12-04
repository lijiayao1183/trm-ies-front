package com.trm.controller.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trm.constants.ExceptionConstants;
import com.trm.constants.SystemConstants;
import com.trm.entity.exception.BindingExcepObj;
import com.trm.entity.exception.BusinessException;
import com.trm.entity.exception.BusinessException_Exception_C;
import com.trm.entity.exception.ExceptionResponse;
import com.trm.entity.exception.Reason;
import com.trm.entity.exception.WebAuthException;

/**
 * 异常处理类
 * @author zhaosimiao 2017-5-9 15:42:36
 */
@ControllerAdvice
public class ExceptionControllerAdvice {
	
	public static Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

	/**
	 * 处理自定义的业务异常
	 * @param e 业务异常
	 * @return
	 */
	@ExceptionHandler(BusinessException_Exception_C.class)
	public @ResponseBody ExceptionResponse businessException_Exception_CHandle(BusinessException_Exception_C e) {
		
		ExceptionResponse response = new ExceptionResponse();
		response.setExplain(ExceptionConstants.EXPLAIN_ERR_6);
		response.setResponsecode(ExceptionConstants.OTHER_SYS_ERR);
		response.setErrorType(ExceptionConstants.ERR_TYPE_0);
		
		Reason reason = new Reason();
		BusinessException busiExcp = e.getFaultInfo();
		reason.setDesc(busiExcp.getExceptionMsg());
		reason.setReasoncode(busiExcp.getExceptionCode());
		response.setReason(reason);
		
		response.setExplain(ExceptionConstants.EXPLAIN_ERR_0);
		
		// 将具体报错信息写入日志
		e.printStackTrace();
		return response;
	}
	
	/**
	 * 处理自定义的业务异常
	 * @param e 业务异常
	 * @return
	 */
	@ExceptionHandler(BusinessException.class)
	public @ResponseBody ExceptionResponse businessExceptionHandle(BusinessException e) {
		
		ExceptionResponse response = new ExceptionResponse();
		response.setResponsecode(ExceptionConstants.BUSI_ERR_9999);
		response.setErrorType(ExceptionConstants.ERR_TYPE_0);
		
		Reason reason = new Reason();
		reason.setDesc(e.getExceptionMsg());
		reason.setReasoncode(e.getExceptionCode());
		response.setReason(reason);
		
		response.setExplain(ExceptionConstants.EXPLAIN_ERR_1);
		
		// 将具体报错信息写入日志
		e.printStackTrace();
		return response;
	}
	
	/**
	 * 处理自定义的业务异常
	 * @param e 业务异常
	 * @return
	 */
	@ExceptionHandler(WebAuthException.class)
	public @ResponseBody ExceptionResponse webAuthExceptionHandle(WebAuthException e) {
		ExceptionResponse resp = new ExceptionResponse();
		resp.setResponsecode(ExceptionConstants.BUSI_ERR_9999);
		resp.setErrorType(SystemConstants.ERROR_TYPE_2);
		Reason reason = new Reason();
		reason.setDesc(e.getDesc());
		reason.setReasoncode(e.getReasoncode());
		resp.setReason(reason);
		return resp;
	}

	/**
	 * 处理Spring框架异常
	 * </p>从前台到后台传递数据中如果包括日期类型的话，一般会抛此异常
	 * @param e 传参异常
	 * @return
	 */
	@ExceptionHandler(BindException.class)
	public @ResponseBody ExceptionResponse bindExceptionHandle(BindException e) {
		
		// 用e.getFieldErrors()获取与字段相关联的所有错误
		List<FieldError> errorList = e.getFieldErrors();
		
		ExceptionResponse resp = new ExceptionResponse();
		BindingExcepObj excepObj = null;

		for (FieldError error : errorList) {
			excepObj = new BindingExcepObj();
			excepObj.setFieldName(error.getField());
			excepObj.setMessage(error.getDefaultMessage());
			resp.getFiledErrorList().add(excepObj);
		}
		resp.setResponsecode(ExceptionConstants.SPRING_ERR_0001);
		resp.setErrorType(ExceptionConstants.ERR_TYPE_1);
		
		resp.setExplain(ExceptionConstants.EXPLAIN_ERR_2);
		
		// 将具体报错信息写入日志
		e.printStackTrace();
		return resp;
	}
	
	/**
	 * 处理Spring框架异常
	 * </p>方法参数无效异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public @ResponseBody ExceptionResponse JsonBindExceptionHandle(MethodArgumentNotValidException e) {
		
		BindingResult br = e.getBindingResult();
		List<FieldError> errorList = br.getFieldErrors();
		ExceptionResponse resp = new ExceptionResponse();
		BindingExcepObj excepObj = null;
		for (FieldError error : errorList) {
			excepObj = new BindingExcepObj();
			excepObj.setFieldName(error.getField());
			excepObj.setMessage(error.getDefaultMessage());
			resp.getFiledErrorList().add(excepObj);
		}
		resp.setResponsecode(ExceptionConstants.SPRING_ERR_0002);
		resp.setErrorType(ExceptionConstants.ERR_TYPE_2);
		
		resp.setExplain(ExceptionConstants.EXPLAIN_ERR_3);
		
		// 将具体报错信息打在日志中
		e.printStackTrace();
		return resp;
	}

	/**
	 * 处理Java系统异常
	 * </p>运行时错误
	 * @param e
	 * @return
	 */
	@ExceptionHandler(RuntimeException.class)
	public @ResponseBody ExceptionResponse technicalExceptionHandle(RuntimeException e) {

		ExceptionResponse response = new ExceptionResponse();
		response.setResponsecode(ExceptionConstants.JAVA_RUNTIME_ERR);
		response.setErrorType(ExceptionConstants.ERR_TYPE_0);
		Reason reason = new Reason();
		reason.setReasoncode(ExceptionConstants.JAVA_RUNTIME_ERR);
		reason.setDesc(e.getMessage());
		response.setReason(reason);
		
		response.setExplain(ExceptionConstants.EXPLAIN_ERR_4);
		
		// 将具体报错信息写入日志
		e.printStackTrace();
		return response;
	}

	/**
	 * 处理SQL异常
	 * @param request
	 * @param e
	 * @return
	 */
	@ExceptionHandler(SQLException.class)
	public String exceptionHandle(SQLException e) {
		
		ExceptionResponse response = new ExceptionResponse();
		Reason reason = new Reason();
		reason.setReasoncode(ExceptionConstants.SQL_ERR);
		reason.setDesc(e.getMessage());
		List<BindingExcepObj> filedErrorList = new ArrayList<BindingExcepObj>();
		
		response.setExplain(ExceptionConstants.EXPLAIN_ERR_5);
		response.setResponsecode(ExceptionConstants.SQL_ERR);
		response.setErrorType(ExceptionConstants.ERR_TYPE_0);
		response.setReason(reason);
		response.setFiledErrorList(filedErrorList);
		
		// 将具体报错信息写入日志
		e.printStackTrace();
		return "error";
	}
	
	/**
	 * 处理其他未识别的系统异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public @ResponseBody ExceptionResponse exceptionHandle(Exception e) {
		
		ExceptionResponse response = new ExceptionResponse();
		response.setExplain(ExceptionConstants.EXPLAIN_ERR_6);
		response.setResponsecode(ExceptionConstants.OTHER_SYS_ERR);
		response.setErrorType(ExceptionConstants.ERR_TYPE_0);
		Reason reason = new Reason();
		reason.setReasoncode(ExceptionConstants.OTHER_SYS_ERR);
		reason.setDesc(e.getMessage());
		response.setReason(reason);
		
		// 将具体报错信息写入日志
		e.printStackTrace();
		return response;
	}
}
