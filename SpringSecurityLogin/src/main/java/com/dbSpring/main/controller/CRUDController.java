package com.dbSpring.main.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dbSpring.main.model.StudentModel;
import com.dbSpring.main.service.StudentServices;

@Controller
public class CRUDController {
	@Autowired
	StudentServices studentServices;

	@RequestMapping(value= {"/","/index"})
	public String getIndex() {
		
		return "redirect:/login";
	}
	
	@RequestMapping("/login")
	public String getLogin() {
		return "login";
	}
	@RequestMapping("/display")
	public String getDisplay(@AuthenticationPrincipal UserDetails userDetails,Model model) {
		Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();
		String role = roles.stream().findFirst().get().toString();
		model.addAttribute("list", studentServices.getAllStudent());
		model.addAttribute("role",role);
		return "display";
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
	
	
	@RequestMapping(value = "/delete", method  = RequestMethod.POST)
	public String deleteStudent(@RequestParam(value="delete",required =true) String id) {
		studentServices.deleteById(id);
		return "redirect:/display";
	}
	@RequestMapping(value="/update" , method  = RequestMethod.POST)
	public String updateStudent(@AuthenticationPrincipal UserDetails userDetails,@RequestParam(value="update",required =true) String id,Model model) {
		Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();
		String role = roles.stream().findFirst().get().toString();
		model.addAttribute("list", studentServices.getAllStudent());
		model.addAttribute("role",role);
		model.addAttribute("studentModel",studentServices.getStudentById(id));
		return "display";
	}
}