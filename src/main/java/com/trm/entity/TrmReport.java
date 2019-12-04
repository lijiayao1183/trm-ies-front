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
 * TrmReport entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "trm_report")
@Where(clause = "isActive='Y'")//获取是激活状态的
public class TrmReport implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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

	// Constructors

	/** default constructor */
	public TrmReport() {
	}

	/** minimal constructor */
	public TrmReport(String isActive) {
		this.isActive = isActive;
	}

	/** full constructor */
	public TrmReport(Integer userId, Integer unitId, Integer departId,
			Integer reportYear, Integer reportQuart, Integer equipSum,
			Integer facilitySum, Integer sumItem1, Double sumItem2,
			Double sumItem3, Integer inProvinceCount, Integer xianCount,
			Integer outProvinceCount, String serviceItem, String caseName,
			String caseObj, String caseBrief, String caseEffect,
			String reportStatus, String isActive, String updater,
			Date updateTime, String creator, Date createTime) {
		this.userId = userId;
		this.unitId = unitId;
		this.departId = departId;
		this.reportYear = reportYear;
		this.reportQuart = reportQuart;
		this.equipSum = equipSum;
		this.facilitySum = facilitySum;
		this.sumItem1 = sumItem1;
		this.sumItem2 = sumItem2;
		this.sumItem3 = sumItem3;
		this.inProvinceCount = inProvinceCount;
		this.xianCount = xianCount;
		this.outProvinceCount = outProvinceCount;
		this.serviceItem = serviceItem;
		this.caseName = caseName;
		this.caseObj = caseObj;
		this.caseBrief = caseBrief;
		this.caseEffect = caseEffect;
		this.reportStatus = reportStatus;
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

	@Column(name = "userId")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "unitId")
	public Integer getUnitId() {
		return this.unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	@Column(name = "departId")
	public Integer getDepartId() {
		return this.departId;
	}

	public void setDepartId(Integer departId) {
		this.departId = departId;
	}

	@Column(name = "reportYear")
	public Integer getReportYear() {
		return this.reportYear;
	}

	public void setReportYear(Integer reportYear) {
		this.reportYear = reportYear;
	}

	@Column(name = "reportQuart")
	public Integer getReportQuart() {
		return this.reportQuart;
	}

	public void setReportQuart(Integer reportQuart) {
		this.reportQuart = reportQuart;
	}

	@Column(name = "equipSum")
	public Integer getEquipSum() {
		return this.equipSum;
	}

	public void setEquipSum(Integer equipSum) {
		this.equipSum = equipSum;
	}

	@Column(name = "facilitySum")
	public Integer getFacilitySum() {
		return this.facilitySum;
	}

	public void setFacilitySum(Integer facilitySum) {
		this.facilitySum = facilitySum;
	}

	@Column(name = "sumItem1")
	public Integer getSumItem1() {
		return this.sumItem1;
	}

	public void setSumItem1(Integer sumItem1) {
		this.sumItem1 = sumItem1;
	}

	@Column(name = "sumItem2", precision = 22, scale = 0)
	public Double getSumItem2() {
		return this.sumItem2;
	}

	public void setSumItem2(Double sumItem2) {
		this.sumItem2 = sumItem2;
	}

	@Column(name = "sumItem3", precision = 22, scale = 0)
	public Double getSumItem3() {
		return this.sumItem3;
	}

	public void setSumItem3(Double sumItem3) {
		this.sumItem3 = sumItem3;
	}

	@Column(name = "inProvinceCount")
	public Integer getInProvinceCount() {
		return this.inProvinceCount;
	}

	public void setInProvinceCount(Integer inProvinceCount) {
		this.inProvinceCount = inProvinceCount;
	}

	@Column(name = "xianCount")
	public Integer getXianCount() {
		return this.xianCount;
	}

	public void setXianCount(Integer xianCount) {
		this.xianCount = xianCount;
	}

	@Column(name = "outProvinceCount")
	public Integer getOutProvinceCount() {
		return this.outProvinceCount;
	}

	public void setOutProvinceCount(Integer outProvinceCount) {
		this.outProvinceCount = outProvinceCount;
	}

	@Column(name = "serviceItem", length = 1000)
	public String getServiceItem() {
		return this.serviceItem;
	}

	public void setServiceItem(String serviceItem) {
		this.serviceItem = serviceItem;
	}

	@Column(name = "caseName", length = 500)
	public String getCaseName() {
		return this.caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	@Column(name = "caseObj", length = 1000)
	public String getCaseObj() {
		return this.caseObj;
	}

	public void setCaseObj(String caseObj) {
		this.caseObj = caseObj;
	}

	@Column(name = "caseBrief", length = 1000)
	public String getCaseBrief() {
		return this.caseBrief;
	}

	public void setCaseBrief(String caseBrief) {
		this.caseBrief = caseBrief;
	}

	@Column(name = "caseEffect", length = 1000)
	public String getCaseEffect() {
		return this.caseEffect;
	}

	public void setCaseEffect(String caseEffect) {
		this.caseEffect = caseEffect;
	}

	@Column(name = "reportStatus", length = 2)
	public String getReportStatus() {
		return this.reportStatus;
	}

	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}

	@Column(name = "isActive", nullable = false, length = 1)
	public String getIsActive() {
		return this.isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
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

	@Override
	public String toString() {
		return "TrmReport [id=" + id + ", userId=" + userId + ", unitId=" + unitId + ", departId=" + departId
				+ ", reportYear=" + reportYear + ", reportQuart=" + reportQuart + ", equipSum=" + equipSum
				+ ", facilitySum=" + facilitySum + ", sumItem1=" + sumItem1 + ", sumItem2=" + sumItem2 + ", sumItem3="
				+ sumItem3 + ", inProvinceCount=" + inProvinceCount + ", xianCount=" + xianCount + ", outProvinceCount="
				+ outProvinceCount + ", serviceItem=" + serviceItem + ", caseName=" + caseName + ", caseObj=" + caseObj
				+ ", caseBrief=" + caseBrief + ", caseEffect=" + caseEffect + ", reportStatus=" + reportStatus
				+ ", isActive=" + isActive + ", updater=" + updater + ", updateTime=" + updateTime + ", creator="
				+ creator + ", createTime=" + createTime + "]";
	}

}