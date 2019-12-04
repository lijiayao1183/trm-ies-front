package com.trm.model.common;

public class TempletFilePathRequest {
    
	private  int id;
	private String filePath;
	
	private String fileName;

	public TempletFilePathRequest(int id, String filePath, String fileName) {
		this.id = id;
		this.filePath = filePath;
		this.fileName = fileName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public TempletFilePathRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
