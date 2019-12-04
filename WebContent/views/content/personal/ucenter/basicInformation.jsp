<!--
	@page 基本信息
	@author yinzheng
	@init-time 2017-10-31
	@history 新建页面	v1.0
-->
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>个人中心-基本信息</title>
		<!--page css-->
		<link rel="stylesheet" href="${contextPath}/css/trm.page.personalCenter.css" />
		<style>
			.img-upload-area{
				position: relative;
			}
			.deletePicButton{
				position: absolute !important;
			    left: 2px !important;
			    top: 2px !important;
			    opacity: 0 !important;
			    text-indent: 9999px;
			    background-color: transparent !important;
			}
			.deletePicButton:hover{
				opacity: 0.7 !important;
				text-indent: 0;
			    background-color: #000 !important;
			    border-radius: 55px;
			}
		</style>
	</head>

	<body>
		<div class="full-container content">
			<div class="container">
				<!--左侧菜单列表  start-->
				<jsp:include page="${contextPath}/views/decorator/common/left-nav.jsp"/>
				<!--左侧菜单列表  end-->
				<!--作者：wangfan 描述    基本信息   start-->
				<div class="ucenter-content  pull-right">
					<div class="row content-box pull-left basic-content-box">
						<div class="form-content">
							<form id="basic_form">
							<h2>陕西军民融合科技创新资源共享服务平台</h2>
							<h1>用户注册信息表</h1>
							<table border="1" userType="admin" style="display:none;">
								  <tr>
								    <td>单位名称</td>
								    <td  colspan="2" >
								    	<input type="text" class="form-control" disabled="disabled" id="firm_filed" name="firm_filed" />
									</td>
								    <td>统一社会信用代码</td>
								    <td  colspan="2" >
								    	<input type="text" class="form-control" disabled="disabled" id="creditId" name="creditId" />
								    </td>
								  </tr>
								  <tr>
								    <td>单位地址</td>
								    <td  colspan="5" >
								    	<input type="text" class="form-control" disabled="disabled" id="address" name="address" />
								    </td>
								  </tr>
								  <tr>
								    <td>单位性质</td>
								    <td>
								    	<input type="text" class="form-control" disabled="disabled" id="proper_filed" name="proper_filed" />
								    </td>
								    <td>公司上市情况</td>
								    <td>
								    	<input type="text" class="form-control" disabled="disabled" id="isListed_filed" name="isListed_filed" />
								    </td>
								    <td>是否高新企业</td>
								    <td>
								    	<input type="text" class="form-control" disabled="disabled" id="hightTec_filed" name="hightTec_filed" />
								    </td>
								  </tr>
								  <tr>
								    <td>隶属单位</td>
								    <td  colspan="5" >
								    	<input type="text" disabled="disabled" class="form-control affily-filed" id="affily_filed" name="affily_filed" style="width:222px;" />
										<input type="text" disabled="disabled" class="form-control affily-filed" id="subAffily_filed" name="subAffily_filed" style="width:228px;" />
									</td>
								  </tr>
								  <tr>
								    <td>所在省份</td>
								    <td  colspan="5" >
								    	<input type="text" disabled="disabled" class="form-control dis-pick" id="province_filed" name="province_filed" style="width:138px;" />
										<input type="text" disabled="disabled" class="form-control dis-pick" id="city_filed" style="width:180px;" />
										<input type="text" disabled="disabled" class="form-control dis-pick" id="county_filed" style="width:128px;" />
									</td>
								  </tr>
								  <tr>
								    <td>企业简介</td>
								    <td  colspan="5" >
								    	<textarea disabled="disabled" style="width:100%;" type="text" class="form-control" id="intro_filed" name="intro_filed" placeholder="请输入企业介绍"></textarea>
								    </td>
								  </tr>
								  <tr>
								    <td>营业执照/法人证书扫描件、信息报送承诺书扫描件(加盖单位公章)</td>
								    <td  colspan="2" >
								    	<div class="img-upload-area" id="img_filed1">
											<img src="" />
										</div>
								    </td>
								    <td>信息报送承诺书扫描件(加盖单位公章)</td>
								    <td  colspan="2" >
										<div class="img-upload-area" id="img_filed2">
											<img src="/images/zixun-2.png" />
										</div>
								    </td>
								  </tr>
								  <tr height="20px">
								    <td   colspan="6" style="text-align:left;padding-left:15px;">注册人信息</td>
								  </tr>
								  <tr>
								    <td>姓名</td>
								    <td  colspan="2" >
								    	<input type="text" class="form-control" id="contact_filed" name="contact_filed" placeholder="请输入联系人姓名" />
								    </td>
								    <td>所在部门</td>
								    <td  colspan="2" >
								    	<input type="text" class="form-control" id="dep_filed" name="dep_filed" placeholder="请输入单位所在部门" />
								    </td>
								  </tr>
								  <tr>
								    <td>身份证号</td>
								    <td  colspan="2" >
								    	<input type="text" class="form-control" id="idNum_filed" name="idNum_filed" placeholder="请输入个人身份证号码" />
								    </td>
								    <td>手机号码</td>
								    <td  colspan="2" >
								    	<input type="text" class="form-control" id="mobile_filed" name="mobile_filed"/>
								    </td>
								  </tr>
								  <tr>
								    <td>安全提示问题</td>
								    <td  colspan="2" >
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
								    </td>
								    <td  rowspan="2">电子邮箱</td>
								    <td   rowspan="2" colspan="2" >
								    	<input type="text" class="form-control" maxlength=50 id="email_field" name="email_field"/>
								    </td>
								  </tr>
								  <tr>
								    <td>安全提示问题答案</td>
								    <td  colspan="2" >
								    	<input type="text" class="form-control" id="answer_filed" name="answer_filed"/>
								    </td>
								  </tr>
							</table>
							<table border="1" userType="normal" style="display:none;">
								 <tr>
								    <td>用户名</td>
								    <td>
								    	<input type="text" class="form-control" disabled="disabled" name="username_field" />
									</td>
									<td rowspan="3">
								      	<div class="single-column">
											<div class="img-upload-area" id="img_filed1">
												<ul name=headPortrait class="file-area-list">
													<li class="owner-img" id="fileNameList1">
														<input id="uploadFile1" name="files" type="file">
														<span class="error-tips"></span>
													</li>
												</ul>
											</div>							
										</div>
									</td>
								  </tr>
								  <tr>
								    <td>单位名称</td>
								    <td>
								    	<input type="text" class="form-control" disabled="disabled" name="firm_filed" />
									</td>
								  </tr>
								  <tr>
								    <td>所在部门</td>
								    <td>
								    	<input type="text" class="form-control" name="dep_filed" placeholder="请输入单位所在部门" />
								    </td>
								  </tr>
								  <tr>
								    <td>姓名</td>
								    <td colspan="2">
								    	<input type="text" class="form-control" name="contact_filed" placeholder="请输入联系人姓名" />
								    </td>
								  </tr>
								  <tr>
								    <td>电子邮箱</td>
								    <td colspan="2">
								    	<input type="text" class="form-control" maxlength=50 name="email_field" placeholder="请输入邮箱地址"/>
								    </td>
								  </tr>
								  <tr>
								    <td>手机号码</td>
								    <td colspan="2">
								    	<input type="text" class="form-control" name="mobile_filed" placeholder="请输入联系人电话"/>
								    </td>
								  </tr>
							</table>

							</form>
						</div>
						<div class="goods-form-button check">
							<button class="btn btn-default bigger highlight" id="save_form">保存信息</button>
							<button class="btn btn-default bigger highlight" id="download_form">导出PDF</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--component js lib-->
		<script src="${contextPath}/js/component/jquery.ui.widget.min.js"></script>
		<script src="${contextPath}/js/component/jquery.iframe-transport.min.js"></script>
		<script src="${contextPath}/js/component/jquery.fileupload.min.js"></script>
		<script src="${contextPath}/js/component/bootstrap_modal_confirm.min.js"></script>
		<script src="${contextPath}/js/component/validation.js"></script>
		<script src="${contextPath}/js/component/laydate.dev.min.js"></script>				
		<!--page js-->
		<script src="${contextPath}/trm_modules/common/ucenter/leftnav.js"></script>
		<script src="${contextPath}/trm_modules/personal/ucenter/basicInformation.js" async="true"></script>
	</body>
</html>