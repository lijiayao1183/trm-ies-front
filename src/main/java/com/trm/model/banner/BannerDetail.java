package com.trm.model.banner;

public class BannerDetail {

	private Integer id;
	private String siteCode;
	private String bannerUp;
	private String bannerDown;
	private String videoUrl;
	private String bgColour;
	private String imgUrl;
	private String brief;
	private Integer sortNo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	public String getBannerUp() {
		return bannerUp;
	}
	public void setBannerUp(String bannerUp) {
		this.bannerUp = bannerUp;
	}
	public String getBannerDown() {
		return bannerDown;
	}
	public void setBannerDown(String bannerDown) {
		this.bannerDown = bannerDown;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public String getBgColour() {
		return bgColour;
	}
	public void setBgColour(String bgColour) {
		this.bgColour = bgColour;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public Integer getSortNo() {
		return sortNo;
	}
	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}
	
	@Override
	public String toString() {
		return "BannerDetail [id=" + id + ", siteCode=" + siteCode + ", bannerUp=" + bannerUp + ", bannerDown="
				+ bannerDown + ", videoUrl=" + videoUrl + ", bgColour=" + bgColour + ", imgUrl=" + imgUrl + ", brief="
				+ brief + ", sortNo=" + sortNo + "]";
	}

}