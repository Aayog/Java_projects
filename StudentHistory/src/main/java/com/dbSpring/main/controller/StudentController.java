package com.dbSpring.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	
	@RequestMapping({"/","/index"})
	public String getWelcome() {
		return "welcome";
	}
	@RequestMapping("/add")
	public String addStudent() {
		return "add";
	}
	@RequestMapping("/submit")
	public String submitForm() {
		return "redirect:/display";
	}
	@RequestMapping("/display")
	public String displayAll() {
		return "display";
	}
}
