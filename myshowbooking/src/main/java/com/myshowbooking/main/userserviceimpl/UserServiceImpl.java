package com.myshowbooking.main.userserviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.myshowbooking.main.user.model.User;
import com.myshowbooking.main.userservice.UserService;
import com.myshowbooking.main.userservice.dao.UserServiceDao;

@Component
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserServiceDao userServiceDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDetails user=userServiceDao.findByUsername(username);
		return new org.springframework.security.core.userdetails.User(user.getUsername(),
	                user.getPassword(),
	                (user.getAuthorities()));
	}

	@Override
	public User findByUserName(String username) {
		User user= userServiceDao.findByUsername(username);
		System.out.println(user.getPassword());
		System.out.println(user.getUsername());
		return user;
	}

}
