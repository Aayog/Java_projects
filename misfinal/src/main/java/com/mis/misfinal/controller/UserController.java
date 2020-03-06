package com.mis.misfinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	
	@RequestMapping(value= {"/index"})
	public String posttDashBoard() {
		//System.out.println(userDetails.getUsername());
		return "index";
	}
	
	@RequestMapping(value= {"/sign-in"})
	public String posttDas1hBoard() {
		//System.out.println(userDetails.getUsername());
		return "sign-in";
	}
}
