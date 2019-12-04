<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="viewport" content="width=device-width" />
		<jsp:include page="${contextPath}/views/decorator/common/seo.jsp"/> 
		
		<jsp:include page="${contextPath}/views/decorator/common/stylesheet.jsp"/>
		<jsp:include page="${contextPath}/views/decorator/common/script.jsp"/>
		<link href="${contextPath}/css/trm.theme.ucenter.css" rel="stylesheet" />
		<link href="${contextPath}/css/trm.design.ucenter.css" rel="stylesheet" />
	    <title>
	       <sitemesh:write property='title' />  
	    </title>
	    <sitemesh:write property='head'/>
	</head>
	<body>
	    <jsp:include page="${contextPath}/views/decorator/common/topbar.jsp"/>
	    <jsp:include page="${contextPath}/views/decorator/common/ucenter-header.jsp"/>
	    <div class="full-container">	    
	        <sitemesh:write property='body'/>
	    </div>
	    <jsp:include page="${contextPath}/views/decorator/common/copyright.jsp"/>
	 </body>
</html>