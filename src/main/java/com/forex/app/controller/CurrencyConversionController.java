package com.forex.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.forex.app.dto.CurrencyConversionDTO;
import com.forex.app.exception.CurrencyConverterNotFoundException;
import com.forex.app.service.CurrencyConversionService;

@RestController
@RequestMapping("/currency-conversions")
public class CurrencyConversionController {

	@Autowired
	private CurrencyConversionService currencyConversionService;

	@PostMapping
	public ResponseEntity<CurrencyConversionDTO> save(@RequestBody CurrencyConversionDTO dto) {
		CurrencyConversionDTO savedDto = currencyConversionService.save(dto);
		return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<CurrencyConversionDTO>> findAll() throws CurrencyConverterNotFoundException {
		List<CurrencyConversionDTO> currencyConversions = currencyConversionService.findAll();
		return new ResponseEntity<>(currencyConversions, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CurrencyConversionDTO> findById(@PathVariable Long id)
			throws CurrencyConverterNotFoundException {
		CurrencyConversionDTO currencyConversion = currencyConversionService.findById(id);
		return new ResponseEntity<>(currencyConversion, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CurrencyConversionDTO> update(@PathVariable Long id, @RequestBody CurrencyConversionDTO dto)
			throws CurrencyConverterNotFoundException {
		CurrencyConversionDTO updatedDto = currencyConversionService.update(id, dto);
		return new ResponseEntity<>(updatedDto, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) throws CurrencyConverterNotFoundException {
		currencyConversionService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
