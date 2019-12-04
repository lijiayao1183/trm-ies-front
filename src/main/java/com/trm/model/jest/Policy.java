package com.trm.model.jest;

public class Policy {
    private String id;
    private String policy_title;
    private String policy_content;
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

    public String getPolicy_title() {
        return policy_title;
    }

    public void setPolicy_title(String policy_title) {
        this.policy_title = policy_title;
    }

    public String getPolicy_content() {
        return policy_content;
    }

    public void setPolicy_content(String policy_content) {
        this.policy_content = policy_content;
    }
}
