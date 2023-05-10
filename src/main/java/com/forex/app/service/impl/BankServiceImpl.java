package com.forex.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forex.app.dto.BankDTO;
import com.forex.app.entity.Bank;
import com.forex.app.exception.BankNotFoundException;
import com.forex.app.repository.BankRepository;
import com.forex.app.service.BankService;
import com.forex.app.util.MapperUtil;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;

    @Override
    public BankDTO save(BankDTO bankDto) {
        Bank bank = MapperUtil.toBankEntity(bankDto);
        bank = bankRepository.save(bank);
        return MapperUtil.toBankDTO(bank);
    }

    @Override
    public List<BankDTO> findAll() {
        List<Bank> banks = bankRepository.findAll();
        return MapperUtil.mapToBankDtoList(banks);
    }

    @Override
    public BankDTO findById(Long id) throws BankNotFoundException {
        Optional<Bank> optionalBank = bankRepository.findById(id);
        Bank bank = optionalBank.orElseThrow(() -> new BankNotFoundException("Bank not found for id: " + id));
        return MapperUtil.toBankDTO(bank);
    }
/*
    @Override
    public BankDTO update(Long id, BankDTO bankDto) throws BankNotFoundException {
        Optional<Bank> optionalBank = bankRepository.findById(id);
        Bank bank = optionalBank.orElseThrow(() -> new BankNotFoundException("Bank not found for id: " + id));
        bank.setName(bankDto.getName());
        bank.setBankCode(bankDto.getBankCode());
        bank.setAccounts(MapperUtil.mapToBankAccountDtoList(bank.getAccounts()));
        bank = bankRepository.save(bank);
        return MapperUtil.toBankDTO(bank);
    }
*/
    @Override
    public void delete(Long id) throws BankNotFoundException {
        Optional<Bank> optionalBank = bankRepository.findById(id);
        Bank bank = optionalBank.orElseThrow(() -> new BankNotFoundException("Bank not found for id: " + id));
        bankRepository.delete(bank);
    }

@Override
public BankDTO update(Long id, BankDTO bank) throws BankNotFoundException {
	// TODO Auto-generated method stub
	return null;
}

}
