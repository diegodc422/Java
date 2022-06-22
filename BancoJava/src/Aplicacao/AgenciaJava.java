package Aplicacao;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class AgenciaJava {

	// Scanner para receber a entrada de dados do usu�rio
	static Scanner entrada = new Scanner(System.in);
	// Lista para exibir todas as contas 
	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {

		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}
	// exibe as opera��es 
	public static void operacoes() {
		int operacao = Integer.parseInt(JOptionPane.showInputDialog("-Escolha uma opera��o-" +				
				"     Op��o(1) - Criar Conta" +			"     Op��o (2) - Depositar" +
				"     Op��o (3) - Sacar" + "     Op��o (4) - Transfer�ncia" + 
				"     Op��o (5) - Listar Contas" + "     Op��o (6) - Sair" ));
		
		// menu de op��es 
		switch (operacao) {
		// Op��o 1
		case 1:
			CriarConta();
			break;

			// Op��o 2
		case 2:
			Depositar();
			break;

		    // Op��o 3
		case 3:
			Sacar();
			break;

			// Op��o 4
		case 4:
			Transferencia();
			break;

			// Op��o 5
		case 5:
			ListarContas();
			break;

			// Op��o 6
		case 6:
			JOptionPane.showMessageDialog(null, "Opera��o encerrada com sucesso! ");
			System.exit(0);

			// Op��o inv�lida
		default:
			JOptionPane.showMessageDialog(null, "Op��o inv�lida!");
			JOptionPane.showMessageDialog(null, "Por favor escolha uma op��o v�lida!");
			operacoes();
			break;
		}
	}

	// m�todo para criar conta
	public static void CriarConta() {
		Pessoa pessoa = new Pessoa();

		// recebe o nome 
		pessoa.setNome(JOptionPane.showInputDialog("nome:"));
		// recebe o cpf
		pessoa.setcpf(JOptionPane.showInputDialog("cpf:"));
		// recebe o e-mail
		pessoa.setEmail(JOptionPane.showInputDialog("e-mail:"));
		
		// objeto para criar a conta com os dados informados
		Conta conta = new Conta(pessoa);
		
		// adicionando nova conta � lista de contas
		contasBancarias.add(conta);
		JOptionPane.showMessageDialog(null,"Conta criada com sucesso!");
		// retorna ao menu de op��es
		operacoes();
	}

	// m�todo para encontrar conta 
	private static Conta encontrarConta(int numeroContas) {
		// conta criada inicializa com null para sugerir q o aplicativo foi criado e n�o h� contas 
		Conta conta = null;
		// se a quantidade de contas representada por uma lista for maior que 0
		if (contasBancarias.size() > 0) {
			for (Conta c : contasBancarias) {
				// e se o n�mero da conta bater com a conta criada
				if (c.getNumeroConta() == numeroContas) {
					// exiba a conta
					conta = c;
				} // fechando if
			} // fechando o forEach
		}
		// apresenta todas as contas criadas
		return conta;
	}

	public static void Depositar() {

		// n�mero da conta para dep�sito
		int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("n�mero da conta para dep�sito"));
		Conta conta = encontrarConta(numeroConta);

		// se a conta existir aceite o valor do dep�sito
		if (conta != null) {
	Double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Valor do dep�sito"));
			// realiza o dep�sito
			conta.depositarDinheiro(valorDeposito);
			JOptionPane.showMessageDialog(null, "Valor depositado com sucesso!");
			// caso contr�rio recuse tudo
		} else {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel depositar o valor desejado ");
		}
		// volte ao menu de op��es
		operacoes();
	}

	public static void Sacar() {

		// valor que o usu�rio ir� escolher para sacar
		int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("N�mero da conta para sacar"));
		
		// exibe a conta para sascar 
		Conta conta = encontrarConta(numeroConta);

		// se a conta existir
		if (conta != null) {
		Double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor para saque"));
			// realiza o valor informado do saque
			conta.sacarDinheiro(valorSaque);
		} else {
			// caso contr�rio recuse tudo
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel realizar o saque");
		}
		// volte ao menu de op��es
		operacoes();
	}

	public static void Transferencia() {

		// usuario digita o n�mero da conta do remetente
		int numeroContaRemetente = Integer.parseInt(JOptionPane.showInputDialog("N�mero da conta do remetente"));
		// Verifica se a conta existe 
		Conta contaRemetente = encontrarConta(numeroContaRemetente);
		// se a conta existir, o usu�rio ir� digitar o n�mero da conta que ir� realizar a transfer�ncia
		if (contaRemetente != null) {
			int numeroContaDestinatario = Integer.parseInt(JOptionPane.showInputDialog("Conta do destinat�rio"));
			// conta do destinat�rio verificada se for v�lida
			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
			// se a conta for diferente de nulo, ou seja, conta v�lida
			if (contaDestinatario != null) {
				Double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor da trasnfer�ncia"));
				// realiza a transfer�ncia para o destinat�rio
				contaRemetente.TransferirDinheiro(contaDestinatario, valor);
				// caso contr�rio recuse tudo
			}else {
				JOptionPane.showMessageDialog(null, "n�o foi poss�vel realizar o dep�sito");
			}
		}
		// retorna ao menu de op��es
		operacoes();
	}

	public static void ListarContas() {
		// se houver contas cadastradas
		if (contasBancarias.size() > 0) {
			// exiba todas elas
			for (Conta conta : contasBancarias) {
				JOptionPane.showInternalMessageDialog(null, conta);
			}
			// caso contr�rio recuse tudo
		} else {
			JOptionPane.showMessageDialog(null, "N�o existe contas cadastradas");
		}
		// volte ao menu de op��es
		operacoes();
	}
}
