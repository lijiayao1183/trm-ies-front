package com.trm.model.msg;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MyMsgDetail {

    private Integer id;
    private String msgName;
    private String content;
    private String readingState;
    private Date createTime;

    public MyMsgDetail() {
        super();
    }

    public MyMsgDetail(Integer id, String msgName, String content, String readingState, Date createTime) {
        super();
        this.id = id;
        this.msgName = msgName;
        this.content = content;
        this.readingState = readingState;
        this.createTime = createTime;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReadingState() {
        return readingState;
    }

    public void setReadingState(String readingState) {
        this.readingState = readingState;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MyMsgDetail [id=" + id + ", msgName=" + msgName + ", content=" + content + ", readingState=" + readingState + ", createTime="
                + createTime + "]";
    }

}
