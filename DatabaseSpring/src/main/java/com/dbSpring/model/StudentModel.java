package com.dbSpring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="student")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentModel {
	@Id
	private int id;
	private String name;
	private String address;
	
}
