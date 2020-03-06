package com.example.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "studentinfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String fname;

	private String lname;

	private String address;
	
}
