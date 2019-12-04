<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8; no-cache">
<title>修改密码</title>
<!--page css  -->
<link rel="stylesheet" href="${contextPath}/css/ies/trm.page.findpassword.css">
<script>
	$(document).ready(function(){
		$(".welcome").html("修改密码");
	});
</script>
</head>
<body>
	<div class="full-container">
		<div class="container content-box" style="margin-top:30px;margin-bottom:30px;min-height:600px;">
		
			<div class="fp-wrap" id="change-pwd">
				<div class="fp-title">账号安全</div>
				<div class="fp-content">
					<p style="text-align:left;font-size:20px;font-weight:bold;padding-left:215px;margin-bottom:50px;">请输入新密码</p>
					
						<div class="form-group">
							<div class="single-column">
								<label class="vereist" for="register_login_mm_filed" style="line-height:42px;">新密码:</label>
								<input type="text" class="form-control pull-left" id="register_login_mm_filed" name="register_login_mm_filed" placeholder="建议至少使用两种字符组合" />
								<div class="error-tips"></div>
							</div>
						</div>	
						
						<div class="form-group">
							<div class="single-column">
								<label class="vereist" for="register_login_mm_copy_filed" style="line-height:42px;">确认密码:</label>
								<input type="text" class="form-control pull-left" id="register_login_mm_copy_filed" name="register_login_mm_copy_filed" placeholder="请确认密码" />
								<div class="error-tips"></div>
							</div>
						</div>									
				
					<div class="next-step-btn" id="step1">下一步</div>
				</div>
			</div>	
			
			<div class="fp-wrap hidden" id="success-modify">
				<div class="fp-title">账号安全</div>
				<div class="fp-content">
					<p style="font-size:28px;color:#666;">密码重置成功</p>
					<p style="font-size:16px;">您的密码已重置成功，可用新密码进行登录</p>
					<div class="next-step-btn" id="step2">登录</div>
				</div>
			</div>								
			
		</div>
	</div>
	<!--component js lib-->
	<script src="${contextPath}/js/component/bootstrap_modal_confirm.min.js"></script>
	<script src="${contextPath}/js/component/jquery.md5.js"></script>
	<!--page js-->
	<script src="${contextPath}/trm_modules/login/front/changepassword.js"></script>
</body>
</html>