<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <link type="text/css" rel="stylesheet" href="<c:url value="/css/estiloViagemAtivaConsulta.css" />" />
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
		<legend>Atualizar Gastos</legend>
		<form id="atualizaForm" action="sistema" method="post">
			<input type="hidden" name="logica" value="AtualizarGasto"/>
			<c:choose>
				<c:when test="${not empty viagemId}">
					<input type="hidden" name="viagemId" value="${viagemId}"/>
				</c:when>    
				<c:otherwise>
					<input type="hidden" name="viagemId" value="${viagem.id}"/>
				</c:otherwise>
			</c:choose>
			<input type="hidden" name="custoId" value="${viagem.custoR.id}"/>
			<div class="row">
				<div class="col-sm-4">
					<div class="form-group">
						<label for="combustivel">Combustivel: </label>
						<c:choose>
							<c:when test="${not empty combustivel}">
								<input id="combustivel" type="text" class="form-control valores" name="combustivel" value="${combustivel}"/>
							</c:when>    
							<c:otherwise>
								<input id="combustivel" type="text" class="form-control valores" name="combustivel" value="${viagem.custoR.combustivel}"/>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<label for="alimentacao">Alimentação: </label>
						<c:choose>
							<c:when test="${not empty alimentacao}">
								<input id="alimentacao" type="text" class="form-control valores" name="alimentacao" value="${alimentacao}"/>
							</c:when>    
							<c:otherwise>
								<input id="alimentacao" type="text" class="form-control valores" name="alimentacao" value="${viagem.custoR.alimentacao}"/>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<label for="hospedagem">Hospedagem: </label>
						<c:choose>
							<c:when test="${not empty hospedagem}">
								<input id="hospedagem" type="text" class="form-control valores" name="hospedagem" value="${hospedagem}"/>
							</c:when>    
							<c:otherwise>
								<input id="hospedagem" type="text" class="form-control valores" name="hospedagem" value="${viagem.custoR.hospedagem}"/>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<div class="form-group">
						<label for="descOG">Descrição outro Custo:</label>
						<c:choose>
						    <c:when test="${not empty desc}">
						    	<input id="descOG" type="text" readonly="readonly" class="form-control valores" name="descOG" value="${desc}"/>
							</c:when>    
							<c:otherwise>
								<input id="descOG" type="text" readonly="readonly" class="form-control valores" name="descOG" value="${viagem.custoR.descOG}"/>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<label for="outrosGastos">Outro Custo: </label>
						<c:choose>
							<c:when test="${not empty outroGasto}">
								<input id="outroCusto" type="text" class="form-control valores" name="outrosGastos" value="${outroGasto}"/>
							</c:when>    
							<c:otherwise>
								<input id="outroCusto" type="text" class="form-control valores" name="outrosGastos" value="${viagem.custoR.outrosGastos}"/>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<label for="total">Total: </label>
						<input id="total" type="text" class="form-control" name="total" readonly="readonly" value="${viagem.custoR.total}"/>
					</div>
				</div>
			</div>
			<input class="btn btn-primary" type="submit" value="atualizar"/>
		</form>
	</fieldset>
</body>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src='<c:url value="/script/jquery.maskMoney.js" ></c:url>'></script>
	<script src='<c:url value="/script/jquery.validate.min.js" ></c:url>'></script>
   <script src="script/scriptAtualizarCustos.js"></script>
</html>