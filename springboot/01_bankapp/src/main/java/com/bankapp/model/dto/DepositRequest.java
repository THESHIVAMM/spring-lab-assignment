package com.bankapp.model.dto;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class DepositRequest {
	private Integer accId;
	private double amount;
}
