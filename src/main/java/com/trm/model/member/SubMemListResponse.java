package com.trm.model.member;

import com.trm.model.common.CommonListResponse;

@SuppressWarnings({ "serial"})
public class SubMemListResponse <T> extends CommonListResponse <T> {
	
	private SubMemHeadInfo headInfo;

	public SubMemHeadInfo getHeadInfo() {
		return headInfo;
	}

	public void setHeadInfo(SubMemHeadInfo headInfo) {
		this.headInfo = headInfo;
	}

	@Override
	public String toString() {
		return "SubMemListResponse [headInfo=" + headInfo + "]";
	}
	
}
