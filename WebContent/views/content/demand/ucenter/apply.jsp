<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags'%>
<sec:authentication property="principal" var="principal"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人中心-设备管理-发布需求</title>
<!--component css-->
<!--page css-->
<link rel="stylesheet" href="${contextPath}/css/trm.page.applyEquipment.css">
<link rel="stylesheet" href="${contextPath}/css/component/bootstrap-select.min.css">
<script src="${contextPath}/js/component/bootstrap-select.min.js"></script>

</head>
<body>
	<!-- 顶部图片end -->
	<div class="full-container content">
		<div class="container">
			<!-- 左侧部分 start-->
			<%@ include file="/views/decorator/common/left-nav.jsp" %>
			<!-- 左侧部分 end-->
			
			<!-- 右侧部分 start-->
			<div class="ucenter-content pull-right">
				<div class="row content-box">
					<div class="form-content">
						<h3 class="form-content-title">军民融合需求信息表</h3>
						
						<form id="apply_form">
<!-- 							<h2><input type="text"  id="requireName" name="requireName"  placeholder="请输入需求名称(限50字)"><span class="error-tips"></span></h2>
 -->							<h1 style="display:none;">发布时间：<span class="applyDate">---   </span>信息来源：<span class="linkUnit" id="linkUnit"></span></h1>
							
							<table border="1">
							 	  <tr>
								      <td>需求名称</td>
								      <td colspan="3">
								      	<input type="text" class="form-control" id="requireName" name="requireName"  placeholder="请输入需求名称(限50字)" maxlength = "50">
								      	<span class="error-tips"></span>
								      </td>
								  </tr>
								
								   <tr>
								      <td>需求类型</td>
								      <td>
										<select class="form-control" id="requireType" name="requireType">
											<option value="" selected >请选择...</option>
											<option value="技术需求">技术需求</option>
											<option value="产品需求">产品需求</option>
											<option value="融资需求">融资需求</option>
										</select>
										<span class="error-tips"></span>
								      </td>
								      <td>关键字</td>
								      <td>
										<input type="text" class="form-control" id="keyword" name="keyword" placeholder="请输入关键字"/>
										<span class="error-tips"></span>
								      </td>
								  </tr>
								   <tr>
								      <td>服务领域</td>
								      <td colspan="3" style="position:relative;">
										<div class="form-group">
											<div class="col-sm-4">
												<select id="usertype" name="usertype" class="selectpicker form-control show-tick" multiple data-width="auto" data-live-search="false" title="请选择服务领域...">
														
												</select>
											</div>
										 </div>
										<span class="error-tips usertypeError" style="margin-left: 120px;"></span>
										<span class="uploadfile-tips" style="position:absolute;top:25px;right:5px;display:inline-block;"><i style="color:red;font-style:normal;">注:</i>多选</span>	
								      
								      </td>
								  </tr>
								   <tr>
								      <td>需求描述</td>
								      <td colspan="3"> 
										<textarea class="form-control" style="height: 120px !important;width: 478px;" rows="10" id="requireBrief"  name="requireBrief" placeholder="请输入需求描述"></textarea>
										<span class="error-tips"></span>
								      </td>
								  </tr>
								   <tr>
								      <td>需求有效期</td>
								      <td colspan="3">
										<input type="text" class="form-control" id="validDate" name="validDate"  placeholder="请输入需求有效期" />
										<span class="error-tips"></span>
								      </td>
								  </tr>
								   <tr>
								      <td>需求单位</td>
								      <td colspan="3">
										<input type="text" class="form-control" id="requireUnit" name="requireUnit" disabled placeholder="请输入需求单位" value="${principal.session.orgName}" />
										<span class="error-tips"></span>
								      </td>
								  </tr>
								  <tr height="20px">
								    <td colspan="6" style="text-align:left !important;padding-left:15px;font-weight: bolder;">联系方式</td>
								  </tr>
								   <tr>
								      <td>联系人</td>
								      <td colspan="3">
										<input type="text" class="form-control" id="linkMan" name="linkMan" placeholder="请输入联系人"/>
										<span class="error-tips"></span>
								      </td>
								  </tr>
								   <tr>
								      <td>联系方式</td>
								      <td colspan="3">
										<input type="text" class="form-control" id="linkPhone" name="linkPhone" placeholder="请输入联系方式" />
										<span class="error-tips"></span>
								      </td>
								  </tr>
								   <tr>
								      <td>单位地址</td>
								      <td colspan="3">
										<input type="text" class="form-control" id="address" name="address" disabled placeholder="请输入单位地址" value="${principal.session.address}" />
										<span class="error-tips"></span>
								      </td>
								  </tr>
								  <tr>
								      <td>备注</td>
								      <td colspan="3">
										<input type="text" class="form-control" id="remark" name="remark" placeholder="请输入备注信息"/>
										<span class="error-tips"></span>
								      </td>
								  </tr>
									
							</table>
							
							
							<div class="form-topbar newrelevant_list" style="border-left:1px solid #333;border-right:1px solid #333;width:100%;font-weight: bolder;">
								<div class="apply-title" >
									<p class="relAdd"><span>+</span>新增相关技术产品</p>
								</div>
							</div>
							<div class="form-topbar relevantTitel" style="display: none;  border-left:1px solid #333;border-right:1px solid #333;width:100%;">
								<div class="apply-title" style="font-weight: bolder;" >
									相关技术产品
								</div>
							</div>
							<table border="1" id="relevant_list" style="width:100%;text-align:center;line-height:50px;">
							  	<tbody id="tblist">
								  	<tr>
								  		<td style="width:5%;">序号</td>
										<td style="width:20%;">名称</td>
										<td style="width:50%;">功能描述</td>
										<td style="width:15%;">联系方式</td>
									</tr>
									<tr>
										<td style="width:5%;">1</td>
										<td style="width:20%;"><input style="width:100%;" type="text" class="techName"  name="techName" placeholder="请输入技术名称"/></td>
										<td style="width:50%;"><input style="width:100%;" type="text" class="techContent"  name="techContent" placeholder="请输入相关技术功能描述" /></td>
										<td style="width:15%;"><input style="width:100%;" type="text" class="techPhone"  name="techPhone" placeholder="请输入联系方式" /></td>
									</tr>
								</tbody>
							</table>
							
							<!-- <div class="form-group">
								<label>技术名称:</label>
								<input type="text" class="form-control" id="techName" name="techName" placeholder="请输入技术名称"/>
								<span class="error-tips"></span>
							</div>
							<div class="form-group">
								<label>功能描述:</label>
								<input type="text" class="form-control" id="techContent" name="techContent" placeholder="请输入相关技术功能描述" />
								<span class="error-tips"></span>
							</div>
							<div class="form-group">
								<label>联系方式:</label>
								<input type="text" class="form-control" id="techPhone" name="techPhone" placeholder="请输入联系方式" />
								<span class="error-tips"></span>
							</div> -->
							
							<div class="form-topbar examineTitel" style="display: none;  border-left:1px solid #333;border-right:1px solid #333;width:100%;font-weight: bolder;">
								<div class="apply-title" >
									审核信息
								</div>
							</div>
							<table border="1"  class="examine" style="display: none;">
								  <tr>
								      <td>审核状态</td>
								      <td>
										<input type="text" class="form-control" id="audStatus" name="audStatus"/>
								      </td>
								      <td>审核时间</td>
								      <td>
										<input type="text" class="form-control" id="audDate" name="audDate"/>
								      </td>
								  </tr>
								  <tr>
								      <td>审核人</td>
								      <td>
										<input type="text" class="form-control" id="audPerson" name="audPerson"/>
								      </td>
								      <td>审核意见</td>
								      <td>
								  		<input type="text" class="form-control" id="audOpinion" name="audOpinion"/>
									  </td>
								  </tr>
							</table>
							
							<!-- <div class="form-group" data-aud="true" style="display: none;">
								<label >审核状态:</label>
								<input type="text" class="form-control" id="audStatus" name="audStatus"/>
							</div>
							<div class="form-group" data-aud="true" style="display: none;">
								<label >审核时间:</label>
								<input type="text" class="form-control" id="audDate" name="audDate"/>
							</div>
							<div class="form-group" data-aud="true" style="display: none;">
								<label>审核人:</label>
								<input type="text" class="form-control" id="audPerson" name="audPerson"/>
							</div>
							<div class="form-group" data-aud="true" style="display: none;">
								<label>审核意见:</label>
								<input type="text" class="form-control" id="audOpinion" name="audOpinion"/>
							</div> -->
						</form>
						<!-- <hr> -->
						<!-- <div class="center-block">
							<button class="btn btn-save" type="button" id="save_form">保存</button>
							<button class="btn btn-submit" type="button" id="submit_form">提交</button>
							<button class="btn btn-save" type="button" id="review_form" style="display:none;">通过</button>
							<button class="btn btn-submit" type="button" id="rollback_form" style="display:none;">回退</button>
							<button class="btn btn-submit" style="display: none;" type="button" id="back">返回</button>
							<button class="btn btn-submit" style="display: none;" type="button" id="downPdf">导出PDF</button>
						</div> -->
					</div>
					<div class="center-block">
						<button class="btn btn-save" type="button" id="save_form">保存</button>
						<button class="btn btn-submit" type="button" id="submit_form">提交</button>
						<button class="btn btn-save" type="button" id="review_form" style="display:none;">通过</button>
						<button class="btn btn-submit" type="button" id="rollback_form" style="display:none;">回退</button>
						<button class="btn btn-submit" style="display: none;" type="button" id="back">返回</button>
						<button class="btn btn-submit" style="display: none;" type="button" id="downPdf">导出PDF</button>
					</div>
				</div>
			</div>
			<!-- 右侧部分 end-->
		</div>
	</div>
	
	<div class="loading-area hide" id="loading_area" style="background-color:#000;opacity:0.6px;">
		<div id="loading_pic">
			<img src="/images/Loading3.gif">
		</div>
	</div>
	
	<script>
		
	</script>
	<!--component js lib-->
	<script src="${contextPath}/js/component/bootstrap_modal_confirm.min.js"></script>
	<script src="${contextPath}/js/component/pagination.min.js"></script>
	<script src="${contextPath}/js/component/jquery.ui.widget.min.js"></script>
	<script src="${contextPath}/js/component/jquery.iframe-transport.min.js"></script>
	<script src="${contextPath}/js/component/jquery.fileupload.js"></script>
	<script src="${contextPath}/js/component/validation.js"></script>
	<script src="${contextPath}/js/component/laydate.dev.min.js"></script>	
	<script src="${contextPath}/trm_modules/common/front/option.js"></script>
	<script src="${contextPath}/js/component/bootstrap3-typeahead.js"></script>
	<script src="${contextPath}/js/component/json2.js"></script>
	<script src="${contextPath}/js/component/browserdetect.js"></script>
	<!--page js-->
	<script src="${contextPath}/trm_modules/common/ucenter/leftnav.js"></script>
	<script src="${contextPath}/trm_modules/demand/ucenter/apply.js"></script>

</body>
</html>