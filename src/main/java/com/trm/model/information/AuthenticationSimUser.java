package com.trm.model.information;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AuthenticationSimUser {
    String id_code;
    String real_name;
    String modify_time;

    public AuthenticationSimUser(String id_code, String real_name, String modify_time) {
        this.id_code = id_code;
        this.real_name = real_name;
        this.modify_time = modify_time;
    }

    public String getId_code() {
        return id_code;
    }

    public void setId_code(String id_code) {
        this.id_code = id_code;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public String getModify_time() {
        return modify_time;
    }

    public void setModify_time(String modify_time) {
        this.modify_time = modify_time;
    }

    public AuthenticationSimUser() {
        super();
    }

    @Override
    public String toString() {
        return "AuthenticationSimUser [id_code=" + id_code + ", real_name=" + real_name + ", modify_time=" + modify_time
                + "]";
    }

}
