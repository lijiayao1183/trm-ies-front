package com.trm.model.common;

public class CommonResponse {

	public String code;
	public String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void setCodeAndMsg(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

    @Override
    public String toString() {
        return "CommonResponse [code=" + code + ", msg=" + msg + "]";
    }

}
