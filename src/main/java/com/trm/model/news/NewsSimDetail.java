package com.trm.model.news;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NewsSimDetail {

    private Integer id;
    private String title;//标题
    private String flagCode;//资讯分类
    private Date publishTime;//发布时间
    private String picture;//图片
    private String summary;//摘要
    //发布单位
    private String publishUnit;

    public NewsSimDetail() {
        super();
    }

    public NewsSimDetail(Integer id, String title, String flagCode, Date publishTime, String picture, String summary,String publishUnit) {
        super();
        this.id = id;
        this.title = title;
        this.flagCode = flagCode;
        this.publishTime = publishTime;
        this.picture = picture;
        this.summary = summary;
        this.publishUnit = publishUnit;
    }

    public String getPublishUnit() {
        return publishUnit;
    }

    public void setPublishUnit(String publishUnit) {
        this.publishUnit = publishUnit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFlagCode() {
        return flagCode;
    }

    public void setFlagCode(String flagCode) {
        this.flagCode = flagCode;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "NewsSimDetail [id=" + id + ", title=" + title + ", flagCode=" + flagCode + ", publishTime=" + publishTime + ", picture=" + picture
                + ", summary=" + summary + "]";
    }

}
