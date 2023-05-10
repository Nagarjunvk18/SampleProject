package com.forex.app.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyRateDTO {
	private long id;
	private CurrencyDTO currency;
	private double rate;
	private LocalDateTime rateDateTime;
}
