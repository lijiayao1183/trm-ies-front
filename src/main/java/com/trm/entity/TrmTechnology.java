package com.trm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * TrmTechnology entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "trm_technology")
@Where(clause = "isActive='Y'")//获取是激活状态的
public class TrmTechnology implements java.io.Serializable {
    
    // Fields
    
    private Integer id;
    @JsonIgnore
    private Integer demandId;
    private String techName;
    private String techContent;
    private String techPhone;
    @JsonIgnore
    private String isActive;
    @JsonIgnore
    private String creator;
    @JsonIgnore
    private Date createTime;
    @JsonIgnore
    private String updater;
    @JsonIgnore
    private Date updateTime;
    
    // Constructors
    
    /** default constructor */
    public TrmTechnology() {
    }
    
    /** minimal constructor */
    public TrmTechnology(Integer demandId, String techName, String techContent, String techPhone, String isActive,
            String creator, Date createTime) {
        this.demandId = demandId;
        this.techName = techName;
        this.techContent = techContent;
        this.techPhone = techPhone;
        this.isActive = isActive;
        this.creator = creator;
        this.createTime = createTime;
    }
    
    /** full constructor */
    public TrmTechnology(Integer demandId, String techName, String techContent, String techPhone, String isActive,
            String creator, Date createTime, String updater, Date updateTime) {
        this.demandId = demandId;
        this.techName = techName;
        this.techContent = techContent;
        this.techPhone = techPhone;
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
    
    @Column(name = "demandId", nullable = false)
    public Integer getDemandId() {
        return this.demandId;
    }
    
    public void setDemandId(Integer demandId) {
        this.demandId = demandId;
    }
    
    @Column(name = "techName", nullable = false)
    public String getTechName() {
        return this.techName;
    }
    
    public void setTechName(String techName) {
        this.techName = techName;
    }
    
    @Column(name = "techContent", nullable = false, length = 65535)
    public String getTechContent() {
        return this.techContent;
    }
    
    public void setTechContent(String techContent) {
        this.techContent = techContent;
    }
    
    @Column(name = "techPhone", nullable = false)
    public String getTechPhone() {
        return this.techPhone;
    }
    
    public void setTechPhone(String techPhone) {
        this.techPhone = techPhone;
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
    
}