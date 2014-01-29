<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="<c:url value='/resources/css/bootstrap.css'/>" rel="stylesheet">
<link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet">

<script type="text/javascript" src='<c:url value="/resources/js/jquery-1.10.2.min.js"/>' ></script>
<script src="http://www.google.com/jsapi"></script>
<script type="text/javascript" src='<c:url value="/resources/js/grafico/pieChart.js"/>?v=2' ></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ranking</title>
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
				<a class="navbar-brand" href="/">VOTAÇÃO</a>
			</div>
		</div>
	</div>

	<br />
	<br />
	
	<div class="container">
	
		<hr>	

		<fieldset>
			<legend class="text-center">MELHORES FILMES</legend>

			<table class="table">
				<thead>
					<tr>
						<th>Ranking</th>
						<th class="text-center">FILME</th>
						<th>Nota</th>
					</tr>
				</thead>
				
				<tbody id="filmesVotados">
					<c:forEach items="${filmes}" var="f" varStatus="contador">
			
						<c:set var="contador" value="${contador.count}" />
			
						<tr id="f_${contador}" class="f_${contador % 2}">
							<td>${contador}°</td>
							<td>${f.nome}</td>
							<td>${f.pontuacao}</td>
						</tr>
			
					</c:forEach>
				</tbody>
				
			</table>
		
			<span class="spacer"></span>
		</fieldset>
	
	
		<div id="loading">
			<img alt="" src='<c:url value="/resources/imgs/load/ajax-loader.gif" /> '>
		</div>
		
	</div>


	<div id="chart_div" style="height: 400px; width: 500px;"></div>

</body>
</html>