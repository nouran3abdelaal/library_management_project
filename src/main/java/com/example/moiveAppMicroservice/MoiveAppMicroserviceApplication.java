package com.example.moiveAppMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.example.moiveAppMicroservice.advice.CustomJwtExceptionHandling")

public class MoiveAppMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoiveAppMicroserviceApplication.class, args);
	}

}
