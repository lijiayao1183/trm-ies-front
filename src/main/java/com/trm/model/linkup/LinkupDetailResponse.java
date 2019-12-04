package com.trm.model.linkup;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LinkupDetailResponse {

	private Integer id;
	private String username;
	private String linkMan;
	private String unitName;
	private String department;
	private String linkPhone;
	private String email;
	private String title;
	private String leaveMsg;
	private Date createTime;
	private String replyMsg;
	private String replyStatus;
	private Date replyDate;
	private String replyPerson;
	
	public LinkupDetailResponse() {
		super();
	}
	
	public LinkupDetailResponse(Integer id, String username, String linkMan, String unitName, String department, String linkPhone, String email,
			String title, String leaveMsg, Date createTime, String replyMsg, String replyStatus, Date replyDate,
			String replyPerson) {
		super();
		this.id = id;
		this.username = username;
		this.linkMan = linkMan;
		this.unitName = unitName;
		this.department = department;
		this.linkMan = linkMan;
		this.linkPhone = linkPhone;
		this.email = email;
		this.title = title;
		this.leaveMsg = leaveMsg;
		this.createTime = createTime;
		this.replyMsg = replyMsg;
		this.replyStatus = replyStatus;
		this.replyDate = replyDate;
		this.replyPerson = replyPerson;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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

	public String getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	public String getLinkPhone() {
		return linkPhone;
	}
	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLeaveMsg() {
		return leaveMsg;
	}
	public void setLeaveMsg(String leaveMsg) {
		this.leaveMsg = leaveMsg;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getReplyMsg() {
		return replyMsg;
	}
	public void setReplyMsg(String replyMsg) {
		this.replyMsg = replyMsg;
	}
	public String getReplyStatus() {
		return replyStatus;
	}
	public void setReplyStatus(String replyStatus) {
		this.replyStatus = replyStatus;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	public String getReplyPerson() {
		return replyPerson;
	}
	public void setReplyPerson(String replyPerson) {
		this.replyPerson = replyPerson;
	}

	@Override
	public String toString() {
		return "LinkupDetailResponse [id=" + id + ", username=" + username + ", linkMan=" + linkMan + ", unitName="
				+ unitName + ", department=" + department + ", linkPhone=" + linkPhone + ", email=" + email + ", title="
				+ title + ", leaveMsg=" + leaveMsg + ", createTime=" + createTime + ", replyMsg=" + replyMsg
				+ ", replyStatus=" + replyStatus + ", replyDate=" + replyDate + ", replyPerson=" + replyPerson + "]";
	}
	
}