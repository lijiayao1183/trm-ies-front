<!--
	@page 资讯详情
	@author yinzheng
	@init-time 2017-10-18
	@history 新建页面	v1.0
-->
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%-- <c:set var="contextPath" value="${pageContext.request.contextPath}" /> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- <!DOCTYPE html>   -->
<html>  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>  
<title>在线预览PDF文档</title>  
<link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap.min.css">  
<script type="text/javascript" src="js/jquery.min.js"></script>  
<script type="text/javascript" src="js/jquery.media.js"></script>  
<script type="text/javascript">  
    $(function() {  
        $('a.media').media({width:800, height:600});  
        $('a.mediase').media({width:800, height:600});  
    });  
</script> 

</head>
<body>
<center>
 <div class="panel panel-primary">
   <div class="panel-heading" align="center">
      <h2>预览pdf文件</h2>
   </div>
   <div class="panel-body">
	  <a class="media" href="yulan.pdf"></a>  
   </div>
</center>
</body>
</html>