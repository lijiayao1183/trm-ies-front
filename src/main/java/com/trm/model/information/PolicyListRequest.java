package com.trm.model.information;

public class PolicyListRequest {

	private String title;
	private String category;
	private String enterpName;
	private String rankType;
	private String isAsc;
	private int pageNum;
	private int num;

	public PolicyListRequest(String title, String category, String enterpName, String rankType, String isAsc, int pageNum, int num) {
		this.title = title;
		this.category = category;
		this.enterpName = enterpName;
		this.rankType = rankType;
		this.isAsc = isAsc;
		this.pageNum = pageNum;
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getEnterpName() {
		return enterpName;
	}

	public void setEnterpName(String enterpName) {
		this.enterpName = enterpName;
	}

	public String getRankType() {
		return rankType;
	}

	public void setRankType(String rankType) {
		this.rankType = rankType;
	}

	public String getIsAsc() {
		return isAsc;
	}

	public void setIsAsc(String isAsc) {
		this.isAsc = isAsc;
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

	public PolicyListRequest() {
		super();
	}

	@Override
	public String toString() {
		return "PolicyListRequest [title=" + title + ", category=" + category + ", enterpName=" + enterpName + ", rankType=" + rankType + ", isAsc=" + isAsc + ", pageNum=" + pageNum + ", num=" + num + "]";
	}

}
