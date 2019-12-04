package com.trm.model.myconcern;

public class CareEquipSimDetail {

	private Integer userId;
	private Integer eqpId;
	private String equipName;
	private String orgName;
	private String equipType;
	private String serviceRange;
	private String audStatus;
	private String isDisplay;
	
	public CareEquipSimDetail() {
		super();
	}
	
	public CareEquipSimDetail(Integer userId, Integer eqpId, String equipName, String orgName, String equipType,
			String serviceRange, String audStatus, String isDisplay) {
		super();
		this.userId = userId;
		this.eqpId = eqpId;
		this.equipName = equipName;
		this.orgName = orgName;
		this.equipType = equipType;
		this.serviceRange = serviceRange;
		this.audStatus = audStatus;
		this.isDisplay = isDisplay;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getEqpId() {
		return eqpId;
	}
	public void setEqpId(Integer eqpId) {
		this.eqpId = eqpId;
	}
	public String getEquipName() {
		return equipName;
	}
	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
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
	public String getAudStatus() {
		return audStatus;
	}
	public void setAudStatus(String audStatus) {
		this.audStatus = audStatus;
	}
	public String getIsDisplay() {
		return isDisplay;
	}
	public void setIsDisplay(String isDisplay) {
		this.isDisplay = isDisplay;
	}

	@Override
	public String toString() {
		return "CareEquipSimDetail [userId=" + userId + ", eqpId=" + eqpId + ", equipName=" + equipName + ", orgName="
				+ orgName + ", equipType=" + equipType + ", serviceRange=" + serviceRange + ", audStatus=" + audStatus
				+ ", isDisplay=" + isDisplay + "]";
	}
	
}
