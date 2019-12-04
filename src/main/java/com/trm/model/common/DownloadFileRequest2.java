package com.trm.model.common;

public class DownloadFileRequest2 {
  
	private int id;
	private String name;
	private String filePath;
	private String targetPath;
	public DownloadFileRequest2(int id, String name, String filePath, String targetPath) {
		this.id = id;
		this.name = name;
		this.filePath = filePath;
		this.targetPath = targetPath;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getTargetPath() {
		return targetPath;
	}
	public void setTargetPath(String targetPath) {
		this.targetPath = targetPath;
	}
	public DownloadFileRequest2() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
