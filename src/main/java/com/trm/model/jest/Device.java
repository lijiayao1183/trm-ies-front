package com.trm.model.jest;

public class Device {
    private String id;
    private String device_name;
    private String applied_range;
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

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public String getApplied_range() {
        return applied_range;
    }

    public void setApplied_range(String applied_range) {
        this.applied_range = applied_range;
    }
}
