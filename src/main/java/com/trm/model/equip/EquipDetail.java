package com.trm.model.equip;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trm.model.member.EquipMember;

import java.util.Date;

public class EquipDetail {
    
    private Integer id;
    private Integer orgId;
    private EquipMember memberDetail;
    private String equipName;
    private String keyWords;
    private String equipVerCode;
    private String equipPic1;
    private String equipPic2;
    private String equipPic3;
    private String equipType;
    private String serviceRange;
    private String equipValue;
    private String createFirm;
    private String proCountry;
    private String brand;
    private Date validDate;
    private Date purchaseDate;
    private String serviceMode;
    private String advancedLevel;
    private String isPublished;
    private String publisher;
    private Date publishTime;
    private String qualification;
    private String useField;
    private String tecFeature;
    private String linkUnit;
    private String linkUnitTel;
    private String linkUnitFax;
    private String linkPerson;
    private String linkPhone;
    private String email;
    private String audStatus;
    private Date audDate;
    private Date applyDate;
    private String audOpinion;
    private String audPerson;
    private String remark;
    private Integer viewCount;
    private Integer searchCount;
    private Integer attentCount;
    private Integer evaluateCount;
    private String isDisplay;
    private Date displayDate;
    private String reason;
    private String usedStatus;
    private String linkAddress;
    
    public EquipMember getMemberDetail() {
        return memberDetail;
    }
    
    public void setMemberDetail(EquipMember memberDetail) {
        this.memberDetail = memberDetail;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getOrgId() {
        return orgId;
    }
    
    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }
    
    public String getEquipName() {
        return equipName;
    }
    
    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }
    
    public String getKeyWords() {
        return keyWords;
    }
    
    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
    
    public String getEquipVerCode() {
        return equipVerCode;
    }
    
    public void setEquipVerCode(String equipVerCode) {
        this.equipVerCode = equipVerCode;
    }
    
    public String getEquipPic1() {
        return equipPic1;
    }
    
    public void setEquipPic1(String equipPic1) {
        this.equipPic1 = equipPic1;
    }
    
    public String getEquipPic2() {
        return equipPic2;
    }
    
    public void setEquipPic2(String equipPic2) {
        this.equipPic2 = equipPic2;
    }
    
    public String getEquipPic3() {
        return equipPic3;
    }
    
    public void setEquipPic3(String equipPic3) {
        this.equipPic3 = equipPic3;
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
    
    public String getEquipValue() {
        return equipValue;
    }
    
    public void setEquipValue(String equipValue) {
        this.equipValue = equipValue;
    }
    
    public String getCreateFirm() {
        return createFirm;
    }
    
    public void setCreateFirm(String createFirm) {
        this.createFirm = createFirm;
    }
    
    public String getProCountry() {
        return proCountry;
    }
    
    public void setProCountry(String proCountry) {
        this.proCountry = proCountry;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getValidDate() {
        return validDate;
    }
    
    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }
    
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getPurchaseDate() {
        return purchaseDate;
    }
    
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    
    public String getServiceMode() {
        return serviceMode;
    }
    
    public void setServiceMode(String serviceMode) {
        this.serviceMode = serviceMode;
    }
    
    public String getAdvancedLevel() {
        return advancedLevel;
    }
    
    public void setAdvancedLevel(String advancedLevel) {
        this.advancedLevel = advancedLevel;
    }
    
    public String getIsPublished() {
        return isPublished;
    }
    
    public void setIsPublished(String isPublished) {
        this.isPublished = isPublished;
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getPublishTime() {
        return publishTime;
    }
    
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
    
    public String getQualification() {
        return qualification;
    }
    
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    
    public String getUseField() {
        return useField;
    }
    
    public void setUseField(String useField) {
        this.useField = useField;
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
    
    public String getLinkUnitTel() {
        return linkUnitTel;
    }
    
    public void setLinkUnitTel(String linkUnitTel) {
        this.linkUnitTel = linkUnitTel;
    }
    
    public String getLinkUnitFax() {
        return linkUnitFax;
    }
    
    public void setLinkUnitFax(String linkUnitFax) {
        this.linkUnitFax = linkUnitFax;
    }
    
    public String getLinkPerson() {
        return linkPerson;
    }
    
    public void setLinkPerson(String linkPerson) {
        this.linkPerson = linkPerson;
    }
    
    public String getLinkPhone() {
        return linkPhone;
    }
    
    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getAudStatus() {
        return audStatus;
    }
    
    public void setAudStatus(String audStatus) {
        this.audStatus = audStatus;
    }
    
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getAudDate() {
        return audDate;
    }
    
    public void setAudDate(Date audDate) {
        this.audDate = audDate;
    }
    
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getApplyDate() {
        return applyDate;
    }
    
    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
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
    
    public Integer getViewCount() {
        return viewCount;
    }
    
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }
    
    public Integer getSearchCount() {
        return searchCount;
    }
    
    public void setSearchCount(Integer searchCount) {
        this.searchCount = searchCount;
    }
    
    public Integer getAttentCount() {
        return attentCount;
    }
    
    public void setAttentCount(Integer attentCount) {
        this.attentCount = attentCount;
    }
    
    public Integer getEvaluateCount() {
        return evaluateCount;
    }
    
    public void setEvaluateCount(Integer evaluateCount) {
        this.evaluateCount = evaluateCount;
    }
    
    public String getIsDisplay() {
        return isDisplay;
    }
    
    public void setIsDisplay(String isDisplay) {
        this.isDisplay = isDisplay;
    }
    
    public String getReason() {
        return reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }
    
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getDisplayDate() {
        return displayDate;
    }
    
    public void setDisplayDate(Date displayDate) {
        this.displayDate = displayDate;
    }
    
    public String getUsedStatus() {
        return usedStatus;
    }
    
    public void setUsedStatus(String usedStatus) {
        this.usedStatus = usedStatus;
    }
    
    public String getLinkAddress() {
        return linkAddress;
    }
    
    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress;
    }
    
    @Override
    public String toString() {
        return "EquipDetail [id=" + id + ", orgId=" + orgId + ", memberDetail=" + memberDetail + ", equipName="
                + equipName + ", keyWords=" + keyWords + ", equipVerCode=" + equipVerCode + ", equipPic1=" + equipPic1
                + ", equipPic2=" + equipPic2 + ", equipPic3=" + equipPic3 + ", equipType=" + equipType
                + ", serviceRange=" + serviceRange + ", equipValue=" + equipValue + ", createFirm=" + createFirm
                + ", proCountry=" + proCountry + ", brand=" + brand + ", validDate=" + validDate + ", purchaseDate="
                + purchaseDate + ", serviceMode=" + serviceMode + ", advancedLevel=" + advancedLevel + ", isPublished="
                + isPublished + ", publisher=" + publisher + ", publishTime=" + publishTime + ", qualification="
                + qualification + ", useField=" + useField + ", tecFeature=" + tecFeature + ", linkUnit=" + linkUnit
                + ", linkUnitTel=" + linkUnitTel + ", linkUnitFax=" + linkUnitFax + ", linkPerson=" + linkPerson
                + ", linkPhone=" + linkPhone + ", email=" + email + ", audStatus=" + audStatus + ", audDate=" + audDate
                + ", applyDate=" + applyDate + ", audOpinion=" + audOpinion + ", audPerson=" + audPerson + ", remark="
                + remark + ", viewCount=" + viewCount + ", searchCount=" + searchCount + ", attentCount=" + attentCount
                + ", evaluateCount=" + evaluateCount + ", isDisplay=" + isDisplay + ", displayDate=" + displayDate
                + ", reason=" + reason + ", usedStatus=" + usedStatus + ", linkAddress=" + linkAddress + "]";
    }
    
}
