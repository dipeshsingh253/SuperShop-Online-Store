package com.supershop.service;

import java.util.List;

import com.supershop.exception.CurrentUserServiceException;
import com.supershop.exception.UserException;
import com.supershop.model.User;


/**
 * Service for user functioning.
 */



public interface UserService {



	/**
	 * Register new user.
	 * @param user new user to be registered.
	 * @throws UserException if user already exist
	 */
	void registerUser(User user) throws UserException;


	/**
	 * Fetch all user available in database. Can only be used by authorized users like Admin and Owner.
	 * @param authenticationToken User authentication taken unique for every logged-in user
	 * @return ResponseEntity {@link List<User>} to be displayed to the user as response
	 * @throws UserException if no user available in database
	 * @throws CurrentUserServiceException if user is not authorized or authenticated
	 */
	List<User> listAllUsers(String authenticationToken) throws UserException, CurrentUserServiceException;


	/**
	 * Update user details.
	 * @param authenticationToken User authentication taken unique for every logged-in user
	 * @param user user to be updated.
	 * @throws UserException if user details are not valid or user unavailable
	 * @throws CurrentUserServiceException if user is not authorized or authenticated
	 */
	void updateUser(User user, String authenticationToken) throws UserException, CurrentUserServiceException;


	/**
	 * Delete user with given email.
	 * @param email user email to identify user. Email is unique for every user.
	 * @param authenticationToken User authentication taken unique for every logged-in user
	 * @throws UserException if user details are not valid or user unavailable
	 * @throws CurrentUserServiceException if user is not authorized or authenticated
	 */
	void deleteUser(String email, String authenticationToken) throws UserException, CurrentUserServiceException;

}
