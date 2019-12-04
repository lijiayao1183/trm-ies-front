package com.trm.model.member;
/**
 * 个人中心-管理用户头部展示信息
 * @author zhaosimiao 2017-11-29 15:11:36
 *
 */
public class SubMemHeadInfo {
	
	private String handler;
	private String unitName;
	private String department;
	
	public SubMemHeadInfo() {
		super();
	}

	public SubMemHeadInfo(String handler, String unitName, String department) {
		super();
		this.handler = handler;
		this.unitName = unitName;
		this.department = department;
	}
	
	public String getHandler() {
		return handler;
	}
	public void setHandler(String handler) {
		this.handler = handler;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "SubMemHeadInfo [handler=" + handler + ", unitName=" + unitName + ", department=" + department + "]";
	}

}
