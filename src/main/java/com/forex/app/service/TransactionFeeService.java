package com.forex.app.service;

import com.forex.app.dto.TransactionFeeDTO;
import com.forex.app.exception.CurrencyNotFoundException;
import com.forex.app.exception.TransactionFeeNotFoundException;

import java.util.List;

public interface TransactionFeeService {
    List<TransactionFeeDTO> findAll();

    TransactionFeeDTO findById(Long id) throws TransactionFeeNotFoundException;

    TransactionFeeDTO save(TransactionFeeDTO transactionFeeDTO) throws Exception;

    TransactionFeeDTO update(Long id, TransactionFeeDTO transactionFeeDTO) throws TransactionFeeNotFoundException, CurrencyNotFoundException;

    void delete(Long id) throws TransactionFeeNotFoundException;
}
