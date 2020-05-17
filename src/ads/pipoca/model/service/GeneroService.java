package ads.pipoca.model.service;

import java.io.IOException;
import java.util.ArrayList;

import ads.pipoca.model.dao.GeneroDAO;
import ads.pipoca.model.entity.Genero;

public class GeneroService {
	public ArrayList<Genero> listarGeneros() throws IOException {
		GeneroDAO dao = new GeneroDAO();
		return dao.listarGeneros();
	}
	
	public Genero buscarGenero(int id) throws IOException {
		GeneroDAO dao = new GeneroDAO();
		return dao.buscarGenero(id);
	}
}
