package com.trm.model.register;

public class UniqueKeys {
	
	private String phone;
	private String email;
	private String numberId;
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumberId() {
		return numberId;
	}
	public void setNumberId(String numberId) {
		this.numberId = numberId;
	}
	
	@Override
	public String toString() {
		return "UniqueKeys [phone=" + phone + ", email=" + email + ", numberId=" + numberId + "]";
	}
	
}
