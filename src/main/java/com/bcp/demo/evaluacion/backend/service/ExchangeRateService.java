package com.bcp.demo.evaluacion.backend.service;

import java.util.List;

import com.bcp.demo.evaluacion.backend.controller.model.CurrencyRequestDto;
import com.bcp.demo.evaluacion.backend.controller.model.CurrencyResponseDto;

import io.reactivex.Maybe;
import io.reactivex.Observable;

public interface ExchangeRateService {

	Maybe<CurrencyResponseDto> currency(CurrencyRequestDto request);
	
	Maybe<Void> create(List<CurrencyRequestDto> request);
	
	Observable<CurrencyResponseDto> currency();
}
