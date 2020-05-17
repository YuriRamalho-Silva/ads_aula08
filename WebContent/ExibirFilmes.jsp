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

<title>Compra de Filmes</title>

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
    <script>
    	var caixas = [];
    	function tratarBotoes(element){
    		if (element.checked){
    			caixas.push(element);
    		} else {
    			caixas.pop();
    		}
    		if (caixas.length == 0){
    			document.getElementById("btnVisualizar").disabled = true;
    			document.getElementById("btnComprar").disabled = true;
    		} else if (caixas.length == 1){
    			document.getElementById("btnVisualizar").disabled = false;
    			document.getElementById("btnComprar").disabled = false;
    		} else {
    			document.getElementById("btnVisualizar").disabled = true;
    			document.getElementById("btnComprar").disabled = false;
   			}
    	}
    </script>
</head>
<body>
	<!-- importa o menu do sistema -->
	<c:import url="Menu.jsp"/>
	<!-- conteiner principal -->
	<div class="container">
	<fmt:setLocale value="pt_BR"/>
	<div class="row">
		<h1>Lista de Filmes</h1>
		<hr>
	</div>
	<form action="comprar_filmes.do" method="POST">
	<!-- modal -->
	<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title">Excluir filme</h4>
		      </div>
		      <div class="modal-body">
		        <p>Confirma a exclusão do(s) filme(s)?</p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
		        <button type="submit" name="acao" value="btn-excluir-de-modal-listar-filmes-jsp" class="btn btn-danger">Excluir</button>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-striped">
				<tr>
				<th>&nbsp;</th><th>Pôster</th><th>Id</th><th>Título</th><th>Gênero</th><th>Diretor</th><th>Lançamento</th>
				</tr>
				<c:forEach var="filme" items="${filmes}" >
					<tr>
					<td><div class="checkbox">
						<label>
							<input type="checkbox" name="box${filme.id}" onClick="tratarBotoes(this)">
						</label>
						</div>
					</td>
					<td><img src="${filme.posterPath}" class="img-thumbnail" width="70"/></td>
					<td>${filme.id}</td> 
					<td>${filme.titulo}</td>
					<td>${filme.genero.nome}</td>
					<td>${filme.diretor}</td>
					<td><fmt:formatDate value="${filme.dataLancamento}" dateStyle="SHORT"/></td>
					</tr>
				</c:forEach>
				</table>
			</div>
		</div>
		<hr>
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" id="btnVisualizar" name="acao" value="btn-visualizar-de-exibir-filmes-jsp" class="btn btn-info" disabled>Visualizar</button>
					<button type="submit" class="btn btn-success" id="btnComprar" name="acao" value="btn-comprar-de-exibir-filmes-jsp" disabled>Comprar</button>
					<a href="index.jsp" class="btn btn-default">Voltar</a>
				</div>
			</div>
		</form>
		<br><br><br>
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