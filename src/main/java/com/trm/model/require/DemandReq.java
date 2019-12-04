/**
 * @Title: DemandReq.java
 * @Package: com.trm.model.require
 * @Description: TODO(用一句话描述该文件做什么)
 * @Copyright: Copyright (c)
 * @Company: Digital Telemedia Co.,Ltd
 * @author LiuJC
 * @date 2018年02月26 上午10:56
 * @version V1.0
 * @Revision 2018年02月26 上午10:56
 */

package com.trm.model.require;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName DemandReq
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author LiuJC
 * @Date 2018年02月26 上午10:56
 * @version 1.0.0
 */
public class DemandReq {
    private Integer id;
    @NotBlank(message = "需求名称不能为空")
    private String name;
    private String source;
    @NotBlank(message = "需求类别不能为空")
    private String type;
    private String keyword;
    private String domain;
    private String companyName;
    private String companyAddr;
    private String contacts;
    private String phone;
    private Date endDate;
    @NotBlank(message = "需求描述不能为空")
    private String content;
    private String remark;
    @NotBlank(message = "状态不能为空")
    @Pattern(regexp = "(^F0$|^F1$|^A2$)", message = "请填写正确的状态")
    private String audStatus;
    private List<RelevantTechReq> list = new ArrayList<>();
    
    public DemandReq() {
    }
    
    /** @return the id */
    public Integer getId() {
        return id;
    }
    
    /** @param id the id to set */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /** @return the name */
    public String getName() {
        return name;
    }
    
    /** @param name the name to set */
    public void setName(String name) {
        this.name = name;
    }
    
    /** @return the source */
    public String getSource() {
        return source;
    }
    
    /** @param source the source to set */
    public void setSource(String source) {
        this.source = source;
    }
    
    /** @return the type */
    public String getType() {
        return type;
    }
    
    /** @param type the type to set */
    public void setType(String type) {
        this.type = type;
    }
    
    /** @return the keyword */
    public String getKeyword() {
        return keyword;
    }
    
    /** @param keyword the keyword to set */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    /** @return the domain */
    public String getDomain() {
        return domain;
    }
    
    /** @param domain the domain to set */
    public void setDomain(String domain) {
        this.domain = domain;
    }
    
    /** @return the companyName */
    public String getCompanyName() {
        return companyName;
    }
    
    /** @param companyName the companyName to set */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    /** @return the companyAddr */
    public String getCompanyAddr() {
        return companyAddr;
    }
    
    /** @param companyAddr the companyAddr to set */
    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr;
    }
    
    /** @return the contacts */
    public String getContacts() {
        return contacts;
    }
    
    /** @param contacts the contacts to set */
    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
    
    /** @return the phone */
    public String getPhone() {
        return phone;
    }
    
    /** @param phone the phone to set */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    /** @return the endDate */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getEndDate() {
        return endDate;
    }
    
    /** @param endDate the endDate to set */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    /** @return the content */
    public String getContent() {
        return content;
    }
    
    /** @param content the content to set */
    public void setContent(String content) {
        this.content = content;
    }
    
    /** @return the remark */
    public String getRemark() {
        return remark;
    }
    
    /** @param remark the remark to set */
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    /** @return the list */
    public List<RelevantTechReq> getList() {
        return list;
    }
    
    /** @param list the list to set */
    public void setList(List<RelevantTechReq> list) {
        this.list = list;
    }
    
    /** @return the audStatus */
    public String getAudStatus() {
        return audStatus;
    }
    
    /** @param audStatus the audStatus to set */
    public void setAudStatus(String audStatus) {
        this.audStatus = audStatus;
    }
}
