<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags'%>
<sec:authentication property="principal" var="principal"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人中心-设备管理-发布需求</title>
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
								<label>用户名:</label>
								<input type="text" class="form-control" id="username" name="username"  disabled="disabled"/> 
							</div>
						
							<div class="form-group">
								<label>联系人:</label>
								<input type="text" class="form-control" id="linkMan" name="linkMan" disabled="disabled"/> 
							</div>
							<div class="form-group">
								<label>所在单位:</label>
								<input type="text" class="form-control" id="unitName" name="unitName" disabled="disabled" /> 
							</div>
							<div class="form-group">
								<label>联系方式:</label>
								<input type="text" class="form-control" id="linkPhone" name="linkPhone" disabled="disabled" /> 
							</div>
							<div class="form-group">
								<label>电子邮件:</label>
								<input type="text" class="form-control" id="email" name="email" disabled="disabled"/> 
							</div>
							<div class="form-group">
								<label>标题:</label>
								<input type="text" class="form-control" id="title" name="title" disabled="disabled" /> 
							</div>
							
							<div class="form-group" style="clear: both;height: 140px !important;">
								<label style="vertical-align: top;">留言内容:</label> 
								<textarea class="form-control" style="height: 120px !important;width: 478px;" rows="10" id="leaveMsg"  name="leaveMsg" disabled="disabled"></textarea>
								<span class="error-tips"></span>
							</div>
							<div class="form-group" style="clear: both;height: 140px !important;" id="replybox">
								<label style="vertical-align: top;">回复内容:</label> 
								<textarea class="form-control" style="height: 120px !important;width: 478px;" rows="10" id="replyMsg"  name="replyMsg" disabled="disabled"></textarea>
								<span class="error-tips"></span>
							</div>
						</form>
						<hr>
					
						<button class="btn btn-submit" style="margin-left:300px;" type="button" id="backBtn">返回</button>
						
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
	<script src="${contextPath}/js/component/bootstrap3-typeahead.js"></script>
	<script src="${contextPath}/js/component/json2.js"></script>
	<script src="${contextPath}/js/component/browserdetect.js"></script>
	<!--page js-->
	<script src="${contextPath}/trm_modules/common/ucenter/leftnav.js"></script>
	<script src="${contextPath}/trm_modules/interaction/ucenter/apply.js"></script>
</body>
</html>