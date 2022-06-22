package Aplicacao;

import javax.swing.JOptionPane;

import Utilitarios.Util;

public class Conta {

	// variável para contar as quantidade de contas
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

	// lê o nome
	public String getNome() {
		return nome;
	}
	// altera o nome
	public void setNome(String nome) {
		this.nome = nome;
	}

	// lê o número da conta
	public int getNumeroConta() {
		return numeroConta;
	}
	// altera o número da conta
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	// lê o nome da pessoa
	public Pessoa getPessoa() {
		return pessoa;
	}
	// altera o nome da pessoa 
	public void setPessoa(Pessoa pessoa) {
		this.pessoa= pessoa;
	}
	// lê o saldo da conta
	public Double getSaldo() {
		return saldo;
	}
	// altera o saldo da conta
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	// método String para retornar o nome, número da conta, cpf, e-mail e saldo
	public String toString() {
		return "\nNome: " + this.pessoa.getNome() + "\nNúmero da conta : " + this.getNumeroConta() + 
				"\nNúmero do CPF: " + this.pessoa.getcpf() + "\nE-mail: " + this.pessoa.getEmail() + "\nSaldo: "
				+ Util.doubleToString(this.getSaldo()) + "\n";
	}
	// método para depositar dinheiro na conta
	public void depositarDinheiro(Double valor) {
		// se o valor informado pelo usuário for maior que 0
		if (valor > 0) {
			// altere o valor atual realizando uma soma do valor atual + o valor depositado
			setSaldo(getSaldo() + valor);
			// se o valor for menor que 0 não faça nada
		} else {
			// caso contrário recuse tudo
			JOptionPane.showMessageDialog(null,"Não foi possível realizar o depósito!");
		}
	}
	// método para sacar dinheiro
	public void sacarDinheiro(Double valor) {
		// se o valor do saque for maior que 0 e o valor do saque estiver disponível na conta
		if (valor > 0 && this.getSaldo() >= valor) {
			// valor do saque será descontado do valor total da conta
			setSaldo(getSaldo() - valor);
			JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
			// caso contrário não faça nada
		} else {
			JOptionPane.showMessageDialog(null,"Não foi possível realizar o saque!");
		}
	}
	// método para transferir a valor da conta
	public void TransferirDinheiro(Conta contaParaDeposito, Double valor) {
		// se o valor da transferência for maior que 0 e o valor estiver no saldo
		if (valor > 0 && this.getSaldo() >= valor) {
			// saldo da conta - valor da transferência = saldo atual
			setSaldo(getSaldo() - valor);
			// retira o valor da conta e repassa para o beneficiário
			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			
			JOptionPane.showMessageDialog(null,"Transferência realizada com sucesso!");
			// caso contrário não faça nada
		} else {
			JOptionPane.showMessageDialog(null,"Não foi possível realizar a transferência");
		}
	}
}
