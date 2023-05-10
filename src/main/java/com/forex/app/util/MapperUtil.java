package com.forex.app.util;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import com.forex.app.dto.BankAccountDTO;
import com.forex.app.dto.BankDTO;
import com.forex.app.dto.CurrencyConversionDTO;
import com.forex.app.dto.CurrencyDTO;
import com.forex.app.dto.CurrencyRateDTO;
import com.forex.app.dto.TransactionDTO;
import com.forex.app.dto.TransactionFeeDTO;
import com.forex.app.entity.Bank;
import com.forex.app.entity.BankAccount;
import com.forex.app.entity.Currency;
import com.forex.app.entity.CurrencyConversion;
import com.forex.app.entity.CurrencyRate;
import com.forex.app.entity.Transaction;
import com.forex.app.entity.TransactionFee;

public class MapperUtil {
	private static final ModelMapper MAPPER = new ModelMapper();

	// Bank & BankDTO

	public static BankDTO toBankDTO(Bank bank) {
		return MAPPER.map(bank, BankDTO.class);
	}

	public static Bank toBankEntity(BankDTO bankDto) {
		return MAPPER.map(bankDto, Bank.class);
	}

	public static List<BankDTO> mapToBankDtoList(List<Bank> bankList) {
		return MAPPER.map(bankList, new TypeToken<List<BankDTO>>() {
		}.getType());
	}

	// BankAccount & BankAccountDTO
	public static BankAccountDTO toBankAccountDTO(BankAccount bank) {
		return MAPPER.map(bank, BankAccountDTO.class);
	}

	public static BankAccount toBankAccountEntity(BankAccountDTO bankAccountDto) {
		return MAPPER.map(bankAccountDto, BankAccount.class);
	}

	public static List<BankAccountDTO> mapToBankAccountDtoList(List<BankAccount> bankList) {
		return MAPPER.map(bankList, new TypeToken<List<BankAccountDTO>>() {
		}.getType());
	}

	// CurrencyDTo & Currency
	public static CurrencyDTO toCurrencyDTO(Currency currency) {
		return MAPPER.map(currency, CurrencyDTO.class);
	}

	public static Currency toCurrencyEntity(CurrencyDTO currencyDto) {
		return MAPPER.map(currencyDto, Currency.class);
	}

	public static List<CurrencyDTO> mapToCurrencyDtoList(List<Currency> currencyList) {
		return MAPPER.map(currencyList, new TypeToken<List<CurrencyDTO>>() {
		}.getType());
	}

	// CurrencyConversion & CurrencyConversion
	public static CurrencyConversionDTO toCurrencyConversionDTO(CurrencyConversion currency) {
		return MAPPER.map(currency, CurrencyConversionDTO.class);
	}

	public static CurrencyConversion toCurrencyConversionEntity(CurrencyConversionDTO currencyConversionDto) {
		return MAPPER.map(currencyConversionDto, CurrencyConversion.class);
	}

	public static List<CurrencyConversionDTO> mapToCurrencyConversionDtoList(List<CurrencyConversion> currencyList) {
		return MAPPER.map(currencyList, new TypeToken<List<CurrencyConversionDTO>>() {
		}.getType());
	}

	// CurrencyRateDTO & CurrencyRate
	public static CurrencyRateDTO toCurrencyRateDTO(CurrencyRate currency) {
		return MAPPER.map(currency, CurrencyRateDTO.class);
	}

	public static CurrencyRate toCurrencyRateEntity(CurrencyRateDTO currencyDto) {
		return MAPPER.map(currencyDto, CurrencyRate.class);
	}

	public static List<CurrencyRateDTO> mapToCurrencyRateDtoList(List<CurrencyRate> currencyList) {
		return MAPPER.map(currencyList, new TypeToken<List<CurrencyRateDTO>>() {
		}.getType());
	}

	// TransactionDTO
	public static TransactionDTO toTransactionDTO(Transaction transaction) {
		return MAPPER.map(transaction, TransactionDTO.class);
	}

	public static Transaction toTransactionEntity(TransactionDTO transactionDto) {
		return MAPPER.map(transactionDto, Transaction.class);
	}

	public static List<TransactionDTO> mapToTransactionDtoList(List<Transaction> transactionList) {
		return MAPPER.map(transactionList, new TypeToken<List<TransactionDTO>>() {
		}.getType());
	}

	// TransactionFeeDTO
	public static TransactionFeeDTO toTransactionFeeDTO(TransactionFee transactionFee) {
		return MAPPER.map(transactionFee, TransactionFeeDTO.class);
	}

	public static TransactionFee toTransactionFeeEntity(TransactionFeeDTO transactionFeeDto) {
		return MAPPER.map(transactionFeeDto, TransactionFee.class);
	}

	public static List<TransactionFeeDTO> mapToTransactionFeeDtoList(List<TransactionFee> transactionFeeList) {
		return MAPPER.map(transactionFeeList, new TypeToken<List<TransactionFeeDTO>>() {
		}.getType());
	}

}
