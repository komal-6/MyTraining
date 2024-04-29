package com.example.departmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.controller",
								"com.example.services",
								"com.example.departmentservicesimpl",
								"com.example.model"})
@EntityScan(basePackages = {"com.example.model"})
@EnableJpaRepositories("com.example.departmentrepository")
public class DepartmentserviceApplication {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DepartmentserviceApplication.class, args);
	}
	
}
