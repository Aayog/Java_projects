package com.example.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.main.daoservices.StudentDaoServices;
import com.example.main.model.StudentModel;

@Controller
public class StudentController {
	
	@Autowired
	StudentDaoServices studentDaoServices;
	
	
	@RequestMapping(value="/insert")
	public String insertUser(Model model) {
		
		// manually setting model to sent to database
		StudentModel studentModel=new StudentModel();
		studentModel.setFname("test");
		studentModel.setLname("demo");
		studentModel.setAddress("demo");
		studentModel.setId(-1);
		
		// .save method is called using jpa repository which return the inserted model if successfully inserted !!!
		StudentModel returnModel=studentDaoServices.save(studentModel);
		
		//displaying the data which is return from database after successful save !!!
		System.out.println(returnModel.getFname());
		System.out.println(returnModel.getLname());
		
		
		// getting model object once with object and value stored in them !!!
		System.out.println("printing to String !!!"+returnModel.toString());
		
		
		return "result";
		
	}

}
