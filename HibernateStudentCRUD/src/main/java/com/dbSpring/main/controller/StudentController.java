package com.dbSpring.main.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dbSpring.main.model.StudentModel;
import com.dbSpring.main.service.StudentServices;

@Controller
public class StudentController {
	@Autowired
	StudentServices studentServices;
	
	@RequestMapping({"/","/index"})
	public String getIndex() {
		return "index";
	}
	
	@RequestMapping("/add")
	public String getAdd() {
		return "add";
	}
	
	@RequestMapping(value = "/submit", method  = RequestMethod.POST)
	public String submitToDatabase(@ModelAttribute StudentModel studentModel) {
		studentServices.save(studentModel);
		return "redirect:/display";
	}
	
	@RequestMapping(value = "/submitUpdate", method  = RequestMethod.POST)
	public String updateToDatabase(@ModelAttribute StudentModel returnModel) {
		studentServices.update(returnModel);
		return "redirect:/display";
	}
	
	@RequestMapping("/display")
	public String getDisplay(Model model) {
		model.addAttribute("list",(ArrayList<StudentModel>) studentServices.getAllStudent());
		return "display";
	}
	
	@RequestMapping(value = "/delete", method  = RequestMethod.POST)
	public String deleteStudent(@RequestParam(value="delete",required =true) String id) {
		studentServices.deleteById(id);
		return "redirect:/display";
	}
	@RequestMapping(value="/update" , method  = RequestMethod.POST)
	public String updateStudent(@RequestParam(value="update",required =true) String id,Model model) {
		model.addAttribute("list",(ArrayList<StudentModel>) studentServices.getAllStudent());
		
		model.addAttribute("studentModel",studentServices.getStudentById(id));
		return "display";
	}
}

