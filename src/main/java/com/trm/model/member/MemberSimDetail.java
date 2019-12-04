package com.trm.model.member;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MemberSimDetail {

    private Integer id;
    private String username;
    private String phone;
    private String email;
    private String orgName;//单位名称
    private String linkPerson;//联系人
    private String audStatus;//审核状态
    private Date audDate;//审核时间
    private Date createTime;//注册时间

    public MemberSimDetail() {
        super();
    }

    public MemberSimDetail(Integer id, String username, String phone, String email, String orgName, String linkPerson, String audStatus, Date audDate,
            Date createTime) {
        super();
        this.id = id;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.orgName = orgName;
        this.linkPerson = linkPerson;
        this.audStatus = audStatus;
        this.audDate = audDate;
        this.createTime = createTime;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getLinkPerson() {
        return linkPerson;
    }

    public void setLinkPerson(String linkPerson) {
        this.linkPerson = linkPerson;
    }

    public String getAudStatus() {
        return audStatus;
    }

    public void setAudStatus(String audStatus) {
        this.audStatus = audStatus;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getAudDate() {
        return audDate;
    }

    public void setAudDate(Date audDate) {
        this.audDate = audDate;
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
}
