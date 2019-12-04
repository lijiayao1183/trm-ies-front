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
<link rel="stylesheet" href="${contextPath}/css/trm.page.demand.css">
</head>

<body>
	<div class="full-container content">
		<div class="container">
			<div class="row">
				<!--作者：wangxun  描述：面包屑导航 start-->
				<ul class="breadcrumb">
					<li><a href="/">首页</a></li>
					<li><a href="/views/content/demand/front/srchlist.jsp">军民融合需求列表</a></li>
					<li class="active">需求详情</li>
				</ul>
			</div>
			<!--作者：wangxun  描述：面包屑导航 end-->
			<div class="row">
				<!--作者：wangxun 描述：左侧详情主体 start-->
				<div class="block-inline w-840 data-part" style="width:880px;">
					<div class="row content-box">
						<div class="detail">
							<div class="dd-name" id="dd_name" style="border-bottom:none;">需求名称 </div>
							<div class="dd-info" style="text-align: left;margin: 10px 0;padding: 0 0 20px 0;border-bottom: 1px solid #ddd;">
								<span id="createTime" style="margin: 0 100px 0 100px;"></span>
								<span id="companyName"></span>
							</div>
														
							<span class="btn-focus"><span class="focus focus-down" id="downPdf"></span>下载</span>
							<span class="timeBox"><img src="${contextPath}/images/liulan.png"><b id="timeForBrowsing"></b>次数</span>
							<div class="dd-line">
								<span id="eType_span" style="font-weight:bold;">需求类型：</span>
								<span id="eType"></span>
							</div>
							<div class="dd-line">
								<span style="font-weight:bold;">服务领域：</span>
								<span id="sArea"></span>
							</div>
							<div class="dd-line">
								<span style="font-weight:bold;">需求描述：</span>
								<span id="desciption"></span>
							</div>
							
							<div class="dd-line">
								<span style="font-weight:bold;">备注：</span>
								<span id="remarks"></span>
							</div>
								
							<div class="d-line"></div>
							
							<div class="title-name">联系方式</div>
							<div class="dd-line">
								<span style="font-weight:bold;">需求有效期：</span>
								<span id="period"></span>
							</div>
							<div class="dd-line">
								<span style="font-weight:bold;">需求单位：</span>
								<span id="dFirm"></span>
							</div>
							<div class="dd-line">
								<span style="font-weight:bold;">单位地址：</span>
								<span id="dAddr"></span>
							</div>
							<div class="dd-line">
								<span style="font-weight:bold;">联系人：</span>
								<span id="contactor"></span>
							</div>
							<div class="dd-line">
								<span style="font-weight:bold;">联系电话：</span>
								<span id="phone"></span>
							</div>	
							<p id="prompt"></p>	
							
							<div class="d-line"></div>
							
							<div class="title-name" >相关技术产品</div>
							<table border="1" id="relevant_list" style="width:100%;text-align:center;line-height:50px;" >
							  	<tr>
									<td style="width:20%;">名称</td>
									<td style="width:50%;">功能描述</td>
									<td style="width:20%;">联系方式</td>
								</tr>
							</table>																														
						</div>
					</div>
				</div>
				<div class="pull-right w-340" style="width:300px;padding: 0 16px;background:#fff;">
					<div class="row content-box box-hasline">
						<div class="title">
							<dt class="pull-left sname">
								<span id="shop_name">热门推荐</span>
							</dt>
						</div>
					</div>
					<div class="row content-box">
						<div class="detail" style="padding: 15px 0;">
							<div class="shop-info" id="shop_info">
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--component js lib-->
	<script src="${contextPath}/js/component/bootstrap_modal_confirm.min.js"></script>
	<!--page js-->
	<script src="${contextPath}/trm_modules/demand/front/detail.js"></script>
</body>
</html>