package com.trm.model.organ;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrganDetail {
    private Integer id;
    private String orgName;
    private String url;
    private String logoImg;
    private String displayImg;
    private Date establishDate;
    private String phone;
    private String address;
    private String orgProperty;
    private String orgBrief;
    private String research;
    private Integer viewCount;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getOrgName() {
        return orgName;
    }
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getLogoImg() {
        return logoImg;
    }
    public void setLogoImg(String logoImg) {
        this.logoImg = logoImg;
    }
    public String getDisplayImg() {
        return displayImg;
    }
    public void setDisplayImg(String displayImg) {
        this.displayImg = displayImg;
    }
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getEstablishDate() {
        return establishDate;
    }
    public void setEstablishDate(Date establishDate) {
        this.establishDate = establishDate;
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
    public String getOrgProperty() {
        return orgProperty;
    }
    public void setOrgProperty(String orgProperty) {
        this.orgProperty = orgProperty;
    }
    public String getOrgBrief() {
        return orgBrief;
    }
    public void setOrgBrief(String orgBrief) {
        this.orgBrief = orgBrief;
    }
    public String getResearch() {
        return research;
    }
    public void setResearch(String research) {
        this.research = research;
    }
    public Integer getViewCount() {
		return viewCount;
	}
	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}
	
	@Override
    public String toString() {
        return "OrganDetail [id=" + id + ", orgName=" + orgName + ", url=" + url + ", logoImg=" + logoImg + ", displayImg=" + displayImg
                + ", establishDate=" + establishDate + ", phone=" + phone + ", address=" + address + ", orgProperty=" + orgProperty + ", orgBrief="
                + orgBrief + ", research=" + research + ", viewCount=" + viewCount + "]";
    }
}
