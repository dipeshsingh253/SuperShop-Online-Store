package com.supershop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supershop.model.CurrentUserSession;
import com.supershop.model.User;
import com.supershop.repository.CurrentUserSessionRepository;


@Service
public class CurrentuserSessionImpl implements CurrentuserService {

	@Autowired
	private CurrentUserSessionRepository currentUserSessionRepository;

	@Override
	public void authenticate(String token) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUser(String token) {

		CurrentUserSession session = currentUserSessionRepository.findByToken(token);

		User user = session.getUser();

		return user;
	}

}
