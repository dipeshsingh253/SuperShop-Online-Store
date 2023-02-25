package com.supershop.service;


import com.supershop.dto.AddItemToCartDto;
import com.supershop.dto.CartDto;
import com.supershop.dto.CartItemDto;
import com.supershop.exception.CartException;
import com.supershop.exception.CurrentUserServiceException;
import com.supershop.exception.ProductException;
import com.supershop.exception.UserException;

/**
 * Service for cart functioning.
 */
public interface CartService {

	/**
	 * This method will add given item to cart. User should be authenticated and authorized in order to perform this operation.
	 * @param authenticationToken User authentication taken unique for every logged-in user
	 * @param cartDto Product to be added to cart
	 * @throws CartException if cart does not exist
	 * @throws CurrentUserServiceException if user is not authorized or authenticated
	 * @throws UserException if user details are not valid or user unavailable
	 * @throws ProductException if product is not available
	 */
	void addItemToCart(AddItemToCartDto cartDto, String authenticationToken)
			throws CartException, CurrentUserServiceException, UserException, ProductException;


	/**
	 * Remove product from user cart.
	 * @param authenticationToken User authentication taken unique for every logged-in user
	 * @param cartDto Product to be deleted from cart
	 * @throws CartException if cart does not exist
	 * @throws CurrentUserServiceException if user is not authorized or authenticated
	 * @throws UserException if user details are not valid or user unavailable
	 * @throws ProductException if product is not available
	 */
	void removeCartItem(CartItemDto cartDto, String authenticationToken) throws CartException, CurrentUserServiceException, UserException, ProductException;

	/**
	 * Fetch user cart by user id. Here Admin will not able to see items added to users cart.
	 * @param authenticationToken User authentication taken unique for every logged-in user
	 * @return ResponseEntity {@link CartDto} to be displayed to the user as response
	 * @throws CartException if cart does not exist
	 * @throws CurrentUserServiceException if user is not authorized or authenticated
	 * @throws UserException if user details are not valid or user unavailable
	 */
	CartDto getCartByUser(String authenticationToken) throws CartException, UserException, CurrentUserServiceException;

	/**
	 * This will update cart details for user. User should be authenticated and authorized in order to perform this operation.
	 * @param authenticationToken User authentication taken unique for every logged-in user
	 * @param cartDto Product to be updated to cart
	 * @throws CartException if cart does not exist
	 * @throws CurrentUserServiceException if user is not authorized or authenticated
	 * @throws UserException if user details are not valid or user unavailable
	 * @throws ProductException if product is not available
	 */
	void updateCartItem(CartItemDto cartDto, String authenticationToken) throws CartException, CurrentUserServiceException, UserException, ProductException;


}
