package com.trm.model.jest;

public class Trade {
    private String id;
    private String pro_name;
    private String technical_route;
    private String type_name;

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public String getTechnical_route() {
        return technical_route;
    }

    public void setTechnical_route(String technical_route) {
        this.technical_route = technical_route;
    }
}
