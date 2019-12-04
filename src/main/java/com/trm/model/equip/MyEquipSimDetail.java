package com.trm.model.equip;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MyEquipSimDetail {

    private Integer id;
    /* 设备名称*/
    private String equipName;
    /* 设备功能分类*/
    private String equipType;
    private String audStatus;
    private Date audDate;
    private String isDisplay;
    private String department;
    private String auser;
    private String userType;

    public MyEquipSimDetail() {
        super();
    }

    public MyEquipSimDetail(Integer id, String equipName, String equipType, String audStatus, Date audDate, String isDisplay, String department, String auser, String userType) {
        super();
        this.id = id;
        this.equipName = equipName;
        this.equipType = equipType;
        this.audStatus = audStatus;
        this.audDate = audDate;
        this.isDisplay = isDisplay;
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

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    public String getEquipType() {
        return equipType;
    }

    public void setEquipType(String equipType) {
        this.equipType = equipType;
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

    public String getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(String isDisplay) {
        this.isDisplay = isDisplay;
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
		return "MyEquipSimDetail [id=" + id + ", equipName=" + equipName
				+ ", equipType=" + equipType + ", audStatus=" + audStatus
				+ ", audDate=" + audDate + ", isDisplay=" + isDisplay
				+ ", department=" + department + ", auser=" + auser
				+ ", userType=" + userType + "]";
	}

}
