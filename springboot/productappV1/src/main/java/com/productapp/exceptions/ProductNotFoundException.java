package com.productapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code =HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 4214448498206041484L;

	public ProductNotFoundException(String message) {
		super(message);
	}
}