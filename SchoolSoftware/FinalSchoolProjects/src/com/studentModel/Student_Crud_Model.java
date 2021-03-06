package com.studentModel;

import java.io.FileInputStream;

public class Student_Crud_Model {
	
	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private FileInputStream image;
	private String phone;
	private String address;
	private String email;
	private int clash;
	private int roll;
	private String admitionDate;
	private String parent;

	private String createdBy;
	private String updatedBy;
	private String updatedDate;
	private String createdDate;
	
	
	
	
	
	public Student_Crud_Model(int id, String firstName, String middleName, String lastName, FileInputStream image,
			String phone, String address, String email, int clash, int roll, String admitionDate, String parent,
			String createdBy, String updatedBy, String updatedDate, String createdDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.image = image;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.clash = clash;
		this.roll = roll;
		this.admitionDate = admitionDate;
		this.parent = parent;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.createdDate = createdDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public FileInputStream getImage() {
		return image;
	}
	public void setImage(FileInputStream image) {
		this.image = image;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getClash() {
		return clash;
	}
	public void setClash(int clash) {
		this.clash = clash;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getAdmitionDate() {
		return admitionDate;
	}
	public void setAdmitionDate(String admitionDate) {
		this.admitionDate = admitionDate;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	
	

}
