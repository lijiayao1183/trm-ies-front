package com.trm.model.common;

public class SysDataRequest extends CommonRequest {
	
    private String code;
    private String name;
    private String subType;
    
    public SysDataRequest() {
        super();
    }
    
    public SysDataRequest(String code) {
        this.code = code;
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

    public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	@Override
	public String toString() {
		return "SysDataRequest [code=" + code + ", name=" + name + ", subType=" + subType + "]";
	}

}
