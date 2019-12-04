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
 * TrmMember entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "trm_member")
@Where(clause = "isActive='Y'")//获取是激活状态的
public class TrmMember implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	// modify by zhaosimiao 2017-11-23 11:05:36
	/**
	 * 所属单位id
	 */
	private Integer unitId;
	/**
	 * 所属管理用户id
	 */
	private Integer masterId;
	private String username;
	private String password;
	private String nickName;
	private String phone;
	private String email;
	private String qq;
	private String weChat;
	private String headPortrait;
	private String problem;
	private String answer;
	private String userType;
	private String orgName;
	private String orgProperty;
	private String isListed;
	private String isHighNew;
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
	private String address;
	private String audStatus;
	private Date audDate;
	private String audOpinion;
	private String audPerson;
	private String remark;
	private String isActive;
	private String creator;
	private Date createTime;
	private String updater;
	private Date updateTime;
	private String isNtblisted;
	private String isWepermited;
	private String isWeqkept;
	private String masterType;
	private String creditId;
	private Integer departId;
	private Date loginDate;

	// Constructors

	/** default constructor */
	public TrmMember() {
	}

	/** minimal constructor */
	public TrmMember(String isActive) {
		this.isActive = isActive;
	}

	/** full constructor */
	public TrmMember(Integer id, String username, String password, String nickName,
			String phone, String email, String qq, String weChat,
			String headPortrait, String problem, String answer,
			String userType, String orgName, String orgProperty,
			String isListed, String isHighNew, String master, String orgBrief,
			String licensePdf, String promisePdf, String linkPerson,
			String department, String numberId, String province, String city,
			String area, String address, String audStatus, Date audDate, String audOpinion,
			String audPerson, String remark, String isActive, String creator,
			Date createTime, String updater, Date updateTime,
			String isNtblisted, String isWepermited, String isWeqkept,
			String masterType, String creditId) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.nickName = nickName;
		this.phone = phone;
		this.email = email;
		this.qq = qq;
		this.weChat = weChat;
		this.headPortrait = headPortrait;
		this.problem = problem;
		this.answer = answer;
		this.userType = userType;
		this.orgName = orgName;
		this.orgProperty = orgProperty;
		this.isListed = isListed;
		this.isHighNew = isHighNew;
		this.master = master;
		this.orgBrief = orgBrief;
		this.licensePdf = licensePdf;
		this.promisePdf = promisePdf;
		this.linkPerson = linkPerson;
		this.department = department;
		this.numberId = numberId;
		this.province = province;
		this.city = city;
		this.area = area;
		this.address = address;
		this.audStatus = audStatus;
		this.audDate = audDate;
		this.audOpinion = audOpinion;
		this.audPerson = audPerson;
		this.remark = remark;
		this.isActive = isActive;
		this.creator = creator;
		this.createTime = createTime;
		this.updater = updater;
		this.updateTime = updateTime;
		this.isNtblisted = isNtblisted;
		this.isWepermited = isWepermited;
		this.isWeqkept = isWeqkept;
		this.masterType = masterType;
		this.creditId = creditId;
	}

	/**
	 * modify by zhaosimiao 2017-11-23 11:09:56
	 * 用户表结构调整
	 */
	public TrmMember(Integer id, Integer unitId, Integer masterId, String username, String password, String nickName,
			String phone, String email, String qq, String weChat, String headPortrait, String problem, String answer,
			String userType, String orgName, String orgProperty, String isListed, String isHighNew, String master,
			String orgBrief, String licensePdf, String promisePdf, String linkPerson, String department,
			String numberId, String province, String city, String area, String address, String audStatus, Date audDate,
			String audOpinion, String audPerson, String remark, String isActive, String creator, Date createTime,
			String updater, Date updateTime, String isNtblisted, String isWepermited, String isWeqkept,
			String masterType, String creditId) {
		super();
		this.id = id;
		this.unitId = unitId;
		this.masterId = masterId;
		this.username = username;
		this.password = password;
		this.nickName = nickName;
		this.phone = phone;
		this.email = email;
		this.qq = qq;
		this.weChat = weChat;
		this.headPortrait = headPortrait;
		this.problem = problem;
		this.answer = answer;
		this.userType = userType;
		this.orgName = orgName;
		this.orgProperty = orgProperty;
		this.isListed = isListed;
		this.isHighNew = isHighNew;
		this.master = master;
		this.orgBrief = orgBrief;
		this.licensePdf = licensePdf;
		this.promisePdf = promisePdf;
		this.linkPerson = linkPerson;
		this.department = department;
		this.numberId = numberId;
		this.province = province;
		this.city = city;
		this.area = area;
		this.address = address;
		this.audStatus = audStatus;
		this.audDate = audDate;
		this.audOpinion = audOpinion;
		this.audPerson = audPerson;
		this.remark = remark;
		this.isActive = isActive;
		this.creator = creator;
		this.createTime = createTime;
		this.updater = updater;
		this.updateTime = updateTime;
		this.isNtblisted = isNtblisted;
		this.isWepermited = isWepermited;
		this.isWeqkept = isWeqkept;
		this.masterType = masterType;
		this.creditId = creditId;
	}
	
	public TrmMember(Integer id, Integer unitId, Integer masterId, String username, String password, String nickName,
			String phone, String email, String qq, String weChat, String headPortrait, String problem, String answer,
			String userType, String orgName, String orgProperty, String isListed, String isHighNew, String master,
			String orgBrief, String licensePdf, String promisePdf, String linkPerson, String department,
			String numberId, String province, String city, String area, String address, String audStatus, Date audDate,
			String audOpinion, String audPerson, String remark, String isActive, String creator, Date createTime,
			String updater, Date updateTime, String isNtblisted, String isWepermited, String isWeqkept,
			String masterType, String creditId, Integer departId, Date loginDate) {
		super();
		this.id = id;
		this.unitId = unitId;
		this.masterId = masterId;
		this.username = username;
		this.password = password;
		this.nickName = nickName;
		this.phone = phone;
		this.email = email;
		this.qq = qq;
		this.weChat = weChat;
		this.headPortrait = headPortrait;
		this.problem = problem;
		this.answer = answer;
		this.userType = userType;
		this.orgName = orgName;
		this.orgProperty = orgProperty;
		this.isListed = isListed;
		this.isHighNew = isHighNew;
		this.master = master;
		this.orgBrief = orgBrief;
		this.licensePdf = licensePdf;
		this.promisePdf = promisePdf;
		this.linkPerson = linkPerson;
		this.department = department;
		this.numberId = numberId;
		this.province = province;
		this.city = city;
		this.area = area;
		this.address = address;
		this.audStatus = audStatus;
		this.audDate = audDate;
		this.audOpinion = audOpinion;
		this.audPerson = audPerson;
		this.remark = remark;
		this.isActive = isActive;
		this.creator = creator;
		this.createTime = createTime;
		this.updater = updater;
		this.updateTime = updateTime;
		this.isNtblisted = isNtblisted;
		this.isWepermited = isWepermited;
		this.isWeqkept = isWeqkept;
		this.masterType = masterType;
		this.creditId = creditId;
		this.departId = departId;
		this.loginDate = loginDate;
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
	
	@Column(name = "unitId")
	public Integer getUnitId() {
		return this.unitId;
	}
	
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	
	@Column(name = "masterId")
	public Integer getMasterId() {
		return this.masterId;
	}
	
	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
	}
	
	@Column(name = "username", length = 100)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "nickName", length = 100)
	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(name = "phone", length = 100)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "email", length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "qq", length = 100)
	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column(name = "weChat", length = 100)
	public String getWeChat() {
		return this.weChat;
	}

	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}

	@Column(name = "headPortrait", length = 100)
	public String getHeadPortrait() {
		return this.headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	@Column(name = "problem", length = 100)
	public String getProblem() {
		return this.problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	@Column(name = "answer", length = 100)
	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Column(name = "userType", length = 10)
	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Column(name = "orgName", length = 100)
	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Column(name = "orgProperty", length = 100)
	public String getOrgProperty() {
		return this.orgProperty;
	}

	public void setOrgProperty(String orgProperty) {
		this.orgProperty = orgProperty;
	}

	@Column(name = "isListed", length = 2)
	public String getIsListed() {
		return this.isListed;
	}

	public void setIsListed(String isListed) {
		this.isListed = isListed;
	}

	@Column(name = "isHighNew", length = 2)
	public String getIsHighNew() {
		return this.isHighNew;
	}

	public void setIsHighNew(String isHighNew) {
		this.isHighNew = isHighNew;
	}

	@Column(name = "master", length = 100)
	public String getMaster() {
		return this.master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	@Column(name = "orgBrief", length = 1000)
	public String getOrgBrief() {
		return this.orgBrief;
	}

	public void setOrgBrief(String orgBrief) {
		this.orgBrief = orgBrief;
	}

	@Column(name = "licensePDF", length = 100)
	public String getLicensePdf() {
		return this.licensePdf;
	}

	public void setLicensePdf(String licensePdf) {
		this.licensePdf = licensePdf;
	}

	@Column(name = "promisePDF", length = 100)
	public String getPromisePdf() {
		return this.promisePdf;
	}

	public void setPromisePdf(String promisePdf) {
		this.promisePdf = promisePdf;
	}

	@Column(name = "linkPerson", length = 100)
	public String getLinkPerson() {
		return this.linkPerson;
	}

	public void setLinkPerson(String linkPerson) {
		this.linkPerson = linkPerson;
	}

	@Column(name = "department", length = 100)
	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "numberId", length = 100)
	public String getNumberId() {
		return this.numberId;
	}

	public void setNumberId(String numberId) {
		this.numberId = numberId;
	}

	@Column(name = "province", length = 10)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "city", length = 10)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "area", length = 10)
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	@Column(name = "address", length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	@Column(name = "remark", length = 500)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	@Column(name = "isNTBListed", length = 2)
	public String getIsNtblisted() {
		return this.isNtblisted;
	}

	public void setIsNtblisted(String isNtblisted) {
		this.isNtblisted = isNtblisted;
	}

	@Column(name = "isWEPermited", length = 2)
	public String getIsWepermited() {
		return this.isWepermited;
	}

	public void setIsWepermited(String isWepermited) {
		this.isWepermited = isWepermited;
	}

	@Column(name = "isWEQKept", length = 2)
	public String getIsWeqkept() {
		return this.isWeqkept;
	}

	public void setIsWeqkept(String isWeqkept) {
		this.isWeqkept = isWeqkept;
	}

	@Column(name = "masterType", length = 100)
	public String getMasterType() {
		return this.masterType;
	}

	public void setMasterType(String masterType) {
		this.masterType = masterType;
	}

	@Column(name = "creditId", length = 100)
	public String getCreditId() {
		return creditId;
	}

	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}

	@Column(name = "departId")
	public Integer getDepartId() {
		return departId;
	}

	public void setDepartId(Integer departId) {
		this.departId = departId;
	}
	
	@Column(name = "loginDate", length = 19)
	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	@Override
	public String toString() {
		return "TrmMember [id=" + id + ", unitId=" + unitId + ", masterId=" + masterId + ", username=" + username
				+ ", password=" + password + ", nickName=" + nickName + ", phone=" + phone + ", email=" + email
				+ ", qq=" + qq + ", weChat=" + weChat + ", headPortrait=" + headPortrait + ", problem=" + problem
				+ ", answer=" + answer + ", userType=" + userType + ", orgName=" + orgName + ", orgProperty="
				+ orgProperty + ", isListed=" + isListed + ", isHighNew=" + isHighNew + ", master=" + master
				+ ", orgBrief=" + orgBrief + ", licensePdf=" + licensePdf + ", promisePdf=" + promisePdf
				+ ", linkPerson=" + linkPerson + ", department=" + department + ", numberId=" + numberId + ", province="
				+ province + ", city=" + city + ", area=" + area + ", address=" + address + ", audStatus=" + audStatus
				+ ", audDate=" + audDate + ", audOpinion=" + audOpinion + ", audPerson=" + audPerson + ", remark="
				+ remark + ", isActive=" + isActive + ", creator=" + creator + ", createTime=" + createTime
				+ ", updater=" + updater + ", updateTime=" + updateTime + ", isNtblisted=" + isNtblisted
				+ ", isWepermited=" + isWepermited + ", isWeqkept=" + isWeqkept + ", masterType=" + masterType
				+ ", creditId=" + creditId + ", departId=" + departId + ", loginDate=" + loginDate + "]";
	}

}