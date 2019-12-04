package com.trm.model.evaluation;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EvalEquipSimDetail {

	private Integer id;
	private String equipName;
	private String evaluation;
	private Date createTime;
	
	public EvalEquipSimDetail() {
		super();
	}
	
	public EvalEquipSimDetail(Integer id, String equipName, String evaluation, Date createTime) {
		super();
		this.id = id;
		this.equipName = equipName;
		this.evaluation = evaluation;
		this.createTime = createTime;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Override
	public String toString() {
		return "EvalEquipSimDetail [id=" + id + ", equipName=" + equipName + ", evaluation=" + evaluation
				+ ", createTime=" + createTime + "]";
	}
	
}
