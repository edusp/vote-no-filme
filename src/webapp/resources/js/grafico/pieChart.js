

$(document).ready(function() {

	$("#loading").show();
	$("#chart_div").hide();

	$.ajax({

		url: "listar",
		data: { init: 0, max: 5 },
		type: "GET",
		success: function(data){

			google.setOnLoadCallback(desenhaGrafico(data));

		}

	});


});


	
google.load('visualization', '1', {'packages' : ['corechart']});



function desenhaGrafico(filmes){

	var data = new google.visualization.DataTable();
	data.addColumn('string','Filme');
	data.addColumn('number','Pontuação');
	
	data.addRows([
		[filmes[0].nome, filmes[0].pontuacao],
		[filmes[1].nome, filmes[1].pontuacao],
		[filmes[2].nome, filmes[2].pontuacao],
		[filmes[3].nome, filmes[3].pontuacao],
		[filmes[4].nome, filmes[4].pontuacao]				
	]);

	var options = {'title':'Pontuação dos filmes',
           'width':600,
           'height':300,
           is3D: true};
	
	//CRIA O GRAFICO
	var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
		chart.draw(data, options);	  
	  
		
		$("#loading").hide();
		$("#chart_div").fadeIn();

}



