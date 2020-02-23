<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="<c:url value="/privado/menuFuncionario.jsp" />">Desk Travel</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Cadastro</span></a>
	        <ul class="dropdown-menu">
				<li><a href="<c:url value="/sistema?logica=PreparaCadastroViagem" />">Cadastrar Viagem</a></li>
	        </ul>
	      </li>
	      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Viagem </span></a>
	      	<ul class="dropdown-menu">
				<li><a href='<c:url value="/sistema?logica=ConsultaViagemPendentesPropria"/>'>Viagens pendentes</a></li>
				<li><a href='<c:url value="/sistema?logica=ConsultaViagemAtiva"/>'>Viagem aprovada</a></li>
	        	<li><a href='<c:url value="/sistema?logica=ConsultaViagemProprias"/>'>Minhas viagens</a></li>
	        </ul>
	      </li>
	      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Atualizar </span></a>
	      	<ul class="dropdown-menu">
				<li><a href='<c:url value="/sistema?logica=ConsultaCustoViagemAtiva"/>'>Gastos</a></li>
	        </ul>
	      </li>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
      		<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span>  ${usuarioLogado.nome} <span class="caret"></span></a>
	      		<ul class="dropdown-menu">
	      			<li><a href='<c:url value="/sistema?logica=PreparaProprioUsuarioAltera"/>'>Alterar Dados</a></li>
					<li><a href='<c:url value="/logoff"/>'>Sair</a></li>
	        	</ul>
	      </li>
    	</ul>
	  </div>
	</nav>