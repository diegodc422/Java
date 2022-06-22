package Aplicacao;

import javax.swing.JOptionPane;

import Utilitarios.Util;

public class Conta {

	// vari�vel para contar as quantidade de contas
	private static int contadorDeContas = 1;

	private int numeroConta;
	private String nome;
	private Pessoa pessoa;
	private Double saldo = 0.0;
	
	// construtor da classe
	public Conta(Pessoa pessoa) {
		 this.numeroConta = Conta.contadorDeContas;
	     this.pessoa= pessoa;
	     Conta.contadorDeContas += 1;
	}

	// l� o nome
	public String getNome() {
		return nome;
	}
	// altera o nome
	public void setNome(String nome) {
		this.nome = nome;
	}

	// l� o n�mero da conta
	public int getNumeroConta() {
		return numeroConta;
	}
	// altera o n�mero da conta
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	// l� o nome da pessoa
	public Pessoa getPessoa() {
		return pessoa;
	}
	// altera o nome da pessoa 
	public void setPessoa(Pessoa pessoa) {
		this.pessoa= pessoa;
	}
	// l� o saldo da conta
	public Double getSaldo() {
		return saldo;
	}
	// altera o saldo da conta
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	// m�todo String para retornar o nome, n�mero da conta, cpf, e-mail e saldo
	public String toString() {
		return "\nNome: " + this.pessoa.getNome() + "\nN�mero da conta : " + this.getNumeroConta() + 
				"\nN�mero do CPF: " + this.pessoa.getcpf() + "\nE-mail: " + this.pessoa.getEmail() + "\nSaldo: "
				+ Util.doubleToString(this.getSaldo()) + "\n";
	}
	// m�todo para depositar dinheiro na conta
	public void depositarDinheiro(Double valor) {
		// se o valor informado pelo usu�rio for maior que 0
		if (valor > 0) {
			// altere o valor atual realizando uma soma do valor atual + o valor depositado
			setSaldo(getSaldo() + valor);
			// se o valor for menor que 0 n�o fa�a nada
		} else {
			// caso contr�rio recuse tudo
			JOptionPane.showMessageDialog(null,"N�o foi poss�vel realizar o dep�sito!");
		}
	}
	// m�todo para sacar dinheiro
	public void sacarDinheiro(Double valor) {
		// se o valor do saque for maior que 0 e o valor do saque estiver dispon�vel na conta
		if (valor > 0 && this.getSaldo() >= valor) {
			// valor do saque ser� descontado do valor total da conta
			setSaldo(getSaldo() - valor);
			JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
			// caso contr�rio n�o fa�a nada
		} else {
			JOptionPane.showMessageDialog(null,"N�o foi poss�vel realizar o saque!");
		}
	}
	// m�todo para transferir a valor da conta
	public void TransferirDinheiro(Conta contaParaDeposito, Double valor) {
		// se o valor da transfer�ncia for maior que 0 e o valor estiver no saldo
		if (valor > 0 && this.getSaldo() >= valor) {
			// saldo da conta - valor da transfer�ncia = saldo atual
			setSaldo(getSaldo() - valor);
			// retira o valor da conta e repassa para o benefici�rio
			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			
			JOptionPane.showMessageDialog(null,"Transfer�ncia realizada com sucesso!");
			// caso contr�rio n�o fa�a nada
		} else {
			JOptionPane.showMessageDialog(null,"N�o foi poss�vel realizar a transfer�ncia");
		}
	}
}
