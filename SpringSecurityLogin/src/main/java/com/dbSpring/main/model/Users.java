package com.dbSpring.main.model;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Users {

	private String username;
	private String password;
}
