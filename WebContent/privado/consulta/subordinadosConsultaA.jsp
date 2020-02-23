<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <link type="text/css" rel="stylesheet" href="<c:url value="/css/estiloSubordinadosConsulta.css" />" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Desk Travel</title>
</head>
<body>
	<%@ include file="/privado/templates/navAdm.jsp" %>
	
	<fieldset>
		<legend>Colaboradores: </legend>
		<table id="tableP" class="table table-bordered">
		<thead>
			<tr>
				<th>ID</th>
				<th>Login</th>
				<th>Nome</th>
				<th>Cod_funcionario</th>
				<th>Email</th>
				<th>Telefone</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${items}">
				<tr>
					<td>${item.id}</td>
					<td>${item.login}</td>
					<td>${item.nome}</td>
					<td>${item.cod_funcionario}</td>
					<td>${item.email}</td>
					<td>${item.telefone}</td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
	</fieldset>
</body>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="script/scriptRemoveUsuario.js"></script>
</html>