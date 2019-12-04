package com.trm.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

/**
 * TrmKeyLaboratory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "trm_key_laboratory")
@Where(clause = "isActive='Y'")//获取是激活状态的
public class TrmKeyLaboratory implements java.io.Serializable {

	// Fields

	private Integer id;
	private String labName;
	private String unitName;
	private String person;
	private String phone;
	private String address;
	private String img;
	private String studiDirecti;
	private String brief;
	private String isActive;
	private String creator;
	private Date createTime;
	private String updater;
	private Date updateTime;
	private Integer viewCount;

	// Constructors

	/** default constructor */
	public TrmKeyLaboratory() {
	}

	/** minimal constructor */
	public TrmKeyLaboratory(String isActive) {
		this.isActive = isActive;
	}

	/** full constructor */
	public TrmKeyLaboratory(String labName, String unitName, String person,
			String phone, String address, String img, String studiDirecti,
			String brief, String isActive, String creator, Date createTime,
			String updater, Date updateTime) {
		this.labName = labName;
		this.unitName = unitName;
		this.person = person;
		this.phone = phone;
		this.address = address;
		this.img = img;
		this.studiDirecti = studiDirecti;
		this.brief = brief;
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

	@Column(name = "labName", length = 100)
	public String getLabName() {
		return this.labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	@Column(name = "unitName", length = 100)
	public String getUnitName() {
		return this.unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	@Column(name = "person", length = 100)
	public String getPerson() {
		return this.person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	@Column(name = "phone", length = 100)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "address", length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "img", length = 1000)
	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Column(name = "studiDirecti", length = 300)
	public String getStudiDirecti() {
		return this.studiDirecti;
	}

	public void setStudiDirecti(String studiDirecti) {
		this.studiDirecti = studiDirecti;
	}

	@Column(name = "brief")
	public String getBrief() {
		return this.brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
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
		return "TrmKeyLaboratory [id=" + id + ", labName=" + labName
				+ ", unitName=" + unitName + ", person=" + person + ", phone="
				+ phone + ", address=" + address + ", img=" + img
				+ ", studiDirecti=" + studiDirecti + ", brief=" + brief
				+ ", isActive=" + isActive + ", creator=" + creator
				+ ", createTime=" + createTime + ", updater=" + updater
				+ ", updateTime=" + updateTime + ", viewCount=" + viewCount
				+ "]";
	}
	
}