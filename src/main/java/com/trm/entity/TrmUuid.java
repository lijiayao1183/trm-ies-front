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
 * TrmUuid entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "trm_uuid")
public class TrmUuid implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String code;
	private Date sendtime;
	private Integer count;

	// Constructors

	/** default constructor */
	public TrmUuid() {
	}

	/** full constructor */
	public TrmUuid(String username, String code, Date sendtime, Integer count) {
		this.username = username;
		this.code = code;
		this.sendtime = sendtime;
		this.count = count;
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

	@Column(name = "username", length = 100)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "code", length = 100)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "sendtime", length = 19)
	public Date getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}

	@Column(name = "count")
	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "TrmUuid [id=" + id + ", username=" + username + ", code=" + code + ", sendtime=" + sendtime + ", count="
				+ count + "]";
	}

}