package com.supershop.service;

import java.util.List;

import com.supershop.exception.CurrentUserServiceException;
import com.supershop.exception.UserException;
import com.supershop.model.User;

public interface UserService {

	public void registerUser(User user) throws UserException;

	public List<User> listAllUsers(String authenticationToken) throws UserException, CurrentUserServiceException;

	public void updateUser(User user, String authenticationToken) throws UserException, CurrentUserServiceException;

	public void deleteUser(String email, String authenticationToken) throws UserException, CurrentUserServiceException;

}
