package com.trm.model.file;

public class FilePathRequest {

	private String filePath;
	
	private String fileName;

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

	@Override
	public String toString() {
		return "FilePathRequest [filePath=" + filePath + "]";
	}
	
}
