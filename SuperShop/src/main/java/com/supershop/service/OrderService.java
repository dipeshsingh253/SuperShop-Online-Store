package com.supershop.service;

import java.util.List;

import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;

import com.supershop.dto.OrderDetailsDto;
import com.supershop.dto.PaymentDto;
import com.supershop.exception.OrderException;
import com.supershop.exception.PaymentException;
import com.supershop.exception.UserException;

public interface OrderService {

	OrderDetailsDto createOrder(PaymentDto paymentDto) throws OrderException, UserException, PaymentException;

	OrderDetailsDto getOrderDetailsByid(Integer orderId) throws OrderException, UserException, PaymentException;

	List<OrderDto> getAllOrders() throws OrderException, UserException, PaymentException;

	OrderDetailsDto updateOrder(Integer orderId) throws UserException, OrderException, PaymentException;

}
