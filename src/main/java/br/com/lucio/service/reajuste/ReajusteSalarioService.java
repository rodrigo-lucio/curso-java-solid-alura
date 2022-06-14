package br.com.lucio.service.reajuste;

import java.math.BigDecimal;
import java.util.List;

import br.com.lucio.model.Funcionario;

public class ReajusteSalarioService {

	// No spring poderia ter um @Autowired ou @Inject
	private List<ValidacaoReajuste> validacoes;
	
	public ReajusteSalarioService(List<ValidacaoReajuste> validacoes) {
		this.validacoes = validacoes;
	}

	public void reajustarSalarioFuncionario(Funcionario funcionario, BigDecimal aumento) {
		validacoes.forEach(validacao -> validacao.validar(funcionario, aumento));
		BigDecimal salarioReajustado = funcionario.getSalario().add(aumento);
		funcionario.atualizarSalario(salarioReajustado);
	}

	/* OBSERVAÇÕES */
	
	/* 
	* 1) 
	* Removemos o método reajustarSalarioFuncionario da classe Funcionario e trouxemos pra cá
	* S do Solid - Single responsability pinciple
	* Uma Classe deve ter apenas um motivo para mudar, seria o motivo que tenha a ver com ela.
	* E nãoo sair mexendo no sistema todo
	*
	*
	* 2)
	* Adicionamos uma lista de validadores, onde injetamos todas as classes que implementam essa interface
	* Com o forEach fazemos todas as validações
	* Assim, a nossa classe está aberta para extensão fechada para modificação
	* O do Solid - Open Closed Principle ou princípio do aberto fechado
	* Assim cada vez que surgir uma nova regra para esse tipo de validação
	* apenas criamos uma nova classe e implementamos a interface
	* 
	* Essa regra no solid vale para classes, módulos, funções, etc.
	* 
	* 
	* 3) Para não termos que ficar instanciando todas as implementações da interface ValidacaoReajuste
	* ex: ValidarPercentualReajusteSalario validacao1 = new ValidarPercentualReajusteSalario();
	*     ValidarPeriodicidadeEntreReajustes validacao2 = new ValidarPeriodicidadeEntreReajustes();
	*     
	* Passamos para o nosso construtor recebeber essa lista de implementaçoes da interface X.
	* Dependendo de interfaces e não de implementações Assim não quebramos o I do SOLID.
	* Dependency Inversion Principlev = Principio da inversão de dependência
	* Ou seja, invertemos a dependencia para que ela nao seja instanciada no validador     
	* Referenciamos a interface no construtor
	* Nao sabemos quais e quantas classes serao passadas para o List do contrutor
	* A classe não depende de outras classes concretas/implementações.
	* Classes são coisas que mexemos o tempo inteiro, e interface não. Costuma mudar menos e ser mais estável.
	* 
	* Geralmente quando implementamos o O do Solid, já somos induzidos a implementar o S e o D juntos.
	* Separando a responsabilidade e invertendo a dependencia.
	* 
	* 
	*/
	
	
	
	
	
}
