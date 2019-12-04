package com.trm.model.member;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class AuditMemberReq {

    @NotNull(message = "用户ID不能为空")
    private Integer id;
    /* 审核状态*/
    @NotEmpty(message = "审核状态不能为空")
    private String audStatus;//审核状态
    /* 审核意见*/
    private String audOpinion;

    private String userName;//审核人

    @NotNull(message = "消息模版id不能为空")
    private Integer msgId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAudStatus() {
        return audStatus;
    }

    public void setAudStatus(String audStatus) {
        this.audStatus = audStatus;
    }

    public String getAudOpinion() {
        return audOpinion;
    }

    public void setAudOpinion(String audOpinion) {
        this.audOpinion = audOpinion;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    @Override
    public String toString() {
        return "AuditMemberReq [id=" + id + ", audStatus=" + audStatus + ", audOpinion=" + audOpinion + ", userName=" + userName + ", msgId=" + msgId
                + "]";
    }

}
