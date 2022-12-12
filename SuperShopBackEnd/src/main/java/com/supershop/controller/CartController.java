package com.supershop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.supershop.dto.AddToCartDto;
import com.supershop.dto.CartDto;
import com.supershop.model.User;
import com.supershop.service.CartService;
import com.supershop.service.CurrentuserService;


@CrossOrigin("http://localhost:8080/")
@RestController
public class CartController {

	@Autowired
	private CartService cartService;

	@Autowired
	private CurrentuserService currentuserService;

	@PostMapping("/cart")
	public String addToCart(@RequestBody AddToCartDto addToCartDto, @RequestParam String token) {

		User user = currentuserService.getUser(token);

		cartService.addToCart(addToCartDto, user);

		return "Added to Cart";

	}

	@GetMapping("/cartitems")
	public CartDto listCartItemsByuser(String token) {

		User user = currentuserService.getUser(token);

		return cartService.listCartItems(user);

	}

	@DeleteMapping("/cartitems/{itemId}")
	public String removeItemFromCart(@PathVariable("itemId") Integer itemId, String token) {
		User user = currentuserService.getUser(token);

		cartService.delete(itemId, user);

		return "Item removed";

	}

}
