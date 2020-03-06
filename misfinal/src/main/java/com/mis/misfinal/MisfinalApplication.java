package com.mis.misfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class MisfinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MisfinalApplication.class, args);
	}
}
