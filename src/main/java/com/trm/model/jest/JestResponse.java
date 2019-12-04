package com.trm.model.jest;

import java.util.ArrayList;
import java.util.List;

public class JestResponse {
    @SuppressWarnings("rawtypes")
	private List<?> objList = new ArrayList();
    private String total;

    public List<?> getObjList() {
        return objList;
    }

    public void setObjList(List<?> objList) {
        this.objList = objList;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
