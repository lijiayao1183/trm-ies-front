package com.trm.trmserver.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class ServiceRequest {
	
	private String name;
	
	private String paswd;
	
	private Integer num;
	
	private Integer pageNum;
	
	@NotEmpty(message = "开始日期不能为空，格式{yyyy-MM-dd}")
	private String startDate;
	@NotEmpty(message = "结束日期不能为空，格式{yyyy-MM-dd}")
	private String endDate;

	private String type;

	public ServiceRequest(String name, String paswd, Integer num, Integer pageNum, String startDate, String endDate,
			String type) {
		this.name = name;
		this.paswd = paswd;
		this.num = num;
		this.pageNum = pageNum;
		this.startDate = startDate;
		this.endDate = endDate;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPaswd() {
		return paswd;
	}

	public void setPaswd(String paswd) {
		this.paswd = paswd;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ServiceRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
