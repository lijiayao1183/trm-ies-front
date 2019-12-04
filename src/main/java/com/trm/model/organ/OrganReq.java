package com.trm.model.organ;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trm.model.common.CommonRequest;

public class OrganReq extends CommonRequest {

    private String orgName;//机构名称
    private String orgProperty;//机构性质
    private Date addStartTime;//新增开始时间
    private Date addEndTime;//新增结束时间

    public OrganReq() {
        super();
    }

    public OrganReq(String orgName, String orgProperty, Date addStartTime, Date addEndTime) {
        super();
        this.orgName = orgName;
        this.orgProperty = orgProperty;
        this.addStartTime = addStartTime;
        this.addEndTime = addEndTime;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getAddStartTime() {
        return addStartTime;
    }

    public void setAddStartTime(Date addStartTime) {
        this.addStartTime = addStartTime;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getAddEndTime() {
        return addEndTime;
    }

    public void setAddEndTime(Date addEndTime) {
        this.addEndTime = addEndTime;
    }

    @Override
    public String toString() {
        return "OrganReq [orgName=" + orgName + ", orgProperty=" + orgProperty + ", addStartTime=" + addStartTime + ", addEndTime=" + addEndTime
                + "]";
    }

}
