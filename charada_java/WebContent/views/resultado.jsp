<%@page import="charada_java.models.Resposta"%>
<%@page import="charada_java.models.Charada"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Charadas</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	</head>
	<%
		Charada charada = (Charada)request.getAttribute("charada");
	%>
	<body>
		<div>
			<a href="/charada_java">Voltar ao Inicio.</a>
		</div>
		<div class="offset-md-3">
			<div class="container">
				<form method="post" action="charadas">
					<fieldset>
						<legend>FeedBack</legend>
						<input type="hidden" name="metodo" value="email">
						<div>
							<label class="col-sm-3">Respostas Corretas: </label><input type="text" class="col-sm-2" name="respostas-corretas" value="<%=request.getAttribute("respostas-corretas") %>" readonly="readonly"/><br />
						</div>
						<div>
							<label class="col-sm-3">Respostas Erradas: </label><input type="text" class="col-sm-2" name="respostas-erradas" value="<%=request.getAttribute("respostas-erradas") %>" readonly="readonly"/><br />
						</div>
						<div>
							<label class="col-sm-3">Receba os resultados por E-mail:</label><input class="col-sm-2" type="email" name="email">
						</div>
						<div class="offset-md-2">
							<input type="submit" value="Enviar para E-mail" />
						</div>
					</fieldset>
				</form>			
			</div>
			<div class="container">
				<form method="post" action="charadas">
					<fieldset>
						<legend>Deixe um Comentário</legend>
						<div>
							<label class="col-sm-3">Nome:</label><input class="col-sm-2" type="text" name="nome"/>
						</div>
						<div>
							<label class="col-sm-3">Comentario:</label>
						</div>
						<div class="col-sm-2">
							<textarea rows="4" cols="55" name="comentario"></textarea>
						</div>
						<div class="offset-md-2">
							<input type="button" value="Enviar Comentário" />
						</div>						
					</fieldset>
				</form>
			</div>
		</div>	
	</body>
	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

</html>