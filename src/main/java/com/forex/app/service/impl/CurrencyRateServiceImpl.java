package com.forex.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forex.app.dto.CurrencyRateDTO;
import com.forex.app.entity.CurrencyRate;
import com.forex.app.exception.CurrencyNotFoundException;
import com.forex.app.repository.CurrencyRateRepository;
import com.forex.app.service.CurrencyRateService;
import com.forex.app.util.MapperUtil;

@Service
public class CurrencyRateServiceImpl implements CurrencyRateService {

    @Autowired
    private CurrencyRateRepository currencyRateRepository;

    @Override
    public CurrencyRateDTO save(CurrencyRateDTO dto) {
        CurrencyRate entity = MapperUtil.toCurrencyRateEntity(dto);
        entity = currencyRateRepository.save(entity);
        return MapperUtil.toCurrencyRateDTO(entity);
    }

    @Override
    public List<CurrencyRateDTO> findAll() {
        List<CurrencyRate> currencyRates = currencyRateRepository.findAll();
        return MapperUtil.mapToCurrencyRateDtoList(currencyRates);
    }

    @Override
    public CurrencyRateDTO findById(Long id) throws CurrencyNotFoundException {
        Optional<CurrencyRate> currencyRate = currencyRateRepository.findById(id);
        if (!currencyRate.isPresent()) {
            throw new CurrencyNotFoundException("Currency Rate with id " + id + " not found");
        }
        return MapperUtil.toCurrencyRateDTO(currencyRate.get());
    }

    @Override
    public CurrencyRateDTO update(Long id, CurrencyRateDTO dto) throws CurrencyNotFoundException {
        Optional<CurrencyRate> optionalCurrencyRate = currencyRateRepository.findById(id);
        if (!optionalCurrencyRate.isPresent()) {
            throw new CurrencyNotFoundException("Currency Rate with id " + id + " not found");
        }

        CurrencyRate currencyRate = optionalCurrencyRate.get();
        currencyRate.setRate(dto.getRate());
        currencyRate.setRateDateTime(dto.getRateDateTime());

        CurrencyRate updatedCurrencyRate = currencyRateRepository.save(currencyRate);
        return MapperUtil.toCurrencyRateDTO(updatedCurrencyRate);
    }

    @Override
    public void delete(Long id) throws CurrencyNotFoundException {
        Optional<CurrencyRate> optionalCurrencyRate = currencyRateRepository.findById(id);
        if (!optionalCurrencyRate.isPresent()) {
            throw new CurrencyNotFoundException("Currency Rate with id " + id + " not found");
        }
        currencyRateRepository.deleteById(id);
    }

}
