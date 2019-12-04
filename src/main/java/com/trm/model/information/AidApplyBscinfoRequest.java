package com.trm.model.information;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AidApplyBscinfoRequest {

	private String applyer;
	private String creditId;
	private String reviewDate;

	private String mold;
	private String type;

	private int pageNum;

	private int num;

	public AidApplyBscinfoRequest(String applyer, String creditId, String reviewDate, String mold, String type, int pageNum, int num) {
		this.applyer = applyer;
		this.creditId = creditId;
		this.reviewDate = reviewDate;
		this.mold = mold;
		this.type = type;
		this.pageNum = pageNum;
		this.num = num;
	}

	public String getApplyer() {
		return applyer;
	}

	public void setApplyer(String applyer) {
		this.applyer = applyer;
	}

	public String getCreditId() {
		return creditId;
	}

	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	@JsonFormat(pattern = "yyyyMMddHHmmss", timezone = "GMT+8")
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getMold() {
		return mold;
	}

	public void setMold(String mold) {
		this.mold = mold;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public AidApplyBscinfoRequest() {
		super();
	}

	@Override
	public String toString() {
		return "AidApplyBscinfoRequest [applyer=" + applyer + ", creditId=" + creditId + ", reviewDate=" + reviewDate + ", mold=" + mold + ", type=" + type + ", pageNum=" + pageNum + ", num=" + num + "]";
	}

}
