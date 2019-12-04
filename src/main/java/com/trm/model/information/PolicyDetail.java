package com.trm.model.information;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PolicyDetail {
    private String title;
    private String keyWords;
    private Date createTime;
    private String enterpName;
    private Integer viewCount;
    private String category;
    private String content;
    private String precode;
    private String pretitle;
    private String nextcode;
    private String nexttitle;
    private String source;
    private Date pubDate;

    public PolicyDetail(String title, String keyWords, Date createTime, String enterpName, Integer viewCount,
            String category, String content, String precode, String pretitle, String nextcode, String nexttitle,
            String source, Date pubDate) {
        this.title = title;
        this.keyWords = keyWords;
        this.createTime = createTime;
        this.enterpName = enterpName;
        this.viewCount = viewCount;
        this.category = category;
        this.content = content;
        this.precode = precode;
        this.pretitle = pretitle;
        this.nextcode = nextcode;
        this.nexttitle = nexttitle;
        this.source = source;
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEnterpName() {
        return enterpName;
    }

    public void setEnterpName(String enterpName) {
        this.enterpName = enterpName;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPrecode() {
        return precode;
    }

    public void setPrecode(String precode) {
        this.precode = precode;
    }

    public String getPretitle() {
        return pretitle;
    }

    public void setPretitle(String pretitle) {
        this.pretitle = pretitle;
    }

    public String getNextcode() {
        return nextcode;
    }

    public void setNextcode(String nextcode) {
        this.nextcode = nextcode;
    }

    public String getNexttitle() {
        return nexttitle;
    }

    public void setNexttitle(String nexttitle) {
        this.nexttitle = nexttitle;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public PolicyDetail() {
        super();
    }

    @Override
    public String toString() {
        return "PolicyDetail [title=" + title + ", keyWords=" + keyWords + ", createTime=" + createTime
                + ", enterpName=" + enterpName + ", viewCount=" + viewCount + ", category=" + category + ", content="
                + content + ", precode=" + precode + ", pretitle=" + pretitle + ", nextcode=" + nextcode
                + ", nexttitle=" + nexttitle + ", source=" + source + ", pubDate=" + pubDate + "]";
    }

}
