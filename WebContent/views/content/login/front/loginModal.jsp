<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<style>
	.error-tips-pwd{
	    color: #999;
	    line-height: 34px;
	    margin-left: 0px;
	    min-height: 20px;
	    height: auto;
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
</style>
<div class='login-modal' id='login_form'>
	<div class="login-box">
		<div>
			<span class="login-title">会员登录</span>
			<span class="register-now pull-right">
				<a class="forget">忘记密码</a>
				<lable style="position:relative;top:-1px;left:-2px;">|</lable>
				<a class="register">立即注册</a>
				
			</span>
		</div>
		<div class="form-content">
			<form novalidate="novalidate">
				<div class="form-group">
					<div class="single-column pos-relative">
						<input type="text" class="form-control" name="login_id_field" id="login_id_field" maxlength=20 style="padding-left: 50px;width: 328px;" placeholder="请输入用户名" autocomplete="off">
						<i class="username-air-icon" style="position: absolute;left: 16px;top: 14px;"></i>
						<div class="error-tips"  style="position:static;"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="single-column pos-relative">
						<input type="text" ondragstart="return false" onpaste="return false" class="form-control" name="login_mm_filed" id="login_mm_filed" maxlength=16 style="padding-left: 50px;width: 328px;" placeholder="请输入密码" autocomplete="off">
						<i class="password-air-icon" style="position: absolute;left: 17px;top: 14px;"></i>
						<div class="error-tips-pwd"  style="position:static;"></div>
					</div>
				</div>
			</form>
			<div class="btn bigger highlight" style="background-color:#419ff6;color:#fff;margin-bottom:35px;">登录</div>
			<!-- <div class="third-login">
				<span class="find-pwd pull-left"><a>忘记密码>></a></span>
			</div> -->
		</div>
	</div>
</div>
<!-- <div class='register-modal hidden' id='register_form'>
	<div class="register-box">
		<div>
			<span class="login-title">会员注册</span>
			<span class="register-now pull-right"><a>立即登录>></a></span>
		</div>
		<div class="form-content">
			<form novalidate="novalidate">
				<div class="form-group">
					<div class="single-column pos-relative">
						<input type="text" class="form-control" name="register_login_id_field" id="register_login_id_field" maxlength=20 style="padding-left: 50px;width: 328px;" placeholder="请输入用户名" autocomplete="off">
						<i class="username-air-icon" style="position: absolute;left: 16px;top: 14px;"></i>
						<div class="error-tips"  style="position:static;">6-20位字母加数字，允许大写字母，不能以数字开头</div>                    innerText add by sunfang 2016-12-29 
					</div>
				</div>
				<div class="form-group">
					<div class="single-column pos-relative">
						<input type="text" ondragstart="return false" onpaste="return false" class="form-control" name="register_login_mm_filed" id="register_login_mm_filed" maxlength=16 style="padding-left: 50px;width: 328px;" placeholder="请输入密码" autocomplete="off">
						<i class="password-air-icon" style="position: absolute;left: 17px;top: 14px;"></i>
						<div class="error-tips-pwd" style="position:static;">密码由6-16位字母加数字组成</div>                                        innerText add by sunfang 2016-12-29 
					</div>
				</div>
				<div class="form-group">
					<div class="single-column pos-relative">
						<input type="text" ondragstart="return false" onpaste="return false" class="form-control" name="register_login_mm_copy_filed" id="register_login_mm_copy_filed" maxlength=16 style="padding-left: 50px;width: 328px;" placeholder="请确认密码" autocomplete="off">
						<i class="password-air-icon" style="position: absolute;left: 17px;top: 14px;"></i>
						<div class="error-tips-pwd" style="position:static;">请再输入一遍密码</div>
					</div>
				</div>
				<div class="form-group">
					<div class="single-column pos-relative">
						<input type="text" class="form-control" name="register_receiver_filed" id="register_receiver_filed" style="padding-left: 50px;width: 328px;" placeholder="请输入手机号码">
						<i class="email-air-icon" style="position: absolute;left: 17px;top: 14px;"></i>
						<div class="error-tips"  style="position:static;"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="single-column pos-relative">
						<input type="text" class="form-control" name="register_cert_code_filed" id="register_cert_code_filed" maxlength=6 style="padding-left: 50px;width: 196px;" placeholder="请输入6位验证码">
						<i class="verifyCode-air-icon" style="position: absolute;left: 17px;top: 14px;"></i>
						<div class="verify-code-btn get-verify-code">获取验证码</div>
						<div class="error-tips"  style="position:static;"></div>
					</div>
				</div>
				<div class="agreement-box pull-left"><span class="checkbox-small-icon"></span><a class="pull-right" href="/views/content/help/front/regAgreement.jsp" target="_blank" title="点击阅读服务条款">接受服务条款</a></div>
			</form>
			<div class="btn btn-default bigger highlight disabled" style="margin-bottom: 12px;">注册</div>
		</div>
	</div>
</div> -->
<!-- <div class='find-pwd-modal hidden' id='find_pwd_form'>
	<div class="find-pwd-box">
		<div>
			<span class="login-title">重置密码</span>
			<span class="register-now pull-right"><a>立即登录>></a></span>
		</div>
		<div class="form-content">
			<div id="security_box" class="stepInfo">
				<div class="tips1 hidden">为了账号安全，需要验证手机有效性，一条包含有验证码的短信已经发送至手机：<span class="default-color"></span></div>
				<div class="tips2 hidden">为了账号安全，需要验证邮箱有效性，一封包含有验证码的邮件已经发送至邮箱：<span class="default-color"></span></div>
			</div>
			<form novalidate="novalidate">
				<div class="form-group">
					<div class="single-column pos-relative">
						<input type="text" class="form-control" name="find_receiver_filed" id="find_receiver_filed" style="padding-left: 50px;width: 328px;" placeholder="请输入手机号码">
						<i class="email-air-icon" style="position: absolute;left: 17px;top: 14px;"></i>
						<div class="error-tips"  style="position:static;"></div>
					</div>
				</div>
				<div class="form-group hidden">
					<div class="single-column pos-relative">
						<input type="text" class="form-control" name="find_cert_code_filed" id="find_cert_code_filed" maxlength=6 style="padding-left: 50px;width: 196px;" placeholder="请输入6位验证码">
						<i class="verifyCode-air-icon" style="position: absolute;left: 17px;top: 14px;"></i>
						<div class="verify-code-btn disabled"></div>
						<div class="error-tips" style="position:static;"></div>
					</div>
				</div>
				<div class="tips3 hidden">请重新设置您的账号密码</div>
				<div class="form-group hidden">
					<div class="single-column pos-relative">
						<input type="text" ondragstart="return false" onpaste="return false" class="form-control" name="find_new_mm_filed" id="find_new_mm_filed" maxlength=16 style="padding-left: 50px;width: 328px;" placeholder="请输入密码" autocomplete="off">
						<i class="username-air-icon" style="position: absolute;left: 16px;top: 14px;"></i>
						<div class="error-tips-pwd" style="position:static;"></div>
					</div>
				</div>
				<div class="form-group hidden">
					<div class="single-column pos-relative">
						<input type="text" ondragstart="return false" onpaste="return false" class="form-control" name="find_new_mm_conf_filed" id="find_new_mm_conf_filed" maxlength=16 style="padding-left: 50px;width: 328px;" placeholder="请确认密码" autocomplete="off">
						<i class="password-air-icon" style="position: absolute;left: 17px;top: 14px;"></i>
						<div class="error-tips-pwd"  style="position:static;"></div>
					</div>
				</div>
			</form>
			<div class="btn btn-default bigger highlight" style="margin-bottom: 12px;">下一步</div>
		</div>
	</div>
</div> -->

<script src="${contextPath}/trm_modules/login/front/loginModal.js"></script>