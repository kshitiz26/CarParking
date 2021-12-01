package com.elsevier.carParking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CarParkingException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public CarParkingException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CarParkingException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
