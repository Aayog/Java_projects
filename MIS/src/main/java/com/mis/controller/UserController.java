package com.mis.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	
	
	@PostMapping(value="/dashboard")
	public String getDashBoard(@AuthenticationPrincipal UserDetails userDetails) {
		System.out.println(userDetails.getUsername());
		return "dashboard";
	}
	
}
