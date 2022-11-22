package com.supershop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supershop.dto.UserDto;
import com.supershop.exception.CartException;
import com.supershop.exception.UserException;
import com.supershop.model.Cart;
import com.supershop.model.User;
import com.supershop.repository.CartRepository;
import com.supershop.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CartRepository cartRepository;

	@Override
	public User registerUser(UserDto userDto) throws UserException {

		User existedUser = userRepository.findByEmail(userDto.getEmail());

		if (existedUser != null) {
			throw new UserException("User Already Exists");
		}

		User user = new User();

		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setRole(userDto.getRole());
		Cart cart = new Cart();
		user.setCart(cart);
		cartRepository.save(cart);
		userRepository.save(user);


		return user;
	}

	@Override
	public User updateUser(UserDto userDto) throws UserException {
		User existedUser = userRepository.findByEmail(userDto.getEmail());

		if (existedUser == null) {
			throw new UserException("User does not Exists");
		}

		existedUser.setFirstName(userDto.getFirstName());
		existedUser.setLastName(userDto.getLastName());
		existedUser.setEmail(userDto.getEmail());
		existedUser.setRole(userDto.getRole());

		return userRepository.save(existedUser);
	}

	@Override
	public User removeUser(Integer userId) throws UserException {

		Optional<User> optional = userRepository.findById(userId);

		if (optional.isEmpty()) {
			throw new UserException("User does not Exists");
		}

		User deleteUser = optional.get();

		userRepository.delete(deleteUser);

		return deleteUser;
	}

	@Override
	public User getUserById(Integer userId) throws UserException {

		Optional<User> optional = userRepository.findById(userId);

		if (optional.isEmpty()) {
			throw new UserException("User does not Exists");
		}

		User user = optional.get();

		return user;
	}

	@Override
	public List<User> getAllUsers() throws UserException {

		List<User> users = userRepository.findAll();

		if (users.isEmpty()) {
			throw new UserException("No users available");
		}

		return users;
	}

	@Override
	public Cart getCartByUserId(Integer userId) throws UserException, CartException {

		Optional<User> optional = userRepository.findById(userId);

		if (optional.isEmpty()) {
			throw new UserException("User does not Exists");
		}
		User user = optional.get();

		Cart cart = user.getCart();

		if (cart == null) {
			throw new CartException("Cart does not exists");
		}

		return cart;
	}

}
