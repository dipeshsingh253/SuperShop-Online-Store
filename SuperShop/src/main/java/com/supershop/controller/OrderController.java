package com.supershop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.supershop.dto.CartDto;
import com.supershop.dto.OrderDto;
import com.supershop.exception.CartException;
import com.supershop.exception.CurrentUserServiceException;
import com.supershop.exception.OrderException;
import com.supershop.exception.UserException;
import com.supershop.model.Order;
import com.supershop.service.OrderService;

@CrossOrigin("http://localhost:3000/")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity<String> makeOrder(@RequestParam String token, @RequestBody OrderDto orderDto)
            throws OrderException, UserException, CurrentUserServiceException, CartException {

        orderService.makeOrder(orderDto, token);

        return new ResponseEntity<String>("Order Created", HttpStatus.ACCEPTED);

    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<List<Order>> listOrdersByUserId(@RequestParam String token,
                                                          @PathVariable("id") Integer userId) throws OrderException, UserException, CurrentUserServiceException {

        List<Order> orders = orderService.listOrdersByUserId(userId, token);

        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);

    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> listAllOrders(@RequestParam String token)
            throws OrderException, UserException, CurrentUserServiceException {

        List<Order> orders = orderService.listAllOrders(token);

        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);

    }


    @PutMapping("/updateorder")
    public ResponseEntity<String> updateOrder(@RequestParam String token, @RequestBody OrderDto orderDto) throws CurrentUserServiceException, OrderException {

        orderService.updateOrder(orderDto,token);
        return new ResponseEntity<>("Order Updated", HttpStatus.ACCEPTED);
    }

}
