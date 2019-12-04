package com.trm.model.require;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trm.model.common.CommonRequest;

/**
 *  军民融合需求请求参数
 *  by zhaosimiao at 2017-11-14 13:02:56
 */
public class RequireRequest extends CommonRequest{

	private String department;
	private String handler;
	
	private Integer id;
	private String searchKey;
	private String requireType;
	private String requireName;
	private String equipType;
	private String serviceRange;
	private String requireBrief;
	private String remark;
	private Date validDate;
	private String requireUnit;
	private String address;
	private String linkMan;
	private String linkPhone;
	private String audStatus;
	private Date audDate;
	private Date validStartDate;
	private Date validEndDate;
	private Date audStartDate;
	private Date audEndDate;
	private Date createStarDate;
	private Date createEndDate;
	
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
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
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
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getValidStartDate() {
		return validStartDate;
	}
	public void setValidStartDate(Date validStartDate) {
		this.validStartDate = validStartDate;
	}
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getValidEndDate() {
		return validEndDate;
	}
	public void setValidEndDate(Date validEndDate) {
		this.validEndDate = validEndDate;
	}
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getAudStartDate() {
		return audStartDate;
	}
	public void setAudStartDate(Date audStartDate) {
		this.audStartDate = audStartDate;
	}
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getAudEndDate() {
		return audEndDate;
	}
	public void setAudEndDate(Date audEndDate) {
		this.audEndDate = audEndDate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getCreateStarDate() {
		return createStarDate;
	}

	public void setCreateStarDate(Date createStarDate) {
		this.createStarDate = createStarDate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getCreateEndDate() {
		return createEndDate;
	}

	public void setCreateEndDate(Date createEndDate) {
		this.createEndDate = createEndDate;
	}

	@Override
	public String toString() {
		return "RequireRequest [id=" + id + ", searchKey=" + searchKey + ", requireType=" + requireType
				+ ", requireName=" + requireName + ", equipType=" + equipType + ", serviceRange=" + serviceRange
				+ ", requireBrief=" + requireBrief + ", remark=" + remark + ", validDate=" + validDate
				+ ", requireUnit=" + requireUnit + ", address=" + address + ", linkMan=" + linkMan + ", linkPhone="
				+ linkPhone + ", audStatus=" + audStatus + ", audDate=" + audDate + ", validStartDate=" + validStartDate
				+ ", validEndDate=" + validEndDate + ", audStartDate=" + audStartDate + ", audEndDate=" + audEndDate
				+ "]";
	}
	
}