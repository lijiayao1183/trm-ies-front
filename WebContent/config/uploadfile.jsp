<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<div style="height: 45px;border-bottom: 1px solid #CCC;width: 1200px;margin-left: 50px;">
		<h4 class="pull-left">上传附件</h4>
		<div class="apply-btn pull-right">
			<div class="btn btn-default big" style="position: relative;" id="addfile">新增<input class="fileInput" style="width: 80px;height: 30px;position: absolute;top: -2px;left: 0px;" id="uploadFile" name="files" type="file" /></div>
			<div class="btn btn-default big" id="Savefile">保存</div>
			<div class="btn btn-default big" id="closefile" onclick="Confirm.hide()">关闭</div>
		</div>
	</div>
	<div class="fileType-area">
		<div class="filetypetile">证明材料</div>
		<div class="invention-file">
			<div class="active fileNav" code="fileType01">国家知识产权局专利收费收据</div>
			<div class="fileNav" code="fileType02">费用减缴审批通知书或缴纳申请费通知书</div>
			<div class="personal-file hidden fileNav" code="fileType03">专利申报人地址归属于西安市辖区内的相关证明材料</div>
		</div>
		<div class="warrant-file">
			<div class="active fileNav" code="fileType04">专利证书</div>
			<div class="fileNav" code="fileType05">国家知识产权局专利收费收据</div>
			<div class="fileNav" code="fileType06">办理登记手续通知书</div>
		</div>
		<div class="entrust-file">
			<div class="active fileNav" code="fileType07">委托协议证明材料</div>
		</div>
	</div>
	<div class="filerighttable">
		<table class="table hidden" id="fileType01">
			<thead>
				<tr>
					<th class="w80">序号</th>
					<th class="w410">文件名称</th>
					<th class="w120">文件格式</th>
					<th class="w120">操作</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
		<table class="table hidden" id="fileType02">
			<thead>
				<tr>
					<th class="w80">序号</th>
					<th class="w410">文件名称</th>
					<th class="w120">文件格式</th>
					<th class="w120">操作</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
		<table class="table hidden" id="fileType03">
			<thead>
				<tr>
					<th class="w80">序号</th>
					<th class="w410">文件名称</th>
					<th class="w120">文件格式</th>
					<th class="w120">操作</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
		<table class="table hidden" id="fileType04">
			<thead>
				<tr>
					<th class="w80">序号</th>
					<th class="w410">文件名称</th>
					<th class="w120">文件格式</th>
					<th class="w120">操作</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
		<table class="table hidden" id="fileType05">
			<thead>
				<tr>
					<th class="w80">序号</th>
					<th class="w410">文件名称</th>
					<th class="w120">文件格式</th>
					<th class="w120">操作</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
		<table class="table hidden" id="fileType06">
			<thead>
				<tr>
					<th class="w80">序号</th>
					<th class="w410">文件名称</th>
					<th class="w120">文件格式</th>
					<th class="w120">操作</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
		<table class="table hidden" id="fileType07">
			<thead>
				<tr>
					<th class="w80">序号</th>
					<th class="w410">文件名称</th>
					<th class="w120">文件格式</th>
					<th class="w120">操作</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
		<div class="upload-tips">
			<p style="font-size:14px">上传说明</p>
			<p>1。文件大小：文件大小不得超过2MB。</p>
			<p>2。文件格式：系统支持文件格式为png、jpg、jpeg、bmp、gif、doc、docx、xls、xlsx、pdf、zip、rar格式。</p>
			<p class="enUpload-tips">3。证明材料：每一项申请材料为必传项，上传张数根据实际情况不唯一。</p>
		</div>
	</div>
</div>