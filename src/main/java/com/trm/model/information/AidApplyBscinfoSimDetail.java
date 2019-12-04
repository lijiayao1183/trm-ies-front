package com.trm.model.information;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AidApplyBscinfoSimDetail {
    private Integer id;
    private String applyer;
    private String creditId;
    private Date reviewDate;
    private String applyerType;
    private String enName;

    public AidApplyBscinfoSimDetail() {
        super();
    }

    public AidApplyBscinfoSimDetail(Integer id, String applyer, String creditId, Date reviewDate, String applyerType) {
        this.id = id;
        this.applyer = applyer;
        this.creditId = creditId;
        this.reviewDate = reviewDate;
        this.applyerType = applyerType;
    }

    public AidApplyBscinfoSimDetail(Integer id, String applyer, String creditId, Date reviewDate, String applyerType,
            String enName) {
        super();
        this.id = id;
        this.applyer = applyer;
        this.creditId = creditId;
        this.reviewDate = reviewDate;
        this.applyerType = applyerType;
        this.enName = enName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplyer() {
        return applyer;
    }

    public void setApplyer(String applyer) {
        this.applyer = applyer;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getApplyerType() {
        return applyerType;
    }

    public void setApplyerType(String applyerType) {
        this.applyerType = applyerType;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    @Override
    public String toString() {
        return "AidApplyBscinfoSimDetail [id=" + id + ", applyer=" + applyer + ", creditId=" + creditId
                + ", reviewDate=" + reviewDate + ", applyerType=" + applyerType + ", enName=" + enName + "]";
    }

}
