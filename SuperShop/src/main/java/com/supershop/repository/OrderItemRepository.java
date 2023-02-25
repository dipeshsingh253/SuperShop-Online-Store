package com.supershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supershop.model.OrderProduct;

public interface OrderItemRepository extends JpaRepository<OrderProduct, Integer> {
	
	

}
