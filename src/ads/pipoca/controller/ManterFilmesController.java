package ads.pipoca.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.NoSuchElementException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.pipoca.model.entity.Filme;
import ads.pipoca.model.entity.Genero;
import ads.pipoca.model.service.FilmeService;
import ads.pipoca.model.service.GeneroService;

@WebServlet("/manter_filmes.do")
public class ManterFilmesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String acao = request.getParameter("acao");
		Filme filme = null;
		Genero genero = null;
		FilmeService fService = new FilmeService();
		GeneroService gService = new GeneroService();
		ArrayList<Genero> generos = null;
		String saida = "index.jsp";
		String id_filme = null;
		int idFilme = -1;
		String titulo = null;
		String descricao = null;
		String diretor = null;
		String idGenero = null;
		String data = null;
		String popularidade = null;
		String posterPath = null;
		SimpleDateFormat formater = null;
		java.util.Date dataLanc = null;
		Enumeration<String> pars = null;
		String par = null;
		ArrayList<Integer> listaIds = null;
		String[] vals = null;
		ArrayList<Filme> filmes = null;
		
		switch(acao) {
		case "menu-novo-menu-jsp":
			generos = gService.listarGeneros();
			request.setAttribute("generos", generos);
			saida = "InserirFilme.jsp";
			break;
		case "btn-visualizar-de-listar-filmes-jsp":
			pars = request.getParameterNames();
			listaIds = new ArrayList<>();
			try {
				while ((par = pars.nextElement()) != null) {
					if (par.startsWith("box")) {
						System.out.println(par +" = "+Arrays.toString(request.getParameterValues(par)));
						vals = request.getParameterValues(par);
						if (vals != null && vals.length > 0 && vals[0].equals("on")) {
							listaIds.add(Integer.parseInt(par.substring(3)));
						}
					}
				}
			} catch(NoSuchElementException nsee) {
			}
			System.out.println("Editar listaIds = "+listaIds);
		case "btn-mostrar-de-mostrar-filme-jsp":
			id_filme = request.getParameter("id_filme");
			if (id_filme != null) {
				idFilme = Integer.parseInt(id_filme);
			} else {
				if (listaIds != null && listaIds.size() > 0) {
					idFilme = listaIds.get(0);
				} else {
					idFilme = -1;
				}
				
			} 
			filme = fService.buscarFilme(idFilme);
			System.out.println(filme);
			request.setAttribute("filme", filme);
			saida = "Filme.jsp";
			break;
		case "btn-inserir-de-inserir-filme-jsp":
		    titulo = request.getParameter("titulo");
			descricao = request.getParameter("descricao");
			diretor = request.getParameter("diretor");
			idGenero = request.getParameter("genero");
			data = request.getParameter("data_lancamento");
			popularidade = request.getParameter("popularidade");
			posterPath = request.getParameter("poster_path");
			filme = new Filme();
			filme.setTitulo(titulo);
			filme.setDescricao(descricao);
			filme.setDiretor(diretor);
			formater = new SimpleDateFormat("yyyy-MM-dd");
			dataLanc = null;
			try {
				dataLanc = formater.parse(data);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			filme.setDataLancamento(dataLanc);
			filme.setPopularidade(Double.parseDouble(popularidade));
			filme.setPosterPath(posterPath);
			genero = gService.buscarGenero(Integer.parseInt(idGenero));
			filme.setGenero(genero);
			int id = fService.inserirFilme(filme);
			filme.setId(id);
			System.out.println(filme);
			request.setAttribute("filme", filme);
			saida = "Filme.jsp";
			break;
		case "btn-editar-de-listar-filmes-jsp":
			pars = request.getParameterNames();
			listaIds = new ArrayList<>();
			try {
				while ((par = pars.nextElement()) != null) {
					if (par.startsWith("box")) {
						System.out.println(par +" = "+Arrays.toString(request.getParameterValues(par)));
						vals = request.getParameterValues(par);
						if (vals != null && vals.length > 0 && vals[0].equals("on")) {
							listaIds.add(Integer.parseInt(par.substring(3)));
						}
					}
				}
			} catch(NoSuchElementException nsee) {
			}
			System.out.println("Editar listaIds = "+listaIds);
		case "btn-editar-de-filme-jsp":
			generos = gService.listarGeneros();
			request.setAttribute("generos", generos);
			id_filme = request.getParameter("id_filme");
			if (id_filme != null) {
				idFilme = Integer.parseInt(id_filme);
			} else {
				if (listaIds != null && listaIds.size() > 0) {
					idFilme = listaIds.get(0);
				} else {
					idFilme = -1;
				}
				
			} 
			filme = fService.buscarFilme(idFilme);
			request.setAttribute("filme", filme);
			System.out.println(filme);
			saida = "AtualizarFilme.jsp";
			break;
		case "btn-atualizar-de-atualizar-filme-jsp":
			id_filme = request.getParameter("id_filme");
			idFilme = Integer.parseInt(id_filme);
			titulo = request.getParameter("titulo");
			descricao = request.getParameter("descricao");
		    diretor = request.getParameter("diretor");
			idGenero = request.getParameter("genero");
			data = request.getParameter("data_lancamento");
			popularidade = request.getParameter("popularidade");
			posterPath = request.getParameter("poster_path");
			filme = new Filme();
			filme.setId(idFilme);
			filme.setTitulo(titulo);
			filme.setDescricao(descricao);
			filme.setDiretor(diretor);
			formater = new SimpleDateFormat("yyyy-MM-dd");
			dataLanc = null;
			try {
				dataLanc = formater.parse(data);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			filme.setDataLancamento(dataLanc);
			filme.setPopularidade(Double.parseDouble(popularidade));
			filme.setPosterPath(posterPath);
			genero = gService.buscarGenero(Integer.parseInt(idGenero));
			filme.setGenero(genero);
			System.out.println(filme);
			fService.atualizarFilme(filme);
			request.setAttribute("filme", filme);
			saida = "Filme.jsp";
			break;
		case "btn-excluir-de-modal-listar-filmes-jsp":
			pars = request.getParameterNames();
			listaIds = new ArrayList<>();
			filmes = new ArrayList<>();
			try {
				while ((par = pars.nextElement()) != null) {
					if (par.startsWith("box")) {
						System.out.println(par +" = "+Arrays.toString(request.getParameterValues(par)));
						vals = request.getParameterValues(par);
						if (vals != null && vals.length > 0 && vals[0].equals("on")) {
							listaIds.add(Integer.parseInt(par.substring(3)));
						}
					}
				}
			} catch(NoSuchElementException nsee) {
			}
			System.out.println("Excluir listaIds = "+listaIds);
			for(int idDel: listaIds) {
				try {
					filme = fService.excluirFilme(idDel);
					filmes.add(filme);
					System.out.println(filme);
				} catch(NumberFormatException nfe) {
					nfe.printStackTrace();
					filme = null;
				}
			}
			request.setAttribute("filmes", filmes);
			saida = "FilmeExcluido.jsp";
			break;
		case "btn-excluir-de-filme-jsp":
			id_filme = request.getParameter("id_filme");
			try {
				idFilme = Integer.parseInt(id_filme);
				filme = fService.excluirFilme(idFilme);
				System.out.println(filme);
			} catch(NumberFormatException nfe) {
				nfe.printStackTrace();
				filme = null;
			}
			filmes = new ArrayList<>();
			filmes.add(filme);
			request.setAttribute("filmes", filmes);
			saida = "FilmeExcluido.jsp";
			break;
		case "menu-listar-menu-jsp":
			filmes = fService.listarFilmes();
			request.setAttribute("filmes", filmes);
			saida = "ListaFilmes.jsp";
			break;
		}
		RequestDispatcher view = request.getRequestDispatcher(saida);
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
