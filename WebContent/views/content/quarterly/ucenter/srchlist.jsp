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
<link rel="stylesheet" href="${contextPath}/js/component/laydate_v5.0.9/theme/default/laydate.css" />
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
								<label class="pull-left w-20">所属部门</label>
								<select class="pull-left w-30" id="department" name="department">
									<option value="">请选择...</option>
								</select>
								<label class="pull-left w-20" id="handlerLabel">管理用户</label>
								<select class="pull-left w-30" id="handler" name="handler">
									<option value="">请选择...</option>
								</select>
								
								<div style="width: 100%;height: 30px;clear: both;"></div>
								<label class="pull-left w-20">报表时间(年份)</label>
								<input type="text" class="pull-left w-30" id="validStartDate" placeholder="请输入年份" />
								<label class="hidden"></label>
								
								
								<label class="pull-left w-20">报表时间(季度)</label>
								<select class="pull-left w-30" id="requireType" name="requireType">
									<option value="">请选择...</option>
									<option value="1">第一季度</option>
									<option value="2">第二季度</option>
									<option value="3">第三季度</option>
									<option value="4">第四季度</option>
								</select>
								
								<div style="width: 100%;height: 30px;clear: both;"></div>
								<label class="pull-left w-20">报表状态</label>
								<select class="pull-left w-30" id="audStatus">
									<option selected id="">请选择...</option>
									<option id="F0">未提交</option>
									<option id="F1">已提交</option>
								</select>
								
								<label class="pull-left w-20">填表时间</label>
								<input type="text" class="pull-left" id="audStartDate" placeholder="请输入开始时间" />
								<label class="hidden"></label>
								<label class="pull-left" style="margin-left: 0;">&nbsp;&nbsp;--&nbsp;&nbsp;</label>
								<input type="text" class="pull-left" id="audEndDate" placeholder="请输入结束时间"/>
								<label class="hidden"></label>
								<div class="btn btn-default small highlight" id="mgt_search_btn">查询</div>
							</div>
						</div>
					</div>
					<div class="content-table">
						<table class="table list-box" id="goods_table">
							<thead>
								<tr>
									<td class="tdw70">序号</td>
									<td class="tdw100">填表时间(年)</td>
									<td class="tdw100">填表时间(季度)</td>
									<td class="tdw100">报表名称</td>
									<td class="tdw100">填报时间</td>
									<td class="tdw100">填报人</td>
									<td class="tdw70">报表状态</td>
									<td class="tdw135">操作</td>
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
	<script src="${contextPath}/js/component/laydate_v5.0.9/laydate_v5.0.9.js"></script>	
	<script src="${contextPath}/trm_modules/common/front/option.js"></script>
	<script src="${contextPath}/js/component/json2.js"></script>
    <script src="${contextPath}/js/component/browserdetect.js"></script>
    
	<!--page js-->
	<script src="${contextPath}/trm_modules/common/ucenter/leftnav.js"></script>
	<script src="${contextPath}/trm_modules/quarterly/ucenter/srchlist.js"></script>
</body>
</html>

