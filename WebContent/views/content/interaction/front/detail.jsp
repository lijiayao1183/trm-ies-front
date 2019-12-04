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
					<li><a href="/views/content/interaction/front/srchlist.jsp">留言列表</a></li>
					<li class="active">留言详情</li>
				</ul>
			</div>
			<!--作者：wangxun  描述：面包屑导航 end-->
			<div class="row">
				<!--作者：wangxun 描述：左侧详情主体 start-->
				<div class="block-inline data-part" >
					<div class="row content-box">
						<div class="detail">
								<h1></h1>
								<p></p>
								<div class="message deta ">
									<span></span>
									<div class="content"></div>
								</div>
								<div class="service deta">
									<span>管理员回复：</span>
									<div class="content"></div>
								</div>																											
						</div>
					</div>
					<div class="back">返回</div>
				</div>
				
			</div>
		</div>
	</div>
	<!--component js lib-->
	<script src="${contextPath}/js/component/bootstrap_modal_confirm.min.js"></script>
	<!--page js-->
	<script src="${contextPath}/trm_modules/interaction/front/detail.js"></script>
</body>
</html>