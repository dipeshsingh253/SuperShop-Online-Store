package com.supershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supershop.model.CurrenUserSession;

public interface CurrentUserSessionRepository extends JpaRepository<CurrenUserSession, Integer>{
	
	CurrenUserSession findByEmail(String email);
	
	CurrenUserSession findByAuthenticationToken(String token);
}
