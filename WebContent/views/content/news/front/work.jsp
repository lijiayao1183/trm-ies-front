<!--
	@page 咨询列表
	@author yinzheng
	@init-time 2017-10-18
	@history 新建页面	v1.0
-->
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>工作动态</title>
<link rel="stylesheet" href="${contextPath}/css/component/simplePagination.min.css">
<!--page css-->
<link rel="stylesheet" href="${contextPath}/css/trm.page.goods.css" />
<link rel="stylesheet" href="${contextPath}/css/trm.page.ienews.css">

<style>
	.news-nav{
	    width: 0;
	    height: 0;
	    display: inline-block;
	    visibility: hidden;
	    padding: 0;
	}
	.news-list {
	    width: 100%;
	}
	.news-ul li {
	    width: 100%;
	}
	.news-ul li img {
	    margin-right: 60px;
	}
	.news-list .news-info {
	    width: 850px;
	}
</style>

</head>
<body>
	<!-- 顶部图片start -->
	<%-- <div class="full-container" style="margin-bottom:-25px;">
		<img class="banner-pic" style="max-height: 400px;" src="${contextPath}/images/pic_news_banner.png" />
	</div> --%>
	<%-- <div class="full-container" style="margin-bottom:0;">
		<div id="home_banner" class="slideBox">
			<div class="fullSlide">
				<div class="bd">
					<div class="tempWrap">
						<ul style="position: relative; width: 1835px; height: 400px;">
							<li>
								<a href="http://www.baidu.com/"><img src="${contextPath}/images/home-banner.png" alt="科工办1" title="科工办1" onerror="imgError(this);"></a>
							</li>
							<li>
								<img src="${contextPath}/images/home-banner2.png" alt="科工办2" title="科工办2" onerror="imgError(this);">
							</li>
							<li>
								<img src="${contextPath}/images/home-banner3.png" alt="科工办3" title="科工办3" onerror="imgError(this);">
							</li>
						</ul>
					</div>
				</div>
				<div class="hd" style="bottom:0;">
					<ul style="margin:0;text-align:center;"></ul>
				</div>
			</div>
		</div>
	</div> --%>
	
	<!-- 顶部图片end -->	
	<div class="full-container content">
		<div class="container filter-box">
			<div class="row">
				<!--描述：面包屑导航 start-->
				<ul class="breadcrumb">
					<li><a href="/">首页</a></li>
					<li class="active">工作动态</li>
				</ul>
			</div>
			<div class="news-nav">
				<ul>
					<li class="active" flagCode="1">政策法规</li>
					<li flagCode="3">通知公告</li>
					<li flagCode="2">要闻动态</li>
					<li flagCode="4">要闻动态</li>
					
				</ul>
			</div>
			<div class="news-list">
				<ul class="news-ul" id="newsList">
					<!-- <li>
						<img class="pull-left" src="/images/zixun-2.png" />
						<div class="news-info pull-left">
							<p class="news-title">吕梁市政府考察团到访西安科技大市场</p>
							
							<div class="news-abstract">
								技大市场吕梁市政府考察团到访西安科技大市场吕梁市政府考察团到访技大市场吕梁市政府考察团到访西安科技大市场吕梁市政府考察团到西安科技大市场吕梁市政府考察团到访西安科技大市场
							</div>
							<span class="news-inscribe pull-left">发布单位:西安西安先发牢骚房东商量</span>
							<span class="news-inscribe pull-right">发布时间:2017-09-09</span>
						</div>
					</li>	 -->																			
				</ul>
				<div class="pull-center text-center clear">
         			<div id="pagtrade"></div>
    			</div>
			</div>
		</div>
	
	</div>
	<script src="${contextPath}/js/component/SuperSlide.js"></script>
	
	<script src="${contextPath}/js/component/pagination.min.js"></script>	
	<script src="${contextPath}/trm_modules/news/front/srchlist.js"></script>
</body>
</html>