//package com.supershop.service;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.supershop.dto.CartDto;
//import com.supershop.exception.CartException;
//import com.supershop.exception.ProductException;
//import com.supershop.exception.UserException;
//import com.supershop.model.Cart;
//import com.supershop.model.Product;
//import com.supershop.model.User;
//import com.supershop.repository.CartRepository;
//import com.supershop.repository.UserRepository;
//
//@Service
//public class CartServiceImpl implements CartService {
//
//	@Autowired
//	private CartRepository cartRepository;
//
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Autowired
//	private
//
//	@Override
//	public Cart addItemToCart(CartDto cartDto) throws CartException, UserException, ProductException {
//
//		Optional<User> optionalUser = userRepository.findById(cartDto.getUserId());
//		
//		Optional<Product> optionalProduct = 
//		
//		if (optional.isEmpty()) {
//			throw new UserException("User does not exist");
//		}
//		
//		User user = optional.get();
//		
//		Cart cart = user.getCart();
//		
//		
//		
//		
//		return null;
//	}
//
//	@Override
//	public Cart removeItemFromCart(CartDto cartDto) throws CartException, UserException, ProductException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Cart upadteCartItem(CartDto cartDto) throws CartException, UserException, ProductException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Cart clearCart(CartDto cartDto) throws CartException, UserException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
