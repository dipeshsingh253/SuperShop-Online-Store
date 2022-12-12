package com.supershop.service;

import com.supershop.dto.SignInDto;
import com.supershop.dto.SignUpDto;

public interface UserService {

	public void signUp(SignUpDto signUpDto);

	public String signIn(SignInDto signInDto);

}
