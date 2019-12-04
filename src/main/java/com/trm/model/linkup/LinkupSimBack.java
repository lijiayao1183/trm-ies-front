package com.trm.model.linkup;
/**
 * 回显信息
 * @author zhaosimiao 2017-12-13 09:42:36
 */
public class LinkupSimBack {

	private String username;
	private String linkMan;
	private String unitName;
	private String department;
	private String linkPhone;
	private String email;
	
	public LinkupSimBack() {
		super();
	}
	
	public LinkupSimBack(String username, String linkMan, String unitName, String department,
			String linkPhone, String email) {
		super();
		this.username = username;
		this.linkMan = linkMan;
		this.unitName = unitName;
		this.department = department;
		this.linkPhone = linkPhone;
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getLinkPhone() {
		return linkPhone;
	}
	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "LinkupSimBack [username=" + username + ", linkMan=" + linkMan + ", unitName=" + unitName
				+ ", department=" + department + ", linkPhone=" + linkPhone + ", email=" + email + "]";
	}
	
}