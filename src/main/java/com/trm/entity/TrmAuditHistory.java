package com.trm.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TrmAuditHistory entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "trm_audit_history")
public class TrmAuditHistory implements java.io.Serializable {

	// Fields

	private Integer id;
	private String auditType;
	private Integer auditId;
	private String auditor;
	private Date auditDate;
	private String station;
	private String status;
	private String auditMsg;
	private String isActive;
	private String updater;
	private Date updateTime;
	private String creator;
	private Date createTime;

	// Constructors

	/** default constructor */
	public TrmAuditHistory() {
	}

	/** minimal constructor */
	public TrmAuditHistory(Integer auditId) {
		this.auditId = auditId;
	}

	public TrmAuditHistory(Integer id, String auditType, Integer auditId, String auditor, Date auditDate,
			String station, String status, String auditMsg, String isActive, String updater, Date updateTime,
			String creator, Date createTime) {
		super();
		this.id = id;
		this.auditType = auditType;
		this.auditId = auditId;
		this.auditor = auditor;
		this.auditDate = auditDate;
		this.station = station;
		this.status = status;
		this.auditMsg = auditMsg;
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

	@Column(name = "auditType", length = 1)
	public String getAuditType() {
		return this.auditType;
	}

	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}

	@Column(name = "auditId", nullable = false)
	public Integer getAuditId() {
		return this.auditId;
	}

	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}

	@Column(name = "auditor", length = 1000)
	public String getAuditor() {
		return this.auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	@Column(name = "auditDate", length = 19)
	public Date getAuditDate() {
		return this.auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	@Column(name = "station", length = 10)
	public String getStation() {
		return this.station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	@Column(name = "status", length = 10)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "auditMsg", length = 1000)
	public String getAuditMsg() {
		return this.auditMsg;
	}

	public void setAuditMsg(String auditMsg) {
		this.auditMsg = auditMsg;
	}

	@Column(name = "isActive", length = 1)
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