package com.trm.model.common;

import java.util.List;

public class UnitResponse {

    private String code;
    private String name;
    private List<UnitResponse> subList;

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

    public List<UnitResponse> getSubList() {
        return subList;
    }

    public void setSubList(List<UnitResponse> subList) {
        this.subList = subList;
    }

    @Override
    public String toString() {
        return "UnitResponse [code=" + code + ", name=" + name + ", subList=" + subList + "]";
    }

}
