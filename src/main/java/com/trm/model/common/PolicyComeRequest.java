package com.trm.model.common;

public class PolicyComeRequest extends CommonRequest {
    private String code;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PolicyComeRequest(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public PolicyComeRequest() {
        super();
    }

    @Override
    public String toString() {
        return "PolicyComeRequest [code=" + code + ", name=" + name + "]";
    }

}
