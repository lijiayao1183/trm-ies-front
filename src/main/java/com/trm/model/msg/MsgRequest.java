package com.trm.model.msg;

import com.trm.model.common.CommonRequest;

public class MsgRequest extends CommonRequest {

    private String msgName;

    public String getMsgName() {
        return msgName;
    }

    public void setMsgName(String msgName) {
        this.msgName = msgName;
    }

    @Override
    public String toString() {
        return "MsgRequest [msgName=" + msgName + "]";
    }

}
