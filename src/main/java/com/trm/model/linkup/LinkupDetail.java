package com.trm.model.linkup;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LinkupDetail {

	private Integer id;
	private Integer userId;
	private Integer unitId;
	private Integer departId;
	private String title;
	private String leaveMsg;
	private String replyMsg;
	private String replyStatus;
	private Date replyDate;
	private String replyPerson;
	private String isActive;
	private String creator;
	private Date createTime;
	private String updater;
	private Date updateTime;

	public LinkupDetail() {
	}

	public LinkupDetail(Integer userId, Integer unitId, Integer departId,
			String title, String leaveMsg, String replyMsg, String replyStatus,
			Date replyDate, String replyPerson, String isActive,
			String creator, Date createTime, String updater,
			Date updateTime) {
		this.userId = userId;
		this.unitId = unitId;
		this.departId = departId;
		this.title = title;
		this.leaveMsg = leaveMsg;
		this.replyMsg = replyMsg;
		this.replyStatus = replyStatus;
		this.replyDate = replyDate;
		this.replyPerson = replyPerson;
		this.isActive = isActive;
		this.creator = creator;
		this.createTime = createTime;
		this.updater = updater;
		this.updateTime = updateTime;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUnitId() {
		return this.unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	public Integer getDepartId() {
		return this.departId;
	}

	public void setDepartId(Integer departId) {
		this.departId = departId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLeaveMsg() {
		return this.leaveMsg;
	}

	public void setLeaveMsg(String leaveMsg) {
		this.leaveMsg = leaveMsg;
	}

	public String getReplyMsg() {
		return this.replyMsg;
	}

	public void setReplyMsg(String replyMsg) {
		this.replyMsg = replyMsg;
	}

	public String getReplyStatus() {
		return this.replyStatus;
	}

	public void setReplyStatus(String replyStatus) {
		this.replyStatus = replyStatus;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getReplyDate() {
		return this.replyDate;
	}
	
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	public String getReplyPerson() {
		return this.replyPerson;
	}

	public void setReplyPerson(String replyPerson) {
		this.replyPerson = replyPerson;
	}

	public String getIsActive() {
		return this.isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdater() {
		return this.updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "LinkupDetail [id=" + id + ", userId=" + userId + ", unitId=" + unitId + ", departId=" + departId
				+ ", title=" + title + ", leaveMsg=" + leaveMsg + ", replyMsg=" + replyMsg + ", replyStatus="
				+ replyStatus + ", replyDate=" + replyDate + ", replyPerson=" + replyPerson + ", isActive=" + isActive
				+ ", creator=" + creator + ", createTime=" + createTime + ", updater=" + updater + ", updateTime="
				+ updateTime + "]";
	}

}