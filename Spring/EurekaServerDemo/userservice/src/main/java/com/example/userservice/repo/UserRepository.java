package com.example.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.userservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
