<%--
 * @page 个人中心首页
 * @author 徐星杰
 * @init-time 2017-10-25
 * @history 新建文档	v1.0
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags'%>
<sec:authentication property="principal" var="principal"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人中心首页</title>
<style>
	.card{
		display: inline-block;
	    width: 48%;
	    height: 120px;
	    padding: 15px;
	    text-align: center;
	    background-color: #fff;
	    border-radius: 6px;
	    background-repeat: no-repeat;
	    background-position: 30px center;
	    margin-right: 15px;
	    margin-bottom: 15px;
	}
	.card.card-device{
		background-image: url("../../../../images/icon_device.png");
	}
	.card.card-follow{
		background-image: url("../../../../images/icon_follow.png");
	}
	.card.card-comment{
		background-image: url("../../../../images/icon_edit.png");
	}
	.card.card-message{
		background-image: url("../../../../images/icon_msg.png");
	}
	.card.card-require{
		background-image: url("../../../../images/icon_reqest.png");
	}
	.card.card-users{
		background-image: url("../../../../images/icon_users.png");
	}
	.card.card-reply{
		background-image: url("../../../../images/icon_replys.png");
	}
	.card h3,.card p{
		width: 100%;
		padding-left: 80px;
	}
	.avatar-wrap{
		height: 80px;
	    width: 80px;
	    text-align: center;
	    display: inline-block;
	    padding-top: 5px;
	    border-radius: 50%;
	    margin-left: 20px;
	}
	.avatar-wrap img{
		width: 70px;
		height: 70px;
		border-radius: 50%;
	}
	.user-name{
    	overflow: hidden;
    	line-height: 80px;
		margin-left: 20px;
	}
	
</style>
<!-- 引入页面级别css文件 -->
<link rel="stylesheet" href="${contextPath}/css/trm.page.personalCenter.css" />
</head>
<body>
	<div class="full-container content">
		<div class="container">
			<!--作者：wangxun 描述：左侧菜单列表  start-->
			<%@ include file="/views/decorator/common/left-nav.jsp" %>
			<!--作者：wangxun 描述：左侧菜单列表  end-->
			
			<div class="ucenter-content pull-right">
				<div class="row content-box index-user-info" style="width: 98%;">
					<div class="avatar-wrap">
						<a href="${contextPath}/views/content/personal/ucenter/basicInformation.jsp">
							<img class="pc-img" src="${principal.session.headPortrait}"/>
						</a>
					</div>
					<div class="user-name">欢迎您，${principal.session.username}</div>
				 </div>
				 
				<div class="row mgt-content-box" style="position: relative;">
				   	<div class="card card-device">
				   		<a href="${contextPath}/views/content/equipment/ucenter/srchlist.jsp">
					   		<p >我的设备</p>
					   		<h3 id="deviceCount">--</h3>
				   		</a>
				   	</div>
				   	<div class="card card-follow">
				   		<a href="${contextPath}/views/content/follow/ucenter/srchlist.jsp">
					   		<p >我的关注</p>
					   		<h3 id="followCount">--</h3>
				   		</a>
				   	</div>
				   	<div class="card card-comment">
				   		<a href="${contextPath}/views/content/comment/ucenter/srchlist.jsp">
					   		<p >我的评论</p>
					   		<h3 id="commentCount">--</h3>
				   		</a>
				   	</div>
				   	<div class="card card-message">
				   		<a href="${contextPath}/views/content/personal/ucenter/messages.jsp">
					   		<p >我的消息</p>
					   		<h3 id="msgCount">--</h3>
				   		</a>
				   	</div>
				   	<div class="card card-require">
				   		<a href="${contextPath}/views/content/demand/ucenter/srchlist.jsp">
					   		<p >我的需求</p>
					   		<h3 id="reqCount">--</h3>
				   		</a>
				   	</div>
				   	<div class="card card-users">
				   		<a href="${contextPath}/views/content/usermgt/ucenter/srchlist.jsp">
					   		<p >我的用户</p>
					   		<h3 id="userCount">--</h3>
				   		</a>
				   	</div>
				   	<div class="card card-reply">
				   		<a href="${contextPath}/views/content/interaction/ucenter/srchlist.jsp">
					   		<p >互动交流</p>
					   		<h3 id="replyCount">--</h3>
				   		</a>
				   	</div>
				  
			 	</div>	
			</div>
		</div>
	</div>

	<!-- 引入组件js库 -->
	<script src="${contextPath}/js/component/bootstrap_modal_confirm.min.js"></script>
	
	<!-- 引入页面js库 -->
	<script src="${contextPath}/trm_modules/common/ucenter/leftnav.js" defer></script>
	<script src="${contextPath}/trm_modules/personal/ucenter/main.js"></script>
</body>
</html>