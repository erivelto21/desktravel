function butaoAprova(a) {
	document.getElementById("decis" + a).value = true;
}

function butaoNega(x) {
	document.getElementById("decis" + x).value = false;
}

$(document).ready(function(){
	  $('.dropdown-submenu a.test').on("click", function(e){
	    $(this).next('ul').toggle();
	    e.stopPropagation();
	    e.preventDefault();
	  });
});

$("button[class='sum']").on("click", function(event) {
	$(".mT4").css({display: "block"});
});

$(".modal").on("hide.bs.modal", function () { 
	$(".mT4").css({display: "none"});
});

//$(".modal").blur(function() {
//	$("#trM").css({display: "none"});
//});
//$("button[class!='sum']").on("click", function() {
//	$("#trM").css({display: "none"});
//});
//
//$("input").on("click", function() {
//	$("#trM").css({display: "block"});
//});
