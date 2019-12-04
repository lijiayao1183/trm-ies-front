package com.trm.model.laboratory;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LaboratoryDetail {
    private Integer id;
    private String labName;
    private String unitName;
    private String person;
    private String phone;
    private String address;
    private String img;
    private String studiDirecti;
    private String brief;
    private Date createTime;
	private Integer viewCount;
	
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLabName() {
        return labName;
    }
    public void setLabName(String labName) {
        this.labName = labName;
    }
    public String getUnitName() {
        return unitName;
    }
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
    public String getPerson() {
        return person;
    }
    public void setPerson(String person) {
        this.person = person;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getStudiDirecti() {
        return studiDirecti;
    }
    public void setStudiDirecti(String studiDirecti) {
        this.studiDirecti = studiDirecti;
    }
    public String getBrief() {
        return brief;
    }
    public void setBrief(String brief) {
        this.brief = brief;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Integer getViewCount() {
		return viewCount;
	}
	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}
	
	@Override
    public String toString() {
        return "LaboratoryDetail [id=" + id + ", labName=" + labName + ", unitName=" + unitName + ", person=" + person + ", phone=" + phone
                + ", address=" + address + ", img=" + img + ", studiDirecti=" + studiDirecti + ", brief=" + brief + ", createTime=" + createTime
                + ", viewCount=" + viewCount + "]";
    }
}
