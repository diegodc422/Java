package Teste.basico.consulta;

import java.util.List;

import Infra.DAO;
import muitosparamuitos.Ator;
import muitosparamuitos.Filme;

public class ObterFilmes {

	public static void main(String[] args) {
		
		DAO<Filme> dao = new DAO<>(Filme.class);
		List<Filme> filmes = dao.consultar("FilmesNotaMaiorQue", "nota", 8.0);
		
		for(Filme filme : filmes) {
			System.out.println(filme.getNome() + filme.getNota());
			
			for(Ator ator: filme.getAtores()) {
				System.out.println(ator.getNome());
			}
		}
	}
}
