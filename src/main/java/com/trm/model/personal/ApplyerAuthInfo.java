package com.trm.model.personal;

/**
 * 
 * @author zhaosimiao 申请人信息（调用外部的回显项）
 *
 */
public class ApplyerAuthInfo {

    private String applyer;
    private String applyerType;
    private String creditId;

    public String getApplyer() {
        return applyer;
    }

    public void setApplyer(String applyer) {
        this.applyer = applyer;
    }

    public String getApplyerType() {
        return applyerType;
    }

    public void setApplyerType(String applyerType) {
        this.applyerType = applyerType;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    @Override
    public String toString() {
        return "ApplyerAuthInfo [applyer=" + applyer + ", applyerType=" + applyerType + ", creditId=" + creditId + "]";
    }

}
