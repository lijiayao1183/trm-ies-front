/**
 * @Title: DemandListResp.java
 * @Package: com.trm.model.require
 * @Description: TODO(用一句话描述该文件做什么)
 * @Copyright: Copyright (c)
 * @Company: Digital Telemedia Co.,Ltd
 * @author LiuJC
 * @date 2018年02月26 上午13:47
 * @version V1.0
 * @Revision 2018年02月26 上午13:47
 */

package com.trm.model.require;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @ClassName DemandListResp
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author LiuJC
 * @Date 2018年02月26 上午13:47
 * @version 1.0.0
 */
public class DemandListResp {
    private Integer id;             //id
    private String code;            //编码
    private String name;            //需求名称
    private String type;            //需求类别
    private String department;      //所属部门
    private Date audDate;           //审核日期
    private String audStatus;       //状态
    private String auser;           //用户
    private String memberType;      //用户类型
    
    public DemandListResp() {
    }
    
    public DemandListResp(Integer id, String code, String name, String type, String department, Date audDate,
            String audStatus, String auser) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
        this.department = department;
        this.audDate = audDate;
        this.audStatus = audStatus;
        this.auser = auser;
    }
    
    public DemandListResp(Integer id, String code, String name, String type, String department, Date audDate,
            String audStatus, String auser, String memberType) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
        this.department = department;
        this.audDate = audDate;
        this.audStatus = audStatus;
        this.auser = auser;
        this.memberType = memberType;
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
    
    /** @return the type */
    public String getType() {
        return type;
    }
    
    /** @param type the type to set */
    public void setType(String type) {
        this.type = type;
    }
    
    /** @return the department */
    public String getDepartment() {
        return department;
    }
    
    /** @param department the department to set */
    public void setDepartment(String department) {
        this.department = department;
    }
    
    /** @return the audDate */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getAudDate() {
        return audDate;
    }
    
    /** @param audDate the audDate to set */
    public void setAudDate(Date audDate) {
        this.audDate = audDate;
    }
    
    /** @return the audStatus */
    public String getAudStatus() {
        return audStatus;
    }
    
    /** @param audStatus the audStatus to set */
    public void setAudStatus(String audStatus) {
        this.audStatus = audStatus;
    }
    
    /** @return the auser */
    public String getAuser() {
        return auser;
    }
    
    /** @param auser the auser to set */
    public void setAuser(String auser) {
        this.auser = auser;
    }
    
    /** @return the code */
    public String getCode() {
        return code;
    }
    
    /** @param code the code to set */
    public void setCode(String code) {
        this.code = code;
    }
    
    /** @return the memberType */
    public String getMemberType() {
        return memberType;
    }
    
    /** @param memberType the memberType to set */
    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }
    
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DemandListResp{");
        sb.append("audDate=").append(audDate);
        sb.append(", audStatus='").append(audStatus).append('\'');
        sb.append(", auser='").append(auser).append('\'');
        sb.append(", code='").append(code).append('\'');
        sb.append(", department='").append(department).append('\'');
        sb.append(", id=").append(id);
        sb.append(", memberType='").append(memberType).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
