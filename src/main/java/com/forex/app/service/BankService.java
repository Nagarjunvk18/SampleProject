package com.forex.app.service;

import java.util.List;

import com.forex.app.dto.BankDTO;
import com.forex.app.exception.BankNotFoundException;

public interface BankService {
	BankDTO save(BankDTO bank);

	List<BankDTO> findAll();

	BankDTO findById(Long id) throws BankNotFoundException;

	BankDTO update(Long id, BankDTO bank) throws BankNotFoundException;

	void delete(Long id) throws BankNotFoundException;
}
