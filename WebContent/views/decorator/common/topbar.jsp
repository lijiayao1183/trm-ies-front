<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags'%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<sec:authentication property="principal" var="principal"/>
<!-- start topbar -->
<style>
	.topbar-header{
	    background-color: #323232;
	}
	.topbar-header a{
	    color: #fff;
	}
</style>

<div class="full-container topbar-header">
	<div class="container">
		<div class="">
			<div class="topbar left">
				<span><a href="/">陕西军民融合科技创新资源开放共享管理服务平台</a></span>
			</div>
			<div class="topbar right">
			 <c:choose>
		        <c:when test="${principal=='anonymousUser'}">
		        <span id="login_part"><a>登录</a></span>
				<span class="hr-line">|</span>
				<span id="register_part"><a>注册</a></span>
		        </c:when>
		        <c:otherwise>
		        <span id="register_part">
					<a href="/">首页</a>
				</span>
		        <span class="hr-line">|</span>
		        <span class="default-color" id="login_part">
		        	<a style="cursor:default">欢迎您 ${principal.session.username}</a>
		        </span>
				<span class="hr-line">|</span>
				<span id="register_part">
					<a href="${contextPath}/logout.action" id="exit2">退出</a>
				</span>
				<script>
				(function () {
					var oA = document.getElementById("exit2");
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
 </div>
<!---topbar end--->
