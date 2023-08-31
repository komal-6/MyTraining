package com.Integration.springbootIntegration.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.Integration.springbootIntegration.SpringbootIntegrationApplication;
import com.Integration.springbootIntegration.model.Student;
import com.Integration.springbootIntegration.repository.StudentRepository;

import lombok.extern.slf4j.Slf4j;

@Service

public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	List<Student> list = new ArrayList<>();
		//Adding Student
		public Student addStudent(Student student) {
			Student student1 = studentRepository.save(student);
			System.out.println(student1);
			
			return student1;
		}
		
		//GetAll Student
		public List<Student> getStudents(){
			List<Student> student = new ArrayList<Student>();
			studentRepository.findAll().forEach(students -> student.add(students));
			return student;
		}
		
		//Get Student findById
		public Student getStudentById(int studentId) {
			return studentRepository.findById(studentId).get();
		}
		
		
		//Update Student
		public Student saveAndUpdate(int studentId,Student studentDetails) {
			Student student = studentRepository.findById(studentId).get();
			//student.setStudentId(studentDetails.getStudentId());
			student.setName(studentDetails.getName());
			student.setEmail(studentDetails.getEmail());
			return studentRepository.save(student);
		}
		
		//Delete Student
		public void deleteStudent(int studentId) {
			Student s = studentRepository.getReferenceById(studentId);
			studentRepository.delete(s);
		}

}
