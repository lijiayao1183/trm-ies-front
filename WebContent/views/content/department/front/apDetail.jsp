<!--
	@page 推荐机构详情页面
	@author yinzheng
	@init-time 2017-10-20
	@history 新建页面	v1.0
-->
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>推荐机构详情</title>
<!--page css-->
<link rel="stylesheet" href="${contextPath}/css/trm.page.goods.css" />
<link rel="stylesheet" href="${contextPath}/css/trm.page.apLab.css">
</head>

<body>
	<div class="full-container content" style="margin:0 auto;border-top:2px solid #419ff6;">
		<div class="container">
			<div class="row">
				<!--描述：面包屑导航 start-->
				<ul class="breadcrumb">
					<li><a href="/">首页</a></li>
					<li class="active">推荐机构详情</li>
				</ul>
			</div>
			<div class="detail-wrap" id="detail_part">
				<div class="detail_top">
					<dl>
						<dt><img alt="" src="${contextPath}/images/default_img.png" id="displayImg"></dt>
						<dd id="title_name"</dd>
						<dd>网址：<a href="" id="url"></a></dd>
						<dd>创办时间：  <span id="date"></span></dd>
						<dd>联系电话：    <span id="phone"></span> </dd>
						<dd>联系地址：    <span id="address"></span> </dd>
						<dd>机构性质：   <span id="nature"></span></dd>
						<dd>主要研究方向：  <span id="direction"></span> </dd>
					</dl>
				</div>
				<span class="timeBox"><img src="${contextPath}/images/liulan.png"><b id="timeForBrowsing"></b>次数</span>
				<div class="detail_bottom">
					<div class="detail_contert">
						<h2>机构介绍</h2>
						<div id="detail_contert"></div>
					</div>
					<div class="detail_relevant" id="hotList">
						<h3>热门推荐</h3>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--component js lib-->
	<script src="${contextPath}/js/component/SuperSlide.js"></script>
	<script src="${contextPath}/js/component/bootstrap_modal_confirm.min.js"></script>
	<!--page js-->
	 <script src="${contextPath}/trm_modules/department/front/apDetail.js"></script>
</body>
</html>