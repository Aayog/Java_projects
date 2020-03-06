package com.myshowbooking.main.movie.controller;

import java.security.Principal;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/login")
	public String getlogin() {
		return "login";
	}
	
	@RequestMapping(value="/dash")
	public String getIndex(@AuthenticationPrincipal Principal principal) {
		
		return "redirect:/index";
	}
	
	@RequestMapping(value="/index")
	public String getIndex1(@AuthenticationPrincipal Principal principal) {
		return "index";
	}
}
