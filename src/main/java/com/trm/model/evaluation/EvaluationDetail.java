package com.trm.model.evaluation;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class EvaluationDetail {

    @NotNull(message = "设备id不能为空")
    private Integer eqpId;//设备ID
    private Integer regId;//用户ID
    private String evaluation;//评论内容
    private Date publishDate;//评论时间
    private String audStatus;//审核状态
    
    public Integer getEqpId() {
        return eqpId;
    }
    public void setEqpId(Integer eqpId) {
        this.eqpId = eqpId;
    }
    public Integer getRegId() {
        return regId;
    }
    public void setRegId(Integer regId) {
        this.regId = regId;
    }
    public String getEvaluation() {
        return evaluation;
    }
    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }
    public Date getPublishDate() {
        return publishDate;
    }
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
    public String getAudStatus() {
        return audStatus;
    }
    public void setAudStatus(String audStatus) {
        this.audStatus = audStatus;
    }
    @Override
    public String toString() {
        return "EvaluationDetail [eqpId=" + eqpId + ", regId=" + regId + ", evaluation=" + evaluation + ", publishDate=" + publishDate
                + ", audStatus=" + audStatus + "]";
    }
	
}
