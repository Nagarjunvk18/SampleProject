package com.forex.app.service;

import com.forex.app.dto.TransactionDTO;
import com.forex.app.exception.TransactionNotFoundException;

import java.util.List;

public interface TransactionService {
    List<TransactionDTO> findAll();

    TransactionDTO findById(Long id) throws TransactionNotFoundException;

    TransactionDTO save(TransactionDTO transactionDTO);

    TransactionDTO update(Long id, TransactionDTO transactionDTO) throws TransactionNotFoundException;

    void delete(Long id) throws TransactionNotFoundException;
}

