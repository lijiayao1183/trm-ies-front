package com.trm.model.laboratory;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trm.model.common.CommonRequest;

public class LaboratoryReq extends CommonRequest {


    private String labName;//技术服务机构名称
    private String unitName;//单位名称
    private Date createStartTime;//新增开始时间
    private Date createEndTime;//新增结束时间
    public String getLabName() {
        return labName;
    }
    public void setLabName(String labName) {
        this.labName = labName;
    }
    public String getUnitName() {
        return unitName;
    }
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateStartTime() {
        return createStartTime;
    }
    public void setCreateStartTime(Date createStartTime) {
        this.createStartTime = createStartTime;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateEndTime() {
        return createEndTime;
    }
    public void setCreateEndTime(Date createEndTime) {
        this.createEndTime = createEndTime;
    }
    @Override
    public String toString() {
        return "LaboratoryReq [labName=" + labName + ", unitName=" + unitName + ", createStartTime=" + createStartTime + ", createEndTime="
                + createEndTime + "]";
    }
    
}
