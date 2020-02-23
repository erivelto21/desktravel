<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="<c:url value="/css/estiloLogin.css" />" />
<title>DeskTravel</title>
</head>
<body>
	<div class="strong">
		<h1>Desk Travel</h1>
	</div>
	<form action="/dT/sistema" method="post">
		<fieldset id="login-form">
			<legend>Acesse o sistema</legend>
			<input type="hidden" name="logica" value="AutenticaUsuario" />
			<div id="div2">
			</div>
			<input type="text" name="login" placeholder="login" /></br> 
			<input type="password" name="senha" placeholder="senha" /></br> 
			<input class="btn" type="submit" value="Logar" />
			<button id="limpar" class="btn" onClick="Nova()">Limpar</button>
			<p>${msgErro}</p>
		</fieldset>
	</form>
	<div id="footer">
	</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="<c:url value="/script/scriptLogin.js" />"></script>
</html>