package com.forex.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forex.app.dto.CurrencyDTO;
import com.forex.app.entity.Currency;
import com.forex.app.exception.CurrencyNotFoundException;
import com.forex.app.repository.CurrencyRepository;
import com.forex.app.service.CurrencyService;
import com.forex.app.util.MapperUtil;

@Service
public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	private CurrencyRepository currencyRepository;

	@Override
	public CurrencyDTO save(CurrencyDTO currencyDto) {
		Currency currency = MapperUtil.toCurrencyEntity(currencyDto);
		currency = currencyRepository.save(currency);
		return MapperUtil.toCurrencyDTO(currency);
	}

	@Override
	public List<CurrencyDTO> findAll() {
		List<Currency> currencies = currencyRepository.findAll();
		return MapperUtil.mapToCurrencyDtoList(currencies);
	}

	@Override
	public CurrencyDTO findById(Long id) throws CurrencyNotFoundException {
		Optional<Currency> optional = currencyRepository.findById(id);
		if (optional.isPresent()) {
			Currency currency = optional.get();
			return MapperUtil.toCurrencyDTO(currency);
		} else {
			throw new CurrencyNotFoundException("Currency not found with id " + id);
		}
	}

	@Override
	public CurrencyDTO update(Long id, CurrencyDTO currencyDto) throws CurrencyNotFoundException {
		Optional<Currency> optional = currencyRepository.findById(id);
		if (optional.isPresent()) {
			Currency currency = optional.get();
			currency.setCode(currencyDto.getCode());
			currency = currencyRepository.save(currency);
			return MapperUtil.toCurrencyDTO(currency);
		} else {
			throw new CurrencyNotFoundException("Currency not found with id " + id);
		}
	}

	@Override
	public void delete(Long id) throws CurrencyNotFoundException {
		Optional<Currency> optional = currencyRepository.findById(id);
		if (optional.isPresent()) {
			currencyRepository.deleteById(id);
		} else {
			throw new CurrencyNotFoundException("Currency not found with id " + id);
		}
	}

}
