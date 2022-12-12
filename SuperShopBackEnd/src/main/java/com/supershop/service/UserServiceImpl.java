package com.supershop.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supershop.dto.SignInDto;
import com.supershop.dto.SignUpDto;
import com.supershop.model.CurrentUserSession;
import com.supershop.model.User;
import com.supershop.repository.CurrentUserSessionRepository;
import com.supershop.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CurrentUserSessionRepository currentUserSessionRepository;

	@Override
	public void signUp(SignUpDto signUpDto) {

		// check if user is already present

		// hash the password

		String hashedPassword = signUpDto.getPassword();

		try {
			hashedPassword = hashPassword(signUpDto.getPassword());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		User user = new User();

		BeanUtils.copyProperties(signUpDto, user);

		user.setPassword(hashedPassword);

		User savedUser = userRepository.save(user);

		final CurrentUserSession currentUserSession = new CurrentUserSession(savedUser);

		currentUserSessionRepository.save(currentUserSession);

	}

	public String hashPassword(String password) throws NoSuchAlgorithmException {

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] digest = md.digest();

		String hash = DatatypeConverter.printHexBinary(digest).toUpperCase();

		return hash;

	}

	@Override
	public String signIn(SignInDto signInDto) {

		// check if user exists or not
		User user = userRepository.findByEmail(signInDto.getEmail());

		// hash the pass

		boolean flag = true;

		try {
			if (!user.getPassword().equals(hashPassword(signInDto.getPassword()))) {
				flag = false;
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		if (flag == false) {
			System.out.println("Password not matched");
			return "Password not matched";
		}

		CurrentUserSession currentUserSession = currentUserSessionRepository.findByUser(user);

		return currentUserSession.getToken();
		// compare pass

	}

}
