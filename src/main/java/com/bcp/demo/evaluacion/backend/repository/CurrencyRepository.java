package com.bcp.demo.evaluacion.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcp.demo.evaluacion.backend.repository.model.CurrencyEntity;

public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Integer> {

	CurrencyEntity findByCodeAndCodeDestiny(String code, String codeDestiny);
}
