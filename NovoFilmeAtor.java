package muitosparamuitos;

import Infra.DAO;

public class NovoFilmeAtor {

	public static void main(String[] args) {
		
		Filme Acao = new Filme("Star Wars EP 04" , 8.8);
		Filme Comedia = new Filme("Harrison Ford" , 8.0);
		
		Ator Harrison = new Ator("Harrison Ford");
		Ator Carrie = new Ator("Carrie Fisher");
		
		Acao.adicionarAtor(Harrison);
		Acao.adicionarAtor(Carrie);
		
		Comedia.adicionarAtor(Harrison);
		
		DAO<Filme> dao = new DAO<>();
		dao.incluirAtomico(Acao);
	}
}
