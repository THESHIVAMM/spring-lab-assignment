package com.bankapp.model.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorInfo {
	private String message;
	private String status;
	private String toContact;
	private LocalDateTime dateTime;
}
