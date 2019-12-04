package com.trm.model.techservorg;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TechServOrgSimDetail {

	private Integer id;
	private String orgName;
	private String servType;
	private String property;
	private String attribute;
	private Date createTime;
	private Date audDate;

    public TechServOrgSimDetail() {
        super();
    }

	public TechServOrgSimDetail(Integer id, String orgName, String servType, String property, String attribute,
			Date createTime, Date audDate) {
		super();
		this.id = id;
		this.orgName = orgName;
		this.servType = servType;
		this.property = property;
		this.attribute = attribute;
		this.createTime = createTime;
		this.audDate = audDate;
	}

	public TechServOrgSimDetail(Integer id, String orgName, String servType, String property, String attribute, Date createTime) {
		super();
		this.id = id;
		this.orgName = orgName;
		this.servType = servType;
		this.property = property;
		this.attribute = attribute;
		this.createTime = createTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getAudDate() {
		return audDate;
	}

	public void setAudDate(Date audDate) {
		this.audDate = audDate;
	}

	@Override
	public String toString() {
		return "TechServOrgSimDetail [id=" + id + ", orgName=" + orgName + ", servType=" + servType + ", property="
				+ property + ", attribute=" + attribute + ", createTime=" + createTime + ", audDate=" + audDate + "]";
	}

}
