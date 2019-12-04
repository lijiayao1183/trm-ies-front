package com.trm.util.batch;

public class BatchEquipFileRequest {

    private String filePath;

    private String fileName;

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

    @Override
	public String toString() {
		return "BatchEquipFileRequest [filePath=" + filePath + ", fileName=" + fileName + "]";
	}

}
