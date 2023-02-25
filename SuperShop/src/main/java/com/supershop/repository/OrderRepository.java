package com.supershop.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.supershop.model.Order;
import com.supershop.model.User;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	List<Order> findByUser(User user);

}
