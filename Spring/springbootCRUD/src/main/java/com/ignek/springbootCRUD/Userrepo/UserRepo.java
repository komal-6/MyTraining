package com.ignek.springbootCRUD.Userrepo;

import org.springframework.data.repository.CrudRepository;

import com.ignek.springbootCRUD.model.User;

public interface UserRepo extends CrudRepository<User, Integer>{

	User getOne(int uid);


}
