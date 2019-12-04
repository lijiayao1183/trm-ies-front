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
<title>联系我们</title>
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
					<li flagCode="1" >网站申明</li>
					<li flagCode="2">关于我们</li>
					<li flagCode="3" class="active">联系我们</li>
				</ul>
			</div>
			
			<div class="pull-right content-wrap">
				<h4>陕西军民融合科技创新资源开放共享管理服务平台</h4>
				<img alt="" src="${contextPath}/images/footer_pic_contactus.png">
				<p>陕西省国防科技工业办公室</p>   
				<p>地址 ：西安市雁塔区翠华路107号</p>
				<p>联系电话：029-85735564</p>
				<div id="map" style="width: 100%;height: 380px;"></div> 	
			</div>
		</div>
	</div>

	<script src="${contextPath}/trm_modules/footer/front/footer.js"></script>
	<script>
		function initialize() {  
			  var mp = new BMap.Map('map');  
			  var point = new BMap.Point(108.963306, 34.224975);
			  mp.centerAndZoom(point, 15);
			  var marker = new BMap.Marker(point);
			  mp.addOverlay(marker);
		}  
		   
		function loadScript() {  
			var script = document.createElement("script");  
			script.src = "http://api.map.baidu.com/api?v=2.0&ak=B6Vf8sL79Uri3CrOVxIPGQpXnGnxy1BS&callback=initialize";
			document.body.appendChild(script);  
		}  
		   
		window.onload = loadScript;
	</script>
</body>
</html>