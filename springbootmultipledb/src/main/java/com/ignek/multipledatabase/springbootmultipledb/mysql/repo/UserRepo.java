package com.ignek.multipledatabase.springbootmultipledb.mysql.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ignek.multipledatabase.springbootmultipledb.mysql.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
