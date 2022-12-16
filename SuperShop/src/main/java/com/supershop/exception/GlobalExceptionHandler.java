package com.supershop.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErroDetails> exceptionHandler(Exception exception, WebRequest request) {

		MyErroDetails myErroDetails = new MyErroDetails(exception.getMessage(), request.getDescription(false),
				LocalDateTime.now());

		return new ResponseEntity<MyErroDetails>(myErroDetails, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErroDetails> exceptionHandler(UserException exception, WebRequest request) {

		MyErroDetails myErroDetails = new MyErroDetails(exception.getMessage(), request.getDescription(false),
				LocalDateTime.now());

		return new ResponseEntity<MyErroDetails>(myErroDetails, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(CurrentUserServiceException.class)
	public ResponseEntity<MyErroDetails> exceptionHandler(CurrentUserServiceException exception, WebRequest request) {

		MyErroDetails myErroDetails = new MyErroDetails(exception.getMessage(), request.getDescription(false),
				LocalDateTime.now());

		return new ResponseEntity<MyErroDetails>(myErroDetails, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<MyErroDetails> exceptionHandler(CategoryException exception, WebRequest request) {

		MyErroDetails myErroDetails = new MyErroDetails(exception.getMessage(), request.getDescription(false),
				LocalDateTime.now());

		return new ResponseEntity<MyErroDetails>(myErroDetails, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(ProductException.class)
	public ResponseEntity<MyErroDetails> exceptionHandler(ProductException exception, WebRequest request) {

		MyErroDetails myErroDetails = new MyErroDetails(exception.getMessage(), request.getDescription(false),
				LocalDateTime.now());

		return new ResponseEntity<MyErroDetails>(myErroDetails, HttpStatus.BAD_REQUEST);

	}

}
