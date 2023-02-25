package com.supershop.helper;

import com.supershop.model.CurrentUserSession;
import com.supershop.repository.CurrentUserSessionRepository;

/**
 *      This is a helper class which contains two static methods that checks if the user is logged in or not
 *      and if the user is logged in then the user is admin or not
 *      I am mainly validating via authentication authenticationTokens passed by the user with request.
 */

public class Helper {


    /**
     * Check if the user with given authenticationToken is logged-in or not.
     * @param authenticationToken User authentication taken unique for every logged-in user
     * @param currentUserSessionRepository Repository object for accessing CurrentUserSession details.
     * @return Boolean true if user is logged-in else false.
     */
    public static boolean isLoggedIn(String authenticationToken, CurrentUserSessionRepository currentUserSessionRepository) {

        CurrentUserSession currentUserSession = currentUserSessionRepository.findByAuthenticationToken(authenticationToken);

        return currentUserSession != null;

    }

    /**
     * Check if the user with given authenticationToken is authorized(Admin) or not.
     * @param authenticationToken User authentication taken unique for every logged-in user
     * @param currentUserSessionRepository Repository object for accessing CurrentUserSession details.
     * @return Boolean true if user is authorized else false.
     */

    public static boolean isAdmin(String authenticationToken, CurrentUserSessionRepository currentUserSessionRepository) {

        CurrentUserSession currentUserSession = currentUserSessionRepository.findByAuthenticationToken(authenticationToken);

        return currentUserSession.getRole().equals("admin");
    }

}
