package com.bankapp.model.dto;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class WithdrawDto {
	private Integer accId;
	private BigDecimal amount;
}
