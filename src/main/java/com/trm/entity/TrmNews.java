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
 * TrmNews entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "trm_news")
@Where(clause = "isActive='Y'")//获取是激活状态的
public class TrmNews implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String origin;
	private String summary;
	private String publishUnit;
	private String context;
	private String picture;
	private String flagCode;
	private Date publishTime;
	private String publishStatus;
	private String isTop;
	private Integer topSort;
	private String isActive;
	private String creator;
	private Date createTime;
	private String updater;
	private Date updateTime;

	// Constructors

	/** default constructor */
	public TrmNews() {
	}

	/** minimal constructor */
	public TrmNews(String flagCode, String isActive) {
		this.flagCode = flagCode;
		this.isActive = isActive;
	}

	/** full constructor */
	public TrmNews(String title, String origin, String summary,
			String publishUnit, String context, String picture,
			String flagCode, Date publishTime, String publishStatus,
			String isTop, Integer topSort, String isActive, String creator,
			Date createTime, String updater, Date updateTime) {
		this.title = title;
		this.origin = origin;
		this.summary = summary;
		this.publishUnit = publishUnit;
		this.context = context;
		this.picture = picture;
		this.flagCode = flagCode;
		this.publishTime = publishTime;
		this.publishStatus = publishStatus;
		this.isTop = isTop;
		this.topSort = topSort;
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

	@Column(name = "title", length = 1000)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "origin", length = 1000)
	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@Column(name = "summary", length = 1000)
	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Column(name = "publishUnit", length = 100)
	public String getPublishUnit() {
		return this.publishUnit;
	}

	public void setPublishUnit(String publishUnit) {
		this.publishUnit = publishUnit;
	}

	@Column(name = "context")
	public String getContext() {
		return this.context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Column(name = "picture", length = 1000)
	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Column(name = "flagCode", nullable = false, length = 1000)
	public String getFlagCode() {
		return this.flagCode;
	}

	public void setFlagCode(String flagCode) {
		this.flagCode = flagCode;
	}

	@Column(name = "publishTime", length = 19)
	public Date getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	@Column(name = "publishStatus", length = 10)
	public String getPublishStatus() {
		return this.publishStatus;
	}

	public void setPublishStatus(String publishStatus) {
		this.publishStatus = publishStatus;
	}

	@Column(name = "isTop", length = 10)
	public String getIsTop() {
		return this.isTop;
	}

	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}

	@Column(name = "topSort")
	public Integer getTopSort() {
		return this.topSort;
	}

	public void setTopSort(Integer topSort) {
		this.topSort = topSort;
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

}