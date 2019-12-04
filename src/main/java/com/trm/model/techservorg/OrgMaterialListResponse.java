package com.trm.model.techservorg;

import java.util.List;

/**
 * 技术服务机构 随附材料列表返回
 * @author zhaosimiao 2018-6-5 14:21:20
 */
public class OrgMaterialListResponse <T> implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<T> fileList;

	public List<T> getFileList() {
		return fileList;
	}

	public void setFileList(List<T> fileList) {
		this.fileList = fileList;
	}
	
}
