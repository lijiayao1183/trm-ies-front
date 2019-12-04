package com.trm.model.require;

/**
 *  军民融合需求列表展示
 *  by zhaosimiao at 2017-11-14 13:02:56
 */
public class RequireSimDetail {

	private Integer id;
	private String requireType;
	private String requireName;
	private String logoUrl;
	private String equipType;
	private String serviceRange;
	
	public RequireSimDetail() {
		super();
	}

	public RequireSimDetail(Integer id, String requireType, String requireName, String logoUrl, String equipType, String serviceRange) {
		super();
		this.id = id;
		this.requireType = requireType;
		this.requireName = requireName;
		this.logoUrl = logoUrl;
		this.equipType = equipType;
		this.serviceRange = serviceRange;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
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
		return "RequireSimDetail [id=" + id + ", requireType=" + requireType + ", requireName=" + requireName
				+ ", logoUrl=" + logoUrl  + ", equipType=" + equipType + ", serviceRange=" + serviceRange + "]";
	}
	
}