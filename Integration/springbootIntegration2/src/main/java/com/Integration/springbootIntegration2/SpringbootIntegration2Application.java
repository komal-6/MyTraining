package com.Integration.springbootIntegration2;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.Integration.springbootIntegration2.service.StudentDetailsService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringbootIntegration2Application implements CommandLineRunner{

	@Autowired
	StudentDetailsService studentDetailsService;
	
	Logger logger = LoggerFactory.getLogger(SpringbootIntegration2Application.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringbootIntegration2Application.class, args);
	}

	/*
	 * @Bean public WebClient getWebClient() { return WebClient.builder()
	 * .baseUrl("http://localhost:8080/") .defaultHeader(HttpHeaders.CONTENT_TYPE,
	 * MediaType.APPLICATION_JSON_VALUE) .build(); }
	 */
	
	
	
	  @Override 
	  public void run(String... args) throws Exception 
	  { 
		  
		  //Get All Student Details
		  JsonNode getStudents = studentDetailsService.getAllStudents(); //JsonNode
		  //System.out.println(getStudents);
		  
		  
		  //Get Student By Id
//		  JsonNode getStudent = studentDetailsService.getStudentfindById(2);
		  //System.out.println(getStudent);
		  
			
		  //Add Student
//		  studentDetailsService.addStudent(); 
//		  System.out.println("Inserted");
			  
		  
		  //Update Student
//		  studentDetailsService.update(7);
		  
		  
		  //Delete Student
//		   studentDetailsService.delete(5);
	  }
	 
	 

}