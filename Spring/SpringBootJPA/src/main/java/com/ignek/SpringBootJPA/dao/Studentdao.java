package com.ignek.SpringBootJPA.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import com.ignek.SpringBootJPA.model.Student;

public interface Studentdao extends JpaRepository<Student, Integer>{

	/*
	 * List<Student> findByTechnology(String technology); List<Student>
	 * findBySidGreaterThan(int sid);
	 * 
	 * @Query("from Student where technology=?1 order by sname") //JPQL Query
	 * List<Student> findByTechSorted(String technology);
	 */
}
