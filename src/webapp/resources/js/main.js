$(function() {
	$(document).ajaxComplete(function(e, xhr, settings){
		var url = xhr.getResponseHeader('Location');
		
		if( url != null && url != '' ){
			window.location = url;
		}
	});
	
	
	
	
	/*
	//Requisi√ß√µes ajax redirecionam para home caso tenha no header
	$('body').bind('ajaxSuccess',function(event,request,settings){
		var url = request.getResponseHeader('Location');

		if( url != null && url != '' ){
			window.location = url;
		}
		return false;
	});
	*/
	
	
	/*VALIDA«√O DE FORMULARIO*/
	$( ".form" ).validate({
		
		onKeyup : true,

		eachInvalidField: function(){
			$(this).css("border-color", "red");
		},

		eachValidField : function() {
			$(this).css("border-color", "#468847");
		}

	});
	
});


function dialog( msg, titulo ){
	var titulo = ( titulo == undefined ) ? '&nbsp' : titulo;
	
	$("#dialog .modal-header h4").html(titulo);
	$("#dialog .modal-body p").html(msg);
	$("#dialog").modal();
}

function redirect( url ){
	window.location.href = url;
}

function setDefValue(idInput, defValue){
	$("#"+idInput).val(defValue);
}