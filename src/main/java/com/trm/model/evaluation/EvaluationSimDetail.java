package com.trm.model.evaluation;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EvaluationSimDetail {

    private Integer id;
    private String username;//评论人用户名
    private String nickName;//评论人昵称
    private String headPortrait;//用户头像
    private String evaluation;//评论内容
    private Date publishDate;//评论时间

    public EvaluationSimDetail() {
        super();
    }

    public EvaluationSimDetail(Integer id,String username, String nickName,String headPortrait, String evaluation, Date publishDate) {
        super();
        this.id = id;
        this.username = username;
        this.nickName = nickName;
        this.headPortrait = headPortrait;
        this.evaluation = evaluation;
        this.publishDate = publishDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "EvaluationSimDetail [username=" + username + ", nickName=" + nickName + ", evaluation=" + evaluation + ", publishDate=" + publishDate
                + "]";
    }

}
