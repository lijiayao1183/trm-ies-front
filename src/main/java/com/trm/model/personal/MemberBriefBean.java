package com.trm.model.personal;

public class MemberBriefBean {
    private String login_id; // 用户名
    private String real_name; // 真实姓名
    private String phone_number; // 联系电话
    private String head_url; // 头像地址
    private String real_cert; // 0：未实名认证    1：已实名认证
    private String last_visit_jsp;

    public String getLogin_id() {
        return login_id;
    }

    public void setLogin_id(String login_id) {
        this.login_id = login_id;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getHead_url() {
        return head_url;
    }

    public void setHead_url(String head_url) {
        this.head_url = head_url;
    }

    public String getReal_cert() {
        return real_cert;
    }

    public void setReal_cert(String real_cert) {
        this.real_cert = real_cert;
    }

    public String getLast_visit_jsp() {
        return last_visit_jsp;
    }

    public void setLast_visit_jsp(String last_visit_jsp) {
        this.last_visit_jsp = last_visit_jsp;
    }

    @Override
    public String toString() {
        return "MemberBriefBean [login_id=" + login_id + ", real_name=" + real_name + ", phone_number=" + phone_number
                + ", head_url=" + head_url + ", real_cert=" + real_cert + ", last_visit_jsp=" + last_visit_jsp + "]";
    }

}
