package com.trm.model.register;

public class CreditIdKeys {
	
	private String creditId;
	private String linkPerson;
	private String phone;
	private String department;
	private String code;
	
	public CreditIdKeys() {
		super();
	}

	public CreditIdKeys(String creditId, String linkPerson, String phone, String department) {
		super();
		this.creditId = creditId;
		this.linkPerson = linkPerson;
		this.phone = phone;
		this.department = department;
	}
	
	public String getCreditId() {
		return creditId;
	}
	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}
	public String getLinkPerson() {
		return linkPerson;
	}
	public void setLinkPerson(String linkPerson) {
		this.linkPerson = linkPerson;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "CreditIdKeys [creditId=" + creditId + ", linkPerson=" + linkPerson
				+ ", phone=" + phone + ", department=" + department + ", code="
				+ code + "]";
	}

}
