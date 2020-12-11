package com.bcp.demo.evaluacion.backend.service;

import com.bcp.demo.evaluacion.backend.controller.model.CurrencyRequestDto;
import com.bcp.demo.evaluacion.backend.controller.model.CurrencyResponseDto;

import io.reactivex.Maybe;

public interface ExchangeRateService {

	Maybe<CurrencyResponseDto> currency(CurrencyRequestDto request);
}
