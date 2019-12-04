<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=utf-8; no-cache">
<title>注册登录</title>
<!--page css  -->
<link rel="stylesheet"
	href="${contextPath}/css/ies/trm.page.register.css">
<script>
	$(document).ready(function() {
		$(".welcome").html("欢迎注册");
	});
</script>
</head>
<body>
	<div class="full-container ies-regist">
		<div class="container content-container">
			<div class="row content-box" id="offer_content">
				<div class="form-content" id="offer_register_form">
					<div class="login-area">
						<p>已经有账号？请直接登录</p>
						<div class="login-btn">登录</div>
					</div>
					<form novalidate="novalidate">
						<%--基本信息 start--%>
						<div class="equ-line" style="overflow:hidden;">
							<p class="en-title pull-left">基本信息</p>
						</div>
						<div class="form-group">
							<div class="single-column">
								<label class="vereist" for="offer_username_filed">用户名:</label> <input
									type="text" class="form-control" id="offer_username_filed"
									name="offer_username_filed" />
								<div class="error-tips">6-20位字母加数字，允许大写字母，不能以数字开头</div>
							</div>
						</div>

						<div class="form-group">
							<div class="single-column">
								<label class="vereist" for="register_offer_mm_filed">登录密码:</label>
								<input type="text" class="form-control pwd-input"
									id="register_offer_mm_filed" name="register_offer_mm_filed" />
								<div class="error-tips">密码由6-16位字母加数字组成</div>
							</div>
						</div>

						<div class="form-group">
							<div class="single-column">
								<label class="vereist" for="register_offer_mm_copy_filed">确认密码:</label>
								<input type="text" class="form-control pwd-input"
									id="register_offer_mm_copy_filed"
									name="register_offer_mm_copy_filed" />
								<div class="error-tips"></div>
							</div>
						</div>
						<%--基本信息 end--%>

						<%--单位信息 start--%>
						<div class="equ-line" style="overflow:hidden;">
							<p class="en-title pull-left">单位信息</p>
						</div>
						<div class="form-group">
							<div class="single-column">
								<label class="vereist" for="address">单位名称:</label> 
								<input
									type="text" class="form-control" id="address"
									name="address" />
								<div class="error-tips">请输入营业执照或其它成立证照上的单位名称</div>
							</div>
						</div>
												
						<!-- 需求变更，新增社会统一信用代码 -->
						<div class="form-group">
							<div class="single-column">
								<label class="vereist" for="org_code" style="line-height: 24px; margin-top: -3px; width: 120px; margin-left: 30px; font-size: 12px;">社会信用统一代码（组织机构代码）:</label>
								<input
									type="text" class="form-control" id="creditId"
									name="creditId" />
								<div class="error-tips">请输入社会信用统一代码（组织机构代码）</div>
							</div>
						</div>

						<!-- 需求变更，新增单位地址 -->
						<div class="form-group">
							<div class="single-column">
								<label class="vereist" for="firm_addr">单位地址:</label> <input
									type="text" class="form-control" id="firm_addr"
									name="firm_addr" />
								<div class="error-tips">请输入营业执照或其它成立证照上的单位地址</div>
							</div>
						</div>
						
						<div class="form-group">
							<div class="single-column">
								<label class="vereist" for="proper_filed">单位性质:</label> <span
									class="select-cell"
									style="height: 37px;"></span> <select
									class="form-control" id="proper_filed" name="proper_filed">
									<option disabled selected>--请选择--</option>
									<option>国有企业</option>
									<option>国有控股企业</option>
									<option>民营企业</option>
									<option>事业单位</option>
									<option>行政机关</option>
									<option>军队单位</option>
									<option>其他</option>
								</select>
								<div class="error-tips"></div>
							</div>
						</div>

						<div class="form-group">
							<div class="single-column">
								<label class="vereist" for="isListed_filed">公司上市情况:</label> <span
									class="select-cell"
									style="height: 37px;"></span>
								<select class="form-control" id="isListed_filed" name="isListed_filed">
									<option flag="" disabled selected>--请选择--</option>
									<option flag="1">主板上市</option>
									<option flag="2">创业板上市</option>
									<option flag="3">中小企业版上市</option>
									<option flag="4">新三板挂牌</option>
									<option flag="5">未上市</option>
								</select>
								<div class="error-tips"></div>
							</div>
						</div>

						<div class="form-group">
							<div class="single-column">
								<label class="vereist" for="hightTec_filed">是否高新企业:</label> <span
									class="select-cell"
									style="height: 37px;"></span> <select
									class="form-control" id="hightTec_filed" name="hightTec_filed">
									<option flag="" disabled selected>--请选择--</option>
									<option flag="Y">是</option>
									<option flag="N">否</option>
								</select>
								<div class="error-tips hightErrorTip">选择高新企业条件为该企业是否获得《高新技术企业认定证书》</div>
							</div>
						</div>

						<%--<div class="form-group">--%>
							<%--<div class="single-column">--%>
								<%--<label class="vereist" for="NTB_filed">是否新三板挂牌:</label> <span--%>
									<%--class="select-cell"--%>
									<%--style="height: 37px;"></span> <select--%>
									<%--class="form-control" id="NTB_filed" name="NTB_filed">--%>
									<%--<option disabled selected>--请选择--</option>--%>
									<%--<option flag="Y">是</option>--%>
									<%--<option flag="N">否</option>--%>
								<%--</select>--%>
								<%--<div class="error-tips"></div>--%>
							<%--</div>--%>
						<%--</div>--%>

						<%--<div class="form-group">--%>
							<%--<div class="single-column">--%>
								<%--<label class="vereist" for="WEP_filed"--%>
									<%--style="line-height: 24px; margin-top: -3px; width: 120px; margin-left: 30px;">是否有武器装备科研生产许可证:</label>--%>
								<%--<span class="select-cell"--%>
									<%--style="height: 37px;"></span> <select--%>
									<%--class="form-control" id="WEP_filed" name="WEP_filed">--%>
									<%--<option disabled selected>--请选择--</option>--%>
									<%--<option flag="Y">是</option>--%>
									<%--<option flag="N">否</option>--%>
								<%--</select>--%>
								<%--<div class="error-tips"></div>--%>
							<%--</div>--%>
						<%--</div>--%>

						<%--<div class="form-group">--%>
							<%--<div class="single-column">--%>
								<%--<label class="vereist" for="WEQK_filed"--%>
									<%--style="line-height: 24px; margin-top: -3px; width: 120px; margin-left: 30px; font-size: 12px;">是否有武器装备科研生产单位保密资格证:</label>--%>
								<%--<span class="select-cell"--%>
									<%--style="height: 37px;"></span> <select--%>
									<%--class="form-control" id="WEQK_filed" name="WEQK_filed">--%>
									<%--<option disabled selected>--请选择--</option>--%>
									<%--<option flag="Y">是</option>--%>
									<%--<option flag="N">否</option>--%>
								<%--</select>--%>
								<%--<div class="error-tips"></div>--%>
							<%--</div>--%>
						<%--</div>--%>

						<div class="form-group">
							<div class="single-column">
								<label class="vereist" for="affily_filed">隶属单位:</label> <span
									class="select-cell"
									style="height: 37px;"></span> 
								<select class="form-control" id="affily_filed" name="affily_filed">

								</select> <span class="select-cell"
									style="height: 37px; left: 730px;"></span> <select
									class="form-control" id="subAffily_filed"
									name="subAffily_filed">
									<option code="" disabled selected>--请选择--</option>
								</select>

								<div class="error-tips"></div>
							</div>
						</div>

						<div class="form-group">
							<div class="single-column" id="district">
								<label class="vereist" for="province_filed">所在省份:</label> 
								<span class="select-cell" style="height: 37px;"></span> 
								<span class="select-cell" style="height: 37px; left: 730px;"></span>
								<span class="select-cell" style="height: 37px; left:1046px;"></span> 
								<select class="form-control dis-pick" id="province_filed" name="province_filed"></select> 
								<select class="form-control dis-pick" id="city_filed"></select> 
								<select class="form-control dis-pick" id="county_filed"></select>
								<div class="error-tips"></div>
							</div>
						</div>

						<div class="form-group">
							<div class="single-column">
								<label class="vereist" for="intro_filed">企业简介:</label>
								<textarea type="text" class="form-control" id="intro_filed"
									name="intro_filed" placeholder="请输入企业介绍"></textarea>
								<div class="error-tips">包括企业法定代表人、地址、注册时间、注册资金、企业人数、资质情况、高新技术企业情况、专利情况等，限1000字以内</div>
							</div>
						</div>

						<div class="form-group" style="margin-right: 35px;margin-bottom: 10px !important;">
							<div class="single-column">
								<label class="vereist"
									style="line-height: 24px; margin-top: 34px; width: 120px; margin-left: 30px;">营业执照/法人证书扫描件:</label>
								<div class="img-upload-area" id="img_filed1">
									<ul name="firm_img" class="file-area-list">
										<li class="owner-img" id="fileNameList1">
											<input id="uploadFile1" name="files" type="file">
										</li>
									</ul>
									<span class="uploadfile-tips" style="margin-top: 42px;">仅限一张</span>
								</div>
								<div class="error-tips"
									style="clear: left; margin-bottom: 10px;">请上传小于5M的jpg或png文件</div>
							</div>
						</div>

						<div class="form-group" style="position: relative;top: 9px;margin-bottom: 10px !important;">
							<div class="single-column">
								<label class="vereist"
									   style="line-height: 24px; margin-top: 35px;">信息报送承诺书扫描件(加盖单位公章):</label>
								<div class="img-upload-area" id="img_filed2">
									<ul name="promise_img" class="file-area-list">
										<li class="owner-img" id="fileNameList2"><input
												id="uploadFile2" name="files" type="file"></li>
									</ul>
									<span class="uploadfile-tips" style="margin-top: 42px;">仅限一张</span>
								</div>

								<div class="error-tips" style="clear: left; margin-bottom: 20px;">请上传小于5M的jpg或png文件</div>
								<div class="promise-area">
								<span class="down-promise-book">
									<a href="/upload/files/protocol/20171013.doc">下载承诺书</a>
								</span>
									<span class="promise-tips">先下载承诺书，加盖公章后，上传扫描件</span>
								</div>
							</div>
						</div>
						<%--单位信息 end--%>

						<%--注册人信息 start--%>
						<div class="equ-line" style="overflow:hidden;">
							<p class="en-title pull-left">注册人信息</p>
						</div>

						<div class="form-group">
							<div class="single-column">
								<label class="vereist" for="dep_filed">所在部门:</label> <input
									type="text" class="form-control" id="dep_filed"
									name="dep_filed" />
								<div class="error-tips"></div>
							</div>
						</div>

						<div class="form-group">
							<div class="single-column">
								<label class="vereist" for="contact_filed">联系人:</label> <input
									type="text" class="form-control" id="contact_filed"
									name="contact_filed" />
								<div class="error-tips"></div>
							</div>
						</div>

						<div class="form-group">
							<div class="single-column">
								<label class="vereist" for="idNum_filed">身份证号:</label> <input
									type="text" class="form-control" id="idNum_filed"
									name="idNum_filed" />
								<div class="error-tips"></div>
							</div>
						</div>

						<div class="form-group">
							<div class="single-column">
								<label class="vereist" for="offer_phone_filed">手机号码:</label> <input
									type="text" class="form-control" id="offer_phone_filed"
									name="offer_phone_filed" />
								<div class="error-tips"></div>
							</div>
						</div>

						<div class="form-group">
							<div class="single-column">
								<label class="vereist" for="offer_email_filed">电子邮箱:</label> <input
									type="text" class="form-control" id="offer_email_filed"
									name="offer_email_filed" />
								<div class="error-tips"></div>
							</div>
						</div>


						<div class="form-group">
							<div class="single-column">
								<label class="vereist" for="offer_tips_filed">安全提示问题:</label> <span
									class="select-cell"
									style="height: 37px;"></span> <select
									class="form-control" id="offer_tips_filed"
									name="offer_tips_filed">
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
								<label class="vereist" for="offer_answer_filed">安全提示问题答案:</label>
								<input type="text" class="form-control" id="offer_answer_filed"
									name="offer_answer_filed" placeholder="请输入安全提示问题的答案" />
								<div class="error-tips"></div>
							</div>
						</div>
						<%--注册人信息 end--%>

						<div class="protocol">
							<input type="checkbox" checked autocomplete="off"
								id="offer_checkbox" /> <span>我已阅读并同意</span> <a class="item">《陕西军民融合科技创新资源开放共享管理服务平台注册协议》</a>
						</div>

						<div class="goods-form-button">
							<div class="btn btn-default bigger" id="offer_register_now"style="padding-top: 15px;">立即注册</div>
							
							<div class="btn btn-default bigger" id="temporary-storage" style="padding:16px 20px;border-radius:5px;margin-left:100px;background:#04a89d;color:#fff;" >保存</div>
						
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	
	
	<!--component js lib-->
	<script src="${contextPath}/js/component/jquery.ui.widget.min.js"></script>
	<script
		src="${contextPath}/js/component/jquery.iframe-transport.min.js"></script>
	<script src="${contextPath}/js/component/jquery.fileupload.min.js"></script>
	<script
		src="${contextPath}/js/component/bootstrap_modal_confirm.min.js"></script>
	<script src="${contextPath}/js/component/validation.js"></script>
	<script src="${contextPath}/js/component/jquery.md5.js"></script>
	<script src="${contextPath}/js/component/distpicker.data.js"></script>
	<script src="${contextPath}/js/component/distpicker.js"></script>
	
	<!--page js-->
	<script src="${contextPath}/trm_modules/login/front/register.js"></script>
	
	<script src="${contextPath}/trm_modules/login/front/somescript.js"></script>

</body>
</html>