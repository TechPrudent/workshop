package com.thoughtworks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtworks.domain.rating.login.GuestLogin;
import com.thoughtworks.domain.rating.login.LoginResponse;
import com.thoughtworks.domain.rating.login.User;

@RestController
@RequestMapping("/user")
public class UserController {

	private static LoginResponse loginFailureResponse() {
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setCode(401);
		loginResponse.setMessage("failure");
		return loginResponse;
	}

	private static LoginResponse loginSuccessResponse() {
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setCode(200);
		loginResponse.setMessage("success");
		return loginResponse;
	}

	private GuestLogin guestLogin; // add more login types if required

	@Autowired
	public UserController(GuestLogin guestLogin) {
		super();
		this.guestLogin = guestLogin;
	}

	@PostMapping("/login")
	public LoginResponse loginUser(@RequestBody User user) {
		if (user.getType().equals("guest") && guestLogin.login(user)) {
			return loginSuccessResponse();
		}
		return loginFailureResponse();
	}

}