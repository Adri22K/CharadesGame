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
	<body>
		<div class="container">
			<div class="offset-md-2" >
				<div>
					<img src="https://www.turminha.com.br/sites/default/files/styles/image_blog_805x503/public/jogos-de-adivinhacoes-charadas-na-educacao-infantil-o-que-e-o-que-e-blog.png" />
				</div>
				<div>
					<button id="btnIniciar">Começar o Jogo.</button>
				</div>
			</div>
		</div>	
	</body>
	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
	<script type="text/javascript">
    	$("#btnIniciar").click(function() {
    		window.location.href="charadas";
    	})
  	</script>

</html>