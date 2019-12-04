<!--
	@page add mydevice page for list
	@author xuxingjie
	@init-time 2017-11-30
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
<title>个人中心-服务机构管理-我的机构</title>
<!-- 引入组件级别css文件 -->
<link rel="stylesheet" href="${contextPath}/css/component/simplePagination.min.css" />
<!-- 引入页面级别css文件 -->
<link rel="stylesheet" href="${contextPath}/css/trm.page.goods.css" />
<link rel="stylesheet" href="${contextPath}/css/trm.page.personalCenter.css" />
<link rel="stylesheet" href="${contextPath}/css/trm.page.mydevice.css" />
<style>
	.content-table .tdw160 {
    	width: 160px;
    	min-width: 160px;
	}
</style>

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
							<label class="pull-left">所属部门</label>
							<select class="pull-left" id="department">
								<option value="">请选择...</option>
							</select>
							<label class="pull-left">管理用户</label>
							<input type="text" class="pull-left" id="handler"/>
							<label class="pull-left">机构性质</label>
							<select class="pull-left" id="property">
								<option value="">请选择...</option>
								<option value="企业">企业</option>
								<option value="科研院所">科研院所</option>
								<option value="高等院校">高等院校</option>
								<option value="其他">其他</option>
							</select>
							<div style="clear: both;height: 30px;"></div>
							<label class="pull-left">机构名称</label>
							<input type="text" class="pull-left" id="orgName"/>
							<label class="pull-left">服务类型</label>
							<input type="text" class="pull-left" id="servType"/>
							<label class="pull-left">机构属性</label>
							<select class="pull-left" id="attribute">
								<option value="">请选择...</option>
								<option value="国有">国有</option>
								<option value="集体">集体</option>
								<option value="民营">民营</option>
								<option value="其他">其他</option>
							</select>
							<div style="clear: both;height: 30px;"></div>
							<label class="pull-left">审核时间</label>
								<input type="text" class="pull-left" id="audStartDate" placeholder="请输入开始时间" />
								<label class="hidden"></label>
								<label class="pull-left" style="margin-left: 0;">&nbsp;&nbsp;--&nbsp;&nbsp;</label>
								<input type="text" class="pull-left" id="audEndDate" placeholder="请输入结束时间"/>
								<label class="hidden"></label>
							<label class="pull-left">审核状态</label>
							<select class="pull-left" id="audStatus">
								<option value="">请选择...</option>
								<option value="F0">用户-未提交</option>
								<option value="F1">用户-待审核</option>
								<option value="A2">单位-已通过</option>
								<option value="A3">单位-未通过</option>
								<option value="F2">平台-已通过</option>
								<option value="F3">平台-未通过</option>
							</select>
							<div class="btn btn-default small highlight" id="mgt_search_btn">查询</div>
						</div>
					</div>
					<div class="content-table">
						<table class="table list-box" id="goods_table">
							<thead>
								<tr>
									<td class="tdw70">序号</td>
									<td class="tdw115">机构名称</td>								
									<td class="tdw115">所属部门</td>
									<td class="tdw115">管理用户</td>
									<td class="tdw115">服务类型</td>
									<td class="tdw100">审核时间</td>
									<td class="tdw115">审核状态</td>
									<td class="tdw160">操作</td>
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
	<script src="${contextPath}/js/component/json2.js"></script>
    <script src="${contextPath}/js/component/browserdetect.js"></script>
    
	<!--page js-->
	<script src="${contextPath}/trm_modules/common/ucenter/leftnav.js"></script>
	<script src="${contextPath}/trm_modules/laboratory/ucenter/srchlist.js"></script>
</body>
</html>

