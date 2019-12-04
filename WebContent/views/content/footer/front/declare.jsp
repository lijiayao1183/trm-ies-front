<!--
	@page 网站申明
	@author xuxingjie
	@init-time 2017-11-14
	@history 新建页面	v1.0
-->
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>网站申明</title>
<!--page css-->
<link rel="stylesheet" href="${contextPath}/css/trm.page.goods.css" />
<link rel="stylesheet" href="${contextPath}/css/trm.page.footersite.css">

</head>
<body>
	<div class="full-container content" style="margin:0;border-top:2px solid #419ff6;">
		<div class="full-container">
			<img class="banner-pic" style="height: 400px" src="${contextPath}/images/footer_banner.png">
		</div>
		<div class="container m__t--50">
			<div class="pull-left sidebar">
				<ul>
					<li flagCode="1" class="active">网站申明</li>
					<li flagCode="2">关于我们</li>
					<li flagCode="3">联系我们</li>
				</ul>
			</div>
			
			<div class="pull-right content-wrap">
				<h4>陕西军民融合科技创新资源开放共享管理服务平台</h4>
				<img alt="" src="${contextPath}/images/footer_pic_declare.png">
				<p>本平台所展示的共享设备设施信息和资料均由持有单位提供，本平台对或资料的准确性、完整性、合法性、可靠性、可操作性或可用性不承担任何责任，同时对平台中任何信息或资料的删除、存储失败、错误提供或未及时提供不承担任何责任。对因通过服务下载或访问平台上的任何信息或资料而导致的任何伤害不承担任何责任。</p>
			</div>
		</div>
	
	</div>
	<script src="${contextPath}/trm_modules/footer/front/footer.js"></script>
</body>
</html>