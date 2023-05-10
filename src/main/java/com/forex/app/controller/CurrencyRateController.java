package com.forex.app.controller;

import com.forex.app.dto.CurrencyRateDTO;
import com.forex.app.exception.CurrencyNotFoundException;
import com.forex.app.service.CurrencyRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency-rates")
public class CurrencyRateController {

    @Autowired
    private CurrencyRateService currencyRateService;

    @GetMapping
    public ResponseEntity<List<CurrencyRateDTO>> getAll() {
        List<CurrencyRateDTO> currencyRates = currencyRateService.findAll();
        return ResponseEntity.ok(currencyRates);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CurrencyRateDTO> getById(@PathVariable Long id) throws CurrencyNotFoundException {
        CurrencyRateDTO currencyRateDTO = currencyRateService.findById(id);
        return ResponseEntity.ok(currencyRateDTO);
    }

    @PostMapping
    public ResponseEntity<CurrencyRateDTO> create(@RequestBody CurrencyRateDTO currencyRateDTO) {
        CurrencyRateDTO savedCurrencyRateDTO = currencyRateService.save(currencyRateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCurrencyRateDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CurrencyRateDTO> update(@PathVariable Long id, @RequestBody CurrencyRateDTO currencyRateDTO) throws CurrencyNotFoundException {
        CurrencyRateDTO updatedCurrencyRateDTO = currencyRateService.update(id, currencyRateDTO);
        return ResponseEntity.ok(updatedCurrencyRateDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws CurrencyNotFoundException {
        currencyRateService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
