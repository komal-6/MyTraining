package com.example.departmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class DepartmentserviceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DepartmentserviceApplication.class, args);
	}
}
