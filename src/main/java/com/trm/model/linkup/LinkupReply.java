package com.trm.model.linkup;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *  军民融合需求审核参数
 *  by zhaosimiao at 2017-11-14 13:02:56
 */
public class LinkupReply {

	@NotNull(message = "回复id不能为空")
	private Integer id;
	private String replyStatus;
	private Date replyDate;
	@NotNull(message = "回复内容不能为空")
	private String replyMsg;
	private String replyPerson;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getReplyStatus() {
		return replyStatus;
	}
	public void setReplyStatus(String replyStatus) {
		this.replyStatus = replyStatus;
	}
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	public String getReplyMsg() {
		return replyMsg;
	}
	public void setReplyMsg(String replyMsg) {
		this.replyMsg = replyMsg;
	}
	public String getReplyPerson() {
		return replyPerson;
	}
	public void setReplyPerson(String replyPerson) {
		this.replyPerson = replyPerson;
	}
	
	@Override
	public String toString() {
		return "LinkupReply [id=" + id + ", replyStatus=" + replyStatus + ", replyDate=" + replyDate + ", replyMsg="
				+ replyMsg + ", replyPerson=" + replyPerson + "]";
	}
	
}