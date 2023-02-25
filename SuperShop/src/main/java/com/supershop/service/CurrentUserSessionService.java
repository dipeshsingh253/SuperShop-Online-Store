package com.supershop.service;

import com.supershop.dto.MyResponseDto;
import com.supershop.dto.UserDto;
import com.supershop.exception.CurrentUserServiceException;
import com.supershop.exception.UserException;

/**
 * Service for user session functioning.
 */

public interface CurrentUserSessionService {

	/**
	 * Login user.
	 * @param userDto user details mandatory to login
	 * @return ResponseEntity {@link MyResponseDto} to be displayed to the user as response. MyResponseDto contains critical details for user like authenticationToken for user, user is authorized or not.
	 * @throws UserException if user details are not valid or user unavailable
	 * @throws CurrentUserServiceException if user is not authorized or authenticated
	 */
	MyResponseDto loginUser(UserDto userDto) throws UserException, CurrentUserServiceException;

	/**
	 * Log out user.
	 * @param authenticationToken User authentication taken unique for every logged-in user
	 * @throws UserException if user details are not valid or user unavailable
	 * @throws CurrentUserServiceException if user is not authorized or authenticated
	 */
	void logoutUser(String authenticationToken) throws UserException, CurrentUserServiceException;


	/**
	 * Check if the user with given authenticationToken is logged-in or not.
	 * @param authenticationToken User authentication taken unique for every logged-in user
	 * @return Boolean true if user is logged-in else false.
	 */
	boolean isLoggedIn(String authenticationToken) throws CurrentUserServiceException;


	/**
	 * Check if the user with given authenticationToken is authorized(Admin) or not.
	 * @param authenticationToken User authentication taken unique for every logged-in user
	 * @return Boolean true if user is authorized else false.
	 */
	boolean isAdmin(String authenticationToken) throws CurrentUserServiceException;
}
