package com.trm.model.techservorg;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trm.model.common.CommonRequest;

public class TechServOrgReq extends CommonRequest {
	
	private String department;
	private String handler;
	private String audStatus;
	
	private Integer id;
	private Integer userId;
	
	private String orgName;
	private String servType;
	private String property;
	private String attribute;
    private Date createStartTime;//新增开始时间
    private Date createEndTime;//新增结束时间
    
    private Date audStartDate;//审核开始时间
    private Date audEndDate;//审核结束时间
    
    private String keyword;
    
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getCreateStartTime() {
        return createStartTime;
    }
    public void setCreateStartTime(Date createStartTime) {
        this.createStartTime = createStartTime;
    }
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getCreateEndTime() {
        return createEndTime;
    }
    public void setCreateEndTime(Date createEndTime) {
        this.createEndTime = createEndTime;
    }
    public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
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
	public Date getAudStartDate() {
		return audStartDate;
	}
	public void setAudStartDate(Date audStartDate) {
		this.audStartDate = audStartDate;
	}
	public Date getAudEndDate() {
		return audEndDate;
	}
	public void setAudEndDate(Date audEndDate) {
		this.audEndDate = audEndDate;
	}
	public String getAudStatus() {
		return audStatus;
	}
	public void setAudStatus(String audStatus) {
		this.audStatus = audStatus;
	}
	
	@Override
	public String toString() {
		return "TechServOrgReq [department=" + department + ", handler=" + handler + ", audStatus=" + audStatus
				+ ", id=" + id + ", userId=" + userId + ", orgName=" + orgName + ", servType=" + servType
				+ ", property=" + property + ", attribute=" + attribute + ", createStartTime=" + createStartTime
				+ ", createEndTime=" + createEndTime + ", audStartDate=" + audStartDate + ", audEndDate=" + audEndDate
				+ ", keyword=" + keyword + "]";
	}
	
}
