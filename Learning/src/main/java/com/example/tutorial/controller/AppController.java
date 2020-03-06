package com.example.tutorial.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tutorial.model.StudentModel;

@Controller
public class AppController {
	public List<StudentModel> students = new ArrayList<>();
	
	@GetMapping({"/hello","/"})
	public String getHello() {
		return "Hello";
	}
	
	@RequestMapping(value="/AddStudent")
	public String getAddStudent() {
		return "addStudent";
	}
	
	@RequestMapping(value="/submitForm")
	public String submittedForm(@ModelAttribute StudentModel studentModel, Model model) {
		students.add(studentModel);
		model.addAttribute("students", students);
		return "display";
	}
	
	
}
