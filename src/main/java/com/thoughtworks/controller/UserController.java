package com.thoughtworks.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtworks.domain.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@PostMapping("/login")
	User loginUser(@RequestBody User user) {
		
		if(user.getType().equals("guest")) {
			System.out.println("Guest user log in is successful");
			return user;
		} else {
			System.out.println("user is not a guest user");
		}
		return null;
	}
	
	
}