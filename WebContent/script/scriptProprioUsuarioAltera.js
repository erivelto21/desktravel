$("#formAltera").validate({
	rules:{
		login:{
			required: true,
			maxlength: 45,
			minlength: 4
		},
			
		senhaAntiga:{
			maxlength: 45,
			minlength: 4
		},
	
		senha:{
			maxlength: 45,
			minlength: 4
		},
			
		senhaConf:{
			maxlength: 45,
			minlength: 4
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
		login:{
			required: "Esse campo é obrigatorio!",
			maxlength: "O campo login não pode ter mais que 45 caracteres",
			minlength: "O campo login não pode ter menos que 4 caracteres"
		},
			
		senhaAntiga:{
			maxlength: "O campo senha não pode ter mais que 45 caracteres",
			minlength: "O campo senha não pode ter menos que 4 caracteres"
		},
			
		senha:{
			maxlength: "O campo senha não pode ter mais que 45 caracteres",
			minlength: "O campo senha não pode ter menos que 4 caracteres"
		},
			
		senhaConf:{
			maxlength: "O campo Confirmar senha não pode ter mais que 45 caracteres",
			minlength: "O campo Confirmar senha não pode ter menos que 4 caracteres"
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
});

$("document").ready(function() {
	$("#telefone").mask("(99) 9999-9999");
	if($("#msgErro").text() != "" && $("#msgErro").text() != "Nada alterado"){
		$("#msgs").css("background-color", "red");
		$("#msgs").css("color", "white");
		$("#msgs").css("height", "90px");
		$("#msgs").css("width", "96%");
		$("#msgs").css("margin-left", "3%");
		$("#msgs").css("margin-top", "2%");
		$("#msgs").css("margin-bottom", "2%");
		$("#msgs").css("border-radius", "4px");
	}else if($("#msgErro").text() == "Nada alterado"){
		$("#msgs").css("background-color", "green");
		$("#msgs").css("color", "white");
		$("#msgs").css("height", "45px");
		$("#msgs").css("width", "96%");
		$("#msgs").css("margin-left", "3%");
		$("#msgs").css("margin-top", "2%");
		$("#msgs").css("margin-bottom", "2%");
		$("#msgs").css("border-radius", "4px");
	}
});

$(document).ready(function(){
	  $('.dropdown-submenu a.test').on("click", function(e){
	    $(this).next('ul').toggle();
	    e.stopPropagation();
	    e.preventDefault();
	  });
	});