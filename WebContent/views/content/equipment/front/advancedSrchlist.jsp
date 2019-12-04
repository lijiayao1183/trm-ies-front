<!--
	@page 高级检索页面
	@author yinzheng
	@init-time 2017-10-25
	@history 新建页面	v1.0
-->
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>高级检索</title>
<link rel="stylesheet" href="${contextPath}/css/component/simplePagination.min.css">
<!--page css-->
<link rel="stylesheet" href="${contextPath}/css/trm.page.goods.css" />
<link rel="stylesheet" href="${contextPath}/css/trm.page.adSrchlist.css">

</head>
<body>
	<!-- 顶部图片start -->
	<div class="full-container">
		<img class="banner-pic" style="max-height: 400px;" src="${contextPath}/images/pic_equip_banner.png">
	</div>
	<!-- 顶部图片end -->	
	<div class="full-container content">
		<div class="container">
			<div class="row">
				<ul class="breadcrumb">
					<li><a href="/">首页</a></li>
					<li class="active"><a href="/views/content/equipment/frontadcancedSrchlist.jsp">高级检索</a></li>
				</ul>
			</div>
			
			<div class="pull-left adSearch-nav content-box">
				<div class="nav-title">设备设施类型</div>
				<div class="nav-detail" id="DF1_nav"><!-- 军工试验仪器 -->
					<div style="padding-left:10px;margin-bottom:5px;">
						<span class="span-checkbox check-all">
							<input type="checkbox" class="radioclass input" autocomplete="off" >
						</span>
						<label style="font-size:16px;">军工试验设施</label>
					</div>
					<ul></ul>
				</div>
				<div class="nav-detail" id="DF2_nav"><!-- 军工科研仪器 -->
					<div style="padding-left:10px;margin-bottom:5px;">
						<span class="span-checkbox check-all">
							<input type="checkbox" class="radioclass input" autocomplete="off">
						</span>
						<label style="font-size:16px;">军工大型科研仪器</label>
					</div>
					<ul></ul>
				</div>
				<div class="nav-title">服务领域</div>
				<div class="nav-detail" id="SR_nav">
					<ul></ul>
				</div>				
			</div>
			
			<div class="pull-left adSearch-content content-box">
				<div class="adSearch-wrap">
					<div class="search-line form-content">
						<span class="search-item">设备设施名称</span>
						<input type="text" class="search-input" id="name-field" />
						<span class="search-item">持有单位</span>
						<input type="text" class="search-input" id="master-field" />
					</div>
					<div class="search-line form-content">
						<span class="search-item">主要技术指标</span>
						<input type="text" class="search-input" id="tech-field" />
						<span class="search-item">功能应用范围</span>
						<input type="text" class="search-input" id="fanwei-field" />						
					</div>	
					<div class="search-line form-content">
						<span class="search-item">技术特点</span>
						<input type="text" class="search-input" id="property-field" />
						<div class="search-btn">检索</div>
					</div>
																								
				</div>
			</div>
			
			<div class="pull-left adSearch-content content-box" style="padding:0;">
				<div class="eqipment-list" id="eqipment_list">
					<ul>
					</ul>
				</div>
				
				<div class="row pull-center text-center clear" style="background-color:#f5f5f5;">
		         	<div id="pagtrade"></div>
		    	</div>					
			</div>
		</div>
	</div>
	<script src="${contextPath}/js/component/pagination.min.js"></script>
	<script src="${contextPath}/js/component/bootstrap_modal_confirm.min.js"></script>	
	<script src="${contextPath}/trm_modules/equipment/front/advancedSrchlist.js"></script>
</body>
</html>