package com.trm.model.member;

public class SetUnitsList {

	private Integer id;
	private String orgName;
	
	public SetUnitsList() {
		super();
	}
	public SetUnitsList(Integer id, String orgName) {
		super();
		this.id = id;
		this.orgName = orgName;
	}
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
	
	@Override
	public String toString() {
		return "SetUnitsList [id=" + id + ", orgName=" + orgName + "]";
	}
	
}
