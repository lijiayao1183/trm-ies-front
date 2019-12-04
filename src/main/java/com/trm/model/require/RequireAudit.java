package com.trm.model.require;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *  军民融合需求审核参数
 *  by zhaosimiao at 2017-11-14 13:02:56
 */
public class RequireAudit {

	@NotNull(message = "军民融合需求id不能为空")
	private Integer id;
	private String audStatus;
	private Date audDate;
	private String audOpinion;
	private String audPerson;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAudStatus() {
		return audStatus;
	}
	public void setAudStatus(String audStatus) {
		this.audStatus = audStatus;
	}
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getAudDate() {
		return audDate;
	}
	public void setAudDate(Date audDate) {
		this.audDate = audDate;
	}
	public String getAudOpinion() {
		return audOpinion;
	}
	public void setAudOpinion(String audOpinion) {
		this.audOpinion = audOpinion;
	}
	public String getAudPerson() {
		return audPerson;
	}
	public void setAudPerson(String audPerson) {
		this.audPerson = audPerson;
	}
	
	@Override
	public String toString() {
		return "RequireAudit [id=" + id + ", audStatus=" + audStatus + ", audDate=" + audDate + ", audOpinion="
				+ audOpinion + ", audPerson=" + audPerson + "]";
	}
	
}