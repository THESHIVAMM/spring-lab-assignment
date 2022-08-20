package com.bankapp.model.dto;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class DepositDto {
	private Integer accId;
	private BigDecimal amount;
}
