package com.trm.model.require;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trm.model.member.EquipMember;

/**
 *  军民融合需求详情 
 *  by zhaosimiao at 2017-11-14 13:02:56
 */
public class RequireDetail {

	private Integer id;
	private Integer orgId;
    private EquipMember memberDetail;
	private String requireType;
	private String requireName;
	private String equipType;
	private String serviceRange;
	private String logoUrl;
	private String requireBrief;
	private String remark;
	private Date validDate;
	private String requireUnit;
	private String address;
	private String linkMan;
	private String linkPhone;
	private String audStatus;
	private Date audDate;
	private String audOpinion;
	private String audPerson;
	private Integer viewCount;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrgId() {
        return orgId;
    }
    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }
    public EquipMember getMemberDetail() {
        return memberDetail;
    }
    public void setMemberDetail(EquipMember memberDetail) {
        this.memberDetail = memberDetail;
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
	public String getServiceRange() {
		return serviceRange;
	}
	public void setServiceRange(String serviceRange) {
		this.serviceRange = serviceRange;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	public String getRequireBrief() {
		return requireBrief;
	}
	public void setRequireBrief(String requireBrief) {
		this.requireBrief = requireBrief;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	public String getLinkPhone() {
		return linkPhone;
	}
	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
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
	public Integer getViewCount() {
		return viewCount;
	}
	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}
	@Override
	public String toString() {
		return "RequireDetail [id=" + id + ", requireType=" + requireType + ", requireName=" + requireName
				+ ", equipType=" + equipType + ", serviceRange=" + serviceRange + ", logoUrl=" + logoUrl
				+ ", requireBrief=" + requireBrief + ", remark=" + remark + ", validDate=" + validDate
				+ ", requireUnit=" + requireUnit + ", address=" + address + ", linkMan=" + linkMan + ", linkPhone="
				+ linkPhone + ", audStatus=" + audStatus + ", audDate=" + audDate + ", audOpinion=" + audOpinion
				+ ", audPerson=" + audPerson + ", viewCount=" + viewCount + "]";
	}
	
}