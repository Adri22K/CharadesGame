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
		<style>
			#interna {
				left:20%;
				top:50%;
				margin-left:-100px; /* Metade do valor da Largura */
				margin-top:-50px; /* Metade da valor da Altura */
				position:absolute;
			}
		</style>
	</head>
	<%
		Charada charada = (Charada)request.getAttribute("charada");
	%>
	<body>
		<div class="container">
			<div id="interna">
				<form method="post" action="charadas">
					<fieldset>
						<input type="hidden" name="numero-charada" value="<%=request.getAttribute("numero")%>"/>
						<Legend><%=charada.getTexto()%></Legend>
						<% for (Resposta resposta : charada.getRespostas()) { %>
					 		<input type="checkbox" class="resposta-list" name="resposta-opcao" value="<%=resposta.getLetra()%>"><%=resposta.getLetra()%> .- <%=resposta.getTexto()%> <br />
						<% } %>
						<input class="btn btn-secondary" type="submit" value="Responder" />   
					</fieldset>
				</form>
			</div>
		</div>	
	</body>
	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
	<script type="text/javascript">
    $('.resposta-list').on('change', function() {
        $('.resposta-list').not(this).prop('checked', false);  
    });
  </script>

</html>