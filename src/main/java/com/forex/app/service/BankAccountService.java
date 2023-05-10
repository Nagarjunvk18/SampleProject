package com.forex.app.service;

import java.util.List;

import com.forex.app.dto.BankAccountDTO;
import com.forex.app.exception.BankAccountNotFoundException;

public interface BankAccountService {
	BankAccountDTO save(BankAccountDTO bankAccount);

	List<BankAccountDTO> findAll();

	BankAccountDTO findById(Long id) throws BankAccountNotFoundException;

	BankAccountDTO update(Long id, BankAccountDTO bankAccount) throws BankAccountNotFoundException;

	void delete(Long id) throws BankAccountNotFoundException;
}
