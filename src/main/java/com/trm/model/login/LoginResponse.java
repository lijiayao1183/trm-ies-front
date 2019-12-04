package com.trm.model.login;

import com.trm.model.common.CommonResponse;

public class LoginResponse extends CommonResponse {
	
	private String username;
	
	private String headPortrait;
	
	private String userType;
	
	private Integer unitId;
	
	private String address;
	
	private String department;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Integer getUnitId() {
		return unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "LoginResponse [username=" + username + ", headPortrait=" + headPortrait + ", userType=" + userType
				+ ", unitId=" + unitId + ", address=" + address + ", department=" + department + "]";
	}

}
