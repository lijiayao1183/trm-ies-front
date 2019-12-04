package com.trm.trmserver.model;

public class ServiceListingDetail {
	private Integer id;
	private String proName;
	private String cpName;
	private String publishDate;
	private String publishTime;
	private String emphasisFlag;
	public ServiceListingDetail(Integer id, String proName, String cpName, String publishDate, String publishTime) {
		super();
		this.id = id;
		this.proName = proName;
		this.cpName = cpName;
		this.publishDate = publishDate;
		this.publishTime = publishTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getCpName() {
		return cpName;
	}
	public void setCpName(String cpName) {
		this.cpName = cpName;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public ServiceListingDetail() {
		super();
	}
	public String getEmphasisFlag() {
		return emphasisFlag;
	}
	public void setEmphasisFlag(String emphasisFlag) {
		this.emphasisFlag = emphasisFlag;
	}
	public ServiceListingDetail(Integer id, String proName, String cpName, String publishDate, String publishTime,
			String emphasisFlag) {
		super();
		this.id = id;
		this.proName = proName;
		this.cpName = cpName;
		this.publishDate = publishDate;
		this.publishTime = publishTime;
		this.emphasisFlag = emphasisFlag;
	}
	
	

}
