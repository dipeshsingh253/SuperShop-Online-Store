package com.supershop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supershop.model.Cart;
import com.supershop.model.Product;
import com.supershop.model.User;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	Cart findByUserAndProduct(User user, Product product);

	List<Cart> findByUserOrderByCreateDateTimeDesc(User user);

	void deleteByUser(User user);

}
