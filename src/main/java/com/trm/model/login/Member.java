package com.trm.model.login;

import java.util.Date;

public class Member {
	
    private Integer id;
    private String username;
    private String password;
    private String nickName;
    private String phone;
    private String email;
    private String qq;
    private String weChat;
    private String problem;
    private String answer;
    private String userType;
    private String orgName;
    private String orgProperty;
    private String isListed;
    private String isHighNew;
    private String masterType;
    private String master;
    private String orgBrief;
    private String licensePdf;
    private String promisePdf;
    private String linkPerson;
    private String department;
    private String numberId;
    private String province;
    private String city;
    private String area;
    private String audStatus;
    private Date audDate;
    private String audOpinion;
    private String audPerson;
    private String remark;
    private String headPortrait;
	private String isNtblisted;
	private String isWepermited;
	private String isWeqkept;
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
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
    public String getQq() {
        return qq;
    }
    public void setQq(String qq) {
        this.qq = qq;
    }
    public String getWeChat() {
        return weChat;
    }
    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }
    public String getProblem() {
        return problem;
    }
    public void setProblem(String problem) {
        this.problem = problem;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
    public String getOrgName() {
        return orgName;
    }
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
    public String getOrgProperty() {
        return orgProperty;
    }
    public void setOrgProperty(String orgProperty) {
        this.orgProperty = orgProperty;
    }
    public String getIsListed() {
        return isListed;
    }
    public void setIsListed(String isListed) {
        this.isListed = isListed;
    }
    public String getIsHighNew() {
        return isHighNew;
    }
    public void setIsHighNew(String isHighNew) {
        this.isHighNew = isHighNew;
    }
    public String getMaster() {
        return master;
    }
    public void setMaster(String master) {
        this.master = master;
    }
    public String getOrgBrief() {
        return orgBrief;
    }
    public void setOrgBrief(String orgBrief) {
        this.orgBrief = orgBrief;
    }
    public String getLicensePdf() {
        return licensePdf;
    }
    public void setLicensePdf(String licensePdf) {
        this.licensePdf = licensePdf;
    }
    public String getPromisePdf() {
        return promisePdf;
    }
    public void setPromisePdf(String promisePdf) {
        this.promisePdf = promisePdf;
    }
    public String getLinkPerson() {
        return linkPerson;
    }
    public void setLinkPerson(String linkPerson) {
        this.linkPerson = linkPerson;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getNumberId() {
        return numberId;
    }
    public void setNumberId(String numberId) {
        this.numberId = numberId;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public String getAudStatus() {
        return audStatus;
    }
    public void setAudStatus(String audStatus) {
        this.audStatus = audStatus;
    }
    public Date getAudDate() {
        return audDate;
    }
    public void setAudDate(Date audDate) {
        this.audDate = audDate;
    }
    public String getAudOpinion() {
        return audOpinion;
    }
    public void setAudOpinion(String audOpinion) {
        this.audOpinion = audOpinion;
    }
    public String getAudPerson() {
        return audPerson;
    }
    public void setAudPerson(String audPerson) {
        this.audPerson = audPerson;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}
	public String getMasterType() {
		return masterType;
	}
	public void setMasterType(String masterType) {
		this.masterType = masterType;
	}
	public String getIsNtblisted() {
		return isNtblisted;
	}
	public void setIsNtblisted(String isNtblisted) {
		this.isNtblisted = isNtblisted;
	}
	public String getIsWepermited() {
		return isWepermited;
	}
	public void setIsWepermited(String isWepermited) {
		this.isWepermited = isWepermited;
	}
	public String getIsWeqkept() {
		return isWeqkept;
	}
	public void setIsWeqkept(String isWeqkept) {
		this.isWeqkept = isWeqkept;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", username=" + username + ", password=" + password + ", nickName=" + nickName
				+ ", phone=" + phone + ", email=" + email + ", qq=" + qq + ", weChat=" + weChat + ", problem=" + problem
				+ ", answer=" + answer + ", userType=" + userType + ", orgName=" + orgName + ", orgProperty="
				+ orgProperty + ", isListed=" + isListed + ", isHighNew=" + isHighNew + ", masterType=" + masterType
				+ ", master=" + master + ", orgBrief=" + orgBrief + ", licensePdf=" + licensePdf + ", promisePdf="
				+ promisePdf + ", linkPerson=" + linkPerson + ", department=" + department + ", numberId=" + numberId
				+ ", province=" + province + ", city=" + city + ", area=" + area + ", audStatus=" + audStatus
				+ ", audDate=" + audDate + ", audOpinion=" + audOpinion + ", audPerson=" + audPerson + ", remark="
				+ remark + ", headPortrait=" + headPortrait + ", isNtblisted=" + isNtblisted + ", isWepermited="
				+ isWepermited + ", isWeqkept=" + isWeqkept + "]";
	}
	
}
