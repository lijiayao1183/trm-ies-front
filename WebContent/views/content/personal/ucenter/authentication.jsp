<!--
	@page 账户安全
	@author yinzheng
	@init-time 2017-11-1
	@history 新建页面	v1.0
-->
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>个人中心-密码管理</title>
		<!--page css-->
		<link rel="stylesheet" href="${contextPath}/css/trm.page.personalCenter.css" />	
	</head>

	<body>
		<div class="full-container content">
			<div class="container">
				<!--左侧菜单列表  start-->
				<jsp:include page="${contextPath}/views/decorator/common/left-nav.jsp"/>
				<!--左侧菜单列表  end-->
				<!--作者：wangxun 描述：账户安全Form表单  start-->
				<div class="ucenter-content pull-right">
					<div class="row content-box">
						<div class="row content-box inner msg">
							<span class="label">温馨提示:</span> <span>为了您的权益与安全，请不要将登录密码透露给他人，并且牢记您的新密码。</span>
						</div>
						<div class="form-content acc-form-content">
							<form id="acc_security_form">
								<div class="form-group">
									<div class="single-column">
										<label>当前密码 :</label>
										<input id="oldPassword_filed" maxlength=16  name="oldPassword_filed" type="password" class="form-control">
										<div class="error-tips"></div>
									</div>
								</div>
								<div class="form-group">
									<div class="single-column">
										<label>新密码 :</label>
										<input id="newPassword_filed" maxlength=16 type="password" class="form-control">
										<div class="error-tips-pwd">密码由6-16位字母加数字组成</div>
									</div>
								</div>
								<div class="form-group">
									<div class="single-column">
										<label>确认新密码 :</label>
										<input id="copy_filed" maxlength=16 name="copy_filed" type="password" class="form-control">
										<div class="error-tips"></div>
									</div>
								</div>
								<div class="goods-form-button">
									<div class="btn btn-default bigger highlight" id="save_form">提交</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<!--作者：wangxun 描述：账户安全Form表单  end-->
			</div>
		</div>
		<!--component js lib-->
		<script src="${contextPath}/js/component/bootstrap_modal_confirm.min.js"></script>
		<script src="${contextPath}/js/component/validation.js"></script>
		<script src="${contextPath}/js/component/jquery.md5.js"></script>
		<!--page js-->
		<script src="${contextPath}/trm_modules/common/ucenter/leftnav.js"></script>
		<script src="${contextPath}/trm_modules/personal/ucenter/authentication.js"></script>
	</body>
</html>