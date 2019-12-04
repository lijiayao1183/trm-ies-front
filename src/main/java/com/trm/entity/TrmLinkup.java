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
 * TrmLinkup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "trm_linkup")
@Where(clause = "isActive='Y'")//获取是激活状态的
public class TrmLinkup implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer userId;
	private Integer unitId;
	private Integer departId;
	private String title;
	private String leaveMsg;
	private String replyMsg;
	private String replyStatus;
	private Date replyDate;
	private String replyPerson;
	private String isActive;
	private String creator;
	private Date createTime;
	private String updater;
	private Date updateTime;

	// Constructors

	/** default constructor */
	public TrmLinkup() {
	}

	/** minimal constructor */
	public TrmLinkup(String isActive) {
		this.isActive = isActive;
	}

	/** full constructor */
	public TrmLinkup(Integer userId, Integer unitId, Integer departId,
			String title, String leaveMsg, String replyMsg, String replyStatus,
			Date replyDate, String replyPerson, String isActive,
			String creator, Date createTime, String updater,
			Date updateTime) {
		this.userId = userId;
		this.unitId = unitId;
		this.departId = departId;
		this.title = title;
		this.leaveMsg = leaveMsg;
		this.replyMsg = replyMsg;
		this.replyStatus = replyStatus;
		this.replyDate = replyDate;
		this.replyPerson = replyPerson;
		this.isActive = isActive;
		this.creator = creator;
		this.createTime = createTime;
		this.updater = updater;
		this.updateTime = updateTime;
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

	@Column(name = "title", length = 100)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "leaveMsg", length = 1000)
	public String getLeaveMsg() {
		return this.leaveMsg;
	}

	public void setLeaveMsg(String leaveMsg) {
		this.leaveMsg = leaveMsg;
	}

	@Column(name = "replyMsg", length = 1000)
	public String getReplyMsg() {
		return this.replyMsg;
	}

	public void setReplyMsg(String replyMsg) {
		this.replyMsg = replyMsg;
	}

	@Column(name = "replyStatus", length = 2)
	public String getReplyStatus() {
		return this.replyStatus;
	}

	public void setReplyStatus(String replyStatus) {
		this.replyStatus = replyStatus;
	}

	@Column(name = "replyDate", length = 19)
	public Date getReplyDate() {
		return this.replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	@Column(name = "replyPerson", length = 50)
	public String getReplyPerson() {
		return this.replyPerson;
	}

	public void setReplyPerson(String replyPerson) {
		this.replyPerson = replyPerson;
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

}