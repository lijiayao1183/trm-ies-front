<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="陕西军民融合科技创新资源开放共享管理服务平台" content="" />
    <title>陕西军民融合科技创新资源开放共享管理服务平台</title>
    <!--page css  -->
    <link rel="stylesheet" href="${contextPath}/css/ies/trm.page.homeNew.css">

    <link rel="stylesheet" href="${contextPath}/js/component/swiper/css/swiper.min.css">
    <jsp:include page="${contextPath}/views/decorator/common/script.jsp"/>
</head>
<body>
    <div id="container">
        <div><span  id="itemTitle"></span></div>
        <div id="itemContent"></div>
    </div>
<script src="${contextPath}/js/component/swiper/js/swiper.min.js"></script>
<!--引入 js-->
<script src="${contextPath}/js/component/SuperSlide.js"></script>
<script src="${contextPath}/trm_modules/newestList.js"></script>
</body>

</html>