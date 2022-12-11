package com.supershop.service;

import java.util.List;

import com.supershop.dto.AddItemToCartDto;
import com.supershop.dto.CartDto;
import com.supershop.dto.CartItemDto;
import com.supershop.exception.CartException;
import com.supershop.exception.CurrentUserServiceException;
import com.supershop.exception.ProductException;
import com.supershop.exception.UserException;
import com.supershop.model.Cart;

public interface CartService {

	public void addItemToCart(AddItemToCartDto cartDto, String authenticationToken)
			throws CartException, CurrentUserServiceException, UserException, ProductException;

//	public void updateCart(Cart cart, String authenticationToken) throws CartException, CurrentUserServiceException;

	public void removeCartItem(CartItemDto cartDto, String authenticationToken) throws CartException, CurrentUserServiceException, UserException, ProductException;

	public CartDto getCartByUserId(Integer userId, String authenticationToken) throws CartException, UserException, CurrentUserServiceException;

	public void updateCartItem(CartItemDto cartDto, String authenticationToken) throws CartException, CurrentUserServiceException, UserException, ProductException;


}
