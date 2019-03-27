package br.com.db1.contaBancaria;

public enum ContaBancariaTipo {
	POUCANCA("001"),
	CORRENTE("002");
	
	private String numero;
	
	private ContaBancariaTipo(String numero){
		this.numero = numero;
	}
	
	public String getNumero() {
		return numero;
	}
}
