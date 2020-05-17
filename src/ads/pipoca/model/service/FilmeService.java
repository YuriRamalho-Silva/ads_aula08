package ads.pipoca.model.service;

import java.io.IOException;
import java.util.ArrayList;

import ads.pipoca.model.dao.FilmeDAO;
import ads.pipoca.model.entity.Filme;

public class FilmeService {
	FilmeDAO dao;
	
	public FilmeService() {
		this.dao = new FilmeDAO();
	}

	public int inserirFilme(Filme filme) throws IOException {
		return dao.inserirFilme(filme);
	}

	public Filme buscarFilme(int id) throws IOException {
		return dao.buscarFilme(id);
	}
	
	public Filme excluirFilme(int id) throws IOException {
		Filme filme = dao.buscarFilme(id);
		if (filme != null) {
			dao.excluirFilme(filme.getId());
			return filme;
		} else {
			return null;
		}
	}
	
	public ArrayList<Filme> listarFilmes() throws IOException {
		return dao.listarFilmes();
	}
	
	public ArrayList<Filme> listarFilmes(ArrayList<Integer> lista) throws IOException {
		ArrayList<Filme> filmes = new ArrayList<>();
		for(int id:lista) {
			filmes.add(buscarFilme(id));
		}
		return filmes;
	}

	public void atualizarFilme(Filme filme) throws IOException {
		dao.atualizarFilme(filme);
	}
}
