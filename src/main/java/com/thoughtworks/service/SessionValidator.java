package com.thoughtworks.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class SessionValidator {

	// session data
	public static Map<String, String> sessionMap = null;

	static {
		sessionMap = new HashMap<>();
	}

	public boolean validateSession(String userId, String sessionId) {
		if (userId == null || sessionId == null) {
			return false;
		}

		String sessId = sessionMap.get(userId);
		return sessionId.equals(sessId);
	}

}
