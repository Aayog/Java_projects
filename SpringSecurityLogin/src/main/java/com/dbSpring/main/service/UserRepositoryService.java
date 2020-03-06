package com.dbSpring.main.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbSpring.main.model.Users;

public interface UserRepositoryService extends JpaRepository<Users, Integer>{
	
}
