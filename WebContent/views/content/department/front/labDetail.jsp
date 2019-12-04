<!--
	@page 技术服务机构详情页面
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
<title>军民融合技术服务机构详情</title>
<!--page css-->
<link rel="stylesheet" href="${contextPath}/css/trm.page.goods.css" />
<link rel="stylesheet" href="${contextPath}/css/trm.page.apLab.css">
</head>

<body>
	<div class="full-container">
		<div class="container" style="margin-top: 10px">
			<div class="row">
				<!--描述：面包屑导航 start-->
				<ul class="breadcrumb">
					<li><a href="/">首页</a></li>
					<li><a href="/views/content/department/front/srchlist.jsp">军民融合技术服务机构列表</a></li>
					<li class="active">军民融合技术服务机构详情</li>
				</ul>
			</div>
			<!-- <div class="detail-wrap" id="detail_part">
			</div> -->
			<div class="row import-info" style="padding: 35px 35px 35px 35px;">
			
				<h2 class="orgName" style="text-align:center;font-size: 24px;font-weight: bold;margin-top:0;padding: 0 100px;"></h2>
				<p style="text-align:center;font-size: 14px;color:#666;margin: 20px 0;"><span class="createTime" style="margin-right: 270px;"></span><span class="unitName"></span></p>
				
				<div class="lab-info pull-left">
					<!-- <div class="unit">
						<span class="max-w150">机构名称：</span>
						<span class="orgName"></span>
					</div> -->
					<div class="unit">
						<span class="max-w150">服务类型：</span>
						<span class="servType"></span>
					</div>
					<div class="unit">
						<span class="max-w150">机构地址：</span>
						<span class="address"></span>
					</div>
					<div class="unit">
						<span class="max-w150">机构性质：</span>
						<span class="property"></span>
					</div>
					<div class="unit">
						<span class="max-w150">机构属性：</span>
						<span class="attribute"></span>
					</div>
					<div class="unit">
						<span class="max-w150">邮编：</span>
						<span class="postcode"></span>
					</div>
					<div class="personTitle">技术服务机构负责人</div>
						<div>
							<div class="unit">
								<span class="max-w150">姓名：</span>
								<span class="headerName"></span>
							</div>
							<div class="unit">
								<span class="max-w150">电话：</span>
								<span class="headerPhone"></span>
							</div>
							<div class="unit">
								<span class="max-w150">手机：</span>
								<span class="headerMobile"></span>
							</div>
							<div class="unit">
								<span class="max-w150">邮箱：</span>
								<span class="headerEmail"></span>
							</div>
						</div>
					<div class="personTitle">技术服务机构联系人</div>
					<div>
						<div class="unit">
							<span class="max-w150">姓名：</span>
							<span class="linker"></span>
						</div>
						<div class="unit">
							<span class="max-w150">电话：</span>
							<span class="linkerPhone"></span>
						</div>
						<div class="unit">
							<span class="max-w150">手机：</span>
							<span class="linkerMobile"></span>
						</div>
						<div class="unit">
							<span class="max-w150">邮箱：</span>
							<span class="linkerEmail"></span>
						</div>
					</div>
				</div>
				<div class="pull-right">
					<div style="position:relative">
						<span class="btn-focus" style="right: 50px;"><span class="focus focus-down" id="downPdf"></span>下载</span>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="pull-left content">
					<div id="goods_content_info" class="row goods-content-title">
						<div class="title" style="border-bottom:1px solid #ddd;overflow:hidden;margin:0 24px">
							<ul>
						        <li class="active"><a>机构简介</a></li>
								<li><a>人才队伍情况</a></li>
								<li><a>规范化管理水平</a></li>
								<li><a>所获资质及荣誉</a></li>
								<li><a>技术服务情况</a></li>
								<li><a>承担的重要项目及案例</a></li>
						    </ul>
						</div>
					</div>
					<div class="detail-content">
						<div class="active" id="agency_intro_detail">1</div>
						<div id="talents_intro_detail">2</div>
						<div id="manage_intro_detail">3</div>
						<div id="honor_intro_detail">4</div>
						<div id="technical_intro_detail">5</div>
						<div id="project_intro_detail">6</div>
					</div>
				</div>
			</div>
			<div class="row" id="fileList">
				<div class="pull-left content" style="min-height: 200px;">
					<div id="goods_content_info" class="row goods-content-title">
						<div class="title" style="border-bottom:1px solid #ddd;overflow:hidden;margin:0 24px">
							<ul>
						        <li class="active"><a>随附材料</a></li>
						    </ul>
						</div>
					</div>
					
					<div class="detail-content">
						<div class="intro">
							<div class="intro__left">法人营业执照副本扫描件:</div>
							<div class="intro__main" id="intro__main--1">
								
							</div>
						</div>
						<div class="intro">
						<div class="intro__left">组织机构代码证书扫描件:</div>
							<div class="intro__main" id="intro__main--2">
								
							</div></div>
						<div class="intro">
						<div class="intro__left">税务登记证书扫描件:</div>
							<div class="intro__main" id="intro__main--3">
								
							</div></div>
						<div class="intro">
						<div class="intro__left">资质及荣誉证书扫描件:</div>
							<div class="intro__main" id="intro__main--4">
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--component js lib-->
	<script src="${contextPath}/js/component/SuperSlide.js"></script>
	<script src="${contextPath}/js/component/bootstrap_modal_confirm.min.js"></script>
	<!--page js-->
	<script src="${contextPath}/trm_modules/common/timeForBrowsing.js"></script>
	<script src="${contextPath}/trm_modules/department/front/labDetail.js"></script>
</body>
</html>