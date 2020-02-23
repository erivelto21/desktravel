<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Desk Travel</title>
</head>
<body>
	<table>
		<tr>
			<td>Id</td>
			<td>login</td>
			<td>duracao</td>
			<td>aprovacao</td>
			<td>custo</td>
			<td>nome cidade</td>
			<td>trabalho nome</td>
			<td>pendente</td>
			<td>Ação</td>
		</tr>
		<c:forEach var="viagem" items="${viagens}">
			<tr>
				<td>${viagem.id}</td>
				<td>${viagem.usuario.login}</td>
				<td>${viagem.duracao}</td>
				<td>${viagem.aprovacao}</td>
				<td>${viagem.custo.total}</td>
				<td>${viagem.endereco.cidade.nome}</td>
				<td>${viagem.trabalho.nome}</td>
				<td>${viagem.pendente}</td>
				<td>
					<form action="/dT/sistema" method="post">
						<input type="hidden" name="logica" value="RemoveViagem" /> 
						<input type="hidden" name="idV" value="${viagem.id}" />
						<input type="submit" value="Cancelar" />				
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>