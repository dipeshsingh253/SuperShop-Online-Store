package com.supershop.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supershop.dto.CartDto;
import com.supershop.dto.OrderDto;
import com.supershop.exception.CartException;
import com.supershop.exception.CurrentUserServiceException;
import com.supershop.exception.OrderException;
import com.supershop.exception.UserException;
import com.supershop.helper.Helper;
import com.supershop.model.Cart;
import com.supershop.model.CurrentUserSession;
import com.supershop.model.Order;
import com.supershop.model.OrderItem;
import com.supershop.model.Payment;
import com.supershop.model.Product;
import com.supershop.model.User;
import com.supershop.repository.*;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CurrentUserSessionRepository currentUserSessionRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Transactional
	@Override
	public void makeOrder(OrderDto orderDto, String authenticationToken)
			throws OrderException, UserException, CurrentUserServiceException, CartException {

		if (!Helper.isLoggedIn(authenticationToken, currentUserSessionRepository)) {
			throw new CurrentUserServiceException("login required");

		}
		/// this way a customer can only book products for their self just like real
		/// worlds and admins are also not allowed to make orders for anyone else except
		/// themselves

		CurrentUserSession session = currentUserSessionRepository.findByAuthenticationToken(authenticationToken);

		Optional<User> optionalUser = userRepository.findById(session.getUserId());

		if (optionalUser.isEmpty()) {
			throw new UserException("No users exists with the given id" + orderDto.getUserId());
		}

		User user = optionalUser.get();

		List<Cart> cart = cartRepository.findByUserOrderByCreateDateTimeDesc(user);

		if (cart.isEmpty()) {
			throw new CartException("Cannot Process on empty cart");
		}

		Payment payment = new Payment();

		payment.setPaymentMethod(orderDto.getPaymentMethod());

		String paymentStatus = "pending";

		payment.setPaymentStatus(paymentStatus);

		if (orderDto.getPaymentMethod().equals("online-payment")) {
			paymentStatus = "success";
			payment.setPaymentStatus(paymentStatus);
		}

		Order newOrder = new Order();

		newOrder.setCreateDateTime(LocalDateTime.now());
		newOrder.setUser(user);
		newOrder.setOrderStatus("pending");
		newOrder.setPayment(payment);

		orderRepository.save(newOrder);

		Double totalAmount = 0.0;

		for (Cart c : cart) {

			OrderItem orderItem = new OrderItem();

			orderItem.setCreateDateTime(LocalDateTime.now());
			orderItem.setOrder(newOrder);
			orderItem.setProduct(c.getProduct());
			orderItem.setQuantity(c.getQuantity());
			orderItem.setTotalPrice(c.getProduct().getPrice() * c.getQuantity());

			totalAmount += c.getQuantity() * c.getProduct().getPrice();

			orderItemRepository.save(orderItem);
		}
		payment.setAmount(totalAmount);
		orderRepository.save(newOrder);

		cartRepository.deleteByUser(user);
	}

	@Override
	public List<Order> listOrdersByUserId(Integer userId, String authenticationToken)
			throws OrderException, UserException, CurrentUserServiceException {

		if (!Helper.isLoggedIn(authenticationToken, currentUserSessionRepository)) {
			throw new CurrentUserServiceException("login required");

		}
		Optional<User> optionalUser;
		if (!Helper.isAdmin(authenticationToken, currentUserSessionRepository)) {
			CurrentUserSession session = currentUserSessionRepository.findByAuthenticationToken(authenticationToken);
			optionalUser = userRepository.findById(session.getUserId());
		} else {
			optionalUser = userRepository.findById(userId);
		}

		if (optionalUser.isEmpty()) {
			throw new UserException("No users exists with the given id" + userId);
		}

		User user = optionalUser.get();

		List<Order> orders = user.getOrders();

		if (orders.isEmpty()) {
			throw new OrderException("No orders available");
		}

		return orders;
	}

	@Override
	public List<Order> listAllOrders(String authenticationToken)
			throws OrderException, UserException, CurrentUserServiceException {

		if (!Helper.isLoggedIn(authenticationToken, currentUserSessionRepository)) {
			throw new CurrentUserServiceException("login required");

		}

		if (!Helper.isAdmin(authenticationToken, currentUserSessionRepository)) {
			throw new CurrentUserServiceException("you are not allowed to perform this action");

		}

		List<Order> allOrders = orderRepository.findAll();

		if (allOrders.isEmpty()) {
			throw new OrderException("no orders avalilable");
		}

		return allOrders;
	}

}
