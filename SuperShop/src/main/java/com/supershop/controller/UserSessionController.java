package com.supershop.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.supershop.dto.MyResponseDto;
import com.supershop.dto.UserDto;
import com.supershop.exception.CurrentUserServiceException;
import com.supershop.exception.UserException;
import com.supershop.model.User;
import com.supershop.service.CurrentUserSessionService;
import com.supershop.service.UserService;

/**
 * RestController to manage functioning of UserSession.
 */

@CrossOrigin("http://localhost:3000/")
@RestController
public class UserSessionController {

	private final Logger logger = LoggerFactory.getLogger(UserSessionController.class);
	@Autowired
	private CurrentUserSessionService currentUserSessionService;

	@Autowired
	private UserService userService;

	/**
	 * Login user.
	 * @param userDto user details mandatory to login
	 * @return ResponseEntity {@link MyResponseDto} to be displayed to the user as response. MyResponseDto contains critical details for user like authenticationToken for user, user is authorized or not.
	 * @throws UserException if user details are not valid or user unavailable
	 * @throws CurrentUserServiceException if user is not authorized or authenticated
	 */
	@PostMapping("/login")
	public ResponseEntity<MyResponseDto> loginUser(@RequestBody UserDto userDto)
			throws UserException, CurrentUserServiceException {
		logger.info("called loginUser method of CurrentUserSessionService");
		MyResponseDto response = currentUserSessionService.loginUser(userDto);
		logger.info("User Login Successful");
		logger.info("Session Started");

		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

	}

	/**
	 * Log out user.
	 * @param authenticationToken User authentication taken unique for every logged-in user
	 * @return ResponseEntity {@link String} message to be displayed to the user as response
	 * @throws UserException if user details are not valid or user unavailable
	 * @throws CurrentUserServiceException if user is not authorized or authenticated
	 */
	@DeleteMapping("/logout")
	public ResponseEntity<String> logoutUser(@RequestParam String authenticationToken)
			throws UserException, CurrentUserServiceException {

		logger.info("called logoutUser method of CurrentUserSessionService");
		currentUserSessionService.logoutUser(authenticationToken);
		logger.info("User Logged Out");
		logger.info("Session Ended");

		return new ResponseEntity<>("User Logged Out", HttpStatus.OK);

	}

	/**
	 * Register new user.
	 * @param user new user to be registered.
	 * @return ResponseEntity {@link String} message to be displayed to the user as response
	 * @throws UserException if user already exist
	 */
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user) throws UserException {

		userService.registerUser(user);

		logger.info("User Registered");

		return new ResponseEntity<>("User registered", HttpStatus.ACCEPTED);

	}


	/**
	 * Fetch all user available in database. Can only be used by authorized users like Admin and Owner.
	 * @param authenticationToken User authentication taken unique for every logged-in user
	 * @return ResponseEntity {@link List<User>} to be displayed to the user as response
	 * @throws UserException if no user available in database
	 * @throws CurrentUserServiceException if user is not authorized or authenticated
	 */
	@GetMapping("/users")
	public ResponseEntity<List<User>> listAllUsers(@RequestParam String authenticationToken)
			throws UserException, CurrentUserServiceException {

		logger.info("called listAllUsers method of UserService");
		List<User> users = userService.listAllUsers(authenticationToken);
		logger.info("All user details fetched successfully");

		return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
	}


	/**
	 * Update user details.
	 * @param authenticationToken User authentication taken unique for every logged-in user
	 * @param user user to be updated.
	 * @return ResponseEntity {@link String} message to be displayed to the user as response
	 * @throws UserException if user details are not valid or user unavailable
	 * @throws CurrentUserServiceException if user is not authorized or authenticated
	 */
	@PutMapping("/users")
	public ResponseEntity<String> updateUser(@RequestParam String authenticationToken, @RequestBody User user)
			throws UserException, CurrentUserServiceException {

		logger.info("called updateUser method of UserService");
		userService.updateUser(user, authenticationToken);
		logger.info("User Updated");

		return new ResponseEntity<>("User updated", HttpStatus.ACCEPTED);

	}


	/**
	 * Delete user with given email.
	 * @param email user email to identify user. Email is unique for every user.
	 * @param authenticationToken User authentication taken unique for every logged-in user
	 * @return ResponseEntity {@link String} message to be displayed to the user as response
	 * @throws UserException if user details are not valid or user unavailable
	 * @throws CurrentUserServiceException if user is not authorized or authenticated
	 */
	@DeleteMapping("/users")
	public ResponseEntity<String> deleteUser(@RequestParam String email, @RequestParam String authenticationToken)
			throws UserException, CurrentUserServiceException {

		logger.info("called deleteUser method of UserService");
		userService.deleteUser(email, authenticationToken);
		logger.warn("User Deleted");

		return new ResponseEntity<>("User deleted", HttpStatus.ACCEPTED);
	}

}
