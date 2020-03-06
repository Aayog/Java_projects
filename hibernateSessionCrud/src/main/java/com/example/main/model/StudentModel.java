package com.example.main.model;

import java.io.Serializable;

public class StudentModel implements Serializable {
	
	private static final long serialVersionUID = -7547189284125850066L;
	

	private String id;

	private String fname;

	private String lname;

	private String address;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
