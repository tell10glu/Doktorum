package com.doktorum.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doktorum.model.User;
import com.doktorum.repository.UserRepository;

@Service
public class UserService {
	private static final Logger logger = Logger.getLogger(UserService.class);
	
	UserRepository userRepository;
	public User getTestUser(String email,String password){
		if(email.isEmpty() || password.isEmpty()){
			return null;
		}
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setId(1);
		logger.debug("returning test user :"+user.toString());
		return user;
	}
	public User getTestUser(boolean isDoctor){
		User user = new User();
		user.setId(1);
		user.setEmail("test@test.com");
		user.setPassword("testsifre");
		user.setDoctor(isDoctor);
		return user;
	}
}
