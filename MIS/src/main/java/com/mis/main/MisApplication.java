package com.mis.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
@ComponentScan("com.mis")
public class MisApplication {

	public static void main(String[] args) {
		SpringApplication.run(MisApplication.class, args);
	}
	@Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }
}
