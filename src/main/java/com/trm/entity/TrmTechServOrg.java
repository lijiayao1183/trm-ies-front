package com.trm.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 军民融合技术服务机构
 * add by zhaosimiao at 2019-3-13 11:21:09
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "trm_tech_serv_org")
public class TrmTechServOrg implements java.io.Serializable {

	private Integer id;
	/**
	 * 机构名称
	 */
	private String orgName;
	/**
	 * 服务类型
	 */
	private String servType;
	/**
	 * 机构地址
	 */
	private String address;
	/**
	 * 机构邮编
	 */
	private String postcode;
	/**
	 * 机构性质
	 */
	private String property;
	/**
	 * 机构属性
	 */
	private String attribute;
	/**
	 * 负责人
	 */
	private String header;
	/**
	 * 负责人电话
	 */
	private String headerPhone;
	/**
	 * 负责人手机
	 */
	private String headerMobile;
	/**
	 * 负责人邮箱
	 */
	private String headerEmail;
	/**
	 * 联系人
	 */
	private String linker;
	/**
	 * 联系人电话
	 */
	private String linkerPhone;
	/**
	 * 联系人手机
	 */
	private String linkerMobile;
	/**
	 * 联系人邮箱
	 */
	private String linkerEmail;
	/**
	 * 机构简介
	 */
	private String brief;
	/**
	 * 人才队伍情况
	 */
	private String team;
	/**
	 * 规范化管理水平
	 */
	private String mgtLevel;
	/**
	 * 所获资质及荣誉
	 */
	private String honor;
	/**
	 * 技术服务情况
	 */
	private String servCase;
	/**
	 * 近年承担重要项目/案例
	 */
	private String projectCase;
	/**
	 * 审核状态
	 */
	private String audStatus;
	/**
	 * 审核时间
	 */
	private Date audDate;
	/**
	 * 审核意见
	 */
	private String audOpinion;
	/**
	 * 审核人
	 */
	private String audPerson;
	private String isActive;
	private String creator;
	private Date createTime;
	private String updater;
	private Date updateTime;
	private Integer userId;

	// Constructors

	/** default constructor */
	public TrmTechServOrg() {
	}

	/** minimal constructor */
	public TrmTechServOrg(String headerEmail, String isActive) {
		this.headerEmail = headerEmail;
		this.isActive = isActive;
	}

	/** full constructor */
	public TrmTechServOrg(String orgName, String servType, String address,
			String postcode, String property, String attribute, String header,
			String headerPhone, String headerMobile, String headerEmail,
			String linker, String linkerPhone, String linkerMobile,
			String linkerEmail, String brief, String team, String mgtLevel,
			String honor, String servCase, String projectCase,
			String audStatus, Date audDate, String audOpinion,
			String audPerson, String isActive, String creator,
			Date createTime, String updater, Date updateTime) {
		this.orgName = orgName;
		this.servType = servType;
		this.address = address;
		this.postcode = postcode;
		this.property = property;
		this.attribute = attribute;
		this.header = header;
		this.headerPhone = headerPhone;
		this.headerMobile = headerMobile;
		this.headerEmail = headerEmail;
		this.linker = linker;
		this.linkerPhone = linkerPhone;
		this.linkerMobile = linkerMobile;
		this.linkerEmail = linkerEmail;
		this.brief = brief;
		this.team = team;
		this.mgtLevel = mgtLevel;
		this.honor = honor;
		this.servCase = servCase;
		this.projectCase = projectCase;
		this.audStatus = audStatus;
		this.audDate = audDate;
		this.audOpinion = audOpinion;
		this.audPerson = audPerson;
		this.isActive = isActive;
		this.creator = creator;
		this.createTime = createTime;
		this.updater = updater;
		this.updateTime = updateTime;
	}

	public TrmTechServOrg(Integer id, String orgName, String servType, String address, String postcode, String property,
			String attribute, String header, String headerPhone, String headerMobile, String headerEmail, String linker,
			String linkerPhone, String linkerMobile, String linkerEmail, String brief, String team, String mgtLevel,
			String honor, String servCase, String projectCase, String audStatus, Date audDate, String audOpinion,
			String audPerson, String isActive, String creator, Date createTime, String updater, Date updateTime) {
		super();
		this.id = id;
		this.orgName = orgName;
		this.servType = servType;
		this.address = address;
		this.postcode = postcode;
		this.property = property;
		this.attribute = attribute;
		this.header = header;
		this.headerPhone = headerPhone;
		this.headerMobile = headerMobile;
		this.headerEmail = headerEmail;
		this.linker = linker;
		this.linkerPhone = linkerPhone;
		this.linkerMobile = linkerMobile;
		this.linkerEmail = linkerEmail;
		this.brief = brief;
		this.team = team;
		this.mgtLevel = mgtLevel;
		this.honor = honor;
		this.servCase = servCase;
		this.projectCase = projectCase;
		this.audStatus = audStatus;
		this.audDate = audDate;
		this.audOpinion = audOpinion;
		this.audPerson = audPerson;
		this.isActive = isActive;
		this.creator = creator;
		this.createTime = createTime;
		this.updater = updater;
		this.updateTime = updateTime;
	}
	
	public TrmTechServOrg(Integer id, String orgName, String servType, String address, String postcode, String property,
			String attribute, String header, String headerPhone, String headerMobile, String headerEmail, String linker,
			String linkerPhone, String linkerMobile, String linkerEmail, String brief, String team, String mgtLevel,
			String honor, String servCase, String projectCase, String audStatus, Date audDate, String audOpinion,
			String audPerson, String isActive, String creator, Date createTime, String updater, Date updateTime,
			Integer userId) {
		super();
		this.id = id;
		this.orgName = orgName;
		this.servType = servType;
		this.address = address;
		this.postcode = postcode;
		this.property = property;
		this.attribute = attribute;
		this.header = header;
		this.headerPhone = headerPhone;
		this.headerMobile = headerMobile;
		this.headerEmail = headerEmail;
		this.linker = linker;
		this.linkerPhone = linkerPhone;
		this.linkerMobile = linkerMobile;
		this.linkerEmail = linkerEmail;
		this.brief = brief;
		this.team = team;
		this.mgtLevel = mgtLevel;
		this.honor = honor;
		this.servCase = servCase;
		this.projectCase = projectCase;
		this.audStatus = audStatus;
		this.audDate = audDate;
		this.audOpinion = audOpinion;
		this.audPerson = audPerson;
		this.isActive = isActive;
		this.creator = creator;
		this.createTime = createTime;
		this.updater = updater;
		this.updateTime = updateTime;
		this.userId = userId;
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

	@Column(name = "orgName", length = 100)
	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Column(name = "servType", length = 100)
	public String getServType() {
		return this.servType;
	}

	public void setServType(String servType) {
		this.servType = servType;
	}

	@Column(name = "address", length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "postcode", length = 100)
	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Column(name = "property", length = 100)
	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	@Column(name = "attribute", length = 100)
	public String getAttribute() {
		return this.attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	@Column(name = "header", length = 100)
	public String getHeader() {
		return this.header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	@Column(name = "headerPhone", length = 100)
	public String getHeaderPhone() {
		return this.headerPhone;
	}

	public void setHeaderPhone(String headerPhone) {
		this.headerPhone = headerPhone;
	}

	@Column(name = "headerMobile", length = 100)
	public String getHeaderMobile() {
		return this.headerMobile;
	}

	public void setHeaderMobile(String headerMobile) {
		this.headerMobile = headerMobile;
	}

	@Column(name = "headerEmail", nullable = false, length = 100)
	public String getHeaderEmail() {
		return this.headerEmail;
	}

	public void setHeaderEmail(String headerEmail) {
		this.headerEmail = headerEmail;
	}

	@Column(name = "linker", length = 100)
	public String getLinker() {
		return this.linker;
	}

	public void setLinker(String linker) {
		this.linker = linker;
	}

	@Column(name = "linkerPhone", length = 100)
	public String getLinkerPhone() {
		return this.linkerPhone;
	}

	public void setLinkerPhone(String linkerPhone) {
		this.linkerPhone = linkerPhone;
	}

	@Column(name = "linkerMobile", length = 100)
	public String getLinkerMobile() {
		return this.linkerMobile;
	}

	public void setLinkerMobile(String linkerMobile) {
		this.linkerMobile = linkerMobile;
	}

	@Column(name = "linkerEmail", length = 100)
	public String getLinkerEmail() {
		return this.linkerEmail;
	}

	public void setLinkerEmail(String linkerEmail) {
		this.linkerEmail = linkerEmail;
	}

	@Column(name = "brief", length = 1000)
	public String getBrief() {
		return this.brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	@Column(name = "team", length = 1000)
	public String getTeam() {
		return this.team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Column(name = "mgtLevel", length = 1000)
	public String getMgtLevel() {
		return this.mgtLevel;
	}

	public void setMgtLevel(String mgtLevel) {
		this.mgtLevel = mgtLevel;
	}

	@Column(name = "honor", length = 1000)
	public String getHonor() {
		return this.honor;
	}

	public void setHonor(String honor) {
		this.honor = honor;
	}

	@Column(name = "servCase", length = 1000)
	public String getServCase() {
		return this.servCase;
	}

	public void setServCase(String servCase) {
		this.servCase = servCase;
	}

	@Column(name = "projectCase")
	public String getProjectCase() {
		return this.projectCase;
	}

	public void setProjectCase(String projectCase) {
		this.projectCase = projectCase;
	}

	@Column(name = "audStatus", length = 2)
	public String getAudStatus() {
		return this.audStatus;
	}

	public void setAudStatus(String audStatus) {
		this.audStatus = audStatus;
	}

	@Column(name = "audDate", length = 19)
	public Date getAudDate() {
		return this.audDate;
	}

	public void setAudDate(Date audDate) {
		this.audDate = audDate;
	}

	@Column(name = "audOpinion", length = 500)
	public String getAudOpinion() {
		return this.audOpinion;
	}

	public void setAudOpinion(String audOpinion) {
		this.audOpinion = audOpinion;
	}

	@Column(name = "audPerson", length = 50)
	public String getAudPerson() {
		return this.audPerson;
	}

	public void setAudPerson(String audPerson) {
		this.audPerson = audPerson;
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
	@Column(name = "userId")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}