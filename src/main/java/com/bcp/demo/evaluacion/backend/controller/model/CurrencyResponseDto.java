package com.bcp.demo.evaluacion.backend.controller.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyResponseDto {

	private String amount;
	private String amountWithRate;
	private String sourceCurrency;
	private String destinyCurrency;
	private String rate;
}
