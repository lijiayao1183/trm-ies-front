package com.trm.model.common;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TempletSimDetail {
	private Integer id;
	private String fileName;
	private String filePath;
	private Integer downCount;
	private String creator;
	private Date createTime;
	private String fileType;
	private Long fileSize;
	public TempletSimDetail(Integer id, String fileName, String filePath, Integer downCount, String creator,
			Date createTime, String fileType, Long size) {
		this.id = id;
		this.fileName = fileName;
		this.filePath = filePath;
		this.downCount = downCount;
		this.creator = creator;
		this.createTime = createTime;
		this.fileType = fileType;
		this.fileSize = size;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Integer getDownCount() {
		return downCount;
	}
	public void setDownCount(Integer downCount) {
		this.downCount = downCount;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	public TempletSimDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
