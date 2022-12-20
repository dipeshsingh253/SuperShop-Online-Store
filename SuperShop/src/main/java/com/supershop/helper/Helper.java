package com.supershop.helper;

import org.springframework.beans.factory.annotation.Autowired;

import com.supershop.model.CurrentUserSession;
import com.supershop.repository.CurrentUserSessionRepository;

public class Helper {


    // this is a helper class which contains two static methods that checks if the user is logged in or not
    // and if the user is logged in then he / she is admin or not
    public static boolean isLoggedIn(String token, CurrentUserSessionRepository currentUserSessionRepository) {

        CurrentUserSession currentUserSession = currentUserSessionRepository.findByAuthenticationToken(token);

        return currentUserSession != null;

    }

    public static boolean isAdmin(String token, CurrentUserSessionRepository currentUserSessionRepository) {

        CurrentUserSession currenUserSession = currentUserSessionRepository.findByAuthenticationToken(token);

        return currenUserSession.getRole().equals("admin");
    }

}
