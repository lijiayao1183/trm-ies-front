package com.trm.model.report;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReportDetail{

	private Integer id;
	private Integer userId;
	private Integer unitId;
	private Integer departId;
	private Integer reportYear;
	private Integer reportQuart;
	private Integer equipSum;
	private Integer facilitySum;
	private Integer sumItem1;
	private Double sumItem2;
	private Double sumItem3;
	private Integer inProvinceCount;
	private Integer xianCount;
	private Integer outProvinceCount;
	private String serviceItem;
	private String caseName;
	private String caseObj;
	private String caseBrief;
	private String caseEffect;
	private String reportStatus;
	private String isActive;
	private String updater;
	private Date updateTime;
	private String creator;
	private Date createTime;
	private String unitName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public Integer getDepartId() {
		return departId;
	}
	public void setDepartId(Integer departId) {
		this.departId = departId;
	}
	public Integer getReportYear() {
		return reportYear;
	}
	public void setReportYear(Integer reportYear) {
		this.reportYear = reportYear;
	}
	public Integer getReportQuart() {
		return reportQuart;
	}
	public void setReportQuart(Integer reportQuart) {
		this.reportQuart = reportQuart;
	}
	public Integer getEquipSum() {
		return equipSum;
	}
	public void setEquipSum(Integer equipSum) {
		this.equipSum = equipSum;
	}
	public Integer getFacilitySum() {
		return facilitySum;
	}
	public void setFacilitySum(Integer facilitySum) {
		this.facilitySum = facilitySum;
	}
	public Integer getSumItem1() {
		return sumItem1;
	}
	public void setSumItem1(Integer sumItem1) {
		this.sumItem1 = sumItem1;
	}
	public Double getSumItem2() {
		return sumItem2;
	}
	public void setSumItem2(Double sumItem2) {
		this.sumItem2 = sumItem2;
	}
	public Double getSumItem3() {
		return sumItem3;
	}
	public void setSumItem3(Double sumItem3) {
		this.sumItem3 = sumItem3;
	}
	public Integer getInProvinceCount() {
		return inProvinceCount;
	}
	public void setInProvinceCount(Integer inProvinceCount) {
		this.inProvinceCount = inProvinceCount;
	}
	public Integer getXianCount() {
		return xianCount;
	}
	public void setXianCount(Integer xianCount) {
		this.xianCount = xianCount;
	}
	public Integer getOutProvinceCount() {
		return outProvinceCount;
	}
	public void setOutProvinceCount(Integer outProvinceCount) {
		this.outProvinceCount = outProvinceCount;
	}
	public String getServiceItem() {
		return serviceItem;
	}
	public void setServiceItem(String serviceItem) {
		this.serviceItem = serviceItem;
	}
	public String getCaseName() {
		return caseName;
	}
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	public String getCaseObj() {
		return caseObj;
	}
	public void setCaseObj(String caseObj) {
		this.caseObj = caseObj;
	}
	public String getCaseBrief() {
		return caseBrief;
	}
	public void setCaseBrief(String caseBrief) {
		this.caseBrief = caseBrief;
	}
	public String getCaseEffect() {
		return caseEffect;
	}
	public void setCaseEffect(String caseEffect) {
		this.caseEffect = caseEffect;
	}
	public String getReportStatus() {
		return reportStatus;
	}
	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
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
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
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
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	@Override
	public String toString() {
		return "ReportDetail [id=" + id + ", userId=" + userId + ", unitId=" + unitId + ", departId=" + departId
				+ ", reportYear=" + reportYear + ", reportQuart=" + reportQuart + ", equipSum=" + equipSum
				+ ", facilitySum=" + facilitySum + ", sumItem1=" + sumItem1 + ", sumItem2=" + sumItem2 + ", sumItem3="
				+ sumItem3 + ", inProvinceCount=" + inProvinceCount + ", xianCount=" + xianCount + ", outProvinceCount="
				+ outProvinceCount + ", serviceItem=" + serviceItem + ", caseName=" + caseName + ", caseObj=" + caseObj
				+ ", caseBrief=" + caseBrief + ", caseEffect=" + caseEffect + ", reportStatus=" + reportStatus
				+ ", isActive=" + isActive + ", updater=" + updater + ", updateTime=" + updateTime + ", creator="
				+ creator + ", createTime=" + createTime + ", unitName=" + unitName + "]";
	}

}