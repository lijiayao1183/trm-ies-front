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
 * TrmEqpReq entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "trm_eqp_req")
@Where(clause = "isActive='Y'")//获取是激活状态的
public class TrmEqpReq implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer eqpId;
	private Integer orgId;
	private Integer regId;
	private String focusStatus;
	private String isActive;
	private String updater;
	private Date updateTime;
	private String creator;
	private Date createTime;

	// Constructors

	/** default constructor */
	public TrmEqpReq() {
	}

	/** minimal constructor */
	public TrmEqpReq(String isActive) {
		this.isActive = isActive;
	}

	/** full constructor */
	public TrmEqpReq(Integer eqpId, Integer orgId, Integer regId,
			String focusStatus, String isActive, String updater,
			Date updateTime, String creator, Date createTime) {
		this.eqpId = eqpId;
		this.orgId = orgId;
		this.regId = regId;
		this.focusStatus = focusStatus;
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

	@Column(name = "eqpId")
	public Integer getEqpId() {
		return this.eqpId;
	}

	public void setEqpId(Integer eqpId) {
		this.eqpId = eqpId;
	}

	@Column(name = "orgId")
	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	@Column(name = "regId")
	public Integer getRegId() {
		return this.regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	@Column(name = "focusStatus", length = 2)
	public String getFocusStatus() {
		return this.focusStatus;
	}

	public void setFocusStatus(String focusStatus) {
		this.focusStatus = focusStatus;
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

}