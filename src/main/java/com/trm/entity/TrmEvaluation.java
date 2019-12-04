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
 * TrmEvaluation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "trm_evaluation")
@Where(clause = "isActive='Y'")//获取是激活状态的
public class TrmEvaluation implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer eqpId;
	private Integer regId;
	private String evaluation;
	private Date publishDate;
	private String audStatus;
	private Date audDate;
	private String audOpinion;
	private String audPerson;
	private String isActive;
	private String updater;
	private Date updateTime;
	private String creator;
	private Date createTime;

	// Constructors

	/** default constructor */
	public TrmEvaluation() {
	}

	/** minimal constructor */
	public TrmEvaluation(String isActive) {
		this.isActive = isActive;
	}

	/** full constructor */
	public TrmEvaluation(Integer eqpId, Integer regId, String evaluation,
			Date publishDate, String audStatus, Date audDate,
			String audOpinion, String audPerson, String isActive,
			String updater, Date updateTime, String creator, Date createTime) {
		this.eqpId = eqpId;
		this.regId = regId;
		this.evaluation = evaluation;
		this.publishDate = publishDate;
		this.audStatus = audStatus;
		this.audDate = audDate;
		this.audOpinion = audOpinion;
		this.audPerson = audPerson;
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

	@Column(name = "regId")
	public Integer getRegId() {
		return this.regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	@Column(name = "evaluation", length = 1000)
	public String getEvaluation() {
		return this.evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	@Column(name = "publishDate", length = 19)
	public Date getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
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