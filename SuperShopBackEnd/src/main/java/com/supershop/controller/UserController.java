package com.supershop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.supershop.dto.SignInDto;
import com.supershop.dto.SignUpDto;
import com.supershop.service.UserService;



@CrossOrigin("http://localhost:8080/")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("users")
	public void signUpUser(@RequestBody SignUpDto signUpDto) {

		userService.signUp(signUpDto);

	}

	@PostMapping("/signin")
	public String signInUser(@RequestBody SignInDto signInDto) {

		return userService.signIn(signInDto);

	}

}
