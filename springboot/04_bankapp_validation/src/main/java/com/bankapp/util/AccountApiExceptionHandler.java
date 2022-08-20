package com.bankapp.util;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.model.dto.ErrorInfo;

//if any ex coming to my api layer control should transfer here
@RestControllerAdvice //use aop under the hood (throws advice)
public class AccountApiExceptionHandler {

	//i need to write a method that can handle BankAccc..... and should send some proper json data to the user
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	@ExceptionHandler(BankAccountNotFoundException.class)
	public ErrorInfo handle404(BankAccountNotFoundException ex) {
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setMessage(ex.getMessage());
		errorInfo.setDateTime(LocalDateTime.now());
		errorInfo.setToContact("suport.api@oracle.com");
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		
		return errorInfo;
	}
	
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorInfo handle400(MethodArgumentNotValidException ex) {
		ErrorInfo errorInfo=new ErrorInfo();
		//we need to get exact information what was not valid?
		
		String errorMessage= ex.getBindingResult().getAllErrors()
				.stream().map(x-> x.getDefaultMessage())
				.collect(Collectors.joining(","));
		
		
		
		errorInfo.setMessage(errorMessage);
		errorInfo.setDateTime(LocalDateTime.now());
		errorInfo.setToContact("suport.api@oracle.com");
		errorInfo.setStatus(HttpStatus.BAD_REQUEST.toString());
		
		return errorInfo;
	}
	
	//@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	//@ExceptionHandler(Exception.class)
	public ErrorInfo handle500(Exception ex) {
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setMessage("some internal server, pls try after some time");
		errorInfo.setDateTime(LocalDateTime.now());
		errorInfo.setToContact("suport.api@oracle.com");
		errorInfo.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		
		return errorInfo;
	}
}




