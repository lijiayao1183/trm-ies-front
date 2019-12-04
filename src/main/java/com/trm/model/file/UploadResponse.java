package com.trm.model.file;

import java.util.Date;

/**
* @description 上传文件的输出字段集
* @author Vani
* @Time 2016年8月3日
*/
public class UploadResponse {
	
	private String accessPath; //存储的访问路径
	
	private String originalName;//文件原名
	
	private String source;
	
	private long size;//文件大小
	
	private String fileType;//文件类型
	
	private Date uploadTime;//文件上传时间
	
	private String username;//上传人
	
	

	public UploadResponse() {
		super();
	}
	

	public UploadResponse(String accessPath, String originalName, long size, String fileType,
			Date uploadTime, String username) {
		super();
		this.accessPath = accessPath;
		this.originalName = originalName;
		this.size = size;
		this.fileType = fileType;
		this.uploadTime = uploadTime;
		this.username = username;
	}
	
	


	public UploadResponse(String accessPath, String originalName, String source, long size, String fileType,
			Date uploadTime, String username) {
		super();
		this.accessPath = accessPath;
		this.originalName = originalName;
		this.source = source;
		this.size = size;
		this.fileType = fileType;
		this.uploadTime = uploadTime;
		this.username = username;
	}


	public String getAccessPath() {
		return accessPath;
	}

	public void setAccessPath(String accessPath) {
		this.accessPath = accessPath;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}

	
	
	
}
