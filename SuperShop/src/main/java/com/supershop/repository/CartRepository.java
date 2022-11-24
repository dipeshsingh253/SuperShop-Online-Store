package com.supershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supershop.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

}
