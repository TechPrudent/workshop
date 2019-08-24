package com.thoughtworks.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.thoughtworks.domain.rating.login.User;
import com.thoughtworks.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	static Map<String, User> users = null;

	static {
		users = new HashMap<>();
		String randomUserId = getRandomUserId();
		users.put(randomUserId, new User(randomUserId, "user1", "user", ""));
		String randomUserId1 = getRandomUserId();
		users.put(randomUserId1, new User(randomUserId1, "user1", "user", ""));
	}

	// oauth2 purpose
	private static String generateAuthKey() {
		return UUID.randomUUID().toString();
	}

	private static String getRandomUserId() {
		return UUID.randomUUID().toString();
	}

	public List<User> getAllUsers() {
		return users.entrySet().stream().map(m -> m.getValue()).collect(Collectors.toList());
	}

	public User getUser(String id) {
		return users.entrySet().stream().filter(u -> u.getKey().equals(id)).findFirst().get().getValue();
	}

	@Override
	public boolean register(User user) {
		try {
			User newUser = new User(getRandomUserId(), user.getName(), user.getType(), user.getPassword());
			users.put(getRandomUserId(), newUser);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public User saveUserPaymentMethod(User user) {
		User user2 = null;
		if (null != user.getPreferredPaymentMethod()) {
			user2 = users.get(user.getId());
			user2.setPreferredPaymentMethod(user.getPreferredPaymentMethod());
			users.put(user2.getId(), user2);
		}
		return user2;
	}
}
