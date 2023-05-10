package com.forex.app.service;

import java.util.List;

import com.forex.app.dto.CurrencyDTO;
import com.forex.app.exception.CurrencyNotFoundException;

public interface CurrencyService {

	CurrencyDTO save(CurrencyDTO bank);

	List<CurrencyDTO> findAll();

	CurrencyDTO findById(Long id) throws CurrencyNotFoundException;

	CurrencyDTO update(Long id, CurrencyDTO bank) throws CurrencyNotFoundException;

	void delete(Long id) throws CurrencyNotFoundException;
}
