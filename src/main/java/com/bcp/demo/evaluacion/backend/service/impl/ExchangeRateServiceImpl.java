package com.bcp.demo.evaluacion.backend.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcp.demo.evaluacion.backend.controller.model.CurrencyRequestDto;
import com.bcp.demo.evaluacion.backend.controller.model.CurrencyResponseDto;
import com.bcp.demo.evaluacion.backend.repository.CurrencyRepository;
import com.bcp.demo.evaluacion.backend.repository.model.CurrencyEntity;
import com.bcp.demo.evaluacion.backend.service.ExchangeRateService;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

	@Autowired
	private CurrencyRepository currencyRepository;

	@Override
	public Maybe<Void> create(List<CurrencyRequestDto> request) {
		request.forEach(item -> {
			currencyRepository.save(CurrencyEntity.of(null, item.getSourceCurrency(), item.getDestinyCurrency(),
					new BigDecimal(item.getRate())));
		});
		return Maybe.empty();
	}

	@Override
	public Observable<CurrencyResponseDto> currency() {
		List<CurrencyEntity> list = currencyRepository.findAll();
		List<CurrencyResponseDto> listResponse = new ArrayList<>();
		list.forEach(entity -> {
			CurrencyResponseDto response = new CurrencyResponseDto();
			response.setSourceCurrency(entity.getCode());
			response.setDestinyCurrency(entity.getCodeDestiny());
			response.setRate(entity.getRate().toPlainString());
			listResponse.add(response);
		});
		return Observable.fromIterable(listResponse);
	}

	@Override
	public Maybe<CurrencyResponseDto> currency(CurrencyRequestDto request) {
		log.info("Init currency method");
		log.info("request.source=" + request.getSourceCurrency());
		log.info("request.destiny=" + request.getDestinyCurrency());
		log.info("request.amount=" + request.getAmount());

		return getFromDatabase(request).switchIfEmpty(Maybe.empty()).flatMap(entity -> {
			log.info("entity getted=" + entity);
			BigDecimal rate = ((CurrencyEntity) entity).getRate();
			if (rate == null) {
				return Maybe.empty();
			}
			BigDecimal amountToTransform = new BigDecimal(request.getAmount());
			BigDecimal amountTransformed = amountToTransform.multiply(rate);
			CurrencyResponseDto response = new CurrencyResponseDto();
			response.setAmount(request.getAmount());
			response.setAmountWithRate(amountTransformed.toPlainString());
			response.setDestinyCurrency(request.getDestinyCurrency());
			response.setRate(rate.toPlainString());
			response.setSourceCurrency(request.getSourceCurrency());
			return Maybe.just(response);
		});
	}

	private Maybe<CurrencyEntity> getFromDatabase(CurrencyRequestDto request) {
		if (request.getSourceCurrency().contentEquals(request.getDestinyCurrency())) {
			return Maybe.just(
					CurrencyEntity.of(null, request.getDestinyCurrency(), request.getSourceCurrency(), BigDecimal.ONE));
		}
		CurrencyEntity entity = null;
		try {
			entity = currencyRepository.findByCodeAndCodeDestiny(request.getSourceCurrency(),
					request.getDestinyCurrency());
		} catch (HibernateException exc) {
			log.error(exc.getMessage(), exc);
		}
		if (entity == null) {
			return Maybe.empty();
		}
		return Maybe.just(entity);
	}
}
