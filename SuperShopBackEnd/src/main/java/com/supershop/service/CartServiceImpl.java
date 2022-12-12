package com.supershop.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supershop.dto.AddToCartDto;
import com.supershop.dto.CartDto;
import com.supershop.dto.CartItemDto;
import com.supershop.dto.ProductDto;
import com.supershop.model.Cart;
import com.supershop.model.Product;
import com.supershop.model.User;
import com.supershop.repository.CartRepository;
import com.supershop.repository.CurrentUserSessionRepository;
import com.supershop.repository.ProductRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void addToCart(AddToCartDto addToCartDto, User user) {

		Product product = productRepository.findById(addToCartDto.getPrdouctId()).get();

		Cart cart = new Cart();
		cart.setUser(user);
		cart.setProduct(product);
		cart.setCreatedTime(LocalDateTime.now());
		cart.setQuantity(addToCartDto.getQuantity());

		cartRepository.save(cart);

	}

	@Override
	public CartDto listCartItems(User user) {

		List<Cart> carts = cartRepository.findAllByUserOrderByCreatedTimeDesc(user);

		List<CartItemDto> cartItemDtos = new ArrayList<>();

		double totalCost = 0;

		for (Cart cart : carts) {

			CartItemDto cartItemDto = new CartItemDto();
			ProductDto productDto = new ProductDto();
			Product product = cart.getProduct();
			BeanUtils.copyProperties(product, productDto);

			productDto.setCategoryId(cart.getProduct().getCategory().getId());
			cartItemDto.setProductDto(productDto);
			cartItemDto.setId(cart.getId());
			cartItemDto.setQuantity(cart.getQuantity());

			totalCost += cart.getQuantity() * cart.getProduct().getPrice();

			cartItemDtos.add(cartItemDto);
		}

		CartDto cartDto = new CartDto();
		cartDto.setCartItems(cartItemDtos);
		cartDto.setTotalCost(totalCost);
		return cartDto;
	}

	@Override
	public void delete(Integer itemId, User user) {

		Optional<Cart> optionalCart = cartRepository.findById(itemId);
		// check if cart is empty

		Cart cart = optionalCart.get();
		System.out.println(cart.getId());
		// check if cart belond to user or not

		cartRepository.delete(cart);

	}

}
