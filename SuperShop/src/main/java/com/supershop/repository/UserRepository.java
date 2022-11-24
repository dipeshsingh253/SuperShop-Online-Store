package com.supershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supershop.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByEmail(String email);
	
}
