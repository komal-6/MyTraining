package com.test.docker.dockerdemo.dockercontroller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {
	
	@RequestMapping("/")
	public Map<String, Object> getValues(){
		Map<String, Object> data = new HashMap<>();
		data.put("message", "Java API is working");
		data.put("languages", Arrays.asList("Java","Python","JavScript"));
		data.put("Code", 7854);
		return data;
		
	}
	
}
