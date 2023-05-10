package com.forex.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.forex.app.dto.CurrencyDTO;
import com.forex.app.exception.CurrencyNotFoundException;
import com.forex.app.service.CurrencyService;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {

	@Autowired
	private CurrencyService currencyService;

	@PostMapping
	public ResponseEntity<CurrencyDTO> save(@RequestBody CurrencyDTO currencyDto) {
		CurrencyDTO savedCurrency = currencyService.save(currencyDto);
		return new ResponseEntity<>(savedCurrency, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<CurrencyDTO>> findAll() {
		List<CurrencyDTO> currencies = currencyService.findAll();
		return new ResponseEntity<>(currencies, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CurrencyDTO> findById(@PathVariable("id") Long id) {
		try {
			CurrencyDTO currency = currencyService.findById(id);
			return new ResponseEntity<>(currency, HttpStatus.OK);
		} catch (CurrencyNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<CurrencyDTO> update(@PathVariable("id") Long id, @RequestBody CurrencyDTO currencyDto) {
		try {
			CurrencyDTO updatedCurrency = currencyService.update(id, currencyDto);
			return new ResponseEntity<>(updatedCurrency, HttpStatus.OK);
		} catch (CurrencyNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		try {
			currencyService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (CurrencyNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
