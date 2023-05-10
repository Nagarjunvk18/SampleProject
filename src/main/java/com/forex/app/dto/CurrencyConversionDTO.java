package com.forex.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversionDTO {

	private long id;
	private CurrencyDTO sourceCurrency;
	private CurrencyDTO destinationCurrency;
	private double rate;
}
