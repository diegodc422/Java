package Aplicacao;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class AgenciaJava {

	// Scanner para receber a entrada de dados do usuário
	static Scanner entrada = new Scanner(System.in);
	// Lista para exibir todas as contas 
	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {

		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}
	// exibe as operações 
	public static void operacoes() {
		int operacao = Integer.parseInt(JOptionPane.showInputDialog("-Escolha uma operação-" +				
				"     Opção(1) - Criar Conta" +			"     Opção (2) - Depositar" +
				"     Opção (3) - Sacar" + "     Opção (4) - Transferência" + 
				"     Opção (5) - Listar Contas" + "     Opção (6) - Sair" ));
		
		// menu de opções 
		switch (operacao) {
		// Opção 1
		case 1:
			CriarConta();
			break;

			// Opção 2
		case 2:
			Depositar();
			break;

		    // Opção 3
		case 3:
			Sacar();
			break;

			// Opção 4
		case 4:
			Transferencia();
			break;

			// Opção 5
		case 5:
			ListarContas();
			break;

			// Opção 6
		case 6:
			JOptionPane.showMessageDialog(null, "Operação encerrada com sucesso! ");
			System.exit(0);

			// Opção inválida
		default:
			JOptionPane.showMessageDialog(null, "Opção inválida!");
			JOptionPane.showMessageDialog(null, "Por favor escolha uma opção válida!");
			operacoes();
			break;
		}
	}

	// método para criar conta
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
		
		// adicionando nova conta à lista de contas
		contasBancarias.add(conta);
		JOptionPane.showMessageDialog(null,"Conta criada com sucesso!");
		// retorna ao menu de opções
		operacoes();
	}

	// método para encontrar conta 
	private static Conta encontrarConta(int numeroContas) {
		// conta criada inicializa com null para sugerir q o aplicativo foi criado e não há contas 
		Conta conta = null;
		// se a quantidade de contas representada por uma lista for maior que 0
		if (contasBancarias.size() > 0) {
			for (Conta c : contasBancarias) {
				// e se o número da conta bater com a conta criada
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

		// número da conta para depósito
		int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("número da conta para depósito"));
		Conta conta = encontrarConta(numeroConta);

		// se a conta existir aceite o valor do depósito
		if (conta != null) {
	Double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Valor do depósito"));
			// realiza o depósito
			conta.depositarDinheiro(valorDeposito);
			JOptionPane.showMessageDialog(null, "Valor depositado com sucesso!");
			// caso contrário recuse tudo
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível depositar o valor desejado ");
		}
		// volte ao menu de opções
		operacoes();
	}

	public static void Sacar() {

		// valor que o usuário irá escolher para sacar
		int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta para sacar"));
		
		// exibe a conta para sascar 
		Conta conta = encontrarConta(numeroConta);

		// se a conta existir
		if (conta != null) {
		Double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor para saque"));
			// realiza o valor informado do saque
			conta.sacarDinheiro(valorSaque);
		} else {
			// caso contrário recuse tudo
			JOptionPane.showMessageDialog(null, "Não foi possível realizar o saque");
		}
		// volte ao menu de opções
		operacoes();
	}

	public static void Transferencia() {

		// usuario digita o número da conta do remetente
		int numeroContaRemetente = Integer.parseInt(JOptionPane.showInputDialog("Número da conta do remetente"));
		// Verifica se a conta existe 
		Conta contaRemetente = encontrarConta(numeroContaRemetente);
		// se a conta existir, o usuário irá digitar o número da conta que irá realizar a transferência
		if (contaRemetente != null) {
			int numeroContaDestinatario = Integer.parseInt(JOptionPane.showInputDialog("Conta do destinatário"));
			// conta do destinatário verificada se for válida
			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
			// se a conta for diferente de nulo, ou seja, conta válida
			if (contaDestinatario != null) {
				Double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor da trasnferência"));
				// realiza a transferência para o destinatário
				contaRemetente.TransferirDinheiro(contaDestinatario, valor);
				// caso contrário recuse tudo
			}else {
				JOptionPane.showMessageDialog(null, "não foi possível realizar o depósito");
			}
		}
		// retorna ao menu de opções
		operacoes();
	}

	public static void ListarContas() {
		// se houver contas cadastradas
		if (contasBancarias.size() > 0) {
			// exiba todas elas
			for (Conta conta : contasBancarias) {
				JOptionPane.showInternalMessageDialog(null, conta);
			}
			// caso contrário recuse tudo
		} else {
			JOptionPane.showMessageDialog(null, "Não existe contas cadastradas");
		}
		// volte ao menu de opções
		operacoes();
	}
}
