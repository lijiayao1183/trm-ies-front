package com.trm.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

/**
 * TrmRequire entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "trm_require")
@Where(clause = "isActive='Y'")//获取是激活状态的
public class TrmRequire implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer orgId;
	private String requireType;
	private String requireName;
	private String equipType;
	private String serviceRange;
	private String logoUrl;
	private String requireBrief;
	private String remark;
	private Date validDate;
	private String requireUnit;
	private String address;
	private String linkMan;
	private String linkPhone;
	private String audStatus;
	private Date audDate;
	private String audOpinion;
	private String audPerson;
	private String isActive;
	private String creator;
	private Date createTime;
	private String updater;
	private Date updateTime;
	private Integer viewCount;

	// Constructors

	/** default constructor */
	public TrmRequire() {
	}

	/** minimal constructor */
	public TrmRequire(String isActive) {
		this.isActive = isActive;
	}

	/** full constructor */
	public TrmRequire(Integer id, Integer orgId, String requireType, String requireName, String equipType, String serviceRange,
			String logoUrl, String requireBrief, String remark, Date validDate, String requireUnit, String address,
			String linkMan, String linkPhone, String audStatus, Date audDate, String audOpinion, String audPerson,
			String isActive, String creator, Date createTime, String updater, Date updateTime) {
		super();
		this.id = id;
		this.orgId = orgId;
		this.requireType = requireType;
		this.requireName = requireName;
		this.equipType = equipType;
		this.serviceRange = serviceRange;
		this.logoUrl = logoUrl;
		this.requireBrief = requireBrief;
		this.remark = remark;
		this.validDate = validDate;
		this.requireUnit = requireUnit;
		this.address = address;
		this.linkMan = linkMan;
		this.linkPhone = linkPhone;
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
	@Column(name = "orgId")
	public Integer getOrgId() {
		return this.orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	@Column(name = "requireType", length = 2)
	public String getRequireType() {
		return this.requireType;
	}

	public void setRequireType(String requireType) {
		this.requireType = requireType;
	}

	@Column(name = "requireName", length = 100)
	public String getRequireName() {
		return this.requireName;
	}

	public void setRequireName(String requireName) {
		this.requireName = requireName;
	}

	@Column(name = "equipType", length = 1000)
	public String getEquipType() {
		return this.equipType;
	}

	public void setEquipType(String equipType) {
		this.equipType = equipType;
	}

	@Column(name = "serviceRange", length = 1000)
	public String getServiceRange() {
		return this.serviceRange;
	}

	public void setServiceRange(String serviceRange) {
		this.serviceRange = serviceRange;
	}

	@Column(name = "logoUrl", length = 50)
	public String getLogoUrl() {
		return this.logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	@Column(name = "requireBrief", length = 1000)
	public String getRequireBrief() {
		return this.requireBrief;
	}

	public void setRequireBrief(String requireBrief) {
		this.requireBrief = requireBrief;
	}

	@Column(name = "remark", length = 100)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "validDate", length = 19)
	public Date getValidDate() {
		return this.validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Column(name = "requireUnit", length = 100)
	public String getRequireUnit() {
		return this.requireUnit;
	}

	public void setRequireUnit(String requireUnit) {
		this.requireUnit = requireUnit;
	}

	@Column(name = "address", length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "linkMan", length = 100)
	public String getLinkMan() {
		return this.linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	@Column(name = "linkPhone", length = 100)
	public String getLinkPhone() {
		return this.linkPhone;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
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

	@Column(name = "viewCount")
	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	@Override
	public String toString() {
		return "TrmRequire [id=" + id + ", orgId=" + orgId + ", requireType=" + requireType + ", requireName="
				+ requireName + ", equipType=" + equipType + ", serviceRange=" + serviceRange + ", logoUrl=" + logoUrl
				+ ", requireBrief=" + requireBrief + ", remark=" + remark + ", validDate=" + validDate
				+ ", requireUnit=" + requireUnit + ", address=" + address + ", linkMan=" + linkMan + ", linkPhone="
				+ linkPhone + ", audStatus=" + audStatus + ", audDate=" + audDate + ", audOpinion=" + audOpinion
				+ ", audPerson=" + audPerson + ", isActive=" + isActive + ", creator=" + creator + ", createTime="
				+ createTime + ", updater=" + updater + ", updateTime=" + updateTime + ", viewCount=" + viewCount + "]";
	}
	
}