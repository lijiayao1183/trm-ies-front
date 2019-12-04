<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<style>
	.welcome{
		font-size: 24px;
	    color: #444;
	    position: relative;
	    top:40px;
	    display:inline-block;
	}
	.company {
		font-size: 18px;
		color:#444;
		position:relative;
		top:70px;
		font-weight:600;
		display:inline-block;
		left:-100px;
	}
	.masker{
	   margin-top: 0;
	}
	.right-bar {
		line-height:110px;
		font-size:16px;
		color:#333;
		
	}
	.right-bar span{
		display:inline-block;
		padding:0 3px;
	}
	.right-bar .sep-line {
		width:1px;
		height:16px;
		background-color:#333;
		padding:0;
		position:relative;
		top:3px;
		
	}
</style>
<div class="full-container header" style="background: #fff;padding: 0;height:120px;">  <!-- new-logo -->
	<div class="container">
		<nav class="navbar navbar-default">
		    <div class="pull-left" style="margin-top: 20px;">
				<div class="masker">
					<a href="/" target="_blank" style="text-decoration:none;">
						<img src="/images/logo_black.png" style="height:80px;"/>
					</a>
				</div>
			</div>
			<span class="welcome" style="margin-left:20px;"></span>
			<div class="pull-right right-bar">
				<span><a href="/">返回首页</a></span>
				<!-- <span class="sep-line"></span>
				<span><a href="#">帮助中心</a></span> -->
			</div>
		</nav>
	</div>
</div>
	
