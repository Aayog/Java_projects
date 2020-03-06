package com.myshowbooking.main.userservice.dao;

import com.myshowbooking.main.user.model.User;

public interface UserServiceDao {
	
	User findByUsername(String username);

}
