package com.trm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

/**
 * TrmMemberTemp entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "trm_member_temp")
@Where(clause = "isActive='Y'")//获取是激活状态的
public class TrmMemberTemp implements java.io.Serializable {

	// Fields

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

	// Constructors

	/** default constructor */
	public TrmMemberTemp() {
	}

	/** minimal constructor */
	public TrmMemberTemp(String isActive) {
		this.isActive = isActive;
	}

	/** full constructor */
	public TrmMemberTemp(String username, String password, String orgName,
			String creditId, String address, String orgProperty,
			String isListed, String isHighNew, String masterType,
			String master, String province, String city, String area,
			String orgBrief, String licensePdf, String promisePdf,
			String department, String linkPerson, String numberId,
			String phone, String email, String problem, String answer,
			String isActive, String creator, Date createTime,
			String updater, Date updateTime) {
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

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "username", length = 100)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "orgName", length = 100)
	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Column(name = "creditId", length = 100)
	public String getCreditId() {
		return this.creditId;
	}

	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}

	@Column(name = "address", length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "orgProperty", length = 100)
	public String getOrgProperty() {
		return this.orgProperty;
	}

	public void setOrgProperty(String orgProperty) {
		this.orgProperty = orgProperty;
	}

	@Column(name = "isListed", length = 2)
	public String getIsListed() {
		return this.isListed;
	}

	public void setIsListed(String isListed) {
		this.isListed = isListed;
	}

	@Column(name = "isHighNew", length = 2)
	public String getIsHighNew() {
		return this.isHighNew;
	}

	public void setIsHighNew(String isHighNew) {
		this.isHighNew = isHighNew;
	}

	@Column(name = "masterType", length = 100)
	public String getMasterType() {
		return this.masterType;
	}

	public void setMasterType(String masterType) {
		this.masterType = masterType;
	}

	@Column(name = "master", length = 100)
	public String getMaster() {
		return this.master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	@Column(name = "province", length = 10)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "city", length = 10)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "area", length = 10)
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "orgBrief", length = 1000)
	public String getOrgBrief() {
		return this.orgBrief;
	}

	public void setOrgBrief(String orgBrief) {
		this.orgBrief = orgBrief;
	}

	@Column(name = "licensePDF", length = 100)
	public String getLicensePdf() {
		return this.licensePdf;
	}

	public void setLicensePdf(String licensePdf) {
		this.licensePdf = licensePdf;
	}

	@Column(name = "promisePDF", length = 100)
	public String getPromisePdf() {
		return this.promisePdf;
	}

	public void setPromisePdf(String promisePdf) {
		this.promisePdf = promisePdf;
	}

	@Column(name = "department", length = 100)
	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "linkPerson", length = 100)
	public String getLinkPerson() {
		return this.linkPerson;
	}

	public void setLinkPerson(String linkPerson) {
		this.linkPerson = linkPerson;
	}

	@Column(name = "numberId", length = 100)
	public String getNumberId() {
		return this.numberId;
	}

	public void setNumberId(String numberId) {
		this.numberId = numberId;
	}

	@Column(name = "phone", length = 100)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "email", length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "problem", length = 100)
	public String getProblem() {
		return this.problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	@Column(name = "answer", length = 100)
	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Column(name = "isActive", nullable = false, length = 1)
	public String getIsActive() {
		return this.isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Column(name = "creator", length = 100)
	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Column(name = "createTime", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "updater", length = 100)
	public String getUpdater() {
		return this.updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	@Column(name = "updateTime", length = 19)
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}