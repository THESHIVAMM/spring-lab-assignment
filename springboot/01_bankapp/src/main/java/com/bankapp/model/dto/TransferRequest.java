package com.bankapp.model.dto;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class TransferRequest {
	private Integer fromAcc;
	private Integer toAcc;
	private double amount;
}
