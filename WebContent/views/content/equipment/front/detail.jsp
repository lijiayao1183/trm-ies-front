<!--
	@page 设备详情
	@author yinzheng
	@init-time 2017-10-17
	@history 新建页面	v1.0
-->
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>设备详情</title>
<link rel="stylesheet" href="${contextPath}/css/component/simplePagination.min.css">
<!--page css-->
<link rel="stylesheet" href="${contextPath}/css/trm.page.goods.css" />
<link rel="stylesheet" href="${contextPath}/css/trm.page.equipment.css">
</head>

<body>
	<div class="full-container content">
		<div class="container">
			<div class="row">
				<!--作者：wangxun  描述：面包屑导航 start-->
				<ul class="breadcrumb">
					<li><a href="/">首页</a></li>
					<li><a href="/views/content/equipment/front/advancedSrchlist.jsp">高级检索</a></li>
					<li class="active">检索详情</li>
				</ul>
			</div>
			<!--作者：wangxun  描述：面包屑导航 end-->
			<div class="row">
				<!--作者：wangxun 描述：左侧详情主体 start-->
				<div class="block-inline w-840 data-part">
					<div class="row content-box">
						<div class="detail">
							<div class="slide-pic">
								<div class="goods-pic">
									<ul class="bigImg">
									</ul>
									<div class="smallScroll">
										<span class="sPrev last-img"></span>
										<div class="smallImg">
											<div class="tempWrap">
												<ul>
												</ul>
											</div>
										</div>
										<span class="sNext next-img"></span>
									</div>
								</div>
							</div>
							<div id="goods_detail_info" class="goods-detail-pannel">
								<div class="goods-name" style="padding: 10px 0 0 0;">
								</div>
								<div class="goods-detail">
									<ul>
									</ul>
									<button type="button" class="btn btn-red" id="reserve">立即预约</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="pull-right w-340">
					<div class="row content-box box-hasline">
						<div class="title">
							<dt class="pull-left sname">
								<span id="shop_name">发布机构</span>
							</dt>
						</div>
					</div>
					<div style="height:340px" class="row content-box">
						<div class="detail">
							<div class="shop-info" id="shop_info">
								<ul>	
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="pull-left container data-part">
					<div id="goods_content_info" class="row content-box goods-content-title">
						<div class="title">
							<ul>
						        <li class="active"><a href="#goods_intro_detail">详情指标</a><!-- <i></i> --></li>
						    </ul>
						</div>
					</div>
					<div class="row content-box goods-content">
						<div class="detail" id="goods_intro_detail">
							<ul>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="row content-box">
				<div class="discuss-wrap">
					<p style="color:#000;font-size:16px;margin:0;">精彩在于评论！</p>
					<div class="discuss-area">
						<div class="num-tips"><span id="current_num">0</span><span class="hr-line">|</span>500字</div>
						<textarea id="discuss_detail" class="discuss-text"></textarea>
						<div class="discuss-btn pull-right">评论</div>
					</div>				
				</div>
				<div class="discuss-list">
					<ul id="discuss_ul">
					</ul>
				</div>
				<div class="row pull-center text-center clear">
			         <div id="pagtrade"></div>
			    </div>				
			</div>
		</div>
	</div>
	<!--component js lib-->
	<script src="${contextPath}/js/component/SuperSlide.js"></script>
	<script src="${contextPath}/js/component/bootstrap_modal_confirm.min.js"></script>
	<script src="${contextPath}/js/component/pagination.min.js"></script>
	<!--page js-->
	<script src="${contextPath}/trm_modules/equipment/front/detail.js"></script>
</body>
</html>