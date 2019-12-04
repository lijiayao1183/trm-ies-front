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
 * TrmNewsMaterial entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "trm_news_material")
@Where(clause = "isActive='Y'")//获取是激活状态的
public class TrmNewsMaterial implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer newsId;
	private String materialName;
	private String materialUrl;
	private Integer materialSize;
	private String materialSuffix;
	private String isActive;
	private String updater;
	private Date updateTime;
	private String creator;
	private Date createTime;

	// Constructors

	/** default constructor */
	public TrmNewsMaterial() {
	}

	/** minimal constructor */
	public TrmNewsMaterial(String isActive) {
		this.isActive = isActive;
	}

	/** full constructor */
	public TrmNewsMaterial(Integer newsId, String materialName,
			String materialUrl, Integer materialSize, String materialSuffix,
			String isActive, String updater, Date updateTime,
			String creator, Date createTime) {
		this.newsId = newsId;
		this.materialName = materialName;
		this.materialUrl = materialUrl;
		this.materialSize = materialSize;
		this.materialSuffix = materialSuffix;
		this.isActive = isActive;
		this.updater = updater;
		this.updateTime = updateTime;
		this.creator = creator;
		this.createTime = createTime;
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

	@Column(name = "newsId")
	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	@Column(name = "materialName", length = 1000)
	public String getMaterialName() {
		return this.materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	@Column(name = "materialURL", length = 1000)
	public String getMaterialUrl() {
		return this.materialUrl;
	}

	public void setMaterialUrl(String materialUrl) {
		this.materialUrl = materialUrl;
	}

	@Column(name = "materialSize")
	public Integer getMaterialSize() {
		return this.materialSize;
	}

	public void setMaterialSize(Integer materialSize) {
		this.materialSize = materialSize;
	}

	@Column(name = "materialSuffix", length = 1000)
	public String getMaterialSuffix() {
		return this.materialSuffix;
	}

	public void setMaterialSuffix(String materialSuffix) {
		this.materialSuffix = materialSuffix;
	}

	@Column(name = "isActive", nullable = false, length = 1)
	public String getIsActive() {
		return this.isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
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

}