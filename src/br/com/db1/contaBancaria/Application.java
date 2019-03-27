package br.com.db1.contaBancaria;

public class Application {

	public static void main(String[] args) {
		
		Cliente cliente = new Cliente("victor", "11111111111");
		ContaBancaria conta = new ContaBancaria("123","001", 1000.0, ContaBancariaTipo.CORRENTE, cliente);
	}
}
