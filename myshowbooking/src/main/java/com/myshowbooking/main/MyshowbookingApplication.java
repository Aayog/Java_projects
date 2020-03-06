package com.myshowbooking.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude= {JpaRepositoriesAutoConfiguration.class,HibernateJpaAutoConfiguration.class})

@ImportResource("classpath:/spring/spring-database-configuration.cfg.xml")
public class MyshowbookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyshowbookingApplication.class, args);
	}
}
