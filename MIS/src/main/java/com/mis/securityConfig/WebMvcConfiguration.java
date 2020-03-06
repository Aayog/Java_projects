package com.mis.securityConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("com.mis")
public class WebMvcConfiguration implements WebMvcConfigurer {
	 @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/sign-in").setViewName("sign-in");
	    }

}
