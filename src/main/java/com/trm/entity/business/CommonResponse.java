package com.trm.entity.business;

public class CommonResponse {

    public Integer code;
	public String message;

	public CommonResponse() {
		super();
	}

	public CommonResponse(String message) {
		super();
		this.message = message;
	}

	public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

    @Override
    public String toString() {
        return "CommonResponse [code=" + code + ", message=" + message + "]";
    }

}
