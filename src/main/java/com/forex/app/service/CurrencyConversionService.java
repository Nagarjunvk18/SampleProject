package com.forex.app.service;

import java.util.List;

import com.forex.app.dto.CurrencyConversionDTO;
import com.forex.app.exception.CurrencyConverterNotFoundException;

public interface CurrencyConversionService {

	CurrencyConversionDTO save(CurrencyConversionDTO dto);

	List<CurrencyConversionDTO> findAll() throws CurrencyConverterNotFoundException;

	CurrencyConversionDTO update(long id, CurrencyConversionDTO dto) throws CurrencyConverterNotFoundException;

	void delete(long id) throws CurrencyConverterNotFoundException;

	CurrencyConversionDTO findById(long id) throws CurrencyConverterNotFoundException;
}
