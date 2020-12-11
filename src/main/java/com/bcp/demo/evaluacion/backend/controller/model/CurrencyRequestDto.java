package com.bcp.demo.evaluacion.backend.controller.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyRequestDto {

	private String amount;
	private String sourceCurrency;
	private String destinyCurrency;
}
