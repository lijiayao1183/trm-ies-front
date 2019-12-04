package com.trm.model.equip;

import javax.validation.constraints.NotNull;

public class NotDisplayReq {

    @NotNull(message = "下架设备id不能为空")
    private Integer id;

    private String isDisplay;
    
    private String reason;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(String isDisplay) {
        this.isDisplay = isDisplay;
    }

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "NotDisplayReq [id=" + id + ", isDisplay=" + isDisplay + ", reason=" + reason + "]";
	}
    
}
