<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags'%>
<sec:authentication property="principal" var="principal"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人中心-用户管理-创建用户</title>
<!--component css-->
<!--page css-->
<link rel="stylesheet" href="${contextPath}/css/trm.page.applyEquipment.css">
</head>
<body>
	<!-- 顶部图片end -->
	<div class="full-container content">
		<div class="container">
			<!-- 左侧部分 start-->
			<%@ include file="/views/decorator/common/left-nav.jsp" %>
			<!-- 左侧部分 end-->
			
			<!-- 右侧部分 start-->
			<div class="ucenter-content pull-right">
				<div class="row content-box">
					<div class="form-content">
						<form id="apply_form">
							<div class="form-group">
								<label class="vereist">用户名:</label>
								<input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名" /> 
								<span class="error-tips"></span>
							</div>
							<div class="form-group">
								<label class="vereist">所在部门:</label>
								<input type="text" class="form-control" id="department" name="department"  placeholder="请输入您的所在部门"/>
								<span class="error-tips"></span>
							</div>
							<div class="form-group">
								<label class="vereist">真实姓名:</label> 
								<input type="text" class="form-control" id="linkPerson" name="linkPerson"  placeholder="请输入您的真实姓名"/>
								<span class="error-tips"></span>
							</div>
							<div class="form-group">
								<label class="vereist">联系电话:</label>
								<input type="text" class="form-control" id="phone" name="phone"  placeholder="请输入联系电话" />
								<span class="error-tips"></span>
							</div>
							<div class="form-group">
								<label class="vereist">电子邮箱:</label>
								<input type="text" class="form-control" id="email" name="email"  placeholder="请输入邮箱" />
								<span class="error-tips"></span>
							</div>
						</form>
						<hr>
						<div class="center-block">
							<button class="btn btn-save" type="button" id="saveItem">保存</button>
							<button class="btn btn-submit" type="button" id="back">返回</button>
						</div>
					</div>
				</div>
			</div>
			<!-- 右侧部分 end-->
		</div>
	</div>
	
	<div class="loading-area hide" id="loading_area" style="background-color:#000;opacity:0.6px;">
		<div id="loading_pic">
			<img src="/images/Loading3.gif">
		</div>
	</div>
	
	<script>
		
	</script>
	<!--component js lib-->
	<script src="${contextPath}/js/component/bootstrap_modal_confirm.min.js"></script>
	<script src="${contextPath}/js/component/pagination.min.js"></script>
	<script src="${contextPath}/js/component/jquery.ui.widget.min.js"></script>
	<script src="${contextPath}/js/component/jquery.iframe-transport.min.js"></script>
	<script src="${contextPath}/js/component/jquery.fileupload.js"></script>
	<script src="${contextPath}/js/component/validation.js"></script>
	<script src="${contextPath}/js/component/laydate.dev.min.js"></script>	
	<script src="${contextPath}/trm_modules/common/front/option.js"></script>
	<script src="${contextPath}/js/component/json2.js"></script>
	<script src="${contextPath}/js/component/browserdetect.js"></script>
	<script src="${contextPath}/js/component/bootstrap3-typeahead.js"></script>
	<!--page js-->
	<script src="${contextPath}/trm_modules/common/ucenter/leftnav.js"></script>
	<script src="${contextPath}/trm_modules/usermgt/ucenter/apply.js"></script>
</body>
</html>