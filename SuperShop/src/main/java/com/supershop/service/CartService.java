package com.supershop.service;

import com.supershop.dto.CartDto;
import com.supershop.exception.CartException;
import com.supershop.exception.CurrentUserServiceException;
import com.supershop.exception.ProductException;
import com.supershop.exception.UserException;
import com.supershop.model.Cart;

public interface CartService {

	public void addItemToCart(CartDto cartDto, String authenticationToken)
			throws CartException, CurrentUserServiceException, UserException, ProductException;

//	public void updateCart(Cart cart, String authenticationToken) throws CartException, CurrentUserServiceException;

	public void removeCartItem(CartDto cartDto, String authenticationToken) throws CartException, CurrentUserServiceException, UserException, ProductException;

	public Cart getCartByUserId(Integer userId, String authenticationToken) throws CartException, UserException, CurrentUserServiceException;

	public void updateCartItem(CartDto cartDto, String authenticationToken) throws CartException, CurrentUserServiceException, UserException, ProductException;

	boolean isLoggedIn(String authenticationToken);

}
