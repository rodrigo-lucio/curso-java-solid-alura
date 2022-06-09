package br.com.lucio.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.lucio.ValidacaoException;
import br.com.lucio.model.Funcionario;

public class ReajusteSalarioService {

	// Removemos esse método da classe Funcionario e trouxemos pra cá
	public void reajustarSalarioFuncionario(Funcionario funcionario, BigDecimal aumento) {
		BigDecimal salarioAtual = funcionario.getSalario();
		BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
		if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
		}
		BigDecimal salarioReajustado = salarioAtual.add(aumento);
		funcionario.atualizarSalario(salarioReajustado);
	}
	
}
