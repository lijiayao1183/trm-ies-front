package com.trm.model.member;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SubMemListDetail {
	
    private Integer id;
    private String username;
    private String linkPerson;
    private String phone;
    private String email;
    private String department;
    private Date createTime;
    
	public SubMemListDetail() {
		super();
	}
	
	public SubMemListDetail(Integer id, String username, String linkPerson, String phone, String email,
			String department, Date createTime) {
		super();
		this.id = id;
		this.username = username;
		this.linkPerson = linkPerson;
		this.phone = phone;
		this.email = email;
		this.department = department;
		this.createTime = createTime;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLinkPerson() {
		return linkPerson;
	}
	public void setLinkPerson(String linkPerson) {
		this.linkPerson = linkPerson;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Override
	public String toString() {
		return "SubMemListDetail [id=" + id + ", username=" + username + ", linkPerson=" + linkPerson + ", phone="
				+ phone + ", email=" + email + ", department=" + department + ", createTime=" + createTime + "]";
	}
	
}
