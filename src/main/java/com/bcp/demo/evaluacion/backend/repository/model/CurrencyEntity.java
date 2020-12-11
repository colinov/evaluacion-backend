package com.bcp.demo.evaluacion.backend.repository.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Entity(name = "currency")
public class CurrencyEntity {

	@Id
	@GeneratedValue
	private Integer id;
	private String code;
	private String codeDestiny;
	private BigDecimal rate;
}
