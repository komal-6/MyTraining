package com.Integration.springbootIntegration2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.Integration.springbootIntegration2.model.Student;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class StudentDetailsService {

   WebClient webClient;
   
   Logger log = LoggerFactory.getLogger(StudentDetailsService.class);
	
	  @Autowired 
	  public StudentDetailsService(WebClient.Builder webClientBuilder) 
	  {
		  	this.webClient = webClientBuilder.build(); 
	  }
	 
	public JsonNode getAllStudents()

	{
		JsonNode getStudents = webClient.method(HttpMethod.GET)
			.uri("http://localhost:8080/student/getStudents")
			.retrieve()
			.bodyToMono(JsonNode.class)
			.block();
		System.out.println(getStudents);
		return getStudents;
	}
	
	
	public JsonNode getStudentfindById(int studentId) {
		JsonNode getStudentById = webClient.get()
				.uri("http://localhost:8080/student/getStudent/" + studentId)
				.retrieve()
				.bodyToMono(JsonNode.class)
				.block();
			System.out.println(getStudentById);
			return getStudentById;
	}

	 Student student = new Student("Roshni","Roshni@gmail.com");

	 public void addStudent() { 
		 webClient.post()
		 .uri("http://localhost:8080/student/addStudent")
		 .contentType(MediaType.APPLICATION_JSON)
		 .accept(MediaType.APPLICATION_JSON)
		 .body(Mono.just(student), Student.class)
		 .retrieve()
		 .bodyToMono(JsonNode.class)
		 .block();
	 }
	 
	

	Student student1 = new Student("Roshni","roshni1245@gmail.com");
	public void update(int studentId)
   {
		webClient.put()
				.uri("http://localhost:8080/student/updateStudent/" +studentId)
			    .contentType(MediaType.APPLICATION_JSON)
			    .accept(MediaType.APPLICATION_JSON)
			    .body(Mono.just(student1),Student.class)
			    .retrieve()
			    .bodyToMono(JsonNode.class)
			    .block();
	}

	
	  public void delete(int studentId) { 
		  Void id = webClient.delete()
				  			.uri("http://localhost:8080/springbootIntegration/student/deleteStudent/"+studentId) 
				  			.retrieve() 
				  			.bodyToMono(Void.class).block();
		  log.info("Successfully deleted");
		 }
	 
}
