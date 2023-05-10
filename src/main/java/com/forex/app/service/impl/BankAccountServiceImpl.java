package com.forex.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forex.app.dto.BankAccountDTO;
import com.forex.app.entity.BankAccount;
import com.forex.app.exception.BankAccountNotFoundException;
import com.forex.app.repository.BankAccountRepository;
import com.forex.app.service.BankAccountService;
import com.forex.app.util.MapperUtil;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    @Autowired
    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public BankAccountDTO save(BankAccountDTO bankAccountDto) {
        BankAccount bankAccount = MapperUtil.toBankAccountEntity(bankAccountDto);
        bankAccount = bankAccountRepository.save(bankAccount);
        return MapperUtil.toBankAccountDTO(bankAccount);
    }

    @Override
    public List<BankAccountDTO> findAll() {
        List<BankAccount> bankAccounts = bankAccountRepository.findAll();
        return MapperUtil.mapToBankAccountDtoList(bankAccounts);
    }

    @Override
    public BankAccountDTO findById(Long id) throws BankAccountNotFoundException {
        Optional<BankAccount> optionalBankAccount = bankAccountRepository.findById(id);
        if (optionalBankAccount.isEmpty()) {
            throw new BankAccountNotFoundException("Bank account not found with id: " + id);
        }
        BankAccount bankAccount = optionalBankAccount.get();
        return MapperUtil.toBankAccountDTO(bankAccount);
    }

    @Override
    public BankAccountDTO update(Long id, BankAccountDTO bankAccountDto) throws BankAccountNotFoundException {
        Optional<BankAccount> optionalBankAccount = bankAccountRepository.findById(id);
        if (optionalBankAccount.isEmpty()) {
            throw new BankAccountNotFoundException("Bank account not found with id: " + id);
        }
        BankAccount bankAccount = optionalBankAccount.get();
        bankAccount.setAccountNumber(bankAccountDto.getAccountNumber());
        bankAccount.setAccountHolderName(bankAccountDto.getAccountHolderName());
        bankAccount.setBank(MapperUtil.toBankEntity(bankAccountDto.getBank()));
        bankAccount = bankAccountRepository.save(bankAccount);
        return MapperUtil.toBankAccountDTO(bankAccount);
    }

    @Override
    public void delete(Long id) throws BankAccountNotFoundException {
        Optional<BankAccount> optionalBankAccount = bankAccountRepository.findById(id);
        if (optionalBankAccount.isEmpty()) {
            throw new BankAccountNotFoundException("Bank account not found with id: " + id);
        }
        bankAccountRepository.deleteById(id);
    }

}
