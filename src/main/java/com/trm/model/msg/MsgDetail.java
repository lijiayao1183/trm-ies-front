package com.trm.model.msg;

public class MsgDetail {
	
    private Integer id;
    private String msgName;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsgName() {
        return msgName;
    }

    public void setMsgName(String msgName) {
        this.msgName = msgName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MsgDetail [id=" + id + ", msgName=" + msgName + ", description=" + description + "]";
    }

}
