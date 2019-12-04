package com.trm.model.member;

import com.trm.model.common.CommonRequest;

public class GetDepartsRequest extends CommonRequest{

	private Integer unitId;
	private String orgName;
	
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	@Override
	public String toString() {
		return "GetDepartsRequest [unitId=" + unitId + ", orgName=" + orgName + "]";
	}

}
