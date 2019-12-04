<!--
	@page 需求详情
	@author yinzheng
	@init-time 2017-11-16
	@history 新建页面	v1.0
-->
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>需求详情</title>
<!--page css-->
<link rel="stylesheet" href="${contextPath}/css/trm.page.goods.css" />
<link rel="stylesheet" href="${contextPath}/css/trm.page.replyList.css">
</head>

<body>
<!-- 顶部图片start -->
	<div class="full-container" style="margin-bottom:0;">
		<div id="home_banner" class="slideBox">
			<div class="fullSlide">
				<div class="bd">
					<div class="tempWrap">
						<ul style="position: relative; width: 1835px; height: 500px;">
						<li><a href="/"><img src="${contextPath}/images/reply_banner.png" onerror="imgError(this);"></a></li>
						</ul>
					</div>
				</div>
				<div class="hd" style="bottom:0;">
					<ul style="margin:0;text-align:center;"></ul>
				</div>
			</div>
		</div>
	</div>
	<!-- 顶部图片end -->


	<div class="full-container content">
		<div class="container">
			<div class="row">
				<!--作者：wangxun  描述：面包屑导航 start-->
				<ul class="breadcrumb">
					<li><a href="/views/content/interaction/front/srchlist.jsp">互动交流</a></li>
					<li class="active">我要留言</li>
				</ul>
			</div>
			<!--作者：wangxun  描述：面包屑导航 end-->
			<div class="row">
				<!--作者：wangxun 描述：左侧详情主体 start-->
				<div class="block-inline data-part" >
					<div class="row content-box">
						<div class="detail" >
							<form id="apply_form">
								<div class="form-group">
									<label class="vereist">用户名:</label>
									<input type="text" class="form-control" id="username" name="username"  disabled="disabled" /> 
									<span class="error-tips"></span>
								</div>
								<div class="form-group">
									<label class="vereist">联系人:</label>
									<input type="text" class="form-control" id="linkMan" name="linkMan"  disabled="disabled" /> 
									<span class="error-tips"></span>
								</div>
								<div class="form-group">
									<label class="vereist">所在单位:</label>
									<input type="text" class="form-control" id="unitName" name="unitName" disabled="disabled" / > 
									<span class="error-tips"></span>
								</div>
								<div class="form-group">
									<label class="vereist">联系方式:</label>
									<input type="text" class="form-control" id="linkPhone" name="linkPhone" disabled="disabled" /> 
									<span class="error-tips"></span>
								</div>
								<div class="form-group">
									<label class="vereist">电子邮件:</label>
									<input type="text" class="form-control" id="email" name="email" disabled="disabled" /> 
									<span class="error-tips"></span>
								</div>
								<div class="form-group">
									<label class="vereist">标题:</label>
									<input type="text" class="form-control" id="title" name="title" maxlength="100" placeholder="不超过100字"/> 
									<span class="error-tips"></span>
								</div>
								<div class="form-group" style="clear: both;height: 200px !important;">
									<label style="vertical-align: top;" class="vereist">留言内容:</label> 
									<textarea class="form-control"  rows="10" id="leaveMsg"  name="leaveMsg"  maxlength="1000" placeholder="不超过1000字"></textarea>
									<span class="error-tips"></span>
								</div>	
							</form>																	
						</div>
					</div>
					<div class="save_form">提交</div>
				</div>
				
			</div>
		</div>
	</div>
	<!--component js lib-->
	<script src="${contextPath}/js/component/bootstrap_modal_confirm.min.js"></script>
	<!--page js-->
	<script src="${contextPath}/trm_modules/interaction/front/write.js"></script>
</body>
</html>