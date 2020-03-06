package com.example.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.main.model.StudentModel;
import com.example.main.services.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService services;
	
	@RequestMapping(value="/sanlama")
	public String saveValue() {
		
		StudentModel model=services.findUserByEmailAddress("sanlama");
		
		System.out.println("adress is "+model.getAddress());
		
		return "page";
	}
	
	
	@RequestMapping(value="/save")
	public String insertValue() {
		
		StudentModel model=new StudentModel();
		model.setFname("test");
		model.setLname("test");
		model.setAddress("test");
		
		StudentModel model1=services.store(model);
		System.out.println("id isadress is "+model1.getId());
		
		return "page";
	}
}
