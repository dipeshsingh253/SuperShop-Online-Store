package com.supershop.helper;

import org.springframework.beans.factory.annotation.Autowired;

import com.supershop.model.CurrentUserSession;
import com.supershop.repository.CurrentUserSessionRepository;

public class Helper {

	public static boolean isLoggedIn(String token, CurrentUserSessionRepository currentUserSessionRepository) {

		CurrentUserSession currentUserSession = currentUserSessionRepository.findByAuthenticationToken(token);

		if (currentUserSession == null) {
			return false;
		}

		return true;

	}

	public static boolean isAdmin(String token, CurrentUserSessionRepository currentUserSessionRepository) {

		CurrentUserSession currenUserSession = currentUserSessionRepository.findByAuthenticationToken(token);

		if (currenUserSession.getRole().equals("admin")) {
			return true;
		}

		return false;
	}

}
