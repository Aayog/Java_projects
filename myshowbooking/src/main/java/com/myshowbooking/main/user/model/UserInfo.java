package com.myshowbooking.main.user.model;

public class UserInfo {
	
	private String id;
	private String username;
	private String firstname;
	private String lastname;
	private String phone;
	private String emailaddress;
	//private String recoveryemailaddress;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", phone=" + phone + ", emailaddress=" + emailaddress + ", getId()=" + getId() + ", getUnername()="
				+ getUsername() + ", getFirstname()=" + getFirstname() + ", getLastname()=" + getLastname()
				+ ", getPhone()=" + getPhone() + ", getEmailaddress()=" + getEmailaddress() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public UserInfo(String id, String username, String firstname, String lastname, String phone, String emailaddress) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.emailaddress = emailaddress;
	}
	public UserInfo() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
