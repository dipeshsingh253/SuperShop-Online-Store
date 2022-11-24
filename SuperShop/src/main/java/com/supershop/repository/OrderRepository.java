package com.supershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supershop.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
