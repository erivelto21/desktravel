<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Desk Travel</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="<c:url value="/css/estiloProprioUsuarioAltera.css" />" />
</head>
<body>
	<%@ include file="/privado/templates/navFuncionario.jsp" %>
	<div id="msgs">
		<p id="msgErro">${msgErro}</p>
	</div>
	<fieldset>
		<legend>Atualizar Dados: </legend>
		<form action="/dT/sistema" id="formAltera">
			<input type="hidden" name="logica" value="AlteraUsuario"/>
			<div class="row">
				<div class="col-sm-4 form-group">
					<label>Login: </label>
					<c:choose>
					    <c:when test="${empty usuario.login}">
					         <input type="text" class="form-control" name="login" value="${login}"/>
					    </c:when>
					    <c:otherwise>
							<input type="text" class="form-control" name="login" value="${usuario.login}"/>
					    </c:otherwise>
					</c:choose>
				</div>
				<div class="col-sm-8 form-group">
					<label>Email: </label>
					<c:choose>
					    <c:when test="${empty usuario.email}">
					    	<input id="email" type="email" class="form-control" name="email" value="${email}"/>
					    </c:when>
					    <c:otherwise>
							<input type="email" class="form-control" name="email" value="${usuario.email}"/>
					    </c:otherwise>
					</c:choose>
				</div>
				
			</div>
			<div class="row">
				<div class="col-sm-6 form-group">
					<label>Telefone: </label>
					<c:choose>
					    <c:when test="${empty usuario.telefone}">
					    	<input id="telefone" type="tel" class="form-control" name="telefone" value="${telefone}"/>
					    </c:when>
					    <c:otherwise>
							<input id="telefone" type="tel" class="form-control" name="telefone" value="${usuario.telefone}"/>
					    </c:otherwise>
					</c:choose>
				</div>
				<div class="col-sm-6 form-group">
					<label>Senha: </label>
					<input id="senhaAntiga" type="password" class="form-control" name="senhaAntiga"/>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6 form-group">
					<label>Senha Nova: </label>
					<input id="senha" type="password" class="form-control" name="senhaNova"/>
				</div>
				<div class="col-sm-6 form-group">
						<label>Confirmar Nova senha : </label>
					<input id="senhaConf" type="password" class="form-control" name="senhaNovaConfi"/>
				</div>
			</div>
			<input type="submit" class="btn btn-primary" value="alterar"/>
		</form>
	</fieldset>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src='<c:url value="/script/jquery.validate.min.js" ></c:url>'></script>
<script src="http://digitalbush.com/wp-content/uploads/2014/10/jquery.maskedinput.js"></script>
<script src='<c:url value="/script/scriptProprioUsuarioAltera.js" ></c:url>' charset="utf-8"></script>
</html>