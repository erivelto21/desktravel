<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="<c:url value="/css/estiloViagemPendentesConsulta.css" />" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>Desk Travel</title>
</head>
<body>
	<%@ include file="/privado/templates/navAdm.jsp" %>
	
	<fieldset>
		<legend>Viagens pendentes para aprovação</legend>
		<table id="tableP" class="table table-bordered">
			<thead>
				<tr>
					<th>Criador</th>
					<th>Cidade</th>
					<th>Estado</th>
					<th>Data de Saida</th>
					<th>Data da Volta</th>
					<th>Duracão</th>
					<th>Custo Total</th>
					<th>Status</th>
					<th>Detalhes</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${viagens}" var="viagem">
					<tr>
						<td>${viagem.usuario.login}</td>
						<td>${viagem.endereco.cidade.nome}</td>
						<td>${viagem.endereco.estado.nome}</td>
						<td><fmt:formatDate value="${viagem.dataSaida.time}" pattern="dd/MM/yyyy"/></td>
						<td><fmt:formatDate value="${viagem.dataVolta.time}" pattern="dd/MM/yyyy"/></td>
						<td>${viagem.duracao} dias</td>
						<td>R$ ${viagem.custo.total}</td>
						<td>
							<c:choose>
								<c:when test="${viagem.pendente == true and viagem.aprovacao == false}"> 
									Pendente
								</c:when>
								<c:when test="${viagem.pendente == true and viagem.aprovacao == true}"> 
									Concluida
								</c:when>
								<c:when test="${viagem.pendente == false and viagem.aprovacao == false}"> 
									Negada
								</c:when>
								<c:when test="${viagem.pendente == false and viagem.aprovacao == true}"> 
									Em andamento
								</c:when>
							</c:choose>
						</td>
						<td><button class="sum" type="button" data-toggle="modal" data-target="#myModal${viagem.id}">Detalhes</button></td>
					  	<td class="mT4">
						  	<div class="modal fade" id="myModal${viagem.id}" role="dialog">
							    <div class="modal-dialog modal-lg ff">
							    
							     
							      <div class="modal-content">
							        <div class="modal-header">
							          <button type="button" class="close" data-dismiss="modal">&times;</button>
							          <h4 class="modal-title">Detalhamento da Viagem</h4>
							        </div>
							        <div class="modal-body">
							     		<table class="table table-hover">
							     			<thead>
							     				<tr>
													<th>Criador</th>
													<th>rua</th>
													<th>numero</th>
													<th>Custo com combustivel</th>
													<th>Custo com hospedagem</th>
													<th>Custo com Alimentação</th>
													<th>Descrição outros custos</th>
													<th>Outros Custos</th>
													<th>Motivo</th>
<!-- 													<th>Descrição</th> -->
												</tr>
							     			</thead>
							     			<tbody>
							     				<tr>
													<td>${viagem.usuario.login}</td>
													<td>${viagem.endereco.rua}</td>
													<td>${viagem.endereco.numero}</td>
													<td>R$ ${viagem.custo.combustivel}</td>
													<td>R$ ${viagem.custo.hospedagem}</td>
													<td>R$ ${viagem.custo.alimentacao}</td>
													<td>${viagem.custo.descOG}</td>
													<td>R$ ${viagem.custo.outrosGastos}</td>
<%-- 													<td>${viagem.motivo}</td> --%>
													<td>${viagem.motivoDesc}</td>
												</tr>
							     			</tbody>
							     		</table>		          		       
							        </div>
							        <div class="modal-footer">
							        	<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>							    							   
							        </div>
							      </div>
						   	
						    </div>
						  </div>
					  	</td>
					  </tr>
				</c:forEach>
			</tbody>
		</table>	
	
	</fieldset>
</body>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="script/script.js"></script>
</html>