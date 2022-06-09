package br.com.lucio.service;

import java.math.BigDecimal;

import br.com.lucio.model.Funcionario;

public interface ValidacaoReajuste {

	void validar(Funcionario funcionario, BigDecimal aumento);

}
