package com.trm.model.news;

public class NewsPic {

	private Integer id;
    private String title;//标题
    private String picture;//图片
    
	public NewsPic() {
		super();
	}
	
	public NewsPic(Integer id, String title, String picture) {
		super();
		this.id = id;
		this.title = title;
		this.picture = picture;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	@Override
	public String toString() {
		return "NewsPic [id=" + id + ", title=" + title + ", picture=" + picture + "]";
	}

}
