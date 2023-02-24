package com.supershop.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.supershop.dto.OrderDto;
import com.supershop.exception.CartException;
import com.supershop.exception.CurrentUserServiceException;
import com.supershop.exception.OrderException;
import com.supershop.exception.UserException;
import com.supershop.model.Order;
import com.supershop.service.OrderService;


/**
 * RestController for Order functioning.
 */

@CrossOrigin("http://localhost:3000/")
@RestController
public class OrderController {

    private final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderService orderService;

    /**
     * This method will create a new order.
     * @param authenticationToken User authentication taken unique for every logged-in user
     * @param orderDto Order to be created. OrderDto contains order details.
     * @return ResponseEntity {@link String} message to be displayed to the user as response
     * @throws UserException if user details are not valid or user unavailable
     * @throws CurrentUserServiceException if user is not authorized or authenticated
     * @throws CartException if cart does not exist or cart is empty
     */
    @PostMapping("/orders")
    public ResponseEntity<String> makeOrder(@RequestParam String authenticationToken, @RequestBody OrderDto orderDto)
            throws UserException, CurrentUserServiceException, CartException {

        logger.info("called makeOrder method of orderService to create a new order");
        orderService.makeOrder(orderDto, authenticationToken);
        logger.info("a new order created successfully");

        return new ResponseEntity<>("Order Created", HttpStatus.ACCEPTED);

    }

    /**
     * Fetch all orders related to a user id.
     * @param authenticationToken User authentication taken unique for every logged-in user
     * @param userId user id to fetch orders for
     * @return  ResponseEntity {@link List<Order>} to be displayed to the user as response
     * @throws OrderException if no orders exist
     * @throws UserException if user details are not valid or user unavailable
     * @throws CurrentUserServiceException if user is not authorized or authenticated
     */
    @GetMapping("/orders/{id}")
    public ResponseEntity<List<Order>> listOrdersByUserId(@RequestParam String authenticationToken,
                                                          @PathVariable("id") Integer userId) throws OrderException, UserException, CurrentUserServiceException {
        logger.info("called listOrdersByUserId method of orderService to fetch orders by user id");
        List<Order> orders = orderService.listOrdersByUserId(userId, authenticationToken);
        logger.info("orders fetched successfully for given user id");

        return new ResponseEntity<>(orders, HttpStatus.OK);

    }

    /**
     *  Fetch all the orders from order table.
     * @param authenticationToken User authentication taken unique for every logged-in user
     * @return  ResponseEntity {@link List<Order>} to be displayed to the user as response
     * @throws OrderException if no orders exist
     * @throws UserException if user details are not valid or user unavailable
     * @throws CurrentUserServiceException if user is not authorized or authenticated
     */
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> listAllOrders(@RequestParam String authenticationToken)
            throws OrderException, UserException, CurrentUserServiceException {
        logger.info("called listAllOrders method of orderService to fetch all orders available in order table");
        List<Order> orders = orderService.listAllOrders(authenticationToken);
        logger.info("orders fetched successfully");

        return new ResponseEntity<>(orders, HttpStatus.OK);

    }

    /**
     * Update order details. This method is authorized only for Admin and Owner.
     * @param authenticationToken User authentication taken unique for every logged-in user
     * @param orderDto Order to be updated. OrderDto contains order details.
     * @return ResponseEntity {@link String} message to be displayed to the user as response
     * @throws CurrentUserServiceException if user is not authorized or authenticated
     * @throws OrderException if no orders exist
     */
    @PutMapping("/updateorder")
    public ResponseEntity<String> updateOrder(@RequestParam String authenticationToken, @RequestBody OrderDto orderDto) throws CurrentUserServiceException, OrderException {

        logger.info("called updateOrder method of orderService to update order");
        orderService.updateOrder(orderDto,authenticationToken);
        logger.info("order updated successfully");

        return new ResponseEntity<>("Order Updated", HttpStatus.ACCEPTED);
    }

}
