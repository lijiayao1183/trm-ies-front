package com.trm.util.batch;

public class BatchEquipFileResponse {

private Integer id;
    
    /**
     * 设备设施名称
     */
    private String equipName;
    
    /**
     * 设备设施类别
     */
    private String equipType;
    
    /**
     * 服务领域
     */
    private String serviceRange;
    
    /**
     * 规格型号
     */
    private String equipVerCode;
    
    /**
     * 生产国别
     */
    private String proCountry;
    
    /**
     * 制造厂商
     */
    private String createFirm;
    
    /**
     * 服务方式
     */
    private String serviceMode;
    
    /**
     * 服务费用
     */
    private String equipValue;
    
    /**
     * 购置日期
     */
    private String purchaseDate;
    
    /**
     * 联系人
     */
    private String linkPerson;
    
    /**
     * 电子邮件
     */
    private String email;
    
    /**
     * 联系方式
     */
    private String linkPhone;

    /**
     * 功能应用范围
     */
    private String useField;
    
    /**
     * 主要技术指标
     */
    private String qualification;
    
    /**
     * 技术特色
     */
    private String tecFeature;
    
    /**
     * 持有单位
     */
    private String linkUnit;
    
    /**
     * 单位地址
     */
    private String linkAddress;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEquipName() {
		return equipName;
	}

	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}

	public String getEquipType() {
		return equipType;
	}

	public void setEquipType(String equipType) {
		this.equipType = equipType;
	}

	public String getServiceRange() {
		return serviceRange;
	}

	public void setServiceRange(String serviceRange) {
		this.serviceRange = serviceRange;
	}

	public String getEquipVerCode() {
		return equipVerCode;
	}

	public void setEquipVerCode(String equipVerCode) {
		this.equipVerCode = equipVerCode;
	}

	public String getProCountry() {
		return proCountry;
	}

	public void setProCountry(String proCountry) {
		this.proCountry = proCountry;
	}

	public String getCreateFirm() {
		return createFirm;
	}

	public void setCreateFirm(String createFirm) {
		this.createFirm = createFirm;
	}

	public String getServiceMode() {
		return serviceMode;
	}

	public void setServiceMode(String serviceMode) {
		this.serviceMode = serviceMode;
	}

	public String getEquipValue() {
		return equipValue;
	}

	public void setEquipValue(String equipValue) {
		this.equipValue = equipValue;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getLinkPerson() {
		return linkPerson;
	}

	public void setLinkPerson(String linkPerson) {
		this.linkPerson = linkPerson;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLinkPhone() {
		return linkPhone;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}

	public String getUseField() {
		return useField;
	}

	public void setUseField(String useField) {
		this.useField = useField;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getTecFeature() {
		return tecFeature;
	}

	public void setTecFeature(String tecFeature) {
		this.tecFeature = tecFeature;
	}

	public String getLinkUnit() {
		return linkUnit;
	}

	public void setLinkUnit(String linkUnit) {
		this.linkUnit = linkUnit;
	}

	public String getLinkAddress() {
		return linkAddress;
	}

	public void setLinkAddress(String linkAddress) {
		this.linkAddress = linkAddress;
	}

	@Override
	public String toString() {
		return "BatchEquipFileResponse [id=" + id + ", equipName=" + equipName + ", equipType=" + equipType
				+ ", serviceRange=" + serviceRange + ", equipVerCode=" + equipVerCode + ", proCountry=" + proCountry
				+ ", createFirm=" + createFirm + ", serviceMode=" + serviceMode + ", equipValue=" + equipValue
				+ ", purchaseDate=" + purchaseDate + ", linkPerson=" + linkPerson + ", email=" + email + ", linkPhone="
				+ linkPhone + ", useField=" + useField + ", qualification=" + qualification + ", tecFeature="
				+ tecFeature + ", linkUnit=" + linkUnit + ", linkAddress=" + linkAddress + "]";
	}

}
