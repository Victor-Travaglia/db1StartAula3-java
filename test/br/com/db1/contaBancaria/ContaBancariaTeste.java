package br.com.db1.contaBancaria;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContaBancariaTeste {
	
	private ContaBancaria conta;
	private ContaBancaria contaAlvo;
	
	@Before
	public void init() {
		Cliente cliente = new Cliente("Victor Lopes", "99999999999");
	    conta = new ContaBancaria("1234", "0001", 1000.0, ContaBancariaTipo.CORRENTE, cliente);
	    contaAlvo = new ContaBancaria("2345", "0002", 0.0, ContaBancariaTipo.CORRENTE, cliente);
	}
	
	@Test
	public void deveSacarDinheiroDaConta() {
		conta.sacar(500.0);
		
		Assert.assertEquals(500.0, conta.getSaldo(), 0);
		Assert.assertEquals(1, conta.getHistoricos().size());
	}
	
	@Test
	public void deveDepositarDinheiroDaConta() {
		conta.depositar(500.0);
		
		Assert.assertEquals(1500.0, conta.getSaldo(), 0);
		Assert.assertEquals(1, conta.getHistoricos().size());
	}
	
	
	@Test(expected=RuntimeException.class)
	public void deveRetornarErroQuandoSaldoMenorQueSaque() {
		conta.sacar(2000.0);
	}
	
	@Test(expected=RuntimeException.class)
	public void deveRetornarErroQuandoSaldoNegativoOuZero() {
		conta.sacar(-2000.0);
	}
	
	@Test(expected=RuntimeException.class)
	public void deveRetornarErroQuandoDepositarValoresNegativosOuZero() {
		conta.depositar(-2000.0);
	}
	
	@Test
	public void deveTransferirValorDeUmaContaParaOutra() {
		conta.transferir(500.0, contaAlvo);
		
		Assert.assertEquals(500, conta.getSaldo(), 0);
		Assert.assertEquals(500, contaAlvo.getSaldo(), 0);
	}
}