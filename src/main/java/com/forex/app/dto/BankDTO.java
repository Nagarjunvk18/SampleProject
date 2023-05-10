package com.forex.app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankDTO {

	@JsonIgnore
	private long id;
	private String bankCode;

	private String name;
	private List<BankAccountDTO> accounts;
}
