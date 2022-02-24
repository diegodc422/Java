package Teste.basico.consultaFilme;

import Infra.DAO;

public class OberMediaFilmes {

	public static void main(String[] args) {
		
		DAO<NotaFilme> dao = new DAO<>(NotaFilme.class);
		NotaFilme nota = dao.consultarUm("ObterMediaGeralFilmes");
		
		System.out.println(nota.getMedia());
		
		dao.fechar();

	}

}
