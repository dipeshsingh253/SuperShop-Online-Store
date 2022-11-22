package com.supershop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.supershop.dto.UserDto;
import com.supershop.exception.CartException;
import com.supershop.exception.UserException;
import com.supershop.model.Cart;
import com.supershop.model.User;
import com.supershop.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/users")
	public ResponseEntity<User> registerUser(@RequestBody UserDto userDto) throws UserException {

		User user = userService.registerUser(userDto);

		return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);

	}

	@PutMapping("/users")
	public ResponseEntity<User> updateUser(@RequestBody UserDto userDto) throws UserException {

		User user = userService.updateUser(userDto);

		return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);

	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) throws UserException {

		User user = userService.getUserById(id);

		return new ResponseEntity<User>(user, HttpStatus.OK);

	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() throws UserException {

		List<User> users = userService.getAllUsers();

		return new ResponseEntity<List<User>>(users, HttpStatus.OK);

	}

	@GetMapping("/user/cart/{id}")
	public ResponseEntity<Cart> getCartByUserId(@PathVariable("id") Integer id) throws UserException, CartException {

		Cart cart = userService.getCartByUserId(id);

		return new ResponseEntity<Cart>(cart, HttpStatus.OK);

	}

	@DeleteMapping("user/{id}")
	public ResponseEntity<User> deleteUserById(@PathVariable("id") Integer id) throws UserException {

		User user = userService.removeUser(id);

		return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);

	}

}
