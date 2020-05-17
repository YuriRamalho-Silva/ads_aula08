package ads.pipoca.controller;

import java.io.IOException;
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
import javax.servlet.http.HttpSession;

import ads.pipoca.model.entity.Filme;
import ads.pipoca.model.service.FilmeService;

@WebServlet("/comprar_filmes.do")
public class ComprarFilmesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String acao = request.getParameter("acao");
		FilmeService fService = new FilmeService();
		String saida = "index.jsp";
		HttpSession session = request.getSession();
		ArrayList<Filme> carrinho = null;
		ArrayList<Integer> listaIds = null;
		Filme filme = null;
		ArrayList<Filme> filmes = null;
		int idFilme = -1;
		Object aux = null;

		switch (acao) {
		case "btn-comprar-de-exibir-filmes-jsp":
			ArrayList<Integer> lista = obterIds(request);
			 filmes = fService.listarFilmes(listaIds);
			// pegar o carrinho da sessão e ver se já tem filmes
			aux = session.getAttribute("filmes");
			if (aux != null && aux instanceof ArrayList<?>) {
				carrinho = (ArrayList<Filme>) aux;
				if (carrinho.size() > 0) {
					for (Filme f : filmes) {
						carrinho.add(f);
					}
				} else {
					carrinho = filmes;
				}
			} else {
				carrinho = filmes;
			}
			session.setAttribute("filmes", carrinho);
			saida = "Carrinho.jsp";
			break;
			
		case "menu-comprar-filmes-de-menu-jsp":
			filmes = fService.listarFilmes();
			request.setAttribute("filmes", filmes);
			saida = "ExibirFilmes.jsp";
			break;

		case "btn-visualizar-de-carrinho-jsp":
			listaIds = obterIds(request);
			if (listaIds != null && listaIds.size() > 0) {
				idFilme = listaIds.get(0);
			} else {
				idFilme = -1;
			}

			filme = fService.buscarFilme(idFilme);
			System.out.println(filme);
			request.setAttribute("filme", filme);
			saida = "Filme.jsp";
			break;
		
		case "btn-excluir-de-modal-carrinho-jsp":
			 lista = obterIds(request);
			 filmes = fService.listarFilmes(lista);
			// pegar o carrinho da sessão e ver se já tem filmes
			aux = session.getAttribute("filmes");
			if (aux != null && aux instanceof ArrayList<?>) {
				carrinho = (ArrayList<Filme>) aux;
				if (carrinho.size() > 0) {
					for (Filme f : filmes) {
						carrinho.add(f);
					}
				} else {
					carrinho = filmes;
				}
			} else {
				carrinho = filmes;
			}
			session.setAttribute("filmes", carrinho);
			saida = "Carrinho.jsp";
			break;
		}
		RequestDispatcher view = request.getRequestDispatcher(saida);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private ArrayList<Integer> obterIds(HttpServletRequest request) {
		Enumeration<String> pars = request.getParameterNames();
		ArrayList<Integer> listaIds = new ArrayList<>();
		String par;
		String[] vals = null;

		try {
			while ((par = pars.nextElement()) != null) {
				if (par.startsWith("box")) {
					System.out.println(par + " = " + Arrays.toString(request.getParameterValues(par)));
					vals = request.getParameterValues(par);
					if (vals != null && vals.length > 0 && vals[0].equals("on")) {
						listaIds.add(Integer.parseInt(par.substring(3)));
					}
				}
			}
		} catch (NoSuchElementException nsee) {
		}
		return listaIds;
	}

}
