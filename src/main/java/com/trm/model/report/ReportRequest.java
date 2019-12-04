package com.trm.model.report;

import java.util.Date;

import com.trm.model.common.CommonRequest;

public class ReportRequest extends CommonRequest{
	
	private Integer userId;
	private String department;
	private String username;
	private Integer reportYear;
	private Integer reportQuart;
	private String reportStatus;
	private Date createStartTime;
	private Date createEndTime;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getReportYear() {
		return reportYear;
	}
	public void setReportYear(Integer reportYear) {
		this.reportYear = reportYear;
	}
	public Integer getReportQuart() {
		return reportQuart;
	}
	public void setReportQuart(Integer reportQuart) {
		this.reportQuart = reportQuart;
	}
	public String getReportStatus() {
		return reportStatus;
	}
	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}
	public Date getCreateStartTime() {
		return createStartTime;
	}
	public void setCreateStartTime(Date createStartTime) {
		this.createStartTime = createStartTime;
	}
	public Date getCreateEndTime() {
		return createEndTime;
	}
	public void setCreateEndTime(Date createEndTime) {
		this.createEndTime = createEndTime;
	}
	
	@Override
	public String toString() {
		return "ReportRequest [userId=" + userId + ", department=" + department + ", username=" + username
				+ ", reportYear=" + reportYear + ", reportQuart=" + reportQuart + ", reportStatus=" + reportStatus
				+ ", createStartTime=" + createStartTime + ", createEndTime=" + createEndTime + "]";
	}
	
}
