package com.supershop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.supershop.dto.AddItemToCartDto;
import com.supershop.dto.CartDto;
import com.supershop.dto.CartItemDto;
import com.supershop.exception.CartException;
import com.supershop.exception.CurrentUserServiceException;
import com.supershop.exception.ProductException;
import com.supershop.exception.UserException;
import com.supershop.model.Cart;
import com.supershop.service.CartService;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:3000/")
@RestController
public class CartController {

    @Autowired
    private CartService cartService;


	/*
		/additemtocart => Post => adding item to cart
		/cart =>  Put => update cart
		/carts/user => Get => get cart by user id
		/cart => Delete => delete item from cart

	 */

    // adding item to cart
    @PostMapping("/additemtocart")
    public ResponseEntity<String> addItemToCart(@RequestParam String authenticationToken,
                                                @RequestBody AddItemToCartDto cartDto)
            throws CartException, CurrentUserServiceException, UserException, ProductException {

        cartService.addItemToCart(cartDto, authenticationToken);

        return new ResponseEntity<String>("Item added to cart", HttpStatus.ACCEPTED);

    }

    // update cart
    @PutMapping("/cart")
    public ResponseEntity<String> updateCartItem(@RequestParam String authenticationToken,
                                                 @RequestBody CartItemDto cartDto)
            throws CartException, CurrentUserServiceException, UserException, ProductException {

        cartService.updateCartItem(cartDto, authenticationToken);

        return new ResponseEntity<String>("Item updated to cart", HttpStatus.ACCEPTED);
    }

    // get cart by user id
    @GetMapping("/carts/user")
    public ResponseEntity<CartDto> getCartByUserId(@RequestParam String authenticationToken)
            throws CartException, UserException, CurrentUserServiceException {

        CartDto userCart = cartService.getCartByUser(authenticationToken);

        return new ResponseEntity<CartDto>(userCart, HttpStatus.OK);

    }


    // delete item from cart
    @DeleteMapping("/cart")
    public ResponseEntity<String> removeItemFromcart(@RequestParam String authenticationToken,
                                                     @RequestBody CartItemDto cartDto)
            throws CartException, CurrentUserServiceException, UserException, ProductException {

        cartService.removeCartItem(cartDto, authenticationToken);

        return new ResponseEntity<String>("Item removed from cart", HttpStatus.OK);

    }

}
