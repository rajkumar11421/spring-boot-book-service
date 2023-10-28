package com.book.service.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.employee")
@EntityScan("com.employee.entity")
@EnableJpaRepositories("com.employee.repository")
public class MainApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
	      SpringApplication.run(MainApplication.class, args);
	  }
}
