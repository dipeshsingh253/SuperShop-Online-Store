package com.supershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supershop.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
