$("document").ready(function() {
	if($("#msgErro").text() != ""){
		$("#msgs").css("color", "white");
		$("#msgs").css("height", "40px");
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

$(document).ready(function(){
	  $('.dropdown-submenu a.test').on("click", function(e){
	    $(this).next('ul').toggle();
	    e.stopPropagation();
	    e.preventDefault();
	  });
	});