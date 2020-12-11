package com.bcp.demo.evaluacion.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.demo.evaluacion.backend.controller.model.CurrencyRequestDto;
import com.bcp.demo.evaluacion.backend.controller.model.CurrencyResponseDto;
import com.bcp.demo.evaluacion.backend.service.ExchangeRateService;

import io.reactivex.Maybe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/exchange/rate")
public class ExchangeRateRest {

	@Autowired
	private ExchangeRateService exchangeRateService;

	@PostMapping("/currency")
	public Maybe<ResponseEntity<CurrencyResponseDto>> currencyRate(@Validated @RequestBody CurrencyRequestDto request) {
		log.info("Init currencyRate method");
		return exchangeRateService.currency(request).map(response -> ResponseEntity.ok(response))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
}
