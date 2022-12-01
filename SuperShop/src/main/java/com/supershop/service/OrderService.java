package com.supershop.service;

import java.util.List;

import com.supershop.dto.CartDto;
import com.supershop.dto.OrderDto;
import com.supershop.exception.CartException;
import com.supershop.exception.CurrentUserServiceException;
import com.supershop.exception.OrderException;
import com.supershop.exception.UserException;
import com.supershop.model.Order;

public interface OrderService {

	public void makeOrder(OrderDto orderDto, String authenticationToken)
			throws OrderException, UserException, CurrentUserServiceException, CartException;

	public List<Order> listOrdersByUserId(Integer userId, String authenticationToken)
			throws OrderException, UserException, CurrentUserServiceException;

	public List<Order> listAllOrders(String authenticationToken)
			throws OrderException, UserException, CurrentUserServiceException;

}
