package com.trm.model.login;

/**
 * 找回密码
 * @author zhaosimiao 2017-10-9 11:03:36
 *
 */
public class PwdReset {
	
	/**
	 * 邮箱验证还是问题验证
	 */
	private String isEorQ;

	/**
	 * 找回密码模块：传值N
	 * 密码管理模块：传值Y
	 */
	private String isLogin;
	
	/**
	 * uuid值
	 */
	private String code;
	private String username;
	private String question;
	private String answer;
	private String email;
	private String oldPwd;
	private String newPwd;
	
	public String getIsEorQ() {
		return isEorQ;
	}
	public void setIsEorQ(String isEorQ) {
		this.isEorQ = isEorQ;
	}
	public String getIsLogin() {
		return isLogin;
	}
	public void setIsLogin(String isLogin) {
		this.isLogin = isLogin;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOldPwd() {
		return oldPwd;
	}
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	
	@Override
	public String toString() {
		return "PwdReset [isEorQ=" + isEorQ + ", isLogin=" + isLogin + ", code=" + code + ", username=" + username
				+ ", question=" + question + ", answer=" + answer + ", email=" + email + ", oldPwd=" + oldPwd
				+ ", newPwd=" + newPwd + "]";
	}
	
}
