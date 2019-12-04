package com.trm.model.member;

public class SetDepartsList {

	private Integer id;
	private String department;
	
	public SetDepartsList(Integer id, String department) {
		super();
		this.id = id;
		this.department = department;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "SetDepartsList [id=" + id + ", department=" + department + "]";
	}
	
}
