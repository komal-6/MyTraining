package com.example.restdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestClass {

    @GetMapping("/hello")
    public String helloMethod(){
        return "Hello !!! I am Komal";
    }
}
