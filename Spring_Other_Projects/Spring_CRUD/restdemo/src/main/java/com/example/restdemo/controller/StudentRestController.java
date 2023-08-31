package com.example.restdemo.controller;

import com.example.restdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> listStudents;

    @PostConstruct
    public void loadData(){
        listStudents = new ArrayList<>();
        listStudents.add(new Student("Komal","Panchal"));
        listStudents.add(new Student("Piya","Panchal"));
        listStudents.add(new Student( "Kavya","Patel"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return listStudents;
    }


    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id){
        return listStudents.get(id);
    }
}
