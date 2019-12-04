package com.trm.model.evaluation;

import javax.validation.constraints.NotNull;

public class RemoveReq {

    @NotNull(message = "评论id不能为空")
    private Integer id;
    private Integer eqpId;//设备ID

    private Integer regId;//用户ID

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "RemoveReq [id=" + id + ", eqpId=" + eqpId + "]";
    }

}
