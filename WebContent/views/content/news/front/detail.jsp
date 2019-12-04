<!--
	@page 资讯详情
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
<title>资讯详情</title>
<link rel="stylesheet" href="${contextPath}/css/component/simplePagination.min.css">
<!--page css-->
<link rel="stylesheet" href="${contextPath}/css/trm.page.goods.css" />
<link rel="stylesheet" href="${contextPath}/css/trm.page.ienews.css">

</head>
<body>
	<div class="full-container content" style="margin:0;border-top:2px solid #419ff6;">
		<div class="container filter-box">
			<div class="row">
				<!--描述：面包屑导航 start-->
				<ul class="breadcrumb">
					<li><a href="/">首页</a></li>
					<li class="active">资讯详情</li>
				</ul>
			</div>
			<div class="pull-left news-nav">
				<ul>
					<!-- <li flagCode="1">政策法规</li> -->
					<li calss="active" flagCode="3">通知公告</li>
					<li flagCode="2">要闻动态</li>
					
				</ul>
			</div>
			
			<div class="pull-right news-detail">
				<p class="detail-title"><!-- 运城科技大市场正式开业 --></p>
				<div class="sub-title">
					<span class="pull-left title-span publicUnit"><!-- 发布单位:洛阳科技大市场 --></span>
					<span class="pull-right title-span publicTime"><!-- 发布时间:2017-09-09 --></span>
				</div>
				
				<div class="detail-abstract" id="detail_abstract">
					<!-- <img src="/images/zixun-2.png" class="pull-left detail-img" />
					<div class="pull-right abstract">
						<p style="margin:0;">摘要：</p>
						<p style="text-indent:2em;">
							作为首届毕业生，你们满载荣耀，使命光荣。希望首届毕业生，你们满载荣耀，使命光荣。希望你你们坚持学习、学以致用，行远升高、积厚成器，努力探索符合本国国情的可持续发展道路，成为各自国家改革发展的领导者。希望你们珍惜同各位老师、同学、朋友在中国结下的情谊，书写你们国家同中国友好合作新篇章，成为全荣耀，使命光荣。希望你们坚持学习、学以致用，行远升高、积厚成器，努力探索符合本国国情的可持续发展道路，成为各自国家改革发展的领导者。希望你们珍惜同各位老师、同学、朋友在中国结下的情谊，书写你们国家同中国友好合作新篇章，成为全球南南合作的践球南南合作的践行者。
						</p>
					</div> -->
				</div>
				
				<div class="detail-content" id="detail_content"></div>
				<div class="enclosure">
					<p>附件</p>
					<div class="enclosure-content">
						<ul>
							<!-- <li><a href="">fujian</a><i class="preview">预览</i><i class="download">下载</i></li> -->
						</ul>
					</div>
				</div>
				<p style="text-align: center;" id="downloadWrap">
					<button type="button" class="btn btn-default highlight detail-btn" id="download">下载</button>
				</p>		
			</div>
		</div>
	
	</div>
	<script src="${contextPath}/js/component/pagination.min.js"></script>
	<script src="${contextPath}/js/component/bootstrap_modal_confirm.min.js"></script>	
	<script src="${contextPath}/trm_modules/news/front/detail.js"></script>
</body>
</html>