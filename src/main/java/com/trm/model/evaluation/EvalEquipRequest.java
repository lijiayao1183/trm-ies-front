package com.trm.model.evaluation;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trm.model.common.CommonRequest;

public class EvalEquipRequest extends CommonRequest{

	private Integer userId;
	private String equipName;
	private String evaluation;
	private Date startDate;
	private Date endDate;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getEquipName() {
		return equipName;
	}
	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}
	public String getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	@Override
	public String toString() {
		return "EvalEquipRequest [userId=" + userId + ", equipName=" + equipName + ", evaluation=" + evaluation
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
}
