package com.thoughtworks.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtworks.domain.LoginStrategy;
import com.thoughtworks.domain.User;
import com.thoughtworks.domain.user.GuestLogin;
import com.thoughtworks.domain.user.LoginResponse;

@RestController
@RequestMapping("/user")
public class UserController {

	@PostMapping("/login")
	LoginResponse loginUser(@RequestBody User user) {
		if (user.getType().equals("guest")) {
			/* strategy patter */
			LoginStrategy strategy = new GuestLogin();
			if (strategy.login(user)) {
				return new LoginResponse("success", 200);
			}
		}
		return new LoginResponse("User is not a guest user", 401);
	}

}