package com.supershop.service;

import com.supershop.model.User;

public interface CurrentuserService {
	
	public void authenticate(String token);
	
	public User getUser(String token);

}
