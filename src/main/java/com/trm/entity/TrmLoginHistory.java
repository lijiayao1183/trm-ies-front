package com.trm.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TrmLoginHistory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "trm_login_history")
public class TrmLoginHistory implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String username;
	private Date loginTime;
	private Date logoutTime;
	private String browser;
	private String ip;

	// Constructors

	/** default constructor */
	public TrmLoginHistory() {
	}

	/** full constructor */
	public TrmLoginHistory(String username, Date loginTime,
			Date logoutTime, String browser, String ip) {
		this.username = username;
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
		this.browser = browser;
		this.ip = ip;
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

	@Column(name = "loginTime", length = 19)
	public Date getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	@Column(name = "logoutTime", length = 19)
	public Date getLogoutTime() {
		return this.logoutTime;
	}

	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}

	@Column(name = "browser", length = 20)
	public String getBrowser() {
		return this.browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	@Column(name = "ip", length = 20)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "TrmLoginHistory [id=" + id + ", username=" + username + ", loginTime=" + loginTime + ", logoutTime="
				+ logoutTime + ", browser=" + browser + ", ip=" + ip + "]";
	}

}