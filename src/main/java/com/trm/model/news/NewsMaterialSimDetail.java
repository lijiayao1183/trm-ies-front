package com.trm.model.news;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NewsMaterialSimDetail {

	private Integer id;
	private Integer newsId;
	private String materialName;
	private String materialUrl;
	private Date updateTime;
	private Date createTime;
	
	public NewsMaterialSimDetail() {
		super();
	}

	public NewsMaterialSimDetail(Integer id, Integer newsId, String materialName, String materialUrl, Date updateTime,
			Date createTime) {
		super();
		this.id = id;
		this.newsId = newsId;
		this.materialName = materialName;
		this.materialUrl = materialUrl;
		this.updateTime = updateTime;
		this.createTime = createTime;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getMaterialName() {
		return this.materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getMaterialUrl() {
		return this.materialUrl;
	}

	public void setMaterialUrl(String materialUrl) {
		this.materialUrl = materialUrl;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}