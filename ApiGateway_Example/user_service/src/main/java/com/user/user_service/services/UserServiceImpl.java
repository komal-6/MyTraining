package com.user.user_service.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.user.user_service.entity.User;


@Service
public class UserServiceImpl implements UserService {

		//Fake User List
		  List<User> list = List.of( 
				  new User(11L,"Komal Panchal","58965521"), 
				  new User(12L,"Piya Panchal","9868574"), 
				  new User(13L,"Kavya Panchal","874586") 
				  );
		
					
			@Override 
			public User getUser(Long userId){ 
				return list.stream().filter(user->user.getUserId().equals(userId)).findAny().orElse(null);	  
			}
				
}
