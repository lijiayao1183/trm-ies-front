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
<title>资料下载列表</title>
<link rel="stylesheet" href="${contextPath}/css/component/simplePagination.min.css">
<!--page css-->
<link rel="stylesheet" href="${contextPath}/css/trm.page.goods.css" />
<link rel="stylesheet" href="${contextPath}/css/trm.page.replyList.css">


<style>
	.news-ul li {
	    height: inherit;
	}
	.news-ul li .demand-name {
	    font-size: 20px;
	    display: inline-block;
        width: 570px;
        margin: 0;
	}
	.demand-btn {
		height: inherit;
	    padding: 14px 19px;
	    line-height: 36px;
	    display: inline-block;
	    float: right;
	}
	.demand-btn p{
	    float:left;
    	font-size: 16px;
   	    color: #666;
 	    padding-right: 20px;
        margin: 0;
	}
	.demand-btn a{
	    float: right;
	    width: 80px;
	    height: 30px;
	    background: url(/images/newsseebg.png) no-repeat;
   	    cursor:pointer;
   	    margin-top: 2px;
	}
	.demand-btn a:hover {
	    background: url(/images/newsseebghover.png) no-repeat;
	}
</style>

</head>
<body>
	<!-- 顶部图片start -->
	<div class="full-container" style="margin-bottom:0;">
		<div id="home_banner" class="slideBox">
			<div class="fullSlide">
				<div class="bd">
					<div class="tempWrap">
						<ul style="position: relative; width: 1835px; height: 500px;">
						<li><a href="/"><img src="${contextPath}/images/banner4.jpg" onerror="imgError(this);"></a></li>
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
					<li class="active">资料下载</li>
				</ul>
			</div>


			<div class="pull-right news-list">
				<div class="demand-search">
					<input type="text" class="input-search" name="d_search" id="d_search" placeholder="请输入搜索内容">
					<div class="s-btn" id="s_Btn">搜索</div>
				</div>



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
		
	<script src="${contextPath}/trm_modules/download/front/srchlist.js"></script>
</body>
</html>