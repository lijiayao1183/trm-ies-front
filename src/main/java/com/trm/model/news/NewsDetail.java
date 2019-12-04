package com.trm.model.news;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NewsDetail {

    private Integer id;
    /*
     * 标题
     */
    private String title;
    /*
     * 来源
     */
    private String origin;
    /*
     * 摘要
     */
    private String summary;
    /*
     * 创建人
     */
    private String creator;
    //发布单位
    private String publishUnit;
    /*
     * 正文
     */
    private String context;
    /*
     * 图片
     */
    private String picture;
    /*
     * 资讯分类区分编码
     */
    private String flagCode;
    /*
     * 发布时间
     */
    private Date publishTime;

    private String publishStatus;//发布状态

    private String isTop;//是否置顶
    private Integer topSort;//置顶顺序
    
    private List<NewsMaterialSimDetail> nmList;

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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getPublishUnit() {
        return publishUnit;
    }

    public void setPublishUnit(String publishUnit) {
        this.publishUnit = publishUnit;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getFlagCode() {
        return flagCode;
    }

    public void setFlagCode(String flagCode) {
        this.flagCode = flagCode;
    }

    public String getIsTop() {
        return isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }

    public Integer getTopSort() {
        return topSort;
    }

    public void setTopSort(Integer topSort) {
        this.topSort = topSort;
    }

    public String getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(String publishStatus) {
        this.publishStatus = publishStatus;
    }
    
    public List<NewsMaterialSimDetail> getNmList() {
		return nmList;
	}

	public void setNmList(List<NewsMaterialSimDetail> nmList) {
		this.nmList = nmList;
	}

	@Override
    public String toString() {
        return "NewsDetail [id=" + id + ", title=" + title + ", origin=" + origin + ", summary=" + summary + ", creator=" + creator + ", publishUnit="
                + publishUnit + ", context=" + context + ", picture=" + picture + ", flagCode=" + flagCode + ", publishTime=" + publishTime
                + ", publishStatus=" + publishStatus + ", isTop=" + isTop + ", topSort=" + topSort + "]";
    }

}
