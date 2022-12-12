package com.supershop.controller;

import java.util.List;

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

import com.supershop.dto.MyResponse;
import com.supershop.dto.UserDto;
import com.supershop.exception.CurrentUserServiceException;
import com.supershop.exception.UserException;
import com.supershop.model.User;
import com.supershop.service.CurrentUserSessionService;
import com.supershop.service.UserService;

@CrossOrigin("http://localhost:3000/")
@RestController
public class UserSessionController {

	@Autowired
	private CurrentUserSessionService currentUserSessionService;

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<MyResponse> loginUser(@RequestBody UserDto userDto)
			throws UserException, CurrentUserServiceException {

		MyResponse response = currentUserSessionService.loginUser(userDto);

		return new ResponseEntity<MyResponse>(response, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/logout")
	public ResponseEntity<String> logoutUser(@RequestParam String authenticationToken)
			throws UserException, CurrentUserServiceException {

		currentUserSessionService.logoutUser(authenticationToken);

		return new ResponseEntity<String>("User Logged Out", HttpStatus.OK);

	}

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user) throws UserException {

		userService.registerUser(user);

		return new ResponseEntity<String>("User registered", HttpStatus.ACCEPTED);

	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> listAllUsers(@RequestParam String authenticationToken)
			throws UserException, CurrentUserServiceException {

		List<User> users = userService.listAllUsers(authenticationToken);

		return new ResponseEntity<List<User>>(users, HttpStatus.ACCEPTED);
	}

	@PutMapping("/users")
	public ResponseEntity<String> updateUser(@RequestParam String authenticationToken, @RequestBody User user)
			throws UserException, CurrentUserServiceException {

		userService.updateUser(user, authenticationToken);

		return new ResponseEntity<String>("User updated", HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/users")
	public ResponseEntity<String> deleteUser(@RequestParam String email, @RequestParam String authenticationToken)
			throws UserException, CurrentUserServiceException {

		userService.deleteUser(email, authenticationToken);
		return new ResponseEntity<String>("User deleted", HttpStatus.ACCEPTED);
	}

}
