<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<style>
	.headerbg {
		background-color:#419ff6 /* #58c4f9 */;
	}
	.headerbg .header {
		padding: 0;
		background-color:#419ff6 /* #58c4f9 */;
		color: #fff;
	}
	.headerbg .header-nav{
		height: 80px;
		line-height: 80px;
	}

</style>

<div class="full-container headerbg">
	<div class="container header">
		<div class="pull-left">
			<a href="/" style="">
				<img style="height: 80px;border: 1px solid #419ff6;" src="/images/logo_white.png" />
			</a>
		</div>
		<div class="header-nav">
			<ul class="navbar-nav">
				<li><a href="/views/content/personal/ucenter/main.jsp">主页</a></li>
				<li><a href="/views/content/personal/ucenter/messages.jsp">消息</a></li>
				<li><a class="active" href="/views/content/follow/ucenter/srchlist.jsp">关注</a></li>
			</ul>
		</div>
	</div>
</div>	
<!---logo end--->
