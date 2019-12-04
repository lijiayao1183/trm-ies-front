<!--
	@page 发布设备页
	@author xuxingjie
	@time 2017-10-24
	@history 新建页面	v1.0
-->
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags'%>
<sec:authentication property="principal" var="principal"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人中心-设备管理-发布设备</title>
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
						<h3 class="form-content-title">军民共享资源信息表</h3>
					
						<form id="apply_form">
							<h1 style="display:none;">发布时间：<span class="applyDate"></span>信息来源：<span class="linkUnit">${principal.session.orgName}</span></h1>
							<table border="1">
								  <tr>
								      <td>设备名称</td>
								      <td colspan="3">
								      	<input type="text" class="form-control" id="equipName" name="equipName"  placeholder="请输入设备名称(限50字)" maxlength = "50">
								      	<span class="error-tips"></span>
								      </td>
								  </tr>
								  <tr style="height:200px;">
								      <td>设备图片</td>
								      <td  colspan="3" >
								      	<!-- 图片一 -->	
								      	<div class="single-column">
											<div class="img-upload-area" id="img_filed1">
												<ul name="equip_img1" class="file-area-list">
													<li class="owner-img" id="fileNameList1">
														<input id="uploadFile1" name="files" type="file">
														<span class="error-tips"></span>
													</li>
												</ul>
											</div>							
										</div>
										<!-- 图片二 -->	
										<div class="single-column">
											<div class="img-upload-area" id="img_filed1">
												<ul name="equip_img2" class="file-area-list">
													<li class="owner-img" id="fileNameList2">
														<input id="uploadFile2" name="files" type="file">
														<span class="error-tips"></span>
													</li>
												</ul>
											</div>							
										</div>
										<!-- 图片三 -->
										<div class="single-column">
											<div class="img-upload-area" id="img_filed1">
												<ul name="equip_img3" class="file-area-list">
													<li class="owner-img" id="fileNameList3">
														<input id="uploadFile3" name="files" type="file">
														<span class="error-tips"></span>
													</li>
												</ul>
											</div>							
										</div>	
										<span class="uploadfile-tips" style="margin-top:42px;"><i style="color:red;font-style:normal;">注:</i>请上传小于5M的jpg或png文件，超出限制则无法上传</span>	
								      </td>
								  </tr>
								  <tr>
								      <td>设备设施类别</td>
								      <td colspan="3" class="olay" value="" style="position:relative;">
								      	<select class="form-control" id="aMilitaryTestEquip" name="aMilitaryTestEquip">
											<option id="0">请选择...</option>
										</select>
										<select class="form-control" id="aMilitaryResearchEquip" name="aMilitaryResearchEquip">
											<option id="0">请选择...</option> 
										</select>
								      	<span class="uploadfile-tips" style="margin-top:10px;display:inline-block;"><i style="color:red;font-style:normal;">注:</i>单选</span>	
										<span class="error-tips sheibeiError" style="margin-left: 120px;"></span>
								      </td>
								  </tr>
								  <tr>
								      <td>服务领域</td>
								      <td colspan="3" style="position:relative">
								      	<div class="form-group">
											<div class="col-sm-4" >
												<select id="usertype" name="usertype" class="selectpicker form-control show-tick" multiple data-width="auto" data-live-search="false" title="请选择服务领域...">
												</select> 
											</div>
										  </div>	
										  <span class="error-tips usertypeError" style="margin-left: 120px;"></span>
										 <span class="uploadfile-tips" style="position:absolute;top:25px;right:5px;display:inline-block;"><i style="color:red;font-style:normal;">注:</i>多选</span>	
								      
								      	<!-- <div class="checkbox-wrap" style="margin-top: -34px;" id="aServiceRanges">
										</div> -->
										
								      </td>
								  </tr>
								  <tr>
								      <td>制造厂商</td>
								      <td>
								      	<input type="text" class="form-control" id="createFirm" name="createFirm"  placeholder="请输入制造厂商"/>
										<span class="error-tips"></span>
								      </td>
								      <td>生产国别</td>
								      <td>
								      	<input type="text" class="form-control" id="proCountry" name="proCountry"  placeholder="请输入生产国别" />
										<span class="error-tips"></span>
								      </td>
								  </tr>
								  <tr>
								      <td>购置日期</td>
								      <td>
								      	<input type="text" class="form-control" id="purchaseDate" name="purchaseDate"  placeholder="请输入购置日期" />
										<span class="error-tips"></span>
								      </td>
								      <td >规格型号</td>
								      <td>
								      	<input type="text" class="form-control" id="equipVerCode" name="equipVerCode"  placeholder="请输入规格型号"/>
										<span class="error-tips"></span>
									  </td>
								  </tr>
								  <tr>
								      <td>搜索关键字</td>
								      <td  colspan="3" >
								      	<input type="text" class="form-control" id="keyWords" name="keyWords" placeholder="若输入多个关键字，请以；号隔开" />
										<span class="error-tips" id="error-tips-applyerAdd"></span>
								      </td>
								  </tr>
								  <tr>
								      <td>主要技术指标</td>
								      <td  colspan="3" >
								      	<textarea rows="8" style="width: 55%;padding: 0 10px;" id="qualification" name="qualification" placeholder="请输入主要技术指标" maxlength="1000"></textarea>
										<span class="error-tips"></span>
								      </td>
								  </tr>
								  <tr>
								      <td>功能应用范围</td>
								      <td colspan="3" >
								      	<textarea rows="8" style="width: 55%;padding: 0 10px;" id="useField" name="useField" placeholder="请输入功能应用范围" maxlength="1000"></textarea>
										<span class="error-tips"></span>
								      </td>
								  </tr>
								  <tr>
								      <td>技术特色</td>
								      <td colspan="3" >
								      	<textarea rows="8" style="width: 55%;padding: 0 10px;" id="tecFeature" name="tecFeature" placeholder="请输入技术特色" maxlength="1000"></textarea>
										<span class="error-tips"></span>
								      </td>
								  </tr>
								  <tr>
								      <td>服务方式</td>
								      <td>
								      	<select class="form-control" id="serviceMode" name="serviceMode">
											<option value="">请选择...</option>
											<option value="对外服务">对外服务 </option>
											<option value="闲置租赁">闲置租赁</option>
											<option value="闲置转让">闲置转让</option>
										</select>
										<span class="error-tips"></span>
								      </td>
								       <td>服务费</td>
								      <td>
								      	<input type="text" class="form-control" id="equipValue" name="equipValue" placeholder="请输入服务费（格式100万元/小时或200万元/天等）" />
										<span class="error-tips"></span>
								      </td>
								  </tr>
								  <tr>
								      <td>持有单位</td>
								      <td colspan="3" >
								      	<input type="text" class="form-control" disabled id="linkUnit" name="linkUnit" value="${principal.session.orgName}" />
										<span class="error-tips"></span>
								      </td>
								  </tr>
								  <tr>
								      <td>单位地址</td>
								      <td colspan="3" >
								      	<input type="text" class="form-control" disabled id="linkAddress" name="linkAddress" value="${principal.session.address}" style="width:100%;"/>
										<span class="error-tips"></span>
								      </td>
								  </tr>
								  <tr>
								      <td>联系人</td>
								      <td  colspan="3" >
								      	<input type="text" class="form-control" id="linkPerson" name="linkPerson" />
										<span class="error-tips"></span>
								      </td>
								  </tr>
								  <tr>
								  	<td>电子邮件</td>
								      <td  >
								      	<input type="text" class="form-control" id="email" name="email" placeholder="请输入电子邮箱"/>
										<span class="error-tips"></span>
								      </td>
								      <td>联系方式</td>
								      <td colspan="3" >
											<input type="text" class="form-control" id="linkPhone" name="linkPhone" />
											<span class="error-tips"></span>
									   </td>
								      
								  </tr>
								  <tr data-aud="true" style="display: none;">
								  	<td colspan="4" style="text-align:left !important;padding-left:15px;font-weight: bolder;">审核信息</td>
								  </tr>
								  <tr data-aud="true" style="display: none;">
								      <td>审核状态</td>
								      <td>
										<input type="text" class="form-control" id="audStatus" name="audStatus"/>
								      </td>
								      <td>审核时间</td>
								      <td>
										<input type="text" class="form-control" id="audDate" name="audDate"/>
								      </td>
								  </tr>
								  <tr data-aud="true" style="display: none;">
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
						</form>
						<!-- <hr>
						<div class="center-block">
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
	<script src="${contextPath}/js/component/json2.js"></script>
	<script src="${contextPath}/js/component/browserdetect.js"></script>
	<!--page js-->
	<script src="${contextPath}/trm_modules/common/ucenter/leftnav.js"></script>
	<script src="${contextPath}/trm_modules/equipment/ucenter/apply.js"></script>
</body>

</html>