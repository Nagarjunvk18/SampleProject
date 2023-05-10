package com.forex.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountDTO {

	@JsonIgnore
	private long id;
	private String accountNumber;
	private String accountHolderName;
	private BankDTO bank;

}
