package com.supershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supershop.model.CartItem;
import com.supershop.model.Product;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

	CartItem findByProduct(Product product);

}
