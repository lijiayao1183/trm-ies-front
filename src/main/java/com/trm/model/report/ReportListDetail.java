package com.trm.model.report;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReportListDetail{

	private Integer id;
	private Integer reportYear;
	private Integer reportQuart;
	private String reportName;
	private Date createTime;
	private String username;
	private String reportStatus;
	
	public ReportListDetail() {
		super();
	}
	
	public ReportListDetail(Integer id, Integer reportYear, Integer reportQuart, String reportName, Date createTime,
			String username, String reportStatus) {
		super();
		this.id = id;
		this.reportYear = reportYear;
		this.reportQuart = reportQuart;
		this.reportName = reportName;
		this.createTime = createTime;
		this.username = username;
		this.reportStatus = reportStatus;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getReportStatus() {
		return reportStatus;
	}
	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}

	@Override
	public String toString() {
		return "ReportListDetail [id=" + id + ", reportYear=" + reportYear + ", reportQuart=" + reportQuart
				+ ", reportName=" + reportName + ", createTime=" + createTime + ", username=" + username
				+ ", reportStatus=" + reportStatus + "]";
	}
	
}