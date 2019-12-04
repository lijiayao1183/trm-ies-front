<!--
	@page add mydevice page for list
	@author xuxingjie
	@init-time 2016-10-30
	@history 新建页面	v1.0
-->
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人中心-基本信息-我的评论</title>
<!-- 引入组件级别css文件 -->
<link rel="stylesheet" href="${contextPath}/css/component/simplePagination.min.css" />
<!-- 引入页面级别css文件 -->
<link rel="stylesheet" href="${contextPath}/css/trm.page.goods.css" />
<link rel="stylesheet" href="${contextPath}/css/trm.page.personalCenter.css" />
<link rel="stylesheet" href="${contextPath}/css/trm.page.mydevice.css" />

</head>
<body>
	<div class="full-container content">
		<div class="container">
			<!--左侧菜单列表  start-->
			<jsp:include page="${contextPath}/views/decorator/common/left-nav.jsp"/>
			<!--左侧菜单列表  end-->
			
			<div class="ucenter-content  pull-right">
				<div class="row content-box">
					<div class="mgt-tool-bar">
						<div class="search-bar">
							<label class="pull-left">设备设施名称</label>
							<input type="text" class="pull-left" id="equipName"/>
							<label class="pull-left">评论内容</label>
							<input type="text" class="pull-left" id="evaluation"/>
							<div style="width: 100%;height: 30px;clear: both;"></div>
							<label class="pull-left">发表时间</label>
							<input type="text" class="pull-left" id="startDate" placeholder="请输入开始时间" />
							<label class="hidden"></label>
							<label class="pull-left" style="margin-left: 0;">&nbsp;&nbsp;--&nbsp;&nbsp;</label>
							<input type="text" class="pull-left" id="endDate" placeholder="请输入结束时间"/>
							<label class="hidden"></label>
							<div class="btn btn-default small highlight" id="mgt_search_btn">查询</div>
						</div>
					</div>
					<div class="content-table">
						<table class="table list-box" id="goods_table">
							<thead>
								<tr>
									<td class="tdw70">序号</td>
									<td>设备设施名称</td>								
									<td>评论内容</td>
									<td>发表时间</td>
									<td>操作</td>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
						<div class="error-msg"></div>
					</div>
					<div class="page-turn text-center">
						<div id="pagtrade"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 引入组件js库 -->
	<script src="${contextPath}/js/component/bootstrap_modal_confirm.min.js"></script>
    <script src="${contextPath}/js/component/pagination.min.js"></script>
	<script src="${contextPath}/js/component/laydate.dev.min.js"></script>	
	<script src="${contextPath}/trm_modules/common/front/option.js"></script>
	<script src="${contextPath}/js/component/bootstrap-typeahead.js"></script>
	<script src="${contextPath}/js/component/json2.js"></script>
    <script src="${contextPath}/js/component/browserdetect.js"></script>
    
	<!--page js-->
	<script src="${contextPath}/trm_modules/common/ucenter/leftnav.js"></script>
	<script src="${contextPath}/trm_modules/comment/ucenter/srchlist.js"></script>
</body>
</html>