package com.supershop.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
 * RestControllerAdvice
 * GlobalExceptionHandler for this project.
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     *  Handles MethodArgumentNotValidException.
     * @param exception MethodArgumentNotValidException exception.
     * @param request web request object requested by user.
     * @return ResponseEntity map of key value pairs of field and message related to field.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> exceptionHandler(MethodArgumentNotValidException exception, WebRequest request) {

        Map<String, String> res = new HashMap<>();

        exception.getBindingResult().getAllErrors().forEach((error) -> {
            res.put(((FieldError) error).getField(), error.getDefaultMessage());
        });

        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);

    }

    /**
     * Handles UserException
     * @param exception UserException exception.
     * @param request web request object requested by user.
     * @return ResponseEntity {@link MyErrorDetails} as response to user
     */

    @ExceptionHandler(UserException.class)
    public ResponseEntity<MyErrorDetails> exceptionHandler(UserException exception, WebRequest request) {

        MyErrorDetails myErrorDetails = new MyErrorDetails(exception.getMessage(), request.getDescription(false),
                LocalDateTime.now());

        return new ResponseEntity<>(myErrorDetails, HttpStatus.BAD_REQUEST);

    }

    /**
     * Handles CurrentUserServiceException
     * @param exception CurrentUserServiceException exception.
     * @param request web request object requested by user.
     * @return ResponseEntity {@link MyErrorDetails} as response to user
     */
    @ExceptionHandler(CurrentUserServiceException.class)
    public ResponseEntity<MyErrorDetails> exceptionHandler(CurrentUserServiceException exception, WebRequest request) {

        MyErrorDetails myErrorDetails = new MyErrorDetails(exception.getMessage(), request.getDescription(false),
                LocalDateTime.now());

        return new ResponseEntity<>(myErrorDetails, HttpStatus.BAD_REQUEST);

    }


    /**
     * Handles CategoryException.
     * @param exception CategoryException exception.
     * @param request web request object requested by user.
     * @return ResponseEntity {@link MyErrorDetails} as response to user
     */
    @ExceptionHandler(CategoryException.class)
    public ResponseEntity<MyErrorDetails> exceptionHandler(CategoryException exception, WebRequest request) {

        MyErrorDetails myErrorDetails = new MyErrorDetails(exception.getMessage(), request.getDescription(false),
                LocalDateTime.now());

        return new ResponseEntity<>(myErrorDetails, HttpStatus.BAD_REQUEST);

    }


    /**
     * Handles ProductException.
     * @param exception ProductException exception.
     * @param request web request object requested by user.
     * @return ResponseEntity {@link MyErrorDetails} as response to user
     */
    @ExceptionHandler(ProductException.class)
    public ResponseEntity<MyErrorDetails> exceptionHandler(ProductException exception, WebRequest request) {

        MyErrorDetails myErrorDetails = new MyErrorDetails(exception.getMessage(), request.getDescription(false),
                LocalDateTime.now());

        return new ResponseEntity<>(myErrorDetails, HttpStatus.BAD_REQUEST);

    }


    /**
     * Handles Exception. Handles all other exception(child class of {@link Exception} ) occurred in project.
     * @param exception Exception exception.
     * @param request web request object requested by user.
     * @return ResponseEntity {@link MyErrorDetails} as response to user
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> exceptionHandler(Exception exception, WebRequest request) {
        MyErrorDetails myErrorDetails = new MyErrorDetails(exception.getMessage(), request.getDescription(false),
                LocalDateTime.now());

        return new ResponseEntity<>(myErrorDetails, HttpStatus.BAD_REQUEST);

    }

}
