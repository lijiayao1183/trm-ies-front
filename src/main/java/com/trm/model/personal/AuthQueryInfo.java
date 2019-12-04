package com.trm.model.personal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"primary-key"}, ignoreUnknown = true)
public class AuthQueryInfo {
	 private String login_id;
	 private String cert_state;
	 private String id_code;
	 private String id_image_b;
	 private String id_image_f;
	 private String modify_user;
	 private String real_name;
	 private String create_time;
	 private String per_cert;
	 private String create_user;
	 private String user_id;
	 private String modify_time;
	 private String submit_time;
	 private String approver;
	 private String approve_time;
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getCert_state() {
		return cert_state;
	}
	public void setCert_state(String cert_state) {
		this.cert_state = cert_state;
	}
	public String getId_code() {
		return id_code;
	}
	public void setId_code(String id_code) {
		this.id_code = id_code;
	}
	public String getId_image_b() {
		return id_image_b;
	}
	public void setId_image_b(String id_image_b) {
		this.id_image_b = id_image_b;
	}
	public String getId_image_f() {
		return id_image_f;
	}
	public void setId_image_f(String id_image_f) {
		this.id_image_f = id_image_f;
	}
	public String getModify_user() {
		return modify_user;
	}
	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getPer_cert() {
		return per_cert;
	}
	public void setPer_cert(String per_cert) {
		this.per_cert = per_cert;
	}
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getModify_time() {
		return modify_time;
	}
	public void setModify_time(String modify_time) {
		this.modify_time = modify_time;
	}
	public String getSubmit_time() {
		return submit_time;
	}
	public void setSubmit_time(String submit_time) {
		this.submit_time = submit_time;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public String getApprove_time() {
		return approve_time;
	}
	public void setApprove_time(String approve_time) {
		this.approve_time = approve_time;
	}
	 
}
