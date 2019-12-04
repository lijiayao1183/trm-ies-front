package com.trm.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 军民融合需求（包括技术需求、产品需求、融资需求）
 * add by zhaosimiao at 2019-3-13 11:21:09
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "trm_demand")
@Where(clause = "isActive='Y'")//获取是激活状态的
public class TrmDemand implements java.io.Serializable {
    
    private Integer id;
    /**
     * 所属单位id
     */
    private Integer orgId;
    /**
     * 所属用户
     */
    private Integer memberId;
    /**
     * 来源
     */
    private String source;
    /**
     * 需求名称
     */
    private String name;
    /**
     * 编号
     */
    private String code;
    /**
     * 类别
     */
    private String type;
    /**
     * 关键字
     */
    private String keyword;
    /**
     * 应用领域
     */
    private String domain;
    /**
     * 单位名称
     */
    private String companyName;
    /**
     * 单位地址
     */
    private String companyAddr;
    /**
     * 联系人
     */
    private String contacts;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 有效日期
     */
    private Date endDate;
    /**
     * 需求描述
     */
    private String content;
    /**
     * 备注
     */
    private String remark;
    /**
     * 审核状态
     */
    private String audStatus;
    /**
     * 审核时间
     */
    private Date audDate;
    /**
     * 审核意见
     */
    private String audOpinion;
    /**
     * 审核人
     */
    private String audPerson;
    /**
     * 浏览量
     */
    private Integer viewCount;
    private String isActive;
    private String creator;
    private Date createTime;
    private String updater;
    private Date updateTime;
    
    /** default constructor */
    public TrmDemand() {
    }
    
    /** minimal constructor */
    public TrmDemand(Integer orgId, Integer memberId, String name, String code, Integer viewCount, String isActive,
            String creator, Date createTime) {
        this.orgId = orgId;
        this.memberId = memberId;
        this.name = name;
        this.code = code;
        this.viewCount = viewCount;
        this.isActive = isActive;
        this.creator = creator;
        this.createTime = createTime;
    }
    
    /** full constructor */
    public TrmDemand(Integer orgId, Integer memberId, String source, String name, String code, String type,
            String keyword, String domain, String companyName, String companyAddr, String contacts, String phone,
            Date endDate, String content, String remark, String audStatus, Date audDate, String audOpinion,
            String audPerson, Integer viewCount, String isActive, String creator, Date createTime, String updater,
            Date updateTime) {
        this.orgId = orgId;
        this.memberId = memberId;
        this.source = source;
        this.name = name;
        this.code = code;
        this.type = type;
        this.keyword = keyword;
        this.domain = domain;
        this.companyName = companyName;
        this.companyAddr = companyAddr;
        this.contacts = contacts;
        this.phone = phone;
        this.endDate = endDate;
        this.content = content;
        this.remark = remark;
        this.audStatus = audStatus;
        this.audDate = audDate;
        this.audOpinion = audOpinion;
        this.audPerson = audPerson;
        this.viewCount = viewCount;
        this.isActive = isActive;
        this.creator = creator;
        this.createTime = createTime;
        this.updater = updater;
        this.updateTime = updateTime;
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
    
    @Column(name = "orgId", nullable = false)
    public Integer getOrgId() {
        return this.orgId;
    }
    
    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }
    
    /** @return the memberId */
    @Column(name = "memberId", nullable = false)
    public Integer getMemberId() {
        return memberId;
    }
    
    /** @param memberId the memberId to set */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
    
    @Column(name = "source")
    public String getSource() {
        return this.source;
    }
    
    public void setSource(String source) {
        this.source = source;
    }
    
    @Column(name = "name", nullable = false)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name = "code", nullable = false)
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    @Column(name = "type", length = 20)
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    @Column(name = "keyword", length = 100)
    public String getKeyword() {
        return this.keyword;
    }
    
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    @Column(name = "domain", length = 100)
    public String getDomain() {
        return this.domain;
    }
    
    public void setDomain(String domain) {
        this.domain = domain;
    }
    
    @Column(name = "companyName", length = 100)
    public String getCompanyName() {
        return this.companyName;
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    @Column(name = "companyAddr", length = 100)
    public String getCompanyAddr() {
        return this.companyAddr;
    }
    
    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr;
    }
    
    @Column(name = "contacts", length = 50)
    public String getContacts() {
        return this.contacts;
    }
    
    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
    
    @Column(name = "phone", length = 50)
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Column(name = "endDate", length = 19)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    @Column(name = "content", length = 65535)
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    @Column(name = "remark", length = 100)
    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    @Column(name = "audStatus", length = 2)
    public String getAudStatus() {
        return this.audStatus;
    }
    
    public void setAudStatus(String audStatus) {
        this.audStatus = audStatus;
    }
    
    @Column(name = "audDate", length = 19)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
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
    
    @Column(name = "viewCount")
    public Integer getViewCount() {
        return viewCount;
    }
    
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }
    
    @Column(name = "isActive", nullable = false, length = 1)
    public String getIsActive() {
        return this.isActive;
    }
    
    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }
    
    @Column(name = "creator", nullable = false, length = 100)
    public String getCreator() {
        return this.creator;
    }
    
    public void setCreator(String creator) {
        this.creator = creator;
    }
    
    @Column(name = "createTime", nullable = false, length = 19)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getUpdateTime() {
        return this.updateTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	@Override
	public String toString() {
		return "TrmDemand [id=" + id + ", orgId=" + orgId + ", memberId=" + memberId + ", source=" + source + ", name="
				+ name + ", code=" + code + ", type=" + type + ", keyword=" + keyword + ", domain=" + domain
				+ ", companyName=" + companyName + ", companyAddr=" + companyAddr + ", contacts=" + contacts
				+ ", phone=" + phone + ", endDate=" + endDate + ", content=" + content + ", remark=" + remark
				+ ", audStatus=" + audStatus + ", audDate=" + audDate + ", audOpinion=" + audOpinion + ", audPerson="
				+ audPerson + ", viewCount=" + viewCount + ", isActive=" + isActive + ", creator=" + creator
				+ ", createTime=" + createTime + ", updater=" + updater + ", updateTime=" + updateTime + "]";
	}
    
}