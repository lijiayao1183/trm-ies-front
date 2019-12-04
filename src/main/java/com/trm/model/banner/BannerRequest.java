package com.trm.model.banner;

import com.trm.model.common.CommonRequest;

public class BannerRequest extends CommonRequest{

	private String siteCode;

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	@Override
	public String toString() {
		return "BannerRequest [siteCode=" + siteCode + "]";
	}
	
}
