package com.trm.model.msg;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MyMsgRequest {

    private int pageNum; //当前页码
    private int num; //每页数量

    private Integer userId;
    private String content;
    private String readingState;
    private Date createStartTime;//发布开始时间
    private Date createEndTime;//发布结束时间

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getCreateStartTime() {
        return createStartTime;
    }

    public void setCreateStartTime(Date createStartTime) {
        this.createStartTime = createStartTime;
    }
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getCreateEndTime() {
        return createEndTime;
    }

    public void setCreateEndTime(Date createEndTime) {
        this.createEndTime = createEndTime;
    }

    @Override
    public String toString() {
        return "MyMsgRequest [pageNum=" + pageNum + ", num=" + num + ", userId=" + userId + ", content=" + content + ", readingState=" + readingState
                + ", createStartTime=" + createStartTime + ", createEndTime=" + createEndTime + "]";
    }

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
}
