package com.studentModel;

import javafx.scene.image.Image;

public class Student_model {

	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private Image image;
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

	public Student_model(int id, String firstName, String middleName, String lastName, Image image, String phone,
			String address, String email, int clash, int roll, String admitionDate, String createdBy, String updatedBy,
			String updatedDate, String createdDate,String parent) {

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
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.createdDate = createdDate;
		this.setParent(parent);
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

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
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

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

}
