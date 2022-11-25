package com.supershop.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supershop.dto.OrderDto;
import com.supershop.exception.CartException;
import com.supershop.exception.CurrentUserServiceException;
import com.supershop.exception.OrderException;
import com.supershop.exception.UserException;
import com.supershop.model.CartItem;
import com.supershop.model.CurrenUserSession;
import com.supershop.model.Order;
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
	private CurrentUserSessionRepository currentUserSessionRepository;

	@Override
	public void makeOrder(OrderDto orderDto, String authenticationToken)
			throws OrderException, UserException, CurrentUserServiceException, CartException {

		if (!isLoggedIn(authenticationToken)) {

			throw new CurrentUserServiceException("login required");

		}
		// System.out.println("hello");
		Optional<Order> existedOrder = orderRepository.findById(orderDto.getOrderId());

		if (!existedOrder.isEmpty()) {
			throw new UserException("Order already exists");
		}

		System.out.println("hello");
		User user = userRepository.findById(orderDto.getUserId()).get();

		if (user == null) {
			throw new UserException("User does not exists with given id :" + orderDto.getUserId());
		}

		List<CartItem> cartItems = user.getCart().getCartItems();

		if (cartItems.isEmpty()) {
			throw new CartException("Unable to process on an empty cart ");
		}

		Double amount = 0.0;

		for (CartItem cartItem : cartItems) {

			Product product = cartItem.getProduct();

			amount += product.getPrice() * cartItem.getQuantity();

		}

		String paymentStatus = "Pending";
		if (orderDto.getPaymentMethod().equals("online-payment")) {
			paymentStatus = "Completed";
		}

		Payment payment = new Payment();
		payment.setPaymentStatus(paymentStatus);
		payment.setPaymentMethod(orderDto.getPaymentMethod());
		payment.setAmount(amount);

		Order order = new Order();
		order.setUser(user);
		order.setPayment(payment);
		order.setOrderStatus("pending");

		orderRepository.save(order);

		System.out.println("Order saved successfully");

	}

	@Override
	public List<Order> listOrdersByUserId(Integer userId, String authenticationToken)
			throws OrderException, UserException, CurrentUserServiceException {

		if (!isLoggedIn(authenticationToken)) {

			throw new CurrentUserServiceException("login required");

		}

		User user = userRepository.findById(userId).get();

		if (user == null) {
			throw new UserException("User does not exists with given id :" + userId);
		}

		List<Order> orders = user.getOrders();

		if (orders.isEmpty()) {
			throw new OrderException("No orders available for given user id :" + userId);
		}

		return orders;
	}

	@Override
	public List<Order> listAllOrders(String authenticationToken)
			throws OrderException, UserException, CurrentUserServiceException {
		// TODO Auto-generated method stub

		if (!isLoggedIn(authenticationToken)) {

			throw new CurrentUserServiceException("login required");

		}

		if (!isAdmin(authenticationToken)) {
			throw new CurrentUserServiceException("Access denied ");
		}
		List<Order> orders = orderRepository.findAll();

		if (orders.isEmpty()) {
			throw new OrderException("No orders exists");
		}

		return orders;

	}

	@Override
	public boolean isLoggedIn(String authenticationToken) {

		CurrenUserSession currenUserSession = currentUserSessionRepository
				.findByAuthenticationToken(authenticationToken);

		if (currenUserSession == null) {
			return false;
		}

		return true;

	}

	@Override
	public boolean isAdmin(String authenticationToken) {

		CurrenUserSession currenUserSession = currentUserSessionRepository
				.findByAuthenticationToken(authenticationToken);
		System.out.println(currenUserSession);

		if (currenUserSession.getRole().equals("admin")) {

			return true;
		}

		return false;
	}

}
