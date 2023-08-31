package com.example.EurekDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekDemoApplication.class, args);
	}

}
