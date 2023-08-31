	package com.Integration.springbootIntegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.Integration.springbootIntegration.model.Student;

@SpringBootApplication
public class SpringbootIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootIntegrationApplication.class, args);
	}

	
}
