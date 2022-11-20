package com.supershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supershop.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
