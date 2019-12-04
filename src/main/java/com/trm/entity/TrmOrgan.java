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
 * TrmOrgan entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "trm_organ")
@Where(clause = "isActive='Y'")//获取是激活状态的
public class TrmOrgan implements java.io.Serializable {

	// Fields

	private Integer id;
	private String orgName;
	private String url;
	private String logoImg;
	private String displayImg;
	private Date establishDate;
	private String phone;
	private String address;
	private String orgProperty;
	private String orgBrief;
	private String research;
	private String isActive;
	private String creator;
	private Date createTime;
	private String updater;
	private Date updateTime;
	private Integer viewCount;

	// Constructors

	/** default constructor */
	public TrmOrgan() {
	}

	/** minimal constructor */
	public TrmOrgan(String isActive) {
		this.isActive = isActive;
	}

	/** full constructor */
	public TrmOrgan(String orgName, String url, String logoImg,
			String displayImg, Date establishDate, String phone,
			String address, String orgProperty, String orgBrief,
			String research, String isActive, String creator, Date createTime,
			String updater, Date updateTime, Integer viewCount) {
		this.orgName = orgName;
		this.url = url;
		this.logoImg = logoImg;
		this.displayImg = displayImg;
		this.establishDate = establishDate;
		this.phone = phone;
		this.address = address;
		this.orgProperty = orgProperty;
		this.orgBrief = orgBrief;
		this.research = research;
		this.isActive = isActive;
		this.creator = creator;
		this.createTime = createTime;
		this.updater = updater;
		this.updateTime = updateTime;
		this.viewCount = viewCount;
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

	@Column(name = "url", length = 200)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "logoImg", length = 200)
	public String getLogoImg() {
		return this.logoImg;
	}

	public void setLogoImg(String logoImg) {
		this.logoImg = logoImg;
	}

	@Column(name = "displayImg", length = 500)
	public String getDisplayImg() {
		return this.displayImg;
	}

	public void setDisplayImg(String displayImg) {
		this.displayImg = displayImg;
	}

	@Column(name = "establishDate", length = 19)
	public Date getEstablishDate() {
		return this.establishDate;
	}

	public void setEstablishDate(Date establishDate) {
		this.establishDate = establishDate;
	}

	@Column(name = "phone", length = 100)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "address", length = 200)
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

	@Column(name = "orgBrief", length = 1000)
	public String getOrgBrief() {
		return this.orgBrief;
	}

	public void setOrgBrief(String orgBrief) {
		this.orgBrief = orgBrief;
	}

	@Column(name = "research", length = 1000)
	public String getResearch() {
		return this.research;
	}

	public void setResearch(String research) {
		this.research = research;
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
		return "TrmOrgan [id=" + id + ", orgName=" + orgName + ", url=" + url
				+ ", logoImg=" + logoImg + ", displayImg=" + displayImg
				+ ", establishDate=" + establishDate + ", phone=" + phone
				+ ", address=" + address + ", orgProperty=" + orgProperty
				+ ", orgBrief=" + orgBrief + ", research=" + research
				+ ", isActive=" + isActive + ", creator=" + creator
				+ ", createTime=" + createTime + ", updater=" + updater
				+ ", updateTime=" + updateTime + ", viewCount=" + viewCount
				+ "]";
	}
	
}