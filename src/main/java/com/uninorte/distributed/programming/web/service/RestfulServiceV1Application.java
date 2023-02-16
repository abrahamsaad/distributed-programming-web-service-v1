package com.uninorte.distributed.programming.web.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.uninorte.distributed.programming.web.service")
public class RestfulServiceV1Application {

	public static void main(String[] args) {
		SpringApplication.run(RestfulServiceV1Application.class, args);
	}

}
