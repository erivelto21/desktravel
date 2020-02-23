$(document).ready(function() {
	$("#combustivel").maskMoney();
	$("#alimentacao").maskMoney();
	$("#hospedagem").maskMoney();
	$("#outroCusto").maskMoney();
	$("#total").maskMoney();
	
	$(".valores").blur(function() {
		var combustivel = parseFloat($("#combustivel").val());
		var alimentacao = parseFloat($("#alimentacao").val());
		var hospedagem = parseFloat($("#hospedagem").val());
		var outroCusto = parseFloat($("#outroCusto").val());
		
		if(isNaN(combustivel)){
			combustivel = 0;
		}
		if(isNaN(alimentacao)){
			alimentacao = 0;
		}
		if(isNaN(hospedagem)){
			hospedagem = 0;
		}
		if(isNaN(outroCusto)){
			outroCusto = 0;
		}
		
		var total = combustivel + alimentacao + hospedagem + outroCusto;
		$("#total").val(total);
	}),
	
	$("#atualizaForm").validate({
		rules:{
			combustivel:{
				required : true,
				maxlength: 6,
			},
			alimentacao:{
				required : true,
				maxlength: 6,
			},
			hospedagem:{
				required : true,
				maxlength: 6,
			},
			outroCusto:{
				maxlength: 6,
			},
			Desc:{
				maxlength: 45,
			},
		},
		messages:{
			combustivel:{
				required: "Esse campo é obrigatorio!",
				maxlength: "valor muito alto",
			},
			alimentacao:{
				required: "Esse campo é obrigatorio!",
				maxlength: "valor muito alto",
			},
			hospedagem:{
				required: "Esse campo é obrigatorio!",
				maxlength: "valor muito alto",
			},
			outroCusto:{
				maxlength: "valor muito alto",
			},
			Desc:{
				maxlength: "Maximo de caracteres é 45",
			}
		},
	})
});
