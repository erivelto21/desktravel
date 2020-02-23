<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="<c:url value="/css/estiloViagemAtivaUsuarioConsulta.css" />" />
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
		<legend>Viagem aprovada</legend>
		<form id="formViagem" action="/dT/sistema" method="post">
		<input type="hidden" name="logica" value="AtualizarViagem"/>
		<input type="hidden" name="idV" value="${viagem.id}"/>
		<div class="row">
			<div class="col-sm-2">
				<div class="form-group">
					<label for="estado">Estado: </label>
					<select id="estado" name="estado" class="form-control" readonly="readonly">
						<option selected>${viagem.endereco.estado.nome}</option>
					</select>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">	
					<label for="cidade">Cidade: </label>
					<select id="cidade" name="cidade" class="form-control" readonly="readonly">
						<option selected>${viagem.endereco.cidade.nome}</option>
					</select>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<label for="rua">Rua: </label>
					<input id="rua" type="text" class="form-control" readonly="readonly" value="${viagem.endereco.rua}"/>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">		
					<label for="numero">Numero: </label>
					<input id="numero" type="number" class="form-control" readonly="readonly" value="${viagem.endereco.numero}"/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-2">
				<div class="form-group">	
					<label for="combustivel">Combustivel: </label>
					<input id="combustivel" type="text" class="form-control valores"  readonly="readonly" value="${viagem.custo.combustivel}"/><br>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">		
					<label for="alimentação">Alimentação: </label>
					<input id="alimentacao" type="text" class="form-control valores"  readonly="readonly" value="${viagem.custo.alimentacao}"/><br>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">				
					<label for="hospedagem">Hospedagem: </label>
					<input id="hospedagem" type="text" class="form-control valores" readonly="readonly" value="${viagem.custo.hospedagem}"/><br>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">
					<label for="outroCusto">Outro custo: </label>
					<input id="outroCusto" type="text" class="form-control" readonly="readonly" valores" value="${viagem.custo.outrosGastos}"/><br>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">
					<label for="Desc">Descrição do outroCusto: </label>
					<input id="Desc" type="text" class="form-control" readonly="readonly" value="${viagem.custo.descOG}"/><br>
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
			<div class="col-sm-6">
				<div class="form-group">
					<label for="trabalho">Motivo: </label>
					<input id="motivo" name="motivo" type="text" class="form-control" readonly value="${viagem.motivoDesc}"/>
<%-- 					<input id="motivo" name="motivo" type="text" class="form-control" readonly value="${viagem.motivo}"/> --%>
				</div>
			</div>
<!-- 			<div class="col-sm-4"> -->
<!-- 				<div class="form-group"> -->
<!-- 					<label for="motivoDesc">Descrição do motivo: </label> -->
<%-- 					<input id="motivoDesc" name="motivoDesc" type="text" class="form-control" readonly value="${viagem.motivoDesc}">					 --%>
<!-- 				</div> -->
<!-- 				<div class="form-group"> -->
<!-- 					<label for="status">Status: </label> -->
<!-- 					<select id="status" class="form-control" readonly="readonly" name="status"> -->
<%-- 						<c:forEach items="${status}" var="stat"> --%>
<%-- 							<c:choose> --%>
<%-- 								<c:when test="${stat.valor == viagem.motivoStatus.valor}"> --%>
<%-- 									<option selected value="${stat}">${stat.valor}</option> --%>
<%-- 								</c:when> --%>
<%-- 								<c:otherwise> --%>
<%-- 									<option value="${stat}">${stat.valor}</option> --%>
<%-- 								</c:otherwise> --%>
<%-- 							</c:choose> --%>
<%-- 						</c:forEach> --%>
<!-- 					</select> -->
<!-- 				</div> -->
<!-- 			</div> -->
			<div class="col-sm-2">
				<div class="form-group">
					<label for="duracao">Duração(dias): </label>
					<input id="duracao" type="number" class="form-control data" readonly="readonly" value="${viagem.duracao}"/><br>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">
					<label for="dataDeSaida">Data de Saida: </label>
					<input id="dataDeSaida" type="date" class="form-control data" readonly="readonly" value="${dataSaida}" /><br>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">
					<label for="dataVolta">Data da volta </label>
					<input id="dataVolta" type="date" class="form-control" readonly="readonly" value="${dataVolta}"/><br>
				</div>
			</div>
		</div>
<!-- 		<input id="btnAtualizar" type="submit" class="btn btn-primary" value="Atualizar"/> -->
		</form>
		<form action="sistema" method="post">
			<input type="hidden" name="logica" value="ConcluiViagem"/>
			<input type="hidden" name="idV" value="${viagem.id}"/>
			<input id="btnConcluir" type="submit" class="btn btn-primary" value="Concluir"/>
		</form>
	</fieldset>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src='<c:url value="/script/jquery.validate.min.js" ></c:url>'></script>
<script src='<c:url value="/script/jquery.maskMoney.js" ></c:url>'></script>
<script src='<c:url value="/script/jquery.validate.min.js" ></c:url>'></script>
<script src='<c:url value="/script/scriptViagemAtivaUsuarioConsulta.js" ></c:url>' charset="utf-8"></script>
</html>