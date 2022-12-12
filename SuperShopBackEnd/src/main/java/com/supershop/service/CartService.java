package com.supershop.service;

import com.supershop.dto.AddToCartDto;
import com.supershop.dto.CartDto;
import com.supershop.model.User;

public interface CartService {

	public void addToCart(AddToCartDto addToCartDto, User user);

	public CartDto listCartItems(User user);

	public void delete(Integer itemId, User user);

}
