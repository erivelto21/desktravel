$(document).ready(function() {
	$("#combustivel").maskMoney();
	$("#alimentacao").maskMoney();
	$("#hospedagem").maskMoney();
	$("#outroCusto").maskMoney();
	$("#total").maskMoney();
	
	$("#estado").blur(function() {
		
	});
	
	$("#estado").change(function() {
		$("#axHid").append('<input id="hiEstado" type="hidden" name="idEstado">');
		
		if($("#estado").val() == ""){
			$("#hiEstado").val("limpar");
			$("#logica").val("AtualizaCidadeViagem");
			$("#formViagem").submit();
		}else{
			$("#hiEstado").val($("#estado").val());
			$("#logica").val("AtualizaCidadeViagem");
			$("#formViagem").submit();
		}
		
		$("#axHid").remove();
	}),
	
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
		
		var total = (combustivel + alimentacao + hospedagem + outroCusto).toFixed(2);
		$("#total").val(total);
	}),
	
	$(".data").focusout(function() {
//		var dataSaida = new Date($("#dataDeSaida").val());
//		var duracao = parseFloat($("#duracao").val());
//		montarData(duracao, dataSaida);
//		dataSaida.setDate(dataSaida.getDate() + duracao);
//		
//		if(dataSaida.getDate() < 10){
//			var dataVolt = dataSaida.getFullYear() + "-" + "0" + (dataSaida.getMonth() + 1) + "-" + "0" + (dataSaida.getDate() + 1);
//		}else{
//			var dataVolt = dataSaida.getFullYear() + "-" + "0" + (dataSaida.getMonth() + 1) + "-" + (dataSaida.getDate() + 1);
//		}
//
//		$("#dataVolta").val(dataVolt);
		
		var depois = new Date($("#dataDeSaida").val());
		var duracao = parseFloat($("#duracao").val());
		duracao += 1;
		depois.setDate(depois.getDate() + duracao);

		var dataBrasil = datT(depois);
		$("#dataVolta").val(dataBrasil);

	});
});

function datT(depois) {
	var dp = new Date(depois);
	
	dp.setMonth(dp.getMonth() + 1);
	
	var dia = dp.getDate();
	var mes = dp.getMonth();
	var ano = dp.getFullYear();
	
	var diaI = parseInt(dp.getDate());
	var mesI = parseInt(dp.getMonth());
	
	if(diaI < 10){
		dia = "0" + dia;
	}
	if(mesI < 10){
		mes = "0" + mes;
	}
	if(mes == 00){
		mes = 12;
	}
		
	return ano + "-" + mes + "-" + dia;
    
};

$("document").ready(function() {
	if($("#msgErro").text() != ""){
		$("#msgs").css("background-color", "red");
		$("#msgs").css("color", "white");
		$("#msgs").css("height", "90px");
		$("#msgs").css("width", "96%");
		$("#msgs").css("margin-left", "3%");
		$("#msgs").css("margin-top", "2%");
		$("#msgs").css("margin-bottom", "2%");
		$("#msgs").css("border-radius", "4px");
	}else if($("#msgSucesso").text() != ""){
		$("#msgs").css("background-color", "green");
		$("#msgs").css("color", "white");
		$("#msgs").css("height", "90px");
		$("#msgs").css("width", "96%");
		$("#msgs").css("margin-left", "3%");
		$("#msgs").css("margin-top", "2%");
		$("#msgs").css("margin-bottom", "2%");
		$("#msgs").css("border-radius", "4px");
	}
});

$("#limpar").on("click", function(event) {
	$("#estado").val("");
	$("#cidade").val("");
	$("#rua").val("");
	$("#numero").val("");
	$("#combustivel").val("");
	$("#alimentacao").val("");
	$("#hospedagem").val("");
	$("#hospedagem").val("");
	$("#outroCusto").val("");
	$("#Desc").val("");
	$("#total").val("");
	$("#trabalho").val("");
	$("#duracao").val("");
	$("#dataDeSaida").val("");
	$("#motivo").val("");
	$("#motivoDesc").val("");
	$("#formViagem").on("submit", function() {
		return false;
	});
});

$("#btnCadastrar").on("click", function(event) {
	$("#formViagem").validate({
		debug: true,
		success: "valid",
		rules:{
			estado:{
				required : true,
			},
			cidade:{
				required : true,
			},
			rua:{
				required : true,
			},
			numero:{
				required : true,
				maxlength: 4,
			},
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
			trabalhos:{
				required : true,
			},
			duracao:{
				required : true,
				maxlength: 3,
				min:2,
			},
			dataDeSaida:{
				required : true,
			},
			dataVolta:{
				required : true,
			},
			motivo:{
				required : true,
				maxlength:  250,
				minlength: 4
			},
			motivoDesc:{
				required : true,
				minlength: 10
			}
		},
		messages:{
			estado:{
				required: "Esse campo é obrigatorio!",
			},
			cidade:{
				required: "Esse campo é obrigatorio!",
			},
			rua:{
				required: "Esse campo é obrigatorio!",
			},
			numero:{
				required: "Esse campo é obrigatorio!",
				maxlength: "O numero so pode ter 4 digitos",
			},
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
			},
			trabalhos:{
				required: "Esse campo é obrigatorio!",
			},
			duracao:{
				required: "Esse campo é obrigatorio!",
				maxlength: "Viagem muito longa",
				min:"Viagem muito curta",
			},
			dataDeSaida:{
				required: "Esse campo é obrigatorio!",
			},
			dataVolta:{
				required: "Esse campo é obrigatorio!",
			},
			motivo:{
				required : "Esse campo é obrigatorio!",
				maxlength:  "Campo muito grande",
				minlength: "Campo muito pequeno"
			},
			motivoDesc:{
				required : "Esse campo é obrigatorio!",
				minlength: "Campo muito pequeno"
			}
		},
	})
	
	if($("#formViagem").valid() == true){
		if(($("#Desc").val() != "") || ($("#outroCusto").val() != "")){

			if(($("#Desc").val() != "") && ($("#outroCusto").val() != "")){
				document.getElementById("formViagem").submit();
			}else{
				$("#msgAviso").text("Se o campo outro custo estar preenchido necessariamente o campo Descrição do outroCusto tambem deve estar preenchindo vice versa");
				$("#msgs").css("color", "white");
				$("#msgs").css("height", "40px");
				$("#msgs").css("width", "96%");
				$("#msgs").css("margin-left", "3%");
				$("#msgs").css("margin-top", "2%");
				
				$("#formViagem").submit(function() {
					return false;
				});
			}
		}else{
			document.getElementById("formViagem").submit();
		}
	}
});
