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
 * 技术服务机构 增加随附材料
 * @author zhaosimiao 2018-6-5 14:21:20
 */
@Entity
@Table(name = "trm_org_material")
@Where(clause = "isActive='Y'")//获取是激活状态的
public class TrmOrgMaterial implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer orgId;
	private String materialType;
	private String materialName;
	private String materialUrl;
	private Integer materialSize;
	private String materialFormat;
	private String isActive;
	private String updater;
	private Date updateTime;
	private String creator;
	private Date createTime;

	// Constructors

	/** default constructor */
	public TrmOrgMaterial() {
	}

	/** minimal constructor */
	public TrmOrgMaterial(String isActive) {
		this.isActive = isActive;
	}

	/** full constructor */
	public TrmOrgMaterial(Integer orgId, String materialType,
			String materialName, String materialUrl, Integer materialSize,
			String materialFormat, String isActive, String updater,
			Date updateTime, String creator, Date createTime) {
		this.orgId = orgId;
		this.materialType = materialType;
		this.materialName = materialName;
		this.materialUrl = materialUrl;
		this.materialSize = materialSize;
		this.materialFormat = materialFormat;
		this.isActive = isActive;
		this.updater = updater;
		this.updateTime = updateTime;
		this.creator = creator;
		this.createTime = createTime;
	}
	
	public TrmOrgMaterial(Integer id, Integer orgId, String materialType, String materialName, String materialUrl,
			Integer materialSize, String materialFormat, String isActive, String updater, Date updateTime,
			String creator, Date createTime) {
		super();
		this.id = id;
		this.orgId = orgId;
		this.materialType = materialType;
		this.materialName = materialName;
		this.materialUrl = materialUrl;
		this.materialSize = materialSize;
		this.materialFormat = materialFormat;
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

	@Column(name = "orgId")
	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	@Column(name = "materialType", length = 1000)
	public String getMaterialType() {
		return this.materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
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

	@Column(name = "materialFormat", length = 1000)
	public String getMaterialFormat() {
		return this.materialFormat;
	}

	public void setMaterialFormat(String materialFormat) {
		this.materialFormat = materialFormat;
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

	@Override
	public String toString() {
		return "TrmOrgMaterial [id=" + id + ", orgId=" + orgId + ", materialType=" + materialType + ", materialName="
				+ materialName + ", materialUrl=" + materialUrl + ", materialSize=" + materialSize + ", materialFormat="
				+ materialFormat + ", isActive=" + isActive + ", updater=" + updater + ", updateTime=" + updateTime
				+ ", creator=" + creator + ", createTime=" + createTime + "]";
	}
	
}