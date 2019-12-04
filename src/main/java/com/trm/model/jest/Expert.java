package com.trm.model.jest;

public class Expert {
    private String id;
    private String expert_name;
    private String expert_domain;
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

    public String getExpert_name() {
        return expert_name;
    }

    public void setExpert_name(String expert_name) {
        this.expert_name = expert_name;
    }

    public String getExpert_domain() {
        return expert_domain;
    }

    public void setExpert_domain(String expert_domain) {
        this.expert_domain = expert_domain;
    }
}
