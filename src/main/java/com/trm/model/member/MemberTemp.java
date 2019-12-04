package com.trm.model.member;

import java.util.Date;

public class MemberTemp {

	private Integer id;
	private String username;
	private String password;
	private String orgName;
	private String creditId;
	private String address;
	private String orgProperty;
	private String isListed;
	private String isHighNew;
	private String masterType;
	private String master;
	private String province;
	private String city;
	private String area;
	private String orgBrief;
	private String licensePdf;
	private String promisePdf;
	private String department;
	private String linkPerson;
	private String numberId;
	private String phone;
	private String email;
	private String problem;
	private String answer;
	private String isActive;
	private String creator;
	private Date createTime;
	private String updater;
	private Date updateTime;
	
	public MemberTemp() {
		super();
	}

	public MemberTemp(Integer id, String username, String password, String orgName, String creditId, String address,
			String orgProperty, String isListed, String isHighNew, String masterType, String master, String province,
			String city, String area, String orgBrief, String licensePdf, String promisePdf, String department,
			String linkPerson, String numberId, String phone, String email, String problem, String answer,
			String isActive, String creator, Date createTime, String updater, Date updateTime) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.orgName = orgName;
		this.creditId = creditId;
		this.address = address;
		this.orgProperty = orgProperty;
		this.isListed = isListed;
		this.isHighNew = isHighNew;
		this.masterType = masterType;
		this.master = master;
		this.province = province;
		this.city = city;
		this.area = area;
		this.orgBrief = orgBrief;
		this.licensePdf = licensePdf;
		this.promisePdf = promisePdf;
		this.department = department;
		this.linkPerson = linkPerson;
		this.numberId = numberId;
		this.phone = phone;
		this.email = email;
		this.problem = problem;
		this.answer = answer;
		this.isActive = isActive;
		this.creator = creator;
		this.createTime = createTime;
		this.updater = updater;
		this.updateTime = updateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getCreditId() {
		return creditId;
	}

	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOrgProperty() {
		return orgProperty;
	}

	public void setOrgProperty(String orgProperty) {
		this.orgProperty = orgProperty;
	}

	public String getIsListed() {
		return isListed;
	}

	public void setIsListed(String isListed) {
		this.isListed = isListed;
	}

	public String getIsHighNew() {
		return isHighNew;
	}

	public void setIsHighNew(String isHighNew) {
		this.isHighNew = isHighNew;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getOrgBrief() {
		return orgBrief;
	}

	public void setOrgBrief(String orgBrief) {
		this.orgBrief = orgBrief;
	}

	public String getLicensePdf() {
		return licensePdf;
	}

	public void setLicensePdf(String licensePdf) {
		this.licensePdf = licensePdf;
	}

	public String getPromisePdf() {
		return promisePdf;
	}

	public void setPromisePdf(String promisePdf) {
		this.promisePdf = promisePdf;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getLinkPerson() {
		return linkPerson;
	}

	public void setLinkPerson(String linkPerson) {
		this.linkPerson = linkPerson;
	}

	public String getNumberId() {
		return numberId;
	}

	public void setNumberId(String numberId) {
		this.numberId = numberId;
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

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "MemberTemp [id=" + id + ", username=" + username + ", password=" + password + ", orgName=" + orgName
				+ ", creditId=" + creditId + ", address=" + address + ", orgProperty=" + orgProperty + ", isListed="
				+ isListed + ", isHighNew=" + isHighNew + ", masterType=" + masterType + ", master=" + master
				+ ", province=" + province + ", city=" + city + ", area=" + area + ", orgBrief=" + orgBrief
				+ ", licensePdf=" + licensePdf + ", promisePdf=" + promisePdf + ", department=" + department
				+ ", linkPerson=" + linkPerson + ", numberId=" + numberId + ", phone=" + phone + ", email=" + email
				+ ", problem=" + problem + ", answer=" + answer + ", isActive=" + isActive + ", creator=" + creator
				+ ", createTime=" + createTime + ", updater=" + updater + ", updateTime=" + updateTime + "]";
	}

}