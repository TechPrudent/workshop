package com.thoughtworks.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.thoughtworks.exceptions.SessionNotValidException;
import com.thoughtworks.service.SessionValidator;

@Component
public class AuthFilter extends OncePerRequestFilter {

	private SessionValidator sessionValidator;

	@Autowired
	public AuthFilter(SessionValidator sessionValidator) {
		super();
		this.sessionValidator = sessionValidator;
	}

	/*
	 * this acts as a auth server where it talks to user service to validate if the
	 * user + user session exist and then filter them accordingly
	 * 
	 * this can be converted into a gateway/ proxy and requests can be downstreamed
	 * to validate the user authorization and authentication
	 * 
	 */

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String sessionId = request.getHeader("sessionId");
		String userId = request.getHeader("userId");

		if (userId == null || sessionId == null) {
			throw new SessionNotValidException("session not valid");
		}

		boolean validateSession = this.sessionValidator.validateSession(userId, sessionId);
		if (!validateSession) {
			throw new SessionNotValidException("session not valid");
		} else {
			filterChain.doFilter(request, response);
		}
	}

}
