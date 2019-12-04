package com.trm.model.linkup;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trm.model.common.CommonRequest;

public class LinkupRequest extends CommonRequest {

	private Integer userId;
	private String unitName;
	private String department;
	private String title;
	private String replyStatus;
	private String username;
	private String linkMan;
	private Date leaveStartTime;
    private Date leaveEndTime;
    private Date replyStartTime;
    private Date replyEndTime;
    
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReplyStatus() {
		return replyStatus;
	}
	public void setReplyStatus(String replyStatus) {
		this.replyStatus = replyStatus;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getLeaveStartTime() {
		return leaveStartTime;
	}
	public void setLeaveStartTime(Date leaveStartTime) {
		this.leaveStartTime = leaveStartTime;
	}
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getLeaveEndTime() {
		return leaveEndTime;
	}
	public void setLeaveEndTime(Date leaveEndTime) {
		this.leaveEndTime = leaveEndTime;
	}
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getReplyStartTime() {
		return replyStartTime;
	}
	public void setReplyStartTime(Date replyStartTime) {
		this.replyStartTime = replyStartTime;
	}
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getReplyEndTime() {
		return replyEndTime;
	}
	public void setReplyEndTime(Date replyEndTime) {
		this.replyEndTime = replyEndTime;
	}
	
	@Override
	public String toString() {
		return "LinkupRequest [userId=" + userId + ", unitName=" + unitName + ", department=" + department + ", title="
				+ title + ", replyStatus=" + replyStatus + ", username=" + username + ", linkMan=" + linkMan
				+ ", leaveStartTime=" + leaveStartTime + ", leaveEndTime=" + leaveEndTime + ", replyStartTime="
				+ replyStartTime + ", replyEndTime=" + replyEndTime + "]";
	}

}