package com.myshowbooking.main.userservice;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.myshowbooking.main.user.model.User;


public interface UserService extends UserDetailsService{
	
	User findByUserName(String username);

}
