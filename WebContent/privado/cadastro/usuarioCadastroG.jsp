<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Desk Travel</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="<c:url value="/css/estiloCadastroUsuario.css" />" />
</head>
<body>
	<%@ include file="/privado/templates/navGestor.jsp" %>
		
	<div id="msgs">
		<p id="msgErro">${msgErro}</p>
		<p id="msgSucesso">${msgSucesso}</p>
	</div>
	<fieldset>
		<legend>Cadastro de Usuario</legend>
			<form id="formCadastroUsuario" action="/dT/sistema" method="post">
			<input type="hidden" name="logica" value="CadastraUsuario" />
			<div class="row">
				<div class="col-sm-2">
					<div class="form-group">
						<label for="cod_funcionario">Codigo do funcionario: </label> 
						<input id="cod_funcionario" class="form-control" type="number" name="cod_funcionario" value="${cod_funcionario}"/> <br>
					</div>
				</div>
				<div class="col-sm-10">	
					<div class="form-group">
						<label for="nome">Nome: </label>
						<input id="nome" class="form-control" type="text" name="nome" value="${nome}"/><br>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="login">login: </label> 
						<input id="login" class="form-control" type="text" name="login" value="${login}"/> <br>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="email">email: </label> 
						<input id="email" class="form-control" type="email" name="email" value="${email}"/> <br>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="senha">Senha: </label> 
						<input id="senha" class="form-control" type="password"	name="senha" /><br>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="senhaConfirmar">Confirmar senha: </label> 
						<input id="senhaConfirmar" class="form-control" type="password"	name="senhaConfirmar"/><br>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="telefone">telefone</label> 
						<input id="telefone" class="form-control" type="tel"	name="telefone" value="${telefone}"/><br>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="tipo">Tipo de Usuario: </label> 
						<select id="tipo" class="form-control" name="tipo">
							<option selected></option>
							<c:forEach var="item" items="${usuarioTipo}">
								<option value="${item.id}">${item.genero}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<input id="btnCadastrar" type="submit" class="btn btn-primary" value="Cadastrar"/>
			<button id="limpar" class="btn btn-primary">Limpar</button>
		</form>
	</fieldset>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://digitalbush.com/wp-content/uploads/2014/10/jquery.maskedinput.js"></script>
<script src='<c:url value="/script/jquery.validate.min.js" ></c:url>'></script>
<script src='<c:url value="/script/scriptUsuarioCadastro.js" ></c:url>' charset="utf-8"></script>
</html>