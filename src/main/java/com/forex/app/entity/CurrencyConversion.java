package com.forex.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "currency_conversion")
public class CurrencyConversion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "source_currency_id", nullable = false)
	private Currency sourceCurrency;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "destination_currency_id", nullable = false)
	private Currency destinationCurrency;

	@Column(nullable = false)
	private double rate;

}
