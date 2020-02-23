<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="<c:url value="/css/estiloCadastroViagem.css" />" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Desk Travel</title>
</head>
<body>
	<%@ include file="/privado/templates/navFuncionario.jsp" %>
	<div id="msgs">
		<p id="msgErro">${msgErro}</p>
		<p id="msgAviso"></p>
	</div>
	<fieldset>
		<legend>Cadastro de viagem</legend>
		<form id="formViagem" action="/dT/sistema" method="post">
		<input id="logica" type="hidden" name="logica" value="CadastraViagem"/>
		<div class="row">
			<div class="col-sm-2">
				<div class="form-group">
					<label for="id_funcionario">Id Funcionario: </label>
					<input id="id_funcionario" type="number" class="form-control" name="idFuncionario" readonly="readonly" value="${usuarioLogado.id}"/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-2">
				<div class="form-group">
					<label for="estado">Estado: </label>
					<c:choose>
						<c:when test="${empty estado}">
							<select id="estado" name="estado" class="form-control">
								<option selected></option>
								<c:forEach var="item" items="${estados}">
									<option value="${item.id}">${item.nome}</option>
								</c:forEach>
							</select>
						</c:when>
						<c:otherwise>
							<select id="estado" name="estado" class="form-control">
								<option></option>
								<c:forEach var="item" items="${estados}">
									<c:choose>
										<c:when test="${item.id == estado}">
											<option selected value="${item.id}">${item.nome}</option>
											<label>${item.id}</label>
										</c:when>
										<c:otherwise>
											<option value="${item.id}">${item.nome}</option>
											<label>oi</label>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</c:otherwise>
					</c:choose>
					</select>
					<div id="axHid">
					</div>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">	
					<label for="cidade">Cidade: </label>
					<select id="cidade" name="cidade" class="form-control">
						<option selected></option>
						<c:forEach var="item" items="${cidades}">
							<option id="op" value="${item.id}">${item.nome}</option>
							
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<label for="rua">Rua: </label>
					<input id="rua" type="text" class="form-control" name="rua"/>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">		
					<label for="numero">Numero: </label>
					<input id="numero" type="number" class="form-control" name="numero"/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-2">
				<div class="form-group">	
					<label for="combustivel">Combustivel: </label>
					<input id="combustivel" type="text" class="form-control valores" name="combustivel" /><br>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">		
					<label for="alimentação">Alimentação: </label>
					<input id="alimentacao" type="text" class="form-control valores" name="alimentacao"/><br>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">				
					<label for="hospedagem">Hospedagem: </label>
					<input id="hospedagem" type="text" class="form-control valores" name="hospedagem"/><br>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">
					<label for="outroCusto">Outro custo: </label>
					<input id="outroCusto" type="text" class="form-control valores" name="outroCusto"/><br>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">
					<label for="Desc">Descrição outro Custo: </label>
					<input id="Desc" type="text" class="form-control" name="Desc"/><br>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">
					<label for="total">Total: </label>
					<input id="total" type="number" class="form-control"  readonly="readonly" name="total"/><br>
				</div>
			</div>
		</div>
		<div class="row">
<!-- 			<div class="col-sm-2"> -->
<!-- 				<div class="form-group"> -->
<!-- 					<label for="motivo">Motivo: </label> -->
<!-- 					<input id="motivo" type="text" name="motivo" class="form-control"> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="col-sm-2"> -->
<!-- 				<div class="form-group"> -->
<!-- 					<label for="motivoDesc">Descrição: </label> -->
<!-- 					<input id="motivoDesc" type="text" name="motivoDesc" class="form-control"> -->
<!-- 				</div> -->
<!-- 			</div> -->
			<div class="col-sm-4">
				<div div class="form-group">
					<label for="motivoDesc">Motivo: </label>
					<input id="motivoDesc" type="text" name="motivoDesc" class="form-control">
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">
					<label for="duracao">Duração(dias): </label>
					<input id="duracao" type="number" class="form-control data" name="duracao"/><br>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label for="dataDeSaida">Data de Saida: </label>
					<input id="dataDeSaida" type="date" class="form-control data" name="dataDeSaida"/><br>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label for="dataVolta">Data da volta </label>
					<input id="dataVolta" type="date" class="form-control" readonly="readonly" name="dataVolta"/><br>
				</div>
			</div>
		</div>
		<input id="btnCadastrar" type="submit" class="btn btn-primary" value="cadastrar"/>
		<button id="limpar" class="btn btn-primary">Limpar</button>
		</form>
	</fieldset>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src='<c:url value="/script/jquery.validate.min.js" ></c:url>'></script>
<script src='<c:url value="/script/jquery.maskMoney.js" ></c:url>'></script>
<script src='<c:url value="/script/jquery.validate.min.js" ></c:url>'></script>
<script src='<c:url value="/script/scriptViagemCadastro.js" ></c:url>' charset="utf-8"></script>
</html>