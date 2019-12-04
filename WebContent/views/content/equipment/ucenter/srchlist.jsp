<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人中心-设备管理-我的设备</title>
<!-- 引入组件级别css文件 -->
<link rel="stylesheet" href="${contextPath}/css/component/simplePagination.min.css" />
<!-- 引入页面级别css文件 -->
<link rel="stylesheet" href="${contextPath}/css/trm.page.goods.css" />
<link rel="stylesheet" href="${contextPath}/css/trm.page.mydevice.css" />

<style>
	#batch_upload{
    	position: absolute;
    	top: 0;
    	left: 0;
    	font-size: 0;
    	display: block;
    	width: 100%;
    	height: 100%;
    	cursor: pointer;
    	opacity: 0;
    	filter: alpha(opacity=0);
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
							<select class="pull-left" id="department" name="department">
								<option value="">请选择...</option>
							</select>
							<label class="pull-left" id="handlerWrap">管理用户</label>
							<select class="pull-left" id="handler" name="handler">
								<option value="">请选择...</option>
							</select>
							<div style="width: 100%;height: 30px;clear: both;"></div>
							<label class="pull-left">设备设施类别</label>
							<select class="pull-left" id="deviceFunction">
								<option selected>请选择...</option>
							</select>
							<label class="pull-left">设备设施名称</label>
							<input type="text" class="pull-left" id="equipName"/>
							<label class="pull-left">审核状态</label>
							<select class="pull-left" id="statusItem">
								<option value="">请选择...</option>
								<option value="F0">用户-未提交</option>
								<option value="F1">用户-待审核</option>
								<option value="A2">单位-已通过</option>
								<option value="A3">单位-未通过</option>
								<option value="F2">平台-已通过</option>
								<option value="F3">平台-未通过</option>
								<option value="N">已下架</option>
							</select>
							<div style="width: 100%;height: 30px;clear: both;"></div>
							<label class="pull-left">审核时间</label>
							<input type="text" class="pull-left" id="audStartTime" placeholder="请输入开始时间" />
							<label class="hidden"></label>
							<label class="pull-left" style="margin-left: 0;">&nbsp;&nbsp;--&nbsp;&nbsp;</label>
							<input type="text" class="pull-left" id="audEndTime" placeholder="请输入结束时间"/>
							<label class="hidden"></label>
							<div class="btn btn-default small highlight" id="mgt_search_btn">查询</div>
							<div class="btn btn-default small highlight" id="mould_download_btn">模板下载</div>
							<div class="btn btn-default small highlight" style="position:relative;">
								<input type="file" id="batch_upload" name="batch_upload">
								<span>批量导入</span>
							</div>
						</div>
					</div>
					<div id="progress1" style="width:100%;height:2px;">
						<div class="bar" style="background-color:red;height:2px;"></div>
					</div>
					<div class="content-table">
						<table class="table list-box" id="goods_table">
							<thead>
								<tr>
									<td>序号</td>
									<td>设备设施名称</td>								
									<td>设备设施类别</td>
									<td class="tdw70">所属部门</td>
									<td>管理用户</td>
									<td>审核时间</td>
									<td>审核状态</td>
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
	<script src="${contextPath}/js/component/bootstrap3-typeahead.js"></script>
	<script src="${contextPath}/js/component/json2.js"></script>
    <script src="${contextPath}/js/component/browserdetect.js"></script>
    
	<script src="${contextPath}/js/component/jquery.ui.widget.min.js"></script>
	<script src="${contextPath}/js/component/jquery.iframe-transport.min.js"></script>
	<script src="${contextPath}/js/component/jquery.fileupload.js"></script>    
	<!--page js-->
	<script src="${contextPath}/trm_modules/common/ucenter/leftnav.js"></script>
	<script src="${contextPath}/trm_modules/equipment/ucenter/srchlist.js"></script>
</body>
</html>

