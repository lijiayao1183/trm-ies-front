package com.trm.model.equip;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MyEquipReq {
	
	private String department;
	private String handler;
	
    private int pageNum;        //当前页码
    private int num;            //每页数量
    private Integer orgId;//用户id
    private String equipName;//设备名称
    private String equipType;//设备功能分类
    private String audStatus;//审核状态
    private String orgName;//持有单位
    private Date audStartTime;//开始时间
    private Date audEndTime;//结束时间

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
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

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getAudStartTime() {
        return audStartTime;
    }

    public void setAudStartTime(Date audStartTime) {
        this.audStartTime = audStartTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getAudEndTime() {
        return audEndTime;
    }

    public void setAudEndTime(Date audEndTime) {
        this.audEndTime = audEndTime;
    }

    public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	@Override
	public String toString() {
		return "MyEquipReq [department=" + department + ", handler=" + handler + ", pageNum=" + pageNum + ", num=" + num
				+ ", orgId=" + orgId + ", equipName=" + equipName + ", equipType=" + equipType + ", audStatus="
				+ audStatus + ", orgName=" + orgName + ", audStartTime=" + audStartTime + ", audEndTime=" + audEndTime
				+ "]";
	}

}
