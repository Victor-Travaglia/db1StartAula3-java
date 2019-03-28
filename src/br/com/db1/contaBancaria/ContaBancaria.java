package br.com.db1.contaBancaria;

import java.util.ArrayList;
import java.util.List;

public class ContaBancaria {
	
	private String numero;
	private String agencia;
	private Double saldo;
	private ContaBancariaTipo tipo = ContaBancariaTipo.CORRENTE;
	private List<ContaBancariaHistorico> historicos = new ArrayList<>();
	private Cliente cliente;
	
	public ContaBancaria(String numero, String agencia, Double saldo, ContaBancariaTipo tipo, Cliente cliente) {
		this.numero = numero;
		this.agencia = agencia;
		this.saldo = saldo;
		this.tipo = tipo;
		this.cliente = cliente;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public List<ContaBancariaHistorico> getHistoricos() {
		return this.historicos;
	}
	
	public void sacar(Double valor) {
		if (valor > saldo) {
			throw new RuntimeException("Saldo Insuficiente");
		}
		
		if (valor <= 0) {
			throw new RuntimeException("Saque deve conter valores maiores do que 0");
		}
		this.saldo -= valor;
		ContaBancariaHistorico historico = new ContaBancariaHistorico(ContaBancariaTipoOperacao.SAIDA, valor);
		this.historicos.add(historico);
	}
	
	public void depositar(Double valor) {
		if (valor <= 0) {
			throw new RuntimeException("Depósito deve conter valores maiores do que 0");
		}
		this.saldo += valor;
		ContaBancariaHistorico historico = new ContaBancariaHistorico(ContaBancariaTipoOperacao.ENTRADA, valor);
		this.novoHistorico(ContaBancariaTipoOperacao.ENTRADA, valor);
	}
	
	public void transferir(Double valor, ContaBancaria contaAlvo) {
		if (valor <= 0) {
			throw new RuntimeException("Valor para a transferência invalido");
		}
		
		if (contaAlvo == null) {
			throw new RuntimeException("Conta do destinatário é obrigatória");
		}
		
		this.sacar(valor);
		contaAlvo.depositar(valor);
	}
	
	private void novoHistorico(ContaBancariaTipoOperacao tipo, Double valor) {
		ContaBancariaHistorico historico = new ContaBancariaHistorico(ContaBancariaTipoOperacao.ENTRADA,valor);
		this.historicos.add(historico);
		
	}
}
