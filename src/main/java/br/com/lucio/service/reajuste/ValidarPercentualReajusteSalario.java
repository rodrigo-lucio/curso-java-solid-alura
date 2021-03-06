package br.com.lucio.service.reajuste;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.lucio.ValidacaoException;
import br.com.lucio.model.Funcionario;

public class ValidarPercentualReajusteSalario implements ValidacaoReajuste {

	@Override
	public void validar(Funcionario funcionario, BigDecimal aumento) {
		BigDecimal salarioAtual = funcionario.getSalario();
		BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
		if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
		}
	}
	
}
