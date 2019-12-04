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
<title>军民融合技术服务机构列表</title>
<link rel="stylesheet" href="${contextPath}/css/component/simplePagination.min.css">
<!--page css-->
<link rel="stylesheet" href="${contextPath}/css/trm.page.goods.css" />
<link rel="stylesheet" href="${contextPath}/css/trm.page.department.css">

</head>
<body>
	<!-- 顶部图片start -->
	<div class="full-container" style="margin-bottom:0;">
		<div id="home_banner" class="slideBox">
			<div class="fullSlide">
				<div class="bd">
					<div class="tempWrap">
						<ul style="position: relative; width: 1835px; height: 400px;">
							<%-- <li>
								<a href="http://www.baidu.com/"><img src="${contextPath}/images/home-banner.png" alt="科工办1" title="科工办1" onerror="imgError(this);"></a>
							</li>
							<li>
								<img src="${contextPath}/images/home-banner2.png" alt="科工办2" title="科工办2" onerror="imgError(this);">
							</li>
							<li>
								<img src="${contextPath}/images/home-banner3.png" alt="科工办3" title="科工办3" onerror="imgError(this);">
							</li> --%>
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
					<li><a href="/">首页</a></li>
					<li class="active">军民融合技术服务机构列表</li>
				</ul>
			</div>
			<div class="news-list">
				<div class="demand-search">
					<input type="text" class="input-search" name="d_search" id="d_search" placeholder="请输入搜索内容" />
					<div class="s-btn" id="s_Btn">搜索</div>
				</div>
				<ul class="news-ul" id="newsList">
					<!-- <li>
						<p class="demand-name">石油产品检测检验装置</p>
						<div class="demand-line">
							<span>设备（设施）类别：</span>
							<span class="demand-item">军工大型仪器设备</span>
							<span>服务领域：</span>
							<span class="demand-item">军工/石化</span>
						</div>
						<div class="demand-line">
							<span>需求单位：</span>
							<span class="demand-item">陕西省西安市机打了个盹有限公司</span>
						</div>	
						<div class="detail-btn">详细信息</div>					
					</li> -->
				</ul>
				<div class="pull-center text-center clear">
         			<div id="pagtrade"></div>
    			</div>
			</div>
		</div>
	
	</div>
	<script src="${contextPath}/js/component/SuperSlide.js"></script>
	<script src="${contextPath}/js/component/pagination.min.js"></script>
		
	<script src="${contextPath}/trm_modules/department/front/srchlist.js"></script>
</body>
</html>