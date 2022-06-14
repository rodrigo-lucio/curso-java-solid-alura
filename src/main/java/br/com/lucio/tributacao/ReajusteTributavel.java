package br.com.lucio.tributacao;

import java.math.BigDecimal;

public interface ReajusteTributavel extends Reajuste {
	
	BigDecimal valorImpostoDeRenda();
	
	/* OBSERVAÇÃO:
	 * 
	 * I do Solid: Interface Segregation Principle = Princípio da segregaçao de interface
	 * Uma classe não deve ser forçada a implementar métodos que não irá utilizar
	 * 
	 * Extendemos a interface Reajuste aqui, para implementar ReajusteTributavel na classe Promocao
	 * 
	 * Se apenas criássemos o método valorImpostoDeRenda() na interface Reajuste:
	 * Na classe Promocao faria sentido ter o método valorImpostoDeRenda()
	 * Já na classe Anuenio não, pois reajustes anuais não tem imposto de renda (por exemplo)
	 * 
	 * Fazendo dessa forma, na classe Anuenio apenas implementamos Reajuste, e na Promocao implementamos ReajusteTributavel que extends Reajuste
	 * 
	 */
	
}
