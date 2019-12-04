package com.trm.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

/**
 * AidDataDictionary entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_data_dictionary")
@Where(clause = "isActive='Y'")//获取是激活状态的
public class SysDataDictionary implements java.io.Serializable {

	// Fields

    private static final long serialVersionUID = 1L;
    private Integer id;
	private String code;
	private String name;
	private String type;
	private String subType;
	private String remarks;
	private Integer sortNo;
	private String isActive;
	private String updater;
	private Date updateTime;
	private String creator;
	private Date createTime;

	// Constructors

	/** default constructor */
	public SysDataDictionary() {
	}

	/** minimal constructor */
	public SysDataDictionary(String code, String name, String subType,
			String isActive) {
		this.code = code;
		this.name = name;
		this.subType = subType;
		this.isActive = isActive;
	}

	/** full constructor */
	public SysDataDictionary(String code, String name, String type,
			String subType, String remarks, Integer sortNo, String isActive,
			String updater, Date updateTime, String creator, Date createTime) {
		this.code = code;
		this.name = name;
		this.type = type;
		this.subType = subType;
		this.remarks = remarks;
		this.sortNo = sortNo;
		this.isActive = isActive;
		this.updater = updater;
		this.updateTime = updateTime;
		this.creator = creator;
		this.createTime = createTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "code", nullable = false, length = 1000)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name", nullable = false, length = 1000)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "type", length = 1000)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "subType", nullable = false, length = 1000)
	public String getSubType() {
		return this.subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	@Column(name = "remarks", length = 1000)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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