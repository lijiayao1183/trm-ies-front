package com.trm.model.member;

public class SetUsersList {

	private Integer id;
	private String users;
	private String userType;
	
	public SetUsersList() {
		super();
	}

	public SetUsersList(Integer id, String users, String userType) {
		super();
		this.id = id;
		this.users = users;
		this.userType = userType;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsers() {
		return users;
	}

	public void setUsers(String users) {
		this.users = users;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "SetUsersList [id=" + id + ", users=" + users + ", userType="
				+ userType + "]";
	}
	
}
