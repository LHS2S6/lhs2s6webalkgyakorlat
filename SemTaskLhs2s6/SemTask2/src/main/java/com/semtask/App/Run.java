package com.semtask.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Run extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Run.class, args);
	}

}
