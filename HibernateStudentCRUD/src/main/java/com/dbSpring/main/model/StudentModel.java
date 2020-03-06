package com.dbSpring.main.model;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class StudentModel implements Serializable {
	
	private static final long serialVersionUID = -7547189284125850066L;
	private String id;
	private String fname;
	private String lname;
	private String address;

}
