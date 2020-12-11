package com.bcp.demo.evaluacion.backend.service.impl;

import java.math.BigDecimal;

import org.hibernate.HibernateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bcp.demo.evaluacion.backend.controller.model.CurrencyRequestDto;
import com.bcp.demo.evaluacion.backend.controller.model.CurrencyResponseDto;
import com.bcp.demo.evaluacion.backend.repository.CurrencyRepository;
import com.bcp.demo.evaluacion.backend.repository.model.CurrencyEntity;

import io.reactivex.observers.TestObserver;

@RunWith(MockitoJUnitRunner.class)
public class ExchangeRateServiceImplTest {

	@InjectMocks
	private ExchangeRateServiceImpl exchangeRateServiceImpl;

	@Mock
	private CurrencyRepository currencyRepository;

	@Test
	public void okTest() {
		CurrencyEntity entity = CurrencyEntity.of(1, "USD", "PEN", new BigDecimal("3.45"));
		Mockito.when(currencyRepository.findByCodeAndCodeDestiny(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(entity);
		CurrencyRequestDto request = new CurrencyRequestDto();
		request.setAmount("1");
		request.setDestinyCurrency("USD");
		request.setSourceCurrency("PEN");
		TestObserver<CurrencyResponseDto> test = exchangeRateServiceImpl.currency(request).test();
		test.awaitTerminalEvent();
		test.assertNoErrors();
		test.assertValue(value -> value.getAmountWithRate().equals("3.45"));
	}

	@Test
	public void errorTest() {
		Mockito.when(currencyRepository.findByCodeAndCodeDestiny(Mockito.anyString(), Mockito.anyString()))
				.thenThrow(new HibernateException("test"));
		CurrencyRequestDto request = new CurrencyRequestDto();
		request.setAmount("1");
		request.setDestinyCurrency("USD");
		request.setSourceCurrency("PEN");
		TestObserver<CurrencyResponseDto> test = exchangeRateServiceImpl.currency(request).test();
		test.awaitTerminalEvent();
		test.assertNoErrors();
	}
}
