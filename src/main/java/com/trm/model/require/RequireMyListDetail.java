package com.trm.model.require;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *  军民融合需求后台列表展示参数
 *  by zhaosimiao at 2017-11-14 13:02:56
 */
public class RequireMyListDetail {

	private Integer id;
	private String requireType;
	private String requireName;
	private String equipType;
	private Date validDate;
	private String requireUnit;
	private String audStatus;
	private Date audDate;
    private String department;
    private String auser;
    private String userType;
	
	public RequireMyListDetail() {
		super();
	}
	
	public RequireMyListDetail(Integer id, String requireType, String requireName, String equipType, Date validDate,
			String requireUnit, String audStatus, Date audDate, String department, String auser, String userType) {
		super();
		this.id = id;
		this.requireType = requireType;
		this.requireName = requireName;
		this.equipType = equipType;
		this.validDate = validDate;
		this.requireUnit = requireUnit;
		this.audStatus = audStatus;
		this.audDate = audDate;
        this.department = department;
        this.auser = auser;
        this.userType = userType;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRequireType() {
		return requireType;
	}
	public void setRequireType(String requireType) {
		this.requireType = requireType;
	}
	public String getRequireName() {
		return requireName;
	}
	public void setRequireName(String requireName) {
		this.requireName = requireName;
	}
	public String getEquipType() {
		return equipType;
	}
	public void setEquipType(String equipType) {
		this.equipType = equipType;
	}
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getValidDate() {
		return validDate;
	}
	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}
	public String getRequireUnit() {
		return requireUnit;
	}
	public void setRequireUnit(String requireUnit) {
		this.requireUnit = requireUnit;
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
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAuser() {
		return auser;
	}

	public void setAuser(String auser) {
		this.auser = auser;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "RequireMyListDetail [id=" + id + ", requireType=" + requireType
				+ ", requireName=" + requireName + ", equipType=" + equipType
				+ ", validDate=" + validDate + ", requireUnit=" + requireUnit
				+ ", audStatus=" + audStatus + ", audDate=" + audDate
				+ ", department=" + department + ", auser=" + auser
				+ ", userType=" + userType + "]";
	}
	
}