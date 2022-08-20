package com.bankapp.model.dto;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class WithdrawRequest {
	private Integer accId;
	private double amount;
}
