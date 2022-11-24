package com.supershop.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supershop.dto.CartDto;
import com.supershop.exception.CartException;
import com.supershop.exception.CurrentUserServiceException;
import com.supershop.exception.ProductException;
import com.supershop.exception.UserException;
import com.supershop.model.Cart;
import com.supershop.model.CartItem;
import com.supershop.model.CurrenUserSession;
import com.supershop.model.Product;
import com.supershop.model.User;
import com.supershop.repository.CartItemRepository;
import com.supershop.repository.CartRepository;
import com.supershop.repository.CurrentUserSessionRepository;
import com.supershop.repository.ProductRepository;
import com.supershop.repository.UserRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CurrentUserSessionRepository currentUserSessionRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CartItemRepository cartItemRepository;

	@Override
	public void addItemToCart(CartDto cartDto, String authenticationToken)
			throws CartException, CurrentUserServiceException, UserException, ProductException {

		if (!isLoggedIn(authenticationToken)) {
			throw new CurrentUserServiceException("Login required");
		}

		CurrenUserSession currenUser = currentUserSessionRepository.findByAuthenticationToken(authenticationToken);

		User user = userRepository.findById(cartDto.getUserId()).get();

		if (user == null) {
			throw new UserException("User does not exists with : " + cartDto.getUserId());
		}

		if (!user.getEmail().equals(currenUser.getEmail())) {
			throw new UserException("Invalid action by user , Use your registered email address");
		}

		Product product = productRepository.findById(cartDto.getProductId()).get();

		CartItem existedProduct = cartItemRepository.findByProduct(product);

		if (existedProduct != null) {
			throw new CartException("Product Already exists in cart");
		}

		if (product == null) {
			throw new ProductException("Product does not exists with given id :" + cartDto.getProductId());
		}

		if (product.getStock() < cartDto.getQantity()) {
			throw new ProductException("Unsufficient products in stock...");
		}

		product.setStock(product.getStock() - cartDto.getQantity());

		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setQuantity(cartDto.getQantity());

		user.getCart().getCartItems().add(cartItem);

		Cart userCart = user.getCart();
		cartRepository.save(userCart);
		userRepository.save(user);
		System.out.println("Cart item created successfully");

	}
//
//	@Override
//	public void updateCart(Cart cart, String authenticationToken) throws CartException, CurrentUserServiceException {
//
//		if (!isLoggedIn(authenticationToken)) {
//			throw new CurrentUserServiceException("Login required");
//		}
//
//		CurrenUserSession currenUser = currentUserSessionRepository.findByAuthenticationToken(authenticationToken);
//
//		cartRepository.save(cart);
//
//	}

	@Override
	public void removeCartItem(CartDto cartDto, String authenticationToken)
			throws CartException, CurrentUserServiceException, UserException, ProductException {

		if (!isLoggedIn(authenticationToken)) {
			throw new CurrentUserServiceException("Login required");
		}

		CurrenUserSession currenUser = currentUserSessionRepository.findByAuthenticationToken(authenticationToken);

		User user = userRepository.findById(cartDto.getUserId()).get();

		if (user == null) {
			throw new UserException("User does not exists with : " + cartDto.getUserId());
		}

		if (!user.getEmail().equals(currenUser.getEmail())) {
			throw new UserException("Invalid action by user , Use your registered email address");
		}

		Product product = productRepository.findById(cartDto.getProductId()).get();

		if (product == null) {
			throw new ProductException("Product does not exists with given id :" + cartDto.getProductId());
		}

		if (product.getStock() < cartDto.getQantity()) {
			throw new ProductException("Unsufficient products in stock...");
		}

		product.setStock(product.getStock() - cartDto.getQantity());

//		CartItem cartItem = new CartItem();
//		cartItem.setProduct(product);
//		cartItem.setQuantity(cartDto.getQantity());

		CartItem cartItem = cartItemRepository.findByProduct(product);
		cartItemRepository.delete(cartItem);
//		List<CartItem> cartItems = user.getCart().getCartItems();
//
//		cartItems.remove(cartItems.indexOf(cartItem));

		Cart userCart = user.getCart();
		cartRepository.save(userCart);
		userRepository.save(user);

		System.out.println("Cart item removed successfully");

	}

	@Override
	public Cart getCartByUserId(Integer userId, String authenticationToken)
			throws CartException, UserException, CurrentUserServiceException {
		if (!isLoggedIn(authenticationToken)) {
			throw new CurrentUserServiceException("Login required");
		}

		CurrenUserSession currenUser = currentUserSessionRepository.findByAuthenticationToken(authenticationToken);

		User user = userRepository.findById(userId).get();

		if (user == null) {
			throw new UserException("User does not exists with : " + userId);
		}

		if (!user.getEmail().equals(currenUser.getEmail())) {
			throw new UserException("Invalid action by user , Use your registered email address");
		}

		return user.getCart();
	}

	@Override
	public void updateCartItem(CartDto cartDto, String authenticationToken)
			throws CartException, CurrentUserServiceException, UserException, ProductException {
		if (!isLoggedIn(authenticationToken)) {
			throw new CurrentUserServiceException("Login required");
		}

		CurrenUserSession currenUser = currentUserSessionRepository.findByAuthenticationToken(authenticationToken);

		User user = userRepository.findById(cartDto.getUserId()).get();

		if (user == null) {
			throw new UserException("User does not exists with : " + cartDto.getUserId());
		}

		if (!user.getEmail().equals(currenUser.getEmail())) {
			throw new UserException("Invalid action by user , Use your registered email address");
		}

		Product product = productRepository.findById(cartDto.getProductId()).get();

		CartItem cartItem = cartItemRepository.findByProduct(product);

		if (cartItem.getQuantity() > cartDto.getQantity()
				&& product.getStock() > product.getStock() + cartItem.getQuantity() - cartDto.getQantity()) {
			cartItem.setQuantity(cartDto.getQantity());
			cartItemRepository.save(cartItem);
			Cart userCart = user.getCart();
			cartRepository.save(userCart);
			userRepository.save(user);
			product.setStock(product.getStock() + cartItem.getQuantity() - cartDto.getQantity());

			System.out.println("Cart item updated successfully");
			return;
		}

		if (product == null) {
			throw new ProductException("Product does not exists with given id :" + cartDto.getProductId());
		}

		if (product.getStock() < cartDto.getQantity()) {
			throw new ProductException("Unsufficient products in stock...");
		}
		product.setStock(product.getStock() - cartDto.getQantity());

		cartItem.setQuantity(cartDto.getQantity());
		cartItemRepository.save(cartItem);
		Cart userCart = user.getCart();
		cartRepository.save(userCart);
		userRepository.save(user);

		System.out.println("Cart item updated successfully");
	}

	@Override
	public boolean isLoggedIn(String authenticationToken) {

		CurrenUserSession currenUserSession = currentUserSessionRepository
				.findByAuthenticationToken(authenticationToken);

		if (currenUserSession == null) {
			return false;
		}

		return true;

	}
}
