package com.forex.app.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forex.app.dto.CurrencyDTO;
import com.forex.app.dto.TransactionFeeDTO;
import com.forex.app.entity.TransactionFee;
import com.forex.app.exception.CurrencyNotFoundException;
import com.forex.app.exception.TransactionFeeNotFoundException;
import com.forex.app.repository.TransactionFeeRepository;
import com.forex.app.service.CurrencyService;
import com.forex.app.service.TransactionFeeService;
import com.forex.app.util.MapperUtil;

@Service
public class TransactionFeeServiceImpl implements TransactionFeeService {

	@Autowired
	private TransactionFeeRepository transactionFeeRepository;
	
	@Autowired
	private CurrencyService currencyService;

	@Override
	public List<TransactionFeeDTO> findAll() {
		List<TransactionFee> transactionFees = transactionFeeRepository.findAll();
		return transactionFees.stream().map(MapperUtil::toTransactionFeeDTO).collect(Collectors.toList());
	}

	@Override
	public TransactionFeeDTO findById(Long id) throws TransactionFeeNotFoundException {
		Optional<TransactionFee> optionalTransactionFee = transactionFeeRepository.findById(id);
		if (optionalTransactionFee.isPresent()) {
			return MapperUtil.toTransactionFeeDTO(optionalTransactionFee.get());
		} else {
			throw new TransactionFeeNotFoundException("Fee not found with id "+id);
		}
	}

	@Override
	public TransactionFeeDTO save(TransactionFeeDTO transactionFeeDTO) throws Exception {
		CurrencyDTO currency = currencyService.findById(transactionFeeDTO.getCurrency().getId());
		TransactionFee transactionFee = new TransactionFee();
		transactionFee.setCurrency(MapperUtil.toCurrencyEntity(currency));
		transactionFee.setFee(transactionFeeDTO.getFee());
		TransactionFee savedTransactionFee = transactionFeeRepository.save(transactionFee);
		return MapperUtil.toTransactionFeeDTO(savedTransactionFee);
	}

	@Override
	public TransactionFeeDTO update(Long id, TransactionFeeDTO transactionFeeDTO) throws TransactionFeeNotFoundException, CurrencyNotFoundException {
		Optional<TransactionFee> optionalTransactionFee = transactionFeeRepository.findById(id);
		if (optionalTransactionFee.isPresent()) {
			CurrencyDTO currency = currencyService.findById(transactionFeeDTO.getCurrency().getId());
			TransactionFee transactionFee = optionalTransactionFee.get();
			transactionFee.setCurrency(MapperUtil.toCurrencyEntity(currency));
			transactionFee.setFee(transactionFeeDTO.getFee());
			TransactionFee updatedTransactionFee = transactionFeeRepository.save(transactionFee);
			return MapperUtil.toTransactionFeeDTO(updatedTransactionFee);
		} else {
			throw new TransactionFeeNotFoundException("Fee not found with id "+id);
		}
	}

	@Override
	public void delete(Long id) throws TransactionFeeNotFoundException {
		Optional<TransactionFee> optionalTransactionFee = transactionFeeRepository.findById(id);
		if (optionalTransactionFee.isPresent()) {
			transactionFeeRepository.delete(optionalTransactionFee.get());
		} else {
			throw new TransactionFeeNotFoundException("Fee not found with id "+id);
		}
	}

}

