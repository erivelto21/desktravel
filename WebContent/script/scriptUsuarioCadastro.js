$("#btnCadastrar").on("click", function(event) {
	$("#formCadastroUsuario").validate({
		rules:{
			nome:{
				required : true,
				maxlength: 45,
			},
	
			cod_funcionario:{
				required : true,
				number: true,
				maxlength:5
			},
			
			login:{
				required: true,
				maxlength: 45,
				minlength: 4
			},
			
			senha:{
				required: true,
				maxlength: 45,
				minlength: 4
			},
			
			senhaConfirmar:{
				required: true,
				maxlength: 45,
				minlength: 4
			},
			
			tipo:{
				required: true
			},
			email:{
				required: true,
				email: true
			},
			telefone:{
				required: true,
				minlength: 10,
			}
		},
	
		messages:{
			nome:{
				required: "Esse campo é obrigatorio!",
				maxlength:"O campo nome não pode ter mais que 45 caracteres"
			},
		
			cod_funcionario:{
				required : "Esse campo é obrigatorio!",
				maxlength: "O numero do fucionario so pode ter no maximo 5 digitos",
			},
			
			login:{
				required: "Esse campo é obrigatorio!",
				maxlength: "O campo login não pode ter mais que 45 caracteres",
				minlength: "O campo login não pode ter menos que 4 caracteres"
			},
			
			senha:{
				required: "Esse campo é obrigatorio!",
				maxlength: "O campo senha não pode ter mais que 45 caracteres",
				minlength: "O campo senha não pode ter menos que 4 caracteres"
			},
			
			senhaConfirmar:{
				required: "Esse campo é obrigatorio!",
				maxlength: "O campo Confirmar senha não pode ter mais que 45 caracteres",
				minlength: "O campo Confirmar senha não pode ter menos que 4 caracteres"
			},
			
			tipo:{
				required: "Esse campo é obrigatorio!",
			},
			email:{
				required: "Esse campo é obrigatorio!",
				email: "Entre com um email valido"
			},
			telefone:{
				required: "Esse campo é obrigatorio!",
				minlength: "O campo telefone não pode ter menos de 10 digitos",
			}
		}
})
	
	var senha = $("#senha").val();
	var senhaC = $("#senhaConfirmar").val();
	
	if(senha != senhaC){
		$("#senha").val("");
		$("#senhaConfirmar").val("");
		alert("Senhas diferentes");
	}else{
		$("#formCadastroUsuario").on("submit");
	}
	
});

$("document").ready(function() {
	$("#telefone").mask("(99) 9999-9999");
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
	$("#cod_funcionario").val("");
	$("#nome").val("");
	$("#login").val("");
	$("#tipo").val("");
	$("#senha").val("");
	$("#senhaConfirmar").val("");
	$("#email").val("");
	$("#telefone").val("");
	$("#formCadastroUsuario").on("submit", function() {
		return false;
	});
});

$(document).ready(function(){
	  $('.dropdown-submenu a.test').on("click", function(e){
	    $(this).next('ul').toggle();
	    e.stopPropagation();
	    e.preventDefault();
	  });
});