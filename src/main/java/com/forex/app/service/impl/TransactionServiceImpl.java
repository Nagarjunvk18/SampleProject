package com.forex.app.service.impl;

import com.forex.app.dto.TransactionDTO;
import com.forex.app.entity.Transaction;
import com.forex.app.exception.TransactionNotFoundException;
import com.forex.app.repository.TransactionRepository;
import com.forex.app.service.TransactionService;
import com.forex.app.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<TransactionDTO> findAll() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream().map(MapperUtil::toTransactionDTO).collect(Collectors.toList());
    }

    @Override
    public TransactionDTO findById(Long id) throws TransactionNotFoundException {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        if (optionalTransaction.isPresent()) {
            return MapperUtil.toTransactionDTO(optionalTransaction.get());
        } else {
            throw new TransactionNotFoundException("Transaction with id " + id + " not found");
        }
    }

    @Override
    public TransactionDTO save(TransactionDTO transactionDTO) {
        Transaction transaction = MapperUtil.toTransactionEntity(transactionDTO);
        Transaction savedTransaction = transactionRepository.save(transaction);
        return MapperUtil.toTransactionDTO(savedTransaction);
    }

    @Override
    public TransactionDTO update(Long id, TransactionDTO transactionDTO) throws TransactionNotFoundException {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        if (optionalTransaction.isPresent()) {
            Transaction transaction = optionalTransaction.get();
            transaction.setAmount(transactionDTO.getAmount());
            transaction.setCurrency(MapperUtil.toCurrencyEntity(transactionDTO.getCurrency()));
//            transaction.setRecipient(MapperUtil.toUserEntity(transactionDTO.getRecipient()));
//            transaction.setSender(MapperUtil.toUserEntity(transactionDTO.getSender()));
            transaction.setTransactionDateTime(transactionDTO.getTransactionDateTime());
            Transaction updatedTransaction = transactionRepository.save(transaction);
            return MapperUtil.toTransactionDTO(updatedTransaction);
        } else {
            throw new TransactionNotFoundException("Transaction with id " + id + " not found");
        }
    }

    @Override
    public void delete(Long id) throws TransactionNotFoundException {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        if (optionalTransaction.isPresent()) {
            transactionRepository.delete(optionalTransaction.get());
        } else {
            throw new TransactionNotFoundException("Transaction with id " + id + " not found");
        }
    }
}
