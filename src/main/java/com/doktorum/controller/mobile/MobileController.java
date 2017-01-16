package com.doktorum.controller.mobile;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doktorum.model.User;
import com.doktorum.service.UserService;

@RestController
@RequestMapping("/mobile")
public class MobileController {
	@Autowired
	UserService userService;
	private static final Logger logger = Logger.getLogger(MobileController.class);
	@RequestMapping(method=RequestMethod.POST,value="login")
	public User login(
			@RequestParam(name="email",required=false,defaultValue="")String email,
			@RequestParam(name="password",required=false,defaultValue="")String password){
		User user = userService.getTestUser(email, password);
		if(user==null){
			user = new User();
			user.setEmail("Null User");
		}
		return user;
	}
	
}
