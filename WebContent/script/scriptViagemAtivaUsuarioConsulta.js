$(document).ready(function() {
	var combustivel = parseFloat($("#combustivel").val());
	var alimentacao = parseFloat($("#alimentacao").val());
	var hospedagem = parseFloat($("#hospedagem").val());
	var outroCusto = parseFloat($("#outroCusto").val());

	if(isNaN(outroCusto)){
		outroCusto = 0;
	}
	
	var total = (combustivel + alimentacao + hospedagem + outroCusto).toFixed(2);
	$("#total").val(total);
});

$(document).ready(function() {
	if($("#msgErro").text() != ""){
		$("#msgs").css("color", "white");
		$("#msgs").css("height", "45px");
		$("#msgs").css("width", "96%");
		$("#msgs").css("margin-left", "3%");
		$("#msgs").css("margin-top", "2%");
	}else if($("#msgAviso").text() != ""){
		$("#msgs").css("color", "green");
		$("#msgs").css("height", "40px");
		$("#msgs").css("width", "96%");
		$("#msgs").css("margin-left", "3%");
		$("#msgs").css("margin-top", "2%");
		$("#msgs").css("margin-bottom", "2%");
		$("#msgs").css("border-radius", "4px");
	}
});

$("#btnAtualizar").on("click",function(event) {
	
	if($("#trabalho").val() == ""){
		$("#msgAviso").text("Trabalho esta vazio");
		$("#msgs").css("color", "white");
		$("#msgs").css("height", "30px");
		$("#msgs").css("width", "96%");
		$("#msgs").css("margin-left", "3%");
		$("#msgs").css("margin-top", "2%");
		$("#msgs").css("margin-bottom", "2%");
		$("#msgs").css("border-radius", "4px");
		$("#formViagem").submit(function(){
		    return false; 
		  });
	}else{
		$("#formViagem").validate({
			rules:{
				trabalho:{
					required:true,
				},
			},
			messages:{
				trabalho:{
					required: "Esse campo é obrigatorio!",
				}
			}
		});
	}
});