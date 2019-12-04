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
 * 军民共享资源（即设备设施）
 * add by zhaosimiao at 2019-3-13 11:21:09
 */
@Entity
@Table(name = "trm_equip")
@Where(clause = "isActive='Y'")//获取是激活状态的
public class TrmEquip implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	/**
	 * 所属单位id
	 */
	private Integer orgId;
	/**
	 * 设备名称
	 */
	private String equipName;
	/**
	 * 关键字
	 */
	private String keyWords;
	/**
	 * 设备型号
	 */
	private String equipVerCode;
	/**
	 * 设备图片1
	 */
	private String equipPic1;
	/**
	 * 设备图片2
	 */
	private String equipPic2;
	/**
	 * 设备图片3
	 */
	private String equipPic3;
	/**
	 * 设备功能分类
	 */
	private String equipType;
	/**
	 * 服务领域分类
	 */
	private String serviceRange;
	/**
	 * 服务费用（人民币/万元）
	 */
	private String equipValue;
	/**
	 * 制造厂商
	 */
	private String createFirm;
	/**
	 * 生产国别
	 */
	private String proCountry;
	/**
	 * 品牌
	 */
	private String brand;
	/**
	 * 有效日期
	 */
	private Date validDate;
	/**
	 * 购置日期
	 */
	private Date purchaseDate;
	/**
	 * 服务方式
	 */
	private String serviceMode;
	/**
	 * 先进程度
	 */
	private String advancedLevel;
	/**
	 * 是否发布
	 */
	private String isPublished;
	/**
	 * 发布人
	 */
	private String publisher;
	/**
	 * 发布时间
	 */
	private Date publishTime;
	/**
	 * 主要技术指标
	 */
	private String qualification;
	/**
	 * 功能/应用范围
	 */
	private String useField;
	/**
	 * 技术特色
	 */
	private String tecFeature;
	/**
	 * 联系单位
	 */
	private String linkUnit;
	/**
	 * 联系单位电话
	 */
	private String linkUnitTel;
	/**
	 * 联系单位传真
	 */
	private String linkUnitFax;
	/**
	 * 联系人
	 */
	private String linkPerson;
	/**
	 * 联系人电话
	 */
	private String linkPhone;
	/**
	 * 电子邮箱
	 */
	private String email;
	/**
	 * 审核状态
	 */
	private String audStatus;
	/**
	 * 审核时间
	 */
    private Date audDate;
    /**
	 * 申请审核时间
	 */
    private Date applyDate;
    /**
	 * 审核意见
	 */
	private String audOpinion;
	/**
	 * 审核人
	 */
	private String audPerson;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 检索量
	 */
	private Integer viewCount;
	/**
	 * 访问量
	 */
	private Integer searchCount;
	/**
	 * 关注量
	 */
	private Integer attentCount;
	/**
	 * 评价量
	 */
	private Integer evaluateCount;
	/**
	 * 是否下架
	 */
	private String isDisplay;
	/**
	 * 上下架时间
	 */
    private Date displayDate;
    /**
	 * 下架原因
	 */
	private String reason;
	/**
	 * 设备状态
	 */
	private String usedStatus;
	private String linkAddress;
	private String isActive;
	private String updater;
	private Date updateTime;
	private String creator;
	private Date createTime;
	
	/** default constructor */
	public TrmEquip() {
	}

	/** minimal constructor */
	public TrmEquip(String isActive) {
		this.isActive = isActive;
	}

	/** full constructor */
	public TrmEquip(Integer orgId, String equipName, String keyWords,
			String equipVerCode, String equipPic1, String equipPic2,
			String equipPic3, String equipType, String serviceRange,
			String equipValue, String createFirm, String proCountry,
			String brand, Date validDate, Date purchaseDate,
			String serviceMode, String advancedLevel, String isPublished,
			String publisher, Date publishTime, String qualification,
			String useField, String tecFeature, String linkUnit,
			String linkUnitTel, String linkUnitFax, String linkPerson,
			String linkPhone, String email, String audStatus, Date audDate,
			String audOpinion, String audPerson, String remark,
			Integer viewCount, Integer searchCount, Integer attentCount,
			Integer evaluateCount, String isDisplay, String reason, String usedStatus, 
			String isActive, String updater, Date updateTime, String creator,
			Date createTime, String linkAddress) {
		this.orgId = orgId;
		this.equipName = equipName;
		this.keyWords = keyWords;
		this.equipVerCode = equipVerCode;
		this.equipPic1 = equipPic1;
		this.equipPic2 = equipPic2;
		this.equipPic3 = equipPic3;
		this.equipType = equipType;
		this.serviceRange = serviceRange;
		this.equipValue = equipValue;
		this.createFirm = createFirm;
		this.proCountry = proCountry;
		this.brand = brand;
		this.validDate = validDate;
		this.purchaseDate = purchaseDate;
		this.serviceMode = serviceMode;
		this.advancedLevel = advancedLevel;
		this.isPublished = isPublished;
		this.publisher = publisher;
		this.publishTime = publishTime;
		this.qualification = qualification;
		this.useField = useField;
		this.tecFeature = tecFeature;
		this.linkUnit = linkUnit;
		this.linkUnitTel = linkUnitTel;
		this.linkUnitFax = linkUnitFax;
		this.linkPerson = linkPerson;
		this.linkPhone = linkPhone;
		this.email = email;
		this.audStatus = audStatus;
		this.audDate = audDate;
		this.audOpinion = audOpinion;
		this.audPerson = audPerson;
		this.remark = remark;
		this.viewCount = viewCount;
		this.searchCount = searchCount;
		this.attentCount = attentCount;
		this.evaluateCount = evaluateCount;
		this.isDisplay = isDisplay;
		this.reason = reason;
		this.usedStatus = usedStatus;
		this.isActive = isActive;
		this.updater = updater;
		this.updateTime = updateTime;
		this.creator = creator;
		this.createTime = createTime;
		this.linkAddress = linkAddress;
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

	@Column(name = "equipName", length = 100)
	public String getEquipName() {
		return this.equipName;
	}

	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}

	@Column(name = "keyWords", length = 500)
	public String getKeyWords() {
		return this.keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	@Column(name = "equipVerCode", length = 100)
	public String getEquipVerCode() {
		return this.equipVerCode;
	}

	public void setEquipVerCode(String equipVerCode) {
		this.equipVerCode = equipVerCode;
	}

	@Column(name = "equipPic1", length = 100)
	public String getEquipPic1() {
		return this.equipPic1;
	}

	public void setEquipPic1(String equipPic1) {
		this.equipPic1 = equipPic1;
	}

	@Column(name = "equipPic2", length = 100)
	public String getEquipPic2() {
		return this.equipPic2;
	}

	public void setEquipPic2(String equipPic2) {
		this.equipPic2 = equipPic2;
	}

	@Column(name = "equipPic3", length = 100)
	public String getEquipPic3() {
		return this.equipPic3;
	}

	public void setEquipPic3(String equipPic3) {
		this.equipPic3 = equipPic3;
	}

	@Column(name = "equipType", length = 100)
	public String getEquipType() {
		return this.equipType;
	}

	public void setEquipType(String equipType) {
		this.equipType = equipType;
	}

	@Column(name = "serviceRange", length = 100)
	public String getServiceRange() {
		return this.serviceRange;
	}

	public void setServiceRange(String serviceRange) {
		this.serviceRange = serviceRange;
	}

	@Column(name = "equipValue", length = 100)
	public String getEquipValue() {
		return this.equipValue;
	}

	public void setEquipValue(String equipValue) {
		this.equipValue = equipValue;
	}

	@Column(name = "createFirm", length = 100)
	public String getCreateFirm() {
		return this.createFirm;
	}

	public void setCreateFirm(String createFirm) {
		this.createFirm = createFirm;
	}

	@Column(name = "proCountry", length = 100)
	public String getProCountry() {
		return this.proCountry;
	}

	public void setProCountry(String proCountry) {
		this.proCountry = proCountry;
	}

	@Column(name = "brand", length = 100)
	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Column(name = "validDate", length = 19)
	public Date getValidDate() {
		return this.validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Column(name = "purchaseDate", length = 19)
	public Date getPurchaseDate() {
		return this.purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Column(name = "serviceMode", length = 100)
	public String getServiceMode() {
		return this.serviceMode;
	}

	public void setServiceMode(String serviceMode) {
		this.serviceMode = serviceMode;
	}

	@Column(name = "advancedLevel", length = 100)
	public String getAdvancedLevel() {
		return this.advancedLevel;
	}

	public void setAdvancedLevel(String advancedLevel) {
		this.advancedLevel = advancedLevel;
	}

	@Column(name = "isPublished", length = 2)
	public String getIsPublished() {
		return this.isPublished;
	}

	public void setIsPublished(String isPublished) {
		this.isPublished = isPublished;
	}

	@Column(name = "publisher", length = 100)
	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Column(name = "publishTime", length = 19)
	public Date getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	@Column(name = "qualification", length = 1000)
	public String getQualification() {
		return this.qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@Column(name = "useField", length = 1000)
	public String getUseField() {
		return this.useField;
	}

	public void setUseField(String useField) {
		this.useField = useField;
	}

	@Column(name = "tecFeature", length = 1000)
	public String getTecFeature() {
		return this.tecFeature;
	}

	public void setTecFeature(String tecFeature) {
		this.tecFeature = tecFeature;
	}

	@Column(name = "linkUnit", length = 100)
	public String getLinkUnit() {
		return this.linkUnit;
	}

	public void setLinkUnit(String linkUnit) {
		this.linkUnit = linkUnit;
	}

	@Column(name = "linkUnitTel", length = 100)
	public String getLinkUnitTel() {
		return this.linkUnitTel;
	}

	public void setLinkUnitTel(String linkUnitTel) {
		this.linkUnitTel = linkUnitTel;
	}

	@Column(name = "linkUnitFax", length = 100)
	public String getLinkUnitFax() {
		return this.linkUnitFax;
	}

	public void setLinkUnitFax(String linkUnitFax) {
		this.linkUnitFax = linkUnitFax;
	}

	@Column(name = "linkPerson", length = 100)
	public String getLinkPerson() {
		return this.linkPerson;
	}

	public void setLinkPerson(String linkPerson) {
		this.linkPerson = linkPerson;
	}

	@Column(name = "linkPhone", length = 100)
	public String getLinkPhone() {
		return this.linkPhone;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}

	@Column(name = "email", length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
	@Column(name = "applyDate", length = 19)
	public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
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

	@Column(name = "remark", length = 500)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "viewCount")
	public Integer getViewCount() {
		return this.viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	@Column(name = "searchCount")
	public Integer getSearchCount() {
		return this.searchCount;
	}

	public void setSearchCount(Integer searchCount) {
		this.searchCount = searchCount;
	}

	@Column(name = "attentCount")
	public Integer getAttentCount() {
		return this.attentCount;
	}

	public void setAttentCount(Integer attentCount) {
		this.attentCount = attentCount;
	}

	@Column(name = "evaluateCount")
	public Integer getEvaluateCount() {
		return this.evaluateCount;
	}

	public void setEvaluateCount(Integer evaluateCount) {
		this.evaluateCount = evaluateCount;
	}

	@Column(name = "isDisplay", length = 2)
	public String getIsDisplay() {
		return this.isDisplay;
	}

	public void setIsDisplay(String isDisplay) {
		this.isDisplay = isDisplay;
	}
	
	@Column(name = "displayDate", length = 19)
	public Date getDisplayDate() {
        return displayDate;
    }

    public void setDisplayDate(Date displayDate) {
        this.displayDate = displayDate;
    }

    @Column(name = "reason", length = 100)
	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@Column(name = "usedStatus", length = 2)
	public String getUsedStatus() {
		return this.usedStatus;
	}

	public void setUsedStatus(String usedStatus) {
		this.usedStatus = usedStatus;
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

	@Column(name = "linkAddress", length = 100)
	public String getLinkAddress() {
		return this.linkAddress;
	}

	public void setLinkAddress(String linkAddress) {
		this.linkAddress = linkAddress;
	}

	@Override
	public String toString() {
		return "TrmEquip [id=" + id + ", orgId=" + orgId + ", equipName=" + equipName + ", keyWords=" + keyWords
				+ ", equipVerCode=" + equipVerCode + ", equipPic1=" + equipPic1 + ", equipPic2=" + equipPic2
				+ ", equipPic3=" + equipPic3 + ", equipType=" + equipType + ", serviceRange=" + serviceRange
				+ ", equipValue=" + equipValue + ", createFirm=" + createFirm + ", proCountry=" + proCountry
				+ ", brand=" + brand + ", validDate=" + validDate + ", purchaseDate=" + purchaseDate + ", serviceMode="
				+ serviceMode + ", advancedLevel=" + advancedLevel + ", isPublished=" + isPublished + ", publisher="
				+ publisher + ", publishTime=" + publishTime + ", qualification=" + qualification + ", useField="
				+ useField + ", tecFeature=" + tecFeature + ", linkUnit=" + linkUnit + ", linkUnitTel=" + linkUnitTel
				+ ", linkUnitFax=" + linkUnitFax + ", linkPerson=" + linkPerson + ", linkPhone=" + linkPhone
				+ ", email=" + email + ", audStatus=" + audStatus + ", audDate=" + audDate + ", applyDate=" + applyDate
				+ ", audOpinion=" + audOpinion + ", audPerson=" + audPerson + ", remark=" + remark + ", viewCount="
				+ viewCount + ", searchCount=" + searchCount + ", attentCount=" + attentCount + ", evaluateCount="
				+ evaluateCount + ", isDisplay=" + isDisplay + ", displayDate=" + displayDate + ", reason=" + reason
				+ ", usedStatus=" + usedStatus + ", isActive=" + isActive + ", updater=" + updater + ", updateTime="
				+ updateTime + ", creator=" + creator + ", createTime=" + createTime + ", linkAddress=" + linkAddress + "]";
	}

}