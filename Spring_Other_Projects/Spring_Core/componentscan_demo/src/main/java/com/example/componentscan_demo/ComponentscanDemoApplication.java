package com.example.componentscan_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@SpringBootApplication(
		scanBasePackages = {"com.example.componentscan_demo","com.example.util"}
)*/
@SpringBootApplication
public class ComponentscanDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComponentscanDemoApplication.class, args);
	}

}
