<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- 引入富文本js -->
<script type="text/javascript" charset="utf-8" src="/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="/ueditor/ueditor.all.min.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="/ueditor/lang/zh-cn/zh-cn.js"></script>

<meta content="" name="description" />
<meta content="" name="keywords" />	

<!-- 引入全局 stylesheet 和 script -->
<jsp:include page="/views/decorator/common/script.jsp"/>

<title>交易平台后台管理系统-登录</title>
</head>
<body>
	<div class="full-container content">
	     <div class="middle-box text-center loginscreen animated fadeInDown">
		     <div class="text-center">
	            <div class="logo-white-img pull-center"></div>
	            <h4>欢迎使用 巨眼网后台管理系统</h4>
	         </div>	         	
	         <form>
	             <div class="form-group">
	                 <input type="text" class="form-control core-base" placeholder="用户名" id="username" name="username"> 
	             </div>
	             <div class="form-group">
	                 <input type="password" class="form-control core-base" placeholder="密码" id="password" name="password">
	             </div>
	             <button type="button" class="btn btn-default bigger highlight full-width m-b" id="login_btn">登 录</button>
	             
	             <p class="text-muted text-center"> <a href="login.html#"><small>忘记密码了？</small></a></p>
	        </form>
        </div>
	</div>
	<a href="${contextPath}/exportBscInfoPDF.action?applyId=1">下载</a>
</body>
<%-- <script type="text/javascript" src="${contextPath}/trm_modules/admin/login/login.js"></script> --%>
</html>