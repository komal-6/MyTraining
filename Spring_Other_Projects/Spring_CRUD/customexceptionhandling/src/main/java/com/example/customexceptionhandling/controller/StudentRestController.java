package com.example.customexceptionhandling.controller;

import com.example.customexceptionhandling.entity.Student;
import com.example.customexceptionhandling.entity.StudentErrorResponse;
import com.example.customexceptionhandling.entity.StudentNotFoundException;
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

    //Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){

        //Create StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //Return RepsonseEntity
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    //Add another exception handler...to catch any exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception e){
        //Create StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("400 bad request message");
        error.setTimeStamp(System.currentTimeMillis());

        //Return RepsonseEntity

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
