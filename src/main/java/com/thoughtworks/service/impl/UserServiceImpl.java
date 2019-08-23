package com.thoughtworks.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.thoughtworks.domain.rating.login.User;
import com.thoughtworks.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	static List<User> users = null;

	static {
		users = new ArrayList<>();
	}

	public List<User> getAllUsers() {
		return users;
	}

	public User getUser(String id) {
		return null;
	}
}
