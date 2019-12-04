<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags'%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<sec:authentication property="principal" var="principal"/>

<style>
	.navbar-right .btn-bar {
    	margin: 0;
	}
	.links {
		display:inline-block;
		font-size:16px;
		width:70px;
		height:40px;
		line-height:40px;
		text-align:center;
		text-decoration: none;
		cursor: pointer;
		margin-top:20px;
		border:1px solid #04a89d;
	}
	.links.link-login {
	    color: #04a89d;
	}
	.links.link-reg {
	    color: #fff;
	    background-color: #04a89d;
	    margin-left:20px;
	    margin-right:20px;
	}
	.links:hover {
	    -webkit-transition: all 0.2s ease;
	    -moz-transition: all 0.2s ease;
	    transition: all 0.2s ease;
	    background-color: #04a89d;
	    color: #fff;
	}
	.header-btn {
		width:49px;
		height:48px;
		display:inline-block;
		margin-right:-4px;
		margin-top:16px;
		background:url(/images/topbar/home-icon.png) center no-repeat;
		cursor:pointer;
	}
	.header {
	    background: transparent;
	}
	.headerbg .header .navbar-nav {
	    margin: 24px -6px 0 20px !important;
	}
	.navbar-right {
	    margin-right: 11px;
	    margin-top: 0;
	}
	.navbar-right label{
	    color:#fff;
	}
</style>

<div class="full-container headerbg">
	<div class="container header">
		<!-- <div class="pull-left">
			<a href="/">
				<img style="height: 90px;" src="/images/logo_black.png" />
			</a>
		</div> -->
		<div class="header-nav" style="display:inline-block;">
			<ul class="navbar-nav">
				<li><a class="active" href="/views/content/homeNew.jsp">首页</a></li>
				<li><a href="/views/content/news/front/srchlist.jsp">新闻资讯</a></li>
				<li><a href="/views/content/equipment/front/srchlist.jsp">军民共享资源</a></li>
				<li><a href="/views/content/demand/front/srchlist.jsp">军民融合需求</a></li>

				<li><a href="/views/content/onload.jsp">下载中心</a></li>

				<li><a href="/views/content/department/front/srchlist.jsp">军民融合技术服务机构</a></li>
				
				<li id="reply"><a href="/views/content/interaction/front/srchlist.jsp">互动交流</a>
					<div class="replyShow">
						<span class="write">我要留言</span>
						<span class="see">查看留言</span>
					</div>
				</li>
			</ul>
			
			
		</div>		
		<div class="navbar-right">
			 <c:choose>
			    <c:when test="${principal=='anonymousUser' || principal == null}">
			    <div class="btn-bar" id="register_part"><a class="links link-reg">注册</a></div>
				<div class="btn-bar" id="login_part"><a class="links link-login">登录</a></div>
			    </c:when>			      
			    <c:otherwise>
			    <div class="btn-bar btn-bar-div" id="login_part" style="margin-top: 10px;">
					<a href="${contextPath}/views/content/personal/ucenter/main.jsp">
						<img class="pc-img" src="${principal.session.headPortrait}"/>
						<label style="margin-left: 10px;">${principal.session.username}</label>
					</a>
					<div class="personal-center" id="personal_center">
						<div class="pc-header">
							<i class="triangle-icon-1"></i>
							<i class="triangle-icon-2"></i>
							<img class="pc-img-span" src="${principal.session.headPortrait}"/>
							<span class="pc-name-span">
								<span class="pc-name">
									<a href="${contextPath}/views/content/personal/ucenter/main.jsp">${principal.session.username}</a>
								</span>
								<span class="signature">欢迎光临!</span>
							</span>	
						</div>
						<div class="pc-content">
							<ul>
								<li><a href="${contextPath}/views/content/personal/ucenter/basicInformation.jsp"><i class="personal-center-icon"></i>个人信息</a></li>
								<li class="no-border"><a href="${contextPath}/views/content/personal/ucenter/authentication.jsp"><i class="identity-icon"></i>密码管理</a></li>
							</ul>
							<ul>
								<li><a href="${contextPath}/views/content/personal/ucenter/messages.jsp"><i class="information-icon"></i>我的消息</a></li>
								<li class="no-border"><a href="${contextPath}/views/content/follow/ucenter/srchlist.jsp"><i class="collect-home-icon"></i>我的关注</a></li>
							</ul>
							<a href="${contextPath}/logout.action" class="exit" id="exit3">退出</a>
						</div>
					</div>
				</div>
				<script>
				(function () {
					var oA = document.getElementById("exit3");
					oA.onclick = function(){
						window.localStorage.removeItem("userStatus");
					}
				})()
				</script>
			    </c:otherwise>
			</c:choose>
		</div>
	</div>
</div>