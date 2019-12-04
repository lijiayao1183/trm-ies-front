package com.trm.model.personal;

public class MemberLoginBean {
	private String login_id;
	private String login_pwd;
	private String receiver;
	private String cert_code;
	private String pwd_length;

	public String getCert_code() {
		return cert_code;
	}

	public void setCert_code(String cert_code) {
		this.cert_code = cert_code;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getLogin_pwd() {
		return login_pwd;
	}

	public void setLogin_pwd(String login_pwd) {
		this.login_pwd = login_pwd;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getPwd_length() {
		return pwd_length;
	}

	public void setPwd_length(String pwd_length) {
		this.pwd_length = pwd_length;
	}

	@Override
	public String toString() {
		return "MemberLoginBean [login_id=" + login_id + ", login_pwd=" + login_pwd + ", receiver=" + receiver + ", cert_code=" + cert_code + ", pwd_length=" + pwd_length + "]";
	}

}
