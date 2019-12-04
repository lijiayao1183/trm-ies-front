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
 * TrmBanner entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "trm_banner")
@Where(clause = "isActive='Y'")//获取是激活状态的
public class TrmBanner implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String siteCode;
	private String bannerUp;
	private String bannerDown;
	private String videoUrl;
	private String bgColour;
	private String imgUrl;
	private String brief;
	private Integer sortNo;
	private String isActive;
	private String creator;
	private Date createTime;
	private String updater;
	private Date updateTime;

	// Constructors

	/** default constructor */
	public TrmBanner() {
	}

	/** minimal constructor */
	public TrmBanner(String siteCode, String isActive) {
		this.siteCode = siteCode;
		this.isActive = isActive;
	}

	/** full constructor */
	public TrmBanner(Integer id, String siteCode, String bannerUp, String bannerDown, String videoUrl, String bgColour,
			String imgUrl, String brief, Integer sortNo, String isActive, String creator, Date createTime,
			String updater, Date updateTime) {
		super();
		this.id = id;
		this.siteCode = siteCode;
		this.bannerUp = bannerUp;
		this.bannerDown = bannerDown;
		this.videoUrl = videoUrl;
		this.bgColour = bgColour;
		this.imgUrl = imgUrl;
		this.brief = brief;
		this.sortNo = sortNo;
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

	@Column(name = "siteCode", nullable = false, length = 2)
	public String getSiteCode() {
		return this.siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	@Column(name = "bannerUp", length = 100)
	public String getBannerUp() {
		return this.bannerUp;
	}

	public void setBannerUp(String bannerUp) {
		this.bannerUp = bannerUp;
	}

	@Column(name = "bannerDown", length = 100)
	public String getBannerDown() {
		return this.bannerDown;
	}

	public void setBannerDown(String bannerDown) {
		this.bannerDown = bannerDown;
	}

	@Column(name = "videoUrl", length = 100)
	public String getVideoUrl() {
		return this.videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	@Column(name = "bgColour", length = 20)
	public String getBgColour() {
		return this.bgColour;
	}

	public void setBgColour(String bgColour) {
		this.bgColour = bgColour;
	}

	@Column(name = "imgUrl", length = 100)
	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Column(name = "brief", length = 500)
	public String getBrief() {
		return this.brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	@Column(name = "sortNo")
	public Integer getSortNo() {
		return this.sortNo;
	}

	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}

	@Column(name = "isActive", nullable = false, length = 1)
	public String getIsActive() {
		return this.isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Column(name = "creator", length = 1000)
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

	@Column(name = "updater", length = 1000)
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

	@Override
	public String toString() {
		return "TrmBanner [id=" + id + ", siteCode=" + siteCode + ", bannerUp=" + bannerUp + ", bannerDown="
				+ bannerDown + ", videoUrl=" + videoUrl + ", bgColour=" + bgColour + ", imgUrl=" + imgUrl + ", brief="
				+ brief + ", sortNo=" + sortNo + ", isActive=" + isActive + ", creator=" + creator + ", createTime="
				+ createTime + ", updater=" + updater + ", updateTime=" + updateTime + "]";
	}

}