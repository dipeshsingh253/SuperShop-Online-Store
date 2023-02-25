package com.supershop.exception;

/**
 * Exception related to current user session functioning.
 */

public class CurrentUserServiceException extends Exception {

	public CurrentUserServiceException() {
		super();
	}

	public CurrentUserServiceException(String message) {
		super(message);
	}

}
