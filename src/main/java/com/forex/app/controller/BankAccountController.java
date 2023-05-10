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

import com.forex.app.dto.BankAccountDTO;
import com.forex.app.exception.BankAccountNotFoundException;
import com.forex.app.service.BankAccountService;

@RestController
@RequestMapping("/bank-accounts")
public class BankAccountController {

	private final BankAccountService bankAccountService;

	@Autowired
	public BankAccountController(BankAccountService bankAccountService) {
		this.bankAccountService = bankAccountService;
	}

	@PostMapping
	public ResponseEntity<BankAccountDTO> create(@RequestBody BankAccountDTO bankAccountDto) {
		BankAccountDTO createdBankAccount = bankAccountService.save(bankAccountDto);
		return new ResponseEntity<>(createdBankAccount, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<BankAccountDTO>> findAll() {
		List<BankAccountDTO> bankAccounts = bankAccountService.findAll();
		return new ResponseEntity<>(bankAccounts, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BankAccountDTO> findById(@PathVariable Long id) throws BankAccountNotFoundException {
		BankAccountDTO bankAccount = bankAccountService.findById(id);
		return new ResponseEntity<>(bankAccount, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<BankAccountDTO> update(@PathVariable Long id, @RequestBody BankAccountDTO bankAccountDto)
			throws BankAccountNotFoundException {
		BankAccountDTO updatedBankAccount = bankAccountService.update(id, bankAccountDto);
		return new ResponseEntity<>(updatedBankAccount, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) throws BankAccountNotFoundException {
		bankAccountService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
