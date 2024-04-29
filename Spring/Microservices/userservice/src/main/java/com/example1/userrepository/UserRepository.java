package com.example1.userrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example1.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
