package com.trm.model.member;

public class EquipMember {
	
    private String orgName;
    private String orgProperty;
    private String masterType;
    private String master;
    private String province;
    private String address;
    
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgProperty() {
		return orgProperty;
	}
	public void setOrgProperty(String orgProperty) {
		this.orgProperty = orgProperty;
	}
	public String getMasterType() {
		return masterType;
	}
	public void setMasterType(String masterType) {
		this.masterType = masterType;
	}
	public String getMaster() {
		return master;
	}
	public void setMaster(String master) {
		this.master = master;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "EquipMember [orgName=" + orgName + ", orgProperty=" + orgProperty + ", masterType=" + masterType
				+ ", master=" + master + ", province=" + province + ", address=" + address + "]";
	}
	
}
