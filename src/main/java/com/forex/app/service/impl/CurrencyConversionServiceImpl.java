package com.forex.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forex.app.dto.CurrencyConversionDTO;
import com.forex.app.entity.CurrencyConversion;
import com.forex.app.exception.CurrencyConverterNotFoundException;
import com.forex.app.repository.CurrencyConversionRepository;
import com.forex.app.util.MapperUtil;
import com.forex.app.service.CurrencyConversionService;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

    @Autowired
    private CurrencyConversionRepository currencyConversionRepository;

    @Override
    public CurrencyConversionDTO save(CurrencyConversionDTO dto) {
        CurrencyConversion currencyConversion = MapperUtil.toCurrencyConversionEntity(dto);
        CurrencyConversion savedCurrencyConversion = currencyConversionRepository.save(currencyConversion);
        return MapperUtil.toCurrencyConversionDTO(savedCurrencyConversion);
    }

    @Override
    public List<CurrencyConversionDTO> findAll() throws CurrencyConverterNotFoundException {
        List<CurrencyConversion> currencyConversions = currencyConversionRepository.findAll();
        if (currencyConversions.isEmpty()) {
            throw new CurrencyConverterNotFoundException("No currency conversions found");
        }
        return currencyConversions.stream().map(MapperUtil::toCurrencyConversionDTO).collect(Collectors.toList());
    }
/*
    @Override
    public CurrencyConversionDTO update(long id, CurrencyConversionDTO dto) throws CurrencyConverterNotFoundException {
        CurrencyConversion currencyConversion = currencyConversionRepository.findById(id)
                .orElseThrow(() -> new CurrencyConverterNotFoundException("Currency conversion not found"));
        currencyConversion.setConversionRate(dto.get);
        currencyConversion.setCurrencyFrom(dto.getCurrencyFrom());
        currencyConversion.setCurrencyTo(dto.getCurrencyTo());
        CurrencyConversion updatedCurrencyConversion = currencyConversionRepository.save(currencyConversion);
        return MapperUtil.toCurrencyConversionDTO(updatedCurrencyConversion);
    }
*/
    @Override
    public void delete(long id) throws CurrencyConverterNotFoundException {
        CurrencyConversion currencyConversion = currencyConversionRepository.findById(id)
                .orElseThrow(() -> new CurrencyConverterNotFoundException("Currency conversion not found"));
        currencyConversionRepository.delete(currencyConversion);
    }

    @Override
    public CurrencyConversionDTO findById(long id) throws CurrencyConverterNotFoundException {
        CurrencyConversion currencyConversion = currencyConversionRepository.findById(id)
                .orElseThrow(() -> new CurrencyConverterNotFoundException("Currency conversion not found"));
        return MapperUtil.toCurrencyConversionDTO(currencyConversion);
    }

	@Override
	public CurrencyConversionDTO update(long id, CurrencyConversionDTO dto) throws CurrencyConverterNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}

