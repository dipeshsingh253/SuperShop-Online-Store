package com.supershop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supershop.exception.CurrentUserServiceException;
import com.supershop.exception.UserException;
import com.supershop.model.Cart;
import com.supershop.model.CurrenUserSession;
import com.supershop.model.User;
import com.supershop.repository.CartRepository;
import com.supershop.repository.CurrentUserSessionRepository;
import com.supershop.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CurrentUserSessionRepository currentUserSessionRepository;

	@Override
	public void registerUser(User user) throws UserException {

		User existedUser = userRepository.findByEmail(user.getEmail());

		if (existedUser != null) {
			throw new UserException("User already exists with given email :" + user.getEmail());
		}

		Cart cart = new Cart();

		cartRepository.save(cart);
		user.setCart(cart);
		userRepository.save(user);

		System.out.println("User Saved Successfully");

	}

	@Override
	public List<User> listAllUsers(String authenticationToken) throws UserException, CurrentUserServiceException {

		if (!isLoggedIn(authenticationToken)) {
			throw new CurrentUserServiceException("login required");
		}

		if (!isAdmin(authenticationToken)) {
			throw new UserException("You are not allowed to perform this action");
		}

		List<User> users = userRepository.findAll();

		if (users.isEmpty()) {
			throw new UserException("No users exists");
		}

		return users;

	}

	@Override
	public void updateUser(User user, String authenticationToken) throws UserException, CurrentUserServiceException {

		if (!isLoggedIn(authenticationToken)) {
			throw new CurrentUserServiceException("Login required");
		}

		if (isAdmin(authenticationToken)) {

			User existedUser = userRepository.findByEmail(user.getEmail());

			if (existedUser == null) {
				throw new UserException("User does not exists with given email : " + user.getEmail());
			}

			userRepository.save(user);

			System.out.println("User updated by admin successfully");
		} else {

			CurrenUserSession currenUserSession = currentUserSessionRepository.findByEmail(user.getEmail());

			if (!currenUserSession.getAuthenticationToken().equals(authenticationToken)) {
				throw new CurrentUserServiceException("Chaeck user email id");
			}

			userRepository.save(user);

		}

	}

	@Override
	public void deleteUser(String email, String authenticationToken) throws UserException, CurrentUserServiceException {
		if (!isLoggedIn(authenticationToken)) {
			throw new CurrentUserServiceException("Login required");
		}

		if (isAdmin(authenticationToken)) {

			User existedUser = userRepository.findByEmail(email);

			if (existedUser == null) {
				throw new UserException("User does not exists with given email : " + email);
			}

			userRepository.delete(existedUser);

			System.out.println("User deletd by admin successfully");
		} else {

			CurrenUserSession currenUserSession = currentUserSessionRepository.findByEmail(email);

			if (!currenUserSession.getAuthenticationToken().equals(authenticationToken)) {
				throw new CurrentUserServiceException("Chaeck user email id");
			}

			currentUserSessionRepository.delete(currenUserSession);
			userRepository.delete(userRepository.findByEmail(email));

		}

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

	@Override
	public boolean isAdmin(String authenticationToken) throws CurrentUserServiceException {

		CurrenUserSession currenUserSession = currentUserSessionRepository
				.findByAuthenticationToken(authenticationToken);

		if (currenUserSession.getRole().equals("admin")) {
			return true;
		}

		return false;
	}

}
