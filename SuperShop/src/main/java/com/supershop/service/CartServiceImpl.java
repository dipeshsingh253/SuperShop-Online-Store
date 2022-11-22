package com.supershop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supershop.dto.CartDto;
import com.supershop.exception.CartException;
import com.supershop.exception.ProductException;
import com.supershop.exception.UserException;
import com.supershop.model.Cart;
import com.supershop.model.Product;
import com.supershop.model.User;
import com.supershop.repository.CartRepository;
import com.supershop.repository.ProductRepository;
import com.supershop.repository.UserRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public Cart addItemToCart(CartDto cartDto) throws CartException, UserException, ProductException {

		Optional<User> optionalUser = userRepository.findById(cartDto.getUserId());

		if (optionalUser.isEmpty()) {
			throw new UserException("User does not exist with given id :" + cartDto.getUserId());
		}

		User user = optionalUser.get();

		Product product = productRepository.findByName(cartDto.getProductName());

		if (product == null) {
			throw new ProductException("Product does not exist ");
		}

		Cart cart = user.getCart();

		cart.getProducts().add(product);

		cartRepository.save(cart);
		userRepository.save(user);

		return cart;
	}

	@Override
	public Cart removeItemFromCart(CartDto cartDto) throws CartException, UserException, ProductException {
		Optional<User> optionalUser = userRepository.findById(cartDto.getUserId());

		if (optionalUser.isEmpty()) {
			throw new UserException("User does not exist with given id :" + cartDto.getUserId());
		}

		User user = optionalUser.get();

		Product product = productRepository.findByName(cartDto.getProductName());

		if (product == null) {
			throw new ProductException("Product does not exist ");
		}

		Cart cart = user.getCart();

		cart.getProducts().remove(product);

		cartRepository.save(cart);
		userRepository.save(user);

		return cart;
	}

	@Override
	public Cart upadteCartItem(CartDto cartDto, Integer quantity)
			throws CartException, UserException, ProductException {
		// Optional<User> optionalUser = userRepository.findById(cartDto.getUserId());

//		if (optionalUser.isEmpty()) {
//			throw new UserException("User does not exist with given id :" + cartDto.getUserId());
//		}
//
//		User user = optionalUser.get();
//
//		Product product = productRepository.findByName(cartDto.getProductName());
//
//		if (product == null) {
//			throw new ProductException("Product does not exist ");
//		}
//		
//		product.se		
//		Cart cart = user.getCart();
//
//		cart.getProducts().remove(product);
//		
		return null;
	}

	@Override
	public Cart clearCart(CartDto cartDto) throws CartException, UserException, ProductException {

		Optional<User> optionalUser = userRepository.findById(cartDto.getUserId());

		if (optionalUser.isEmpty()) {
			throw new UserException("User does not exist with given id :" + cartDto.getUserId());
		}

		User user = optionalUser.get();

		Product product = productRepository.findByName(cartDto.getProductName());

		if (product == null) {
			throw new ProductException("Product does not exist ");
		}

		Cart cart = user.getCart();

		cart.getProducts().clear();

		cartRepository.save(cart);
		userRepository.save(user);

		return cart;
	}

}
