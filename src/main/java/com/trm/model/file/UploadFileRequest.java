package com.trm.model.file;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class UploadFileRequest {

	private CommonsMultipartFile[] files;
	
	private String name;
	
	
	public CommonsMultipartFile[] getFiles() {
		return files;
	}

	public void setFiles(CommonsMultipartFile[] files) {
		this.files = files;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
