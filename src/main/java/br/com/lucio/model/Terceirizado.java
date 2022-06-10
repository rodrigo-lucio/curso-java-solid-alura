package br.com.lucio.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;

@Getter
public class Terceirizado /*extends Funcionario */ { 

	private DadosPessoais dadosPessoais;
	private String empresaTerceirizada;
	
	public Terceirizado(String nome, String cpf, Cargo cargo, BigDecimal salario, LocalDate dataUltimoReajuste, String empresaTerceirizada) {
		this.dadosPessoais = new DadosPessoais(nome, cpf, cargo, salario, dataUltimoReajuste);
		this.empresaTerceirizada = empresaTerceirizada;
	}
	
	/* OBSERVAÇÕES */
	
	/*
	 * Seria um erro colocar o extends Funcionario na classe Terceirizado
	 * Seria uma herança indesejada
	 * Nesse caso preferimos utilizar a composição e extraimos os dados em comum para outra classe=DadosPessoais
	 * Não quebrando a implementação das de validação de reajuste e promoção de funcionário
	 * Pois essas regras não fazem sentido para um funcionário terceirizado
	 * 
	 * Isso iria ferir o L do Solid
	 * Liskov Substituition Principle 
	 * Utilizar a herança errada.
	 * 
	 * Como exemplo da foto da video aula, temos um pato normal e um de borracha.
	 * 
	 * O Pato de borracha se parece com o pato normal, mas não é.
	 * É parecido e tal, mas nao podemos substitir pelo pato de borracha
	 * 
	 * Mesma coisa aqui, não Podemos substituir Terceirizado por Funcionario.
	 * Pois iriamos causar um efeito colateral nas nossas classes de validação.
	 * 
	 * Só podemos aplicar herança se o objeto realmente for substituível pela sua classe mãe.
	 * 
	 * Ou também se ficassemos colocando if (funcionario instance of Terceirizado)
	 * Também é inadequado e começa a complicar o código
	 * 
	 * 
	 */

}
