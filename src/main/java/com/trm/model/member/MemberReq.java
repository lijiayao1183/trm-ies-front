package com.trm.model.member;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trm.model.common.CommonRequest;

public class MemberReq extends CommonRequest {

    private String username;//用户名
    private String orgName;//单位名称
    private String phone;//手机、联系方式
    private String audStatus;//审核状态1未审核，2审核通过，3未通过
    private Date regStartTime;
    private Date regEndTime;
    private Date audStartTime;
    private Date audEndTime;
    private String userType;//用户类型1:普通用户(检索)，2:高级用户(可添加设备)
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getOrgName() {
        return orgName;
    }
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAudStatus() {
        return audStatus;
    }
    public void setAudStatus(String audStatus) {
        this.audStatus = audStatus;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getRegStartTime() {
        return regStartTime;
    }
    public void setRegStartTime(Date regStartTime) {
        this.regStartTime = regStartTime;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getRegEndTime() {
        return regEndTime;
    }
    public void setRegEndTime(Date regEndTime) {
        this.regEndTime = regEndTime;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getAudStartTime() {
        return audStartTime;
    }
    public void setAudStartTime(Date audStartTime) {
        this.audStartTime = audStartTime;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getAudEndTime() {
        return audEndTime;
    }
    public void setAudEndTime(Date audEndTime) {
        this.audEndTime = audEndTime;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
    @Override
    public String toString() {
        return "MemberReq [username=" + username + ", orgName=" + orgName + ", phone=" + phone + ", audStatus=" + audStatus + ", regStartTime="
                + regStartTime + ", regEndTime=" + regEndTime + ", audStartTime=" + audStartTime + ", audEndTime=" + audEndTime + ", userType="
                + userType + "]";
    }

}
