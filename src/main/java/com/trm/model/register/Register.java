package com.trm.model.register;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @description 注册用户信息
 * @author zhaosimiao 
 * @date 2017-9-28 10:12:16
 */
public class Register {
	
    private Integer id;
    
    /**
     * 用户类型必传：
     * 1：设备检索用户
     * 2：设备提供用户
     */
    @NotEmpty(message = "注册用户类型不能为空！")
    private String userType;
    
	//******begin same******//
    @NotEmpty(message = "用户名不能为空！")
    private String username;
    @NotEmpty(message = "密码不能为空！")
    private String password;
    @NotEmpty(message = "邮箱不能为空！")
    private String email;
    @NotEmpty(message = "手机号码不能为空！")
    private String phone;
    @NotEmpty(message = "提示问题不能为空！")
    private String problem;
    @NotEmpty(message = "提示答案不能为空！")
    private String answer;
    //******end same******//
     
    private String nickName;
    private String qq;
    private String weChat;
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
    private String remark;
    @NotEmpty(message = "统一社会信息代码不能为空！")
    private String creditId;
    private String address;
    
    /**
     * 是否新三板挂牌
     */
	private String isNtblisted;
	
	/**
	 * 是否有武器装备科研生产许可证
	 */
	private String isWepermited;
	
	/**
	 * 是否有武器装备科研生产单位保密资格证
	 */
	private String isWeqkept;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getMasterType() {
		return masterType;
	}

	public void setMasterType(String masterType) {
		this.masterType = masterType;
	}

	public String getCreditId() {
		return creditId;
	}

	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Register [id=" + id + ", userType=" + userType + ", username="
				+ username + ", password=" + password + ", email=" + email
				+ ", phone=" + phone + ", problem=" + problem + ", answer="
				+ answer + ", nickName=" + nickName + ", qq=" + qq
				+ ", weChat=" + weChat + ", orgName=" + orgName
				+ ", orgProperty=" + orgProperty + ", isListed=" + isListed
				+ ", isHighNew=" + isHighNew + ", masterType=" + masterType
				+ ", master=" + master + ", orgBrief=" + orgBrief
				+ ", licensePdf=" + licensePdf + ", promisePdf=" + promisePdf
				+ ", linkPerson=" + linkPerson + ", department=" + department
				+ ", numberId=" + numberId + ", province=" + province
				+ ", city=" + city + ", area=" + area + ", remark=" + remark
				+ ", creditId=" + creditId + ", address=" + address
				+ ", isNtblisted=" + isNtblisted + ", isWepermited="
				+ isWepermited + ", isWeqkept=" + isWeqkept + "]";
	}
}
