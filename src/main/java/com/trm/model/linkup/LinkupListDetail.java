package com.trm.model.linkup;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LinkupListDetail {

	private Integer id;
	private String title;
	private String unitName;
	private String department;
	private String username;
	private Date createTime;
	private Date replyDate;
	private String replyStatus;
	
	public LinkupListDetail() {
		super();
	}
	
	public LinkupListDetail(Integer id, String title, String unitName, String department, String username,
			Date createTime, Date replyDate, String replyStatus) {
		super();
		this.id = id;
		this.title = title;
		this.unitName = unitName;
		this.department = department;
		this.username = username;
		this.createTime = createTime;
		this.replyDate = replyDate;
		this.replyStatus = replyStatus;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
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
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	public String getReplyStatus() {
		return replyStatus;
	}
	public void setReplyStatus(String replyStatus) {
		this.replyStatus = replyStatus;
	}
	
	@Override
	public String toString() {
		return "LinkupListDetail [id=" + id + ", title=" + title + ", unitName=" + unitName + ", department="
				+ department + ", username=" + username + ", createTime=" + createTime + ", replyDate=" + replyDate
				+ ", replyStatus=" + replyStatus + "]";
	}

}