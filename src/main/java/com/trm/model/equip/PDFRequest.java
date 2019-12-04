package com.trm.model.equip;

import javax.validation.constraints.NotNull;

public class PDFRequest {
	
	@NotNull(message = "所下载项的id不能为空")
	private Integer itemId;

	@NotNull(message = "所下载项的对象分类不能为空")
	private String itemType;
	
	@NotNull(message = "是否为详情页")
	private String isDetail;

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getIsDetail() {
		return isDetail;
	}

	public void setIsDetail(String isDetail) {
		this.isDetail = isDetail;
	}

	@Override
	public String toString() {
		return "PDFRequest [itemId=" + itemId + ", itemType=" + itemType + ", isDetail=" + isDetail + "]";
	}
	
}
