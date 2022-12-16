package com.supershop.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supershop.dto.AddItemToCartDto;
import com.supershop.dto.CartDto;
import com.supershop.dto.CartItemDto;
import com.supershop.dto.ProductDto;
import com.supershop.exception.CartException;
import com.supershop.exception.CurrentUserServiceException;
import com.supershop.exception.ProductException;
import com.supershop.exception.UserException;
import com.supershop.helper.Helper;
import com.supershop.model.Cart;
import com.supershop.model.CurrentUserSession;
import com.supershop.model.Product;
import com.supershop.model.User;
import com.supershop.repository.CartRepository;
import com.supershop.repository.CurrentUserSessionRepository;
import com.supershop.repository.ProductRepository;
import com.supershop.repository.UserRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CurrentUserSessionRepository currentUserSessionRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void addItemToCart(AddItemToCartDto cartDto, String authenticationToken)
			throws CartException, CurrentUserServiceException, UserException, ProductException {

		if (!Helper.isLoggedIn(authenticationToken, currentUserSessionRepository)) {

			System.out.println(authenticationToken);

			throw new CurrentUserServiceException(" Log in required ");

		}

		CurrentUserSession session = currentUserSessionRepository.findByAuthenticationToken(authenticationToken);

		Optional<User> optionalUser = userRepository.findById(session.getUserId());

		if (optionalUser.isEmpty()) {
			throw new UserException("No users exists with the given id" + session.getUserId());
		}

		User user = optionalUser.get();

		Optional<Product> optionalProduct = productRepository.findById(cartDto.getProductId());

		if (optionalProduct.isEmpty()) {
			throw new ProductException("Product Does not exists with given product id");
		}

		Product product = optionalProduct.get();

		Cart existedCart = cartRepository.findByUserAndProduct(user, product);

		if (existedCart != null) {
			throw new CartException("Product already exists in the cart");
		}

		if (product.getStock() < cartDto.getQantity()) {
			throw new ProductException("product out of stock");
		}

		product.setStock(product.getStock() - cartDto.getQantity());

		Cart newCart = new Cart();

		newCart.setCreateDateTime(LocalDateTime.now());
		newCart.setQuantity(cartDto.getQantity());
		newCart.setProduct(product);
		newCart.setUser(user);

		cartRepository.save(newCart);

		System.out.println("new item added to cart successfully");

	}

	@Override
	public void removeCartItem(CartItemDto cartDto, String authenticationToken)
			throws CartException, CurrentUserServiceException, UserException, ProductException {

		if (!Helper.isLoggedIn(authenticationToken, currentUserSessionRepository)) {

			throw new CurrentUserServiceException(" Log in required ");

		}

		Optional<User> optionalUser = userRepository.findById(cartDto.getUserId());

		if (optionalUser.isEmpty()) {
			throw new UserException("No users exists with the given id" + cartDto.getUserId());
		}

		User user = optionalUser.get();

		Optional<Product> optionalProduct = productRepository.findById(cartDto.getProductDto().getId());

		if (optionalProduct.isEmpty()) {
			throw new ProductException("Product Does not exists with given product id");
		}
		Product product = optionalProduct.get();

		Cart existedCart = cartRepository.findByUserAndProduct(user, product);

		if (existedCart == null) {
			throw new CartException("Product does not exists in the cart");
		}

		cartRepository.delete(existedCart);
		System.out.println("Product removed");

	}

	@Override
	public CartDto getCartByUser(String authenticationToken)
			throws CartException, UserException, CurrentUserServiceException {

		if (!Helper.isLoggedIn(authenticationToken, currentUserSessionRepository)) {

			throw new CurrentUserServiceException(" Log in required ");

		}

		CurrentUserSession session = currentUserSessionRepository.findByAuthenticationToken(authenticationToken);

		Optional<User> optionalUser = userRepository.findById(session.getUserId());

		if (optionalUser.isEmpty()) {
			throw new UserException("No users exists with the given id" + session.getUserId());
		}

		User user = optionalUser.get();

		List<Cart> carts = cartRepository.findByUserOrderByCreateDateTimeDesc(user);

		if (carts.isEmpty()) {
			throw new CartException("Cart is empty");

		}
		CartDto cartDto = new CartDto();
		List<CartItemDto> cartItems = new ArrayList<>();

		Double totalAmount = 0.0;

		for (Cart c : carts) {

			Product p = c.getProduct();

			ProductDto pDto = new ProductDto();

			BeanUtils.copyProperties(p, pDto);

			System.out.println(c);

			CartItemDto cartItemDto = new CartItemDto();
			cartItemDto.setId(c.getId());
			cartItemDto.setUserId(c.getUser().getId());
			cartItemDto.setQantity(c.getQuantity());
			cartItemDto.setProductDto(pDto);
			cartItemDto.setTotal(c.getProduct().getPrice() * c.getQuantity());

			cartItems.add(cartItemDto);
			totalAmount += cartItemDto.getTotal();

		}
		cartDto.setUserId(session.getUserId());

		cartDto.setCartItems(cartItems);
		cartDto.setTotalCost(totalAmount);

		if (!Helper.isAdmin(authenticationToken, currentUserSessionRepository)) {

			CurrentUserSession currentUserSession = currentUserSessionRepository
					.findByAuthenticationToken(authenticationToken);

			if (user.getEmail().equals(currentUserSession.getEmail())) {
				return cartDto;
			} else {
				throw new CurrentUserServiceException("You are not allowed to perform this operation");
			}

		} else {

			return cartDto;
		}

	}

	@Override
	public void updateCartItem(CartItemDto cartDto, String authenticationToken)
			throws CartException, CurrentUserServiceException, UserException, ProductException {

		if (!Helper.isLoggedIn(authenticationToken, currentUserSessionRepository)) {

			throw new CurrentUserServiceException(" Log in required ");

		}

		Optional<User> optionalUser = userRepository.findById(cartDto.getUserId());

		if (optionalUser.isEmpty()) {
			throw new UserException("No users exists with the given id" + cartDto.getUserId());
		}

		User user = optionalUser.get();

		Optional<Product> optionalProduct = productRepository.findById(cartDto.getProductDto().getId());

		if (optionalProduct.isEmpty()) {
			throw new ProductException("Product Does not exists with given product id");
		}
		Product product = optionalProduct.get();

		Cart existedCart = cartRepository.findByUserAndProduct(user, product);

		if (existedCart == null) {
			throw new CartException("Product does not exists in the cart");
		}

		Cart newCart = new Cart();
		newCart.setId(existedCart.getId());
		newCart.setCreateDateTime(LocalDateTime.now());
		newCart.setQuantity(cartDto.getQantity());
		newCart.setProduct(product);
		newCart.setUser(user);

		cartRepository.save(newCart);

	}

}
