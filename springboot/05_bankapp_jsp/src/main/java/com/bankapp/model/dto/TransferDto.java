package com.bankapp.model.dto;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class TransferDto {
	private Integer fromAcc;
	private Integer toAcc;
	private BigDecimal amount;
}
