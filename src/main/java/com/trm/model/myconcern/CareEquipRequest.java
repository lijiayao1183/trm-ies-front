package com.trm.model.myconcern;

import com.trm.model.common.CommonRequest;

public class CareEquipRequest extends CommonRequest {
	
	// 用户id
	private Integer userId;
	
	// 搜索参数 4个
    private String equipName;
    private String orgName;
    private String equipType;
    private String serviceRange;
    
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
	
	@Override
	public String toString() {
		return "CareEquipRequest [userId=" + userId + ", equipName=" + equipName + ", orgName=" + orgName + ", equipType="
				+ equipType + ", serviceRange=" + serviceRange + "]";
	}
    
}
