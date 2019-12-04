<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8; no-cache">
<link rel="shortcut icon" href="${contextPath}/images/logo.ico" />
<jsp:include page="${contextPath}/views/decorator/common/seo.jsp"/> 
<%
  //设置缓存为空
  response.setHeader("Pragma","No-cache");
  response.setHeader("Cache-Control","no-cache, no-store");
  response.setDateHeader("Expires",   0);
  %>
<%
  if(request.getProtocol().compareTo("HTTP/1.0")==0)
        response.setHeader("Pragma","no-cache");
  else   if(request.getProtocol().compareTo("HTTP/1.1")==0)
        response.setHeader("Cache-Control","no-cache, no-store");
  response.setDateHeader("Expires",0);
  %>
<ora:noCache/>


<jsp:include page="${contextPath}/views/decorator/common/stylesheet.jsp"/>
<jsp:include page="${contextPath}/views/decorator/common/script.jsp"/>
<jsp:include page="${contextPath}/views/decorator/common/login-script.jsp"/>

<!-- 中端样式加载  -->
<link href="${contextPath}/css/trm.theme.front.css" rel="stylesheet" />
<link href="${contextPath}/css/trm.design.front.css" rel="stylesheet" />
<script src="${contextPath}/js/component/validation.js"></script>

<title><sitemesh:write property='title'/></title>
<sitemesh:write property='head'/>

</head>
	<body>
	    <jsp:include page="${contextPath}/views/decorator/login/login-header.jsp"/>   	    	    	    	    
	    <sitemesh:write property='body'/>
	    <jsp:include page="${contextPath}/views/decorator/common/copyright.jsp"/>
	    <script>
		//发布信息click事件
		$(".header-nav").delegate(".publish-equipment","click",function(){
			if(loginCheck()){
				window.open("/views/content/equipment/ucenter/apply.jsp");
			}
		});
		
		//发布需求click事件
		$(".header-nav").delegate(".publish-demand","click",function(){
			if(loginCheck()){
				window.open("/views/content/demand/ucenter/apply.jsp");
			}
		});
		
		//发布需求click事件
		$(".header-nav").delegate(".publish-reportform","click",function(){
			if(loginCheck()){
				window.open("/views/content/quarterly/ucenter/apply.jsp");
			}
		});
		</script>
	 </body>
</html>