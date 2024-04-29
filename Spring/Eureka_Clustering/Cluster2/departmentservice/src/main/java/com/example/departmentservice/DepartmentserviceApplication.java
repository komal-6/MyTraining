package com.example.departmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
//@ComponentScan(basePackages = {"com.example.departmentservice.controller",
//							  "com.example.departmentservice.serviceimpl",
//							  "com.example.departmentservice.services"})
//@EntityScan(basePackages = "com.example.departmentservice.model")
//@EnableJpaRepositories("com.example.departmentservice.repo")
public class DepartmentserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentserviceApplication.class, args);
	}

}
