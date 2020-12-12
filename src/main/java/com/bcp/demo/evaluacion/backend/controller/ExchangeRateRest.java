package com.bcp.demo.evaluacion.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.demo.evaluacion.backend.controller.model.CurrencyRequestDto;
import com.bcp.demo.evaluacion.backend.controller.model.CurrencyResponseDto;
import com.bcp.demo.evaluacion.backend.service.ExchangeRateService;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/exchange/rate")
public class ExchangeRateRest {

	@Autowired
	private ExchangeRateService exchangeRateService;

	@GetMapping("/currency")
	public Observable<CurrencyResponseDto> currencyRate() {
		log.info("Init get currencyRate method");
		return exchangeRateService.currency();
	}

	@PostMapping("/currency")
	public void currencyRate(@Validated @RequestBody List<CurrencyRequestDto> request) {
		log.info("Init post currencyRate method");
		exchangeRateService.create(request).subscribe();
	}

	@PostMapping("/")
	public Maybe<ResponseEntity<CurrencyResponseDto>> rate(@Validated @RequestBody CurrencyRequestDto request) {
		log.info("Init currencyRate method");
		return exchangeRateService.currency(request)
				.switchIfEmpty(Maybe.error(new RuntimeException("Not currency rate for the parameters")))
				.map(response -> ResponseEntity.ok(response));
	}
}
