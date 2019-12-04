<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8; no-cache">
<title>找回密码</title>
<!--page css  -->
<link rel="stylesheet" href="${contextPath}/css/ies/trm.page.findpassword.css">
<script>
	$(document).ready(function(){
		$(".welcome").html("找回密码");
	});
</script>
</head>
<body>
	<div class="full-container">
		<div class="container content-box" style="margin-top:30px;margin-bottom:30px;min-height:600px;">
		
			<div class="fp-wrap" id="fp_method">
				<div class="fp-title">账号安全</div>
				<div class="fp-tips">如果你的账号是由单位管理员创建，请联系单位管理员进行密码修改重置！</div>
				<div class="fp-content">
					<span class="fp-tips">密码找回方式:</span>
					<input type="radio" checked id="question" name="question" />
					<label text="step1" for="question">安全问题</label>
					<input type="radio" id="email" name="question" />
					<label text="step1" for="email">邮箱验证</label>	
					<div class="next-step-btn" id="step1">下一步</div>
				</div>
			</div>
			
			<div class="fp-wrap hidden" id="validate-problem">
				<div class="fp-title">账号安全</div>
				<div class="fp-content">
					<p style="text-align:left;font-size:20px;font-weight:bold;padding-left:215px;margin-bottom:50px;">安全验证问题</p>
					
					<div class="form-group">
						<div class="single-column">
							<label class="vereist" for="username_filed">用户名:</label>
							<input type="text" class="form-control" id="username_filed" name="username_filed" placeholder="请输入您的用户名" />
							<div class="error-tips"></div>					
						</div>
					</div>
	
					<div class="form-group">
						<div class="single-column">
							<label class="vereist" for="safe_tips_filed">安全提示问题:</label>
							<select class="form-control" id="safe_tips_filed" name="safe_tips_filed">
								<option selected disabled>--请选择安全提示问题--</option>
								<option text="请问您上的哪一所小学？">1.请问您上的哪一所小学？</option>
								<option text="请问您上的哪一所初中？">2.请问您上的哪一所初中？</option>
								<option text="请问你上的哪一所高中？">3.请问你上的哪一所高中？</option>
								<option text="请问你上的哪一所大学？">4.请问你上的哪一所大学？</option>
								<option text="请问您的出生地？">5.请问您的出生地？</option>
								<option text="请问您的父亲名字？">6.请问您的父亲名字？</option>
								<option text="请问您的母亲名字？">7.请问您的母亲名字？</option>
								<option text="请问您最喜欢的运动明星？">8.请问您最喜欢的运动明星？</option>
							</select>
							<div class="error-tips"></div>					
						</div>
					</div>	
					
					<div class="form-group">
						<div class="single-column">
							<label class="vereist" for="answer_filed">安全提示问题答案:</label>
							<input type="text" class="form-control" id="answer_filed" name="answer_filed" placeholder="请输入安全提示问题的答案" />
							<div class="error-tips"></div>						
						</div>
					</div>										
				
					<div class="next-step-btn" id="step2">下一步</div>
				</div>
			</div>	
			
			<div class="fp-wrap hidden" id="register-email">
				<div class="fp-title">账号安全</div>
				<div class="fp-content">
					
					<div class="form-group">
						<div class="single-column">
							<label class="vereist" for="email_filed">注册邮箱:</label>
							<input type="text" style="float:left;" class="form-control" id="email_filed" name="email_filed" placeholder="请输入注册时填写的邮箱账号" />					
						</div>
					</div>
				
					<div class="next-step-btn sending-email" id="step3">下一步</div>
				</div>
			</div>	
			
			<div class="fp-wrap hidden" id="sended-email">
				<div class="fp-title">账号安全</div>
				<div class="fp-content">
					<p style="text-align:left;font-size:20px;font-weight:bold;padding-left:238px;margin-bottom:50px;">邮箱验证</p>
					
					<img src="/images/u18.png">
					<p style="font-size:16px;color:#333;">一封验证邮件已发送到您的注册邮箱</p>
					<p style="color:#ed1b25;font-size:16px;">请查收，并按照邮件中的提示继续操作</p>
					<div class="next-step-btn" id="step4">返回首页</div>
				</div>
			</div>								
			
		</div>
	</div>
	<!--component js lib-->
	<script src="${contextPath}/js/component/bootstrap_modal_confirm.min.js"></script>
	<script src="${contextPath}/js/component/jquery.md5.js"></script>
	<!--page js-->
	<script src="${contextPath}/trm_modules/login/front/findpassword.js"></script>
</body>
</html>