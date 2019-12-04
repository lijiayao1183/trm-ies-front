package com.trm.model.information;

public class CodeReq {
	private String code;

	public CodeReq(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public CodeReq() {
		super();
	}

	@Override
	public String toString() {
		return "CodeReq [code=" + code + "]";
	}

}
