package com.example.springMVCsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome(){
         return "home";
    }

    //Request for leaders
    @GetMapping("/leaders")
    public String showLeaders(){
        return "leaders";
    }

    //Request for admin
    @GetMapping("/admin")
    public String showAdmin(){
        return "admin";
    }
}
