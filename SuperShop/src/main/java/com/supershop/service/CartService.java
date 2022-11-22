package com.supershop.service;

import com.supershop.dto.CartDto;
import com.supershop.exception.CartException;
import com.supershop.exception.ProductException;
import com.supershop.exception.UserException;
import com.supershop.model.Cart;

public interface CartService {

	Cart addItemToCart(CartDto cartDto) throws CartException, UserException, ProductException;

	Cart removeItemFromCart(CartDto cartDto) throws CartException, UserException, ProductException;

	Cart upadteCartItem(CartDto cartDto, Integer quantity) throws CartException, UserException, ProductException;

	Cart clearCart(CartDto cartDto) throws CartException, UserException, ProductException;

}
