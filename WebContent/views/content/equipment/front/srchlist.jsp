<!--
	@page 设备列表
	@author yinzheng
	@init-time 2017-10-16
	@history 新建页面	v1.0
-->
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>设备检索</title>
<link rel="stylesheet" href="${contextPath}/css/component/simplePagination.min.css">
<!--page css-->
<link rel="stylesheet" href="${contextPath}/css/trm.page.goods.css" />
<link rel="stylesheet" href="${contextPath}/css/trm.page.equipment.css">

</head>
<body>
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
	
	<!-- 顶部图片start -->
	<div class="full-container" style="margin-bottom:15px;">
		<div class="search-area">
			<div class="search-center">
				<div class="search-content">
					<input type="text" class="pull-left Search-input" id="BDSearch_input" placeholder="请输入设备设施关键信息"/>
					<div class="search-btn pull-left" id="doSearch">搜索</div>
					<ul class="search-ul">
						<li style="background:#fff;">
							<div class="advanced-search">
								<div class="search-tips">高级检索</div>
							</div>
						</li>
						<!-- <li style="background:#fff;">
							<div class="deliver-info">
								<i class="search-icon pub-eq"></i>
								<div class="search-tips" style="margin-left:-17px;">发布信息设备</div>
							</div>				
						</li> -->
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- 顶部图片end -->	
	<div class="full-container content">
		<div class="container filter-box">
			<div id="page_search_store" class="sxcon filter-tab-content single">
				<div class="search-by">
					<dl>
						<dt class="pull-left">
							<span>设备设施类型:</span>
						</dt>
						<dd class="pull-left show-con" stype="equipType" id="equipType_list">
						</dd>
					</dl>
					<dl>
						<dt class="pull-left">
							<span>服务领域:</span>
						</dt>
						<dd class="pull-left show-con" stype="serviceRange" id="serviceRange_list">
						</dd> 
					</dl>
				</div>
			</div>
		</div>
		<div class="container filter-list">
			<div class="row full-row">
				<div class="row content-box">
					<div class="detail">
					  <ul class="good-list-item clear" id="recom_list">
					  </ul>	
		           </div>
            	</div>
	        </div>
	    </div>
		<div class="row pull-center text-center clear">
         	<div id="pagtrade"></div>
    	</div>	
	</div>
	
	<script src="${contextPath}/js/component/SuperSlide.js"></script>
	<script src="${contextPath}/js/component/pagination.min.js"></script>
	
	<script src="${contextPath}/trm_modules/equipment/front/srchlist.js"></script>
</body>
</html>