package com.dbSpring.main.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="student_education_history")
@NoArgsConstructor
@AllArgsConstructor
public class StudentHistoryModel {
	@Id
	private int id;
	private String student_id;
	private String college_school_name;
	private String address_school_college;
	private String university;
	private String datefrom;
	private String dateto;
	private String qualification;
	private String grade_percentage;
}
