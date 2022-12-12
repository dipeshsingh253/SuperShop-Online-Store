package com.supershop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supershop.model.Cart;
import com.supershop.model.User;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	List<Cart> findAllByUserOrderByCreatedTimeDesc(User user);

	List<Cart> deleteByUser(User user);

}
