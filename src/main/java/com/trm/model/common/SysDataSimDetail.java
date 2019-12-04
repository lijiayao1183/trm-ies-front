package com.trm.model.common;

public class SysDataSimDetail {
	private Integer id;
	private String code;
	private String name;
	private String type;
	private String subType;
	private String remarks;
	public SysDataSimDetail(Integer id, String code, String name, String type, String subType, String remarks) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.type = type;
		this.subType = subType;
		this.remarks = remarks;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSubType() {
		return subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public SysDataSimDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
