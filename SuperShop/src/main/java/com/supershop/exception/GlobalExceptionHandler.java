package com.supershop.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {


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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> exceptionHandler(MethodArgumentNotValidException exception, WebRequest request) {

        Map<String, String> res = new HashMap<>();

        exception.getBindingResult().getAllErrors().forEach((error) -> {
            res.put(((FieldError) error).getField(), error.getDefaultMessage());
        });

        return new ResponseEntity<Map<String, String>>(res, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErroDetails> exceptionHandler(Exception exception, WebRequest request) {
        MyErroDetails myErroDetails = new MyErroDetails(exception.getMessage(), request.getDescription(false),
                LocalDateTime.now());

        return new ResponseEntity<MyErroDetails>(myErroDetails, HttpStatus.BAD_REQUEST);

    }

}
