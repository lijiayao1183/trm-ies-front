package com.trm.model.techservorg;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TechServOrgDetail {
	
	private Integer id;
	private String orgName;
	private String servType;
	private String address;
	private String postcode;
	private String property;
	private String attribute;
	private String header;
	private String headerPhone;
	private String headerMobile;
	private String headerEmail;
	private String linker;
	private String linkerPhone;
	private String linkerMobile;
	private String linkerEmail;
	private String brief;
	private String team;
	private String mgtLevel;
	private String honor;
	private String servCase;
	private String projectCase;
	private String audStatus;
	private Date audDate;
	private String audOpinion;
	private String audPerson;
	private Integer userId;
	
	/**
	 * 发布时间
	 */
	private Date createTime;
	
	/**
	 * 信息来源（发布单位）
	 */
	private String unitName;
	
	/**
	 * 技术服务机构各类随附材料列表  add by zhaosimiao 2018-6-5 15:16:30
	 */
	private List<OrgOneKindMaterial> fileList;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getServType() {
		return servType;
	}
	public void setServType(String servType) {
		this.servType = servType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getHeaderPhone() {
		return headerPhone;
	}
	public void setHeaderPhone(String headerPhone) {
		this.headerPhone = headerPhone;
	}
	public String getHeaderMobile() {
		return headerMobile;
	}
	public void setHeaderMobile(String headerMobile) {
		this.headerMobile = headerMobile;
	}
	public String getHeaderEmail() {
		return headerEmail;
	}
	public void setHeaderEmail(String headerEmail) {
		this.headerEmail = headerEmail;
	}
	public String getLinker() {
		return linker;
	}
	public void setLinker(String linker) {
		this.linker = linker;
	}
	public String getLinkerPhone() {
		return linkerPhone;
	}
	public void setLinkerPhone(String linkerPhone) {
		this.linkerPhone = linkerPhone;
	}
	public String getLinkerMobile() {
		return linkerMobile;
	}
	public void setLinkerMobile(String linkerMobile) {
		this.linkerMobile = linkerMobile;
	}
	public String getLinkerEmail() {
		return linkerEmail;
	}
	public void setLinkerEmail(String linkerEmail) {
		this.linkerEmail = linkerEmail;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getMgtLevel() {
		return mgtLevel;
	}
	public void setMgtLevel(String mgtLevel) {
		this.mgtLevel = mgtLevel;
	}
	public String getHonor() {
		return honor;
	}
	public void setHonor(String honor) {
		this.honor = honor;
	}
	public String getServCase() {
		return servCase;
	}
	public void setServCase(String servCase) {
		this.servCase = servCase;
	}
	public String getProjectCase() {
		return projectCase;
	}
	public void setProjectCase(String projectCase) {
		this.projectCase = projectCase;
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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	public List<OrgOneKindMaterial> getFileList() {
		return fileList;
	}
	public void setFileList(List<OrgOneKindMaterial> fileList) {
		this.fileList = fileList;
	}
	@Override
	public String toString() {
		
		String printFileList = "";
		if(fileList != null) {
			for(OrgOneKindMaterial oom : fileList) {
					printFileList += oom.toString();
			}
		}
		
		return "TechServOrgDetail [id=" + id + ", orgName=" + orgName + ", servType=" + servType + ", address="
				+ address + ", postcode=" + postcode + ", property=" + property + ", attribute=" + attribute
				+ ", header=" + header + ", headerPhone=" + headerPhone + ", headerMobile=" + headerMobile
				+ ", headerEmail=" + headerEmail + ", linker=" + linker + ", linkerPhone=" + linkerPhone
				+ ", linkerMobile=" + linkerMobile + ", linkerEmail=" + linkerEmail + ", brief=" + brief + ", team="
				+ team + ", mgtLevel=" + mgtLevel + ", honor=" + honor + ", servCase=" + servCase + ", projectCase="
				+ projectCase + ", audStatus=" + audStatus + ", audDate=" + audDate + ", audOpinion=" + audOpinion
				+ ", audPerson=" + audPerson + ", userId=" + userId + ", createTime=" + createTime + ", unitName="
				+ unitName + ", fileList=" + printFileList +"]";
	}
    
}
