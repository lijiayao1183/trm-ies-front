package com.trm.model.member;

public class SubMemberDetail {
	
    private Integer id;
    /**
	 * 所属单位id
	 */
	private Integer unitId;
	/**
	 * 所属部门id
	 */
	private Integer departId;
	/**
	 * 所属管理用户id
	 */
	private Integer masterId;
    private String username;
    private String linkPerson;
	private String password;
    private String phone;
    private String email;
    private String userType;
    private String orgName;
    private String department;
    
	public SubMemberDetail() {
		super();
	}
	
	public SubMemberDetail(Integer id, Integer unitId, Integer departId, Integer masterId, String username,
			String linkPerson, String password, String phone, String email, String userType, String orgName,
			String department) {
		super();
		this.id = id;
		this.unitId = unitId;
		this.departId = departId;
		this.masterId = masterId;
		this.username = username;
		this.linkPerson = linkPerson;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.userType = userType;
		this.orgName = orgName;
		this.department = department;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public Integer getDepartId() {
		return departId;
	}
	public void setDepartId(Integer departId) {
		this.departId = departId;
	}
	public Integer getMasterId() {
		return masterId;
	}
	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLinkPerson() {
		return linkPerson;
	}
	public void setLinkPerson(String linkPerson) {
		this.linkPerson = linkPerson;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "SubMemberDetail [id=" + id + ", unitId=" + unitId + ", departId=" + departId + ", masterId=" + masterId
				+ ", username=" + username + ", linkPerson=" + linkPerson + ", password=" + password + ", phone="
				+ phone + ", email=" + email + ", userType=" + userType + ", orgName=" + orgName + ", department="
				+ department + "]";
	}
	
}
