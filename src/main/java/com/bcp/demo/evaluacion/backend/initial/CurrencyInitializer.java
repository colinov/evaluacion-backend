package com.bcp.demo.evaluacion.backend.initial;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bcp.demo.evaluacion.backend.repository.CurrencyRepository;
import com.bcp.demo.evaluacion.backend.repository.model.CurrencyEntity;

@Component
public class CurrencyInitializer implements CommandLineRunner {

	@Autowired
	private CurrencyRepository currencyRepository;

	@Override
	public void run(String... args) throws Exception {
		List<CurrencyEntity> data = Arrays.asList(CurrencyEntity.of(null, "PEN", "USD", new BigDecimal("0.29")),
				CurrencyEntity.of(null, "USD", "PEN", new BigDecimal("3.45")));
		currencyRepository.saveAll(data);
	}
}
