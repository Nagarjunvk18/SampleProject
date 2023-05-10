package com.forex.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionFeeDTO {
	private Long id;
	private CurrencyDTO currency;
	private double fee;
}
