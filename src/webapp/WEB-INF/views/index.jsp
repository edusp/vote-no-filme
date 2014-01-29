<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<link href="<c:url value='/resources/css/bootstrap.css'/>" rel="stylesheet">
<link href="<c:url value='/resources/css/custon_form.css'/>" rel="stylesheet">

<link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet">

<script type="text/javascript" src='<c:url value="/resources/js/jquery-1.10.2.min.js"/>' ></script>
<script type="text/javascript" src='<c:url value="/resources/js/jquery.validate.js"/>' ></script>
<script type="text/javascript" src='<c:url value="/resources/js/votacao/votacao.js"/>' ></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>INDEX</title>
</head>
<body>
	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
	
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span> <span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">VOTAÇÃO</a>
			</div>
		</div>
	</div>

	<br />
	<br />

	<div class="container">
		<hr>	

		<fieldset id="exibirFilmes">
			<legend class="text-center">ESCOLHA SEU FILME FAVORITO</legend>
				
				<div id="imagens">
			
				</div>
			
			<span class="spacer"></span>
		</fieldset>
		
		
		<br />
		<div id="formulario" style="display: none;">
		
			<form role="form" action="<c:url value='ranking'/>" method="post"  class="form-signin" id="form">					
					
				<fieldset>
		        	<legend class="text-center">Preencha os dados para ver o Ranking dos filmes</legend>
			      		<input type="text" name="nome" class="input-block-level form-control" placeholder="Nome"  />
			      		<input type="text" name="email" class="input-block-level form-control" placeholder="E-mail"  />		
		        		<button id="submitLogar" class="btn btn-primary pull-right" type="submit">Enviar</button>
		        </fieldset>
					
			</form>
		
		</div>
		

	</div>


</body>
</html>