<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8; no-cache">

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
<title>登录</title>
<style>
	.login-body{
		height:600px;
		padding: 0px !important;
		border-top:1px solid #ccc;
		background:url(/images/login-bg-icon.png) center no-repeat;
	}
	.modal-body-login{
		background: #FFF;
		display: inline-block;
        width: 425px;
		min-height: 319px;
		height: auto;
	}
	.login-area{
		width: 45%;
	    height: 574px;
	    float: right;
	}
	.login-icon-area{
		width: 55%;
	   /*  height: 574px; */
	    float: left;
	    margin-top:30px;
	}
	.login-icon-area img{
	    float: right;
	}
	.error-tips-pwd{
	    color: #999;
	    line-height: 34px;
	    margin-left: 0px;
	    height: 34px;
	}
	.error-pwd{
		font-size: 12px;
    	color: #ff7b20;
	}
	.QRCode-area{
	    position: relative;
    	top: -364px;
    	right: 160px;
    	width: 450px;
    	height: 450px;
    	background: #000;
	}
	.QRCode-area iframe{
		margin-left: 75px;
	}
	.form-group input{
		ime-mode: disabled;
		-ms-ime-mode: disabled;
		-o-ime-mode: disabled;
		-moz-ime-mode: disabled;
		-webkit-ime-mode: disabled;
	}
	.username-air-icon,
	.password-air-icon,
	.vcode-air-icon {
		background:url(/images/login_icon_new.png) 0 0 no-repeat;
	}
	.username-air-icon {
		width:24px;
		height:28px;
    	background-position: 0 0;		
	}
	.password-air-icon {
		width:24px;
		height:29px;	
	    background-position: 0 -85px;
	}
	.vcode-air-icon {
		width:24px;
		height:24px;	
	    background-position: 0 -170px;
	}	
	.foot-text ul {
		margin:0;
		padding:0;
	}
	.foot-text ul li {
		display:inline-block;
		float:left;
		width:90px;
		font-size:14px;
		line-height:14px;
		border-right:1px solid #000;
		font-weight:bold;
	}
	.foot-text ul li:last-child {
		border:none;
	}
	.foot-text p {
		font-size:14px;
		margin:15px 0;
		
	}
	.copyright {
		min-height:200px;
	}
</style>
<script>
	$(document).ready(function(){
		$(".welcome").html("欢迎登录");
	});
</script>
</head>
<body>
	<div class="login-body full-container">
		<!-- <div class="login-icon-area"><img src="/images/login-bg-icon.jpg"  onerror="imgError(this);"/></div> -->
		<div class="login-area">
			<div class="modal-body-login modal-body" style="margin: 75px;">
				<div class='login-modal' id='login_form'>
					<div class="login-box">
						<div style="font-size:18px;font-weight:bold;line-height:60px;">
							<span class="login-title">会员登录</span>
						</div>
						<div class="form-content" style="width:350px;">
							<form novalidate="novalidate">
								<div class="form-group">
									<div class="single-column pos-relative">
										<input type="text" class="form-control" name="login_id_field" id="login_id_field" maxlength=20 style="padding-left: 50px;width: 350px;height:50px;" placeholder="请输入用户名" autocomplete="off">
										<i class="username-air-icon" style="position: absolute;left: 16px;top: 10px;"></i>
										<div class="error-tips" style="height:34px;"></div>
									</div>
								</div>
								<div class="form-group">
									<div class="single-column pos-relative">
										<input type="text" ondragstart="return false" onpaste="return false" class="form-control" name="login_mm_filed" id="login_mm_filed" maxlength=16 style="padding-left: 50px;width: 350px;height:50px;" placeholder="请输入密码" autocomplete="off">
										<i class="password-air-icon" style="position: absolute;left: 17px;top: 10px;"></i>
										<div class="error-tips-pwd error-tips"></div>
									</div>
								</div>
								<!-- <div class="form-group">
									<div class="pos-relative" style="width:100%;">
										<input type="text" ondragstart="return false" onpaste="return false" class="form-control" name="login_v_code" id="login_v_code" style="padding-left: 50px;width: 220px;height:50px;margin-right:15px;" placeholder="请输入验证码" autocomplete="off">
										<i class="vcode-air-icon" style="position: absolute;left: 17px;top: 13px;"></i>
										<span><img id="vcode" src="/admin/logincode.action?t=Math.random()" style="width:110px;height:50px;background-color:red;"/></span>
										<div class="error-tips"></div>
									</div>
								</div> -->
								<div class="form-group">
									<div class="single-column pos-relative" style="padding:0 10px;">
									    <span style="line-height:20px;float:right;margin-bottom:15px;"><a class="find-pwd">忘记密码?</a></span>
									</div>
								</div>								
							</form>
							<div class="btn btn-default bigger highlight" style="background-color:#419ff6;border-color: #419ff6">登录</div>
							<div class="third-login">
								<span class="pull-right">还不是会员?<a class="default-color register-now" style="margin:0 10px;">立即注册>></a></span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="${contextPath}/js/component/jquery.md5.js"></script>
	<script src="${contextPath}/trm_modules/login/front/login.js"></script>
</body>
</html>