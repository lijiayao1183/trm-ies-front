package com.trm.model.evaluation;

import javax.validation.constraints.NotNull;

import com.trm.model.common.CommonRequest;

public class EvaluationRequest extends CommonRequest {

    private Integer userId;

    @NotNull(message = "设备id不能为空")
    private Integer eqpId;//设备ID

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getEqpId() {
        return eqpId;
    }

    public void setEqpId(Integer eqpId) {
        this.eqpId = eqpId;
    }

    @Override
    public String toString() {
        return "EvaluationRequest [userId=" + userId + ", eqpId=" + eqpId + "]";
    }

}
