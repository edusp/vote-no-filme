$(document).ready(function() {
	
	var divImagens = $("#imagens");
	var divImgFilmeA = $("<div>").addClass("form-group col-xs-3");
	var divImgFilmeB = $("<div>").addClass("form-group col-xs-5");
	var labelA = $("<label>");
	var labelB = $("<label>");
	var initResul = 0;
	var notSelected = new Array();
	var filmeA = new Array();
	var filmeB = new Array();
	var step = 1;
	
	var imgA = $("<img>").attr({
		width: "200px",
		height: "290px",
		alt:	""
	});
	
	var imgB = $("<img>").attr({
		width: "200px",
		height: "290px",
		alt:	""
	});
	
	
	init();
	
	
	/*EFEITO DE HOVER DAS IMAGENS*/
	$(document).on('mouseenter', 'img', function(){
		$(this).css("opacity","0.4").css("cursor", "pointer");
	}).on('mouseleave', 'img', function() {
		$(this).css("opacity", "1").css("cursor", "pointer");
	});
	
	
	/* EXECUTA A VOTAÇÃO CONTABILIZANDO O CLIQUE NA IMAGEM */
	$(document).on('click', 'img', function(){

		initResul += 2;
		step ++;
		var idImgSelected = $(this).attr("id");

		if (initResul == 2) {
			firstSelected = idImgSelected; 

			if (firstSelected == filmeA.id) {
				notSelected[0] = filmeB;
			}else {
				notSelected[0] = filmeA;
			}
		}


		$.ajax({

			url: "votar",
			data: { idFilme: idImgSelected },
			type: "POST",
			success: function(data){

				if (step > 3) {
					$("#exibirFilmes").fadeOut();
					$("#formulario").delay(500).fadeIn();

					return;
				}
				nextFilmes();
			}

		});


	});
	
	
	/**
	 *APÓS O CLIQUE EM ALGUM DOS FILMES, ESSA FUNÇÃO CHAMA OS DOIS PRÓXIMOS FILMES A SER VOTADO 
	 */
	function nextFilmes() {

		$.ajax({

			url: "listar",
			data: { init: initResul, max:2,  },
			type: "GET",
			success: function(data){

				filmeA = data[0];
				filmeB = data[1];

				if (initResul == 4) {

					buildDivImagens(notSelected[0], filmeA);
				}else {

					buildDivImagens(filmeA, filmeB);
				}
			}
		});

	}
	
	
	
	/**
	 * CARREGA AS DUAS PRIMEIRAS IMAGENS NA TELA
	 */
	function init(){

		$.ajax({
			url: "listar",
			data: { init: initResul, max:2 },
			type: "GET",
			success: function(data){

				filmeA = data[0];
				filmeB = data[1];

				buildDivImagens(filmeA, filmeB);

			}
		});
	}
	
	
	/**
	 *CODIGO QUE GERA AS DUAS DIVs QUE CONTEM AS IMAGENS 
	 */
	function buildDivImagens(filmeA, filmeB){

		$(divImagens).hide();

		$(divImagens).append(divImgFilmeA);
		$(labelA).text(filmeA.nome);
		$(divImgFilmeA).append(labelA);
		$(imgA).attr("src", "resources/imgs/"+filmeA.nomeImagem+".jpg");
		$(imgA).attr("id", +filmeA.id);

		$(divImagens).append(divImgFilmeB);
		$(labelB).text(filmeB.nome);
		$(divImgFilmeB).append(labelB);
		$(imgB).attr("src", "resources/imgs/"+filmeB.nomeImagem+".jpg");
		$(imgB).attr("id", +filmeB.id);

		$(divImgFilmeA).append(imgA);
		$(divImgFilmeB).append(imgB);

		$(divImagens).fadeIn(800);


	}
	
	
	$("#form").validate({
		rules : {

			nome: {
				required: true,
			},

			email : {
				required : true,
				email : true
			}

		},

		messages : {
			nome : {
				required : "O campo nome é obrigatorio."
			},
			email : {
				required : "O campo email é obrigatorio.",
				email : "Digite um email válido."
			}
		}

	});
	
	
});