package com.ignek.multipledatabase.springbootmultipledb.postgres.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ignek.multipledatabase.springbootmultipledb.postgres.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
