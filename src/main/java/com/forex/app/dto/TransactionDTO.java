package com.forex.app.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
	private Long id;
	private UserDTO sender;
	private UserDTO recipient;
	private double amount;
	private CurrencyDTO currency;
	private LocalDateTime transactionDateTime;
}
