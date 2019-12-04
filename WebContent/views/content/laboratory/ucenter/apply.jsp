<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags'%>
<sec:authentication property="principal" var="principal"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人中心-服务机构管理-发布机构</title>
<!--component css-->
<!--page css-->
<link rel="stylesheet" href="${contextPath}/css/trm.page.applyEquipment.css">

<style type="text/css">
	table{
		width: 100%;
		table-layout: fixed;
		overflow:hidden; 
		white-space:nowrap; 
	}
	table tr {
    	height: 66px;
	}
	table tr td {
	    padding: 0 5px;
	}
	table tr td:nth-child(odd) {
	    width: auto !important;
	    text-align: left !important;
	    word-wrap:break-word;
	}
	table tr td[colspan="4"] {
	    text-align: center !important;
	}
	.ucenter-content table input {
 	   width: 100%;
	}
	.ue-edit-wrap{
	 width: 100% !important;
	}
	.ucenter-content table select{width:140px !important ;}
	.error-tips{
        font-size: 12px;
	    display: inline-block;
	    width: 72px !important;
	    text-align: center;
	    float: right !important;
	    overflow: hidden !important;
	    text-overflow: ellipsis !important;
	    white-space: normal !important;
	 }
	 .deletePicButton{
	 	color: #f00;
	 	margin-left: 20px;
	 }
	 .uploadBtn{
		color: #FFF;
	    width: 120px;
	    height: 50px;
	    line-height: 40px;
	    position: relative;
	    z-index: 101;
	    text-align: center;
	    background-color: #419ff6;
	    border-color: #419ff6;
    }
    .uploadBtn>input{
	    position: absolute;
	    z-index: 102;
	    left: 0;
	    top: 0;
	    width: 100% !important;
	    height: 100%;
    }
    .deletePicButton{
    	cursor:pointer;
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
						<h3 class="form-content-title">技术服务机构信息表</h3>
				
						<form id="apply_form">
						<!-- <h2>
							<input type="text" id="orgName" name="orgName" placeholder="请输入机构名称">
							<span class="error-tips"></span>
						</h2> -->
						<h1 style="display:none;">发布时间：<span class="createTime"></span>信息来源：<span class="unitName"></span></h1>
						<table border="1" >
					 		<tr>
							      <td>机构名称</td>
							      <td colspan="3">
							     	 <input type="text" class="form-control" id="orgName" name="orgName" placeholder="请输入机构名称">
									 <span class="error-tips"></span>
							      </td>
							 </tr>
							<tr>
								<td>
									<label class="vereist">服务类型:</label>
								</td>
								<td colspan="3">
									<input style="width:40%;" type="text" class="form-control" id="servType" name="servType"  placeholder="请输入服务类型"/>
									<label style="width:60%; color:red; font-size: 12px;">* 建议：技术需求对接类/科技评估类/孵化器类/科技投融资类/管理咨询类</label>
									<span class="error-tips"></span>
								</td>
							</tr>
							<tr>
								<td>
									<label class="vereist">机构地址:</label>
								</td>
								<td> 
									<input style="width:200px;" type="text" class="form-control" id="address" name="address"  placeholder="请输入机构地址"/>
									<span class="error-tips"></span>
								</td>
								<td>
									<label class="vereist">机构邮编:</label>
								</td>
								<td>
									<input type="text" class="form-control" id="postcode" name="postcode"  placeholder="请输入机构邮编" />
									<span class="error-tips"></span>
								</td>
							</tr>
							<tr>
								<td>
									<label class="vereist">机构性质:</label>
								</td>
								<td>
									<select class="form-control" id="property" name="property">
										<option value="">请选择...</option>
										<option value="企业">企业</option>
										<option value="科研院所">科研院所</option>
										<option value="高等院校">高等院校</option>
										<option value="其他">其他</option>
									</select>
									<span class="error-tips"></span>
								</td>
								<td>
									<label class="vereist">机构属性:</label>
								</td>
								<td>
									<select class="form-control" id="attribute" name="attribute">
										<option value="">请选择...</option>
										<option value="国有">国有</option>
										<option value="集体">集体</option>
										<option value="民营">民营</option>
										<option value="其他">其他</option>
									</select>
									<span class="error-tips"></span>
								</td>
							</tr>
							<tr>
								<td colspan="4" style="text-align:left !important;padding-left:15px;font-weight: bolder;">负责人</td>
							</tr>
							<tr>
								<td>
									<label class="vereist">姓名:</label>
								</td>
								<td>
									<input type="text" class="form-control" id="header" name="header"  placeholder="请输入负责人姓名" />
									<span class="error-tips"></span>
								</td>
								<td>
									<label class="vereist">电话:</label>
								</td>
								<td>
									<input type="text" class="form-control" id="headerPhone" name="headerPhone"  placeholder="请输入负责人电话" />
									<span class="error-tips"></span>
								</td>
							</tr>
							<tr>
								<td>
									<label>手机:</label>
								</td>
								<td>
									<input type="text" class="form-control" id="headerMobile" name="headerMobile"  placeholder="请输入负责人手机" />
									<span class="error-tips"></span>
								</td>
								<td>
									<label class="vereist">邮箱:</label>
								</td>
								<td>
									<input type="text" class="form-control" id="headerEmail" name="headerEmail"  placeholder="请输入负责人邮箱" />
									<span class="error-tips"></span>
								</td>
							</tr>
							<tr>
								<td colspan="4" style="text-align:left !important;padding-left:15px;font-weight: bolder;">联系人</td>
							</tr>
							<tr>
								<td>
									<label class="vereist">姓名:</label>
								</td>
								<td>
									<input type="text" class="form-control" id="linker" name="linker"  placeholder="请输入联系人姓名" />
									<span class="error-tips"></span>
								</td>
								<td>
									<label class="vereist">电话:</label>
								</td>
								<td>
									<input type="text" class="form-control" id="linkerPhone" name="linkerPhone"  placeholder="请输入联系人电话" />
									<span class="error-tips"></span>
								</td>
							</tr>
							<tr>
								<td>
									<label class="vereist">手机:</label>
								</td>
								<td>
									<input type="text" class="form-control" id="linkerMobile" name="linkerMobile"  placeholder="请输入联系人手机" />
									<span class="error-tips"></span>
								</td>
								<td>
									<label class="vereist">邮箱:</label>
								</td>
								<td>
									<input type="text" class="form-control" id="linkerEmail" name="linkerEmail"  placeholder="请输入联系人邮箱" />
									<span class="error-tips"></span>
								</td>
							</tr>
							<tr style="height:480px">
								<td>
									<label>机构简介:</label>
								</td>
								<td colspan="3">
									<div class="single-column">
									    <div class="pull-left  ue-edit-wrap" >
											<script id="briefEditor" type="text/plain" style="width:100%;min-height:350px;"> </script>
										</div>
										<textarea class="form-control hidden" rows="8" id="brief_filed" name="brief_filed"></textarea>
										<span class="error-tips"></span>
									</div>
								</td>
							</tr>
							<tr style="height:480px">
								<td>
									<label>人才队伍情况:</label>
								</td>
								<td colspan="3">
									<div class="single-column">
									    
									    <div class="pull-left  ue-edit-wrap" >
											<script id="teamEditor" type="text/plain" style="width:100%;min-height:350px;"> </script>
										</div>
										<textarea class="form-control hidden" rows="8" id="team_filed" name="team_filed"></textarea>
										<span class="error-tips"></span>
									</div>
								</td>
							</tr>
							<tr style="height:480px">
								<td>
								<label>规范化管理水平:</label>
								</td>
								<td colspan="3">
								<div class="single-column">
								    
								    <div class="pull-left  ue-edit-wrap" >
										<script id="mgtLevelEditor" type="text/plain" style="width:100%;min-height:350px;"> </script>
									</div>
									<textarea class="form-control hidden" rows="8" id="mgtLevel_filed" name="mgtLevel_filed"></textarea>
									<span class="error-tips"></span>
								</div>
								</td>
							</tr>
							<tr style="height:480px">
								<td>
									<label>所获资质及荣誉:</label>
								</td>
								<td colspan="3">
								<div class="single-column">
								    <div class="pull-left  ue-edit-wrap" >
										<script id="honorEditor" type="text/plain" style="width:100%;min-height:350px;"> </script>
									</div>
									<textarea class="form-control hidden" rows="8" id="honor_filed" name="honor_filed"></textarea>
									<span class="error-tips"></span>
								</div>
								</td>
							</tr>
							<tr style="height:480px">
								<td>
									<label>技术服务情况:</label>
								</td>
								<td colspan="3">
									<div class="single-column">
								    
								    <div class="pull-left  ue-edit-wrap" >
										<script id="servCaseEditor" type="text/plain" style="width:100%;min-height:350px;"> </script>
									</div>
									<textarea class="form-control hidden" rows="8" id="servCase_filed" name="servCase_filed"></textarea>
									<span class="error-tips"></span>
								</div>
								</td>
							</tr>
							<tr style="height:480px">
								<td>
									<label>承担的重要项目及案例:</label>
								</td>
								<td colspan="3">
									<div class="single-column">
									    <div class="pull-left  ue-edit-wrap" >
											<script id="projectCaseEditor" type="text/plain" style="width:100%;min-height:350px;"> </script>
										</div>
										<textarea class="form-control hidden" rows="8" id="projectCase_filed" name="projectCase_filed"></textarea>
										<span class="error-tips"></span>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="4" style="text-align:left !important;padding-left:15px;font-weight: bolder;">随附材料</td>
							</tr>
							<tr>
								<td>
									<label>法人营业执照副本扫描件:</label>
								</td>
								<td colspan="3">
									<div class="single-column">
										<div class="btn btn-default uploadBtn">上传
											<input id="uploadFile1" name="files" type="file">
										</div>
									   	<div class="img-upload-area">
										   <ul id="attachment_file1" class="file-mgtArea-list">
											   <li class="btn btn-default owner-img hide" id="fileNameList1"></li>
										   </ul>
									   	</div>
									   <span class="error-tips"></span>						
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<label>组织机构代码证书扫描件:</label>
								</td>
								<td colspan="3">
									<div class="single-column">
										<div class="btn btn-default uploadBtn">上传
											<input id="uploadFile2" name="files" type="file">
										</div>
									   	<div class="img-upload-area">
										   <ul id="attachment_file2" class="file-mgtArea-list">
											   <li class="btn btn-default owner-img hide" id="fileNameList2"></li>
										   </ul>
									   	</div>
									   <span class="error-tips"></span>						
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<label>税务登记证书扫描件:</label>
								</td>
								<td colspan="3">
									<div class="single-column">
										<div class="btn btn-default uploadBtn">上传
											<input id="uploadFile3" name="files" type="file">
										</div>
									   	<div class="img-upload-area">
										   <ul id="attachment_file3" class="file-mgtArea-list">
											   <li class="btn btn-default owner-img hide" id="fileNameList3"></li>
										   </ul>
									   	</div>
									   <span class="error-tips"></span>						
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<label>资质及荣誉证书扫描件:</label>
								</td>
								<td colspan="3">
									<div class="single-column">
										<div class="btn btn-default uploadBtn">上传
											<input id="uploadFile4" name="files" type="file">
										</div>
									   	<div class="img-upload-area">
										   <ul id="attachment_file4" class="file-mgtArea-list">
											   <li class="btn btn-default owner-img hide" id="fileNameList4"></li>
										   </ul>
									   	</div>
									   <span class="error-tips"></span>						
									</div>
								</td>
							</tr>
							<tr data-aud="true" style="display: none;">
								<td colspan="4">
									<div class="apply-title">
										审核信息
									</div>
								</td>
							</tr>
							<tr data-aud="true" style="display: none;">
								<td>
									<label >审核状态:</label>
								</td>
								<td colspan="3">
									<input type="text" class="form-control" id="audStatus" name="audStatus"/>
								</td>
							</tr>
							<tr data-aud="true" style="display: none;">
								<td>
									<label>审核人:</label>
								</td>
								<td>
									<input type="text" class="form-control" id="audPerson" name="audPerson"/>
								</td>
								<td>
									<label >审核时间:</label>
								</td>
								<td>
									<input type="text" class="form-control" id="audDate" name="audDate"/>
								</td>
							</tr>
							<tr data-aud="true" style="display: none;">
								<td>
									<label>审核意见:</label>
								</td>
								<td colspan="3">
									<input type="text" class="form-control" id="audOpinion" name="audOpinion"/>
								</td>
							</tr>
							</table>
							</form>
						<!-- <hr>
						<div class="center-block" style="clear:both;padding-top: 20px;">
							<button class="btn btn-save" type="button" id="save_form">保存</button>
							<button class="btn btn-submit" type="button" id="submit_form">提交</button>
							<button class="btn btn-save" type="button" id="review_form" style="display:none;">通过</button>
							<button class="btn btn-submit" type="button" id="rollback_form" style="display:none;">回退</button>
							<button class="btn btn-submit" type="button" id="back" style="display:none;">返回</button>
							<button class="btn btn-submit" type="button" id="downPdf" style="display:none;">导出PDF</button>
						</div> -->
					</div>
					<div class="center-block" style="clear:both;padding-top: 20px;">
						<button class="btn btn-save" type="button" id="save_form">保存</button>
						<button class="btn btn-submit" type="button" id="submit_form">提交</button>
						<button class="btn btn-save" type="button" id="review_form" style="display:none;">通过</button>
						<button class="btn btn-submit" type="button" id="rollback_form" style="display:none;">回退</button>
						<button class="btn btn-submit" type="button" id="back" style="display:none;">返回</button>
						<button class="btn btn-submit" type="button" id="downPdf" style="display:none;">导出PDF</button>
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
	<script src="${contextPath}/js/component/jquery.fileupload_M.js"></script>
	<script src="${contextPath}/js/component/validation.js"></script>
	<script src="${contextPath}/js/component/laydate.dev.min.js"></script>	
	<script src="${contextPath}/trm_modules/common/front/option.js"></script>
	<script src="${contextPath}/js/component/json2.js"></script>
	<script src="${contextPath}/js/component/browserdetect.js"></script>
	<script src="${contextPath}/js/component/bootstrap3-typeahead.js"></script>
	<!--page js-->
	<script src="${contextPath}/trm_modules/common/ucenter/leftnav.js"></script>
	<script src="${contextPath}/trm_modules/laboratory/ucenter/apply.js"></script>
</body>
</html>