package com.ignek.SpringDataRest.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "students",path="students")
public interface Studentdao extends JpaRepository<Student, Integer>{

}
