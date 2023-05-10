package com.forex.app.service;

import java.util.List;

import com.forex.app.dto.CurrencyRateDTO;
import com.forex.app.exception.CurrencyNotFoundException;

public interface CurrencyRateService {
	CurrencyRateDTO save(CurrencyRateDTO dto);

	List<CurrencyRateDTO> findAll();

	CurrencyRateDTO findById(Long id) throws CurrencyNotFoundException;

	CurrencyRateDTO update(Long id, CurrencyRateDTO bank) throws CurrencyNotFoundException;

	void delete(Long id) throws CurrencyNotFoundException;
}
