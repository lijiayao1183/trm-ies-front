<!--
	@page 我的消息
	@author yinzheng
	@init-time 2017-11-1
	@history 新建页面	v1.0
-->
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>个人中心-系统消息</title>
		<!-- 引入组件级别css文件 -->
		<link rel="stylesheet" href="${contextPath}/css/component/simplePagination.min.css" />
		
		<!--page css-->
		<link rel="stylesheet" href="${contextPath}/css/trm.page.goods.css" />
		<link rel="stylesheet" href="${contextPath}/css/trm.page.personalCenter.css" />
	</head>

	<body>
		<div class="full-container content">
			<div class="container">
				<!--左侧菜单列表  start-->
				<jsp:include page="${contextPath}/views/decorator/common/left-nav.jsp"/>
				<!--左侧菜单列表  end-->
				<!--作者：wangxun 描述    系统消息   start-->
				<div class="ucenter-content  pull-right">
					<div class="row content-box">
						<div class="tool-bar" style="margin-top:20px;padding-right:53px;">
							<div class="pull-left pos-relative select-area">
								<select id="msg_status" class="form-control">
									<option code="">全部</option>
									<option code="Y">已读</option>
									<option code="N" selected>未读</option>
								</select>
								<span class="select-cell-msg" style="pointer-events: none;"></span>     <!--modefy by sunfang 2016-12-2  -->

							</div>
							<div class="pull-left">
								<label for="content_field" style="margin-left:20px;margin-right:8px;line-height:28px;">内容关键字:</label>
								<input type="text" id="content_field" name="content_field" style="height:28px;padding:0 6px;margin-right:20px;" />
							</div>
							<div class="pull-left">
								<label style="line-height:28px;">时间区间</label>
								<input type="text" id="startTime_box" style="width:120px;height:28px;padding:0 6px;" />-<label class="hidden"></label><input type="text" id="endTime_box" style="width:120px;height:28px;padding:0 6px;" /><label class="hidden"></label>							
							</div>
							
							<div class="pull-right searbtn" style="height:28px;background-color:#419ff6;text-align:center;padding:0 10px;color:#fff;line-height:28px;border:1px solid #419ff6; border-radius:4px;cursor:pointer;">
								查询
							</div>
						</div>
						<div class="content-table msg-content-table">
							<!-- <div class="unread-tip">未读系统通知 ： <span class="tips-color unread-sum"></span></div> -->
							<div class="msg-list"></div>
							<div class="error-msg"></div>
							<div class="buttom-bar">
								<div class="pull-left">
								     <span class="span-checkbox select-all">
								     	<input type="checkbox" id="select_all" class="radioclass input" autocomplete="off">
								     </span>
							         <label>全选</label>
							    </div>
							    <span class="hr-line">|</span>
								<span class="mark-all-read"><a>标记为已读</a></span>
								<span class="hr-line">|</span>
								<span class="del-all"><a>批量删除</a></span>
							</div>
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
		
		<!--page js-->
		<script src="${contextPath}/trm_modules/common/ucenter/leftnav.js"></script>
		<script src="${contextPath}/trm_modules/personal/ucenter/messages.js"></script>
	</body>
</html>