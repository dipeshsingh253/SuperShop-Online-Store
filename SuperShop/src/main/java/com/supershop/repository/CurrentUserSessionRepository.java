package com.supershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.supershop.model.CurrentUserSession;

public interface CurrentUserSessionRepository extends JpaRepository<CurrentUserSession, Integer>{
	
	CurrentUserSession findByEmail(String email);
	
	CurrentUserSession findByAuthenticationToken(String token);
}
