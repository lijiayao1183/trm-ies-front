package com.trm.model.common;

import java.util.List;

public class SysDataSimListDetailResponse {
	private List<SysDataSimDetail> list;

	public SysDataSimListDetailResponse(List<SysDataSimDetail> list) {
		super();
		this.list = list;
	}

	public List<SysDataSimDetail> getList() {
		return list;
	}

	public void setList(List<SysDataSimDetail> list) {
		this.list = list;
	}

	public SysDataSimListDetailResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
