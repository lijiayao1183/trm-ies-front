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
					<div class="mgt-tool-bar" style="margin-bottom: 0;">
						<div class="mgt-tool-bar" style="overflow:visible;">
							<div class="search-bar">
								<label class="pull-left w-20">所属部门：</label>
								<select class="pull-left w-30" id="department" name="department">
									<option value="">请选择...</option>
								</select>
								<label class="pull-left  w-20" id="handlerLabel">管理用户：</label>
								<select class="pull-left w-30" id="handler" name="handler">
									<option value="">请选择...</option>
								</select>
								<div style="width: 100%;height: 30px;clear: both;"></div>
								<!--  -->
								<label class="pull-left w-20">标题：</label>
								<input type="text" class="pull-left w-30" id="requireName"/>
								
								<label class="pull-left w-20">回复状态：</label>
								<select class="pull-left w-30" id="requireType" name="requireType">
									<option value="">请选择...</option>
									<option value="N">未回复</option>
									<option value="Y">已回复</option>
								</select>
								
								<div class="btn btn-default small highlight" id="mgt_search_btn">查询</div>
							</div>
						</div>
					</div>
					<div class="content-table">
						<table class="table list-box" id="goods_table">
							<thead>
								<tr>
									<td class="tdw70">序号</td>
									<td class="tdw100">标题</td>
									<td class="tdw100">所属部门</td>
									<td class="tdw100">用户名</td>
									<td class="tdw100">留言时间</td>
									<td class="tdw100">回复时间</td>
									<td class="tdw100">回复状态</td>
									<td class="tdw70">操作</td>
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
	<script src="${contextPath}/trm_modules/interaction/ucenter/srchlist.js"></script>
</body>
</html>

