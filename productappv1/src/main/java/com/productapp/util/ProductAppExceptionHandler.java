package com.productapp.util;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.productapp.dto.ErrorDetails;
import com.productapp.exceptions.ProductNotFoundException;

@RestControllerAdvice
public class ProductAppExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorDetails> handle404(ProductNotFoundException ex){
		ErrorDetails details=new ErrorDetails();
		details.setDate(LocalDateTime.now());
		details.setName("rgupta.mtech@gmail.com");
		details.setMessage(ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(details);
	}
	//MethodArgumentNotValidException
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> handle400(MethodArgumentNotValidException ex){
		ErrorDetails details=new ErrorDetails();
		details.setDate(LocalDateTime.now());
		details.setName("rgupta.mtech@gmail.com");
		
		String errorMessage= ex.getBindingResult().getAllErrors().stream()
				.map(x-> x.getDefaultMessage())
				.collect(Collectors.joining(","));
		
		details.setMessage(errorMessage);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(details);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handle500(Exception ex){
		ErrorDetails details=new ErrorDetails();
		details.setDate(LocalDateTime.now());
		details.setName("rgupta.mtech@gmail.com");
		
		
		details.setMessage("some internel server error pls try after some time");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(details);
	}
	
}





