package com.supershop.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supershop.dto.UserDto;
import com.supershop.exception.CurrentUserServiceException;
import com.supershop.exception.UserException;
import com.supershop.model.CurrentUserSession;
import com.supershop.model.User;
import com.supershop.repository.CurrentUserSessionRepository;
import com.supershop.repository.UserRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class CurrentUserSessionServiceImpl implements CurrentUserSessionService {

	@Autowired
	private CurrentUserSessionRepository currentUserSessionRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void loginUser(UserDto userDto) throws UserException, CurrentUserServiceException {

		User user = userRepository.findByEmail(userDto.getEmail());

		if (user == null) {
			throw new UserException("User does not exists with given email :" + userDto.getEmail());
		}

		CurrentUserSession currenUserSession = currentUserSessionRepository.findByEmail(userDto.getEmail());

		if (currenUserSession != null) {
			throw new CurrentUserServiceException("User already logged in");
		}

		CurrentUserSession newUserSession = new CurrentUserSession(user.getId(), LocalDateTime.now(),
				RandomString.make(12), user.getRole(), user.getEmail());

		currentUserSessionRepository.save(newUserSession);

		System.out.println("Session Started successfully");

	}

	@Override
	public void logoutUser(String authenticationToken) throws UserException, CurrentUserServiceException {

		if (!isLoggedIn(authenticationToken)) {
			throw new CurrentUserServiceException("User not logged in");
		}

		CurrentUserSession currenUserSession = currentUserSessionRepository
				.findByAuthenticationToken(authenticationToken);

		currentUserSessionRepository.delete(currenUserSession);

		System.out.println("Log out successfull");

	}

	@Override
	public boolean isLoggedIn(String authenticationToken) {

		CurrentUserSession currenUserSession = currentUserSessionRepository
				.findByAuthenticationToken(authenticationToken);

		if (currenUserSession == null) {
			return false;
		}

		return true;

	}

	@Override
	public boolean isAdmin(String authenticationToken) throws CurrentUserServiceException {

		CurrentUserSession currenUserSession = currentUserSessionRepository
				.findByAuthenticationToken(authenticationToken);

		if (currenUserSession.getRole().equals("admin")) {
			return true;
		}

		return false;
	}

}
