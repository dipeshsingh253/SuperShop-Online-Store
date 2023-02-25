package com.supershop.service;

import com.supershop.dto.MyResponseDto;
import com.supershop.dto.UserDto;
import com.supershop.exception.CurrentUserServiceException;
import com.supershop.exception.UserException;

public interface CurrentUserSessionService {

	public MyResponseDto loginUser(UserDto userDto) throws UserException, CurrentUserServiceException;

	public void logoutUser(String authenticationToken) throws UserException, CurrentUserServiceException;

	public boolean isLoggedIn(String authenticationToken) throws CurrentUserServiceException;

	public boolean isAdmin(String authenticationToken) throws CurrentUserServiceException;
}
