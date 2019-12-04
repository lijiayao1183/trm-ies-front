package com.trm.model.techservorg;

import java.util.Date;

/**
 * 技术服务机构 随附材料详情
 * @author zhaosimiao 2018-6-5 14:21:20
 */
public class OrgMaterialDetail {

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
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public String getMaterialType() {
		return materialType;
	}
	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public String getMaterialUrl() {
		return materialUrl;
	}
	public void setMaterialUrl(String materialUrl) {
		this.materialUrl = materialUrl;
	}
	public Integer getMaterialSize() {
		return materialSize;
	}
	public void setMaterialSize(Integer materialSize) {
		this.materialSize = materialSize;
	}
	public String getMaterialFormat() {
		return materialFormat;
	}
	public void setMaterialFormat(String materialFormat) {
		this.materialFormat = materialFormat;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
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
	
	@Override
	public String toString() {
		return "OrgMaterialDetail [id=" + id + ", orgId=" + orgId + ", materialType=" + materialType + ", materialName="
				+ materialName + ", materialUrl=" + materialUrl + ", materialSize=" + materialSize + ", materialFormat="
				+ materialFormat + ", isActive=" + isActive + ", updater=" + updater + ", updateTime=" + updateTime
				+ ", creator=" + creator + ", createTime=" + createTime + "]";
	}
	
}