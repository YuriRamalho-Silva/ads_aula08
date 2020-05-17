<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<link rel="canonical"
	href="https://getbootstrap.com/docs/3.3/examples/starter-template/">

<title>Filme</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="starter-template.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<!-- modal -->
	<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Excluir filme</h4>
      </div>
      <div class="modal-body">
        <p>Confirma a exclusão do filme #${filme.id}-${filme.titulo}?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
        <a href="manter_filmes.do?acao=btn-excluir-de-filme-jsp&id_filme=${filme.id}" class="btn btn-danger">Excluir</a>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
	<!-- importa o menu do sistema -->
	<c:import url="Menu.jsp"/>
	<!-- conteiner principal -->
	<div class="container">
	<fmt:setLocale value="pt_BR"/>
	<c:if test="${empty filme}">
		<div class="row">
			<h3 class="bg-danger" >Filme não encontrado.</h3>
		</div>
		<div class="row">
			<hr>
			<a href="MostrarFilme.jsp" class="btn btn-default">Voltar</a>
		</div>
	</c:if>
	<c:if test="${not empty filme}">
		<div class="row">
			<h1>#${filme.id} - ${filme.titulo}</h1>
			<br>
		</div>
		<div class="row">
			<div class="col-md-3">
				<img src="${filme.posterPath}" class="img-responsive">
			</div>
			<div class="col-md-9">
				<p><strong>Gênero: </strong>${filme.genero.nome}</p>
				<p><strong>Diretor: </strong>${filme.diretor}</p>
				<p><strong>Lançamento: </strong>
				<fmt:formatDate value="${filme.dataLancamento}" dateStyle="SHORT"/></p>
				<p><strong>Descrição: </strong>${filme.descricao}</p>
				<p><strong>Popularidade: </strong>
				<fmt:formatNumber value="${filme.popularidade}" minFractionDigits="2"
				maxFractionDigits="2"/>
				</p>
			</div>
		</div>
		<hr />
			<div id="actions" class="row">
				<div class="col-md-12">
					<a href="manter_filmes.do?acao=btn-editar-de-filme-jsp&id_filme=${filme.id}" class="btn btn-primary">Editar</a> 
					<a href="#" class="btn btn-danger" data-toggle="modal" data-target="#delete-modal">Excluir</a> 
					<a href="index.jsp" class="btn btn-default">Voltar</a>
				</div>
			</div>
		</c:if>
	</div><!-- /.container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>