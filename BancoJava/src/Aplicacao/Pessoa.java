package Aplicacao;

public class Pessoa {

	@SuppressWarnings("unused")
	private static int contador = 1;

	private String nome;
	private String cpf;
	private String email;
	
	// construtor padrão
	public Pessoa (){
		
	}
	// construtor para receber nome, cpf, e-mail, contador
	public Pessoa(String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		contador += 1;
	}
	// lê o nome da pessoa
	public String getNome() {
		return nome;
	}
	// modifica o nome da pessoa
	public void setNome(String nome) {
		this.nome = nome;
	}
	// lê o cpf
	public String getcpf() {
		return cpf;
	}
	// modifica o cpf
	public void setcpf(String cpf) {
		this.cpf = cpf;
	}
	// lê o e-mail
	public String getEmail() {
		return email;
	}
	// modifica o e-mail
	public void setEmail(String email) {
		this.email = email;
	}
}
