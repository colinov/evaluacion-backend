package com.bcp.demo.evaluacion.backend.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.bcp.demo.evaluacion.backend.controller.model.CurrencyRequestDto;
import com.bcp.demo.evaluacion.backend.controller.model.CurrencyResponseDto;
import com.bcp.demo.evaluacion.backend.service.ExchangeRateService;

import io.reactivex.Maybe;
import io.reactivex.observers.TestObserver;

@RunWith(MockitoJUnitRunner.class)
public class ExchangeRateRestTest {

	@InjectMocks
	private ExchangeRateRest exchangeRateRest;

	@Mock
	private ExchangeRateService exchangeRateService;

	@Test
	public void okTest() {
		CurrencyRequestDto request = new CurrencyRequestDto();
		request.setAmount("1");
		CurrencyResponseDto response = new CurrencyResponseDto();
		response.setAmountWithRate("3.45");
		response.setRate("3.45");
		Mockito.when(exchangeRateService.currency(Mockito.any())).thenReturn(Maybe.just(response));
		TestObserver<ResponseEntity<CurrencyResponseDto>> test = exchangeRateRest.rate(request).test();
		test.awaitTerminalEvent();
		test.assertNoErrors();
		test.assertValue(value -> value.getBody() != null);
		test.assertValue(value -> value.getBody().getAmountWithRate().equals("3.45"));
	}

	@Test
	public void emptyTest() {
		CurrencyRequestDto request = new CurrencyRequestDto();
		request.setAmount("1");
		Mockito.when(exchangeRateService.currency(Mockito.any())).thenReturn(Maybe.empty());
		TestObserver<ResponseEntity<CurrencyResponseDto>> test = exchangeRateRest.rate(request).test();
		test.awaitTerminalEvent();
		test.assertError(RuntimeException.class);
	}
}
