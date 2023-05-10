package com.forex.app.controller;

import com.forex.app.dto.TransactionDTO;
import com.forex.app.exception.TransactionNotFoundException;
import com.forex.app.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

	private final TransactionService transactionService;

	@Autowired
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@GetMapping
	public List<TransactionDTO> findAll() {
		return transactionService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<TransactionDTO> findById(@PathVariable Long id) {
		try {
			TransactionDTO transactionDTO = transactionService.findById(id);
			return ResponseEntity.ok(transactionDTO);
		} catch (TransactionNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<TransactionDTO> save(@RequestBody TransactionDTO transactionDTO) {
		TransactionDTO savedTransactionDTO = transactionService.save(transactionDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedTransactionDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TransactionDTO> update(@PathVariable Long id, @RequestBody TransactionDTO transactionDTO) {
		try {
			TransactionDTO updatedTransactionDTO = transactionService.update(id, transactionDTO);
			return ResponseEntity.ok(updatedTransactionDTO);
		} catch (TransactionNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		try {
			transactionService.delete(id);
			return ResponseEntity.noContent().build();
		} catch (TransactionNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
