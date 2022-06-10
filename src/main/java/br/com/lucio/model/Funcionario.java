package br.com.lucio.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Funcionario {

	private DadosPessoais dadosPessoais;

	public Funcionario(String nome, String cpf, Cargo cargo, BigDecimal salario, LocalDate dataUltimoReajuste, String empresaTerceirizada) {
		this.dadosPessoais = new DadosPessoais(nome, cpf, cargo, salario, dataUltimoReajuste);
	}
	
	public void atualizarSalario(BigDecimal novoSalario) {
		this.dadosPessoais.setSalario(novoSalario);
		this.setDataUltimoReajuste(LocalDate.now());
	}

	public Cargo getCargo() {
		return this.dadosPessoais.getCargo();
	}
	
	public BigDecimal getSalario() {
		return this.dadosPessoais.getSalario();
	}
	
	public LocalDate getDataUltimoReajuste() {
		return this.dadosPessoais.getDataUltimoReajuste();
	}

	public void setDataUltimoReajuste(LocalDate dataUltimoReajuste) {
		this.dadosPessoais.setDataUltimoReajuste(dataUltimoReajuste);
	}

	public void promover(Cargo novoCargo) {
		this.dadosPessoais.setCargo(novoCargo);
	}

}
