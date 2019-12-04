<!--
	@page 需求列表
	@author yinzheng
	@init-time 2017-11-16
	@history 新建页面	v1.0
-->
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>留言列表</title>
<link rel="stylesheet" href="${contextPath}/css/component/simplePagination.min.css">
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
		
	<div class="full-container content" style="margin:0;">
		<div class="container filter-box">
			<div class="row" style="line-height:38px;">
				<!--作者：wangxun  描述：面包屑导航 start-->
				<ul class="breadcrumb">
					<li><a href="/views/content/interaction/front/srchlist.jsp">互动交流</a></li>
					<li class="active">留言列表</li>
				</ul>
			</div>
			
			
			<div class=" news-list">
				
				<ul class="news-ul" id="newsList">
				</ul>
				<div class="pull-center text-center clear">
         			<div id="pagtrade"></div>
    			</div>
			</div>
		</div>
	
	</div>
	<script src="${contextPath}/js/component/SuperSlide.js"></script>
	<script src="${contextPath}/js/component/pagination.min.js"></script>
		
	<script src="${contextPath}/trm_modules/interaction/front/srchlist.js"></script>
</body>
</html>