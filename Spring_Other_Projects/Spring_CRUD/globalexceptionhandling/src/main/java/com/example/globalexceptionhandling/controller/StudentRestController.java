package com.example.globalexceptionhandling.controller;

import com.example.globalexceptionhandling.entity.Student;
import com.example.globalexceptionhandling.entity.StudentErrorResponse;
import com.example.globalexceptionhandling.entity.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

        if((id > listStudents.size()) ||(id < 0)) {
            throw new StudentNotFoundException("Student id is not found "+id);
        }
        return listStudents.get(id);
    }
}
