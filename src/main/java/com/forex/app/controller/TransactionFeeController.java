package com.forex.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.forex.app.dto.TransactionFeeDTO;
import com.forex.app.exception.CurrencyNotFoundException;
import com.forex.app.exception.TransactionFeeNotFoundException;
import com.forex.app.service.TransactionFeeService;

@RestController
@RequestMapping("/transaction-fees")
public class TransactionFeeController {

	@Autowired
	private TransactionFeeService transactionFeeService;

	@GetMapping
	public ResponseEntity<List<TransactionFeeDTO>> getAllTransactionFees() {
		List<TransactionFeeDTO> transactionFees = transactionFeeService.findAll();
		return new ResponseEntity<>(transactionFees, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TransactionFeeDTO> getTransactionFeeById(@PathVariable Long id)
			throws TransactionFeeNotFoundException {
		TransactionFeeDTO transactionFee = transactionFeeService.findById(id);
		return new ResponseEntity<>(transactionFee, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<TransactionFeeDTO> createTransactionFee(@RequestBody TransactionFeeDTO transactionFeeDTO)
			throws Exception {
		TransactionFeeDTO savedTransactionFee = transactionFeeService.save(transactionFeeDTO);
		return new ResponseEntity<>(savedTransactionFee, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TransactionFeeDTO> updateTransactionFee(@PathVariable Long id,
			@RequestBody TransactionFeeDTO transactionFeeDTO)
			throws TransactionFeeNotFoundException, CurrencyNotFoundException {
		TransactionFeeDTO updatedTransactionFee = transactionFeeService.update(id, transactionFeeDTO);
		return new ResponseEntity<>(updatedTransactionFee, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTransactionFee(@PathVariable Long id) throws TransactionFeeNotFoundException {
		transactionFeeService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
