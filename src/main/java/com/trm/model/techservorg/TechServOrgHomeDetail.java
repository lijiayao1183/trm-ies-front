package com.trm.model.techservorg;

public class TechServOrgHomeDetail {

	private Integer id;
	private String orgName;
	
	public TechServOrgHomeDetail() {
		super();
	}

	public TechServOrgHomeDetail(Integer id, String orgName) {
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
    
}
