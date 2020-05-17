<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp">Hora da Pipoca</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="nav-item dropdown">
                    	<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Filme</a>
                    		<ul class="dropdown-menu">
  						  	<li><a class="dropdown-item" href="manter_filmes.do?acao=menu-novo-menu-jsp">Novo</a></li>
  						   	<li><a class="dropdown-item" href="MostrarFilme.jsp">Procurar</a></li>
  						   	<li><a class="dropdown-item" href="manter_filmes.do?acao=menu-listar-menu-jsp">Listar</a></li>
						</ul>
                    </li>
					<li><a href="comprar_filmes.do?acao=menu-comprar-filmes-de-menu-jsp">Comprar Filmes</a></li>
					<li><a href="#">Carrinho de Compras</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<br><br><br><br>