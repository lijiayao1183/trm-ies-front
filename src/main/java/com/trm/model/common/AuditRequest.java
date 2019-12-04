package com.trm.model.common;

import java.util.Date;

public class AuditRequest {
	
	/**
	 * 设备设施1/需求2/技术服务机构3/季报4
	 */
	private String auditType;
	
	/**
	 * 设备/需求/技术服务机构/季报各表中的id
	 */
	private Integer auditId;
	
	/**
	 * 当前用户
	 */
	private String auditor;
	
	/**
	 * 呈报单位审核1/科工办审核2
	 */
	private String station;
	
	/**
	 * 未提交F0;待审核F1;呈报单位审核已通过A2;呈报单位审核未通过A3;科工办审核已通过F2;科工办审核未通过F3;
	 */
	private String status;
	
	/**
	 * 审核意见
	 */
	private String auditMsg;
	
	private Date auditDate;
	
	public String getAuditType() {
		return auditType;
	}
	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}
	public Integer getAuditId() {
		return auditId;
	}
	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}
	public String getAuditor() {
		return auditor;
	}
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAuditMsg() {
		return auditMsg;
	}
	public void setAuditMsg(String auditMsg) {
		this.auditMsg = auditMsg;
	}
	public Date getAuditDate() {
		return auditDate;
	}
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}
	
}
