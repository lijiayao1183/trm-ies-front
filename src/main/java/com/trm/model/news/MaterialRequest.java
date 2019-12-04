package com.trm.model.news;

import com.trm.model.common.CommonRequest;

public class MaterialRequest extends CommonRequest {

	/**
	 * 标题
	 */
    private String title;

    /**
     * 资料
     * 政策法规 1
     * 要闻动态 2
     * 通知公告 3
     * 工作动态 4 
     */
    private String flagCode;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFlagCode() {
        return flagCode;
    }

    public void setFlagCode(String flagCode) {
        this.flagCode = flagCode;
    }

    @Override
	public String toString() {
		return "MaterialRequest [title=" + title + ", flagCode=" + flagCode + "]";
	}

}
