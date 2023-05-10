package com.forex.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forex.app.dto.BankDTO;
import com.forex.app.exception.BankNotFoundException;
import com.forex.app.service.BankService;

@RestController
@RequestMapping("/banks")
public class BankController {

	private final BankService bankService;

	@Autowired
	public BankController(BankService bankService) {
		this.bankService = bankService;
	}

	@PostMapping
	public ResponseEntity<BankDTO> create(@RequestBody BankDTO bankDto) {
		BankDTO createdBank = bankService.save(bankDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdBank);
	}

	@GetMapping
	public ResponseEntity<List<BankDTO>> findAll() {
		List<BankDTO> banks = bankService.findAll();
		return ResponseEntity.ok(banks);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BankDTO> findById(@PathVariable Long id) throws BankNotFoundException {
		BankDTO bank = bankService.findById(id);
		return ResponseEntity.ok(bank);
	}

	@PutMapping("/{id}")
	public ResponseEntity<BankDTO> update(@PathVariable Long id, @RequestBody BankDTO bankDto)
			throws BankNotFoundException {
		BankDTO updatedBank = bankService.update(id, bankDto);
		return ResponseEntity.ok(updatedBank);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) throws BankNotFoundException {
		bankService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
