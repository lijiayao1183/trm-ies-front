package com.trm.trmserver.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.trm.entity.exception.BindingExcepObj;
import com.trm.entity.exception.ExceptionResponse;
import com.trm.entity.exception.Reason;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ApiLoginInterceptor extends HandlerInterceptorAdapter {

	public static Logger logger = LoggerFactory.getLogger(ApiLoginInterceptor.class);
	public static final String SYNC_md5 = "cf4107f7ba8406abd309a02da3e8c10c2809c971321068f4bb0231fc29b98f7f";
	public static final String RESPONSECOE_008 = "008";
	public final static String ERROR_TYPE_1 ="1";//表示校验类型的错误
	public final static String ERROR_TYPE_2 ="2";//表示权限不够的错误
	public static final String MGT_USER_NOT_LOGIN = "3002"; // 后端用户未登陆

	private String getBody(HttpServletRequest request) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;
		try {
			InputStream inputStream = request.getInputStream();
			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
					throw ex;
				}
			}
		}
		return stringBuilder.toString();
	}

	/**
	 * preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用。
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String jstring = getBody(request);
		JSONObject myJsonObject = JSONObject.parseObject(jstring);
		Object username = myJsonObject.get("name");
		Object password = myJsonObject.get("paswd");
		Object startDate = myJsonObject.get("startDate");
		Object endDate = myJsonObject.get("endDate");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		OutputStream out = response.getOutputStream();
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(out, "utf-8"));
		ExceptionResponse eResponse = new ExceptionResponse();
		// BindingExcepObj bindingExcepObj=new BindingExcepObj();
		Reason reason = new Reason();
		List<BindingExcepObj> list = new ArrayList<BindingExcepObj>();
		// 参数验证
		
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)|| StringUtils.isEmpty(startDate) || StringUtils.isEmpty(endDate)) {
			if (StringUtils.isEmpty(username)) {
				BindingExcepObj bindingExcepObj = new BindingExcepObj();
				bindingExcepObj.setFieldName("name");
				bindingExcepObj.setMessage("用户名不能为空！");
				list.add(bindingExcepObj);
			}

			if (StringUtils.isEmpty(password)) {
				BindingExcepObj bindingExcepObj = new BindingExcepObj();
				bindingExcepObj.setFieldName("password");
				bindingExcepObj.setMessage("密码不能为空！");
				list.add(bindingExcepObj);
			}
			if (StringUtils.isEmpty(startDate)) {
				BindingExcepObj bindingExcepObj = new BindingExcepObj();
				bindingExcepObj.setFieldName("startDate");
				bindingExcepObj.setMessage("开始时间不能为空！");
				list.add(bindingExcepObj);
			}
			if (StringUtils.isEmpty(endDate)) {
				BindingExcepObj bindingExcepObj = new BindingExcepObj();
				bindingExcepObj.setFieldName("endDate");
				bindingExcepObj.setMessage("结束时间不能为空！");
				list.add(bindingExcepObj);
			}
			eResponse.setResponsecode(RESPONSECOE_008);
			eResponse.setErrorType(ERROR_TYPE_1);
			eResponse.setFiledErrorList(list);

			pw.println(JSON.toJSONString(eResponse));
			pw.flush();
			pw.close();
			return false;
		}

		String name = username.toString();
		String paswd = password.toString();
		// 没有用户信息StringHelper.isEmpty(username) ||
		// StringHelper.isEmpty(password)
	/*	Md5PasswordEncoder md5 = MD5Utils.getInstance();
*/	/*	String md5Password = md5.encodePassword(paswd,null);
		String md5Password2 = md5.encodePassword(name,null);*/
		if (!SYNC_md5.equals(name+paswd)) {
			logger.info("身份认证失败!");
			// 如果该action 必须用户登录之后才能使用，则给出提示
			List<BindingExcepObj> list2 = new ArrayList<BindingExcepObj>();
			BindingExcepObj bindingExcepObj = new BindingExcepObj();
			eResponse.setResponsecode(RESPONSECOE_008);
			eResponse.setErrorType(ERROR_TYPE_2);
			reason.setDesc("身份认证失败!");
			reason.setReasoncode(MGT_USER_NOT_LOGIN);
			eResponse.setReason(reason);
			bindingExcepObj.setFieldName("name or password");
			bindingExcepObj.setMessage("身份认证失败！");
			list2.add(bindingExcepObj);
			eResponse.setFiledErrorList(list2);

			pw.println(JSON.toJSONString(eResponse));
			pw.flush();
			pw.close();
			return false;
		} else {
			request.setAttribute("myJsonObject", myJsonObject);
			return true;
		}

	}

	/**
	 * 这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行。
	 * postHandle是进行处理器拦截用的，它的执行时间是在处理器进行处理之 后，
	 * 也就是在Controller方法调用后执行，但是会在DispatcherServlet进行视图的渲染之前执行.
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。
	 * 该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行，主要是用来清理释放资源的
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
}
