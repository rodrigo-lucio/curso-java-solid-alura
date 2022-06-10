package br.com.lucio.service.promocao;

import br.com.lucio.ValidacaoException;
import br.com.lucio.model.Cargo;
import br.com.lucio.model.Funcionario;

public class PromocaoService {

	public void promover(Funcionario funcionario, boolean metaBatida) {
		Cargo cargoAtual = funcionario.getCargo();
		if (Cargo.GERENTE.equals(cargoAtual)) {
			throw new ValidacaoException("Gerentes não podem ser promovidos");
		}

		if (!metaBatida) {
			throw new ValidacaoException("Funcionario não bateu a meta");
		}
		
		Cargo novoCargo = cargoAtual.getProximoCargo();
		funcionario.promover(novoCargo);
		
	}

}
