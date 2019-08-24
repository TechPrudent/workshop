package com.thoughtworks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtworks.domain.rating.login.AuthUserLogin;
import com.thoughtworks.domain.rating.login.GuestLogin;
import com.thoughtworks.domain.rating.login.User;
import com.thoughtworks.domain.user.RegisterResponse;
import com.thoughtworks.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private static RegisterResponse registerFailureResponse() {
		RegisterResponse registerResponse = new RegisterResponse();
		registerResponse.setCode(401);
		registerResponse.setMessage("failure");
		return registerResponse;
	}
	private static RegisterResponse registerSuccessResponse() {
		RegisterResponse registerResponse = new RegisterResponse();
		registerResponse.setCode(200);
		registerResponse.setMessage("success");
		return registerResponse;
	}
	private GuestLogin guestLogin; // add more login types if required

	private UserService userService;

	private AuthUserLogin authUserLogin;

	@Autowired
	public UserController(GuestLogin guestLogin, UserService userService, AuthUserLogin authUserLogin) {
		super();
		this.guestLogin = guestLogin;
		this.userService = userService;
		this.authUserLogin = authUserLogin;
	}

	@PostMapping("/login")
	public User loginUser(@RequestBody User user) {
		User login = null;
		if (user.getType().equals("guest")) {
			login = guestLogin.login(user);
		} else if (user.getType().equals("user")) {
			login = authUserLogin.login(user);
		}
		return login;
	}

	@PostMapping("/register")
	public RegisterResponse registerUser(@RequestBody User user) {
		if (this.userService.register(user)) {
			return registerSuccessResponse();
		}

		return registerFailureResponse();
	}

	@PostMapping("/paymentmethod")
	public User saveUserPaymentMethod(@RequestBody User user) {
		return this.userService.saveUserPaymentMethod(user);
	}

}