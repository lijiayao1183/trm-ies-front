package com.trm.model.news;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trm.model.common.CommonRequest;

public class NewsReq extends CommonRequest {

    private String title;//标题
    private String updater;//发布人
    private Date publishStartTime;//发布开始时间
    private Date publishEndTime;//发布结束时间
    private String flagCode;//资讯分类区分编码政策法规:1,要闻动态:2,最新推荐:3

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getPublishStartTime() {
        return publishStartTime;
    }

    public void setPublishStartTime(Date publishStartTime) {
        this.publishStartTime = publishStartTime;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getPublishEndTime() {
        return publishEndTime;
    }

    public void setPublishEndTime(Date publishEndTime) {
        this.publishEndTime = publishEndTime;
    }

    public String getFlagCode() {
        return flagCode;
    }

    public void setFlagCode(String flagCode) {
        this.flagCode = flagCode;
    }

    @Override
    public String toString() {
        return "NewsReq [title=" + title + ", updater=" + updater + ", publishStartTime=" + publishStartTime + ", publishEndTime=" + publishEndTime
                + ", flagCode=" + flagCode + "]";
    }

}
