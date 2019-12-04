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
 * 军工企业
 * add by zhaosimiao at 2019-3-13 11:21:09
 */
@Entity
@Table(name = "trm_unit")
@Where(clause = "isActive='Y'")
public class TrmUnit implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	/**
	 * 单位名称
	 */
	private String orgName;
	/**
	 * 单位性质
	 */
	private String orgProperty;
	/**
	 * 单位介绍
	 */
	private String orgBrief;
	/**
	 * 所在省
	 */
	private String province;
	/**
	 * 所在市
	 */
	private String city;
	/**
	 * 所在区
	 */
	private String area;
	/**
	 * 详细地址
	 */
	private String address;
	/**
	 * 统一社会信用代码
	 */
	private String creditId;
	/**
	 * 是否上市公司
	 */
	private String isListed;
	/**
	 * 是否高新企业
	 */
	private String isHighNew;
	/**
	 * 是否新三板挂牌
	 */
	private String isNtblisted;
	/**
	 * 是否有武器装备科研生产许可证
	 */
	private String isWepermited;
	/**
	 * 是否有武器装备科研生产单位保密资格证
	 */
	private String isWeqkept;
	/**
	 * 隶属单位类型（一级）
	 */
	private String masterType;
	/**
	 * 隶属单位（二级）
	 */
	private String master;
	/**
	 * 营业执照/法人证书扫描件
	 */
	private String licensePdf;
	/**
	 * 信息报送承诺书扫描件
	 */
	private String promisePdf;
	private String isActive;
	private String creator;
	private Date createTime;
	private String updater;
	private Date updateTime;
	private String isImportant;
	/** default constructor */
	public TrmUnit() {
	}

	/** minimal constructor */
	public TrmUnit(String isActive) {
		this.isActive = isActive;
	}

	/** full constructor */
	public TrmUnit(Integer id, String orgName, String orgProperty, String orgBrief, String province, String city,
			String area, String address, String creditId, String isListed, String isHighNew, String isNtblisted,
			String isWepermited, String isWeqkept, String masterType, String master, String licensePdf,
			String promisePdf, String isActive, String creator, Date createTime, String updater, Date updateTime,
			String 	isImportant) {
		super();
		this.id = id;
		this.orgName = orgName;
		this.orgProperty = orgProperty;
		this.orgBrief = orgBrief;
		this.province = province;
		this.city = city;
		this.area = area;
		this.address = address;
		this.creditId = creditId;
		this.isListed = isListed;
		this.isHighNew = isHighNew;
		this.isNtblisted = isNtblisted;
		this.isWepermited = isWepermited;
		this.isWeqkept = isWeqkept;
		this.masterType = masterType;
		this.master = master;
		this.licensePdf = licensePdf;
		this.promisePdf = promisePdf;
		this.isActive = isActive;
		this.creator = creator;
		this.createTime = createTime;
		this.updater = updater;
		this.updateTime = updateTime;
		this.isImportant = isImportant;
	}

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

	@Column(name = "province", length = 10)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "city", length = 10)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "area", length = 10)
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "address", length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "creditId", length = 100)
	public String getCreditId() {
		return this.creditId;
	}

	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}

	@Column(name = "isListed", length = 2)
	public String getIsListed() {
		return this.isListed;
	}

	public void setIsListed(String isListed) {
		this.isListed = isListed;
	}

	@Column(name = "isHighNew", length = 2)
	public String getIsHighNew() {
		return this.isHighNew;
	}

	public void setIsHighNew(String isHighNew) {
		this.isHighNew = isHighNew;
	}

	@Column(name = "isNTBListed", length = 2)
	public String getIsNtblisted() {
		return this.isNtblisted;
	}

	public void setIsNtblisted(String isNtblisted) {
		this.isNtblisted = isNtblisted;
	}

	@Column(name = "isWEPermited", length = 2)
	public String getIsWepermited() {
		return this.isWepermited;
	}

	public void setIsWepermited(String isWepermited) {
		this.isWepermited = isWepermited;
	}

	@Column(name = "isWEQKept", length = 2)
	public String getIsWeqkept() {
		return this.isWeqkept;
	}

	public void setIsWeqkept(String isWeqkept) {
		this.isWeqkept = isWeqkept;
	}

	@Column(name = "masterType", length = 100)
	public String getMasterType() {
		return this.masterType;
	}

	public void setMasterType(String masterType) {
		this.masterType = masterType;
	}

	@Column(name = "master", length = 100)
	public String getMaster() {
		return this.master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	@Column(name = "licensePDF", length = 100)
	public String getLicensePdf() {
		return this.licensePdf;
	}

	public void setLicensePdf(String licensePdf) {
		this.licensePdf = licensePdf;
	}

	@Column(name = "promisePDF", length = 100)
	public String getPromisePdf() {
		return this.promisePdf;
	}

	public void setPromisePdf(String promisePdf) {
		this.promisePdf = promisePdf;
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

	@Column(name = "isImportant",nullable = false, length = 1)
	public String getIsImportant(){
		return this.isImportant;
	}

	public void setIsImportant(String isImportant){
		this.isImportant = isImportant;
	}

	@Override
	public String toString() {
		return "TrmUnit{" +
				"id=" + id +
				", orgName='" + orgName + '\'' +
				", orgProperty='" + orgProperty + '\'' +
				", orgBrief='" + orgBrief + '\'' +
				", province='" + province + '\'' +
				", city='" + city + '\'' +
				", area='" + area + '\'' +
				", address='" + address + '\'' +
				", creditId='" + creditId + '\'' +
				", isListed='" + isListed + '\'' +
				", isHighNew='" + isHighNew + '\'' +
				", isNtblisted='" + isNtblisted + '\'' +
				", isWepermited='" + isWepermited + '\'' +
				", isWeqkept='" + isWeqkept + '\'' +
				", masterType='" + masterType + '\'' +
				", master='" + master + '\'' +
				", licensePdf='" + licensePdf + '\'' +
				", promisePdf='" + promisePdf + '\'' +
				", isActive='" + isActive + '\'' +
				", creator='" + creator + '\'' +
				", createTime=" + createTime +
				", updater='" + updater + '\'' +
				", updateTime=" + updateTime +
				", isImportant='" + isImportant + '\'' +
				'}';
	}
}