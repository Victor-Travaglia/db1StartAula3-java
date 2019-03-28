package br.com.db1.contaBancaria;

public class Cliente {
	
	private String nome;
	private String cpf;
	
	public Cliente(String nome, String cpf) {
		
		if (nome == null) {
			throw new RuntimeException("Nome � obrigat�rio");
		}
		
		if (nome.length() <= 5) {
			throw new RuntimeException("Nome deve ter no minimo 5 caracteres");
		}
		
		if (cpf == null) {
			throw new RuntimeException("CPF � obrigat�rio");
		}
		
		if (cpf.length() != 11) {
			throw new RuntimeException("CPF Inv�lido");
		}
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
}
