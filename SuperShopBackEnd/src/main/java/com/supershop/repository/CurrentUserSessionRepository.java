package com.supershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supershop.model.CurrentUserSession;
import com.supershop.model.User;

public interface CurrentUserSessionRepository extends JpaRepository<CurrentUserSession, Integer> {

	CurrentUserSession findByUser(User user);

	CurrentUserSession findByToken(String token);

}
