package com.trm.model.techservorg;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TechServOrgCenterDetail {

	private Integer id;
	private String department;
	private String handler;
	private String orgName;
	private String servType;
	private String property;
	private String attribute;
	private Date audDate;
	private String audStatus;
	private String userType;

    public TechServOrgCenterDetail() {
        super();
    }

	public TechServOrgCenterDetail(Integer id, String department, String handler, String orgName, String servType,
			String property, String attribute, Date audDate, String audStatus, String userType) {
		super();
		this.id = id;
		this.department = department;
		this.handler = handler;
		this.orgName = orgName;
		this.servType = servType;
		this.property = property;
		this.attribute = attribute;
		this.audDate = audDate;
		this.audStatus = audStatus;
		this.userType = userType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getServType() {
		return servType;
	}

	public void setServType(String servType) {
		this.servType = servType;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getAudDate() {
		return audDate;
	}

	public void setAudDate(Date audDate) {
		this.audDate = audDate;
	}

	public String getAudStatus() {
		return audStatus;
	}

	public void setAudStatus(String audStatus) {
		this.audStatus = audStatus;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "TechServOrgCenterDetail [id=" + id + ", department=" + department + ", handler=" + handler
				+ ", orgName=" + orgName + ", servType=" + servType + ", property=" + property + ", attribute="
				+ attribute + ", audDate=" + audDate + ", audStatus=" + audStatus + ", userType=" + userType + "]";
	}

}
