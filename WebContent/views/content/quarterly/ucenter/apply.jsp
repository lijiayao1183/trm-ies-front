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
<style>
	.ucenter-content .form-group label:first-child{width:180px;}
	.layui-laydate-content {
	    height: 230px;
	    overflow: hidden;
	}
</style>
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
						<h3 class="form-content-title">服务成效报告表</h3>
					
						<form id="apply_form">
							<h2  style="display:none;"><span class="year"></span> 年第  <span class="quarter"></span>  季度 <span class="user">${principal.session.orgName}</span>服务成效报告表</h2>
							<h1 style="display:none;">发布时间：<span class="applyDate"></span>信息来源：<span class="linkUnit"></span></h1>
							
							<table border="1">
								 <tr class="year-filed" >
									 <td>年份</td>
									 <td  colspan="3" >
										<input type="text" class="form-control" id="reportYear" name="reportYear" placeholder="请选择时间">
										<span class="error-tips"></span>
									 </td>
								 </tr>
								 <tr class="quart-filed" >
									 <td>季度</td>
									 <td  colspan="3" >
										 <select class="form-control" id="reportQuart" name="reportQuart">
											<option value="" selected >请选择...</option>
											<option value="1">第一季度</option>
											<option value="2">第二季度</option>
											<option value="3">第三季度</option>
											<option value="4">第四季度</option>
										</select>
										<span class="error-tips"></span>
									 </td>
								 </tr>
								 <tr class="unitname-filed" >
									 <td>单位名称</td>
									 <td  colspan="3" >
										<input type="text" class="form-control" id="unitName"  name="reportYear" disabled="disabled">
										<span class="error-tips"></span>
									 </td>
								 </tr>
								 
								 <tr height="20px">
								    <td colspan="6" style="text-align:left;padding-left:15px;font-weight: bolder;">设施设备数量</td>
								  </tr>
								 <tr>
									 <td>本季度共享设备数(台/套)</td>
									 <td>
										<input type="text" class="form-control" id="equipSum"  name="equipSum" >
										<span class="error-tips"></span>
									 </td>
									 <td>本季度共享设施数(个)</td>
									 <td>
										<input type="text" class="form-control" id="facilitySum"  name="facilitySum" >
										<span class="error-tips"></span>
									 </td>
								 </tr>
								 <tr height="20px">
								    <td colspan="6" style="text-align:left;padding-left:15px;font-weight: bolder;">共享服务情况</td>
								  </tr>
								 <tr>
									 <td>对外检测样品总数(个)</td>
									 <td  colspan="3" >
										<input type="text" class="form-control" id="sumItem1"  name="sumItem1" >
										<span class="error-tips"></span>
									 </td>
								 </tr>
								 <tr>
									 <td>对外服务总机时数(小时)</td>
									 <td  colspan="3" >
										<input type="text" class="form-control" id="sumItem2"  name="sumItem2" >
										<span class="error-tips"></span>
									 </td>
								 </tr>
								 <tr>
									 <td>对外服务总金额(元)</td>
									 <td  colspan="3" >
										<input type="text" class="form-control" id="sumItem3"  name="sumItem3" >
										<span class="error-tips"></span>
									 </td>
								 </tr>
								  <tr height="20px">
								    <td colspan="6" style="text-align:left;padding-left:15px;font-weight: bolder;">服务对象所在地</td>
								  </tr>
								 <tr>
									 <td>省市区域数量(个)</td>
									 <td  colspan="3" >
										<input type="text" class="form-control" id="inProvinceCount"  name="inProvinceCount" >
										<span class="error-tips"></span>
									</td>
								 </tr>
								 <tr>
									 <td>其中西安数量(个)/td>
									 <td  colspan="3" >
										<input type="text" class="form-control" id="xianCount"  name="xianCount" >
										<span class="error-tips"></span>
									 </td>
								 </tr>
								 <tr>
									 <td>外省区域数量(个)</td>
									 <td  colspan="3" >
										<input type="text" class="form-control" id="outProvinceCount"  name="outProvinceCount" >
										<span class="error-tips"></span>
									 </td>
								 </tr>
								  <tr height="20px">
								    <td colspan="6" style="text-align:left;padding-left:15px;font-weight: bolder;">主要服务内容</td>
								  </tr>
								 <tr>
									 <td>主要服务内容</td>
									 <td  colspan="3" >
										<textarea class="form-control" style="height: 120px !important;width: 478px;" rows="10" id="serviceItem"  name="serviceItem" placeholder="限1000字"onchange="this.value=this.value.substring(0, 1000)" onkeydown="this.value=this.value.substring(0, 1000)" onkeyup="this.value=this.value.substring(0, 1000)"></textarea>
										<span class="error-tips"></span>
									 </td>
								 </tr>
								  <tr height="20px">
								    <td colspan="6" style="text-align:left;padding-left:15px;font-weight: bolder;">对外服务典型事例</td>
								  </tr>
								 <tr>
									 <td>事例名称</td>
									 <td  colspan="3" >
										<input type="text" class="form-control" id="caseName"  name="caseName" placeholder="限100字"onchange="this.value=this.value.substring(0, 100)" onkeydown="this.value=this.value.substring(0, 100)" onkeyup="this.value=this.value.substring(0, 100)" />
										<span class="error-tips"></span>
									 </td>
								 </tr>
								  <tr>
									 <td>服务对象</td>
									 <td  colspan="3" >
										<textarea class="form-control" style="height: 120px !important;width: 478px;" rows="10" id="caseObj"  name="caseObj" placeholder="限500字 ，服务的单位、部门或项目名称及情况简介"onchange="this.value=this.value.substring(0, 500)" onkeydown="this.value=this.value.substring(0, 500)" onkeyup="this.value=this.value.substring(0, 500)"></textarea>
										<span class="error-tips"></span>
									 </td>
								 </tr>
								 <tr>
									 <td>服务内容</td>
									 <td  colspan="3" > 
										<textarea class="form-control" style="height: 120px !important;width: 478px;" rows="10" id="caseBrief"  name="caseBrief" placeholder="限1000字，服务对象存在的实际问题及问题解决途径"onchange="this.value=this.value.substring(0, 1000)" onkeydown="this.value=this.value.substring(0, 1000)" onkeyup="this.value=this.value.substring(0, 1000)"></textarea>
										<span class="error-tips"></span>
									 </td>
								 </tr>
								 <tr>
									 <td>服务效果</td>
									 <td  colspan="3" > 
										<textarea class="form-control" style="height: 120px !important;width: 478px;" rows="10" id="caseEffect"  name="caseEffect" placeholder="限1000字，具体解决了什么问题，达到了什么样的状态，与之前相比有何改进，取得了什么样的社会经济效益"onchange="this.value=this.value.substring(0, 1000)" onkeydown="this.value=this.value.substring(0, 1000)" onkeyup="this.value=this.value.substring(0, 1000)"></textarea>
										<span class="error-tips"></span>
									 </td>
								 </tr>
							</table>
							
							
						</form>
						<!-- <hr>
						<div class="center-block">
							<button class="btn btn-save" type="button" id="save_form">保存</button>
							<button class="btn btn-submit" type="button" id="submit_form">提交</button>
							<button class="btn btn-submit" style="display: none;" type="button" id="back">返回</button>
							<button class="btn btn-submit" style="display: none;" type="button" id="downPdf">导出PDF</button>
						</div> -->
					</div>
					<div class="center-block">
						<button class="btn btn-save" type="button" id="save_form">保存</button>
						<button class="btn btn-submit" type="button" id="submit_form">提交</button>
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
	<script src="${contextPath}/js/component/laydate_v5.0.9/laydate.js"></script>	
	<script src="${contextPath}/trm_modules/common/front/option.js"></script>
	<script src="${contextPath}/js/component/bootstrap3-typeahead.js"></script>
	<script src="${contextPath}/js/component/json2.js"></script>
	<script src="${contextPath}/js/component/browserdetect.js"></script>
	<!--page js-->
	<script src="${contextPath}/trm_modules/common/ucenter/leftnav.js"></script>
	<script src="${contextPath}/trm_modules/quarterly/ucenter/apply.js"></script>
</body>
</html>