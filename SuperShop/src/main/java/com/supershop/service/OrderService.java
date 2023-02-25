package com.supershop.service;

import java.util.List;
import com.supershop.dto.OrderDto;
import com.supershop.exception.CartException;
import com.supershop.exception.CurrentUserServiceException;
import com.supershop.exception.OrderException;
import com.supershop.exception.UserException;
import com.supershop.model.Order;


/**
 * Service for order functioning.
 */

public interface OrderService {

	/**
	 * This method will create a new order.
	 * @param authenticationToken User authentication taken unique for every logged-in user
	 * @param orderDto Order to be created. OrderDto contains order details.
	 * @throws UserException if user details are not valid or user unavailable
	 * @throws CurrentUserServiceException if user is not authorized or authenticated
	 * @throws CartException if cart does not exist or cart is empty
	 */
	void makeOrder(OrderDto orderDto, String authenticationToken)
			throws  UserException, CurrentUserServiceException, CartException;


	/**
	 * Fetch all orders related to a user id.
	 * @param authenticationToken User authentication taken unique for every logged-in user
	 * @param userId user id to fetch orders for
	 * @return  ResponseEntity {@link List<Order>} to be displayed to the user as response
	 * @throws OrderException if no orders exist
	 * @throws UserException if user details are not valid or user unavailable
	 * @throws CurrentUserServiceException if user is not authorized or authenticated
	 */
	List<Order> listOrdersByUserId(Integer userId, String authenticationToken)
			throws OrderException, UserException, CurrentUserServiceException;



	/**
	 *  Fetch all the orders from order table.
	 * @param authenticationToken User authentication taken unique for every logged-in user
	 * @return  ResponseEntity {@link List<Order>} to be displayed to the user as response
	 * @throws OrderException if no orders exist
	 * @throws UserException if user details are not valid or user unavailable
	 * @throws CurrentUserServiceException if user is not authorized or authenticated
	 */
	List<Order> listAllOrders(String authenticationToken)
			throws OrderException, UserException, CurrentUserServiceException;


	/**
	 * Update order details. This method is authorized only for Admin and Owner.
	 * @param authenticationToken User authentication taken unique for every logged-in user
	 * @param orderDto Order to be updated. OrderDto contains order details.
	 * @throws CurrentUserServiceException if user is not authorized or authenticated
	 * @throws OrderException if no orders exist
	 */
    void updateOrder(OrderDto orderDto,String authenticationToken) throws CurrentUserServiceException, OrderException;
}
