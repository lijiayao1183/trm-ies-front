package com.trm.model.information;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PolicySimDetail implements java.io.Serializable {

    // Fields

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String code;
    private String category;
    private String title;
    private String enterpName;
    private String keyWords;
    private Date createTime;
    private Date pubDate;

    public PolicySimDetail(Integer id, String code, String category, String title, String enterpName, String keyWords,
            Date createTime, Date pubDate) {
        this.id = id;
        this.code = code;
        this.category = category;
        this.title = title;
        this.enterpName = enterpName;
        this.keyWords = keyWords;
        this.createTime = createTime;
        this.pubDate = pubDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEnterpName() {
        return enterpName;
    }

    public void setEnterpName(String enterpName) {
        this.enterpName = enterpName;
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

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public PolicySimDetail() {
        super();
    }

    @Override
    public String toString() {
        return "PolicySimDetail [id=" + id + ", code=" + code + ", category=" + category + ", title=" + title
                + ", enterpName=" + enterpName + ", keyWords=" + keyWords + ", createTime=" + createTime + ", pubDate="
                + pubDate + "]";
    }

}