package com.supershop.service;

import com.supershop.dto.UserDto;
import com.supershop.exception.UserException;
import com.supershop.model.User;

public interface UserService {

	User registerUser(UserDto userDto) throws UserException;

	User updateUser(UserDto userDto) throws UserException;

	User removeUser(Integer userId) throws UserException;

	User getUserById(Integer userId) throws UserException;

	User getAllUsers() throws UserException;

}
