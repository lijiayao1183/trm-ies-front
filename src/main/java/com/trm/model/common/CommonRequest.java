package com.trm.model.common;

public class CommonRequest {
	private Integer id;
	private int pageNum;		//当前页码
	private int num;			//每页数量
	private String way;
	private String searchkey;
	private String code;
	private String name;	//名称
	public CommonRequest(Integer id, int pageNum, int num, String way, String searchkey, String code, String name) {
		super();
		this.id = id;
		this.pageNum = pageNum;
		this.num = num;
		this.way = way;
		this.searchkey = searchkey;
		this.code = code;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getWay() {
		return way;
	}
	public void setWay(String way) {
		this.way = way;
	}
	public String getSearchkey() {
		return searchkey;
	}
	public void setSearchkey(String searchkey) {
		this.searchkey = searchkey;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CommonRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
