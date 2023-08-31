package com.Integration.springbootIntegration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Integration.springbootIntegration.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student save(Optional<Student> updateStudent);

}
