package com.trm.model.information;

public class AuthenticationUser {
    String code;
    String time;
    String name;

    public AuthenticationUser(String code, String time, String name) {
        this.code = code;
        this.time = time;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AuthenticationUser() {
        super();
    }

    @Override
    public String toString() {
        return "AuthenticationUser [code=" + code + ", time=" + time + ", name=" + name + "]";
    }

}
