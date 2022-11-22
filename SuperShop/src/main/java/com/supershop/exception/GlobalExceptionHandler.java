package com.supershop.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetails> userExceptionHandler(UserException e, WebRequest request) {

		MyErrorDetails myErrorDetails = new MyErrorDetails();

		myErrorDetails.setMessage(e.getMessage());
		myErrorDetails.setTimeStamp(LocalDateTime.now());
		myErrorDetails.setDescription(request.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(CartException.class)
	public ResponseEntity<MyErrorDetails> cartExceptionHandler(CartException e, WebRequest request) {

		MyErrorDetails myErrorDetails = new MyErrorDetails();

		myErrorDetails.setMessage(e.getMessage());
		myErrorDetails.setTimeStamp(LocalDateTime.now());
		myErrorDetails.setDescription(request.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<MyErrorDetails> categoryExceptionHandler(CategoryException e, WebRequest request) {

		MyErrorDetails myErrorDetails = new MyErrorDetails();

		myErrorDetails.setMessage(e.getMessage());
		myErrorDetails.setTimeStamp(LocalDateTime.now());
		myErrorDetails.setDescription(request.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(OrderException.class)
	public ResponseEntity<MyErrorDetails> userExceptionHandler(OrderException e, WebRequest request) {

		MyErrorDetails myErrorDetails = new MyErrorDetails();

		myErrorDetails.setMessage(e.getMessage());
		myErrorDetails.setTimeStamp(LocalDateTime.now());
		myErrorDetails.setDescription(request.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(PaymentException.class)
	public ResponseEntity<MyErrorDetails> paymentExceptionHandler(PaymentException e, WebRequest request) {

		MyErrorDetails myErrorDetails = new MyErrorDetails();

		myErrorDetails.setMessage(e.getMessage());
		myErrorDetails.setTimeStamp(LocalDateTime.now());
		myErrorDetails.setDescription(request.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(ProductException.class)
	public ResponseEntity<MyErrorDetails> productExceptionHandler(ProductException e, WebRequest request) {

		MyErrorDetails myErrorDetails = new MyErrorDetails();

		myErrorDetails.setMessage(e.getMessage());
		myErrorDetails.setTimeStamp(LocalDateTime.now());
		myErrorDetails.setDescription(request.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler(Exception e, WebRequest request) {

		MyErrorDetails myErrorDetails = new MyErrorDetails();

		myErrorDetails.setMessage(e.getMessage());
		myErrorDetails.setTimeStamp(LocalDateTime.now());
		myErrorDetails.setDescription(request.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.BAD_REQUEST);

	}

}
