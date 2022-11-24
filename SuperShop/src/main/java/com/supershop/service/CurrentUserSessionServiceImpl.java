package com.supershop.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supershop.dto.UserDto;
import com.supershop.exception.CurrentUserServiceException;
import com.supershop.exception.UserException;
import com.supershop.model.CurrenUserSession;
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

		CurrenUserSession currenUserSession = currentUserSessionRepository.findByEmail(userDto.getEmail());

		if (currenUserSession != null) {
			throw new CurrentUserServiceException("User already logged in");
		}

		CurrenUserSession newUserSession = new CurrenUserSession(user.getId(), LocalDateTime.now(),
				RandomString.make(12), user.getRole(), user.getEmail());

		currentUserSessionRepository.save(newUserSession);

		System.out.println("Session Started successfully");

	}

	@Override
	public void logoutUser(String authenticationToken) throws UserException, CurrentUserServiceException {

		if (!isLoggedIn(authenticationToken)) {
			throw new CurrentUserServiceException("User not logged in");
		}

		CurrenUserSession currenUserSession = currentUserSessionRepository
				.findByAuthenticationToken(authenticationToken);

		currentUserSessionRepository.delete(currenUserSession);

		System.out.println("Log out successfull");

	}

	@Override
	public boolean isLoggedIn(String authenticationToken) {

		CurrenUserSession currenUserSession = currentUserSessionRepository
				.findByAuthenticationToken(authenticationToken);

		if (currenUserSession == null) {
			return false;
		}

		return true;

	}

	@Override
	public boolean isAdmin(String authenticationToken) throws CurrentUserServiceException {

		CurrenUserSession currenUserSession = currentUserSessionRepository
				.findByAuthenticationToken(authenticationToken);

		if (currenUserSession.getRole().equals("admin")) {
			return true;
		}

		return false;
	}

}
