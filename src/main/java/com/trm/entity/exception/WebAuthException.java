package com.trm.entity.exception;

public class WebAuthException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * 根据reason code可以判断出是什么业务逻辑错误
	 */
	private String reasoncode;
	/*
	 * 对错误的描述
	 */
	private String desc;
	public String getReasoncode() {
		return reasoncode;
	}
	public void setReasoncode(String reasoncode) {
		this.reasoncode = reasoncode;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
